package com.sa.samov.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sa.samov.CheckoutActivity
import com.sa.samov.R
import com.sa.samov.model.Checkout
import com.sa.samov.model.Film
import kotlinx.android.synthetic.main.activity_pilih_bangku.*

class PilihBangkuActivity : AppCompatActivity() {

    var statusA3:Boolean = false
    var statusA4:Boolean = false
    var total:Int = 0

    private var dataList = ArrayList<Checkout>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_bangku)

        val data = intent.getParcelableExtra<Film>("data")

        tv_kursi.text = data?.judul

        a3.setOnClickListener {
            if(statusA3){
                a3.setImageResource(R.drawable.ic_rectangle_empty)
                statusA3 = false
                total -= 1
                beliTiket(total)
            }else{
                a3.setImageResource(R.drawable.ic_rectangle_selected)
                statusA3 = true
                total += 1
                beliTiket(total)

                val data = Checkout("A3", "7000")
                dataList.add(data)
            }
        }

        a4.setOnClickListener {
            if(statusA4){
                a4.setImageResource(R.drawable.ic_rectangle_empty)
                statusA4 = false
                total -= 1
                beliTiket(total)
            }else{
                a4.setImageResource(R.drawable.ic_rectangle_selected)
                statusA4 = true
                total += 1
                beliTiket(total)

                val data = Checkout("A4", "7000")
                dataList.add(data)
            }
        }
    }

    private fun beliTiket(total: Int) {
        if(total == 0){
            btn_home.setText("Beli Tiket")
            btn_home.visibility = View.INVISIBLE
        }else{
            btn_home.setText("Beli Tiket ($total) ")
            btn_home.visibility = View.VISIBLE
        }
    }
}