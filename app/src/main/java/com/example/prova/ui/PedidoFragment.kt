package com.example.prova.ui

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prova.R
import com.example.prova.commons.Adapter
import kotlinx.android.synthetic.main.pedido_fragment.*

class PedidoFragment : Fragment() {

    private lateinit var viewModel: PedidoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pedido_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()

        viewModel = ViewModelProvider(this).get(PedidoViewModel::class.java)


        viewModel.getAllPedidos().observe(this, Observer { pedidos ->
            recyclerView.adapter = Adapter(pedidos)
            recyclerView.layoutManager = LinearLayoutManager(this.context)
        })

//        viewModel = PedidoViewModel(requireContext())
//
//        try {
//            configuraObserverPedido()
//            getPedidos()
//        } catch (e: Exception) {
//            Toast.makeText(context, "Erro na aplicação", Toast.LENGTH_LONG).show()
//        }
//
//    }
//
//    fun getPedidos() {
//        viewModel.getAllPedidos()
//    }


//    fun configuraObserverPedido() {
//        viewModel.pedidos.observe(viewLifecycleOwner, Observer { pedidos ->
//
//            pedidos.forEach { pedido ->
//                if (pedido != null) {
//                    textViewNumPedErp.text = pedido.numPedERP
//                    textViewNumPedRca.text = pedido.numPedRca
//                    textViewClienteName.text = pedido.cliente
//                }
//            }
//
//        })
//    }


    }
}


