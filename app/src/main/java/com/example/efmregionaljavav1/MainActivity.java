package com.example.efmregionaljavav1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText poids ;
    EditText taille ;
    Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taille	=findViewById(R.id.taille);
        poids 	=findViewById(R.id.poids);
        btn	=findViewById(R.id.ok);

        btn.setOnClickListener(btnListener);

    }
    private View.OnClickListener btnListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            String t = taille.getText().toString(); //On récupère la taille saisie par l'utilisateur et on l'affecte à la variable t
            String p = poids.getText().toString(); //On récupère le poid saisie par l'utilisateur et on l'affecte à la variable p
            float tValue = Float.valueOf(t); //On transforme la valeur que contient t en float et on l'affecte à la variable tValue
            float pValue = Float.valueOf(p); //On trans
            tValue = (float)Math.pow(tValue, 2);
            float imc = pValue / tValue; //Calcule de l'IMC
            imc = (float)Math.round(imc*100)/100; //Arrondie à 2 chiffres après la virgule.
            //On verifie si un des champ est vide
            if (taille.getText().toString().isEmpty() || poids.getText().toString().isEmpty()){

                //Message d'erreur si un des champs est vide.
                Resources message = getResources();
                Toast.makeText(MainActivity.this, message.getString(R.string.toast_message_erreur_saisie), Toast.LENGTH_LONG).show();
            }
            else if (imc<18.5){
                Resources message = getResources();
                Toast.makeText(MainActivity.this, message.getString(R.string.Maigreur), Toast.LENGTH_LONG).show();

            }
            else if (imc>18.5||imc<25){
                Resources message = getResources();
                Toast.makeText(MainActivity.this, message.getString(R.string.Normal), Toast.LENGTH_LONG).show();
            }
            else if (imc>25||imc<40){
                Resources message = getResources();
                Toast.makeText(MainActivity.this, message.getString(R.string.Surpoids), Toast.LENGTH_LONG).show();
            }
            else if (imc>=40){
                Resources message = getResources();
                Toast.makeText(MainActivity.this, message.getString(R.string.Obesite), Toast.LENGTH_LONG).show();
            }
        }
    };


}