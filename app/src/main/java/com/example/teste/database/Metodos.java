package com.example.teste.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.teste.ItensLivros;
import java.util.ArrayList;
import java.util.List;

public class Metodos extends SQLiteOpenHelper {

    /*
     * ATRIBUTOS
     */
    public final static String NOME_DO_BANCO = "livraria";
    /*
     * Quando a versão é alterada para 2, ele executa o método onUpgrade e
     * em seguida o método onCreate.
     */
    public final static int VERSAO_DO_BANCO = 1;


    /*
     * CONSTRUTOR
     */
    public Metodos(Context context) {
        super(context, NOME_DO_BANCO, null, VERSAO_DO_BANCO);
    }

    /*
     * ====================== MÉTODOS OBRIGATÓRIOS ======================
     */

    /*
     * Método que será executado quando o banco de dados não existir:
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //id INTEGER PRIMARY KEY AUTOINCREMENT
        sqLiteDatabase.execSQL("CREATE TABLE Livro (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tituloDoLivro TEXT, imagemDoLivro BLOB, precoDoLivro DOUBLE);");

        sqLiteDatabase.execSQL("CREATE TABLE PedidosItens (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tituloDoLivro TEXT, codigoDoLivro INTEGER, codigoPedido INTEGER, quantidadeItens INTEGER);");

        sqLiteDatabase.execSQL("CREATE TABLE Pedido (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "totalPedido DOUBLE, quantidadeItens INTEGER);");
    }

    /*
     * Método responsável por apagar o banco de dados e recriá-lo através do onCreate a partir da versão VERSAO_DO_BANCO = 2
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Livro");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PedidosItens");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Pedido");

        onCreate(sqLiteDatabase);
    }


    /*
     * ====================== MÉTODOS PERSONALIZADOS ======================
     */

    /*
     * Método para a busca de dados no banco de dados, ele retorna uma pesquisa (uma lista) na tabela ItemLivro
     *
    /*/
    public List<ItensLivros> consultaLivro() {
        SQLiteDatabase database = this.getReadableDatabase(); //Determina que o banco de dados será apenas para leitura
        String selectLivro = "SELECT * FROM ItemLivro;"; //Retorna todos os livros disponíveis no banco de dados

        //
        Cursor cursor = database.rawQuery(selectLivro, null);

        //Lista responsável que por retornar todos os livros para o usuário
        List<ItensLivros> livros = new ArrayList<ItensLivros>();

        while (cursor.moveToNext()) {
            ItensLivros livro = new ItensLivros();

            livro.setTituloDoLivro(String.valueOf(cursor.getColumnIndex("tituloDoLivro")));
            livro.setImagemDoLivro(cursor.getColumnIndex("imagemDoLivro"));
            livro.setPrecoDoLivro(cursor.getColumnIndex("precoDoLivro"));

            livros.add(livro);
        }

        return livros;
    }


    /*
     * Método para a inserção de dados no banco de dados (livro)
     */
    public void insereLivro(ItensLivros livro) {
        SQLiteDatabase database = this.getWritableDatabase(); //Torna as ações "gravavéis"

        //ContentValues estrutura os dados de modo chave-valor
        ContentValues valoresParaInserirNoBanco = new ContentValues();
        valoresParaInserirNoBanco.put("tituloDoLivro", livro.getTituloDoLivro());
        valoresParaInserirNoBanco.put("imagemDoLivro", livro.getImagemDoLivro());
        valoresParaInserirNoBanco.put("precoDoLivro", livro.getPrecoDoLivro());

        database.insert("livro", null, valoresParaInserirNoBanco);

        database.close();
    }


    /*
     * Método para o ato de deletar os dados no banco de dados (livro)
     */
    public void deletaLivro(String tituloDoLivro) {
        SQLiteDatabase database = this.getWritableDatabase(); //Torna as ações "gravavéis"
        String deletaLivro = "DELETE * FROM ItemLivro WHERE tituloDoLivro = " + " ' " + tituloDoLivro + " ' ";
        database.execSQL(deletaLivro);
    }

}
