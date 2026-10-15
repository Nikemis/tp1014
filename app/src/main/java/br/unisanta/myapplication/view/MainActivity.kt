package br.unisanta.myapplication.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import br.unisanta.myapplication.R
import br.unisanta.myapplication.databinding.ActivityMainBinding
import br.unisanta.myapplication.viewModel.LoginViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var loginViewModel:LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        loginViewModel= LoginViewModel()
        setContentView(R.layout.activity_main)
       ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main))
       { v, insets ->
           val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnEntrar.setOnClickListener{
            val email = binding.edtEmailUsuario.text.toString()
            val senha = binding.edtSenhaUsuario.text.toString()
            val retorno = loginViewModel.entrar(email, senha)
            Toast.makeText(this,retorno,Toast.LENGTH_SHORT).show()
        }
        binding.bntCadastrar.setOnClickListener{
            val email = binding.edtEmailUsuario.text.toString()
            val senha = binding.edtSenhaUsuario.text.toString()
            val retorno = loginViewModel.cadastrar(email, senha)
            Toast.makeText(this,retorno,Toast.LENGTH_SHORT).show()
        }
    }
}