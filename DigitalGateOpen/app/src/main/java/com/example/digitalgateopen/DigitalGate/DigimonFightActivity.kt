package com.example.digitalgateopen.DigitalGate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.digitalgateopen.MainActivity
import com.example.digitalgateopen.databinding.ActivityDigimonFightBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.squareup.picasso.Picasso

class DigimonFightActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDigimonFightBinding
    private lateinit var retrofit: Retrofit
    private lateinit var DigimonA:String
    private lateinit var DigimonD:String
    private lateinit var ListID:MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityDigimonFightBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit= getRetrofit()
        DigimonA= intent.getStringExtra("idA")!!
        DigimonD= intent.getStringExtra("idD")!!
        ListID= listOf(DigimonA, DigimonD).toMutableList()
        Picasso.get().load("https://images.digimoncard.io/images/cards/"+DigimonA+".jpg").into(binding.ivA)
        Picasso.get().load("https://images.digimoncard.io/images/cards/"+DigimonD+".jpg").into(binding.ivD)
        binding.cvSTBTN.setOnClickListener { initFight() }

    }
    private fun initFight(){
        Log.i("gg", ListID.toString())
        SearchByName(ListID)
    }
    private fun SearchByName(query: List<String>) {
        CoroutineScope(Dispatchers.IO).launch{
            val n= query
            var dpA: Int? =null
            var color1A= null.toString()
            var color2A= null.toString()
            var dpD: Int? =null
            var color1D= null.toString()
            var color2D= null.toString()
            var AColors:MutableList<String>
            var DColors:MutableList<String>
            AColors= listOf(null.toString()).toMutableList()
            DColors= listOf(null.toString()).toMutableList()
            var myAResponse= retrofit.create(ApiService::class.java).getDigimon(n[0])
            Log.i("gg", myAResponse.toString())
            if (myAResponse.isSuccessful) {
                Log.i("gg", myAResponse.toString())
                val responseA= myAResponse.body()
                dpA= responseA!![0].Dp
                color1A= responseA[0].Color.orEmpty()
                color2A= responseA[0].Color2.orEmpty()
            }
            val myDResponse= retrofit.create(ApiService::class.java).getDigimon(n[1])
            Log.i("gg", myDResponse.toString())
            if(myDResponse.isSuccessful){
                Log.i("gg", myDResponse.toString())
                val responseD= myDResponse.body()
                dpD= responseD!![0].Dp
                color1D= responseD[0].Color.orEmpty()
                color2D= responseD[0].Color2.orEmpty()

            }
            AColors= mutableListOf(color1A, color2A)
            DColors= mutableListOf(color1D, color2D)
            startAttack(dpA, AColors, dpD, DColors)
        }
    }
    private fun startAttack(dpA: Int?, AColors:List<String>, dpD:Int?, DColors:List<String>){
        Log.i("gg", AColors.toString())
        Log.i("gg", DColors.toString())
        val remainingDP = calculateRemainingDP(AColors, DColors, dpA, dpD)
        Log.i("gg", remainingDP.toString())
        runOnUiThread{
            binding.tvResDP.text= remainingDP.toString()
        }
        evaluateBattleOutcome(remainingDP)
        runOnUiThread{
            binding.cvRSTBTN.setOnClickListener {
                val intent= Intent(this, MainActivity::class.java)
                intent.putExtra("axis", 0)
                startActivity(intent)
            }
        }

    }
    fun evaluateBattleOutcome(remainingDP: Int) {
        runOnUiThread {
            when {
                remainingDP > 0 -> binding.tvRes.text= "El Digimon defensor ha sobrevivido y el atacante ha muerto."
                remainingDP < 0 -> binding.tvRes.text= "Digimon defensor ha muerto."
                else -> binding.tvRes.text= "Digimons han muerto."
            }
        }
    }
    private fun calculateRemainingDP(AColors: List<String>, DColors: List<String>, dpA: Int?, dpD: Int?): Int {
        val effectiveness = calculateEffectiveness(AColors, DColors)
        var DPA=0
        if(dpA!=null){
            DPA=dpA
        }
        var DPD=0
        if(dpD!=null){
            DPD=dpD
        }
        return DPD - (DPA * effectiveness).toInt()
    }
    fun calculateEffectiveness(AColors: List<String>, DColors: List<String>): Double {
        var effectiveness = 1.0
        for (attackerColor in AColors) {
            for (defenderColor in DColors) {
                effectiveness *= when {
                    isStrongAgainst(attackerColor, defenderColor) -> 2.0
                    isWeakAgainst(attackerColor, defenderColor) -> 0.5
                    else -> 1.0
                }
            }
        }

        return when {
            effectiveness == 4.0 -> 4.0 // Ultra efectivo
            effectiveness == 2.0 -> 2.0 // Súper efectivo
            effectiveness < 1.0 -> effectiveness // Menos de 1 para no efectivo
            else -> 1.0 // Neutral
        }
    }


    fun isStrongAgainst(attacker: String, defender: String): Boolean {
        return when (attacker) {
            "Rojo" -> defender == "Verde"
            "Azul" -> defender == "Rojo"
            "Amarillo" -> defender == "Azul"
            "Morado" -> defender == "Amarillo"
            "Blanco" -> defender == "Morado"
            "Negro" -> defender == "Blanco"
            "Verde" -> defender == "Negro"
            else -> false
        }
    }
    fun isWeakAgainst(attacker: String, defender: String): Boolean {
        return when (attacker) {
            "Rojo" -> defender == "Azul"
            "Azul" -> defender == "Amarillo"
            "Amarillo" -> defender == "Morado"
            "Morado" -> defender == "Blanco"
            "Blanco" -> defender == "Negro"
            "Negro" -> defender == "Verde"
            "Verde" -> defender == "Rojo"
            else -> false
        }
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://digimoncard.io/api-public/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}