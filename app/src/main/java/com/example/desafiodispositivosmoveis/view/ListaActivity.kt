package com.example.desafiodispositivosmoveis.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiodispositivosmoveis.R
import com.example.desafiodispositivosmoveis.adapter.DestinoTurismoAdapter
import com.example.desafiodispositivosmoveis.model.DestinoTuristico
import com.example.desafiodispositivosmoveis.model.DestinoTuristicoDaoImpl

class ListaActivity : AppCompatActivity(R.layout.activity_lista_destinos) {
    private val dao = DestinoTuristicoDaoImpl()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnVoltar = findViewById<Button>(R.id.btn_voltar_cadastro)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, CadastroDestinoActivity::class.java)
            startActivity(intent)
            finish()
        }

        val rvDestino: RecyclerView = findViewById(R.id.rv_destinos)
        val destinos= dao.getDestinoTuristico()

        rvDestino.layoutManager = LinearLayoutManager(this)
        rvDestino.adapter = DestinoTurismoAdapter(destinos as MutableList<DestinoTuristico>)




    }
}