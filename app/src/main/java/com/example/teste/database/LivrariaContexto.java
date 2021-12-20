package com.example.teste.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.teste.dao.LivroDao;
import com.example.teste.dao.PedidoDao;
import com.example.teste.dao.PedidoItensDao;
import com.example.teste.model.LivroModel;
import com.example.teste.model.PedidoItensModel;
import com.example.teste.model.PedidoModel;

@Database(entities = {LivroModel.class, PedidoItensModel.class, PedidoModel.class}, version=1)
public abstract class LivrariaContexto extends RoomDatabase {

    private static volatile LivrariaContexto instancia;

    public static synchronized LivrariaContexto getInstancia(Context contexto){
        if(instancia == null){
            instancia = Room.databaseBuilder(contexto, LivrariaContexto.class, "livraria").allowMainThreadQueries().build();
        }
        return instancia;
    }

    public abstract LivroDao Livro();
    public abstract PedidoDao Pedido();
    public abstract PedidoItensDao PedidoItens();

}
