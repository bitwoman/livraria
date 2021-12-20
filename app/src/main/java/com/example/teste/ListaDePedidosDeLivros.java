package com.example.teste;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teste.ui.home.HomeFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ListaDePedidosDeLivros extends AppCompatActivity {

    /*
     * ATRIBUTOS
     */
    List<ItensLivros> ListaLivrosDoCarrinho = new ArrayList<ItensLivros>();
    Button buttonFecharPedido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_lista_de_pedidos_de_livros);

        Intent it = this.getIntent();
        List<ItensLivros> listaLivros = (List<ItensLivros>) it.getSerializableExtra("PedidosLivros");

        final PedidoAdapter adaptador = new PedidoAdapter(this, listaLivros);
        final ListView listaDePedidos = (ListView) findViewById(R.id.idListViewListaPedidosLivros);
        listaDePedidos.setAdapter(adaptador);

        TextView respostaFormaPagamento = findViewById(R.id.idTextViewRespostaFormaPagamento);

        Button buttonTelaInicial = (Button) findViewById(R.id.idButtonTelaInicial);

        buttonTelaInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(v.getContext(), HomeFragment.class);
                it.putExtra("Home", HomeFragment.class);
                startActivity(it);
            }
        });

        //buttonFecharPedido = (Button) findViewById(R.id.idButtonFecharCarrinho);

        /*buttonFecharPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pedidos pedidos = new Pedidos(adaptador.livro);
                Iterator<ItensLivros> iterator = pedidos.itemPedidosLivros.iterator();

                while (iterator.hasNext()){
                    if(iterator.next().getQuantidadeLivro() == 0){
                        iterator.remove();
                    }
                }

                Intent it = new Intent(view.getContext(), Pedido.class);
                it.putExtra("pedido", (Serializable) pedidos);
                startActivity(it);

                listaDePedidos.setAdapter(adaptador);
            }
        });*/
    }
}