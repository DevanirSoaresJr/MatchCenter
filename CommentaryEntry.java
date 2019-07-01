
package devanir.soaresjunior.matchcentredevanir;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommentaryEntry {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("period")
    @Expose
    private Integer period;
    @SerializedName("time")
    @Expose
    private String time;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
