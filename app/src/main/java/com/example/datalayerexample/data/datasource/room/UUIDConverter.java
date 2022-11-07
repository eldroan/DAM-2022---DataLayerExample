package com.example.datalayerexample.data.datasource.room;

import androidx.room.TypeConverter;
import java.util.UUID;

public class UUIDConverter {
    @TypeConverter
    public static String fromUUID(UUID uuid) {
        return uuid.toString();
    }

    @TypeConverter
    public static UUID uuidFromString(String string) {
        return UUID.fromString(string);
    }
}
