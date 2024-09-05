package com.example.lamismisimaexpendedora.ui.theme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.text.toUpperCase
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lamismisimaexpendedora.R

class Reward : AppCompatActivity() {

    private lateinit var Object:TextView
    private lateinit var Cash:TextView
    private lateinit var Code:String
    private lateinit var RESTART:Button
    private var Money:Int=0
    private var Retorno:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reward)
        initTexts()
        Code= intent.extras?.getString("Code").toString()
        Money= intent.extras?.getInt("Cash")!!
        printer()
        val intent3= Intent(this, Expendedora::class.java)
        RESTART.setOnClickListener{
            startActivity(intent3)
        }
    }
    private fun initTexts(){
        Object=findViewById<TextView>(R.id.Object)
        Cash=findViewById<TextView>(R.id.Cash)
        RESTART=findViewById<Button>(R.id.RESTARTbtn)
    }
    private fun printer(){
        Code.toUpperCase()
        Retorno=Money
        if(Code=="AA") {
            if (Money >= 335) {
                Object.text = "Usted pidió una Coca-Cola"
                Retorno = Money - 335
                Cash.text = "Se retornan: '$'$Retorno'ARS'"
            } else {
                Object.text = "Saldo insuficiente"
                Cash.text = "Se retornan: '$'$Retorno'ARS'"
            }
            if (Code == "AB") {
                if (Money >= 315) {
                    Object.text = "Usted pidió una Sprite"
                    Retorno = Money - 315
                    Cash.text = "Se retornan: '$'$Retorno'ARS'"
                } else {
                    Object.text = "Saldo insuficiente"
                    Cash.text = "Se retornan: '$'$Retorno'ARS'"
                }
            }
        }
        if(Code=="BA"){
                if(Money>=350){
                    Object.text="Usted pidió una Fanta"
                    Retorno=Money-350
                    Cash.text="Se retornan: '$'$Retorno'ARS'"
                }else{
                    Object.text="Saldo insuficiente"
                    Cash.text="Se retornan: '$'$Retorno'ARS'"
                }
            }
        if(Code=="BB"){
            if(Money>=250){
                Object.text="Usted pidió Agua"
                Retorno=Money-250
                Cash.text="Se retornan: '$'$Retorno'ARS'"
            }else{
                Object.text="Saldo insuficiente"
                Cash.text="Se retornan: '$'$Retorno'ARS'"
            }
        }
        if(Code=="AC"){
            if(Money>=275){
                Object.text="Usted pidió un Baggio"
                Retorno=Money-275
                Cash.text="Se retornan: '$'$Retorno'ARS'"
            }else{
                Object.text="Saldo insuficiente"
                Cash.text="Se retornan: '$'$Retorno'ARS'"
            }
        }
        if (Code=="CA"){
            if(Money>=375){
                Object.text="Usted pidió una Speed"
                Retorno=Money-375
                Cash.text="Se retornan: '$'$Retorno'ARS'"
            }else{
                Object.text="Saldo insuficiente"
                Cash.text="Se retornan: '$'$Retorno'ARS'"
            }
        }
        if((Code!="AA")&&(Code!="AB")&&(Code!="BA")&&(Code!="BB")&&(Code!="AC")&&(Code!="CA")){
            Object.text="Código inválido"
            Cash.text="Se retornan: '$'$Retorno'ARS'"
        }
    }
}
/*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

*/