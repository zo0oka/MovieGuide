package com.zo0okadev.movieguide.db;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class TypeConverters {

    @TypeConverter
     public static String integerToString(List<Integer> integers) {
         if (integers == null) {
             return (null);
         }

         Gson gson = new Gson();
         Type type = new TypeToken<List<Integer>>(){}.getType();
         return gson.toJson(integers, type);
     }

     @TypeConverter
     public static List<Integer> stringToInteger(String json) {
         if (json == null) {
             return (null);
         }

         Gson gson = new Gson();
         Type type = new TypeToken<List<Integer>>(){}.getType();
         return gson.fromJson(json, type);
     }

    @TypeConverter
    public static String toString(List<String> strings) {
        if (strings == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>(){}.getType();
        return gson.toJson(strings, type);
    }

    @TypeConverter
    public static List<String> toList(String json) {
        if (json == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>(){}.getType();
        return gson.fromJson(json, type);
    }
}
