package com.example.basicskotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val btnStart = findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener {
            showNumberPickerDialog()
        }
    }

    private fun showNumberPickerDialog() {
        val numberPicker = NumberPicker(this).apply {
            minValue = 1
            maxValue = 8
        }

        AlertDialog.Builder(this)
            .setTitle("Combien de joueurs ?")
            .setView(numberPicker)
            .setPositiveButton("Valider") { _, _ ->
                val count = numberPicker.value
                val intent = Intent(this, PlayerNameInputActivity::class.java)
                intent.putExtra("playerCount", count)
                startActivity(intent)
            }
            .setNegativeButton("Annuler", null)
            .show()
    }
}