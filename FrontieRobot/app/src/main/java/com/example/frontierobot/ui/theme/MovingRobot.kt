package com.example.frontierobot.ui.theme

import android.content.res.Resources.Theme
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.frontierobot.R

class MovingRobot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_moving_robot)
        val coordx= intent.extras?.getInt("CoordX")
        val coordy= intent.extras?.getInt("CoordY")
        val Ordis= findViewById<ImageView>(R.id.Ordis)
        val params= Ordis.layoutParams as RelativeLayout.LayoutParams
        if (coordx != null) {
            params.leftMargin= coordx
        }
        if (coordy != null) {
            params.topMargin= coordy
        }
        Ordis.layoutParams= params
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