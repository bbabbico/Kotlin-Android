package com.example.bookmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bookmarket.chap03.ButtonActivity
import com.example.bookmarket.chap03.ButtonProjectActivity
import com.example.bookmarket.chap03.EditTextActivity
import com.example.bookmarket.chap03.EditTextProjectActivity
import com.example.bookmarket.chap03.ImageButtonActivity
import com.example.bookmarket.chap03.ImageViewActivity
import com.example.bookmarket.chap03.TextViewActivity
import com.example.bookmarket.chap03.UIActivity
import com.example.bookmarket.chap04.ConstraintLayoutProjectActivity
import com.example.bookmarket.chap04.FrameLayoutProjectActivity
import com.example.bookmarket.chap04.LinearLayoutProjectActivity
import com.example.bookmarket.chap04.TableLayoutProjectActivity
import com.example.bookmarket.chap05.ButtonEvent01Activity
import com.example.bookmarket.chap05.ButtonEvent03Activity
import com.example.bookmarket.chap05.ButtonEvent04Activity
import com.example.bookmarket.chap05.ButtonEventProjectActivity
import com.example.bookmarket.chap05.CheckBoxActivity
import com.example.bookmarket.chap05.CheckBoxProjectActivity
import com.example.bookmarket.chap05.RadioButtonActivity
import com.example.bookmarket.chap05.RadioButtonProjectActivity
import com.example.bookmarket.chap05.SwitchProjectActivity
import com.example.bookmarket.chap05.ToggleButtonActivity
import com.example.bookmarket.chap05.ToggleButtonProjectActivity

fun AppCompatActivity.setScreen(layoutId: Int, rootId: Int = R.id.main) {
    enableEdgeToEdge()
    setContentView(layoutId)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(rootId)) { v, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        insets
    }
}

class LayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(intent.getIntExtra(EXTRA_LAYOUT, R.layout.ch03_textview01))
    }

    companion object {
        const val EXTRA_LAYOUT = "layout"
    }
}

class ExamplesActivity : AppCompatActivity() {
    private fun screen(cls: Class<*>) = Intent(this, cls)

    private fun layout(layoutId: Int) =
        Intent(this, LayoutActivity::class.java).putExtra(LayoutActivity.EXTRA_LAYOUT, layoutId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val screens: List<Pair<String, Intent?>> = listOf(
            "5장 프로젝트" to null,
            "BookMarket 도서목록 화면" to screen(BooksActivity::class.java),

            "4장 프로젝트" to null,
            "BookMarket 메뉴 목록 화면" to screen(MenuActivity::class.java),

            "3장 기본 위젯" to null,
            "TextView 예제" to screen(TextViewActivity::class.java),
            "TextView 01 - 위치" to layout(R.layout.ch03_textview01),
            "TextView 02 - textColor" to layout(R.layout.ch03_textview02),
            "TextView 03 - textSize" to layout(R.layout.ch03_textview03),
            "TextView 04 - textStyle" to layout(R.layout.ch03_textview04),
            "TextView 05 - typeface" to layout(R.layout.ch03_textview05),
            "TextView 06 - maxLines" to layout(R.layout.ch03_textview06),
            "Button 예제" to screen(ButtonActivity::class.java),
            "Button 01 - backgroundTint" to layout(R.layout.ch03_button01),
            "Button 02 - drawableTop" to layout(R.layout.ch03_button02),
            "Button 03 - background" to layout(R.layout.ch03_button03),
            "ButtonProject - 두 수의 합" to screen(ButtonProjectActivity::class.java),
            "EditText 예제" to screen(EditTextActivity::class.java),
            "EditTextProject - 입력 결과 보기" to screen(EditTextProjectActivity::class.java),
            "ImageView 예제" to screen(ImageViewActivity::class.java),
            "ImageButtonProject - 다음 사진 보기" to screen(ImageButtonActivity::class.java),
            "UI 예제 - 코드로 버튼 추가" to screen(UIActivity::class.java),

            "4장 레이아웃" to null,
            "ConstraintLayout - 체인 기본" to layout(R.layout.ch04_constraint),
            "ConstraintLayout 01 - 상대 위치" to layout(R.layout.ch04_constraint01),
            "ConstraintLayout 01_2 - 가운데 정렬" to layout(R.layout.ch04_constraint01_2),
            "ConstraintLayout 02 - 원형 위치" to layout(R.layout.ch04_constraint02),
            "ConstraintLayout 03 - bias" to layout(R.layout.ch04_constraint03),
            "ConstraintLayout 04 - 비율" to layout(R.layout.ch04_constraint04),
            "ConstraintLayout 05 - chain spread" to layout(R.layout.ch04_constraint05),
            "ConstraintLayout 05_2 - chain spread_inside" to layout(R.layout.ch04_constraint05_2),
            "ConstraintLayout 05_3 - chain packed" to layout(R.layout.ch04_constraint05_3),
            "ConstraintLayoutProject - 주사위 합계" to screen(ConstraintLayoutProjectActivity::class.java),
            "LinearLayout - horizontal" to layout(R.layout.ch04_linear),
            "LinearLayout 02 - vertical" to layout(R.layout.ch04_linear02),
            "LinearLayout 03 - baselineAligned" to layout(R.layout.ch04_linear03),
            "LinearLayout 04 - layout_weight" to layout(R.layout.ch04_linear04),
            "LinearLayout 05 - weightSum" to layout(R.layout.ch04_linear05),
            "LinearLayoutProject - 정답 고르기" to screen(LinearLayoutProjectActivity::class.java),
            "FrameLayout - foreground" to layout(R.layout.ch04_frame),
            "FrameLayout 02 - foregroundGravity" to layout(R.layout.ch04_frame02),
            "FrameLayout 03 - measureAllChildren" to layout(R.layout.ch04_frame03),
            "FrameLayout 04 - visibility" to layout(R.layout.ch04_frame04),
            "FrameLayoutProject - 옷 입히기" to screen(FrameLayoutProjectActivity::class.java),
            "TableLayout - stretchColumns 1" to layout(R.layout.ch04_table),
            "TableLayout _1 - stretchColumns 0" to layout(R.layout.ch04_table_1),
            "TableLayout _2 - stretchColumns *" to layout(R.layout.ch04_table_2),
            "TableLayout _3 - stretchColumns 2" to layout(R.layout.ch04_table_3),
            "TableLayout 02 - shrinkColumns 1" to layout(R.layout.ch04_table02),
            "TableLayout 02_1 - shrinkColumns 0" to layout(R.layout.ch04_table02_1),
            "TableLayout 02_2 - shrinkColumns *" to layout(R.layout.ch04_table02_2),
            "TableLayout 02_3 - shrinkColumns 2" to layout(R.layout.ch04_table02_3),
            "TableLayout 03 - collapseColumns" to layout(R.layout.ch04_table03),
            "TableLayout 04 - layout_column" to layout(R.layout.ch04_table04),
            "TableLayout 05 - layout_span" to layout(R.layout.ch04_table05),
            "TableLayoutProject - 그림 개수 세기" to screen(TableLayoutProjectActivity::class.java),

            "5장 이벤트 처리" to null,
            "ButtonEvent 01 - onClick 속성" to screen(ButtonEvent01Activity::class.java),
            "ButtonEvent 03 - 액티비티가 리스너 구현" to screen(ButtonEvent03Activity::class.java),
            "ButtonEvent 04 - 리스너 클래스" to screen(ButtonEvent04Activity::class.java),
            "ButtonEventProject - 그림 퀴즈" to screen(ButtonEventProjectActivity::class.java),
            "CheckBox 예제" to screen(CheckBoxActivity::class.java),
            "CheckBoxProject - 소방관 용품 찾기" to screen(CheckBoxProjectActivity::class.java),
            "RadioButton 예제" to screen(RadioButtonActivity::class.java),
            "RadioButtonProject - 동물 그림자 찾기" to screen(RadioButtonProjectActivity::class.java),
            "ToggleButton 예제" to screen(ToggleButtonActivity::class.java),
            "ToggleButtonProject - 조명 켜고 끄기" to screen(ToggleButtonProjectActivity::class.java),
            "Switch 예제" to layout(R.layout.ch05_switch),
            "Switch 02 - switchMinWidth" to layout(R.layout.ch05_switch02),
            "Switch 03 - textOn/textOff" to layout(R.layout.ch05_switch03),
            "Switch 04 - thumb" to layout(R.layout.ch05_switch04),
            "Switch 05 - thumbTint" to layout(R.layout.ch05_switch05),
            "SwitchProject - 고양이와 조명" to screen(SwitchProjectActivity::class.java),
        )
        val list = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        for ((title, intent) in screens) {
            if (intent == null) {
                list.addView(TextView(this).apply {
                    text = title
                    textSize = 20f
                    setPadding(24, 32, 24, 8)
                })
            } else {
                list.addView(Button(this).apply {
                    text = title
                    isAllCaps = false
                    setOnClickListener { startActivity(intent) }
                })
            }
        }
        val root = ScrollView(this).apply { addView(list) }
        setContentView(root)
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
