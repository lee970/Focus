package com.pk.example;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.arch.persistence.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Converters {
    //converters for string arraylists
    @TypeConverter
    public static ArrayList<String> fromArrayListString(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    //converters for date arraylists
    @TypeConverter
    public static ArrayList<Date> fromDateArrayListString(String value) {
        Type listType = new TypeToken<ArrayList<Date>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromDateArrayList(ArrayList<Date> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    //converters for date object
    @TypeConverter
    public Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public Long dateToTimestamp(Date date) {
        if (date == null) {
            return null;
        } else {
            return date.getTime();
        }
    }

    //converters for minnotification lists
    @TypeConverter
    public static ArrayList<MinNotification> fromArrayListNotification (String value) {
        Type listType = new TypeToken<ArrayList<MinNotification>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromNotificationArrayList(ArrayList<MinNotification> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }


}