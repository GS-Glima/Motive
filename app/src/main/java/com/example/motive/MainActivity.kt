package com.example.motive

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var nome = findViewById<TextView>(R.id.text_view_nome)
        val nomeRecuperacao = this.getSharedPreferences("motivacao", MODE_PRIVATE).getString("nome", "Seja bem vindo")
        nome.text = "Olá, " + nomeRecuperacao

        var novaFrase = findViewById<TextView>(R.id.text_frase)
        var botaoFrase = findViewById<Button>(R.id.button_nova_frase)
        var imageAll = findViewById<ImageView>(R.id.image_infinito)
        var imageHappy = findViewById<ImageView>(R.id.image_carinha)
        var imageSun = findViewById<ImageView>(R.id.image_sol)

        botaoFrase.setOnClickListener {
            var fraseSorteada = FraseRepository.getFrase(0)
            novaFrase.text = fraseSorteada
        }

        imageAll.setOnClickListener {
            imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
            imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.black))
            imageSun.setColorFilter(ContextCompat.getColor(this, R.color.black))
            var fraseSorteada = FraseRepository.getFrase(0)
            novaFrase.text = fraseSorteada
        }
    }
}