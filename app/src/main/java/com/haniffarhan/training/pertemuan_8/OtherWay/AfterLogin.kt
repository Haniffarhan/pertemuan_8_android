package com.haniffarhan.training.pertemuan_8.OtherWay

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.haniffarhan.training.pertemuan_8.R
import org.jetbrains.anko.*

class AfterLogin : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AfterLoginView().setContentView(this)
    }

    class AfterLoginView : AnkoComponent<AfterLogin>{
        override fun createView(ui: AnkoContext<AfterLogin>)=with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    padding = 30
                    verticalGravity = Gravity.CENTER
                    backgroundColor = R.color.abuabu
                }
                textView{
                    hint = "WELCOME"
                    textSize = 50f
                    textColor = Color.CYAN
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 5
                }
                textView{
                    hint = "uname"
                    textSize = 25f
                    textColor = Color.CYAN
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }.lparams(width = matchParent, height = wrapContent){
                    margin = 5
                }
            }
        }
    }
}