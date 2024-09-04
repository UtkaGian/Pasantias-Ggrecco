package com.example.lamismisimaexpendedora

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
import com.example.lamismisimaexpendedora.ui.theme.LaMismisimaExpendedoraTheme
import com.example.lamismisimaexpendedora.ui.theme.Expendedora

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnStart= findViewById<Button>(R.id.Startbtn)
        btnStart.setOnClickListener {
            val intent = Intent(this, Expendedora::class.java)
            startActivity(intent)
        }

    }
}

/*enableEdgeToEdge()
          setContent {
            LaMismisimaExpendedoraTheme {
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
    LaMismisimaExpendedoraTheme {
        Greeting("Android")
    }
}

*/