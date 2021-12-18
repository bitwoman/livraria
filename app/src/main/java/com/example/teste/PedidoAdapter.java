package com.example.teste;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PedidoAdapter extends BaseAdapter implements Serializable {

    /*
     * Atributos
     */
    private Context context;
    public List<ItensLivros> livro = new ArrayList<>();

    /*
     * CONSTRUTOR
     */
    public PedidoAdapter(Context context, List<ItensLivros> livro) {
        this.context = context;
        this.livro = livro;
    }

    /*
     * Métodos personalizados
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
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemLivrosAdapt = inflater.inflate(R.layout.fragment_pedidos, parent, false);

        ImageView imagemDoLivro = (ImageView) itemLivrosAdapt.findViewById(R.id.idIconLivro);
        TextView textViewTituloDoLivro = (TextView) itemLivrosAdapt.findViewById(R.id.idTextViewTituloDoLivro);
        TextView TextViewPecoDoLivro = (TextView) itemLivrosAdapt.findViewById(R.id.idTextViewPrecoDoLivro);
        final ItensLivros itemLivro = livro.get(position);


        imagemDoLivro.setImageResource(itemLivro.imagemDoLivro);
        textViewTituloDoLivro.setText(itemLivro.tituloDoLivro);
        TextViewPecoDoLivro.setText("R$ " + String.format("%.2f", itemLivro.precoDoLivro).replace(".", ","));

        return itemLivrosAdapt;
    }
}
