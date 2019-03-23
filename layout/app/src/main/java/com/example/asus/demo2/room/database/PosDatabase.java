package com.example.asus.demo2.room.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.asus.demo2.room.daos.UserDao;
import com.example.asus.demo2.room.entities.User;

import static com.example.asus.demo2.room.database.PosDatabase.DATABASE_VERSION;


@Database(entities = {User.class}, exportSchema = false, version = DATABASE_VERSION)
public abstract class PosDatabase extends RoomDatabase {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "pos-database";
    private static PosDatabase INSTANCE;
    public abstract UserDao getUserDao();
    public static PosDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PosDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PosDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
