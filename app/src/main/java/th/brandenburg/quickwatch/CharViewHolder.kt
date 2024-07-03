package th.brandenburg.quickwatch

import android.media.Image
import android.service.quicksettings.Tile
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val nameView: TextView = itemView.findViewById(R.id.name)
    val imageView: ImageView = itemView.findViewById(R.id.image)
    val personaView: TextView = itemView.findViewById(R.id.persona)
    val textView: TextView = itemView.findViewById(R.id.chartext)
}