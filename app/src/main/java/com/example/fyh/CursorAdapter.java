package com.example.fyh;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class CursorAdapter extends android.widget.CursorAdapter
{

    private DbAdapter dbAdapter; //Creamos el objeto DbAdapter

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
        tv.setText(cursor.getString(cursor.getColumnIndex(DbAdapter.C_DESCRIPCION)));
 
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent)
    {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(android.R.layout.simple_expandable_list_item_1, parent, false);

        return view;
    }
}
