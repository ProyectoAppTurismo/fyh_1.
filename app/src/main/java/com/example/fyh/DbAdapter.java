package com.example.fyh;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DbAdapter extends Resultados {

    /**
     * Definimos constante con el nombre de la tabla
     */
    public static final String C_TABLA = "DESTINO" ;

    /**
     * Definimos constantes con el nombre de las columnas de la tabla
     */
    public static final String C_ID   = "_id";
    public static final String C_NOMBRE = "d_nombre";
    public static final String C_COMPANIA = "d_compania";
    public static final String C_TIPO = "d_tipo";
    public static final String C_PRECIO = "d_precio";
    public static final String C_AFLUENCIA = "d_afluencia";
    public static final String C_DESCRIPCION = "d_descripcion";
    public static final String C_DESCRIPTION = "d_description";
    public static final String C_LOCALIZACION = "d_localizacion";
    public static final String C_TIPOTUR = "d_tipo_turismo";
    public static final String C_LINK = "d_link";
    private Context contexto;
    private DbHelper dbHelper;
    private SQLiteDatabase db;
    String seleccion =  C_COMPANIA + " = ?" + " AND " + C_TIPO + " = ?" + " AND " + C_PRECIO + " = ?" + " AND " + C_AFLUENCIA + " = ?" + " AND " + C_TIPOTUR + " = ?";


    /**
     * Definimos lista de columnas de la tabla para utilizarla en las consultas a la base de datos
     */
    private String[] columnas = new String[]{C_ID, C_NOMBRE, C_DESCRIPCION,C_LOCALIZACION, C_DESCRIPTION, C_LINK} ;

    public DbAdapter(Context context )
    {

        this.contexto = context;

    }

    public DbAdapter abrir() throws SQLException
    {
        dbHelper = new DbHelper(contexto);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void cerrar()
    {
        dbHelper.close();
    }

    /**
     * Devuelve cursor con todas las columnas de la tabla
     *
     */
    public Cursor getCursor(String com, String tip, String afl,String pre, String tipot) throws SQLException
    {

        String seleccionArgs[] = new String []{ com,tip, afl,pre, tipot};
        Cursor c = db.query( true, C_TABLA, columnas, seleccion , seleccionArgs, null, null, null, null);
        return c;
    }


}