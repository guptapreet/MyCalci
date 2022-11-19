package com.guptapreet.mycalci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvone.setOnClickListener {
            evaluateExpression("1", clear = true)
        }
        tvtwo.setOnClickListener {
            evaluateExpression("2", clear = true)
        }
        tvthree.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        tvfour.setOnClickListener {
            evaluateExpression("4", clear = true)
        }
        tvfive.setOnClickListener {
            evaluateExpression("5", clear = true)
        }
        tvsix.setOnClickListener {
            evaluateExpression("6", clear = true)
        }
        tvseven.setOnClickListener {
            evaluateExpression("7", clear = true)
        }
        tveight.setOnClickListener {
            evaluateExpression("8", clear = true)
        }
        tvnine.setOnClickListener {
            evaluateExpression("9", clear = true)
        }
        tvzero.setOnClickListener {
            evaluateExpression("0", clear = true)
        }
        tvplus.setOnClickListener {
            evaluateExpression("+", clear = true)
        }
        tvminus.setOnClickListener {
            evaluateExpression("-", clear = true)
        }
        tvmultiply.setOnClickListener {
            evaluateExpression("*", clear = true)
        }
        tvdiv.setOnClickListener {
            evaluateExpression("/", clear = true)
        }
        tvdot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }
        tvclear.setOnClickListener {
            tvExp.text = ""
            tvResult.text = ""
        }
        tvequals.setOnClickListener {
            val text = tvExp.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tvResult.text = longResult.toString()
            } else {
                tvResult.text = result.toString()
            }
        }

        tvback.setOnClickListener {
            val text = tvExp.text.toString()
            if(text.isNotEmpty()) {
                tvExp.text = text.drop(1)
            }

            tvResult.text = ""
        }
    }
    fun evaluateExpression(string: String, clear: Boolean) {
        if(tvResult.text.isNotEmpty()){
            tvExp.text= tvResult.text
        }

        if(clear) {
            tvResult.text = ""
            tvExp.append(string)
        } else {
            tvExp.append(tvResult.text)
            tvExp.append(string)
            tvResult.text = ""
        }
    }
}
