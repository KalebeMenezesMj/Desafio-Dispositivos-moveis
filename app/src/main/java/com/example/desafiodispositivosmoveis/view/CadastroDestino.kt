package com.example.desafiodispositivosmoveis.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.desafiodispositivosmoveis.R
import com.example.desafiodispositivosmoveis.model.DestinoTuristico
import com.example.desafiodispositivosmoveis.model.DestinoTuristicoDaoImpl

class CadastroDestinoActivity : AppCompatActivity() {

    private val dao = DestinoTuristicoDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_destino)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtPais = findViewById<EditText>(R.id.edt_pais)
        val edtUrl = findViewById<EditText>(R.id.edt_url)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val tvVerLista = findViewById<TextView>(R.id.tv_ver_lista)

        btnSalvar.setOnClickListener {
            val nome = edtNome.text.toString()
            val pais = edtPais.text.toString()
            val url = edtUrl.text.toString()

            if (nome.isNotEmpty() && pais.isNotEmpty() && url.isNotEmpty()) {
                val novoDestino = DestinoTuristico(nome, pais, url)
                dao.postDestinoTuristico(novoDestino)

                Toast.makeText(this, "Destino salvo com sucesso!", Toast.LENGTH_SHORT).show()

                edtNome.text.clear()
                edtPais.text.clear()
                edtUrl.text.clear()
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        tvVerLista.setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }
    }
}