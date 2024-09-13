package com.example.digitalgateopen

import android.content.Intent
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
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalgateopen.DigitalGate.ApiService
import com.example.digitalgateopen.DigitalGate.DigimonListAdapter
import com.example.digitalgateopen.databinding.ActivityMainBinding
import com.example.digitalgateopen.ui.theme.DigitalGateOpenTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
        adapter= DigimonListAdapter{ navigateToDetail(it) }
        binding.rvDigimons.setHasFixedSize(true)
        binding.rvDigimons.layoutManager= LinearLayoutManager(this)
        binding.rvDigimons.adapter= adapter
    }

    private fun SearchByName(query: String){
        binding.progressBar.isVisible= true
        CoroutineScope(Dispatchers.IO).launch{
            val myResponse= retrofit.create(ApiService::class.java).getDigimon(query)
            if (myResponse.isSuccessful){
                val response= myResponse.body()
                if (response!=null){
                    Log.i("gg", response.toString())
                    withContext(Dispatchers.Main){
                        binding.progressBar.isVisible=false
                        adapter.updateList(response)
                    }
                }
                Log.i("gg", "works :)")

            }else{
                withContext(Dispatchers.Main){
                    Log.i("gg", "not works :(")
                }
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun navigateToDetail(id:Int){
        val intent= Intent(this, DetailDigimonActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }
}