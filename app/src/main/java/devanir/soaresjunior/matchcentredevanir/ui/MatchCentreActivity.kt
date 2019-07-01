package devanir.soaresjunior.matchcentredevanir.ui

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import devanir.soaresjunior.matchcentredevanir.R
import devanir.soaresjunior.matchcentredevanir.di.ActivityModule
import devanir.soaresjunior.matchcentredevanir.di.DaggerActivityComponent
import devanir.soaresjunior.matchcentredevanir.recyclerviews.CommentaryAdapter
import devanir.soaresjunior.matchcentredevanir.recyclerviews.HomeTeamAdapter
import kotlinx.android.synthetic.main.activity_matchcentre.*
import javax.inject.Inject

class MatchCentreActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MatchCentreViewModel

    private lateinit var commentaryAdapter: CommentaryAdapter
    private lateinit var homeTeamAdapter: HomeTeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matchcentre)
        DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)


    }

   @SuppressLint("SetTextI18n")
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
            //tvScore.text = teamHomeScore + someSpace + colonChar + someSpace + teamAwayScore
            tvScore.text = "$teamHomeScore : $teamAwayScore"
            tvTeams.text= homeTeam + someSpace + versus + someSpace + awayTeam

            homeTeamAdapter = HomeTeamAdapter(it?.data?.homeTeam?.players!!)

            rvHomeTeam.apply {
                layoutManager = LinearLayoutManager(this@MatchCentreActivity)
                adapter = homeTeamAdapter
                addItemDecoration(DividerItemDecoration(this@MatchCentreActivity, LinearLayoutManager.VERTICAL))
            }
        })

       viewModel.fetchCommentary().observe(this, Observer{
            commentaryAdapter = CommentaryAdapter(it?.data?.commentaryEntries!!)

           rvCommentary.adapter = commentaryAdapter
           rvCommentary.layoutManager = LinearLayoutManager(this)
           rvCommentary.addItemDecoration(DividerItemDecoration(this@MatchCentreActivity, LinearLayoutManager.VERTICAL))


       })

       viewModel.fetchCommentary()

    }

}
