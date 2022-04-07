package com.ort.recyclerlist_apprecetas.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.ort.recyclerlist_apprecetas.R
import com.ort.recyclerlist_apprecetas.entities.User
import com.ort.recyclerlist_apprecetas.viewmodel.LoginViewModel

class LoginFragment : Fragment() {
    lateinit var v: View
    private lateinit var viewModel: LoginViewModel
    private lateinit var btnLogin : Button
    lateinit var firstName : EditText
    lateinit var lastName : EditText
    lateinit var password : EditText
    lateinit var email : EditText
    var users : MutableList<User> = mutableListOf()

    fun sumarUsuarios(): MutableList<User> {


        var usuario1 = User("Damian","Guillemi", "dguillemi@gmail.com","test")

        users.add(usuario1)
        users.add( User("damian","guillemi", "dguillemi@gmail.com","test"))
        users.add( User("cosme","fulanito", "cosmefulanito@gmail.com","test"))
        users.add( User("pancho","hervido", "panchohervido@gmail.com","test"))
        users.add( User("asado","hervido", "asadohervido@gmail.com","test"))

        return users
    }



    //Se comporta como una vista del activity, por eso tiene un onCreateView. Se ejecuta cada vez que se crea el fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.login_fragment, container, false)
        btnLogin = v.findViewById(R.id.btnLogin)

        firstName = v.findViewById(R.id.inputFirstName)
        lastName = v.findViewById(R.id.inputLastName)
        password = v.findViewById(R.id.inputPassword)
        email = v.findViewById(R.id.inputEmail)
        //WQQ"layout = v.findViewById(R.id.layout)"



        return v

    }

    //Se ejecuta cada vez que arranca el fragment
    override fun onStart() {
        super.onStart()
        sumarUsuarios()



        btnLogin.setOnClickListener{
            val action =  LoginFragmentDirections.actionLoginFragmentToRecipesFragment()
            var encontrado : User?

            if (firstName.length() > 0 && lastName.length() > 0 && email.length() > 0 && password.length() > 0) {
                encontrado = users.find {user -> (user.firstName == firstName.text.toString() && user.lastName ==
                        lastName.text.toString() && user.password == password.text.toString() && user.email == email.text.toString())}
                if(encontrado != null) {
                    v.findNavController().navigate(action)
                }else{
                    Snackbar.make(v, "Datos incorrectos", Snackbar.LENGTH_SHORT).show()
                }

            }else{
                Snackbar.make(v,"Debe completar todos los campos",Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }


}