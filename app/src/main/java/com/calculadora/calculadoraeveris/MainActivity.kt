package com.calculadora.calculadoraeveris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar!!.hide()

        numero_zero.setOnClickListener { AcrescentarUmaExpressao(string = "0", limpar = true) }
        numero_um.setOnClickListener { AcrescentarUmaExpressao(string = "1", limpar = true) }
        numero_dois.setOnClickListener { AcrescentarUmaExpressao(string = "2", limpar = true) }
        numero_tres.setOnClickListener { AcrescentarUmaExpressao(string = "3", limpar = true) }
        numero_quatro.setOnClickListener { AcrescentarUmaExpressao(string = "4", limpar = true) }
        numero_cinco.setOnClickListener { AcrescentarUmaExpressao(string = "5", limpar = true) }
        numero_seis.setOnClickListener { AcrescentarUmaExpressao(string = "6", limpar = true) }
        numero_sete.setOnClickListener { AcrescentarUmaExpressao(string = "7", limpar = true) }
        numero_oito.setOnClickListener { AcrescentarUmaExpressao(string = "8", limpar = true) }
        numero_nove.setOnClickListener { AcrescentarUmaExpressao(string = "9", limpar = true) }
        ponto.setOnClickListener { AcrescentarUmaExpressao(string = ".", limpar = true) }

        //Operadores

        adicao.setOnClickListener { AcrescentarUmaExpressao(string = "+", limpar = false) }
        subtracao.setOnClickListener { AcrescentarUmaExpressao(string = "-", limpar = false) }
        multplicacao.setOnClickListener { AcrescentarUmaExpressao(string = "*", limpar = false) }
        dividir.setOnClickListener { AcrescentarUmaExpressao(string = "/", limpar = false) }



        limpar.setOnClickListener {

            expressao.text = ""
            txt_resultado.text = ""
        }

        backspace.setOnClickListener {

            val string = expressao.text.toString()

            if (string.isNotBlank()) {
                expressao.text = string.substring(0, string.length - 1)
            }

            txt_resultado.text = ""

        }

        igual.setOnClickListener {
            try {
                val expressao = ExpressionBuilder(expressao.text.toString()).build()
                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()

                if (resultado == longResult.toDouble())
                    txt_resultado.text = longResult.toString()
                else
                    txt_resultado.text = resultado.toString()
            } catch (e: Exception){
                
            }

        }


    }

    fun AcrescentarUmaExpressao(string: String, limpar : Boolean) {

        if (txt_resultado.text.isNotEmpty()) {
            expressao.text =""
        }

        if (limpar){
            txt_resultado.text = ""
            expressao.append(string)
        }else{
            expressao.append(txt_resultado.text)
            expressao.append(string)
            txt_resultado.text = ""
        }


    }

}