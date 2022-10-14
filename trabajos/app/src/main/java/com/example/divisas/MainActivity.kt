package com.example.divisas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.divisas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener{
    private lateinit var divisa1:Spinner
    private lateinit var divisa2:Spinner
    private var selected:Int=0
    private var selected2:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val num1=binding.num1
        val res=binding.res
        divisa1=binding.spinner1
        divisa2=binding.spinner2

        ArrayAdapter.createFromResource(
            this,
            R.array.tipo,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.spinner1.adapter = adapter
            binding.spinner2.adapter = adapter
        }
divisa1.onItemSelectedListener=this
divisa2.onItemSelectedListener=this
binding.calcular.setOnClickListener{
    val div=num1.text.toString().toDouble()
    when(selected){
        0->{
            when (selected2){
                0->{
                    val result=div
                    res.text=String.format("Cantidad de dolar: %.2f",result)
                }
                1->{
                    val result=div*1.02
                    res.text=String.format("Cantidad de dolar a euro es: %.2f",result)
                }
                2->{
                    val result=div*19.97
                    res.text=String.format("Cantidad de dolar a peso es: %.2f",result)
                }
            }
        }
        1->{
            when (selected2){
                0->{
                    val result=div*0.98
                    res.text=String.format("Cantidad de euro a dolar es: %.2f",result)
                }
                1->{
                    val result=div
                    res.text=String.format("Cantidad de euro: %.2f",result)
                }
                2->{
                    val result=div*19.55
                    res.text=String.format("Cantidad de euro a peso es: %.2f",result)
                }
            }
        }
        2->{
            when (selected2){
                0->{
                    val result=div*0.050
                    res.text=String.format("Cantidad de peso a dolar es: %.2f",result)
                }
                1->{
                    val result=div*0.051
                    res.text=String.format("Cantidad de peso a euro es: %.2f",result)
                }
                2->{
                    val result=div
                    res.text=String.format("Cantidad de peso: %.2f",result)
                }
            }
        }
    }
}
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (p0?.id==divisa1.id){
            selected=p2
        }
        if (p0?.id==divisa2.id){
            selected2=p2
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}
