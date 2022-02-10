package com.example.medmanager.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.medmanager.models.User;
import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users ORDER BY UPPER(name) ASC")
    LiveData<List<User>> allUsers();

    @Query("SELECT * FROM users WHERE name LIKE :search")
    LiveData<List<User>> findMedicinesByPattern(String search);

    @Query("SELECT * FROM users WHERE userId = :uid")
    User getUserById(int uid);


    @Query("SELECT * FROM users WHERE email LIKE :uEmail AND password LIKE :uPass")
    User getUserByEmail(String uEmail, String uPass);

    @Insert
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Update
    void updateUser(User user);

    @Query("DELETE FROM users")
    void deleteAllUsers();
}
