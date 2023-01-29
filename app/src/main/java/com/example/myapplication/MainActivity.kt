package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
//    databinding
   lateinit var binding:ActivityMainBinding
    private val passwordfragment=passwordlist.newInstance()
    private val noteslistfragment=Noteslist.newInstance()
    var fragmentSwitchStatus: Int? = null
    lateinit var viewPager:ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //databinding
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.searchlayout.setOnClickListener{
            Toast.makeText(this,"search click",Toast.LENGTH_SHORT).show()
            var intent= Intent(applicationContext,searchlist::class.java)
            startActivity(intent)
        }
//starting from password fragment
        replaceFragment(passwordfragment)
        fragmentSwitchStatus = 0
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)



    }
    private val mOnNavigationItemSelectedListener=BottomNavigationView.OnNavigationItemSelectedListener{item->
        when(item.itemId){
            R.id.navigation_password->{
                replaceFragment(passwordfragment)
                fragmentSwitchStatus = 0
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notes-> {
                replaceFragment(noteslistfragment)
                fragmentSwitchStatus = 1
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment!=null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }

}