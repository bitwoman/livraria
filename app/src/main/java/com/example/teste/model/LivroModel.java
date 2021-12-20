package com.example.teste.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LivroModel {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String tituloDoLivro;
    public double precoDoLivro;
}
