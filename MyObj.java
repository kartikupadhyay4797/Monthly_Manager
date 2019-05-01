package com.example.tinpattiofflineaccountant;

import java.util.Date;

class MyObj {
    private int showExp=0,status=0;
    private String showDetail,date,user,getUser,doneDate,statusString="";

    public MyObj(int expend, String det,String date,String user) {
        this.showExp=expend;
        this.showDetail=det;
        this.date= date;
        this.user=user;
    }

    public MyObj(int expend, String det,String date,String user,String getUser,String doneDate) {
        this.showExp=expend;
        this.showDetail=det;
        this.date= date;
        this.user=user;
        this.getUser=getUser;
        this.doneDate=doneDate;
    }
    public MyObj(String statusString, String det,String date,String user) {
        this.statusString=statusString;
        this.showDetail=det;
        this.date= date;
        this.user=user;
    }

    public String getStatusString() {
        return statusString;
    }

    public String getDoneDate() {
        return doneDate;
    }

    public String getGetUser(){
        return getUser;
    }

    public String getUser(){return user;}

    public String getDate() {
        return date;
    }

    public int getShowExp() { return showExp; }

    public String getShowDetail() {
        return showDetail;
    }

}
