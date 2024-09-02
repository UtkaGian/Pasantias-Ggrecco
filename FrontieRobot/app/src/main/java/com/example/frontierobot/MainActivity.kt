package com.example.frontierobot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.frontierobot.ui.theme.FrontieRobotTheme
import com.example.frontierobot.ui.theme.MovingRobot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)
        val btnStart= findViewById<Button>(R.id.PressStartbtn)
        val coordx1= 46
        val coordy= 700
        btnStart.setOnClickListener {
            val intent= Intent(this, MovingRobot::class.java)
            intent.putExtra("CoordX",coordx1 )
            intent.putExtra("CoordY", coordy)
            startActivity(intent)
        }
    }
}



/*
        enableEdgeToEdge()
        setContent {
            FrontieRobotTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FrontieRobotTheme {
        Greeting("Android")
    }
}

 */