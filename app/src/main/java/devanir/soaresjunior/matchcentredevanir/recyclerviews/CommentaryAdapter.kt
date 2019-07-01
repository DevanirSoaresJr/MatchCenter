package devanir.soaresjunior.matchcentredevanir.recyclerviews

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import devanir.soaresjunior.matchcentredevanir.R
import devanir.soaresjunior.matchcentredevanir.data.commentary.CommentaryResponse
import kotlinx.android.synthetic.main.item_commentary.view.*

class CommentaryAdapter : RecyclerView.Adapter<CommentaryAdapter.CommentaryVH>(){

    private val commentaryList: List<CommentaryResponse.Data.CommentaryEntry> = arrayListOf()

    fun setData(commentaryList:ArrayList<CommentaryResponse.Data.CommentaryEntry>){
        commentaryList.clear()
        commentaryList.addAll(commentaryList)
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentaryVH {
        return CommentaryVH(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_commentary, parent, false))
    }

    override fun getItemCount(): Int {
        return commentaryList.size
    }

    override fun onBindViewHolder(vh: CommentaryVH, position: Int) {
     vh.bind(commentaryList[position])
    }
    class CommentaryVH(view: View):RecyclerView.ViewHolder(view){

       private val tvComment:TextView = view.findViewById(R.id.tvComment)

        fun bind(commentaryEntry: CommentaryResponse.Data.CommentaryEntry){
            tvComment.text=commentaryEntry.comment
        }
    }
}