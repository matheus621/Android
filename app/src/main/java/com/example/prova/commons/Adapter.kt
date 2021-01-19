package com.example.prova.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prova.R
import com.example.prova.model.Cliente
import kotlinx.android.synthetic.main.cliente_item.view.*

class Adapter(val dataSet: List<Cliente>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(clientes: Cliente) {

            with(itemView) {
                textCodigo.text = clientes.codigo
                txtNomeFantasia.text = clientes.nomeFantasia
                txtRazaoSocial.text = clientes.razao_social
                txtEndereco.text = clientes.endereco
                txtCnpj.text = clientes.cnpj
                txtRamoAtividade.text = clientes.ramo_atividade

//                rcy_clientes.setOnClickListener {
//                   // val clienteSelectdId = bundleOf("clienteSelectdId" to clientes.id)
////                    findNavController().navigate(
////                        R.id.action_mainFragment_to_clienteFullFragment,
////                        clienteSelectdId
//                    )
//                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.cliente_item, parent, false)

        return ViewHolder(layoutItem)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bindView(dataSet[position])
        val list = dataSet[position]
        holder.let {
            it.bindView(list)
        }

    }
}