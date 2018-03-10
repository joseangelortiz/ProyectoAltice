package com.joseangelortiz.calculadoradeedad;

import android.app.DatePickerDialog;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CalculadoraDeEdadActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textoReciente, textoAntigua, textoResultado;
    Button botonFechaReciente, botonFechaAntigua, botonCalcular;
    int diaReciente, mesReciente, anoReciente, diaAntiguo, mesAntiguo, anoAntiguo;

    private Typeface bauhaus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_de_edad);

        textoReciente = (TextView) findViewById(R.id.textoReciente);
        textoAntigua = (TextView) findViewById(R.id.textoAntigua);
        textoResultado = (TextView) findViewById(R.id.textoResultado);

        botonFechaReciente = (Button) findViewById(R.id.botonFechaReciente);
        botonFechaAntigua = (Button) findViewById(R.id.botonFechaAntigua);
        botonCalcular = (Button) findViewById(R.id.botonCalcular);

        botonFechaReciente.setOnClickListener(this);
        botonFechaAntigua.setOnClickListener(this);
        botonCalcular.setOnClickListener(this);

        String fuente = "fuentes/bauhaus93.ttf";

        this.bauhaus = Typeface.createFromAsset(getAssets(), fuente);

        textoReciente.setTypeface(bauhaus);
        textoAntigua.setTypeface(bauhaus);
        textoResultado.setTypeface(bauhaus);
        botonFechaReciente.setTypeface(bauhaus);
        botonFechaAntigua.setTypeface(bauhaus);
        botonCalcular.setTypeface(bauhaus);

    }

    @Override
    public void onClick(View view) {

        if (view == botonFechaReciente) {
            Calendar calendar = Calendar.getInstance();
            diaReciente = calendar.get(calendar.DAY_OF_MONTH);
            mesReciente = calendar.get(calendar.MONTH);
            anoReciente = calendar.get(calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

                    textoReciente.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                }
            }, diaReciente, mesReciente, anoReciente);
            datePickerDialog.show();
        }
        if (view == botonFechaAntigua) {
            Calendar calendar = Calendar.getInstance();
            diaAntiguo = calendar.get(calendar.DAY_OF_MONTH);
            mesAntiguo = calendar.get(calendar.MONTH);
            anoAntiguo = calendar.get(calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view2, year2, monthOfYear2, dayOfMonth2) -> {

                textoAntigua.setText(dayOfMonth2 + "/" + (monthOfYear2 + 1) + "/" + year2);
            }, diaAntiguo, mesAntiguo, anoAntiguo);

            datePickerDialog.show();
        }
        if (view == botonCalcular) {
            int resta = diaReciente - diaAntiguo;
            String resu = String.valueOf(resta);
            textoResultado.setText(resu);
        }

    }
}



