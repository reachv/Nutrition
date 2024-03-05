package com.example.nutrition.LoR

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.nutrition.MainActivity
import com.example.nutrition.R
import com.parse.LogInCallback
import com.parse.ParseUser
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Declarations
        var registerUser : EditText = findViewById(R.id.RegisterUsername)
        var registerEmail : EditText = findViewById(R.id.RegisterEmail)
        var registerPassword : EditText = findViewById(R.id.RegisterPassword)
        var registerButton : Button = findViewById(R.id.RegisterButton)

        //Registry
        registerButton.setOnClickListener {
            val username : String = registerUser.text.toString()
            val password : String = registerPassword.text.toString()
            val email : String = registerEmail.text.toString()
            if(!verifyUser(username, password, email)){
                return@setOnClickListener
            }

            val user = ParseUser()
            user.username = username
            user.setPassword(password)
            user.email = email
            user.signUpInBackground {
                if(it != null){
                    Toast.makeText(this, "Failed to register", Toast.LENGTH_SHORT).show()
                    Log.e("Registry 29:", it.toString())
                    return@signUpInBackground
                }
                ParseUser.logInInBackground(registerUser.text.toString(), registerPassword.text.toString(), LogInCallback { user, e ->
                    if(e != null){
                        Toast.makeText(this, "Failed to create account", Toast.LENGTH_SHORT).show()
                        Log.e("Registry 39:", e.toString())
                        return@LogInCallback
                    }
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                })
            }
        }
    }
    //Verification
    private fun verifyUser(username : String, password : String, email : String) : Boolean{
        var res = true
        if(!userVerify(username, email) || !passwordVerify(password)){
            res = false
        }
        return res
    }
    private fun userVerify(username : String, email : String): Boolean {
        var res = true
        val usernamePattern : Pattern = Pattern.compile("[A-Za-z0-9]{5,24}")
        if(!usernamePattern.matcher(username).matches()){
            Toast.makeText(this, "Username must be alphanumeric", Toast.LENGTH_SHORT).show()
            res = false
        }else{
            val userQuery = ParseUser.getQuery()
            userQuery.findInBackground { objects, e ->
                if (e != null) {
                    Log.e("Registry 78:", e.toString())
                    return@findInBackground
                }
                for (i in objects) {
                    if (i.username.equals(username)) {
                        Toast.makeText(this, "Username already exist, Try again", Toast.LENGTH_SHORT).show()
                        res = false
                        break
                    }
                }
            }
        }
        return res
    }
    private fun passwordVerify(password : String) : Boolean{
        val passwordPattern : Pattern = Pattern.compile("[a-zA-Z0-9!@#$]{8,24}")
        return !password.isNullOrBlank() && passwordPattern.matcher(password).matches()
    }
}