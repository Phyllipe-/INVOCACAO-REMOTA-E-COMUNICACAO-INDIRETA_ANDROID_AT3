package com.example.exemplomodelos_de_comunicacao;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class CalculadoraHttpPOST extends AsyncTask<Void, Void, String> {

    TextView textView;
    String numeroA, numeroB, operacao;
    PrecisaCalcular calcular;
    public CalculadoraHttpPOST(TextView textViewActivity, String numeroA,
                               String numeroB){
        this.textView = textViewActivity;
        this.numeroA = numeroA;
        this.numeroB = numeroB;

    }
    public CalculadoraHttpPOST(PrecisaCalcular calcular, String numeroA, String numeroB, String operacao){
        this.textView = textView;
        this.numeroA = numeroA;
        this.numeroB = numeroB;
        this.calcular = calcular;
        this.operacao = operacao;

    }
    @Override
    protected String doInBackground(Void... voids) {
        String resultado="";
        try {

           URL url = new URL("https://double-nirvana-273602.appspot.com/?hl=pt-BR");
           HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true) ;

            //ENVIO DOS PARAMETROS
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));

            writer.write("oper1="+ numeroA +"&oper2="+ numeroB +"&operacao="+operacao);
            writer.flush();
            writer.close();
            os.close();

            int responseCode=conn.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK) {

                //RECBIMENTO DOS PARAMETROS


                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "utf-8"));
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                resultado = response.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return resultado;
        //Codigo
    }


    @Override
    protected void onPreExecute() {
        //Codigo
    }


    @Override
    protected void onPostExecute(String resultado) {
        //Codigo
        if(this.textView !=null) {
            this.textView.setText(resultado);
        }else {
            this.calcular.result_calculoRemoto(resultado);
        }
    }

}

