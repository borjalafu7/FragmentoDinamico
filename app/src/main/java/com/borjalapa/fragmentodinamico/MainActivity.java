package com.borjalapa.fragmentodinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //para manejar los fragmentos
        fragmentManager = getSupportFragmentManager();

        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.contenedor_fragments, new FragmentInicio());
        //no se cierra la aplicacion dandole a la flechita de atras
        transaction.addToBackStack(null);

        //para finalizar la transaccion
        transaction.commit();
    }

    public void onClick(View view) {
        transaction = fragmentManager.beginTransaction();
        switch (view.getId()){
            case R.id.btnIrAzul:
                //pasamos un texto para actualizar el texto del fragmento azul
                transaction.replace(R.id.contenedor_fragments, FragmentAzul.newInstance("Esto es el título", null));
                break;
            case R.id.btnIrRojo:
                transaction.replace(R.id.contenedor_fragments, new FragmentRojo());
                break;
        }

        //para finalizar la transaccion
        transaction.addToBackStack(null);
        transaction.commit();
    }
}