package com.example.calculadora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etOper1;
    EditText etOper2;
    TextView txtResult;
    Spinner spn;

    private Calculadora calculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculadora = new Calculadora();

        etOper1 = findViewById(R.id.etOper1);
        etOper2 = findViewById(R.id.etOper2);
        spn = findViewById(R.id.spn);
        txtResult = findViewById(R.id.txtRes);

        // Configuramos el Spinner
        // Tomamos sus valores posibles del array de strings "operacioneArray", definido
        // en string.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operacionesArray,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);
    }

    public void calcula(View view) {
        String str1 = etOper1.getText().toString();
        String str2 = etOper2.getText().toString();

        if (str1.isEmpty() || str2.isEmpty()) {
            txtResult.setText((""));

        } else {
            double o1 = Double.parseDouble(str1);
            double o2 = Double.parseDouble(str2);
            String operacion = spn.getSelectedItem().toString();

            calculadora.setOper1(o1);
            calculadora.setOper2(o2);
            calculadora.setOperacion(Calculadora.OPERACION.fromSymbol(operacion));
            double result = calculadora.opera();

            txtResult.setText(String.valueOf(result));
        }
    }
}