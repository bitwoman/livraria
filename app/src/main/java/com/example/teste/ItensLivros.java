package com.example.teste;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * ******* PRODUTO QUE SERÁ VENDIDO *******
 * Itens que poderão ser adicionados ao carrinho
 */

public class ItensLivros extends Fragment implements Serializable {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_itens_livros, container, false);
    }

    /*
     * ******* ATRIBUTOS *******
     */
    public String tituloDoLivro;
    public int id, imagemDoLivro, quantidadeLivro = 0;
    public double precoDoLivro;

    /*
     * CONSTRUTOR
     * Necessário iniciá-lo vazio
     */
    public ItensLivros(){

    }

    /*
     * ******* CONSTRUTOR *******
     * não é iniciado com quantidade, pois o carrinho começa vazio
     */
    public ItensLivros(String tituloDoLivro, int imagemDoLivro, double precoDoLivro) {
        this.tituloDoLivro = tituloDoLivro;
        this.imagemDoLivro = imagemDoLivro;
        this.precoDoLivro = precoDoLivro;
    }


    /*
     * ******* GETTERS AND SETTERS *******
     */

    public String getTituloDoLivro() {
        return tituloDoLivro;
    }

    public void setTituloDoLivro(String tituloDoLivro) {
        this.tituloDoLivro = tituloDoLivro;
    }

    /*public int getId() {
        return id;
    }*/

    public void setId(int id) {
        this.id = id;
    }

    public int getImagemDoLivro() {
        return imagemDoLivro;
    }

    public void setImagemDoLivro(int imagemDoLivro) {
        this.imagemDoLivro = imagemDoLivro;
    }

    public int getQuantidadeLivro() {
        return quantidadeLivro;
    }

    public void setQuantidadeLivro(int quantidadeLivro) {
        this.quantidadeLivro = quantidadeLivro;
    }

    public double getPrecoDoLivro() {
        return precoDoLivro;
    }

    public void setPrecoDoLivro(double precoDoLivro) {
        this.precoDoLivro = precoDoLivro;
    }


    public static List<ItensLivros> getLivro() {
        List<ItensLivros> prateleira = new ArrayList<ItensLivros>();
        /*
         * A classe ListaLivros é instanciada com o nome de "prateleira" (intuitivo), e, assim, podendo ser adicionado
         * itens ao objeto em questão. Adicionaremos livros à "prateleira".
         */
        prateleira.add(new ItensLivros("O andar do bêbado",R.drawable.ic_o_andar_do_bebado, 28.73));

        prateleira.add(new ItensLivros("Eragon",R.drawable.ic_eragon,47.62));

        prateleira.add(new ItensLivros("Factfulness", R.drawable.ic_factfulness, 47.19));

        prateleira.add(new ItensLivros("Cartas de amor aos mortos", R.drawable.ic_cartas_de_amor_aos_mortos, 22.34));

        prateleira.add(new ItensLivros("Admirável mundo novo", R.drawable.ic_admiravel_mundo_novo,20.80));

        prateleira.add(new ItensLivros("21 lições para o século 21", R.drawable.ic_21_licoes_para_o_seculo_21, 35.63));

        prateleira.add(new ItensLivros("Sapiens", R.drawable.ic_sapiens, 49.19));

        prateleira.add(new ItensLivros("Anne Frank: Obra reunida", R.drawable.ic_anne_frank_obra_reunida, 93.89));

        prateleira.add(new ItensLivros("Homo Deus", R.drawable.ic_homo_deus, 29.00));

        prateleira.add(new ItensLivros("Tudo e um pouco mais", R.drawable.ic_tudo_e_um_pouco_mais, 61.99));

        return prateleira;
    }
}