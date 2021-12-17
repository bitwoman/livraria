package com.example.teste;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class CadastroDeLivros extends Fragment implements Serializable {

    /*ItemLivro livro = new ItemLivro();
    private ItemLivroDAO dao;*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cadastro_de_livros, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);
        EditText tituloLivro = view.findViewById(R.id.idEditTextCadastroTituloLivro);
        EditText precoLivro = view.findViewById(R.id.idEditTextCadastroPrecoLivro);
        Button iconeLivro = view.findViewById(R.id.idButtonUploadIconeLivro);
        Button ButtonCadastrarLivro = view.findViewById(R.id.idButtonCadastrarLivro);
        //dao =  new ItemLivroDAO(this);


        iconeLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //livro.setImagemDoLivro(iconeLivro.getContext());
            }
        });


        ButtonCadastrarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tituloLivro.getText().toString().trim().isEmpty() || precoLivro.getText().toString().trim().isEmpty()){
                    Toast.makeText(view.getContext(), "Preencha os campos", Toast.LENGTH_SHORT).show();
                } else {
                    if (tituloLivro.getText().toString().trim().isEmpty() && precoLivro.getText().toString().trim().isEmpty()) {
                        Toast.makeText(view.getContext(), "Preencha os campos", Toast.LENGTH_SHORT).show();
                    } else {
                        /*livro.setTituloDoLivro(tituloLivro.getText().toString());
                        livro.setPrecoDoLivro(Double.parseDouble(precoLivro.getText().toString()));
                        long id = dao.inserirLivro(livro);


                        Toast.makeText(view.getContext(), "Livro cadastrado " + id, Toast.LENGTH_SHORT).show();
                        navController.navigate(R.id.action_cadastroDeLivros_to_home2);*/
                    }
                }
            }
        });

    }
}