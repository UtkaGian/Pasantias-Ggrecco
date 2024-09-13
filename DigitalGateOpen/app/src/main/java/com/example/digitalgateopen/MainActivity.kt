package com.example.digitalgateopen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.widget.SearchView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalgateopen.databinding.ActivityMainBinding
import com.example.digitalgateopen.ui.theme.DigitalGateOpenTheme
import retrofit2.Retrofit

class MainActivity : ComponentActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: DigimonListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun initUI() {
        binding.svDigimons.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.i("gg", "$query")
                SearchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
        adapter= MovieListAdapter{ navigateToDetail(it) }
        binding.rvDigimons.setHasFixedSize(true)
        binding.rvDigimons.layoutManager= LinearLayoutManager(this)
        binding.rvDigimons.adapter= adapter
    }
}