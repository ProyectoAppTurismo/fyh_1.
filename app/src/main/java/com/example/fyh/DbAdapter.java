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
    public static final String C_ID   = "id";
    public static final String C_NOMBRE = "nombre";
    public static final String C_COMPANIA = "compania";
    public static final String C_TIPO = "tipo";
    public static final String C_PRECIO = "precio";
    public static final String C_AFLUENCIA = "afluencia";
    public static final String C_DESCRIPCION = "descripcion";
    public static final String C_DESCRIPTION = "description";
    public static final String C_LOCALIZACION = "coordenadas";
    public static final String C_TIPOTUR = "tipo_turismo";
    public static final String C_LINK = "link";
    private Context contexto;
    private DbHelper dbHelper;
    private SQLiteDatabase db;
    String seleccion =  C_COMPANIA + " = ?" + " AND " + C_TIPO + " = ?" + " AND " + C_PRECIO + " = ?" + " AND " + C_AFLUENCIA + " = ?" + " AND " + C_TIPOTUR + " = ?";


    /**
     * Definimos lista de columnas de la tabla para utilizarla en las consultas a la base de datos
     */
    private String[] columnas = new String[]{  C_ID, C_NOMBRE, C_COMPANIA, C_TIPO, C_PRECIO, C_AFLUENCIA, C_LINK, C_DESCRIPCION, C_DESCRIPTION, C_LOCALIZACION, C_TIPOTUR} ;

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
    public Cursor getCursor(String com, String tip, String pre, String afl, String Tipot) throws SQLException
    {

        String seleccionArgs[] = new String []{ com,tip, pre, afl, Tipot};
        Cursor c = db.query( true, C_TABLA, columnas, seleccion , seleccionArgs, null, null, null, null);
        return c;
    }


}