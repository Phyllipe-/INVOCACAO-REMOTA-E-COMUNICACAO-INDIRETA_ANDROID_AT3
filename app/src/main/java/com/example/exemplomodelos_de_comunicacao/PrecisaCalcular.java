package com.example.exemplomodelos_de_comunicacao;

import android.widget.TextView;

public class PrecisaCalcular {
    TextView textViewPrecisaCalcular;
    public PrecisaCalcular(TextView textView){
        this.textViewPrecisaCalcular = textView;
    }
    public String calculoLocal(){
        Calculadora calc = new Calculadora();
        String result= calc.soma(20.0,20.0)+"";
        return result;
    }

    public void calculoRemoto(){
        CalculadoraSocket calculadoraSocket = new CalculadoraSocket(this, "15", "15");
        calculadoraSocket.execute();

    }
    public void calculoRemotoHTTP(String operacao){
        CalculadoraHttpPOST calculadoraHttpPOST = null;
        switch (operacao) {
            case "1":
                // Código para a operação de soma
                calculadoraHttpPOST = new CalculadoraHttpPOST(this, "15", "15",operacao);
                break;
            case "2":
                // Código para a operação de subtração
                calculadoraHttpPOST = new CalculadoraHttpPOST(this, "15", "15",operacao);
                break;
            case "3":
                // Código para a operação de divisão
                calculadoraHttpPOST = new CalculadoraHttpPOST(this, "15", "15",operacao);
                break;
            case "4":
                // Código para a operação de multiplicação
                calculadoraHttpPOST = new CalculadoraHttpPOST(this, "15", "15",operacao);
                break;
            default:
                // Código caso a operação seja inválida
                break;
        }

        calculadoraHttpPOST.execute();

    }
    public void result_calculoRemoto(String result){
        textViewPrecisaCalcular.setText(result);
    }

}
