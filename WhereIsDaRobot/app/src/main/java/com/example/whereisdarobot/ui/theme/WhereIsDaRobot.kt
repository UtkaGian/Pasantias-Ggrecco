package com.example.whereisdarobot.ui.theme

import android.util.Log
import android.widget.Button
import com.example.whereisdarobot.R

fun main(){
    val pasos= intArrayOf(10, 5, -2)
    val coordenadasFinales=coordsFinales(pasos)
    println("Coordenadas finales: (${coordenadasFinales.first}, ${coordenadasFinales.second})")
}
private fun coordsFinales(pasos: IntArray): Pair<Int, Int>{
    val direcciones= arrayOf(Pair(0, 1), Pair(-1, 0), Pair(0, -1), Pair(1, 0))
    var direccionActual= 0
    var x= 0
    var y= 0
    pasos.forEach { paso ->
        val direccion = direcciones[direccionActual]
        val movimiento = paso * if (paso >= 0) 1 else -1
        x += direccion.first * movimiento
        y += direccion.second * movimiento
        direccionActual = (direccionActual + 1) % 4
    }
    return Pair(x, y)
}
