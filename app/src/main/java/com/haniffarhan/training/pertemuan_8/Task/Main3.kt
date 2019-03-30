package com.haniffarhan.training.pertemuan_8.Task

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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

class Main3 : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginView().setContentView(this)
        var login : Button = findViewById(R.id.btn_login)
        var email : EditText = findViewById(R.id.et_email)
        var pass : EditText = findViewById(R.id.et_pass)
//        var forgot : TextView = findViewById(R.id.tv_forgot)
//        var regis : TextView = findViewById(R.id.tv_regis)
        login.setOnClickListener {
            val user = email.text.toString().trim()
            val password = pass.text.toString().trim()
            handleLogin(user, password)
        }
    }

    class LoginView : AnkoComponent<Main3>{
        override fun createView(ui: AnkoContext<Main3>)=with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    padding = 10
                    verticalGravity = Gravity.CENTER
                    backgroundColor = R.color.grey
                }
                imageView{
                    setImageResource(R.drawable.firebase)
                }.lparams(width = matchParent, height = 200) {
                    bottomMargin = 25
                }
                textView{
                    hint = "WELCOME"
                    textSize = 25f
                    textColor = Color.CYAN
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 5
                }
                editText{
                    id = R.id.et_email
                    hint = "Email"
                    textSize = 20f
                    inputType = InputType.TYPE_CLASS_TEXT
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 15
                }
                editText {
                    id = R.id.et_pass
                    hint = "Password"
                    textSize = 20f
                    inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 15
                }
                button("LOGIN"){
                    id = R.id.btn_login
                    background = ColorDrawable(Color.YELLOW)
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 15
                    gravity = Gravity.CENTER
                }
                textView{
                    id = R.id.tv_forgot
                    hint = "Forgot your password?"
                    textSize = 15f
                    hintTextColor = Color.YELLOW
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 15
                }
                textView{
                    id = R.id.tv_regis
                    hint = "Not a member? Get registered in Firebase now!"
                    textSize = 15f
                    hintTextColor = Color.WHITE
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 15
                }
            }
        }

    }

    private fun handleLogin(email : String, password : String){
        info { "data email : $email, data password : $password" }
        if (email.equals("test") && password.equals("test123")){
            toast("Welcome Aboard $email")
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