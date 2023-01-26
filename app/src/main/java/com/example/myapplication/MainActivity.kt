package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val passwordfragment=passwordlist()
    private val noteslistfragment=Noteslist()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var search =findViewById(R.id.searchlayout) as LinearLayout
        search.setOnClickListener{
            Toast.makeText(this,"search click",Toast.LENGTH_SHORT).show()
            var intent= Intent(applicationContext,searchlist::class.java)
            startActivity(intent)
        }

        replaceFragment(passwordfragment)
        var bottom_navigation=findViewById<BottomNavigationView>(R.id.navigation)


        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_password->replaceFragment(passwordfragment)
                R.id.navigation_notes->replaceFragment(noteslistfragment)

            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment!=null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }
    private fun replacesearchFragment(fragment: Fragment){
        if (fragment!=null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_search_container,fragment)
            transaction.commit()
        }
    }
}