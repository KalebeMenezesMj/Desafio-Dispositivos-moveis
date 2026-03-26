package com.example.desafiodispositivosmoveis.model

class DestinoTuristicoDaoImpl : DestinoTuristicoDao {

    companion object{
        private val destinosTuristicos = mutableListOf<DestinoTuristico>()
    }

    override fun postDestinoTuristico(destinoTuristico: DestinoTuristico) {
        destinosTuristicos.add(destinoTuristico)
    }

    override fun getDestinoTuristico(): List<DestinoTuristico> {
        return destinosTuristicos
    }

}