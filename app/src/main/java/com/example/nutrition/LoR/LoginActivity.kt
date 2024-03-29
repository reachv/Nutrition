package com.example.nutrition.LoR

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.nutrition.MainActivity
import com.example.nutrition.R
import com.parse.LogInCallback
import com.parse.ParseUser
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //Variables
        var loginUsername : EditText = findViewById(R.id.LoginUsername)
        var loginPassword : EditText = findViewById(R.id.LoginPassword)
        var loginCheck : CheckBox = findViewById(R.id.LoginCheck)
        var loginButton : Button = findViewById(R.id.LoginButton)
        var loginRegister : Button = findViewById(R.id.LoginRegisterButton)

        //Preservation
        if(ParseUser.getCurrentUser() != null){
            goMain()
        }
        val sharedPref = getSharedPreferences("UserPref", MODE_PRIVATE)
        val prevUser : String? = sharedPref.getString("username", "");
        if(!prevUser.isNullOrEmpty()){
            loginUsername.setText(prevUser)
        }
        val prevPass : String? = sharedPref.getString("password", "")
        if(!prevPass.isNullOrEmpty()){
            loginPassword.setText(prevPass)
        }

        //Register + Login
        loginRegister.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        loginButton.setOnClickListener {
            val usernamePattern : Pattern = Pattern.compile("[A-Za-z0-9]{5,24}")
            if(!usernamePattern.matcher(loginUsername.text.toString()).matches()){
                Toast.makeText(this, "Username must not contain symbols", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            ParseUser.logInInBackground(loginUsername.text.toString(), loginPassword.text.toString(), LogInCallback { user, e ->
                if(e !=  null){
                    Log.e("LoginActivity 55:", e.toString())
                    return@LogInCallback
                }
                if(loginCheck.isActivated){
                    val shared = getSharedPreferences("UserPref", MODE_PRIVATE)
                    val sharedEdit = shared.edit()

                    sharedEdit.putString("username", loginUsername.text.toString())
                    sharedEdit.putString("password", loginPassword.text.toString())
                    sharedEdit.apply()
                }
                goMain()
            })
        }

    }
    fun goMain(){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}