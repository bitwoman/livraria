package com.example.teste;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Teste extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    /*
     * Atributos globais utilizados nesta classe
     */
    List<ItensLivros> ListaLivrosDoCarrinho = new ArrayList<ItensLivros>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_teste);

        ItemAdapter adaptador = new ItemAdapter(this, ItensLivros.getLivro());

        ListView listViewListaLivros = (ListView) findViewById(R.id.idlistViewMain);
        listViewListaLivros.setAdapter(adaptador);
        listViewListaLivros.setOnItemClickListener(this);
        listViewListaLivros.setOnItemLongClickListener(this);
    }


    /*
     * Método responsável pelo clique simples em um item da lista.
     * Retorna o nome do livro clicado (que são nossos itens).
     */
    public void onItemClick(AdapterView<?> lv, View v, int pos, long id) {
        ItensLivros livro = (ItensLivros) lv.getAdapter().getItem(pos);
        Toast.makeText(this, " " + livro.tituloDoLivro, Toast.LENGTH_SHORT).show();
    }


    /*
     * Método responsável pelo clique longo em um item da lista.
     * Tem a ação de adicionar o item ao carrinho de compras ou notificar ao usuário, através de
     * uma mensagem, que o item selecionado já está em seu carrinho.
     */
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long id) {
        ItensLivros livro = (ItensLivros) adapterView.getAdapter().getItem(i);

        if(livro.getQuantidadeLivro() == 0){
            livro.setQuantidadeLivro(1);

            ListaLivrosDoCarrinho.add(livro);

            Toast.makeText(this, "Você selecionou " + livro.tituloDoLivro, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "O " + livro.tituloDoLivro + " já está no seu no carrinho", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    /*
     * ACTION BAR
     */
    /*
     * Responsável por inflar a action bar na activity
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*
     * Método responsável pela ação do botão presente na Action Bar
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem itemDaActionBar){
        switch(itemDaActionBar.getItemId()) {
            case R.id.idButtonCarrinhoCompras:
                Intent it = new Intent(this, ListaDePedidosDeLivros.class);
                it.putExtra("PedidosLivros", (Serializable) ListaLivrosDoCarrinho);
                startActivity(it);

                break;
        }
        return super.onOptionsItemSelected(itemDaActionBar);
    }

}