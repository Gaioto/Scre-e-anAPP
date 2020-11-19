package general.dev.screean.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import general.dev.screean.ImageActivity
import general.dev.screean.R
import general.dev.screean.model.Imagem
import general.dev.screean.utils.base64ToBitmap

class ScreeanAdapter(private val context: Context): RecyclerView.Adapter<ScreeanAdapter.ScreeanViewHolder>(){

    var items: List<Imagem> = listOf()
    set(newList) {
        field = newList
        notifyDataSetChanged()
    }

    inner class ScreeanViewHolder: RecyclerView.ViewHolder{
        val imagem: ImageView
        val nome: TextView
        val card: CardView

        constructor(item: View): super(item){
            imagem = item.findViewById(R.id.image_screean)
            nome = item.findViewById(R.id.tv_name_image)
            card = item.findViewById(R.id.image_card)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreeanViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)
          return ScreeanViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScreeanViewHolder, position: Int) {
        val item = items[position]

        holder.imagem.setImageBitmap(base64ToBitmap(item.imagem))
        holder.nome.text = item.nome
        holder.card.setOnClickListener(){
            val item = items[position]
            val iId: Int? = item.id

            val intent = Intent(context, ImageActivity::class.java)
            intent.putExtra("iId", iId)

            context.startActivity(intent)
        }

    }

    override fun getItemCount() = items.size

}