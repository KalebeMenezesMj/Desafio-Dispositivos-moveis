package com.example.desafiodispositivosmoveis.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiodispositivosmoveis.R
import com.example.desafiodispositivosmoveis.model.DestinoTuristico

class DestinoTurismoAdapter(private val destinosTuristicos: List<DestinoTuristico>) :
    RecyclerView.Adapter<DestinoTurismoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvNomeFilme: TextView = itemView.findViewById(R.id.txv_nome_filme)
        val txvGeneroFilme: TextView = itemView.findViewById(R.id.txv_genero_filme)
        val cbAssistido: CheckBox = itemView.findViewById(R.id.cb_assistido)
        val edtNota: EditText = itemView.findViewById(R.id.edt_nota_filme)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = filmes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = filmes[position]

        // Remove listeners antigos para evitar comportamento fantasma ao reciclar a view
        holder.cbAssistido.setOnCheckedChangeListener(null)

        holder.txvNomeFilme.text = filme.nome
        holder.txvGeneroFilme.text = filme.genero
        holder.cbAssistido.isChecked = filme.assistido

        // Exibe a nota salva se já existir
        holder.edtNota.setText(if (filme.nota > 0) filme.nota.toString() else "")
        holder.edtNota.visibility = if (filme.assistido) View.VISIBLE else View.GONE

        // Lógica do CheckBox (Assistido)
        holder.cbAssistido.setOnCheckedChangeListener { _, isChecked ->
            filme.assistido = isChecked
            if (isChecked) {
                holder.edtNota.visibility = View.VISIBLE
            } else {
                holder.edtNota.visibility = View.GONE
                filme.nota = 0.0
                holder.edtNota.text.clear()
            }
        }

        // Lógica para SALVAR a nota enquanto o usuário digita
        holder.edtNota.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val notaDigitada = s.toString().toDoubleOrNull()
                if (notaDigitada != null) {
                    filme.nota = notaDigitada
                }
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }
}