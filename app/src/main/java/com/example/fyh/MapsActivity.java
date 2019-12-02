package com.example.fyh;

import androidx.fragment.app.FragmentActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.widget.Toast.LENGTH_LONG;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private String v_compañia;
    private String v_tipo;
    private String v_precio;
    private String v_afluencia;
    private String v_TipoTur;
    private DbAdapter dbAdapter2;
    private Cursor cursor;
    private CursorAdapter destinoAdapter ;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        lista = (ListView) findViewById(android.R.id.list);
        dbAdapter2 = new DbAdapter(this);
        dbAdapter2.abrir();

        v_compañia= getIntent().getExtras().getString("b_compañia");
        v_tipo= getIntent().getExtras().getString("b_tipo");
        v_precio= getIntent().getExtras().getString("b_precio");
        v_afluencia= getIntent().getExtras().getString("b_afluencia");
        v_TipoTur= getIntent().getExtras().getString("TipoTur");


        consultar(v_compañia, v_tipo, v_precio,v_afluencia,v_TipoTur);

        /*
         * Declaramos el controlador de la BBDD y accedemos en modo escritura
         */
        DbHelper dbHelper = new DbHelper(getBaseContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Toast.makeText(getBaseContext(), v_TipoTur, LENGTH_LONG).show();

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        LatLng madrid = new LatLng(40.4378698,-3.8196233);
        mMap.addMarker(new MarkerOptions().position(madrid).title(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(madrid));

        mMap.setMinZoomPreference(5);


    }

    private void consultar( String com, String tip, String pre, String afl, String Tipot)
    {

        cursor = dbAdapter2.getCursor(com, tip, afl,pre, Tipot);
        startManagingCursor(cursor);
        destinoAdapter = new CursorAdapter(this, cursor);
        lista.setAdapter(destinoAdapter);


    }
}
