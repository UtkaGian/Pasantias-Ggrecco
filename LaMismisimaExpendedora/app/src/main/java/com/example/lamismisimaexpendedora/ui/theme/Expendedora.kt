package com.example.lamismisimaexpendedora.ui.theme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lamismisimaexpendedora.R

class Expendedora : AppCompatActivity() {

    private lateinit var btn50Cent: Button
    private lateinit var btn25Cent: Button
    private lateinit var btn10Cent: Button
    private lateinit var btn5Cent: Button
    private lateinit var btnSelect: Button
    private lateinit var input: EditText
    private var Plata=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_expender)
        initResources()
        losListenners()
    }
    private fun initResources(){
        btn50Cent=findViewById<Button>(R.id.Cent50btn)
        btn25Cent=findViewById<Button>(R.id.Cent25btn)
        btn10Cent=findViewById<Button>(R.id.Cent10btn)
        btn5Cent=findViewById<Button>(R.id.Cent5btn)
        btnSelect=findViewById<Button>(R.id.Sendbtn)
        input=findViewById<EditText>(R.id.Input)
    }
    private fun losListenners(){
        btn50Cent.setOnClickListener{
            Plata+= 50
        }
        btn25Cent.setOnClickListener{
            Plata+=25
        }
        btn10Cent.setOnClickListener{
            Plata+=10
        }
        btn5Cent.setOnClickListener{
            Plata+=5
        }
        val code=input.text.toString()
        btnSelect.setOnClickListener{
            val intent2= Intent(this, Reward::class.java)
            startActivity(intent2)
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
