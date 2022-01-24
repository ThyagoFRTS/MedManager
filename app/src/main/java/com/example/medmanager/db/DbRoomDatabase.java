package com.example.medmanager.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.medmanager.models.Medicine;
import com.example.medmanager.models.User;
import com.example.medmanager.staticData.Data;

@Database(entities = {Medicine.class, User.class}, version = 1, exportSchema = false)
public  abstract class DbRoomDatabase extends RoomDatabase {
    public abstract MedicineDao medicineDao();
    public abstract UserDao userDao();


    private static final RoomDatabase.Callback databaseCallBack = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            //new PopulateAsyncDb(INSTANCE).execute();
        }
    };

    private static DbRoomDatabase INSTANCE;

    public static DbRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (DbRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            DbRoomDatabase.class,
                            "db_medicine_manager")
                            .fallbackToDestructiveMigration()
                            .addCallback(databaseCallBack)
                            .build();
                }
            }
        }
        return  INSTANCE;
    }

    private static class PopulateAsyncDb extends AsyncTask<Void, Void, Void>{
        private final MedicineDao _medicineDao;
        private final UserDao _userDao;

        PopulateAsyncDb (DbRoomDatabase dbRoomDatabase){
            _medicineDao = dbRoomDatabase.medicineDao();
            _userDao = dbRoomDatabase.userDao();
        }

        @Override
        protected Void doInBackground(final Void... params ){
            _medicineDao.deleteAllMedicines();
            for (Medicine med: Data.getMedicines()) {
                _medicineDao.insertMedicine(med);
            }
            _userDao.deleteAllUsers();
            for (User user: Data.getUsers()) {
                _userDao.insertUser(user);
            }
            return null;
        }

    }
}
