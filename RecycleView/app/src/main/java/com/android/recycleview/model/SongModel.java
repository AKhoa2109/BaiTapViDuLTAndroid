package com.android.recycleview.model;

public class SongModel {
    private String mCode;
    private String mTitle;
    private String myLyric;
    private String myArtist;

    public SongModel(String mCode, String mTitle, String myLyric, String myArtist) {
        this.mCode = mCode;
        this.mTitle = mTitle;
        this.myLyric = myLyric;
        this.myArtist = myArtist;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getMyLyric() {
        return myLyric;
    }

    public void setMyLyric(String myLyric) {
        this.myLyric = myLyric;
    }

    public String getMyArtist() {
        return myArtist;
    }

    public void setMyArtist(String myArtist) {
        this.myArtist = myArtist;
    }
}
