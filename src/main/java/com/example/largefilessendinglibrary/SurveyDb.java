package com.example.largefilessendinglibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by BN on 4/23/2018.
 */

public class SurveyDb extends SQLiteOpenHelper {
    public static  SurveyDb surveyDb=null;
    private static final int DATABASE_VERSION=3;

    private static final String DATABASE_Name="SurveyDB2";

    private static final String AutoId="AutoId";
    //Table
    private static final String UserDetail="UserDetail";
    private static final String TaskList="TaskList";
    private static final String SampleTable="SampleTable";
    private static final String CategoryList="CategoryList";
    private static final String CategoryOneList="CategoryOneList";
    private static final String CategoryTwoList="CategoryTwoList";
    private static final String SaveCheckListData="SaveCheckListData";
    private static final String ImageData="ImageData";
    private static final String AudioData="AudioData";
    private static final String SuveyCount="SuveyCount";


    private static final String StartData="StartEnd";
    private static final String EndData="EndData";


    //Field Login
    private static final String EmpName="EmpName";
    private static final String EmpId="EmpId";
    private static final String Password="Password";
    private static final String isActive="isActive";


    //Field TaskList
    private static final String CheckListId="CheckListId";
    private static final String TaskId="TaskId";
    private static final String fromDates="fromDates";
    private static final String toDates="toDates";
    private static final String taskStatus="taskStatus";
    private static final String checkListName="checkListName";
    private static final String retry="retry";

    //Field SampleTable
    private static final String category="category";
    private static final String value="value";
    private static final String subCategory="subCategory";
    private static final String remainingCount="remainingCount";
    private static final String totalCount="totalCount";
    private static final String checkPointId="checkPointId";

    //Field CategoryList
    private static final String typeId="typeId";
    private static final String LangId="LangId";
    private static final String mandatoy="mandatoy";
    private static final String viewType="viewType";
    private static final String size="size";
    private static final String checkPointName="checkPointName";
    private static final String mainCategoryId="mainCategoryId";
    private static final String OneCategoryId="OneCategoryId";
    private static final String CategoryListviewType="CategoryListviewType";
    private static final String catId="catId";
    private static final String subSubCategory="subSubCategory";
    private static final String subCheckPointId="subCheckPointId";
    private static final String subSubCheckPointId="subSubCheckPointId";
    private static final String isDependent="isDependent";
    private static final String dependentAnswer="dependentAnswer";
    private static final String dependentQuestion="dependentQuestion";
    private static final String openQuestion="openQuestion";
    private static final String icon1="icon1";
    private static final String icon2="icon2";
    private static final String icon3="icon3";
    private static final String timestamp = "timestamp";

    private static final String mainId="mainId";
    private static final String SubId="SubId";
    //
    private static final String subCheckListAns="subCheckListAns";
    private static final String subSubCheckListAns="subSubCheckListAns";
    private static final String CheckListAns="CheckListAns";
    private static final String TaskId_New="TaskId_New";
    private static final String UploadStatus="UploadStatus";
    private static final String Task_Count="Task_Count";
    private static final String DateTime="DateTime";
    private static final String otherAns="otherAns";
    private static final String subotherAns="subotherAns";
    private static final String subSubotherAns="subSubotherAns";
    //
    private static final String image="image";
    private static final String startTime="startTime";
    private static final String banner="banner";
    private static final String recording="recording";

    private static final String Status="EndTime";
    private static final String Latitude="Latitude";
    private static final String Longitude="Longitude";
    private static final String GpsStatus="GpsStatus";
    private static final String questionCode="questionCode";
    private static final String surveyId="surveyId";
    private static final String count="count";

    private static final String duration="duration";

    private static final String DeviceDateTime="DeviceDateTime";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + UserDetail + " ( " +
                AutoId + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                EmpId + " TEXT , " +
                EmpName + " TEXT , " +
                isActive + " TEXT , " +
                Password + " TEXT );"
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TaskList + " ( " +
                AutoId + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                EmpId + " TEXT , " +
                CheckListId + " TEXT , " +
                TaskId + " TEXT , " +
                fromDates + " TEXT , " +
                toDates + " TEXT , " +
                checkListName + " TEXT , " +
                taskStatus + " TEXT );"
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS " + SampleTable + " ( " +
                AutoId + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                EmpId + " TEXT , " +
                subCategory + " TEXT , " +
                TaskId + " TEXT , " +
                category + " TEXT , " +
                checkPointId + " TEXT , " +
                totalCount + " TEXT , " +
                remainingCount + " TEXT , " +
                value + " TEXT );"
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS " + CategoryList + " ( " +
                AutoId + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                typeId + " TEXT , " +
                LangId + " TEXT , " +
                CheckListId + " TEXT , " +
                checkPointName + " TEXT , " +
                checkListName + " TEXT , " +
                mandatoy + " TEXT , " +
                checkPointId + " TEXT , " +
                viewType + " TEXT , " +
                category + " TEXT , " +
                catId + " TEXT , " +
                subCategory + " TEXT , " +
                subSubCategory + " TEXT , " +
                subCheckPointId + " TEXT , " +
                dependentQuestion + " TEXT , " +
                isDependent + " TEXT , " +
                dependentAnswer + " TEXT , " +
                openQuestion + " TEXT , " +
                banner + " TEXT , " +
                recording + " TEXT , " +
                questionCode + " TEXT , " +
                CategoryListviewType+ " TEXT , " +
                value + " TEXT , " +
                size + " TEXT , " +
                icon1+ " TEXT , " +
                icon2 + " TEXT , " +
                icon3 + " TEXT , " +
                EmpId + " TEXT );"
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS " + CategoryOneList + " ( " +
                AutoId + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                typeId + " TEXT , " +
                LangId + " TEXT , " +
                checkListName + " TEXT , " +
                category + " TEXT , " +
                catId + " TEXT , " +
                CategoryListviewType+ " TEXT , " +
                mandatoy + " TEXT , " +
                CheckListId + " TEXT , " +
                checkPointId + " TEXT , " +
                checkPointName + " TEXT , " +
                mainCategoryId+ " TEXT , " +
                subCategory + " TEXT , " +
                subSubCategory + " TEXT , " +
                subCheckPointId + " TEXT , " +
                dependentQuestion + " TEXT , " +
                isDependent + " TEXT , " +
                dependentAnswer + " TEXT , " +
                openQuestion + " TEXT , " +
                viewType + " TEXT , " +
                value + " TEXT , " +
                size + " TEXT , " +
                EmpId + " TEXT );"
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS " + CategoryTwoList + " ( " +
                AutoId + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                typeId + " TEXT , " +
                LangId + " TEXT , " +
                checkListName + " TEXT , " +
                category + " TEXT , " +
                catId + " TEXT , " +
                CategoryListviewType+ " TEXT , " +
                CheckListId + " TEXT , " +
                checkPointName + " TEXT , " +
                mandatoy + " TEXT , " +
                mainCategoryId + " TEXT , " +
                checkPointId + " TEXT , " +
                SubId + " TEXT , " +
                OneCategoryId+ " TEXT , " +
                subCategory + " TEXT , " +
                subSubCategory + " TEXT , " +
                subCheckPointId + " TEXT , " +
                dependentQuestion + " TEXT , " +
                isDependent + " TEXT , " +
                dependentAnswer + " TEXT , " +
                openQuestion + " TEXT , " +
                viewType + " TEXT , " +
                value + " TEXT , " +
                size + " TEXT , " +
                EmpId + " TEXT );"
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS " + SaveCheckListData + " ( " +
                AutoId + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                EmpId + " TEXT , " +
                CheckListId + " TEXT , " +
                catId + " TEXT , " +
                TaskId + " TEXT , " +
                Task_Count + " TEXT , " +
                TaskId_New + " TEXT , " +
                UploadStatus + " TEXT , " +
                checkPointId + " TEXT , " +
                subCheckListAns + " TEXT , " +
                subSubCheckListAns + " TEXT , " +
                subCheckPointId + " TEXT , " +
                subSubCheckPointId + " TEXT , " +
                typeId + " TEXT , " +
                otherAns + " TEXT , " +
                startTime + " TEXT , " +
                subotherAns + " TEXT , " +
                subSubotherAns + " TEXT , " +
                DeviceDateTime + " TEXT , " +
                DateTime + " TEXT , " +
                timestamp + " TEXT , " +
                CheckListAns + " TEXT );"
        );
        db.execSQL("CREATE TABLE IF NOT EXISTS " + ImageData + " ( " +
                AutoId + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                EmpId + " TEXT , " +
                TaskId_New + " TEXT , " +
                TaskId + " TEXT , " +
                UploadStatus + " TEXT , " +
                surveyId + " TEXT , " +
                timestamp + " TEXT , " +
                checkPointId + " TEXT, " +
                retry + " INT, " +
                image + " TEXT );"
        );
        db.execSQL("CREATE TABLE IF NOT EXISTS " + AudioData + " ( " +
                AutoId + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                EmpId + " TEXT , " +
                TaskId_New + " TEXT , " +
                TaskId + " TEXT , " +
                UploadStatus + " TEXT , " +
                surveyId + " TEXT , " +
                image + " TEXT );"
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS " + StartData + " ( " +
                AutoId + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                EmpId + " TEXT , " +
                Latitude + " TEXT , " +
                GpsStatus + " TEXT , " +
                Longitude + " TEXT , " +
                TaskId + " TEXT , " +
                Status + " TEXT , " +
                DeviceDateTime + " TEXT , " +
                duration + " TEXT , " +
                startTime + " TEXT );"
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS " + SuveyCount + " ( " +
                AutoId + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                EmpId + " TEXT , " +
                surveyId + " TEXT , " +
                count + " TEXT );"
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        switch(oldVersion) {
            case 1:
                sqLiteDatabase.execSQL("ALTER TABLE "+CategoryList + " ADD COLUMN " + icon1 +" TEXT;");
                sqLiteDatabase.execSQL("ALTER TABLE "+CategoryList + " ADD COLUMN " + icon2 +" TEXT;");
                sqLiteDatabase.execSQL("ALTER TABLE "+CategoryList + " ADD COLUMN " + icon3 +" TEXT;");
            case 2:
                sqLiteDatabase.execSQL("ALTER TABLE "+SaveCheckListData + " ADD COLUMN " + timestamp +" TEXT;");
                sqLiteDatabase.execSQL("ALTER TABLE "+ImageData + " ADD COLUMN " + timestamp +" TEXT;");
                sqLiteDatabase.execSQL("ALTER TABLE "+ImageData + " ADD COLUMN " + checkPointId +" TEXT;");
                sqLiteDatabase.execSQL("ALTER TABLE "+ImageData + " ADD COLUMN " + retry +" INT;");

        }
    }

    public SurveyDb(Context context) {
        super(context, DATABASE_Name, null, DATABASE_VERSION);
    }


    public static synchronized SurveyDb getInstance(Context context){
        if(surveyDb==null){
            surveyDb=new SurveyDb(context.getApplicationContext());
        }
        return surveyDb;
    }

    //insert Login Data


    public void insertImageData(ImageModel content, SurveyDb db){
        SQLiteDatabase db1=db.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(EmpId,content.getEmpid());
        values.put(TaskId,content.getTaskId());
        values.put(TaskId_New,content.getSubTaskId());
        values.put(UploadStatus,content.getUpload());
        values.put(surveyId,content.getSurveyId());
        values.put(timestamp,content.getTimestamp());
        values.put(checkPointId,content.getCheckPointId());
        values.put(retry,content.getRetry());
        db1.insert(ImageData,null,values);
    }

    public void insertAudioData(ImageModel content, SurveyDb db){
        SQLiteDatabase db1=db.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(EmpId,content.getEmpid());
        values.put(TaskId,content.getTaskId());
        values.put(TaskId_New,content.getSubTaskId());
        values.put(UploadStatus,content.getUpload());
        values.put(surveyId,content.getSurveyId());
        db1.insert(AudioData,null,values);
    }


    public int deleteUserDetail(String Uid){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(UserDetail, EmpId +" = "+ "\"" + Uid+ "\"" ,null);
    }

    public int deleteTaskList(String Uid){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TaskList, EmpId +" = "+ "\"" + Uid+ "\"" ,null);
    }

    public int deleteSampleList(String Uid){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(SampleTable, EmpId +" = "+ "\"" + Uid+ "\"" ,null);
    }

    public int deleteCategoryList(String Uid){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(CategoryList, EmpId +" = "+ "\"" + Uid+ "\"" ,null);
    }


    public void deleteCachedData(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("SaveCheckListData", "UploadStatus"+" = 0" , null);
    }

    public int deleteCategoryOneList(String Uid){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(CategoryOneList, EmpId +" = "+ "\"" + Uid+ "\"" ,null);
    }

    public int deleteCategoryTwoList(String Uid){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(CategoryTwoList, EmpId +" = "+ "\"" + Uid+ "\"" ,null);
    }
    public int deleteCategoryListbyCatID(String Uid,String chkId){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(CategoryList, EmpId +" = "+ "\"" + Uid+ "\""+" AND "+ CheckListId+" = "+ "\"" + chkId+ "\"" ,null);
    }

    public int deleteCategoryOneListbyCatID(String Uid,String chkId){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(CategoryOneList, EmpId +" = "+ "\"" + Uid+ "\""+" AND "+ CheckListId+" = "+ "\"" + chkId+ "\"" ,null);
    }

    public int deleteCategoryTwoListbyCatID(String Uid,String chkId){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(CategoryTwoList, EmpId +" = "+ "\"" + Uid+ "\"" +" AND "+ CheckListId+" = "+ "\"" + chkId+ "\"",null);
    }

    public int deleteTaskData(String Uid){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(SaveCheckListData, TaskId_New+" = "+ "\"" + Uid+ "\"" ,null);
    }

    public int deleteImageDirectory(String Uid,String NewTask, String newtimestamp){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(ImageData, TaskId+" = "+ "\"" + Uid+ "\""+" AND "+ TaskId_New+" = "+ "\"" + NewTask+ "\""+" AND "+ timestamp+" = "+ "\"" + newtimestamp+ "\"" ,null);
    }

    public int deleteImageFile(String Uid,String NewTask, String newtimestamp, String checkPoint){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(ImageData, TaskId+" = "+ "\"" + Uid+ "\""+" AND "+ TaskId_New+" = "+ "\"" + NewTask+ "\""+" AND "+ timestamp+" = "+ "\"" + newtimestamp+ "\"" +" AND "+ checkPointId+" = "+ "\"" + checkPoint+ "\"" ,null);
    }

    public int deleteAudio(String Uid,String NewTask){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(AudioData, TaskId+" = "+ "\"" + Uid+ "\""+" AND "+ TaskId_New+" = "+ "\"" + NewTask+ "\"" ,null);
    }
    public int deleteStartEnd(String Uid,String NewTask){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(StartData, EmpId+" = "+ "\"" + Uid+ "\""+" AND "+ TaskId+" = "+ "\"" + NewTask+ "\"" ,null);
    }


    public ArrayList<ImageModel> getImageData() {
        ArrayList<ImageModel> contentList = new ArrayList<ImageModel>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + ImageData +" ORDER BY "+retry+ " ASC";;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                ImageModel content = new ImageModel();
                content.setEmpid(cursor.getString(cursor.getColumnIndex(EmpId)));
                content.setTaskId(cursor.getString(cursor.getColumnIndex(TaskId)));
                content.setSubTaskId(cursor.getString(cursor.getColumnIndex(TaskId_New)));
                content.setUpload(cursor.getString(cursor.getColumnIndex(UploadStatus)));
                content.setSurveyId(cursor.getString(cursor.getColumnIndex(surveyId)));
                content.setTimestamp(cursor.getString(cursor.getColumnIndex(timestamp)));
                content.setCheckPointId(cursor.getString(cursor.getColumnIndex(checkPointId)));
                content.setRetry(cursor.getInt(cursor.getColumnIndex(retry)));
                // Adding contact to list
                contentList.add(content);
            } while (cursor.moveToNext());
        }

        cursor.close();

        // return contact list
        return contentList;
    }

    public ArrayList<ImageModel> getAudioData() {
        ArrayList<ImageModel> contentList = new ArrayList<ImageModel>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + AudioData ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                ImageModel content = new ImageModel();
                content.setEmpid(cursor.getString(cursor.getColumnIndex(EmpId)));
                content.setTaskId(cursor.getString(cursor.getColumnIndex(TaskId)));
                content.setSubTaskId(cursor.getString(cursor.getColumnIndex(TaskId_New)));
                content.setUpload(cursor.getString(cursor.getColumnIndex(UploadStatus)));
                content.setSurveyId(cursor.getString(cursor.getColumnIndex(surveyId)));

                // Adding contact to list
                contentList.add(content);
            } while (cursor.moveToNext());
        }

        cursor.close();

        // return contact list
        return contentList;
    }




    public void updatecheckPointId(String chekptId){
        SQLiteDatabase db1 = this.getWritableDatabase();
        try {
            String selectQuery = "UPDATE " + ImageData +" SET "+retry+ "="+ retry+"+1 WHERE " + checkPointId +"="+chekptId;
            db1.execSQL(selectQuery);

        } catch (NullPointerException e) {
            e.getStackTrace();
        }
    }

}
