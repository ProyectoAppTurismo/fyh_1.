package com.example.fyh;

import android.content.Context;
import android.database.Cursor;
import android.text.Html;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class CursorAdapter extends android.widget.CursorAdapter
{

    private DbAdapter dbAdapter; //Creamos el objeto DbAdapter
    private Html.TagHandler http;

    /**
     * Constructor CursorAdapter
     * @param context
     * @param c
     */
    public CursorAdapter(Context context, Cursor c)
    {
        super(context, c);
        dbAdapter = new DbAdapter(context);
        dbAdapter.abrir();
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor)
    {

        TextView tv = (TextView) view ;

        String nombre = cursor.getString(cursor.getColumnIndex(DbAdapter.C_NOMBRE));
        String descripcion = cursor.getString(cursor.getColumnIndex(DbAdapter.C_DESCRIPCION));
        String resultado = nombre + "\n" + descripcion;

        //tv.setText(resultado);
        tv.setText(
                Html.fromHtml("<strong>" + nombre +"</strong>:<br>" +resultado));


    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent)
    {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(android.R.layout.simple_list_item_activated_1, parent, false);
        view.setMinimumHeight(200);
        view.setClickable(true);
        return view;
    }
}
