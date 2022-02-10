package com.example.medmanager.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.medmanager.db.DbRoomDatabase;
import com.example.medmanager.db.MedicineDao;
import com.example.medmanager.db.UserDao;
import com.example.medmanager.models.Medicine;
import com.example.medmanager.models.User;

import java.util.List;

public class UserRepository {
    private UserDao userDao;
    private MedicineDao medicineDao;
    private LiveData<User> userByEmail;
    private final LiveData<List<User>> allUsers;
    private final LiveData<List<Medicine>> allMedicines;

    public  UserRepository (Application application){
        DbRoomDatabase dbRoomDatabase = DbRoomDatabase.getDatabase(application);
        userDao = dbRoomDatabase.userDao();
        medicineDao = dbRoomDatabase.medicineDao();
        allUsers = dbRoomDatabase.userDao().allUsers();
        allMedicines = dbRoomDatabase.medicineDao().getAllMedicines();

    }

    public LiveData<List<Medicine>> getAllMedicines() {
        return  allMedicines;
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

    /*
    private static class GetAsyncUserById extends AsyncTask<String, Void, User> {
        private final UserDao userDao;
        GetAsyncUserById(UserDao dao){ this.userDao = dao; }
        @Override
        protected User doInBackground(final String... uid) {
            //userDao.getUserById(uid[0]);
            return userDao.getUserById(uid[0]);
        }
    }

    private static class GetAsyncUserByEmail extends AsyncTask<String, Void, Void> {
        private final UserDao userDao;
        GetAsyncUserByEmail(UserDao dao){ this.userDao = dao; }
        @Override
        protected Void doInBackground(final String... uemail) {
            userDao.getUserByEmail(uemail[0]);
            return null;
        }
    }

     */

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
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

    public User getUserById(int uid){
        return userDao.getUserById(uid);
    }

    public User getUserByEmail(String email, String pass){
        return userDao.getUserByEmail(email, pass);
    }


}
