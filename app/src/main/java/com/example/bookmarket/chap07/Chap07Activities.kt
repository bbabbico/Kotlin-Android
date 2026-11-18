package com.example.bookmarket.chap07

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.bookmarket.R
import com.example.bookmarket.setScreen

class ActionBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch07_actionbar, edgeToEdge = false)
        supportActionBar?.title = "액션 바 예제"
        supportActionBar?.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.ch07_actionbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}

class ToolBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch07_toolbar, edgeToEdge = false)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setLogo(R.drawable.kitty)
        toolbar.setNavigationIcon(R.drawable.toolbar_menu)
        toolbar.title = "툴 바 예제"
        toolbar.subtitle = "ToolbarExample"
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setSubtitleTextColor(Color.parseColor("#F4511E"))
    }
}

class OptionMenuActivity : AppCompatActivity() {
    lateinit var textObj: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch07_options_menu, edgeToEdge = false)
        textObj = findViewById(R.id.textView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.ch07_options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(applicationContext, " 메뉴항목 : " + item.title, Toast.LENGTH_SHORT).show()
        when (item.itemId) {
            R.id.itemColorR -> {
                textObj.setTextColor(Color.RED)
                return true
            }
            R.id.itemColorG -> {
                textObj.setTextColor(Color.GREEN)
                return true
            }
            R.id.itemColorB -> {
                textObj.setTextColor(Color.BLUE)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

class ContextMenuActivity : AppCompatActivity() {
    lateinit var btnObj: Button
    lateinit var layoutObj: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch07_context_menu)
        layoutObj = findViewById(R.id.main)
        btnObj = findViewById(R.id.button)
        registerForContextMenu(btnObj)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.ch07_context_menu, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        Toast.makeText(applicationContext, " 메뉴항목 : " + item.title, Toast.LENGTH_SHORT).show()
        when (item.itemId) {
            R.id.itemColorR -> {
                layoutObj.setBackgroundColor(Color.RED)
                return true
            }
            R.id.itemColorG -> {
                layoutObj.setBackgroundColor(Color.GREEN)
                return true
            }
            R.id.itemColorB -> {
                layoutObj.setBackgroundColor(Color.BLUE)
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}

class PopupMenuActivity : AppCompatActivity() {
    lateinit var btnObj: Button
    lateinit var layoutObj: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreen(R.layout.ch07_popup_menu)
        layoutObj = findViewById(R.id.main)
        btnObj = findViewById(R.id.button)

        btnObj.setOnClickListener {
            val popupMenu = PopupMenu(this, btnObj)
            val inflater: MenuInflater = popupMenu.menuInflater
            inflater.inflate(R.menu.ch07_popup_menu, popupMenu.menu)
            popupMenu.show()
            popupMenu.setOnMenuItemClickListener { item ->
                Toast.makeText(applicationContext, " 메뉴항목 : " + item.title, Toast.LENGTH_SHORT).show()
                when (item.itemId) {
                    R.id.itemColorR -> layoutObj.setBackgroundColor(Color.RED)
                    R.id.itemColorG -> layoutObj.setBackgroundColor(Color.GREEN)
                    R.id.itemColorB -> layoutObj.setBackgroundColor(Color.BLUE)
                }
                true
            }
        }
    }
}
