package com.example.teste.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.teste.model.LivroModel;
import java.util.List;

@Dao
public interface LivroDao {

    @Insert
    long insert(LivroModel livro);

    @Update
    void update(LivroModel livro);

    @Delete
    void delete(LivroModel livro);

    @Query("SELECT * FROM livromodel WHERE id = (:id)")
    LivroModel get(int id);

    @Query("SELECT * FROM livromodel")
    List<LivroModel> getAll();

}
