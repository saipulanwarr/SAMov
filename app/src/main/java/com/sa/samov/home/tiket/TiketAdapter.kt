package com.sa.samov.home.tiket

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sa.samov.R
import com.sa.samov.model.Checkout
import java.text.NumberFormat
import java.util.*

class TiketAdapter(private var data: List<Checkout>,
                   private val listener:(Checkout) -> Unit)
    : RecyclerView.Adapter<TiketAdapter.ViewHoler>() {

    lateinit var contextAdapter : Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TiketAdapter.ViewHoler {
        var layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.row_item_checkout_white, parent, false)
        return ViewHoler(inflatedView)
    }

    override fun getItemCount(): Int = data.size

    class ViewHoler(view : View) : RecyclerView.ViewHolder(view){
        private val tvTitle: TextView = view.findViewById(R.id.tv_kursi)

        fun bindItem(data:Checkout, listener: (Checkout) -> Unit, context: Context){
            tvTitle.setText("Seat no ${data.kursi}")

            itemView.setOnClickListener{
                listener(data)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHoler, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

}
