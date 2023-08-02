package com.example.scopefunction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    //we use let usually null check
    private var number: Int? = null

    //for 'also' example
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * let
         */
        if(number != null) {
            val number2 = number + 1
        }

        //'?' means if number is not equal to null
        //it means this 'number' variable is safe at the time we actually call 'let' function
        //so if we change 'number' during the let block then 'it' won't be affected
        //so that is basically just the state of that variable(number) or that object at the time
        //we call let function. That's why it works
        number?.let {
            val number2 = it + 1
        }

        //'x' is unit. because let block returns the last line of it.
        //since now it is just variable declaration which this is basically type of 'unit'
        //we could solve this by adding 'number2' in last line.
        val x = number?.let {
            val number2 = it + 1
            number2
        } ?: 3


        /**
         * also
         */
        //'also' is similar with 'let'
        //'also' return the object it was called on
        //so from this example it will return result of (i*i) not last line of 'also' block
        fun getSquaredI() = (i * i).also {
            i++
        }

        /**
         * apply
         */
        //'apply' is helpful to modify objects
        //from example below, it will return 'intent' with all these changes applied in 'apply' block
        val intent = Intent().apply {
            putExtra("", "")
            action = ""
        }

        /**
         * run
         */
        //'run' is similar with 'apply'
        //but it won't return the object it called on. it returns last line of 'run' block
        // it is like 'let'
        //so in order to return intent object for this example add 'this' at last line
        val intent2 = Intent().run {
            putExtra("", "")
            action = ""
            this
        }

    }
}