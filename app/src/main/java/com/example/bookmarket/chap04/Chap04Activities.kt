package com.example.bookmarket.chap04

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bookmarket.R
import com.example.bookmarket.setScreen

class ConstraintLayoutProjectActivity : AppCompatActivity() {
    lateinit var ivObjA: ImageView
    lateinit var ivObjB: ImageView
    lateinit var edtObjResult: EditText
    val diceNumber = intArrayOf(
        R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
        R.drawable.dice4, R.drawable.dice5, R.drawable.dice6
    )
    var numA = 0
    var numB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch04_constraint_project)
        ivObjA = findViewById(R.id.imageView1)
        ivObjB = findViewById(R.id.imageView2)
        edtObjResult = findViewById(R.id.editText)

        numA = (1..6).random()
        numB = (1..6).random()
        ivObjA.setImageResource(diceNumber[numA - 1])
        ivObjB.setImageResource(diceNumber[numB - 1])
    }

    fun onClickChoice(view: View?) {
        val num = edtObjResult.text.toString().toIntOrNull()
        if (num == numA + numB) Toast.makeText(applicationContext, "맞았습니다", Toast.LENGTH_SHORT).show()
        else Toast.makeText(applicationContext, "틀렸습니다", Toast.LENGTH_SHORT).show()
    }
}

class LinearLayoutProjectActivity : AppCompatActivity() {
    lateinit var btnObj1: ImageButton
    lateinit var btnObj2: ImageButton
    lateinit var btnObj3: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch04_linear_project)
        btnObj1 = findViewById(R.id.imageButton1)
        btnObj2 = findViewById(R.id.imageButton2)
        btnObj3 = findViewById(R.id.imageButton3)
    }

    fun onClickChoice(view: View?) {
        when (view?.id) {
            R.id.imageButton1 -> Toast.makeText(applicationContext, "틀렸습니다", Toast.LENGTH_SHORT).show()
            R.id.imageButton2 -> Toast.makeText(applicationContext, "맞았습니다", Toast.LENGTH_SHORT).show()
            R.id.imageButton3 -> Toast.makeText(applicationContext, "틀렸습니다", Toast.LENGTH_SHORT).show()
        }
    }
}

class FrameLayoutProjectActivity : AppCompatActivity() {
    lateinit var ivObjDress: ImageView
    lateinit var ivObjCrown: ImageView
    lateinit var ivObjNecklace: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch04_frame_project)
        ivObjCrown = findViewById(R.id.imageViewCrown)
        ivObjNecklace = findViewById(R.id.imageViewNecklace)
        ivObjDress = findViewById(R.id.imageViewDress)

        ivObjCrown.visibility = View.INVISIBLE
        ivObjNecklace.visibility = View.INVISIBLE
        ivObjDress.visibility = View.INVISIBLE
    }

    private fun show(target: ImageView, imageRes: Int) {
        target.visibility = View.VISIBLE
        target.setImageResource(imageRes)
    }

    fun onClickChoice(view: View) {
        when (view.id) {
            R.id.imageViewDress1 -> show(ivObjDress, R.drawable.dress1)
            R.id.imageViewDress2 -> show(ivObjDress, R.drawable.dress2)
            R.id.imageViewDress3 -> show(ivObjDress, R.drawable.dress3)
            R.id.imageViewCrown1 -> show(ivObjCrown, R.drawable.crown1)
            R.id.imageViewCrown2 -> show(ivObjCrown, R.drawable.crown2)
            R.id.imageViewNeck1 -> show(ivObjNecklace, R.drawable.necklace1)
            R.id.imageViewNeck2 -> show(ivObjNecklace, R.drawable.necklace2)
        }
    }

    fun onClickReset(view: View?) {
        ivObjCrown.visibility = View.INVISIBLE
        ivObjNecklace.visibility = View.INVISIBLE
        ivObjDress.visibility = View.INVISIBLE
    }
}

class TableLayoutProjectActivity : AppCompatActivity() {
    lateinit var etObjA: EditText
    lateinit var etObjB: EditText
    lateinit var btObj: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch04_table_project)
        etObjA = findViewById(R.id.editText1)
        etObjB = findViewById(R.id.editText2)
        btObj = findViewById(R.id.button)
    }

    fun onClickChoice(view: View?) {
        val partA = etObjA.text.toString().toIntOrNull()
        val partB = etObjB.text.toString().toIntOrNull()
        if (partA == 2 && partB == 5) Toast.makeText(applicationContext, "맞았습니다", Toast.LENGTH_SHORT).show()
        else Toast.makeText(applicationContext, "틀렸습니다", Toast.LENGTH_SHORT).show()
    }
}
