package org.adrianitos.hackviolettest2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager
    private lateinit var tab: TabLayout
    private lateinit var bar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)
        bar = findViewById(R.id.toolbar)


        setSupportActionBar(bar)


        val adapter = TabsAdapter(supportFragmentManager)


        adapter.addFragment(QAFragment(), "Preguntas")
        adapter.addFragment(CodeFragment(), "Guía de precios")
        adapter.addFragment(DirectoryFragment(), "Directorio")


        pager.adapter = adapter


        tab.setupWithViewPager(pager)
    }


}