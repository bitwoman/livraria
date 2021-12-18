package com.example.teste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends BaseAdapter {

    /*
     * Atributos
     */
    private Context context;
    private List<ItensLivros> livro = new ArrayList<>();

    /*
     * Construtor
     */
    public ItemAdapter(Context context, List<ItensLivros> livro){
        this.context = context;
        this.livro = livro;
    }

    /*
     * Métodos personalizados
     */

    /*
     * GETTERS AND SETTERS
     */
    @Override
    public int getCount() {
        return livro.size();
    }

    @Override
    public Object getItem(int position) {
        return livro.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemLivrosAdapt = LayoutInflater.from(context).inflate(R.layout.fragment_itens_livros,parent , false);

        /*
         * Responsável por acessar os componentes da linha da lista
         */
        ImageView imagemDoLivro = (ImageView) itemLivrosAdapt.findViewById(R.id.idIconLivro);
        TextView textViewTituloDoLivro = (TextView) itemLivrosAdapt.findViewById(R.id.idTextViewTituloDoLivro);
        TextView TextViewPecoDoLivro = (TextView) itemLivrosAdapt.findViewById(R.id.idTextViewPrecoDoLivro);
        ItensLivros item = livro.get(position);

        /*
         * Responsável por adicionar as informações nos componentes de cada linha
         */
        imagemDoLivro.setImageResource(item.imagemDoLivro);
        textViewTituloDoLivro.setText(item.tituloDoLivro);
        TextViewPecoDoLivro.setText("R$ " + String.format("%.2f", item.precoDoLivro));



        return itemLivrosAdapt;
    }
}
