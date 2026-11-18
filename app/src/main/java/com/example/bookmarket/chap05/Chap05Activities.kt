package com.example.bookmarket.chap05

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.example.bookmarket.R
import com.example.bookmarket.setScreen

class ButtonEvent01Activity : AppCompatActivity() {
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch05_button_event01)
        button = findViewById(R.id.button_id)
    }

    fun onButtonClick(v: View) {
        button.text = "버튼 클릭 이벤트"
    }
}

class ButtonEvent03Activity : AppCompatActivity(), View.OnClickListener {
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch05_button_event03)
        btn = findViewById(R.id.button_id)
        btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        btn.text = "버튼 클릭 이벤트"
    }
}

class ButtonEvent04Activity : AppCompatActivity() {
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch05_button_event04)
        btn = findViewById(R.id.button_id)
        val listener = MyListener()
        btn.setOnClickListener(listener)
    }
}

class MyListener : View.OnClickListener {
    override fun onClick(p0: View?) {
        if (p0?.id == R.id.button_id) {
            val btn: Button = p0.findViewById(R.id.button_id)
            btn.text = "버튼 클릭 이벤트"
        }
    }
}

class CheckBoxActivity : AppCompatActivity() {
    lateinit var cbObj1: CheckBox
    lateinit var cbObj2: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch05_checkbox)
        cbObj1 = findViewById(R.id.checkBox1)
        cbObj2 = findViewById(R.id.checkBox2)

        val listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                when (buttonView.id) {
                    R.id.checkBox1 -> Toast.makeText(applicationContext, "강아지를 선택했습니다.", Toast.LENGTH_LONG).show()
                    R.id.checkBox2 -> Toast.makeText(applicationContext, "고양이를 선택했습니다.", Toast.LENGTH_LONG).show()
                }
            } else {
                when (buttonView.id) {
                    R.id.checkBox1 -> Toast.makeText(applicationContext, "강아지를 해제했습니다.", Toast.LENGTH_LONG).show()
                    R.id.checkBox2 -> Toast.makeText(applicationContext, "고양이를 해제했습니다.", Toast.LENGTH_LONG).show()
                }
            }
        }
        cbObj1.setOnCheckedChangeListener(listener)
        cbObj2.setOnCheckedChangeListener(listener)
    }
}

class RadioButtonActivity : AppCompatActivity() {
    lateinit var rbObj1: RadioButton
    lateinit var rbObj2: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch05_radio)
        rbObj1 = findViewById(R.id.radioButton1)
        rbObj2 = findViewById(R.id.radioButton2)

        val listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                when (buttonView.id) {
                    R.id.radioButton1 -> Toast.makeText(applicationContext, "강아지를 선택했습니다.", Toast.LENGTH_LONG).show()
                    R.id.radioButton2 -> Toast.makeText(applicationContext, "고양이를 선택했습니다.", Toast.LENGTH_LONG).show()
                }
            }
        }
        rbObj1.setOnCheckedChangeListener(listener)
        rbObj2.setOnCheckedChangeListener(listener)
    }
}

class ToggleButtonActivity : AppCompatActivity() {
    lateinit var tbObj: ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch05_toggle)
        tbObj = findViewById(R.id.toggleButton)

        tbObj.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
                if (isChecked) Toast.makeText(applicationContext, "YES 상태입니다.", Toast.LENGTH_LONG).show()
                else Toast.makeText(applicationContext, "NO 상태입니다", Toast.LENGTH_LONG).show()
            }
        })
    }
}

class ButtonEventProjectActivity : AppCompatActivity() {
    lateinit var btObj1: ImageButton
    lateinit var btObj2: ImageButton
    lateinit var btObj3: ImageButton
    lateinit var btObj4: ImageButton
    lateinit var ivObj: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch05_button_event_project)
        btObj1 = findViewById(R.id.button1)
        btObj2 = findViewById(R.id.button2)
        btObj3 = findViewById(R.id.button3)
        btObj4 = findViewById(R.id.button4)
        ivObj = findViewById(R.id.imageView2)

        btObj1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                ivObj.visibility = View.VISIBLE
                ivObj.setImageResource(R.drawable.anwer1)
                Toast.makeText(applicationContext, "틀렸습니다", Toast.LENGTH_SHORT).show()
            }
        })
        btObj2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                ivObj.visibility = View.VISIBLE
                ivObj.setImageResource(R.drawable.anwer2)
                Toast.makeText(applicationContext, "맞았습니다", Toast.LENGTH_SHORT).show()
            }
        })
        btObj3.setOnClickListener {
            ivObj.visibility = View.VISIBLE
            ivObj.setImageResource(R.drawable.anwer3)
            Toast.makeText(applicationContext, "틀렸습니다", Toast.LENGTH_SHORT).show()
        }
        btObj4.setOnClickListener {
            ivObj.visibility = View.VISIBLE
            ivObj.setImageResource(R.drawable.anwer4)
            Toast.makeText(applicationContext, "틀렸습니다", Toast.LENGTH_SHORT).show()
        }
    }
}

class CheckBoxProjectActivity : AppCompatActivity() {
    lateinit var cbObj1: CheckBox
    lateinit var cbObj2: CheckBox
    lateinit var cbObj3: CheckBox
    lateinit var cbObj4: CheckBox
    lateinit var btnObj: Button
    lateinit var tvObj: TextView
    var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch05_checkbox_project)
        cbObj1 = findViewById(R.id.checkBox1)
        cbObj2 = findViewById(R.id.checkBox2)
        cbObj3 = findViewById(R.id.checkBox3)
        cbObj4 = findViewById(R.id.checkBox4)
        btnObj = findViewById(R.id.button)
        tvObj = findViewById(R.id.textViewResult)

        val listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                when (buttonView.id) {
                    R.id.checkBox1 -> Toast.makeText(applicationContext, "소방차를 선택했습니다.", Toast.LENGTH_LONG).show()
                    R.id.checkBox2 -> Toast.makeText(applicationContext, "거품기를 선택했습니다.", Toast.LENGTH_LONG).show()
                    R.id.checkBox3 -> Toast.makeText(applicationContext, "청진기를 선택했습니다.", Toast.LENGTH_LONG).show()
                    R.id.checkBox4 -> Toast.makeText(applicationContext, "장갑을 선택했습니다.", Toast.LENGTH_LONG).show()
                }
            }
        }
        cbObj1.setOnCheckedChangeListener(listener)
        cbObj2.setOnCheckedChangeListener(listener)
        cbObj3.setOnCheckedChangeListener(listener)
        cbObj4.setOnCheckedChangeListener(listener)

        btnObj.setOnClickListener {
            if (!flag) {
                tvObj.text = if (cbObj1.isChecked && cbObj4.isChecked && !cbObj2.isChecked && !cbObj3.isChecked) "맞았습니다" else "틀렸습니다"
                btnObj.text = "재시작하기"
                flag = true
            } else {
                cbObj1.isChecked = false
                cbObj2.isChecked = false
                cbObj3.isChecked = false
                cbObj4.isChecked = false
                btnObj.text = "결과보기"
                tvObj.text = "소방관의 용품을 선택해주세요"
                flag = false
            }
        }
    }
}

class RadioButtonProjectActivity : AppCompatActivity() {
    lateinit var rbObj1: RadioButton
    lateinit var rbObj2: RadioButton
    lateinit var rbObj3: RadioButton
    lateinit var rbObj4: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch05_radio_project)
        rbObj1 = findViewById(R.id.radioButton1)
        rbObj2 = findViewById(R.id.radioButton2)
        rbObj3 = findViewById(R.id.radioButton3)
        rbObj4 = findViewById(R.id.radioButton4)

        val listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                when (buttonView.id) {
                    R.id.radioButton2 -> Toast.makeText(applicationContext, "맞았습니다.", Toast.LENGTH_LONG).show()
                    else -> Toast.makeText(applicationContext, "틀렸습니다.", Toast.LENGTH_LONG).show()
                }
            }
        }
        rbObj1.setOnCheckedChangeListener(listener)
        rbObj2.setOnCheckedChangeListener(listener)
        rbObj3.setOnCheckedChangeListener(listener)
        rbObj4.setOnCheckedChangeListener(listener)
    }
}

class ToggleButtonProjectActivity : AppCompatActivity() {
    lateinit var tbObj: ToggleButton
    lateinit var ivObj1: ImageView
    lateinit var ivObj2: ImageView
    lateinit var ivObj3: ImageView
    lateinit var ivObj: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch05_toggle_project)
        tbObj = findViewById(R.id.toggleButton)
        ivObj1 = findViewById(R.id.imageView1)
        ivObj2 = findViewById(R.id.imageView2)
        ivObj3 = findViewById(R.id.imageView3)
        ivObj = findViewById(R.id.imageView)

        tbObj.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                ivObj1.setImageResource(R.drawable.light21)
                ivObj2.setImageResource(R.drawable.light22)
                ivObj3.setImageResource(R.drawable.light23)
                tbObj.setBackgroundResource(R.drawable.toggle_on)
                ivObj.setImageResource(R.drawable.bg2)
            } else {
                ivObj1.setImageResource(R.drawable.light11)
                ivObj2.setImageResource(R.drawable.light12)
                ivObj3.setImageResource(R.drawable.light13)
                tbObj.setBackgroundResource(R.drawable.toggle_off)
                ivObj.setImageResource(R.drawable.bg1)
            }
        }
    }
}

class SwitchProjectActivity : AppCompatActivity() {
    lateinit var sObj1: Switch
    lateinit var sObj2: Switch
    lateinit var tvObj: TextView
    lateinit var ivObj1: ImageView
    lateinit var ivObj2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch05_switch_project)
        sObj1 = findViewById(R.id.switch1)
        sObj2 = findViewById(R.id.switch2)
        sObj2.textOn = ""
        sObj2.textOff = ""
        tvObj = findViewById(R.id.textView2)
        ivObj1 = findViewById(R.id.imageView1)
        ivObj2 = findViewById(R.id.imageView2)

        sObj1.setOnCheckedChangeListener { _, isChecked ->
            ivObj1.visibility = if (isChecked) View.INVISIBLE else View.VISIBLE
        }
        sObj2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                tvObj.setBackgroundColor(Color.argb(40, 200, 200, 200))
                ivObj2.setImageResource(R.drawable.light2)
                sObj2.setThumbResource(R.drawable.switch_on)
            } else {
                tvObj.setBackgroundColor(Color.argb(200, 200, 200, 200))
                ivObj2.setImageResource(R.drawable.light1)
                sObj2.setThumbResource(R.drawable.switch_off)
            }
        }
    }
}
