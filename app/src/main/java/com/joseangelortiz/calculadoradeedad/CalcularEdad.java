package com.joseangelortiz.calculadoradeedad;

import java.util.Calendar;

public class CalcularEdad {

    private int inicioAno, inicioMes, inicioDia, finAno, finMes, finDia, resultadoAno, resulatadoMes, resultadoDia;
    private Calendar inicio, fin;

    public String getFechaActual() {
        fin = Calendar.getInstance();
        finAno = fin.get(Calendar.YEAR);
        finMes = fin.get(Calendar.MONTH);
        finMes++;
        finDia = fin.get(Calendar.DAY_OF_MONTH);
        return finDia + "/" + finMes + "/" + finAno;
    }

    public void setFechaNacimiento(int iniAno, int iniMes, int iniDia) {
        inicioAno = iniAno;
        inicioMes = iniMes;
        inicioMes++;
        inicioDia = iniDia;

    }

    public void calcularAno() {
        if (finAno <= inicioAno) {
            resultadoAno = 0;
        } else {
            resultadoAno = finAno - inicioAno;
        }
    }

    public void calcularMes() {
        if (finMes >= inicioMes) {
            resulatadoMes = finMes - inicioMes;
        } else {
            resulatadoMes = finMes - inicioMes;
            resulatadoMes = 12 + resulatadoMes;
            resultadoAno--;
        }

    }

    public void calcularDia() {

        if (finDia >= inicioDia) {
            resultadoDia = finDia - inicioDia;
        } else {
            resultadoDia = finDia - inicioDia;
            resultadoDia = 30 + resultadoDia;
            if (resulatadoMes == 0) {
                resulatadoMes = 11;
                resultadoDia--;
            } else {
                resulatadoMes--;
            }

        }
    }

    public String getResultado() {
        if (resultadoAno >= 0) {
            return resultadoAno + " años";
        } else {
            return " No es posible hacer el calculo.";
        }
    }

    public long getSegundos() {
        inicio = Calendar.getInstance();
        inicio.set(Calendar.YEAR, inicioAno);
        inicio.set(Calendar.MONTH, inicioMes);
        inicio.set(Calendar.DAY_OF_MONTH, inicioDia);
        inicio.set(Calendar.HOUR, 12);
        inicio.set(Calendar.MINUTE, 30);
        inicio.set(Calendar.SECOND, 30);
        inicio.set(Calendar.MILLISECOND, 30);
        long fecha2 = fin.getTimeInMillis();
        long fecha1 = inicio.getTimeInMillis();
        long diferencia = fecha1 - fecha2;
        return diferencia / 1000;
    }
}
