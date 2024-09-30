package com.example.digitalgateopen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalgateopen.DigitalGate.ApiService
import com.example.digitalgateopen.DigitalGate.DigimonFightActivity
import com.example.digitalgateopen.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random
import androidx.appcompat.app.AlertDialog
import com.google.android.material.shape.ShapeAppearanceModel

class MainActivity : ComponentActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var retrofit: Retrofit
    private var axis: Int= 0
    private lateinit var finalIds: MutableList<String>
    private lateinit var ids: MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit= getRetrofit()
        ids= mutableListOf()
        finalIds= mutableListOf()
        binding.tvSign.setOnClickListener {
            //showPopUp()
        }
        initUI()

    }


    private fun showPopUp(){
        val inflater= LayoutInflater.from(this)
        val popUpView= inflater.inflate(R.layout.popup_rules, null)
        val dialogBuilder= AlertDialog.Builder(this).setView(popUpView).setCancelable(true)
        val dialog= dialogBuilder.create()
        dialog.show()

        dialog.setCanceledOnTouchOutside(true)

    }



    private fun checkAxisAndSearch() {
        if (axis == 2) {
            SearchByName(ids)
        }
    }

    private fun initUI() {
        binding.cvBT1.setOnClickListener {
            ids.add("BT1-")
            Log.i("gg", ids.toString())
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT2.setOnClickListener {
            ids.add("BT2-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT3.setOnClickListener {
            ids.add("BT3-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT4.setOnClickListener {
            ids.add("BT4-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT5.setOnClickListener {
            ids.add("BT5-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT6.setOnClickListener {
            ids.add("BT6-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT7.setOnClickListener {
            ids.add("BT7-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT8.setOnClickListener {
            ids.add("BT8-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT9.setOnClickListener {
            ids.add("BT9-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT10.setOnClickListener {
            ids.add("BT10-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT11.setOnClickListener {
            ids.add("BT11-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT12.setOnClickListener {
            ids.add("BT12-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT13.setOnClickListener {
            ids.add("BT13-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT14.setOnClickListener {
            ids.add("BT14-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT15.setOnClickListener {
            ids.add("BT15-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT16.setOnClickListener {
            ids.add("BT16-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT17.setOnClickListener {
            ids.add("BT17-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT18.setOnClickListener {
            ids.add("BT18-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvBT19.setOnClickListener {
            ids.add("BT19-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvEX1.setOnClickListener {
            ids.add("EX1-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvEX2.setOnClickListener {
            ids.add("EX2-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvEX3.setOnClickListener {
            ids.add("EX3-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvEX4.setOnClickListener {
            ids.add("EX4-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvEX5.setOnClickListener {
            ids.add("EX5-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvEX6.setOnClickListener {
            ids.add("EX6-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvEX7.setOnClickListener {
            ids.add("EX7-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvEX8.setOnClickListener {
            ids.add("EX8-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvLM.setOnClickListener {
            ids.add("LM-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvMD.setOnClickListener {
            ids.add("MD-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvP.setOnClickListener {
            ids.add("P-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvRB1.setOnClickListener {
            ids.add("RB1-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvST1.setOnClickListener {
            ids.add("ST1-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvST2.setOnClickListener {
            ids.add("ST2-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvST3.setOnClickListener {
            ids.add("ST3-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvST4.setOnClickListener {
            ids.add("ST4-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvST5.setOnClickListener {
            ids.add("ST5-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvST6.setOnClickListener {
            ids.add("ST6-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvST7.setOnClickListener {
            ids.add("ST7-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvST8.setOnClickListener {
            ids.add("ST8-")
            axis++
            checkAxisAndSearch()
        }
        binding.cvST9.setOnClickListener {
            ids.add("ST9-")
            axis++
            checkAxisAndSearch()
        }
    }

    private fun SearchByName(query: List<String>) {
        CoroutineScope(Dispatchers.IO).launch{
            val n= query
            val myResponseA= retrofit.create(ApiService::class.java).getDigimon(n[0])
            Log.i("gg", myResponseA.toString())
            if (myResponseA.isSuccessful) {
                Log.i("gg", myResponseA.toString())
                val responseA= myResponseA.body()
                val randA= Random.nextInt(0, responseA!!.size)
                val idA= responseA!![randA].Id
                Log.i("gg", idA.toString())
                if (idA != null) {
                    finalIds.add(idA)
                }
            }
            val myResponseD= retrofit.create(ApiService::class.java).getDigimon(n[1])
            Log.i("gg", myResponseD.toString())
            if(myResponseD.isSuccessful){
                Log.i("gg", myResponseD.toString())
                val responseD= myResponseD.body()
                val randD= Random.nextInt(0, responseD!!.size)
                val idD= responseD!![randD].Id
                Log.i("gg", idD.toString())
                if (idD != null) {
                    finalIds.add(idD)
                }
            }
            navigateToDetail(finalIds)
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://digimoncard.io/api-public/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun navigateToDetail(ids: List<String>){
        val intent= Intent(this, DigimonFightActivity::class.java)
        intent.putExtra("idA", ids[0])
        intent.putExtra("idD", ids[1])
        startActivity(intent)
    }
}