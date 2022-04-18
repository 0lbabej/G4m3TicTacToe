package com.example.tictactoegame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonOnClick(view: View) {


        val buttonSelected = view as Button

        var cellId = 0
        when (buttonSelected.id) {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9
        }

        playGame(cellId, buttonSelected)

    }


    fun restartGame(){

        activePlayer = 1
        player1.clear()
        player2.clear()




        for(cellId in 1..16){

            var buttonSelected: Button? = when(cellId){
                1-> button1
                2-> button2
                3-> button3
                4-> button4
                5-> button5
                6-> button6
                7-> button7
                8-> button8
                9-> button9
                else ->{button1}

            }
            buttonSelected!!.text = ""
            buttonSelected.setBackgroundResource(R.color.whiteOur)
            buttonSelected.isEnabled = true
        }

    }



    var activePlayer = 1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var player1WinsCounts = 0
    var player2WinsCounts = 0

    fun playGame(cellId: Int, buttonSelected: Button) {


        if (activePlayer == 1) {
            buttonSelected.text = "x"
            buttonSelected.setBackgroundResource(R.color.whiteOur2)
            player1.add(cellId)
            activePlayer = 2

        } else {

            buttonSelected.text = "o"
            buttonSelected.setBackgroundResource(R.color.whiteOur2)
            player2.add(cellId)
            activePlayer = 1

        }

        buttonSelected.isEnabled = false

        checkWinner()
    }

    fun checkWinner() {

        var winer = -1



        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winer = 2
        }


        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winer = 2
        }


        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winer = 2
        }





        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winer = 2
        }


        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winer = 2
        }


        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winer = 2
        }


        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winer = 2
        }


        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winer = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winer = 2
        }





        if (winer == 1) {
            player1WinsCounts += 1
            textViewPlayer1.setText("$player1WinsCounts")
            Toast.makeText(this, "Player1: $player1WinsCounts, Player2: $player2WinsCounts", Toast.LENGTH_LONG).show()
            restartGame()

        } else if (winer == 2) {
            player2WinsCounts += 1
            textViewPlayer2.setText("$player2WinsCounts")
            Toast.makeText(this, "Player1: $player1WinsCounts, Player2: $player2WinsCounts", Toast.LENGTH_LONG).show()
            restartGame()
        }

        if (player1WinsCounts == 3){
            Toast.makeText(this, "Winner Player №1", Toast.LENGTH_LONG).show()
            player1WinsCounts = 0
            textViewPlayer1.setText("$player1WinsCounts")
            player2WinsCounts = 0
            textViewPlayer2.setText("$player2WinsCounts")
            restartGame()
        } else if(player2WinsCounts == 3){
            Toast.makeText(this, "Winner Player №2", Toast.LENGTH_LONG).show()
            player1WinsCounts = 0
            textViewPlayer1.setText("$player1WinsCounts")
            player2WinsCounts = 0
            textViewPlayer2.setText("$player2WinsCounts")
            restartGame()
        }

        if (player1.size + player2.size == 9){
         restartGame()
            Toast.makeText(this, "All Buttons Are Selected. Restarting Game", Toast.LENGTH_LONG).show()
     }
    }
}