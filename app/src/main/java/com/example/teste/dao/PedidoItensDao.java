package com.example.teste.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.teste.model.LivroModel;
import com.example.teste.model.PedidoItensModel;
import com.example.teste.model.PedidoModel;

import java.util.List;

@Dao
public interface PedidoItensDao {

    @Insert
    long insert(PedidoItensModel pedidoItens);

    @Update
    void update(PedidoItensModel pedidoItens);

    @Delete
    void delete(PedidoItensModel pedidoItens);

    @Query("SELECT * FROM pedidoitensmodel WHERE id = (:id)")
    PedidoItensModel get(int id);

    @Query("SELECT * FROM pedidoitensmodel")
    List<PedidoItensModel> getAll();

}
