package com.binar.academy.resourcemodapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by herisulistiyanto on 1/16/18.
 */

public class Manusia implements Parcelable {

    private String nama;
    private String jenisKelamin;
    private int usia;

    public Manusia(String nama, String jenisKelamin, int usia) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.usia = usia;
    }

    protected Manusia(Parcel in) {
        nama = in.readString();
        jenisKelamin = in.readString();
        usia = in.readInt();
    }

    public static final Creator<Manusia> CREATOR = new Creator<Manusia>() {
        @Override
        public Manusia createFromParcel(Parcel in) {
            return new Manusia(in);
        }

        @Override
        public Manusia[] newArray(int size) {
            return new Manusia[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public int getUsia() {
        return usia;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(jenisKelamin);
        dest.writeInt(usia);
    }
}
