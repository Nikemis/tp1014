package br.unisanta.myapplication.viewModel

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.ViewModel
import br.unisanta.myapplication.model.Usuario

class LoginViewModel : ViewModel() {
    private val usuarios = mutableListOf<Usuario>()

    fun entrar (email: String, senha:String):String{

    val usuario =  usuarios.find { it.email == email && it.senha == senha}
        if(usuario!=null){
            return "Usuario Pode Logar"
        }
         return "usuario não cadastrado"
        }
    fun cadastrar(email: String, senha:String):String{
        val usuario = Usuario(email,senha)
        usuarios.add(usuario)
        return "Usuário Cadastrado";

    }
}