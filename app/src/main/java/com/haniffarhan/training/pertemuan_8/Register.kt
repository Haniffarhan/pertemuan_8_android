package com.haniffarhan.training.pertemuan_8

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.register_layout.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.alert
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class Register : AppCompatActivity(),AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_layout)
        btn.setOnClickListener {
            val fullname = et_fullname.text.toString().trim()
            val username = et_username.text.toString().trim()
            val password = et_password.text.toString().trim()
            handleRegister(fullname, username, password)
        }
    }

    private fun handleRegister(fullname : String, username : String, password : String){
        info { "fullname = $fullname \n username = $username \n password = $password" }
        when{
            fullname.isEmpty() -> toast("fullname belum di isi")
            username.isEmpty() -> toast("username belum di isi")
            password.isEmpty() -> toast("password belum di isi")
            else -> alert(title = "Register", message = "Account Baru Telah Ditambahkan"){
                positiveButton(buttonText =  "OKE"){
                    onBackPressed()
                    finish()
                }
            isCancelable = false
            }.show()
        }
    }
}