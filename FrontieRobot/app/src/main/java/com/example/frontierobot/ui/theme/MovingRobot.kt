package com.example.frontierobot.ui.theme

import android.content.res.Resources.Theme
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.frontierobot.R
import kotlinx.coroutines.delay



class MovingRobot : AppCompatActivity() {

    private val coords= arrayOf(
        Pair(15, 25),
        Pair(25, 30),
        Pair(-10, 45),
        Pair(-5, 60)
    )
    private var index=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_moving_robot)
        val btnContinue= findViewById<Button>(R.id.Next)
        val Ordis= findViewById<ImageView>(R.id.Ordis)
        val params= Ordis.layoutParams as RelativeLayout.LayoutParams
        btnContinue.setOnClickListener{
            val (x, y)= coords[index]
            if(index<coords.size){
                if (x != null) {
                    params.leftMargin= x*10
                }
                if (y != null) {
                    params.topMargin= y*10
                }
                Ordis.layoutParams= params
                index++
            }
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