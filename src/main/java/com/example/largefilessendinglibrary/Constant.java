package com.example.largefilessendinglibrary;

/**
 * Created by BN on 4/23/2018.
 */

public class Constant {
//    public static String url="http://www.pnndsrvctvt.com:8080/AxisMyIndia/ami/";
  public static String url="http://www.in3.co.in:8080/AxisMyIndia/ami/";
    public static Integer ApiCallCount=0;
    public static final String WebService_Request_Type="WebService_Request_Type";

    //
    public static final String Login="login";
    public static final String AssignedData="getAssignedSurvey";
    public static final String getCheckList="getCheckList";
    public static final String saveSurvey=url+"saveSurvey";  //saving data
    public static final String SurveyDoc="FsrDoc";
    public static final String Survey="Survey_App";
    public static final String saveAmiImage="saveAmiImage";  //saving image and video
    public static final String saveStartEnd="saveStartEnd";
    public static final String sendNotification="sendNotification";
    public static final String saveDevice="saveDevice";
    public static final String saveAmiAudio=url+"saveAmiAudio";
    public static final String getDependentCheckList="getDependentCheckList";


    //
    public static final int TaskList=1;
    public static final int CheckListData=2;
    public static final int SendData=3;
    public static final int SendImage=4;
    public static final int OnlyTask=5;
    public static final int SendAudio=6;

    //SharedPrefrence
    public static final String EmpId="EmpId";
    public static final String CheckListId="CheckListId";
    public static final String TaskId="TaskId";
    public static final String LogInState="LogInState";
    public static final String Mandatory="1";
    public static final String LoginCheck="LoginCheck";
    public static final String LocationType="LocationType";
    public static final int autosave=60*1000;
    public static final String Version="Version";
    public static final String ShrtCodeNum="ShrtCodeNum";


    //Inputtype
    public static final String Text="1";
    public static final String longText="2";
    public static final String number="3";
    public static final String radio="4";
    public static final String checkBox="5";
    public static final String img="6";
    public static final String camera="7";
    public static final String sign="8";
    public static final String date="9";
    public static final String time="10";
    public static final String timeStamp="11";
    public static final String rating="12";
    public static final String seekBar_vertical="13";
    public static final String seekBar_horizontal="14";
    public static final String dropDown="15";
    public static final String FingerPrint="16";
  public static final String Vedio="17";
    public static final String Type0="0";


    public static final String TOPIC_GLOBAL = "global";

    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";
    public static String NOTIFICATION = "NOTIFICATION";
    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;

    public static final String SHARED_PREF = "ah_firebase";


    public static final String Username="Username";
    public static final String UserPassword="UserPassword";
    public static final String Checkbox="Checkbox";

}
