package devanir.soaresjunior.matchcentredevanir.rvAdapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import devanir.soaresjunior.matchcentredevanir.R
import devanir.soaresjunior.matchcentredevanir.data.eventdetails.MatchInfoResponse

class HomeTeamAdapter(private val players: List<MatchInfoResponse.Data.HomeTeam.Player>):
    RecyclerView.Adapter<HomeTeamAdapter.HomeTeamVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTeamVH {
        return HomeTeamVH(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_team_home, parent, false))
    }

    override fun getItemCount(): Int = players.size

    override fun onBindViewHolder(holder: HomeTeamVH, position: Int) {
        holder.bind(players[position])
    }

    class HomeTeamVH(view: View): RecyclerView.ViewHolder(view){
        private val tvPlayerName: TextView = view.findViewById(R.id.tvPlayerName)
        private val tvShirtNumber: TextView = view.findViewById(R.id.tvShirtNumber)
        private val tvPosition: TextView = view.findViewById(R.id.tvPosition)
        private val tvStatus: TextView = view.findViewById(R.id.tvStatus)

        @SuppressLint("SetTextI18n")
        fun bind(player: MatchInfoResponse.Data.HomeTeam.Player){
            tvPlayerName.text = "${player.firstName} ${player.lastName}"
            tvPosition.text = player.position
            tvShirtNumber.text = player.shirtNumber.toString()
            tvStatus.text = player.status
        }
    }
}
