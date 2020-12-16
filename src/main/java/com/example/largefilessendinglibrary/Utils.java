package com.example.largefilessendinglibrary;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by BN on 4/26/2018.
 */

public class Utils {

    public static String getCapturePathAsset(Context ctx, String TicketNo,String subtaskId,String timestamp, String AssetID){
        try {
            String employeeID = SharedpreferenceUtility.getInstance(ctx).getString(Constant.EmpId);

            String tempDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                    + "/" +"Survey_App"+ "/"+employeeID
                    + "/" + TicketNo+ "/" + subtaskId + "/" + timestamp
                    ;
            File tempdir = new File(tempDir);
            if (!tempdir.exists())
                tempdir.mkdirs();

            return tempDir+ "/"+ AssetID +".jpg";
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(
                    ctx,
                    "Could not initiate File System.. Is Sdcard mounted properly?",
                    Toast.LENGTH_LONG).show();
            return "";
        }
    }

    public static String getCapturePathVedio(Context ctx, String TicketNo,String subtaskId,String timestamp, String AssetID){
        try {
            String employeeID = SharedpreferenceUtility.getInstance(ctx).getString(Constant.EmpId);

            String tempDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                    + "/" +"Survey_App"+ "/"+employeeID
                    + "/" + TicketNo+ "/" + subtaskId + "/" + timestamp
                    ;
            File tempdir = new File(tempDir);
            if (!tempdir.exists())
                tempdir.mkdirs();

            return tempDir+ "/"+ AssetID +".mp4";
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(
                    ctx,
                    "Could not initiate File System.. Is Sdcard mounted properly?",
                    Toast.LENGTH_LONG).show();
            return "";
        }
    }

    public static String getCapturePathAudio(Context ctx, String TicketNo,String subtaskId, String AssetID){
        try {
            String employeeID = SharedpreferenceUtility.getInstance(ctx).getString(Constant.EmpId);

            String tempDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                    + "/" +"Survey_App"+ "/"+employeeID
                    + "/" + TicketNo+ "/" + subtaskId
                    ;
            File tempdir = new File(tempDir);
            if (!tempdir.exists())
                tempdir.mkdirs();

            return tempDir+ "/"+ AssetID +".m4a";
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(
                    ctx,
                    "Could not initiate File System.. Is Sdcard mounted properly?",
                    Toast.LENGTH_LONG).show();
            return "";
        }
    }

    public static String calculateDate(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
        String datetime = dateformat.format(c.getTime());
        return datetime;
    }


    private static final DecimalFormat format = new DecimalFormat("#.##");
    private static final long GiB = 1024 * 1024 * 1024;
    private static final long MiB = 1024 * 1024;
    private static final long KiB = 1024;

    public static String getFileSize(File file) {

        if (!file.isFile()) {
            throw new IllegalArgumentException("Expected a file");
        }
        final double length = file.length();

        if (length > MiB) {
            return format.format(length / MiB) + " MB";
        }
        if (length > KiB) {
            return format.format(length / KiB) + " KB";
        }
        return format.format(length) + " B";
    }
    public static String showMemory()
    {
        String path= Environment.getDataDirectory().getPath();
        StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
        long bytesAvailable = (long)stat.getBlockSize() * (long)stat.getAvailableBlocks();
//        long megAvailable = (bytesAvailable / (1024 * 1024 * 1024));
//        String value=String.valueOf(megAvailable)+"GB";


        final double length = bytesAvailable;
        if (length > GiB) {
            return format.format(length / GiB) + " GB";
        }
        if (length > MiB) {
            return format.format(length / MiB) + " MB";
        }
        if (length > KiB) {
            return format.format(length / KiB) + " KB";
        }
        return format.format(length) + " B";
//        return value;
    }

    public static boolean isServiceRunningInForeground(Context context, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                if (service.foreground) {
                    return true;
                }

            }
        }
        return false;
    }
}
