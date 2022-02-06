package org.adrianitos.hackviolettest2


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QAAdapter(private val mList: List<ItemsQAViewModel>) : RecyclerView.Adapter<QAAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_qa, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsQAViewModel = mList[position]



        holder.question.setText(ItemsQAViewModel.question)



    }

    override fun getItemCount(): Int {
        return mList.size
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val question: TextView = itemView.findViewById(R.id.textViewQuestion)

    }
}