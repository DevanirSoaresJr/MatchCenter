package devanir.soaresjunior.matchcentredevanir.recyclerviews

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import devanir.soaresjunior.matchcentredevanir.R
import devanir.soaresjunior.matchcentredevanir.data.commentary.CommentaryResponse
import kotlinx.android.synthetic.main.item_commentary.view.*

class CommentaryAdapter constructor(val commentary: List<CommentaryResponse.Data.CommentaryEntry>)
    : RecyclerView.Adapter<CommentaryAdapter.CommentaryVH>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentaryVH {
        return CommentaryVH(LayoutInflater.from(parent.context).inflate(R.layout.item_commentary, parent, false))
    }

    override fun getItemCount(): Int {
        return commentary.size
    }

    override fun onBindViewHolder(p0: CommentaryAdapter.CommentaryVH, position: Int) {
      val itemCommentary = commentary.get(position)
    }
    class CommentaryVH(view: View):RecyclerView.ViewHolder(view){
        val tvComment:TextView = view.findViewById(R.id.tvComment)
    }
}