package com.example.motivation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.motivation.infrastructure.MotivationConstants
import com.example.motivation.R
import com.example.motivation.data.Mock
import com.example.motivation.infrastructure.SecurityPreferences
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Esconder barra de navegação
        supportActionBar?.hide()

        handleUserName()
        handleFilter(R.id.image_all)
        handleNexPhrase()

        /**
         * Atribui eventos aos elementos
         * */
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageProfile.setOnClickListener(this)
        binding.imageClock.setOnClickListener(this)
        /* enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
    }
    /**
     * Trata eventos de click
     * */
    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase) {
            handleNexPhrase()
        } else if (view.id in listOf(R.id.image_all, R.id.image_profile, R.id.image_clock)) {
            handleFilter(view.id)
        }
    }
    /**
     * Busca o nome do usuário
     * */
    @SuppressLint("SetTextI18n")
    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textUserName.text = "Olá, ${name}!"
    }
    /**
     * Trata o filtro aplicado para as frases
     * quando clica na imagem ela muda de cor
     * */
    private fun handleFilter(id: Int) {
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageProfile.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageClock.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.image_profile -> {
                binding.imageProfile.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.PROFILE
            }
            R.id.image_clock -> {
                binding.imageClock.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.CLOCK
            }
        }
    }

    private fun handleNexPhrase(){
        val phrase = Mock().getPhrase(categoryId)
        binding.textPhrase.text=phrase

    }
}
