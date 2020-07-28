package com.example.prova.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.prova.R
import com.example.prova.model.Cliente
import kotlinx.android.synthetic.main.cliente_item.*
class ClienteFullFragment : Fragment() {

    private lateinit var viewModel: ClienteFullViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.cliente_item, container, false)
    }

    override fun onResume() {
        super.onResume()

        viewModel = ViewModelProviders.of(this).get(ClienteFullViewModel::class.java)


        val userId = arguments?.getInt("userSelectdId")
        userId?.let { viewModel.setCurrentSelectedUserId(it) }


        val observeUserData = Observer<Cliente> { clientes ->

            if (clientes != null) {
                textCodigo.text = clientes.codigo
                txtNomeFantasia.text = clientes.nomeFantasia
                txtRazaoSocial.text = clientes.razao_social
                txtEndereco.text = clientes.endereco
                txtCnpj.text = clientes.cnpj
                txtRamoAtividade.text = clientes.ramo_atividade


            }

        }

        // Porque tem essa linha abaixo
        //viewModel.getUserLiveData().observe(viewLifecycleOwner, observeUserData)

       // NavHostFragment.findNavController(this).navigate(R.id.action_mainFragment_to_clienteFullFragment)

    }

}