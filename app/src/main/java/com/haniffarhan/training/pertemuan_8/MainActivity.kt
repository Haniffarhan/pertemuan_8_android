package com.haniffarhan.training.pertemuan_8

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            val username = et_username.text.toString().trim()
            val password = et_password.text.toString().trim()
            handleLogin(username, password)
        }

        tv_ca.setOnClickListener {
            toast("Pindah ke Halaman Register")
            startActivity(intentFor<Register>())
        }
    }

    //membuat fungsi atau methode untuk handleLogin
    private fun handleLogin(username : String, password : String){
//        debug {  } // Log.d
//        info {  } // Log.i
//        error {  } // Log.e

        //Log.i jika ditulis di java
        info { "data username :  $username , data password : $password" }
        if (username.equals("test") && password.equals("test123")){
            toast("Welcome Aboard $username")
        }else{
            alert(title = "Warning", message = "Password atau Username"){
                positiveButton(buttonText = "OKE"){
                    //
                }
            isCancelable = false
            }.show()
        }
    }
}
