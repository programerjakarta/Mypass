package com.example.gajahterbang.mypass;

/**
 * Created by gajahterbang on 1/27/2016.
 */
public class Password {
    private int _id;
    private String _ip;

    public Password(){

    }

    public Password(int id,String ip){
        this._id = id;
        this._ip = ip;
    }
    public void setID(int id) {
        this._id = id;
    }

    public int getID() {
        return this._id;
    }

    public void setIP(String ip) {
        this._ip = ip;
    }

    public String getIP() {
        return this._ip;
    }



}
