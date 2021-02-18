package com.example.prova.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.*
import com.example.prova.R
import kotlinx.android.synthetic.main.pedido_item.*
import java.lang.Exception

class PedidoFragment : Fragment() {

    private lateinit var viewModel: PedidoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pedido_item, container, false)
    }

    override fun onResume() {
        super.onResume()

        viewModel = PedidoViewModel(requireContext())

        try {
            configuraObserverPedido()
            getPedidos()
        } catch (e: Exception) {
            Toast.makeText(context, "Erro na aplicação", Toast.LENGTH_LONG).show()
        }

    }

    fun getPedidos() {
        viewModel.getAllPedidos();
    }


    fun configuraObserverPedido() {
        viewModel.pedidos.observe(viewLifecycleOwner, Observer { pedidos ->

            val pedido = pedidos.get(0)

            if (pedidos != null) {
                textViewNumPedErp.text = pedido.numPedERP
                textViewNumPedRca.text = pedido.numPedRca
                textViewClienteName.text = pedido.cliente
            }
        })
    }

}


