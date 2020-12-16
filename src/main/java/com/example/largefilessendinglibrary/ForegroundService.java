package com.example.largefilessendinglibrary;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;


import com.example.largefilessendinglibrary.Api.Api;
import com.example.largefilessendinglibrary.Api.ProgressRequestBody;
import com.example.largefilessendinglibrary.Api.RetrofitClient;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.largefilessendinglibrary.SurveyDb.surveyDb;


public class ForegroundService extends Service implements ProgressRequestBody.UploadCallbacks{
    public static final String CHANNEL_ID = "ForegroundServiceChannel";
    public static final int ONGOING_NOTIFICATION_ID = 1;
    public static boolean hasStarted = false;
    Context context;
//    String path;
    ImageModel imageModel;
//    ArrayList<ImageModel> imageModels;
    int count;
    int PROGRESS_MAX = 100;
    int PROGRESS_CURRENT = 0;
    boolean hasSentData = false;
    HashMap<String, Integer> videos = new HashMap<String, Integer>();
    Notification notification;
    NotificationCompat.Builder builder;
    PendingIntent pendingIntent;
    NotificationManager mNotificationManager;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        createNotificationChannel();

        Bundle b = intent.getExtras();
        imageModel = (ImageModel) b.getSerializable("imageModel");
        hasStarted = true;

        startForeground(ONGOING_NOTIFICATION_ID, getMyActivityNotification());
        count = 0;
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                sendFile();
            }
        });
        return START_NOT_STICKY;
    }

    private void updateNotificationProgress(int progress) {

        builder.setProgress(100, progress, false);

//Send the notification:
        notification = builder.build();
        mNotificationManager.notify(ONGOING_NOTIFICATION_ID, notification);
    }

    private Notification getMyActivityNotification() {
        Intent notificationIntent = new Intent(this, getApplicationContext().getClass());
        pendingIntent =
                PendingIntent.getActivity(this, 0, notificationIntent, 0);

        builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        notification = builder
                        .setContentTitle("Sending Data")
                        .setContentText(imageModel.getSurveyId()+"-"+imageModel.getCheckPointId()+ " is uploading")
                        .setSmallIcon(R.drawable.logo)
                        .setContentIntent(pendingIntent)
                        .setProgress(100, 0, false)
                        .setOnlyAlertOnce(true)
                        .build();
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(ONGOING_NOTIFICATION_ID, notification);
        return  notification;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }

    public void startServiceNew(Context context, ImageModel imageModel) {
        Intent serviceIntent = new Intent(context, ForegroundService.class);
        Bundle b = new Bundle();
        b.putSerializable("imageModel", imageModel);
        serviceIntent.putExtras(b);
        this.context = context;
        ContextCompat.startForegroundService(context, serviceIntent);
    }

    public void stopService(Context context) {
        Intent serviceIntent = new Intent(context, ForegroundService.class);
        try {
            ArrayList<ImageModel> imageModels = surveyDb.getImageData();
            for (int i = 0; i < imageModels.size(); i++) {
                if (hasSentData) {
//                    ForegroundService service = new ForegroundService();
//                    service.startServiceNew(context, imageModels.get(i));
                    hasSentData = false;
                    imageModel = imageModels.get(i);
                   getMyActivityNotification();
                    sendFile();
                    break;
                }
            }
            if(imageModels.isEmpty()){
                hasStarted = false;
                stopService(serviceIntent);
            }
        }catch (Exception e){
            hasStarted = false;
            stopService(serviceIntent);
            Log.d("Error", e.getLocalizedMessage());
        }
    }

    public void sendFile(){
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/"+Constant.Survey+"/"+imageModel.getEmpid()+"/"+imageModel.getTaskId()+"/"+imageModel.getSubTaskId()+"/"+imageModel.getTimestamp()+"/"+imageModel.getCheckPointId()+".mp4";
        String path2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/"+Constant.Survey+"/"+imageModel.getEmpid()+"/"+imageModel.getTaskId()+"/"+imageModel.getSubTaskId()+"/"+imageModel.getTimestamp()+"/"+imageModel.getCheckPointId()+".jpg";
        File file = new File(path);
        File file2 = new File(path2);
        if(file.exists()){
            sendFileToServer(file);
        } else if(file2.exists())
        {
            sendFileToServer(file2);
        } else {
            surveyDb.deleteImageFile(imageModel.getTaskId(),imageModel.getSubTaskId(), imageModel.getTimestamp(), imageModel.getCheckPointId());
            hasSentData = true;
            stopService(getApplicationContext());
        }


    }

    private void sendFileToServer(File file) {
        long length = file.length();
        length = length / 1024;
        ProgressRequestBody fileBody = new ProgressRequestBody(file, "video", this);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("image", file.getName(), fileBody);
        RetrofitClient.setHost(Constant.url);
        Api apiInterface = RetrofitClient.getClient().create(Api.class);
//        final String imagedta[] = path.split("/");
        RequestBody empid =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), imageModel.getEmpid());
        RequestBody taskid =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), imageModel.getTaskId());
        RequestBody subtaskid =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), imageModel.getSubTaskId());
        RequestBody surveyid =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), imageModel.getSurveyId());
        RequestBody size =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), String.valueOf(length));
        RequestBody timestamp =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), imageModel.getTimestamp());
        RequestBody checkid = null;
        checkid =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), imageModel.getCheckPointId());
        RequestBody value =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), imageModel.getTaskId() + "-" + imageModel.getSubTaskId() + "-" + imageModel.getTimestamp() + "-" + imageModel.getCheckPointId());
        RequestBody date =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), Utils.calculateDate());

//        if (imagedta[imagedta.length - 1].contains(".jpg")) {
            surveyDb.updatecheckPointId(imageModel.getCheckPointId());
//        } else {
//            surveyDb.updatecheckPointId(imagedta[imagedta.length - 1].replace(".mp4", ""));
//        }

        Call<JsonObject> request = apiInterface.uploadImage(filePart, empid, taskid, subtaskid, surveyid, size, checkid, value, date, timestamp);
        request.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject obj = response.body();
                    assert obj != null;
                    String status = obj.get("responseCode").getAsString();
                    if (status.equals("200")) {
                        JsonObject wrappedlist = obj.get("wrappedList").getAsJsonArray().get(0).getAsJsonObject();
                        String url = wrappedlist.get("url").getAsString();
                        String timestamp1 = wrappedlist.get("timestamp").getAsString();
                        String filename = url.substring(url.lastIndexOf("_")+1);
                        final String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/"+Constant.Survey+"/"+ SharedpreferenceUtility.getInstance(context).getString(Constant.EmpId) +"/"+imageModel.getTaskId()+"/"+imageModel.getSubTaskId()+"/"+timestamp1+"/"+filename;
                        File fdelete = new File(path);
                        count++;
                        if (fdelete.exists()) {
                            if (fdelete.delete()) {
                                surveyDb.deleteImageFile(imageModel.getTaskId(), imageModel.getSubTaskId(), timestamp1, imageModel.getCheckPointId());
                            }
                        }
//                        if(count == lengthcount){
//                            count = 0;
                            hasSentData = true;
                            stopService(getApplicationContext());
//                        }
                    }

                    /* Here we can equally assume the file has been downloaded successfully because for some reasons the onFinish method might not be called, I have tested it myself and it really not consistent, but the onProgressUpdate is efficient and we can use that to update our progress on the UIThread, and we can then set our progress to 100% right here because the file already downloaded finish. */
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                /* we can also stop our progress update here, although I have not check if the onError is being called when the file could not be downloaded, so I will just use this as a backup plan just in case the onError did not get called. So I can stop the progress right here. */
                hasSentData = true;
                stopService(getApplicationContext());
            }
        });
    }


    @Override
    public void onProgressUpdate(int percentage) {
        PROGRESS_CURRENT = percentage;
        updateNotificationProgress(percentage);
        Log.d("Percentage",String.valueOf(percentage));
    }

    @Override
    public void onError() {

    }

    @Override
    public void onFinish() {

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        hasStarted = false;
    }
}
