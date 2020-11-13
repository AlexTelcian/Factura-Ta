package com.AT.FacturaTa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculFactura extends AppCompatActivity {

    private TextView valoare1, suma1,valoareCantitate;
    private EditText pretUnitTXT, cantitateTXT,tvaTXT,markupTXT;
    private Button calculeaza,reset;
    private float floatVal;
    private double pretUnitar,suma,valoarePret,tvaDouble,markupDouble;;
    private int sumaFactura,cantitateINT,valoareCantitateINT,sumaValoare,index;
    private String pret,cantitate,nouaValoareView,valCantView,SumaTotView,tva,markup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul_factura);


        pretUnitTXT = findViewById(R.id.PretUnitar);
        cantitateTXT = findViewById(R.id.Cantitate);
        tvaTXT = findViewById(R.id.TVA);
        markupTXT = findViewById(R.id.markup);

        valoare1 = findViewById(R.id.sumaValoare);
        valoareCantitate = findViewById(R.id.ValoareCantitate);
        suma1 = findViewById(R.id.sumaTotalaFactura);

        calculeaza = findViewById(R.id.btnCalculeaza);
        reset = findViewById(R.id.btnReset);

        calculeaza.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pret = pretUnitTXT.getText().toString();
                pret = pret.replace(",",".");
                cantitate = cantitateTXT.getText().toString();
                tva = tvaTXT.getText().toString();
                markup = markupTXT.getText().toString();

                if (markup.length() == 0)
                    markupTXT.setHint("necompletat");
                else
                    index++;
                if (tva.length() == 0)
                    tvaTXT.setHint("necompletat");
                else
                    index++;
                if (pretUnitTXT.length() == 0)
                    pretUnitTXT.setHint("necompletat");
                else
                    index++;
                if (cantitateTXT.length() == 0)
                    cantitateTXT.setHint("necompletat");
                else
                    index++;

                if (index >= 4) {
                    pretUnitar = Double.valueOf(pret);
                    cantitateINT = Integer.valueOf(cantitate);
                    tvaDouble = Double.valueOf(tva);
                    markupDouble = Double.valueOf(markup);

                    markupDouble = markupDouble / 100;
                    tvaDouble = tvaDouble / 100;

                    valoarePret = pretUnitar + (pretUnitar * markupDouble);
                    valoarePret = valoarePret + (valoarePret * tvaDouble);
                    sumaValoare = (int) Math.round(valoarePret);
                    nouaValoareView = String.valueOf(sumaValoare);
                    valoare1.setText(nouaValoareView);

                    cantitateINT = Integer.valueOf(cantitate);
                    valoareCantitateINT = sumaValoare * cantitateINT;
                    valCantView = String.valueOf(valoareCantitateINT);
                    valoareCantitate.setText(valCantView);

                    sumaFactura = sumaFactura + valoareCantitateINT;
                    SumaTotView = String.valueOf(sumaFactura);
                    suma1.setText(SumaTotView);
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                pretUnitar = 0;
                sumaValoare = (int)Math.round(pretUnitar);
                nouaValoareView = String.valueOf(sumaValoare);
                valoare1.setText(nouaValoareView);

                cantitateINT = 0;
                valCantView = String.valueOf(cantitateINT);
                valoareCantitate.setText(valCantView);

                sumaFactura = 0;
                SumaTotView = String.valueOf(sumaFactura);
                suma1.setText(SumaTotView);

            }
        });


    }
}