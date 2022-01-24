package com.example.medmanager.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.medmanager.models.Medicine;
import java.util.List;

@Dao
public interface MedicineDao {
    @Query("SELECT * FROM medicines ORDER BY UPPER(name) ASC")
    LiveData<List<Medicine>> getAllMedicines();

    @Query("SELECT * FROM medicines WHERE name LIKE :search")
    LiveData<List<Medicine>> findMedicinesByPattern(String search);

    @Query("SELECT * FROM medicines WHERE medicineId = :mid")
    Medicine getMedicineById(int mid);

    @Insert
    void insertMedicine(Medicine medicine);

    @Delete
    void deleteMedicine(Medicine medicine);

    @Update
    void updateMedicine(Medicine medicine);

    @Query("DELETE FROM medicines")
    void deleteAllMedicines();

}
