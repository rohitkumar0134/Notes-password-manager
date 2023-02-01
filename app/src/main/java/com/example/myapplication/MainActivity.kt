package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.adapter.FragmentPagerAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
//    databinding
   lateinit var binding:ActivityMainBinding



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

val menuAdapter=FragmentPagerAdapter(initFragment(),supportFragmentManager)
        binding.viewpg.adapter=menuAdapter

        binding.navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.navigation_password -> {
                    binding.viewpg.currentItem =0

                }
                R.id.navigation_notes ->{
                    binding.viewpg.currentItem =1
                }

            }
            true
        }
        binding.viewpg.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                binding.navigation.menu.getItem(position).setChecked(true)

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

    }

    private fun initFragment():ArrayList<Fragment>{
        return arrayListOf(
            passwordlist.newInstance(),
            Noteslist.newInstance()

        )
    }

 }

