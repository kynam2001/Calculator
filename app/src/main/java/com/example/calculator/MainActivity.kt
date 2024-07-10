package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    var input: TextView? = null
    var output: TextView? = null
    var b1: Button? = null
    var b2: Button? = null
    var b3: Button? = null
    var b4: Button? = null
    var b5: Button? = null
    var b6: Button? = null
    var b7: Button? = null
    var b8: Button? = null
    var b9: Button? = null
    var b0: Button? = null
    var dot: Button? = null
    var add: Button? = null
    var minus: Button? = null
    var multiply: Button? = null
    var divide: Button? = null
    var AC: Button? = null
    var C: Button? = null
    var equal: Button? = null
    var resutl: Float = 0.0f

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        input = findViewById(R.id.input)
        output = findViewById(R.id.output)
        // số
        b1 = findViewById(R.id.one)
        b2 = findViewById(R.id.two)
        b3 = findViewById(R.id.three)
        b4 = findViewById(R.id.four)
        b5 = findViewById(R.id.five)
        b6 = findViewById(R.id.six)
        b7 = findViewById(R.id.seven)
        b8 = findViewById(R.id.eight)
        b9 = findViewById(R.id.nine)
        b0 = findViewById(R.id.zero)
        // nút chức năng
        dot = findViewById(R.id.dot)
        add = findViewById(R.id.add)
        minus = findViewById(R.id.minus)
        multiply = findViewById(R.id.multiply)
        divide = findViewById(R.id.divide)
        AC = findViewById(R.id.AC)
        C = findViewById(R.id.C)
        equal = findViewById(R.id.equal)
        //
        b1?.setOnClickListener(View.OnClickListener {
            input?.text = input?.text.toString() + "1"
        })
        b2?.setOnClickListener(View.OnClickListener {
            input?.text = input?.text.toString() + "2"
        })
        b3?.setOnClickListener(View.OnClickListener {
            input?.text = input?.text.toString() + "3"
        })
        b4?.setOnClickListener(View.OnClickListener {
            input?.text = input?.text.toString() + "4"
        })
        b5?.setOnClickListener(View.OnClickListener {
            input?.text = input?.text.toString() + "5"
        })
        b6?.setOnClickListener(View.OnClickListener {
            input?.text = input?.text.toString() + "6"
        })
        b7?.setOnClickListener(View.OnClickListener {
            input?.text = input?.text.toString() + "7"
        })
        b8?.setOnClickListener(View.OnClickListener {
            input?.text = input?.text.toString() + "8"
        })
        b9?.setOnClickListener(View.OnClickListener {
            input?.text = input?.text.toString() + "9"
        })
        b0?.setOnClickListener(View.OnClickListener {
            input?.text = input?.text.toString() + "0"
        })
        dot?.setOnClickListener(View.OnClickListener {
            if(input?.text.toString().isEmpty()){
                output?.text = "Nhập lại"
            }
            else {
                if (input?.text.toString().last().isDigit()) {

                        input?.text = input?.text.toString() + "."

                }
            }
        })
        add?.setOnClickListener(View.OnClickListener {
            if (valid(input?.text.toString())){
                if (input?.text.toString().isDigitsOnly()){
                    input?.text = input?.text.toString() + "+"
                }
                else {
                    output?.text = Result(input)
                    if(output?.text.toString().toFloat() - output?.text.toString().toFloat().roundToInt() == 0f) {
                        input?.text = resutl.toString().dropLast(2)
                    }
                    else {
                        input?.text = resutl.toString()
                    }
                    input?.text = input?.text.toString() + "+"
                }
            }
            else{
                var arr = input?.text.toString()
                arr = arr.dropLast(1) + "+"
                input?.text = arr
            }
        })
        minus?.setOnClickListener(View.OnClickListener {
            if (valid(input?.text.toString())){
                if (input?.text.toString().isDigitsOnly()){
                    input?.text = input?.text.toString() + "-"
                }
                else {
                    output?.text = Result(input)
                    if(output?.text.toString().toFloat() - output?.text.toString().toFloat().roundToInt() == 0f) {
                        input?.text = resutl.toString().dropLast(2)
                    }
                    else {
                        input?.text = resutl.toString()
                    }
                    input?.text = input?.text.toString() + "-"
                }
            }
            else{
                var arr = input?.text.toString()
                arr = arr.dropLast(1) + "-"
                input?.text = arr
            }
        })
        multiply?.setOnClickListener(View.OnClickListener {
            if (valid(input?.text.toString())){
                if (input?.text.toString().isDigitsOnly()){
                    input?.text = input?.text.toString() + "*"
                }
                else {
                    output?.text = Result(input)
                    if(output?.text.toString().toFloat() - output?.text.toString().toFloat().roundToInt() == 0f) {
                        input?.text = resutl.toString().dropLast(2)
                    }
                    else {
                        input?.text = resutl.toString()
                    }
                    input?.text = input?.text.toString() + "*"
                }
            }
            else{
                var arr = input?.text.toString()
                arr = arr.dropLast(1) + "*"
                input?.text = arr
            }
        })
        divide?.setOnClickListener(View.OnClickListener {
            if (valid(input?.text.toString())){
                if (input?.text.toString().isDigitsOnly()){
                    input?.text = input?.text.toString() + "/"
                }
                else {
                    output?.text = Result(input)
                    if(output?.text.toString().toFloat() - output?.text.toString().toFloat().roundToInt() == 0f) {
                        input?.text = resutl.toString().dropLast(2)
                    }
                    else {
                        input?.text = resutl.toString()
                    }
                    input?.text = input?.text.toString() + "/"
                }
            }
            else{
                var arr = input?.text.toString()
                arr = arr.dropLast(1) + "/"
                input?.text = arr
            }
        })
        AC?.setOnClickListener(View.OnClickListener {
            input?.text = ""
            output?.text = ""
        })
        C?.setOnClickListener(View.OnClickListener {
            input?.text = input?.text.toString().dropLast(1)
        })
        equal?.setOnClickListener(View.OnClickListener {
            if (input?.text.toString().isNotEmpty()) {
                if (input?.text.toString().last().isDigit()) {
                    output?.text = Result(input)
                    if(output?.text.toString().toFloat() - output?.text.toString().toFloat().roundToInt() == 0f) {
                        input?.text = resutl.toString().dropLast(2)
                    }
                    else {
                        input?.text = resutl.toString()
                    }
                }
            }
            else{
                output?.text = "Nhập lại"
            }
        })
    }

    private fun valid(s1: String): Boolean {
        if (s1.isEmpty()){
            return true
        }
        if (s1[s1.length-1].isDigit()){
            return true
        }
        return false
    }

    fun Result(view: TextView?): String {
        val input = view!!.text.toString()
        var a: String
        var b: String
        if (input.contains("+")) {
            a = input.substring(0, input.indexOf("+"))
            b = input.substring(input.indexOf("+") + 1)
            resutl = a.toFloat() + b.toFloat()
            if(resutl - (a.toFloat() + b.toFloat()).toInt() == 0.0f){
                return resutl.toInt().toString()
            }
            return (a.toFloat() + b.toFloat()).toString()
        }
        if (input.contains("-")) {
            a = input.substring(0, input.indexOf("-"))
            b = input.substring(input.indexOf("-") + 1)
            resutl = a.toFloat() - b.toFloat()
            if(resutl - (a.toFloat() - b.toFloat()).toInt() == 0.0f){
                return resutl.toInt().toString()
            }
            return (a.toFloat() - b.toFloat()).toString()
        }
        if (input.contains("*")) {
            a = input.substring(0, input.indexOf("*"))
            b = input.substring(input.indexOf("*") + 1)
            resutl = a.toFloat() * b.toFloat()
            if(resutl - (a.toFloat() * b.toFloat()).toInt() == 0.0f){
                return resutl.toInt().toString()
            }
            return (a.toFloat() * b.toFloat()).toString()
        }
        if (input.contains("/")) {
            a = input.substring(0, input.indexOf("/"))
            b = input.substring(input.indexOf("/") + 1)
            if (b.toFloat() == 0.0f) {
                return "Không thể chia cho 0"
            }
            resutl = a.toFloat() / b.toFloat()
            if(resutl - (a.toFloat() / b.toFloat()).toInt() == 0.0f){
                return resutl.toInt().toString()
            }
            return (a.toFloat() / b.toFloat()).toString()
        }
        if (input.isDigitsOnly()|| input.contains(".")) {
            resutl = input.toFloat()
            return input
        }
        return "Nhập lại"
    }
//    fun check(s1: String):Boolean{
//
//        val operator = "+-x/"
//        var count = 0
//        for (i in s1){
//            if(i.equals(".")){
//                Log.e("123","check")
//                count++
//            }
//            if(operator.contains(i)){
//                Log.e("123","check2")
//                count--
//            }
//        }
//        if (count == 1){
//            return true
//        }
//        return false
//    }
//    private fun result(view: TextView?): String{
//        var input = view?.text.toString()
//        if (!input.last().isDigit()){
//            input = input.dropLast(1)
//        }
//        if (input.first().toString() != "-"){
//            input = input.drop(1)
//        }
//        var i = 0
//        var temp = 0
//        var result = 0
//        while (i<input.length){
//            if (input[i].toString() == "+"){
//                result += input.substring(temp,i).toFloat()
//                temp = i+1
//            }
//            i++
//        }
//        return result.toString()
//    }

}

