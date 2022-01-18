package com.example.userrecyclerview_jan10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.userrecyclerview_jan10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {


            submitBtn.setOnClickListener {
                val firstName = firstNameEt.editText?.text.toString()
                val lastName = lastNameEt.editText?.text.toString()

                val user = User(firstName, lastName)
            }
        }
    }
}