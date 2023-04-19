package yash.com.example.weddingManagement

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdaptor (
    private var context: Context,
    private var postModelList: List<Model>,
): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageCard: ImageView = itemView.findViewById(R.id.image)
        var titleCard: TextView = itemView.findViewById(R.id.title)
        var descCard: TextView = itemView.findViewById(R.id.desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view  = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = postModelList[position]
        val viewHolder = holder as? ViewHolder
        viewHolder!!.titleCard.text = currentItem.title
        viewHolder.descCard.text = currentItem.desc
        viewHolder.imageCard.setImageResource(currentItem.image)

    }

    override fun getItemCount(): Int {
        return postModelList.size
    }


}