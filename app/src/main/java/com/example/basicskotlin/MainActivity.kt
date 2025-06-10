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
        val playerCount = intent.getIntExtra("playerCount", 1)

        for (i in 1..playerCount) {
            val playerView = layoutInflater.inflate(R.layout.player_block, container, false)

            val name = playerView.findViewById<TextView>(R.id.playerName)
            val score = playerView.findViewById<TextView>(R.id.playerScore)
            val btn1 = playerView.findViewById<Button>(R.id.btnAdd1)
            val btn5 = playerView.findViewById<Button>(R.id.btnAdd5)
            val btnReset = playerView.findViewById<Button>(R.id.btnReset)

            name.text = "Joueur $i"
            score.text = "0"

            btn1.setOnClickListener {
                val current = score.text.toString().toInt()
                score.text = (current + 1).toString()
            }

            btn5.setOnClickListener {
                val current = score.text.toString().toInt()
                score.text = (current + 5).toString()
            }

            btnReset.setOnClickListener {
                score.text = "0"
            }

            container.addView(playerView)
        }
    }
}
