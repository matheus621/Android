package com.example.prova.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prova.R
import com.example.prova.commons.Adapter
import kotlinx.android.synthetic.main.cliente_fragment.*

class ClientesFragment : Fragment() {

    private lateinit var viewModel: ClientesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cliente_item, container, false)
    }

    override fun onResume() {
        super.onResume()

        viewModel = ViewModelProviders.of(this).get(ClientesViewModel::class.java)


        viewModel.getAllClientes().observe(this, Observer { clientes ->
            recyclerView.adapter = Adapter(listOf(clientes))
            recyclerView.layoutManager = LinearLayoutManager(context)
        })
    }

}