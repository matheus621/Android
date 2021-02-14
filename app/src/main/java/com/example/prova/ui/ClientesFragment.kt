package com.example.prova.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import com.example.prova.R
import com.example.prova.model.Cliente
import kotlinx.android.synthetic.main.cliente_item.*

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

        viewModel = ClientesViewModel(requireContext())

        // viewModel = ViewModelProviders.of(this).get(ClientesViewModel::class.java)
        configuraObserverCliente()
        getClientes()


//        val clientes = arguments?.let { viewModel.getAllClientes() }
//
//
//        val observeClienteData = Observer<Cliente> { clientes ->
//
//            if (clientes != null) {
//                textCodigo.text = clientes.codigo
//                txtNomeFantasia.text = clientes.nomeFantasia
//                txtRazaoSocial.text = clientes.razao_social
//                txtEndereco.text = clientes.endereco
//                txtCnpj.text = clientes.cnpj
//                txtRamoAtividade.text = clientes.ramo_atividade
//
//
//            }
//
//        }

        //viewModel.getAllClientes().observe(clientes, observeClienteData)
    }

    fun getClientes() {
        viewModel.getAllClientes2();
    }


    fun configuraObserverCliente() {
        viewModel.clientes.observe(viewLifecycleOwner, Observer { clientes ->
            val cliente = clientes.get(0)
            textCodigo.text = cliente.codigo
            txtNomeFantasia.text = cliente.nomeFantasia
            txtRazaoSocial.text = cliente.razao_social
            txtEndereco.text = cliente.endereco
            txtCnpj.text = cliente.cnpj
            txtRamoAtividade.text = cliente.ramo_atividade
            txtTelefone.text = cliente.contatos.telefone
            txtCelular.text = cliente.contatos.celular
            txtEmail.text = cliente.contatos.e_mail
            txtTime.text = cliente.contatos.time
            txtDataNascimento.text = cliente.contatos.data_nascimento
            txtConjuge.text = cliente.contatos.conjuge
        })
    }

}


