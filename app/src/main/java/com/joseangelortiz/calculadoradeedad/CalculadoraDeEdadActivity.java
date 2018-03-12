package com.joseangelortiz.calculadoradeedad;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.app.DatePickerDialog;
import android.view.View;
import android.app.Dialog;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.Toast;

public class CalculadoraDeEdadActivity extends AppCompatActivity implements OnClickListener {

    TextView textoFechaActual, textoFechaSeleccionada, textoResultado;
    Button botonCalcular;

    static final int Fecha = 0;
    private int fechaAno = 1985;
    private int fechaMes = 7;
    private int fechaDia = 20;
    private CalcularEdad edad = null;

    private Typeface bauhaus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_de_edad);

        textoFechaActual = findViewById(R.id.textoFechaActual);
        textoFechaSeleccionada = findViewById(R.id.textoFechaSeleccionada);
        textoResultado = findViewById(R.id.textoResultado);
        botonCalcular = findViewById(R.id.botonCalcular);

        edad = new CalcularEdad();
        textoFechaActual = findViewById(R.id.textoFechaActual);
        textoFechaActual.setText("Fecha actual: " + edad.getFechaActual());
        textoFechaSeleccionada = findViewById(R.id.textoFechaSeleccionada);
        textoResultado = findViewById(R.id.textoResultado);
        botonCalcular = findViewById(R.id.botonCalcular);
        botonCalcular.setOnClickListener(this);

        String fuente = "fuentes/bauhaus93.ttf";

        this.bauhaus = Typeface.createFromAsset(getAssets(), fuente);

        textoFechaActual.setTypeface(bauhaus);
        textoFechaSeleccionada.setTypeface(bauhaus);
        textoResultado.setTypeface(bauhaus);
        botonCalcular.setTypeface(bauhaus);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case Fecha:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        fechaAno, fechaMes, fechaDia);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener
            = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            fechaAno = selectedYear;
            fechaMes = selectedMonth;
            fechaDia = selectedDay;
            edad.setFechaNacimiento(fechaAno, fechaMes, fechaDia);
            textoFechaSeleccionada.setText("Fecha de nacimiento: " + selectedDay + "/" + (fechaMes + 1) + "/" + fechaAno);
            calcularEdad();
        }
    };

    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.botonCalcular:
                showDialog(Fecha);
                break;

            default:
                break;
        }
    }

    private void calcularEdad() {
        edad.calcularAno();
        edad.calcularMes();
        edad.calcularDia();
        Toast.makeText(getBaseContext(), "Fecha seleccionada.", Toast.LENGTH_SHORT).show();
        textoResultado.setText("Edad = " + edad.getResultado());
    }

}



