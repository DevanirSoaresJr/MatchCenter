package devanir.soaresjunior.matchcentredevanir.rvAdapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import devanir.soaresjunior.matchcentredevanir.R
import devanir.soaresjunior.matchcentredevanir.data.eventdetails.MatchInfoResponse

class AwayTeamAdapter(private val players2: List<MatchInfoResponse.Data.AwayTeam.Player>):
    RecyclerView.Adapter<AwayTeamAdapter.AwayTeamVH>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AwayTeamVH {
        return AwayTeamVH(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_team_away, parent, false))
    }

    override fun getItemCount(): Int = players2.size


    override fun onBindViewHolder(holder: AwayTeamVH, position: Int) {
        holder.bind(players2[position])
    }


    class AwayTeamVH(view: View): RecyclerView.ViewHolder(view) {
        private val tvPlayerName: TextView = view.findViewById(R.id.tvPlayerName2)
        private val tvShirtNumber: TextView = view.findViewById(R.id.tvShirtNumber2)
        private val tvPosition: TextView = view.findViewById(R.id.tvPosition2)
        private val tvStatus: TextView = view.findViewById(R.id.tvStatus2)

        @SuppressLint("SetTextI18n")
        fun bind(player: MatchInfoResponse.Data.AwayTeam.Player) {
            tvPlayerName.text = "${player.firstName} ${player.lastName}"
            tvPosition.text = player.position
            tvShirtNumber.text = player.shirtNumber.toString()
            tvStatus.text = player.status


        }
    }
}