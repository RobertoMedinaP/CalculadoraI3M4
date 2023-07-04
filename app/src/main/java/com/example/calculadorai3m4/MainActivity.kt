package com.example.calculadorai3m4

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // se crean var null, al ser var pueden cambiar
    //ya no hay ; para finalizar línea
    private var et1: EditText? = null
    private var et2: EditText? = null
    private var tv1: TextView? = null
    private var bt1: Button? = null
    private var bt2: Button? = null
    private var bt3: Button? = null
    private var bt4: Button? = null
    private var bt5: Button? = null

    //función onCreate, Kotlin usa mucho las funciones
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("Info","Llegamos a onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Se llaman los métodos
        vistas()
        clicks()
        //Al boton 5 le doy el salir, al set on click se le da el new que sobrescribe
        bt5!!.setOnClickListener { // y acá se le da la salida
            finish()
        }
    }

    //los metodos ahora son funciones
    fun vistas() {
        //la definicion cambia, as Button
        bt1 = findViewById<View>(R.id.bt1) as Button
        bt2 = findViewById<View>(R.id.bt2) as Button
        bt3 = findViewById<View>(R.id.bt3) as Button
        bt4 = findViewById<View>(R.id.bt4) as Button
        //agrego el boton 5 salir
        bt5 = findViewById<View>(R.id.bt5) as Button
        et1 = findViewById<View>(R.id.et1) as EditText
        et2 = findViewById<View>(R.id.et2) as EditText
        tv1 = findViewById<View>(R.id.tv1) as TextView
    }

    fun validacion(): Boolean {
        /* la idea es crear un metodo que vea si hay campos vacios y llamar este método en los
        metodos del click(para las operaciones aritméticas)
         */

        // se crea variable booleana para asignar verdadero
        var estavacio = true

        // las validaciones se hacen dentro de if por campo
        estavacio = if (et1!!.text.toString().isEmpty()) {
            true
        } else if (et2!!.text.toString().isEmpty()) {
            true
        } else {
            false
        }
        return estavacio
    }

    // Se hacen los metodos por cada boton
    fun clicks() {
        Log.i("Info", "Metodo de captura de clicks")
        //bt1!! para escuchar el click
        bt1!!.setOnClickListener { // acá meteré el metodo de la suma, se parsean los et
            //Integer.parseINT pasa a entero
            //gettext().tostring saca el texto lo pasa a string

            /* El metodo va dentro de un if que comprueba que los campos no esten vacios segun el
                metodo validacion
                 */
            if (!validacion()) {
                //val ya que su valor cambia
                val suma = et1!!.text.toString().toInt() + et2!!.text.toString().toInt()
                tv1!!.text = "El resultado es: $suma"
            } else {
                Toast.makeText(this@MainActivity, "Ingrese un numero", Toast.LENGTH_SHORT).show()
            }
        }
        bt2!!.setOnClickListener { // el metodo de la resta
            if (!validacion()) {
                val resta = et1!!.text.toString().toInt() - et2!!.text.toString().toInt()
                tv1!!.text = "El resultado es: $resta"
            } else {
                Toast.makeText(this@MainActivity, "Ingrese un numero", Toast.LENGTH_SHORT).show()
            }
        }
        bt3!!.setOnClickListener { //metodo multiplicacion
            if (!validacion()) {
                val multiplicacion = et1!!.text.toString().toInt() * et2!!.text.toString().toInt()
                tv1!!.text = "El resultado es: $multiplicacion"
            } else {
                Toast.makeText(this@MainActivity, "Ingrese un numero", Toast.LENGTH_SHORT).show()
            }
        }
        bt4!!.setOnClickListener {
            if (!validacion()) {
                // metodo division con try catch para division por cero
                try {
                    val division = et1!!.text.toString().toInt() / et2!!.text.toString().toInt()
                    tv1!!.text = "El resultado es: $division"
                } catch (e: ArithmeticException) {
                    tv1!!.text = "No se puede dividir por 0"
                }
            } else {
                Toast.makeText(this@MainActivity, "Ingrese un numero", Toast.LENGTH_SHORT).show()
            }
        }
    }
}