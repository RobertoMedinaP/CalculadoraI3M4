package com.example.calculadorai3m4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // se crean las variables para los campos llenados por el usuario a traves de las id
    private EditText et1, et2;
    // se crea variable para el textview donde irá el resultado, por su id tv1
    private TextView tv1;
    // se crea variable para el boton
    private Button bt1,bt2,bt3,bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //funcion para findViewById
// Se crea un metodo que capture el click, se importan las clases button y view

        vistas();
        clicks();

}

//Se hace un metodo que llame textos y boton
public void vistas (){
    bt1 = (Button) findViewById(R.id.bt1);
    bt2 = (Button) findViewById(R.id.bt2);
    bt3 = (Button) findViewById(R.id.bt3);
    bt4 = (Button) findViewById(R.id.bt4);
    et1=(EditText) findViewById(R.id.et1);
    et2=(EditText) findViewById(R.id.et2);
    tv1=(TextView) findViewById(R.id.tv1);
}

// Se hacen los metodos por cada boton
public void clicks(){
    bt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // acá meteré el metodo de la suma, se parsean los et
            //Integer.parseINT pasa a entero
            //gettext().tostring saca el texto lo pasa a string
            int suma=Integer.parseInt(et1.getText().toString())+Integer.parseInt(et2.getText().toString());
            tv1.setText("El resultado es: "+suma);


        }
    });
    bt2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // el metodo de la resta
            int resta=Integer.parseInt(et1.getText().toString())-Integer.parseInt(et2.getText().toString());
            tv1.setText("El resultado es: "+resta);


        }
    });
    bt3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //metodo multiplicacion
            int multiplicacion=Integer.parseInt(et1.getText().toString())*Integer.parseInt(et2.getText().toString());
            tv1.setText("El resultado es: "+multiplicacion);


        }
    });
    bt4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // metodo division con try catch para division por cero
            try {


                int division = Integer.parseInt(et1.getText().toString()) / Integer.parseInt(et2.getText().toString());
                tv1.setText("El resultado es: " + division);
            }
            catch (ArithmeticException e){
                tv1.setText("No se puede dividir por 0");
            }

        }
    });

}

}