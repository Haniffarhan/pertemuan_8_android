package com.haniffarhan.training.pertemuan_8.OtherWay

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.haniffarhan.training.pertemuan_8.R
import org.jetbrains.anko.*

class Regis2 : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RegisView().setContentView(this)
        var btn : Button = findViewById(R.id.btn_regis)
        var fullnm : EditText = findViewById(R.id.et_fullname)
        var uname : EditText = findViewById(R.id.et_username_regis)
        var passwd : EditText = findViewById(R.id.et_password_regis)
        btn.setOnClickListener {
            val fullname = fullnm.text.toString().trim()
            val username = uname.text.toString().trim()
            val password = passwd.text.toString().trim()
            handleRegis(fullname, username, password)
        }
    }

    class RegisView : AnkoComponent<Regis2>{
        override fun createView(ui: AnkoContext<Regis2>)= with(ui) {
            verticalLayout {
                lparams(width = matchParent, height = wrapContent){
                    margin = 15
                    padding = 20
                }
                textView{
                    hint = "REGISTER"
                    textSize = 25f
                    textColor = Color.CYAN
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 5
                }
                editText{
                    id = R.id.et_fullname
                    hint = "Fullname"
                    textSize = 20f
                    inputType = InputType.TYPE_CLASS_TEXT
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 15
                }
                editText{
                    id = R.id.et_username_regis
                    hint = "Username"
                    textSize = 20f
                    inputType = InputType.TYPE_CLASS_TEXT
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 15
                }
                editText {
                    id = R.id.et_password_regis
                    hint = "Password"
                    textSize = 20f
                    inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 15
                }
                button("REGISTER"){
                    id = R.id.btn_regis
                }.lparams(width = wrapContent, height = wrapContent){
                    margin = 15
                    gravity = Gravity.CENTER
                }
            }
        }

    }

    private fun handleRegis(fullname : String, username : String,
                            password : String){
        info { "data fullname : $fullname, data username : $username," +
                "data password : $password" }
        if (fullname.equals("")){
            alert(title = "Warning", message = "Fullname kosong") {
                positiveButton(buttonText = "OKE"){
                    //
                }
                isCancelable = false
            }.show()
        }else if(username.equals("")){
            alert(title = "Warning", message = "Username kosong") {
                positiveButton(buttonText = "OKE"){
                    //
                }
                isCancelable = false
            }.show()
        }else if(password.equals("")){
            alert(title = "Warning", message = "Password kosong") {
                positiveButton(buttonText = "OKE"){
                    //
                }
                isCancelable = false
            }.show()
        }else{
            alert(title = "Attention", message = "User telah dibuat") {
                positiveButton(buttonText = "OKE"){
                    startActivity(intentFor<Main2>())
                }
                isCancelable = false
            }.show()
        }
    }
}