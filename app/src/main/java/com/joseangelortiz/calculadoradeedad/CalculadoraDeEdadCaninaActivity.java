package com.joseangelortiz.calculadoradeedad;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraDeEdadCaninaActivity extends AppCompatActivity {

    TextView textoTamano, textoEdad, textoResultado;
    Spinner spinnerTamano;
    EditText editTextoEdad;
    Button botonCalcular;

    private Typeface bauhaus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_de_edad_canina);

        textoTamano = findViewById(R.id.textoTamano);
        textoEdad = findViewById(R.id.textoEdad);
        textoResultado = findViewById(R.id.textoResultado);

        spinnerTamano = findViewById(R.id.spinnerTamano);
        String[] items = new String[]{"Menos de 27 cm", "Entre 27 y 53 cm", "Más de 53 cm"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_estilo, items);

        /*adapter.setDropDownViewResource(R.layout.spinner_item_estilo);*/

        spinnerTamano.setAdapter(adapter);

        editTextoEdad = findViewById(R.id.editTextoEdad);
        botonCalcular = findViewById(R.id.botonCalcular);

        String fuente = "fuentes/bauhaus93.ttf";

        this.bauhaus = Typeface.createFromAsset(getAssets(), fuente);
        textoTamano.setTypeface(bauhaus);
        textoEdad.setTypeface(bauhaus);
        textoResultado.setTypeface(bauhaus);
        editTextoEdad.setTypeface(bauhaus);
        botonCalcular.setTypeface(bauhaus);
    }

    /*Metodo del boton*/

    public void Calcular(View view) {
        String Edad_String = editTextoEdad.getText().toString();
        if (editTextoEdad.getText().toString().isEmpty()) {
            textoResultado.setText("El campo de introducir la edad humana, está vacío.");
        } else {

            int Edad_int = Integer.parseInt(Edad_String);

            String seleccion = spinnerTamano.getSelectedItem().toString();

            if (seleccion.equals("Menos de 27 cm")) {
                if (Edad_int != 0) {
                    int val4 = Edad_int * 4;
                    String resultado = String.valueOf(val4);

                    textoResultado.setText("Si fueras perr@ del tamaño elegido, tu edad canina sería de " + resultado + " años.");
                } else {

                    Toast.makeText(this, "No se puede seleccionar 0 como edad humana.", Toast.LENGTH_LONG).show();

                }

            } else if (seleccion.equals("Entre 27 y 53 cm")) {
                if (Edad_int != 0) {
                    int val6 = Edad_int * 6;
                    String resultado = String.valueOf(val6);

                    textoResultado.setText("Si fueras perr@ del tamaño elegido, tu edad canina sería de " + resultado + " años.");
                } else {

                    Toast.makeText(this, "No se puede seleccionar 0 como edad humana.", Toast.LENGTH_LONG).show();

                }
            } else if (seleccion.equals("Más de 53 cm")) {
                if (Edad_int != 0) {
                    int val7 = Edad_int * 7;
                    String resultado = String.valueOf(val7);

                    textoResultado.setText("Si fueras perr@ del tamaño elegido, tu edad canina sería de " + resultado + " años.");

                } else {

                    Toast.makeText(this, "No se puede seleccionar 0 como edad humana.", Toast.LENGTH_LONG).show();

                }
            }

        }

    }
}
