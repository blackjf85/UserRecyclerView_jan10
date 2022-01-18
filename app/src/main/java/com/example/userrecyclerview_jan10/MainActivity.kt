package com.example.userrecyclerview_jan10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userrecyclerview_jan10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        with(binding) {

            viewModel.users.observe(this@MainActivity) { users ->
                // .apply allows you to modify multiple fields of an object
                userRv.apply {
                    adapter = UserAdapter(users)
                    // Tells reyclerview orientation
                    layoutManager =
                        LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                }
            }

            submitBtn.setOnClickListener {
                val firstName = firstNameEt.editText?.text.toString()
                val lastName = lastNameEt.editText?.text.toString()

                val user = User(firstName, lastName)

                viewModel.addUser(user)
            }
        }
    }
}