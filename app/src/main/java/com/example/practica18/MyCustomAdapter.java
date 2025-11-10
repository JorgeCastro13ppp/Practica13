package com.example.practica18;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomAdapter extends BaseAdapter  {

    ArrayList <Filas> lista;
    //Almacenamos el contexto de la aplicación
    Context contexto;

    //Constructor
    MyCustomAdapter(Context c){
        //Recogemos el contexto que nos pasa por parámetros
        contexto = c;
        //Definimos un arraylist donde almacenamos los elementos (objetos de la clase contenedora)
        lista = new ArrayList<Filas>();
        //Definimos un objeto resources para poder acceder a los arrays de Strings y a los drawables
        Resources res = c.getResources();
        String [] titulos = res.getStringArray(R.array.titulos);
        String [] subtitulos = res.getStringArray(R.array.subtitulos);
        int imagenes [] = {R.drawable.madrid,R.drawable.barcelona,R.drawable.caceres,R.drawable.badajoz,R.drawable.talavera};

        //Creamos un arraylist de objetos a partir de la clase contenedora a partir de los arrays
        for(int i = 0;i<5;i++){
            lista.add(new Filas(titulos[i],subtitulos[i],imagenes[i]));
        }
    }
    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Definimos un layout inflater para poder cargar el custom layout de la fila
        LayoutInflater inflar = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Inflamos el layout
        View list = inflar.inflate(R.layout.fila,parent,false);
        //Enlazamos a través de la clase R los elementos del custom layout
        TextView titulo = (TextView) list.findViewById(R.id.textView1);
        TextView subtitulo= (TextView) list.findViewById(R.id.textView2);
        ImageView imagen = (ImageView) list.findViewById(R.id.imageView1);

        //Mostrar el elemento definido en position
        Filas temporal = lista.get(position);
        //Y asignamos su contenido a los elementos del custom layout
        titulo.setText(temporal.titulo);
        subtitulo.setText(temporal.subtitulo);
        imagen.setImageResource(temporal.imagen);

        return list;
    }


}
