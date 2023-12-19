package com.example.tic_tac_toe

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var flag = 0
    var count = 0
    var gameOver = false // Track if the game is over

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize all the buttons
        btn1 = findViewById<Button>(R.id.button14)
        btn2 = findViewById<Button>(R.id.button15)
        btn3 = findViewById<Button>(R.id.button16)
        btn4 = findViewById<Button>(R.id.button17)
        btn5 = findViewById<Button>(R.id.button18)
        btn6 = findViewById<Button>(R.id.button19)
        btn7 = findViewById<Button>(R.id.button21)
        btn8 = findViewById<Button>(R.id.button22)
        btn9 = findViewById<Button>(R.id.button23)

        // Setting onClickListeners for boxes
        btn1.setOnClickListener {
            onButtonClick(btn1)
        }

        btn2.setOnClickListener {
            onButtonClick(btn2)
        }

        btn3.setOnClickListener {
            onButtonClick(btn3)
        }

        btn4.setOnClickListener {
            onButtonClick(btn4)
        }

        btn5.setOnClickListener {
            onButtonClick(btn5)
        }

        btn6.setOnClickListener {
            onButtonClick(btn6)
        }

        btn7.setOnClickListener {
            onButtonClick(btn7)
        }

        btn8.setOnClickListener {
            onButtonClick(btn8)
        }

        btn9.setOnClickListener {
            onButtonClick(btn9)
        }

        // New game button code
        val newgamebtn = findViewById<Button>(R.id.new_game_btn)
        newgamebtn.setOnClickListener { newGame() }
    }

    private fun onButtonClick(button: Button) {
        val buttonText = button.text.toString()
        if (!gameOver && buttonText.length == 1 && buttonText[0].isDigit()) { // Check if the game is not over and the button contains a single digit
            count++
            if (flag == 0) {
                button.text = "X"
                flag = 1
            } else {
                button.text = "O"
                flag = 0
            }
            checkWin() // Check for a win after each move
        }
    }

    private fun checkWin() {
        val b1 = btn1.text.toString()
        val b2 = btn2.text.toString()
        val b3 = btn3.text.toString()
        val b4 = btn4.text.toString()
        val b5 = btn5.text.toString()
        val b6 = btn6.text.toString()
        val b7 = btn7.text.toString()
        val b8 = btn8.text.toString()
        val b9 = btn9.text.toString()

        // Diagonal win conditions
        if (b1 == b5 && b5 == b9) {
            showWinner(b1)
        } else if (b3 == b5 && b5 == b7) {
            showWinner(b3)
        }
        // Row win conditions
        else if (b1 == b2 && b2 == b3) {
            showWinner(b1)
        } else if (b4 == b5 && b5 == b6) {
            showWinner(b4)
        } else if (b7 == b8 && b8 == b9) {
            showWinner(b7)
        }
        // Column win conditions
        else if (b1 == b4 && b4 == b7) {
            showWinner(b1)
        } else if (b2 == b5 && b5 == b8) {
            showWinner(b2)
        } else if (b3 == b6 && b6 == b9) {
            showWinner(b3)
        }
        // Draw Condition
        else if (count == 9) {
            showDraw()
        }
    }

    private fun showWinner(winner: String) {
        gameOver = true // Set the game as over
        Toast.makeText(this, "Winner is $winner", Toast.LENGTH_SHORT).show()
    }

    private fun showDraw() {
        gameOver = true // Set the game as over
        Toast.makeText(this, "DRAW!", Toast.LENGTH_SHORT).show()
    }

    private fun newGame() {
        btn1.text = "1"
        btn2.text = "2"
        btn3.text = "3"
        btn4.text = "4"
        btn5.text = "5"
        btn6.text = "6"
        btn7.text = "7"
        btn8.text = "8"
        btn9.text = "9"
        flag = 0
        count = 0
        gameOver = false // Reset the game status
    }
}
