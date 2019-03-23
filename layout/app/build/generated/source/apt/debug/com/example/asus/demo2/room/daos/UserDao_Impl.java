package com.example.asus.demo2.room.daos;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import com.example.asus.demo2.room.entities.User;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUser;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Users`(`id`,`username`,`password`,`phone`,`fullname`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
        if (value.getUsername() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUsername());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassword());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPhone());
        }
        if (value.getFullname() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFullname());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Users` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Users` SET `id` = ?,`username` = ?,`password` = ?,`phone` = ?,`fullname` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
        if (value.getUsername() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUsername());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassword());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPhone());
        }
        if (value.getFullname() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFullname());
        }
        stmt.bindLong(6, value.getId());
      }
    };
  }

  @Override
  public void addUser(User... users) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteUser(User... user) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handleMultiple(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUser(User... users) {
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handleMultiple(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<User> getUserList() {
    final String _sql = "SELECT * FROM Users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfUsername = _cursor.getColumnIndexOrThrow("username");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("password");
      final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("phone");
      final int _cursorIndexOfFullname = _cursor.getColumnIndexOrThrow("fullname");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        _item = new User();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _item.setUsername(_tmpUsername);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _item.setPassword(_tmpPassword);
        final String _tmpPhone;
        _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        _item.setPhone(_tmpPhone);
        final String _tmpFullname;
        _tmpFullname = _cursor.getString(_cursorIndexOfFullname);
        _item.setFullname(_tmpFullname);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User getUser(String username) {
    final String _sql = "SELECT * FROM Users WHERE username = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfUsername = _cursor.getColumnIndexOrThrow("username");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("password");
      final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("phone");
      final int _cursorIndexOfFullname = _cursor.getColumnIndexOrThrow("fullname");
      final User _result;
      if(_cursor.moveToFirst()) {
        _result = new User();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _result.setUsername(_tmpUsername);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _result.setPassword(_tmpPassword);
        final String _tmpPhone;
        _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        _result.setPhone(_tmpPhone);
        final String _tmpFullname;
        _tmpFullname = _cursor.getString(_cursorIndexOfFullname);
        _result.setFullname(_tmpFullname);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
