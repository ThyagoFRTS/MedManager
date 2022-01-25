package com.example.medmanager.repository;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.example.medmanager.db.DbRoomDatabase;
import com.example.medmanager.db.MedicineDao;
import com.example.medmanager.models.Medicine;
import java.util.List;



public class MedicineRepository {
    private final MedicineDao medicineDao;
    private final LiveData<List<Medicine>> allMedicines;

    public  MedicineRepository (Application application){
        DbRoomDatabase dbRoomDatabase = DbRoomDatabase.getDatabase(application);
        medicineDao = dbRoomDatabase.medicineDao();
        allMedicines = medicineDao.getAllMedicines();
    }

    private static class InsertAsyncMedicine extends AsyncTask<Medicine, Void, Void> {
        private final MedicineDao medicineDao;
        InsertAsyncMedicine(MedicineDao dao){ this.medicineDao = dao; }
        @Override
        protected Void doInBackground(final Medicine... medicine) {
            medicineDao.insertMedicine(medicine[0]);
            return null;
        }
    }

    private static class UpdateAsyncMedicine extends AsyncTask<Medicine, Void, Void> {
        private final MedicineDao medicineDao;
        UpdateAsyncMedicine(MedicineDao dao){ this.medicineDao = dao; }
        @Override
        protected Void doInBackground(final Medicine... medicine) {
            medicineDao.updateMedicine(medicine[0]);
            return null;
        }
    }

    private static class DeleteAsyncMedicine extends AsyncTask<Medicine, Void, Void> {
        private final MedicineDao medicineDao;
        DeleteAsyncMedicine(MedicineDao dao){ this.medicineDao = dao; }
        @Override
        protected Void doInBackground(final Medicine... medicine) {
            medicineDao.deleteMedicine(medicine[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncMedicine extends AsyncTask<Void, Void, Void> {
        private final MedicineDao medicineDao;
        DeleteAllAsyncMedicine(MedicineDao dao){ this.medicineDao = dao; }
        @Override
        protected Void doInBackground(Void... voids) {
            medicineDao.deleteAllMedicines();
            return null;
        }
    }

    public void insert(Medicine medicine){
        new InsertAsyncMedicine(medicineDao).execute(medicine);
    }

    public void update(Medicine medicine){
        new UpdateAsyncMedicine(medicineDao).execute(medicine);
    }

    public void delete(Medicine medicine){
        new DeleteAsyncMedicine(medicineDao).execute(medicine);
    }

    public LiveData<List<Medicine>> getAllMedicines () {return allMedicines; }

    public void deleteAll(){
        new DeleteAllAsyncMedicine(medicineDao).execute();
    }




}
