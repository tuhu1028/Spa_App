package com.example.asus.demo2.room.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.asus.demo2.room.entities.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void addUser(User... users);

    @Update
    void updateUser(User...users);

    @Delete
    void deleteUser(User...user);

    @Query("SELECT * FROM Users")
    public List<User> getUserList();

    @Query("SELECT * FROM Users WHERE username = :username")
    public User getUser(String username);



}
