package com.example.largefilessendinglibrary;

import java.io.Serializable;

/**
 * Created by BN on 5/5/2018.
 */

public class ImageModel implements Serializable {
    String empid;
    String TaskId;
    String SubTaskId;
    String Upload;
    String SurveyId;
    String timestamp;
    String checkPointId;
    int retry;

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }

    public String getCheckPointId() {
        return checkPointId;
    }

    public void setCheckPointId(String checkPointId) {
        this.checkPointId = checkPointId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSurveyId() {
        return SurveyId;
    }

    public void setSurveyId(String surveyId) {
        SurveyId = surveyId;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getTaskId() {
        return TaskId;
    }

    public void setTaskId(String taskId) {
        TaskId = taskId;
    }

    public String getSubTaskId() {
        return SubTaskId;
    }

    public void setSubTaskId(String subTaskId) {
        SubTaskId = subTaskId;
    }

    public String getUpload() {
        return Upload;
    }

    public void setUpload(String upload) {
        Upload = upload;
    }
}
