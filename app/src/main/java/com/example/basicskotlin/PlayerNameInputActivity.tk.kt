package com.example.basicskotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class PlayerNameInputActivity : AppCompatActivity() {

    private lateinit var nameInputContainer: LinearLayout
    private val nameEditTexts = mutableListOf<EditText>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_name_input) // Nouveau layout XML

        nameInputContainer = findViewById(R.id.nameInputContainer)
        val startButton = findViewById<Button>(R.id.startButton)

        val playerCount = intent.getIntExtra("playerCount", 1) // Récupère le nombre de joueurs

        for (i in 1..playerCount) {
            // Créer un EditText pour chaque joueur
            val editText = EditText(this).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 8, 0, 8) // Ajoute une marge entre les EditTexts
                }
                hint = "Nom du joueur $i" // Texte d'aide
                textSize = 18f
                setSingleLine(true) // Pour n'avoir qu'une seule ligne de texte
            }
            nameEditTexts.add(editText) // Ajoute l'EditText à notre liste
            nameInputContainer.addView(editText) // Ajoute l'EditText au conteneur LinearLayout
        }

        startButton.setOnClickListener {
            val playerNames = ArrayList<String>()
            for (editText in nameEditTexts) {
                // Récupère le texte de chaque EditText. Si vide, utilise le hint comme nom par défaut.
                val name = if (editText.text.isNullOrBlank()) {
                    editText.hint.toString() // Utilise le "Nom du joueur X" si rien n'est tapé
                } else {
                    editText.text.toString()
                }
                playerNames.add(name)
            }

            // Lance MainActivity en passant la liste des noms
            val intent = Intent(this, MainActivity::class.java).apply {
                putStringArrayListExtra("playerNames", playerNames)
            }
            startActivity(intent)
            finish() // Optionnel : ferme cette activité pour ne pas revenir en arrière
        }
    }
}