package com.binar.academy.resourcemodapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by herisulistiyanto on 11/1/17.
 */

public class Student implements Parcelable {

    private final String nama;
    private final String kelas;

    public Student(String nama, String kelas) {
        this.nama = nama;
        this.kelas = kelas;
    }

    protected Student(Parcel in) {
        nama = in.readString();
        kelas = in.readString();
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(kelas);
    }
}
