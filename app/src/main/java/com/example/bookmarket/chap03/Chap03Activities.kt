package com.example.bookmarket.chap03

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.bookmarket.R
import com.example.bookmarket.setScreen

class TextViewActivity : AppCompatActivity() {
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch03_textview)
        textView = findViewById(R.id.textView_id)
        textView.text = "Android App 배우기"
    }
}

class ButtonActivity : AppCompatActivity() {
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch03_button)
        button = findViewById(R.id.button_id)
    }

    fun onButtonClick(view: View?) {
        Toast.makeText(applicationContext, "버튼을 눌렀습니다", Toast.LENGTH_SHORT).show()
    }
}

class ButtonProjectActivity : AppCompatActivity() {
    lateinit var tvObj1: TextView
    lateinit var tvObj2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch03_button_project)
        tvObj1 = findViewById(R.id.num1)
        tvObj2 = findViewById(R.id.num2)
    }

    fun onClickSum(view: View?) {
        val value1 = tvObj1.text.toString().toInt()
        val value2 = tvObj2.text.toString().toInt()
        val sum = value1 + value2
        Toast.makeText(applicationContext, "합계: $sum", Toast.LENGTH_LONG).show()
    }
}

class EditTextActivity : AppCompatActivity() {
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch03_edittext)
        editText = findViewById(R.id.editText_id)
    }

    fun onButtonClick(view: View?) {
        val str = editText.text.toString()
        Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()
    }
}

class EditTextProjectActivity : AppCompatActivity() {
    lateinit var nameObj: EditText
    lateinit var passwordObj: EditText
    lateinit var emailObj: EditText
    lateinit var dateObj: EditText
    lateinit var phonenoObj: EditText
    lateinit var resultObj: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch03_edittext_project)
        nameObj = findViewById(R.id.edtName)
        passwordObj = findViewById(R.id.edtPasswd)
        emailObj = findViewById(R.id.edtEmail)
        dateObj = findViewById(R.id.edtDate)
        phonenoObj = findViewById(R.id.edtPhone)
        resultObj = findViewById(R.id.txtResult)
    }

    fun onButtonClick(view: View?) {
        if (nameObj.text.toString().isEmpty() ||
            passwordObj.text.toString().isEmpty() ||
            emailObj.text.toString().isEmpty() ||
            dateObj.text.toString().isEmpty() ||
            phonenoObj.text.toString().isEmpty()
        ) {
            resultObj.text = "모든 항목을 입력해 주세요"
        } else {
            resultObj.text = "성명 - ${nameObj.text}\n" +
                    "비밀번호 - ${passwordObj.text}\n" +
                    "이메일 - ${emailObj.text}\n" +
                    "생년월일 - ${dateObj.text}\n" +
                    "연락처 - ${phonenoObj.text}"
        }
    }
}

class ImageViewActivity : AppCompatActivity() {
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch03_imageview)
        imageView = findViewById(R.id.imageView_id)
    }

    fun onButtonClick(view: View?) {
        imageView.setImageResource(R.drawable.imageview_cat2)
    }
}

class ImageButtonActivity : AppCompatActivity() {
    lateinit var imgObj: ImageView
    lateinit var numObj: TextView
    val imgNumber = arrayOf(R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4, R.drawable.cat5)
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch03_imagebutton)
        imgObj = findViewById(R.id.imageView_id)
        numObj = findViewById(R.id.textView_id1)
    }

    fun onButtonClick(view: View?) {
        index = (index + 1) % imgNumber.size
        imgObj.setImageResource(imgNumber[index])
        numObj.text = "cat${index + 1}.png"
    }
}

class UIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch03_ui)

        val myLayout: ConstraintLayout = findViewById(R.id.main)
        val myButton = Button(this).apply {
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
            text = "버튼"
            setBackgroundColor(Color.rgb(103, 80, 164))
            setTextColor(Color.WHITE)
        }
        myLayout.addView(myButton)
    }
}
