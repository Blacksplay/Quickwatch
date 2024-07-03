package th.brandenburg.quickwatch

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CharAdapter(private val context: Context, private val charItem: List<CharItem>) :
    RecyclerView.Adapter<CharViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.chars, parent, false)
        return CharViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: CharViewHolder, position: Int) {
        val currentItem = charItem[position]
        holder.nameView.text = currentItem.name
        holder.textView.text = currentItem.text
        holder.personaView.text = currentItem.persona
        holder.imageView.setImageResource(currentItem.image)
    }

    override fun getItemCount(): Int {
        return charItem.size
    }
}