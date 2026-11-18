package com.example.bookmarket

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BooksActivity : AppCompatActivity() {
    lateinit var book1Obj: ImageView
    lateinit var book2Obj: ImageView
    lateinit var book3Obj: ImageView
    lateinit var book4Obj: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.activity_books, R.id.books)

        book1Obj = findViewById(R.id.book1)
        book2Obj = findViewById(R.id.book2)
        book3Obj = findViewById(R.id.book3)
        book4Obj = findViewById(R.id.book4)

        book1Obj.setOnClickListener {
            Toast.makeText(applicationContext, "쉽게 배우는 알고리즘", Toast.LENGTH_LONG).show()
        }
        book2Obj.setOnClickListener {
            Toast.makeText(applicationContext, "난생 처음 MySQL", Toast.LENGTH_LONG).show()
        }
        book3Obj.setOnClickListener {
            Toast.makeText(applicationContext, "쉽게 배우는 PHP 웹 프로그래밍", Toast.LENGTH_LONG).show()
        }
        book4Obj.setOnClickListener {
            Toast.makeText(applicationContext, "미라클 HTML5 + CSS3 + 자바스크립트", Toast.LENGTH_LONG).show()
        }
    }
}
