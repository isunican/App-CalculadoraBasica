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
        // Tomamos sus valores posibles del array de strings "operacionesArray", definido
        // en string.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operacionesArray,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);
    }

    /**
     * Método que tenemos que definir para que se muestre el menú de opciones en esta
     * actividad. El menú de opciones es el menú con un icono de 3 puntos que aparece en la parte
     * superior izquierda de la pantalla
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Método que se va a llamar automáticamente al pulsar sobre cualquier item del menú de opciones
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItemAvanzada:
                Intent intent = new Intent(this, AvanzadaActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Listener del boton Calcular. La asignacion de este listener con el boton se realiza en el
     * layout: atributo onclick del boton
     * @param view
     */
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

    /**
     * Listener del boton Avanzada. La asignacion de este listener con el boton se realiza en el
     * layout: atributo onclick del boton
     * @param view
     */
    public void goToAvanzada(View view) {
        Intent intent = new Intent(this, AvanzadaActivity.class);
        startActivity(intent);
    }
}