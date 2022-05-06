package com.example.formvalidation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var name : EditText
    private lateinit var item : EditText
    private lateinit var rate : EditText
    private lateinit var total : TextView
    private lateinit var names : TextView
    private lateinit var discount : EditText
    private lateinit var discountValue : TextView
    private lateinit var netTotal : TextView
    private lateinit var gst : EditText
    private lateinit var gstValue : TextView
    private lateinit var grandTotal : TextView
    private lateinit var submit1 : Button
    private lateinit var submit2 : Button
    private lateinit var submit3 : Button
    private  var sum = 0.0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        names = findViewById(R.id.names)
        item = findViewById(R.id.item)
        rate = findViewById(R.id.rate)
        total = findViewById(R.id.total)
        discount = findViewById(R.id.discount)
        discountValue = findViewById(R.id.discountValue)
        netTotal = findViewById(R.id.netTotal)
        gst = findViewById(R.id.gst)
        gstValue = findViewById(R.id.gstValue)
        grandTotal = findViewById(R.id.grandTotal)
        submit1 = findViewById(R.id.submit)
        submit2 = findViewById(R.id.submit2)
        submit3 = findViewById(R.id.submit3)




        submit1.setOnClickListener {
            if (item.text.toString().isBlank() && rate.text.toString().isBlank() && name.text.toString().isBlank())
            {
                Toast.makeText(this, "Enter all the values", Toast.LENGTH_SHORT).show()
            }
            else {
                val items = item.text.toString().toDouble()
                val rates = rate.text.toString().toDouble()
                sum = items * rates
                total.text = sum.toString()
            }
        }

        submit2.setOnClickListener {

            if(discount.text.toString().isBlank())
            {
                Toast.makeText(this, "please enter discount value", Toast.LENGTH_SHORT).show()
            }
            else {
                var dis = discount.text.toString().toDouble()
                dis = (dis / 100)
                val tt = (sum * dis)
                discountValue.text = tt.toString()
                netTotal.text = (sum - tt).toString()
            }
        }

        submit3.setOnClickListener {
            if(gst.text.toString().isBlank())
            {
                Toast.makeText(this, "Please enter value of gst", Toast.LENGTH_SHORT).show()
            }

            else {
                var gstt = gst.text.toString().toDouble()
                gstt = (gstt / 100) * netTotal.text.toString().toDouble()
                gstValue.text = gstt.toString()

                val grand = gstt + (netTotal.text.toString().toDouble())
                grandTotal.text = grand.toString()
                names.text = name.text.toString()

            }


        }

    }

}



