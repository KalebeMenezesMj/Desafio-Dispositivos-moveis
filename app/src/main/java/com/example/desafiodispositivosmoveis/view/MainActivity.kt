package com.example.desafiodispositivosmoveis.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.desafiodispositivosmoveis.R
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val usuario1 ="Linux"
        val senha1 = 123

        val usuario : EditText = findViewById(R.id.edt_usuario)
        val senha: EditText = findViewById(R.id.edt_senha)
        val botaoLogar: Button = findViewById(R.id.btn_login)

        botaoLogar.setOnClickListener {

            val usuarioDigitado = usuario.text.toString()
            val senhaDigitada = senha.text.toString()

            if (usuarioDigitado == usuario1 && senhaDigitada == senha1.toString()){
                Toast.makeText(this, "Seja Bem Vindo", Toast.LENGTH_SHORT).show()

                // --- COMANDO PARA PASSAR DE TELA ---
                // Troque 'SegundaActivity' pelo nome da sua classe da 2ª tela
                val intent = Intent(this, ListaActivity::class.java)
                startActivity(intent)

                // Finaliza a MainActivity para o usuário não voltar ao login ao apertar 'voltar'
                finish()

            } else {
                // Agora o erro só aparece se o login falhar
                Toast.makeText(this, "Usuário ou senha Inválido", Toast.LENGTH_SHORT).show()
            }
        }

    }
}