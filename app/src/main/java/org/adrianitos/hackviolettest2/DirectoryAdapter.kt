package org.adrianitos.hackviolettest2


import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView

class DirectoryAdapter(private val mList: List<ItemsDirectoryViewModel>) : RecyclerView.Adapter<DirectoryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_organization, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]



        holder.imageViewONG.setImageResource(ItemsViewModel.imageONG)
        holder.ongName.setText(ItemsViewModel.nameONG)
        holder.category.setText("Categoría: "+ItemsViewModel.category)
        holder.direction.setText(ItemsViewModel.direction)


        if(ItemsViewModel.directionURL.length == 0)
            holder.directionImageURL.background = null
        holder.directionURL.setOnClickListener{
            if(ItemsViewModel.directionURL.length > 0){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ItemsViewModel.directionURL))

                holder.itemView.context.startActivity(intent)
            }

        }
        holder.btnOpenURL.setOnClickListener{
            if(ItemsViewModel.urlView.length > 0){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ItemsViewModel.urlView))

                holder.itemView.context.startActivity(intent)
            }
        }

        holder.phone.setText("Telefono: " +  ItemsViewModel.phone)


    }

    override fun getItemCount(): Int {
        return mList.size
    }



    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageViewONG: ImageView = itemView.findViewById(R.id.imageviewONG)
        val ongName: TextView = itemView.findViewById(R.id.textViewONGName)
        val category: TextView = itemView.findViewById(R.id.textViewCategory)
        val direction: TextView = itemView.findViewById(R.id.textViewDirection)
        val directionURL: Button = itemView.findViewById(R.id.btnDirectionURL)
        val directionImageURL: AppCompatImageButton = itemView.findViewById(R.id.btnImageURL)
        val phone: TextView = itemView.findViewById(R.id.textViewPhone)
        val btnOpenURL: Button = itemView.findViewById(R.id.btnOpenURLONG)
    }
}