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

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNomeDestino: TextView = itemView.findViewById(R.id.tv_nome_destino)
        val tvPaisDestino: TextView = itemView.findViewById(R.id.tv_pais_destino)
        val tvLinkDestino: TextView = itemView.findViewById(R.id.tv_link_destino)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_lista_destinos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = destinosTuristicos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val destino = destinosTuristicos[position]

        holder.tvNomeDestino.text = destino.nome
        holder.tvPaisDestino.text = destino.pais
        holder.tvLinkDestino.text = destino.link
    }
}