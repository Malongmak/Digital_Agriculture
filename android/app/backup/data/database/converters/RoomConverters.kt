package com.makertest.app.data.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.makertest.app.data.models.NGOService

class RoomConverters {
    
    @TypeConverter
    fun fromStringList(value: List<String>): String {
        return Gson().toJson(value)
    }
    
    @TypeConverter
    fun toStringList(value: String): List<String> {
        return Gson().fromJson(value, object : TypeToken<List<String>>() {}.type)
    }
    
    @TypeConverter
    fun fromNGOServiceList(value: List<NGOService>): String {
        return Gson().toJson(value.map { it.name })
    }
    
    @TypeConverter
    fun toNGOServiceList(value: String): List<NGOService> {
        val stringList = Gson().fromJson(value, object : TypeToken<List<String>>() {}.type)
        return stringList.mapNotNull { name ->
            try {
                NGOService.valueOf(name)
            } catch (e: IllegalArgumentException) {
                null
            }
        }
    }
}
