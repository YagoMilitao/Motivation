package com.example.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.infrastructure.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infrastructure.SecurityPreferences
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Esconder barra de navegação
        supportActionBar?.hide()

        //Eventos
        binding.buttonSave.setOnClickListener(this)
        binding.editName.setOnClickListener(this)

        verifyUserName()
    }

    /**
     * Verifica se usuário já preencheu o nome
     * */
    private fun verifyUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        if(name!=""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    /**
     * Tratamento de clicks dos elementos
     * */
    override fun onClick(view: View?) {
        if (view != null) {
            if (view.id == R.id.button_save) {
                handlesave()
            }
        }
    }

    /**
     * Salva o nome do usuário para utilizações futuras
     * */
    private fun handlesave() {
        // Obtém o nome
        val name = binding.editName.text.toString()
        // Verifica se usuário não preencheu o nome
        if (name != "") {
            // Salva os dados do usuário e redireciona para as frases
            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME,name)
            startActivity(Intent(this, MainActivity::class.java))
            // Impede que seja possível voltar a Activity
            finish()
        } else {
            Toast.makeText(
                this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT
            ).show()
        }

    }
}