package edu.uw.ischool.jtay25.biggobutton

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

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

        val clickMe = findViewById<Button>(R.id.button)
        var count = 0
        clickMe.setOnClickListener{
            val randomColor = Color.rgb(
                Random.nextInt(256),
                Random.nextInt(256),
                Random.nextInt(256)
            )

            val textColor = Color.rgb(
                Random.nextInt(256),
                Random.nextInt(256),
                Random.nextInt(256)
            )

            count++
            clickMe.setTextColor(textColor)
            clickMe.setBackgroundColor(randomColor)
            if (count == 1){
                clickMe.text = "You have pushed me " + count + " time!"
            } else {
                clickMe.text = "You have pushed me " + count + " times!"
            }
        }

    }

}