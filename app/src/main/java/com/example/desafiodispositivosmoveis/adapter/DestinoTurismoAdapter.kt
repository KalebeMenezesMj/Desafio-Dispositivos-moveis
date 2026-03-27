package com.example.desafiodispositivosmoveis.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiodispositivosmoveis.R
import com.example.desafiodispositivosmoveis.model.DestinoTuristico

class DestinoTurismoAdapter(private val destinosTuristicos: List<DestinoTuristico>) :
    RecyclerView.Adapter<DestinoTurismoAdapter.ViewHolder>() {

    // 1. Atualizamos o ViewHolder para procurar os IDs corretos do seu XML
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNomeDestino: TextView = itemView.findViewById(R.id.tv_nome_destino)
        val tvPaisDestino: TextView = itemView.findViewById(R.id.tv_pais_destino)
        val tvLinkDestino: TextView = itemView.findViewById(R.id.tv_link_destino)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // 2. Trocamos "item_filme" pelo nome correto do seu layout de item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_lista, parent, false)
        return ViewHolder(view)
    }

    // 3. Trocamos "filmes.size" pela lista correta de destinos
    override fun getItemCount(): Int = destinosTuristicos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 4. Pegamos o destino atual da posição
        val destino = destinosTuristicos[position]

        // 5. Passamos os dados da classe DestinoTuristico para a tela
        holder.tvNomeDestino.text = destino.nome
        holder.tvPaisDestino.text = destino.pais
        holder.tvLinkDestino.text = destino.link
    }
}