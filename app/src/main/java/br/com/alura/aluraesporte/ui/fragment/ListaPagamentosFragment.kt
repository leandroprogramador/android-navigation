package br.com.alura.aluraesporte.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.recyclerview.adapter.ListaPagamentosAdapter
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel
import br.com.alura.aluraesporte.ui.viewmodel.PagamentoViewModel
import br.com.alura.aluraesporte.ui.viewmodel.ViewComponents
import kotlinx.android.synthetic.main.lista_pagamentos.*
import kotlinx.android.synthetic.main.login.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ListaPagamentosFragment : BaseFragment() {

    private val adapter : ListaPagamentosAdapter by inject()
    private val pagamentoViewModel : PagamentoViewModel by viewModel()
    private val estadoAppViewModel : EstadoAppViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lista_pagamentos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lista_pagamentos_recyclerview.adapter = adapter
        pagamentoViewModel.todos().observe(this, Observer { pagamentos ->

            pagamentos?.let {
                adapter.add(pagamentos)
            }

        })

        estadoAppViewModel.hasComponents = ViewComponents(appBar = true, bottomNav = true)
    }
}