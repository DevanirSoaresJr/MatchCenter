
package devanir.soaresjunior.matchcentredevanir;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("feedMatchId")
    @Expose
    private Integer feedMatchId;
    @SerializedName("homeTeamName")
    @Expose
    private String homeTeamName;
    @SerializedName("homeTeamId")
    @Expose
    private String homeTeamId;
    @SerializedName("homeScore")
    @Expose
    private Integer homeScore;
    @SerializedName("awayTeamName")
    @Expose
    private String awayTeamName;
    @SerializedName("awayTeamId")
    @Expose
    private String awayTeamId;
    @SerializedName("awayScore")
    @Expose
    private Integer awayScore;
    @SerializedName("competitionId")
    @Expose
    private Integer competitionId;
    @SerializedName("competition")
    @Expose
    private String competition;
    @SerializedName("commentaryEntries")
    @Expose
    private List<CommentaryEntry> commentaryEntries = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getFeedMatchId() {
        return feedMatchId;
    }

    public void setFeedMatchId(Integer feedMatchId) {
        this.feedMatchId = feedMatchId;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(String homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public String getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(String awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    public Integer getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public List<CommentaryEntry> getCommentaryEntries() {
        return commentaryEntries;
    }

    public void setCommentaryEntries(List<CommentaryEntry> commentaryEntries) {
        this.commentaryEntries = commentaryEntries;
    }

}
