package com.example.desafiodispositivosmoveis.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiodispositivosmoveis.R
import com.example.desafiodispositivosmoveis.model.DestinoTuristico
// Importe a classe da sua WebView (verifique o nome exato que você deu a ela)
import com.example.desafiodispositivosmoveis.view.Webview_Activity
import kotlin.jvm.java

class DestinoTurismoAdapter(private val destinosTuristicos: MutableList<DestinoTuristico>) :
    RecyclerView.Adapter<DestinoTurismoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNomeDestino: TextView = itemView.findViewById(R.id.tv_nome_destino)
        val tvPaisDestino: TextView = itemView.findViewById(R.id.tv_pais_destino)
        val tvLinkDestino: TextView = itemView.findViewById(R.id.tv_link_destino)
        val btnExplorar: Button = itemView.findViewById(R.id.btn_explorar)
        val btnExcluir: Button = itemView.findViewById(R.id.btn_excluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_destino, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = destinosTuristicos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val destino = destinosTuristicos[position]

        holder.tvNomeDestino.text = destino.nome
        holder.tvPaisDestino.text = destino.pais
        holder.tvLinkDestino.text = destino.link

        holder.btnExplorar.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, Webview_Activity::class.java)
            intent.putExtra("URL_DESTINO", destino.link) // Passa o link do objeto destino
            context.startActivity(intent)
        }

        holder.btnExcluir.setOnClickListener {
            destinosTuristicos.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, destinosTuristicos.size)
        }
    }
}