package com.example.asus.demo2.room.management;

import android.app.Application;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;

import com.example.asus.demo2.room.daos.UserDao;
import com.example.asus.demo2.room.database.PosDatabase;
import com.example.asus.demo2.room.entities.User;

import java.util.List;

public class UserManagement {
    private UserDao mUserDao;
    private Application mApplication;

    public UserManagement(Application mApplication){
        this.mApplication = mApplication;
        PosDatabase posDatabase = PosDatabase.getDatabase(mApplication);
        mUserDao = posDatabase.getUserDao();
    }
    public List<User> getAllUserItems() {
        return mUserDao.getUserList();
    }

    public void getAllUserItemEntity(OnDataCallBackUserData listener) {
        GetAllUserItemAsync getUserAsync = new GetAllUserItemAsync(mUserDao, listener);
        getUserAsync.execute();
    }

    public void addUserItem(User userItem) {
        AddUserItemAsyn addUserItemAsyn = new AddUserItemAsyn(mUserDao);
        addUserItemAsyn.execute(userItem);
    }

    public void updateUserItem(User userItem) {
        UpdateUserItemAsyn updateUserItemAsyn = new UpdateUserItemAsyn(mUserDao);
        updateUserItemAsyn.execute(userItem);
    }

    public void deleteUserItem(User userItem) {
        DeleteUserItemAsyn deleteUserItemAsyn = new DeleteUserItemAsyn(mUserDao);
        deleteUserItemAsyn.execute(userItem);
    }

    public void deleteAllUserItems() {
        DeleteAllUserItemAsyn deleteAllUserItemAsyn = new DeleteAllUserItemAsyn(mUserDao);
        deleteAllUserItemAsyn.execute();
    }

    private class AddUserItemAsyn extends AsyncTask<User, Void, Void> {
        private UserDao mUserDao;

        public AddUserItemAsyn(UserDao mUserDao) {
            this.mUserDao = mUserDao;
        }

        @Override
        protected Void doInBackground(User... userItem) {
            mUserDao.addUser(userItem);
            return null;
        }
    }

    private class UpdateUserItemAsyn extends AsyncTask<User, Void, Void> {
        private UserDao mUserDao;

        public UpdateUserItemAsyn(UserDao mUserDao) {
            this.mUserDao = mUserDao;
        }

        @Override
        protected Void doInBackground(User... userItem) {
            mUserDao.updateUser(userItem);
            return null;
        }
    }

    private class DeleteUserItemAsyn extends AsyncTask<User, Void, Void> {
        private UserDao mUserDao;

        public DeleteUserItemAsyn(UserDao mUserDao) {
            this.mUserDao = mUserDao;
        }

        @Override
        protected Void doInBackground(User... userItem) {
            mUserDao.deleteUser(userItem);
            return null;
        }
    }

    private class DeleteAllUserItemAsyn extends AsyncTask<Void, Void, Void> {
        private UserDao mUserDao;

        public DeleteAllUserItemAsyn(UserDao mUserDao) {
            this.mUserDao = mUserDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mUserDao.deleteUser();
            return null;
        }
    }

    private class GetAllUserItemAsync extends AsyncTask<List<User>, Void, Void> {
        private UserDao mUserDao;
        private List<User> mListUserItem;
        private OnDataCallBackUserData mListener;

        public GetAllUserItemAsync(UserDao userDao, OnDataCallBackUserData listener) {
            this.mUserDao = userDao;
            this.mListener = listener;
        }

        @Override
        protected Void doInBackground(List<User>... lists) {
            try {
                mListUserItem = mUserDao.getUserList();
            } catch (SQLiteConstraintException e) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (mListUserItem != null) {
                mListener.onDataSuccess(mListUserItem);
            } else {
                mListener.onDataFail("Lấy thông tin người dùng thất bại!");
            }
        }
    }

    public interface OnDataCallBackUserData {
        void onDataSuccess(List<User> userItemEntityList);

        void onDataFail(String message);
    }

}
