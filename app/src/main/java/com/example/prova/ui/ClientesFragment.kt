package com.example.prova.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.prova.R
import com.example.prova.commons.Adapter
import com.example.prova.model.Cliente
import kotlinx.android.synthetic.main.cliente_fragment.*
import kotlinx.android.synthetic.main.cliente_item.*
import org.jetbrains.anko.adapterViewFlipper

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

        viewModel.getAllClientes().let {
            if (it != null) {
                textCodigo.text = it.codigo
                txtNomeFantasia.text = it.nomeFantasia
                txtRazaoSocial.text = it.razao_social
                txtEndereco.text = it.endereco
                txtCnpj.text = it.cnpj
                txtRamoAtividade.text = it.ramo_atividade
            }


//        viewModel.getAllClientes().let {
//            val observeUserData = Observer<Cliente> { clientes ->
//
//                if (clientes != null) {
//                    textCodigo.text = clientes.codigo
//                    txtNomeFantasia.text = clientes.nomeFantasia
//                    txtRazaoSocial.text = clientes.razao_social
//                    txtEndereco.text = clientes.endereco
//                    txtCnpj.text = clientes.cnpj
//                    txtRamoAtividade.text = clientes.ramo_atividade
//
//
//                }
//
//            }
//        }


//            .observe(this, Observer { clientes ->
//            recyclerView.adapter = Adapter(listOf(clientes))
//            val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//            recyclerView.layoutManager = layoutManager


        }
    }

}