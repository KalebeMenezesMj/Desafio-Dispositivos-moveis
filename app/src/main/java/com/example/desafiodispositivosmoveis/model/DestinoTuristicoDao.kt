package com.example.desafiodispositivosmoveis.model

interface DestinoTuristicoDao {
    fun postDestinoTuristico(destinoTuristico: DestinoTuristico)
    fun getDestinoTuristico(): List<DestinoTuristico>
}