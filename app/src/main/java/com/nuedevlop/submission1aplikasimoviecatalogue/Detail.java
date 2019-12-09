package com.nuedevlop.submission1aplikasimoviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Detail implements Parcelable {
    private String judul,keterangan,tanggal,budget,durasi;
    private int Poster;

    public Detail() {

    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public int getPoster() {
        return Poster;
    }

    public void setPoster(int poster) {
        Poster = poster;
    }

    protected Detail(Parcel in) {
        judul = in.readString();
        keterangan = in.readString();
        tanggal = in.readString();
        budget = in.readString();
        durasi = in.readString();
        Poster = in.readInt();
    }

    public static final Creator<Detail> CREATOR = new Creator<Detail>() {
        @Override
        public Detail createFromParcel(Parcel in) {
            return new Detail(in);
        }

        @Override
        public Detail[] newArray(int size) {
            return new Detail[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(keterangan);
        dest.writeString(tanggal);
        dest.writeString(budget);
        dest.writeString(durasi);
        dest.writeInt(Poster);
    }
}
