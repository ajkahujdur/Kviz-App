package com.example.user.kvizzastave;

public class Pitanje {
    private int mIndex;
    private String mTacan_odgovor;
    int mDetalji;

    public Pitanje(int index, String tacan_odgovor,int detalji) {
        mIndex = index;
        mTacan_odgovor = tacan_odgovor;
        mDetalji = detalji;
    }

    public int getIndex() {
        return mIndex;
    }

    public void setIndex(int index) {
        mIndex = index;
    }

    public String getTacan_odgovor() {
        return mTacan_odgovor;
    }

    public void setTacan_odgovor(String tacan_odgovor) {
        mTacan_odgovor = tacan_odgovor;
    }

    public int getDetalji() {
        return mDetalji;
    }

    public void setDetalji(int detalji) {
        mDetalji = detalji;
    }
}


