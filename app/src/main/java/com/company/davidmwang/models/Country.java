package com.company.davidmwang.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "country_table")
public class Country {

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @ColumnInfo(name="id")
    public Integer id;


    @SerializedName("name")
    @ColumnInfo(name = "name")
    public String name;


    @SerializedName("code")
    @ColumnInfo(name = "code")
    public String code;


    @SerializedName("created_at")
    @ColumnInfo(name="created_at")
    public String createdAt;


    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    public String updatedAt;


    @SerializedName("country_code")
    @ColumnInfo(name = "country_code")
    public String countryCode;

}
