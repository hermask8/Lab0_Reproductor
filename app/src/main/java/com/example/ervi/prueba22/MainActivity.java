package com.example.ervi.prueba22;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public EditText mostrar;
    public static Hashtable<String,Cancion> miDiccionario = new Hashtable<>();
    public  List<String> miLista = new ArrayList<>();
    public static List<Cancion> playList = new ArrayList<>();
    public static int numero = 1;
    Intent ventanaAgregar ;
    ListView lvLista;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        lvLista = (ListView)findViewById(R.id.lvListas);
        mostrar = (EditText) findViewById(R.id.txtBuscar);
       ventanaAgregar = new Intent(this,AgregarActivity.class);

       if (numero!=1)
       {
           String nom = getIntent().getStringExtra("nombre");
           String dura = getIntent().getStringExtra("duracion");

           Cancion miCancion = new Cancion();

           miCancion.SetNombre(nom);
           miCancion.SetDuracion(Double.valueOf(dura));
           miDiccionario.put(nom,miCancion);
           for (Cancion i: miDiccionario.values()) {
                String elemento = i.GetNombre() + "              " + String.valueOf(i.GetDuracion());
               miLista.add(elemento);
           }
       }

       if (miDiccionario.size()==0)
       {
           AgregarDiccionario();
           for (Cancion i: miDiccionario.values()) {
               String elemento = i.GetNombre() + "              " + String.valueOf(i.GetDuracion());
               miLista.add(elemento);
           }
       }
        //ArrayAdapter<Cancion> adaptador = ArrayAdapter.createFromResource(this,miLista, android.R.layout.simple_list_item_1);
        if (miLista!=null)
        {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, miLista);
            lvLista.setAdapter(adapter);
        }
        numero++;

    }

    public void Cambio(View view)
    {
        startActivity(ventanaAgregar);
    }

    public void MostrarPlay(View view)
    {
        if (playList!=null)
        {
            miLista = new ArrayList<>();
            for (Cancion i:playList) {
                String ply = i.GetNombre() + "              " + String.valueOf(i.GetDuracion());
                miLista.add(ply);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, miLista);
            lvLista.setAdapter(adapter);

        }


    }
   public void Buscar(View view)
   {

       String elePlaylist = mostrar.getText().toString();
       if (miDiccionario.containsKey(elePlaylist)==true)
       {
           miLista = new ArrayList<>();
           String agreL = miDiccionario.get(elePlaylist).GetNombre() + "              " + String.valueOf(miDiccionario.get(elePlaylist).GetDuracion());
           miLista.add(agreL);
           ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, miLista);
           lvLista.setAdapter(adapter);
       }

       mostrar.setText("");
   }

    public void Biblioteca(View view)
    {
        miLista = new ArrayList<>();
        for (Cancion i: miDiccionario.values()) {
            String elemento = i.GetNombre() + "              " + String.valueOf(i.GetDuracion());
            miLista.add(elemento);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, miLista);
        lvLista.setAdapter(adapter);
    }
    public void AgregarPlaylist(View view)
    {

        String elePlaylist = mostrar.getText().toString();
        if (miDiccionario.containsKey(elePlaylist)==true)
        {
            playList.add(miDiccionario.get(elePlaylist));
        }
        mostrar.setText("");
    }

    public void AgregarDiccionario()
    {

        miDiccionario.put("Te vas",new Cancion("Te vas",3.45) );
        miDiccionario.put("Roxane",new Cancion("Roxane",4.56) );
        miDiccionario.put("Magic",new Cancion("Magic",3.4));
        miDiccionario.put("November Rain",new Cancion("November Rain",3));
        miDiccionario.put("Mirrors",new Cancion("Mirrors",4) );
        miDiccionario.put("Take On Me",new Cancion("Take On Me",3.6));
        miDiccionario.put("Let It Be",new Cancion("Let It Be",2.5));
    }

    public void AscendenteNombre(View view)
    {
        Collections.sort(playList, new Comparator<Cancion>() {
            @Override
            public int compare(Cancion o1, Cancion o2) {
                return new String(o1.GetNombre()).compareTo(new String(o2.GetNombre()));
            }
        });

        if (playList!=null)
        {
            miLista = new ArrayList<>();
            for (Cancion i:playList) {
                String ply = i.GetNombre() + "              " + String.valueOf(i.GetDuracion());
                miLista.add(ply);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, miLista);
            lvLista.setAdapter(adapter);

        }

    }
    public void DescendenteNombre(View view)
    {
        Collections.sort(playList, new Comparator<Cancion>() {
            @Override
            public int compare(Cancion o1, Cancion o2) {
                return new String(o2.GetNombre()).compareTo(new String(o1.GetNombre()));
            }
        });

        if (playList!=null)
        {
            miLista = new ArrayList<>();
            for (Cancion i:playList) {
                String ply = i.GetNombre() + "              " + String.valueOf(i.GetDuracion());
                miLista.add(ply);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, miLista);
            lvLista.setAdapter(adapter);

        }

    }
    public void AscendenteDuracion(View view)
    {
        Collections.sort(playList, new Comparator<Cancion>() {
            @Override
            public int compare(Cancion o1, Cancion o2) {
                return new Double(o1.GetDuracion()).compareTo(new Double(o2.GetDuracion()));
            }
        });

        if (playList!=null)
        {
            miLista = new ArrayList<>();
            for (Cancion i:playList) {
                String ply = i.GetNombre() + "              " + String.valueOf(i.GetDuracion());
                miLista.add(ply);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, miLista);
            lvLista.setAdapter(adapter);

        }

    }
    public void DescendenteDuracion(View view)
    {
        Collections.sort(playList, new Comparator<Cancion>() {
            @Override
            public int compare(Cancion o1, Cancion o2) {
                return new Double(o2.GetDuracion()).compareTo(new Double(o1.GetDuracion()));
            }
        });

        if (playList!=null)
        {
            miLista = new ArrayList<>();
            for (Cancion i:playList) {
                String ply = i.GetNombre() + "              " + String.valueOf(i.GetDuracion());
                miLista.add(ply);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, miLista);
            lvLista.setAdapter(adapter);

        }
    }
}
