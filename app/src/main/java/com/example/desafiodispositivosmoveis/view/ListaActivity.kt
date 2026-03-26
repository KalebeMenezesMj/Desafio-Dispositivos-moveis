package com.example.desafiodispositivosmoveis.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiodispositivosmoveis.R
import com.example.desafiodispositivosmoveis.adapter.DestinoTurismoAdapter
import com.example.desafiodispositivosmoveis.model.DestinoTuristicoDaoImpl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaActivity : AppCompatActivity(R.layout.activity_lista) {
    private val dao = DestinoTuristicoDaoImpl()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val rvDestino: RecyclerView = findViewById(R.id.rv_destinos)
        val destinos= dao.getDestinoTuristico()

        rvDestino.layoutManager = LinearLayoutManager(this)
        rvDestino.adapter = DestinoTurismoAdapter(destinos)



    }
}