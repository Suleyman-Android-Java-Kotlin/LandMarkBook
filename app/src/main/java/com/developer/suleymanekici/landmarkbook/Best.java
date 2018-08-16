package com.developer.suleymanekici.landmarkbook;

import android.graphics.Bitmap;

public class Best {
    private  static  Best instance;

    private Bitmap resimsec;

    private Best() {

    }

    public void  setData(Bitmap resimsec) {
        this.resimsec = resimsec;
    }

    public  Bitmap getData() {
        return this.resimsec;
    }

    public  static  Best getInstance() {
        if (instance == null) {
            instance = new Best();
        }
        return  instance;
    }
}
