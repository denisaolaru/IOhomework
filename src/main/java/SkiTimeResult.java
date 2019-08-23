public class SkiTimeResult {
    String minutes;
    String seconds;

    public SkiTimeResult ( String minutes , String seconds ) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public SkiTimeResult ( String[] word ) {
    }

    public String getMinutes () {
        return minutes;
    }

    public void setMinutes ( String minutes ) {
        this.minutes = minutes;
    }

    public String getSeconds () {
        return seconds;
    }

    public void setSeconds ( String seconds ) {
        this.seconds = seconds;
    }

    @Override
    public String toString () {
        return
                "minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }


}
