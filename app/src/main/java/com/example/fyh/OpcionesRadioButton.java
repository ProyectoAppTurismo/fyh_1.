package com.example.fyh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class OpcionesRadioButton extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Button botonMaps = (Button) findViewById(R.id.maps);
        botonMaps.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(view.getContext(), MapsActivity.class);
                startActivityForResult(intent2, 0);

            }
        });

        Button btn = (Button) findViewById(R.id.siguiente);


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), Resultados.class);
                intent.putExtra("b_compañia", BotonesCompañia() );
                intent.putExtra("b_tipo", BotonesTipo() );
                intent.putExtra("b_precio", BotonesPrecio() );
                intent.putExtra("b_afluencia", BotonesAfluencia() );
                intent.putExtra("TipoTur", Spinneropcion() );
                startActivityForResult(intent, 0);

            }
        });

        botonMaps.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), MapsActivity.class);
                intent.putExtra("b_compañia", BotonesCompañia() );
                intent.putExtra("b_tipo", BotonesTipo() );
                intent.putExtra("b_precio", BotonesPrecio() );
                intent.putExtra("b_afluencia", BotonesAfluencia() );
                intent.putExtra("TipoTur", Spinneropcion() );
                startActivityForResult(intent, 0);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Según el radioButton seleccionado, retorna un string
     * @return tipo de compañia seleccionada
     */
    public String BotonesCompañia(){
        String compañia="";
        RadioButton solo= (RadioButton) findViewById(R.id.solo);
        RadioButton amigos= (RadioButton) findViewById(R.id.amigos);
        RadioButton pareja= (RadioButton) findViewById(R.id.pareja);
        RadioButton familia= (RadioButton) findViewById(R.id.familia);
        if (solo.isChecked())
            compañia= "Sol@";
        if (pareja.isChecked())
            compañia= "Pareja";
        if (familia.isChecked())
            compañia= "Familia";
        if (amigos.isChecked())
            compañia= "Amigos";
        return compañia;
    }

    /**
     * Según el radioButton seleccionado, retorna un string
     * @return tipo seleccionado
     */
    public String BotonesTipo(){
        String tipo="";
        RadioButton costa= (RadioButton) findViewById(R.id.costa);
        RadioButton interior = (RadioButton) findViewById(R.id.interior);

        if (costa.isChecked())
            tipo= "Costa";
        if (interior.isChecked())
            tipo= "Interior";

        return tipo;
    }

    /**
     * Según el radioButton seleccionado, retorna un string
     * @return precio seleccionado
     */
    public String BotonesPrecio(){
        String precio ="";
        RadioButton bajo = (RadioButton) findViewById(R.id.precio_bajo);
        RadioButton medio = (RadioButton) findViewById(R.id.precio_medio);
        RadioButton alto = (RadioButton) findViewById(R.id.precio_alto);


            if (bajo.isChecked()) {
                precio = "€";
            }
            if (medio.isChecked()) {
                precio = "€€";
            }
            if (alto.isChecked()) {
                precio = "€€€";
            }

        return precio;
    }

    /**
     * Según el radioButton seleccionado, retorna un string
     * @return tipo de afluencia seleccionada
     */
    public String BotonesAfluencia(){
        String afluencia ="";
        RadioButton baja = (RadioButton) findViewById(R.id.baja);
        RadioButton media = (RadioButton) findViewById(R.id.media);
        RadioButton alta = (RadioButton) findViewById(R.id.alta);

        if (baja.isChecked())
            afluencia= "Baja";
        if (media.isChecked())
            afluencia= "Media";
        if (alta.isChecked())
            afluencia= "Alta";
        return afluencia;
    }

    public String Spinneropcion(){
        Spinner Tipotur= (Spinner) findViewById(R.id.TipoDeTurismo);
        String spinnerText= Tipotur.getSelectedItem().toString();

        return spinnerText;
    }
}