package com.example.bookmarket.chap08

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.bookmarket.R
import com.example.bookmarket.setScreen
import java.util.Calendar
import kotlin.math.round
import kotlin.math.roundToInt

class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch08_alert)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setIcon(R.drawable.dialog_kitty)
            alertDialog.setTitle("AlertDialog")
            alertDialog.setMessage("앱을 종료하겠습니까?")
            alertDialog.setPositiveButton("예") { _, _ -> finish() }
            alertDialog.setNegativeButton("아니요") { dialog, _ ->
                Toast.makeText(this, "종료를 취소합니다.", Toast.LENGTH_LONG).show()
                dialog.cancel()
            }
            alertDialog.show()
        }
    }
}

class AlertDialog02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch08_alert02)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val listItems = arrayOf("Android App", "Kotlin", "Java")
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setIcon(R.drawable.dialog_kitty)
            alertDialog.setTitle("AlertDialog")
            val itemListener = DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, listItems[which], Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }
            val btnListener = DialogInterface.OnClickListener { dialog, _ -> dialog.cancel() }
            alertDialog.setItems(listItems, itemListener)
            alertDialog.setPositiveButton("예", btnListener)
            alertDialog.show()
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val listItems = arrayOf("Android App", "Kotlin", "Java")
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setIcon(R.drawable.dialog_kitty)
            alertDialog.setTitle("AlertDialog")
            val itemListener = DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, listItems[which], Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }
            val btnListener = DialogInterface.OnClickListener { dialog, _ -> dialog.cancel() }
            alertDialog.setSingleChoiceItems(listItems, -1, itemListener)
            alertDialog.setPositiveButton("예", btnListener)
            alertDialog.show()
        }

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            val listItems = arrayOf("Android App", "Kotlin", "Java")
            val checkedArray = booleanArrayOf(true, false, false)
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setIcon(R.drawable.dialog_kitty)
            alertDialog.setTitle("AlertDialog")
            val itemListener = DialogInterface.OnMultiChoiceClickListener { dialog, which, b ->
                Toast.makeText(this, listItems[which], Toast.LENGTH_LONG).show()
                checkedArray[which] = b
                dialog.dismiss()
            }
            val btnListener = DialogInterface.OnClickListener { dialog, _ -> dialog.cancel() }
            alertDialog.setMultiChoiceItems(listItems, checkedArray, itemListener)
            alertDialog.setPositiveButton("예", btnListener)
            alertDialog.show()
        }
    }
}

class CustomDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch08_custom)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.ch08_custom_dialog, null)
            alertDialog.setView(dialogView)
            val dialog = alertDialog.show()
            val close: Button = dialogView.findViewById(R.id.close)
            close.setOnClickListener {
                val name: EditText = dialogView.findViewById(R.id.name)
                dialog.dismiss()
                Toast.makeText(this, "당신의 이름은 " + name.text + "입니다", Toast.LENGTH_LONG).show()
            }
        }
    }
}

class DateTimePickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch08_datetime)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val calendar = Calendar.getInstance()
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)
            val listener = DatePickerDialog.OnDateSetListener { _, y, m, dayOfMonth ->
                Toast.makeText(this, "선택날짜 : " + y + "년 " + (m + 1) + "월 " + dayOfMonth + "일", Toast.LENGTH_LONG).show()
            }
            val pickerDialog = DatePickerDialog(this, listener, year, month, day)
            pickerDialog.setTitle("DatePickerDialog")
            pickerDialog.show()
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val listener = TimePickerDialog.OnTimeSetListener { _, hourOfDay, m ->
                Toast.makeText(this, "선택시간 : " + hourOfDay + "시 " + m + "분", Toast.LENGTH_LONG).show()
            }
            val pickerDialog = TimePickerDialog(this, listener, hour, minute, true)
            pickerDialog.setTitle("TimePickerDialog")
            pickerDialog.show()
        }
    }
}

class PizzaActivity : AppCompatActivity() {
    lateinit var btnPizzaObj: Button
    lateinit var btnToppingObj: Button
    lateinit var ivBgObj: ImageView
    lateinit var ivPizzaObj: ImageView
    lateinit var btnOrderObj: Button
    lateinit var tvPizzaObj: TextView
    lateinit var tvToppingObj: TextView
    lateinit var ivDeliveryObj: ImageView
    lateinit var tvDeliveryObj: TextView
    val drawablePizza = intArrayOf(R.drawable.pizza1, R.drawable.pizza2, R.drawable.pizza3, R.drawable.pizza4)
    val drawableTopping = intArrayOf(
        R.drawable.topping1, R.drawable.topping2, R.drawable.topping3, R.drawable.topping4, R.drawable.topping5
    )
    val imageViewTopping = intArrayOf(R.id.topping1, R.id.topping2, R.id.topping3, R.id.topping4, R.id.topping5)
    val ivToppingObj = arrayOfNulls<ImageView>(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch08_pizza)

        btnPizzaObj = findViewById(R.id.button_pizza)
        btnToppingObj = findViewById(R.id.button_toppting)
        btnToppingObj.isEnabled = false
        ivBgObj = findViewById(R.id.imageView_bg)
        ivPizzaObj = findViewById(R.id.pizza)
        for (i in 0..4) ivToppingObj[i] = findViewById(imageViewTopping[i])
        btnOrderObj = findViewById(R.id.button_order)
        btnOrderObj.isEnabled = false
        tvPizzaObj = findViewById(R.id.textView_pizza)
        tvToppingObj = findViewById(R.id.textView_toppting)
        ivDeliveryObj = findViewById(R.id.delivery)
        tvDeliveryObj = findViewById(R.id.textView_delivery)

        var selectNum = 0
        var oldNum = 0

        btnPizzaObj.setOnClickListener {
            val listItems = arrayOf("마르게리타 피자", "불고기 피자", "양송이 피자", "하와이안 피자")
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setIcon(R.drawable.icon_pizza)
            alertDialog.setTitle("주문할 피자를 선택하세요")
            val itemListener = DialogInterface.OnClickListener { _, which ->
                Toast.makeText(this, listItems[which], Toast.LENGTH_LONG).show()
                selectNum = which
            }
            val btnListener = DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        dialog.dismiss()
                        ivBgObj.isVisible = false
                        ivDeliveryObj.isVisible = false
                        tvDeliveryObj.isVisible = false
                        btnToppingObj.isEnabled = true
                        btnOrderObj.isEnabled = true
                        ivPizzaObj.isVisible = true
                        tvPizzaObj.isVisible = true
                        ivPizzaObj.setImageResource(drawablePizza[selectNum])
                        tvPizzaObj.text = listItems[selectNum]
                        oldNum = selectNum
                        tvToppingObj.text = ""
                    }
                    DialogInterface.BUTTON_NEGATIVE -> dialog.cancel()
                }
                dialog.cancel()
            }
            alertDialog.setSingleChoiceItems(listItems, oldNum, itemListener)
            alertDialog.setPositiveButton("예", btnListener)
            alertDialog.setNegativeButton("아니요", btnListener)
            alertDialog.show()
        }

        btnToppingObj.setOnClickListener {
            val listItems = arrayOf("양송이", "불고기", "바질", "베이컨", "해물")
            val checkedArray = booleanArrayOf(false, false, false, false, false)
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setIcon(R.drawable.icon_pizza)
            alertDialog.setTitle("추가할 토핑을 선택하세요")
            val itemListener = DialogInterface.OnMultiChoiceClickListener { _, which, b ->
                Toast.makeText(this, listItems[which], Toast.LENGTH_LONG).show()
                checkedArray[which] = b
            }
            val btnListener = DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        dialog.dismiss()
                        ivBgObj.isVisible = false
                        tvToppingObj.isVisible = true
                        var str = "토핑추가 : "
                        for (i in 0..4) {
                            ivToppingObj[i]?.isVisible = false
                            if (checkedArray[i]) {
                                ivToppingObj[i]?.isVisible = true
                                ivToppingObj[i]?.setImageResource(drawableTopping[i])
                                str += listItems[i] + " "
                            }
                        }
                        tvToppingObj.text = str
                    }
                    DialogInterface.BUTTON_NEGATIVE -> dialog.cancel()
                }
                dialog.cancel()
            }
            alertDialog.setMultiChoiceItems(listItems, checkedArray, itemListener)
            alertDialog.setPositiveButton("예", btnListener)
            alertDialog.setNegativeButton("아니요", btnListener)
            alertDialog.show()
        }

        btnOrderObj.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setMessage("주문하겠습니까?")
            alertDialog.setIcon(R.drawable.icon_pizza)
            val listener = DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        ivDeliveryObj.isVisible = true
                        tvDeliveryObj.isVisible = true
                        dialog.dismiss()
                    }
                    DialogInterface.BUTTON_NEGATIVE -> dialog.cancel()
                }
            }
            alertDialog.setPositiveButton("예", listener)
            alertDialog.setNegativeButton("아니요", listener)
            alertDialog.show()
        }
    }
}

class CalculatorActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var tvInput: TextView
    private var tvResultCheck = false
    private var tvInputCheck = false
    private var FirstNum: Double = 0.0
    private var SecondNum: Double = 0.0
    private var ResultNum: Double = 0.0
    private var ArithOper: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch08_calc)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.ch08_calc_dialog, null)
            builder.setView(dialogView)
            val dialog = builder.show()
            tvResult = dialogView.findViewById(R.id.tvResult)
            tvInput = dialogView.findViewById(R.id.tvIntput)
            val buttonclose: Button = dialogView.findViewById(R.id.buttonclose)
            buttonclose.setOnClickListener { dialog.dismiss() }
        }
    }

    private fun format(num: Double) = if (num % 1.0 == 0.0) num.toLong().toString() else num.toString()

    private fun calculate(): Double {
        val result = when (ArithOper) {
            "+" -> FirstNum + SecondNum
            "-" -> FirstNum - SecondNum
            "x" -> FirstNum * SecondNum
            else -> FirstNum / SecondNum
        }
        return round(result * 1000000000) / 1000000000
    }

    fun numClick(view: View) {
        if (!tvResultCheck) tvResult.text = ""
        tvResult.append((view as ImageButton).tag.toString())
        tvResultCheck = true
        SecondNum = tvResult.text.toString().toDouble()
    }

    fun BackClick(view: View) {
        var str = tvResult.text.toString()
        if (str.isNotEmpty()) {
            str = str.substring(0, str.length - 1)
            tvResult.text = str
            SecondNum = str.toDoubleOrNull() ?: 0.0
        }
    }

    fun ClearClick(view: View) {
        tvResult.text = ""
        tvResultCheck = false
        SecondNum = 0.0
    }

    fun ACClick(view: View) {
        tvResult.text = ""
        tvInput.text = ""
        tvResultCheck = false
        tvInputCheck = false
        FirstNum = 0.0
        SecondNum = 0.0
        ArithOper = ""
    }

    fun DotClick(view: View) {
        val dotCheck = tvResult.text.contains(".")
        if (!tvResultCheck) {
            tvResult.text = "0."
            tvResultCheck = true
        } else if (!dotCheck) {
            tvResult.append(".")
        }
    }

    fun OperClick(view: View) {
        val btn = (view as ImageButton).tag.toString()
        if (!tvInputCheck) {
            tvInput.text = format(SecondNum) + " " + btn
            FirstNum = SecondNum
            tvInputCheck = true
            tvResultCheck = false
        } else {
            if (!tvResultCheck) {
                tvInput.text = format(FirstNum) + " " + btn
            } else {
                ResultNum = calculate()
                tvInput.text = format(ResultNum) + " " + btn
                tvResultCheck = false
                FirstNum = ResultNum
            }
        }
        ArithOper = btn
    }

    fun EqualClick(view: View) {
        tvInput.text = format(FirstNum) + " " + ArithOper + " " + format(SecondNum) + " = "
        ResultNum = calculate()
        tvInput.append(format(ResultNum))
        FirstNum = ResultNum
        tvResultCheck = false
    }
}

class TimeQuizActivity : AppCompatActivity() {
    lateinit var ivQestion: ImageView
    lateinit var ivAnswer: ImageView
    lateinit var ivAmPm: ImageView
    lateinit var resultTime: String
    lateinit var resultAMPM: String
    var question = 0
    var ampm = 0
    val drawableQuestion = intArrayOf(
        R.drawable.question1, R.drawable.question2, R.drawable.question3, R.drawable.question4, R.drawable.question5
    )
    val drawableAnswerAM = intArrayOf(
        R.drawable.answer11, R.drawable.answer12, R.drawable.answer13, R.drawable.answer14, R.drawable.answer15
    )
    val drawableAnswerPM = intArrayOf(
        R.drawable.answer21, R.drawable.answer22, R.drawable.answer23, R.drawable.answer24, R.drawable.answer25
    )
    val timeAnswerAM = arrayOf("9:15", "2:25", "10:35", "11:40", "3:10")
    val timeAnswerPM = arrayOf("21:15", "14:25", "22:35", "23:40", "15:10")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch08_time_quiz)

        ivQestion = findViewById(R.id.question)
        ivAnswer = findViewById(R.id.answer)
        ivAmPm = findViewById(R.id.ampm)
        newQuestion()

        val buttonStart: Button = findViewById(R.id.buttonStart)
        buttonStart.setOnClickListener {
            newQuestion()
            ivAnswer.isVisible = false
        }

        val buttonTime: Button = findViewById(R.id.buttonTime)
        buttonTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val listener = TimePickerDialog.OnTimeSetListener { _, selHour, selMinute ->
                resultAMPM = if (selHour > 12) "PM" else "AM"
                resultTime = "$selHour:$selMinute"
                val answers = if (resultAMPM == "AM") timeAnswerAM else timeAnswerPM
                val images = if (resultAMPM == "AM") drawableAnswerAM else drawableAnswerPM
                if (resultTime == answers[question]) {
                    ivAnswer.isVisible = true
                    ivAnswer.setImageResource(images[question])
                    Toast.makeText(applicationContext, "맞았습니다", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "틀렸습니다", Toast.LENGTH_LONG).show()
                }
            }
            val timePickerDialog = TimePickerDialog(this, R.style.TimePickerStyle, listener, hour, minute, true)
            timePickerDialog.show()
        }
    }

    private fun newQuestion() {
        question = (Math.random() * 3).roundToInt()
        ampm = (Math.random() * 1).roundToInt()
        ivQestion.setImageResource(drawableQuestion[question])
        ivAmPm.setImageResource(if (ampm == 0) R.drawable.time_am else R.drawable.time_pm)
    }
}
