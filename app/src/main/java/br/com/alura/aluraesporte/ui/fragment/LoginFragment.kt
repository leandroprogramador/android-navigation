package br.com.alura.aluraesporte.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel
import br.com.alura.aluraesporte.ui.viewmodel.LoginViewModel
import br.com.alura.aluraesporte.ui.viewmodel.ViewComponents
import kotlinx.android.synthetic.main.login.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val controller by lazy{
        findNavController()
    }

    private val viewModel : LoginViewModel by viewModel()
    private val estadoAppViewModel: EstadoAppViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        estadoAppViewModel.hasComponents = ViewComponents()

        login_botao_logar.setOnClickListener {
            viewModel.login()

            goToProductsListScreen()
        }

        login_botao_cadastrar_usuario.setOnClickListener {
            val direction =
                LoginFragmentDirections.actionLoginToCadastroUsuario()
            controller.navigate(direction)
        }
    }

    private fun goToProductsListScreen() {
        val direction = LoginFragmentDirections.actionLoginToListaProdutos()
        controller.navigate(direction)
    }
}