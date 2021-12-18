package com.example.teste;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Pedidos implements Serializable {

    /*
     * Atributos
     */
    List<ItensLivros> itemPedidosLivros = new ArrayList<>();

    public Pedidos(List<ItensLivros> itemPedidosLivros) {
        this.itemPedidosLivros = itemPedidosLivros;
    }


    /*
     * Construtor: declarado vazio, primeiro
     */
    //public Pedidos() {
    // Required empty public constructor
    //}



    /*
     * ************* Métodos personalizados *************
     */

    /*
     * Método responsável por retornar o valor total da compra feita pelo usuário
     */
    public double valorTotal(){
        double total = 0;

        for (ItensLivros livro: itemPedidosLivros) {
            total += (livro.precoDoLivro * livro.getQuantidadeLivro());
        }
        return total;
    }

    /*
     * Método responsável por retornar a quantidade total de itens pedidos
     */
    public int QuantidadeTotal(){
        int quantidade=0;

        for (ItensLivros livro: itemPedidosLivros) {
            quantidade += livro.getQuantidadeLivro();
        }
        return quantidade;
    }


/*    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pedidos, container, false);
    }*/
}