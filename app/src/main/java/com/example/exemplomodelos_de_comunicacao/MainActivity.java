package com.example.exemplomodelos_de_comunicacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    TextView textViewHTTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSomar = findViewById(R.id.buttonSomar);
        Button buttonSubtrair = findViewById(R.id.buttonSubtrair);
        Button buttonDividir = findViewById(R.id.buttonDividir);
        Button buttonMultiplicar = findViewById(R.id.buttonMultiplicar);

        textViewHTTP = findViewById(R.id.textView);

        buttonSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularOperacaoRemota("1");
            }
        });

        buttonSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularOperacaoRemota("2");
            }
        });

        buttonDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularOperacaoRemota("3");
            }
        });

        buttonMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularOperacaoRemota("4");
            }
        });
    }

    private void calcularOperacaoRemota(String operacao) {
        PrecisaCalcular precisaCalcularHTTP = new PrecisaCalcular(textViewHTTP);
        precisaCalcularHTTP.calculoRemotoHTTP(operacao);
    }
}