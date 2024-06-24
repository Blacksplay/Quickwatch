package th.brandenburg.quickwatch

import android.media.Image
import android.service.quicksettings.Tile
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val imageView: ImageView = itemView.findViewById(R.id.image)
    val titleView: TextView = itemView.findViewById(R.id.titel)
    val directorView: TextView = itemView.findViewById(R.id.director)
}