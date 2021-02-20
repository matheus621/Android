package com.example.prova.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prova.R
import com.example.prova.model.Pedido
import kotlinx.android.synthetic.main.pedido_item.view.*

class Adapter(val dataSet: List<Pedido>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(pedidos: Pedido) {

            with(itemView) {
                textViewNumPedErp.text = pedidos.numPedERP
                textViewNumPedRca.text = pedidos.numPedRca
                textViewClienteName.text = pedidos.cliente
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.pedido_item, parent, false)

        return ViewHolder(layoutItem)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(dataSet[position])
    }
}

