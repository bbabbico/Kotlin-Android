package com.example.bookmarket.chap06

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.example.bookmarket.R
import com.example.bookmarket.setScreen

class ExplicitIntent01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_explicit01)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, ExplicitIntent01SubActivity::class.java)
            startActivity(intent)
        }
    }
}

class ExplicitIntent01SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_explicit01_sub, R.id.sub)
    }
}

class ExplicitIntent02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_explicit02)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val editText: EditText = findViewById(R.id.editText)
            val intent = Intent(this, ExplicitIntent02SubActivity::class.java)
            intent.putExtra("name", editText.text.toString())
            startActivity(intent)
        }
    }
}

class ExplicitIntent02SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_explicit02_sub, R.id.sub)
        val textView: TextView = findViewById(R.id.textView)
        val strName = intent.getStringExtra("name")
        textView.text = strName
    }
}

class ExplicitIntent03Activity : AppCompatActivity() {
    lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_explicit03)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, ExplicitIntent03SubActivity::class.java)
            launcher.launch(intent)
        }
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val text = data?.getStringExtra("editText")
                val textView: TextView = findViewById(R.id.textView)
                textView.text = text
            }
        }
    }
}

class ExplicitIntent03SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_explicit03_sub, R.id.sub)
        val intent = intent
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val editText: EditText = findViewById(R.id.editText)
            intent.putExtra("editText", editText.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_implicit)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:01012341234")
            startActivity(intent)
        }
    }
}

class IntentFilterExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_intent_filter)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://www.hanbit.co.kr")
            startActivity(intent)
        }
    }
}

class SplashLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_login_splash)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }, 2000)
    }
}

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_login, R.id.login)
        val btnObj: Button = findViewById(R.id.button)
        btnObj.setOnClickListener {
            val etObj01: EditText = findViewById(R.id.editText01)
            val etObj02: EditText = findViewById(R.id.editText02)
            Toast.makeText(
                applicationContext,
                "아이디 : " + etObj01.text.toString() + "\n비밀번호 : " + etObj02.text.toString(),
                Toast.LENGTH_LONG
            ).show()
        }
    }
}

class AnimalMainActivity : AppCompatActivity() {
    lateinit var rdObj1: RadioButton
    lateinit var rdObj2: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_animal_main)
        rdObj1 = findViewById(R.id.radioButton1)
        rdObj2 = findViewById(R.id.radioButton2)
        val btnObj: Button = findViewById(R.id.button)
        btnObj.setOnClickListener {
            val intent = Intent(this, AnimalGameActivity::class.java)
            if (rdObj1.isChecked) intent.putExtra("image", 1)
            else if (rdObj2.isChecked) intent.putExtra("image", 2)
            startActivity(intent)
        }
    }
}

class AnimalGameActivity : AppCompatActivity() {
    val imageviewCatId = intArrayOf(R.id.ivCheck11, R.id.ivCheck12, R.id.ivCheck13, R.id.ivCheck14, R.id.ivCheck15)
    val imageviewDogId = intArrayOf(R.id.ivCheck21, R.id.ivCheck22, R.id.ivCheck23, R.id.ivCheck24, R.id.ivCheck25)
    val checkObj: Array<ImageView?> = arrayOfNulls(5)
    var mImage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_animal_game, R.id.game)

        mImage = intent.getIntExtra("image", 0)
        val imageObj01: ImageView = findViewById(R.id.imageView01)
        val imageObj02: ImageView = findViewById(R.id.imageView02)
        val catLayout: ConstraintLayout = findViewById(R.id.catLayout)
        val dogLayout: ConstraintLayout = findViewById(R.id.dogLayout)

        if (mImage == 1) {
            imageObj01.setImageResource(R.drawable.cat01)
            imageObj02.setImageResource(R.drawable.cat02)
            for (i in 0..4) checkObj[i] = findViewById(imageviewCatId[i])
            catLayout.isVisible = true
            dogLayout.isVisible = false
        } else if (mImage == 2) {
            imageObj01.setImageResource(R.drawable.dog01)
            imageObj02.setImageResource(R.drawable.dog02)
            for (i in 0..4) checkObj[i] = findViewById(imageviewDogId[i])
            catLayout.isVisible = false
            dogLayout.isVisible = true
        }

        var num = 0
        for (i in 0..4) {
            checkObj[i]?.setOnClickListener {
                if (num < 5) {
                    num++
                    checkObj[i]?.setImageResource(R.drawable.ok_select)
                    Toast.makeText(applicationContext, "맞았습니다", Toast.LENGTH_SHORT).show()
                }
                if (num == 5) Toast.makeText(applicationContext, "5개 모두 선택했습니다.", Toast.LENGTH_SHORT).show()
            }
        }
        imageObj01.setOnClickListener {
            Toast.makeText(applicationContext, "틀렸습니다.", Toast.LENGTH_SHORT).show()
        }
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener { finish() }
    }
}

class ShapeMainActivity : AppCompatActivity() {
    lateinit var launcher: ActivityResultLauncher<Intent>
    val drawableId = intArrayOf(
        R.drawable.shape01, R.drawable.shape02, R.drawable.shape03,
        R.drawable.shape04, R.drawable.shape05, R.drawable.shape06,
        R.drawable.shape07, R.drawable.shape08, R.drawable.shape09
    )
    val imageviewId = intArrayOf(R.id.image01, R.id.image02, R.id.image03)
    lateinit var rdObj1: RadioButton
    lateinit var rdObj2: RadioButton
    val ivObj: Array<ImageView?> = arrayOfNulls(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_shape_main)
        rdObj1 = findViewById(R.id.radioButton1)
        rdObj2 = findViewById(R.id.radioButton2)
        for (i in 0..2) ivObj[i] = findViewById(imageviewId[i])

        val btnObj: Button = findViewById(R.id.button)
        btnObj.setOnClickListener {
            val intent = Intent(applicationContext, ShapeGameActivity::class.java)
            if (rdObj1.isChecked) intent.putExtra("shape", 1)
            else if (rdObj2.isChecked) intent.putExtra("shape", 2)
            launcher.launch(intent)
        }

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val resId = result.data?.getIntArrayExtra("answer") ?: return@registerForActivityResult
                var num = 0
                for (i in 0..8) {
                    if (resId[i] >= 1) {
                        ivObj[num]?.setImageResource(drawableId[i])
                        num++
                    }
                }
                var flag = true
                for (i in 0..8) {
                    if (rdObj1.isChecked) {
                        if (resId[i] == 1 && i > 2) flag = false
                    } else if (rdObj2.isChecked) {
                        if ((resId[i] == 1 && i <= 2) || (resId[i] == 1 && i >= 6)) flag = false
                    }
                }
                val layoutResultObj: LinearLayout = findViewById(R.id.layoutResult)
                layoutResultObj.visibility = View.VISIBLE
                val tvObj: TextView = findViewById(R.id.textViewResult)
                tvObj.visibility = View.VISIBLE
                tvObj.text = if (flag) "맞았습니다" else "틀렸습니다"
            }
        }
    }
}

class ShapeGameActivity : AppCompatActivity() {
    val imageviewId = intArrayOf(
        R.id.image01, R.id.image02, R.id.image03, R.id.image04, R.id.image05,
        R.id.image06, R.id.image07, R.id.image08, R.id.image09
    )
    val framelayoutId = intArrayOf(
        R.id.frame_layout01, R.id.frame_layout02, R.id.frame_layout03,
        R.id.frame_layout04, R.id.frame_layout05, R.id.frame_layout06,
        R.id.frame_layout07, R.id.frame_layout08, R.id.frame_layout09
    )
    val ivObj: Array<ImageView?> = arrayOfNulls(9)
    val flayoutObj: Array<FrameLayout?> = arrayOfNulls(9)
    val imgArray: Array<ImageView?> = arrayOfNulls(9)
    val selectNum = IntArray(9)
    var mShape = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_shape_game, R.id.game)

        mShape = intent.getIntExtra("shape", 0)
        val shapeObj: ImageView = findViewById(R.id.imageView)
        if (mShape == 1) shapeObj.setImageResource(R.drawable.circle)
        else if (mShape == 2) shapeObj.setImageResource(R.drawable.square)

        for (i in 0..8) {
            selectNum[i] = 0
            ivObj[i] = findViewById(imageviewId[i])
            flayoutObj[i] = findViewById(framelayoutId[i])
        }

        var num = 0
        for (i in 0..8) {
            ivObj[i]?.setOnClickListener {
                if (selectNum[i] == 1) {
                    selectNum[i] = 0
                    --num
                    flayoutObj[i]?.removeView(imgArray[i])
                } else {
                    if (num < 3) {
                        selectNum[i] = 1
                        num++
                        imgArray[i] = ImageView(this)
                        imgArray[i]?.setImageResource(R.drawable.ok_check)
                        flayoutObj[i]?.addView(imgArray[i])
                    } else {
                        Toast.makeText(this, "3개 까지만 선택 가능합니다", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        val btnObj: Button = findViewById(R.id.button)
        btnObj.setOnClickListener {
            val intent = intent
            intent.putExtra("answer", selectNum)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}

class ImplicitIntentProjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_implicit_project)
        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val url = editText.text.toString()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://$url")
            startActivity(intent)
        }
    }
}

class IntentFilterProjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch06_intent_filter_project)
        val etObj01: EditText = findViewById(R.id.editText1)
        val etObj02: EditText = findViewById(R.id.editText2)
        val etObj03: EditText = findViewById(R.id.editText3)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(etObj01.text.toString()))
            intent.putExtra(Intent.EXTRA_SUBJECT, etObj02.text.toString())
            intent.putExtra(Intent.EXTRA_TEXT, etObj03.text.toString())
            val intent2 = Intent.createChooser(intent, "앱을 선택하세요")
            startActivity(intent2)
        }
    }
}
