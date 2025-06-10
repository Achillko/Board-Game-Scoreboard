package com.example.basicskotlin

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById<LinearLayout>(R.id.playersContainer)
        val playerNames = intent.getStringArrayListExtra("playerNames") ?: arrayListOf("Joueur 1")
        val playerCount = playerNames.size

        for (i in 0 until playerCount) {
            val playerView = layoutInflater.inflate(R.layout.player_block, container, false)

            val name = playerView.findViewById<TextView>(R.id.playerName)
            val score = playerView.findViewById<TextView>(R.id.playerScore)
            val btn1 = playerView.findViewById<Button>(R.id.btnAdd1)
            val btn5 = playerView.findViewById<Button>(R.id.btnAdd5)
            val btn10 = playerView.findViewById<Button>(R.id.btnAdd10)
            val btnReset = playerView.findViewById<Button>(R.id.btnReset)

            name.text = playerNames[i]
            score.text = "0"

            btn1.setOnClickListener {
                val current = score.text.toString().toInt()
                score.text = (current + 1).toString()
            }

            btn5.setOnClickListener {
                val current = score.text.toString().toInt()
                score.text = (current + 5).toString()
            }

            btn10.setOnClickListener {
                val current = score.text.toString().toInt()
                score.text = (current + 10).toString()
            }

            btnReset.setOnClickListener {
                score.text = "0"
            }

            container.addView(playerView)
        }
    }
}
