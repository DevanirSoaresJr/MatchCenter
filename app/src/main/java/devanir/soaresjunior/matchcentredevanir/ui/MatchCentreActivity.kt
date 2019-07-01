package devanir.soaresjunior.matchcentredevanir.ui

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import devanir.soaresjunior.matchcentredevanir.MAN_UNITED
import devanir.soaresjunior.matchcentredevanir.R
import devanir.soaresjunior.matchcentredevanir.di.ActivityModule
import devanir.soaresjunior.matchcentredevanir.di.DaggerActivityComponent
import devanir.soaresjunior.matchcentredevanir.rvAdapters.AwayTeamAdapter
import devanir.soaresjunior.matchcentredevanir.rvAdapters.CommentaryAdapter
import devanir.soaresjunior.matchcentredevanir.rvAdapters.HomeTeamAdapter
import kotlinx.android.synthetic.main.activity_matchcentre.*
import javax.inject.Inject
import devanir.soaresjunior.matchcentredevanir.LEICESTER as LEICESTER

class MatchCentreActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MatchCentreViewModel

    private lateinit var commentaryAdapter: CommentaryAdapter
    private lateinit var homeTeamAdapter: HomeTeamAdapter
    private lateinit var awayTeamAdapter: AwayTeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matchcentre)
        DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)
        //NOT THE BEST PRACTICE SINCE WE LOADING IT FROM AN URL AND IT NOT A KNOWN API BUT WHY NOT JUST TO
        //MAKE THE APP LOOK BETTER ONCE RAN IN A DEVICE
        //HOWEVER THE LINKS ARE ON A CONSTANTS FILE WHICH CAN MAKE MAINTENANCE A BIT EASIER...
        //USING PICASSO THIS WAY IS MORE OF A TEMPORARY SOLUTION... ignore the caps lock was typing the constants...

    }

   @SuppressLint("SetTextI18n")
   override fun onResume() {
        super.onResume()
       Picasso
           .get()
           .load(MAN_UNITED)
           .into(imageTeam1)

       Picasso
           .get()
           .load(LEICESTER)
           .into(imageTeam2)

       viewModel.showMatchInfo().observe(this, Observer {
            //TextViews Match Data Info
            val teamAwayScore:String=it?.data?.awayTeam?.score.toString()
            val teamHomeScore:String=it?.data?.homeTeam?.score.toString()
            val homeTeam:String=it?.data?.homeTeam?.shortName.toString()
            val awayTeam:String=it?.data?.awayTeam?.shortName.toString()

            tvCompetition.text=it?.data?.competition
            tvScore.text = "$teamHomeScore : $teamAwayScore"
            tvTeams.text= "$homeTeam V.S. $awayTeam"

            //Home Team Starter 11, Names, Position, Shirt No. RecyclerView
            homeTeamAdapter = HomeTeamAdapter(it?.data?.homeTeam?.players!!)

            rvHomeTeam.apply {
                layoutManager = LinearLayoutManager(this@MatchCentreActivity)
                adapter = homeTeamAdapter
                addItemDecoration(DividerItemDecoration(this@MatchCentreActivity, LinearLayoutManager.VERTICAL))
            }
            //AwayTeam same impl like the homeTeam
            awayTeamAdapter = AwayTeamAdapter(it?.data.awayTeam.players!!)
            rvAwayTeam.apply {
                layoutManager = LinearLayoutManager(this@MatchCentreActivity)
                adapter = awayTeamAdapter
                addItemDecoration(DividerItemDecoration(this@MatchCentreActivity, LinearLayoutManager.VERTICAL))
            }


        })

            viewModel.fetchCommentary().observe(this, Observer{
                //Recycler View For Match Commentary
                commentaryAdapter = CommentaryAdapter(it?.data?.commentaryEntries!!)

           rvCommentary.apply{
               layoutManager = LinearLayoutManager(this@MatchCentreActivity)
               adapter = commentaryAdapter
               addItemDecoration(DividerItemDecoration(this@MatchCentreActivity, LinearLayoutManager.VERTICAL))
           }

       })

       viewModel.fetchCommentary()

    }

}
