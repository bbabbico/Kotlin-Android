package com.example.bookmarket

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.activity_menu, R.id.menu)
    }

    fun onBookListClick(view: View?) {
        Toast.makeText(applicationContext, "도서목록 버튼을 클릭하였습니다", Toast.LENGTH_LONG).show()
        val intent = Intent(this, BooksActivity::class.java)
        startActivity(intent)
    }

    fun onEBookClick(view: View?) {
        Toast.makeText(applicationContext, "E-Book 버튼을 클릭하였습니다", Toast.LENGTH_LONG).show()
    }

    fun onCustomerInquiryClick(view: View?) {
        Toast.makeText(applicationContext, "고객문의 버튼을 클릭하였습니다", Toast.LENGTH_LONG).show()
    }

    fun onMyPageClick(view: View?) {
        Toast.makeText(applicationContext, "나의페이지 버튼을 클릭하였습니다", Toast.LENGTH_LONG).show()
    }

    fun onMarketInfoClick(view: View?) {
        Toast.makeText(applicationContext, "마켓정보 버튼을 클릭하였습니다", Toast.LENGTH_LONG).show()
    }

    fun onSettingClick(view: View?) {
        Toast.makeText(applicationContext, "설정 버튼을 클릭하였습니다", Toast.LENGTH_LONG).show()
    }

    fun onBannerClick(view: View?) {
        val menuObj: ImageView = findViewById(R.id.imageView2)
        if (index % 2 == 0) menuObj.setImageResource(R.drawable.menu_banner2)
        else menuObj.setImageResource(R.drawable.menu_banner1)
        index++
    }
}
