package com.example.prova.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.prova.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.cliente_fragment.*
import kotlinx.android.synthetic.main.cliente_item.*
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.pedido_fragment.*

class MainFragment : Fragment(),
    BottomNavigationView.OnNavigationItemSelectedListener,
    BottomNavigationView.OnNavigationItemReselectedListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)


        initBottomNavigation()
    }

    override fun onResume() {
        super.onResume()

        cardViewCliente.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_clienteFullFragment)
        }

        cardViewPedidos.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_pedidoFragment)
        }



    }

    private fun initBottomNavigation() {
        bottom_nav_cliente.setOnNavigationItemSelectedListener(this)
        bottom_nav_cliente.setOnNavigationItemReselectedListener(this)
        bottom_nav_pedido.setOnNavigationItemReselectedListener(this)
        bottom_nav_pedido.setOnNavigationItemReselectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragment: Fragment

        when (item.itemId) {
            R.id.nav_clientes -> {
                fragment = ClientesFragment()
                fragment.findNavController()
                    .navigate(R.id.action_mainFragment_to_clienteFullFragment)
            }
            R.id.nav_pedidos -> {
                fragment = PedidoFragment()
                fragment.findNavController()
                    .navigate(R.id.action_pedidoFragment_to_clienteFullFragment)
            }
//            else -> {
//                fragment = AlvaraFragment()
//            }
        }


        return true
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        Log.i("LOG", "onNavigationItemReselected()");
    }


}