package com.example.laba3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clear = findViewById<Button>(R.id.button_clear);
        val del = findViewById<Button>(R.id.button_multi2);
        val multi = findViewById<Button>(R.id.button_multi);
        val minus = findViewById<Button>(R.id.button_minus);
        val plus = findViewById<Button>(R.id.button_plus);
        val abs = findViewById<Button>(R.id.button_abs);
        val persent = findViewById<Button>(R.id.button_persent);
        val rezult = findViewById<Button>(R.id.button_rezult);

        val zero = findViewById<Button>(R.id.button_zero);
        val one = findViewById<Button>(R.id.button_one);
        val two = findViewById<Button>(R.id.button_two);
        val three = findViewById<Button>(R.id.button_three);
        val four = findViewById<Button>(R.id.button_four);
        val five = findViewById<Button>(R.id.button_five);
        val six = findViewById<Button>(R.id.button_six);
        val seven = findViewById<Button>(R.id.button_seven);
        val eight = findViewById<Button>(R.id.button_eight);
        val nine = findViewById<Button>(R.id.button_nine);
        val dot = findViewById<Button>(R.id.button_dot);

        val text = findViewById<TextView>(R.id.text_rezult);
        var oper = "0";
        var zn = "";

        fun textSize(){
            if(text.text.length == 7){
                text.textSize = 70f;
            }
            if(text.text.length == 9){
                text.textSize = 65f;
            }
            if(text.text.length == 10){
                text.textSize = 60f;
            }
            if(text.text.length == 3 || text.text.length == 7){
                text.text = text.text.toString() + " ";
            }
        }

        fun clickValue(string: String){
            if (text.text.toString() == "0"){
                text.text = string
                oper = string
                zn = string
            }
            else{
                text.text = text.text.toString() + string
                oper+= string
                zn = string
            }
        }

        fun clickOper(string: String){
            oper+= string
        }

        fun operColor(button: Button){
            button.setBackgroundColor(getColor(R.color.white));
            button.setTextColor(0xffFF9800.toInt())
        }

        fun operDefColor(){
            del.setBackgroundColor(0xffFF9800.toInt());
            del.setTextColor(getColor(R.color.white))

            multi.setBackgroundColor(0xffFF9800.toInt());
            multi.setTextColor(getColor(R.color.white))

            minus.setBackgroundColor(0xffFF9800.toInt());
            minus.setTextColor(getColor(R.color.white))

            plus.setBackgroundColor(0xffFF9800.toInt());
            plus.setTextColor(getColor(R.color.white))
        }

        zero.setOnClickListener {
            textSize();
            operDefColor()
            if (text.text.toString() != "0"){
                if(zn == "-" || zn == "+" || zn == "/" || zn == "*"){
                    text.text = "";
                }
                else{
                    text.text = text.text.toString() + "0"
                }
                oper+= '0'
            }
            clickValue("0")
        }
        one.setOnClickListener {
            textSize()
            operDefColor()
            if(zn == "-" || zn == "+" || zn == "/" || zn == "*"){
                text.text = "";
            }
            clickValue("1")
        }
        two.setOnClickListener {
            textSize()
            operDefColor()
            if(zn == "-" || zn == "+" || zn == "/" || zn == "*"){
                text.text = "";
            }
            clickValue("2")
        }
        three.setOnClickListener {
            textSize()
            operDefColor()
            if(zn == "-" || zn == "+" || zn == "/" || zn == "*"){
                text.text = "";
            }
            clickValue("3")
        }
        four.setOnClickListener {
            textSize()
            operDefColor()
            if(zn == "-" || zn == "+" || zn == "/" || zn == "*"){
                text.text = "";
            }
            clickValue("4")
        }
        five.setOnClickListener {
            textSize()
            operDefColor()
            if(zn == "-" || zn == "+" || zn == "/" || zn == "*"){
                text.text = "";
            }
            clickValue("5")
        }
        six.setOnClickListener {
            textSize()
            operDefColor()
            if(zn == "-" || zn == "+" || zn == "/" || zn == "*"){
                text.text = "";
            }
            clickValue("6")
        }
        seven.setOnClickListener {
            textSize()
            operDefColor()
            if(zn == "-" || zn == "+" || zn == "/" || zn == "*"){
                text.text = "";
            }
            clickValue("7")
        }
        eight.setOnClickListener {
            textSize()
            operDefColor()
            if(zn == "-" || zn == "+" || zn == "/" || zn == "*"){
                text.text = "";
            }
            clickValue("8")
        }
        nine.setOnClickListener {
            textSize()
            operDefColor()
            if(zn == "-" || zn == "+" || zn == "/" || zn == "*"){
                text.text = "";
            }
            clickValue("9")
        }

        fun onOperatorButtonClicked(operator: String) {
            zn = operator
            clickOper(operator)
            when (operator) {
                "/" -> operColor(del)
                "*" -> operColor(multi)
                "-" -> operColor(minus)
                "+" -> operColor(plus)
            }
        }

        del.setOnClickListener { onOperatorButtonClicked("/") }
        multi.setOnClickListener { onOperatorButtonClicked("*") }
        minus.setOnClickListener { onOperatorButtonClicked("-") }
        plus.setOnClickListener { onOperatorButtonClicked("+") }


        abs.setOnClickListener {
            if ("-" in text.text.toString() && text.text.length == 12){
                text.text = text.text.toString().replace("-", "")
                text.textSize = 60f;
                return@setOnClickListener;
            }
            else if (text.text.length == 11){
                text.textSize = 50f;
                text.text = "-" + text.text.toString()
            }
            else if("-" in text.text.toString()){
                text.text = text.text.toString().replace("-", "")
            }
            else{
                textSize();
                text.text = "-" + text.text.toString()
            }

        }
        clear.setOnClickListener {
            text.text = "0"
            text.textSize = 90f;
        }
        rezult.setOnClickListener {
            try {
                val ex = ExpressionBuilder(oper.toString().replace(" ", "")).build();
                val rezult = ex.evaluate();

                val longRes = rezult.toLong();

                if (rezult == longRes.toDouble())
                {
                    text.text = longRes.toString();
                    oper = longRes.toString();
                }
                else
                {
                    text.text = rezult.toString();
                    oper = rezult.toString();
                }
            }
            catch (e: Exception){
                text.text = "Ошибка";
            }

            //text.text = oper.toString();
        }

        persent.setOnClickListener {
            if (text.text != "0"){
                text.text = (text.text.toString().toDouble() / 100).toString();
            }
        }
    }


}