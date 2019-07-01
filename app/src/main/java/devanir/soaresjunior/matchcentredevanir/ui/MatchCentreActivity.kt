package devanir.soaresjunior.matchcentredevanir.ui

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import devanir.soaresjunior.matchcentredevanir.R
import devanir.soaresjunior.matchcentredevanir.data.commentary.CommentaryResponse
import devanir.soaresjunior.matchcentredevanir.di.ActivityModule
import devanir.soaresjunior.matchcentredevanir.di.DaggerActivityComponent
import devanir.soaresjunior.matchcentredevanir.recyclerviews.CommentaryAdapter
import kotlinx.android.synthetic.main.activity_matchcentre.*
import javax.inject.Inject

class MatchCentreActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MatchCentreViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matchcentre)
        DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)


    }

   override fun onResume() {
        super.onResume()

        viewModel.showMatchInfo().observe(this, Observer {
            val teamAwayScore:String=it?.data?.awayTeam?.score.toString()
            val teamHomeScore:String=it?.data?.homeTeam?.score.toString()
            val homeTeam:String=it?.data?.homeTeam?.shortName.toString()
            val awayTeam:String=it?.data?.awayTeam?.shortName.toString()
            val colonChar = ":"
            val versus = "V.S."
            val someSpace = " "
            tvCompetition.text=it?.data?.competition
            tvScore.text = teamHomeScore + someSpace + colonChar + someSpace + teamAwayScore
            tvTeams.text= homeTeam + someSpace + versus + someSpace + awayTeam
        })
       rvCommentary.layoutManager = LinearLayoutManager(this)
       val commentaryAdapter = CommentaryAdapter()
       viewModel.commentaryData.observe(this, Observer{
                   commentaryAdapter.setData(it.data.commentaryEntries)

       })

       viewModel.fetchCommentary()

    }

}
