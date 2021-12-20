package com.example.teste.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PedidoModel {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public double totalPedido;
    public int quantidadeItens;

}
