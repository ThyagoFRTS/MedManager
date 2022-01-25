package com.example.medmanager.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.medmanager.db.DbRoomDatabase;
import com.example.medmanager.db.UserDao;
import com.example.medmanager.models.User;

public class UserRepository {
    private UserDao userDao;
    private User user;

    public  UserRepository (Application application){
        DbRoomDatabase dbRoomDatabase = DbRoomDatabase.getDatabase(application);
        userDao = dbRoomDatabase.userDao();

    }

    private static class InsertAsyncUser extends AsyncTask<User, Void, Void> {
        private final UserDao userDao;
        InsertAsyncUser(UserDao dao){ this.userDao = dao; }
        @Override
        protected Void doInBackground(final User... user) {
            userDao.insertUser(user[0]);
            return null;
        }
    }

    private static class UpdateAsyncUser extends AsyncTask<User, Void, Void> {
        private final UserDao userDao;
        UpdateAsyncUser(UserDao dao){ this.userDao = dao; }
        @Override
        protected Void doInBackground(final User... user) {
            userDao.updateUser(user[0]);
            return null;
        }
    }

    private static class DeleteAsyncUser extends AsyncTask<User, Void, Void> {
        private final UserDao userDao;
        DeleteAsyncUser(UserDao dao){ this.userDao = dao; }
        @Override
        protected Void doInBackground(final User... user) {
            userDao.deleteUser(user[0]);
            return null;
        }
    }

    private static class GetAsyncUserById extends AsyncTask<String, Void, Void> {
        private final UserDao userDao;
        GetAsyncUserById(UserDao dao){ this.userDao = dao; }
        @Override
        protected Void doInBackground(final String... uid) {
            userDao.getUserById(uid[0]);
            return null;
        }
    }

    public void insert(User user){
        new InsertAsyncUser(userDao).execute(user);
    }

    public void update(User user){
        new UpdateAsyncUser(userDao).execute(user);
    }

    public void delete(User user){
        new DeleteAsyncUser(userDao).execute(user);
    }

    public void getItemById(String uid){
        new GetAsyncUserById(userDao).execute(uid);
    }


}
