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
        val nome = findViewById<TextView>(R.id.text_view_nome)
        val nomeRecuperacao = this.getSharedPreferences("motivacao", MODE_PRIVATE).getString("nome", "Seja bem vindo")
        nome.text = "Olá, $nomeRecuperacao";

        val novaFrase = findViewById<TextView>(R.id.text_frase)
        val botaoFrase = findViewById<Button>(R.id.button_nova_frase)
        val imageAll = findViewById<ImageView>(R.id.image_infinito)
        val imageHappy = findViewById<ImageView>(R.id.image_carinha)
        val imageSun = findViewById<ImageView>(R.id.image_sol)
        val fraseRepo = FraseRepository()

        botaoFrase.setOnClickListener {
            val fraseSorteada = fraseRepo.getFrase(0)
            novaFrase.text = fraseSorteada
        }

        imageAll.setOnClickListener {
            imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
            imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.black))
            imageSun.setColorFilter(ContextCompat.getColor(this, R.color.black))
            val fraseSorteada = fraseRepo.getFrase(0)
            novaFrase.text = fraseSorteada
        }
        imageHappy.setOnClickListener {
            imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
            imageAll.setColorFilter(ContextCompat.getColor(this, R.color.black))
            imageSun.setColorFilter(ContextCompat.getColor(this, R.color.black))
            val fraseSorteada = fraseRepo.getFrase(1)
            novaFrase.text = fraseSorteada
        }
        imageSun.setOnClickListener {
            imageSun.setColorFilter(ContextCompat.getColor(this, R.color.white))
            imageAll.setColorFilter(ContextCompat.getColor(this, R.color.black))
            imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.black))
            val fraseSorteada = fraseRepo.getFrase(2)
            novaFrase.text = fraseSorteada
        }
    }
}