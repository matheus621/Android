package com.example.prova.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.*
import com.example.prova.R
import com.example.prova.model.Cliente
import kotlinx.android.synthetic.main.cliente_item.*
import java.lang.Exception

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

        try {
            configuraObserverCliente()
            getClientes()
        } catch (e: Exception) {
            Toast.makeText(context, "Erro na aplicação", Toast.LENGTH_LONG).show()
        }

    }

    fun getClientes() {
        viewModel.getAllClientes();
    }


    fun configuraObserverCliente() {
        viewModel.clientes.observe(viewLifecycleOwner, Observer { clientes ->

            clientes.forEach { cliente ->
                if (clientes != null) {
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
                }
            }

        })
    }

}


