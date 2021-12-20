package com.example.teste;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Pedido extends AppCompatActivity {

    /*
     * ATRIBUTOS
     */
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView formaDePagamento;
    Button fecharPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pedido);

        Intent it = this.getIntent();
        Pedidos pedidos = (Pedidos) it.getSerializableExtra("pedido");

        final ItemAdapter adaptador = new ItemAdapter(this, pedidos.itemPedidosLivros);

        ListView listView = (ListView) findViewById(R.id.idListViewPedido);
        listView.setAdapter(adaptador);

        TextView quantidade = (TextView) findViewById(R.id.idTextViewTotalDePedidos);
        TextView valor = (TextView) findViewById(R.id.idTextViewValorTotalDoPedido);

        quantidade.setText(String.valueOf(pedidos.QuantidadeTotal()));
        valor.setText("R$ " + String.format("%.2f", pedidos.valorTotal()).replace(".",","));


        radioGroup = findViewById(R.id.idRadioGroup);
        formaDePagamento = findViewById(R.id.idTextViewRespostaFormaPagamento);
        fecharPedido = findViewById(R.id.idButtonFecharPedido);

        fecharPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void checkRadioBox(View v){
        int idRadioGroup = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(idRadioGroup);

        formaDePagamento.setText(radioButton.getText());

    }

}