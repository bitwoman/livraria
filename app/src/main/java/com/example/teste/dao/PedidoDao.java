package com.example.teste.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.teste.model.LivroModel;
import com.example.teste.model.PedidoModel;

import java.util.List;

@Dao
public interface PedidoDao {

    @Insert
    long insert(PedidoModel pedido);

    @Update
    void update(PedidoModel pedido);

    @Delete
    void delete(PedidoModel pedido);

    @Query("SELECT * FROM pedidomodel WHERE id = (:id)")
    PedidoModel get(int id);

    @Query("SELECT * FROM pedidomodel")
    List<PedidoModel> getAll();

}
