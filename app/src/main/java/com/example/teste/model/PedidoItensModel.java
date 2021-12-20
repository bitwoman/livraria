package com.example.teste.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PedidoItensModel {

    @PrimaryKey(autoGenerate = false)
    public int id;
    public int quantidadeItens, codigoDoLivro, codigoPedido;
    public String tituloDoLivro;

}
