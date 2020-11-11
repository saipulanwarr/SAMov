package com.sa.samov.home.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sa.samov.R
import com.sa.samov.model.Plays

class PlaysAdapter(private var data: List<Plays>,
                   private val listener:(Plays) -> Unit)
    : RecyclerView.Adapter<PlaysAdapter.ViewHoler>() {

    lateinit var contextAdapter : Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlaysAdapter.ViewHoler {
        var layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.row_item_play, parent, false)
        return ViewHoler(inflatedView)
    }

    override fun getItemCount(): Int = data.size

    class ViewHoler(view : View) : RecyclerView.ViewHolder(view){
        private val tvTitle: TextView = view.findViewById(R.id.tv_kursi)

        private val tvImage: ImageView = view.findViewById(R.id.iv_poster_image)

        fun bindItem(data:Plays, listener: (Plays) -> Unit, context: Context){
            tvTitle.setText(data.nama)

            Glide.with(context)
                .load(data.url)
                    .apply(RequestOptions.circleCropTransform())
                .into(tvImage)

            itemView.setOnClickListener{
                listener(data)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHoler, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

}
