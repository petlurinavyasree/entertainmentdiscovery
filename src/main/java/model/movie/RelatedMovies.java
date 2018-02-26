package model.movie;

import java.util.Date;

public class RelatedMovies {
    private String movieName;
    private Date releaseDate;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RelatedMovies that = (RelatedMovies) o;

        if (!movieName.equals(that.movieName)) return false;
        return releaseDate.equals(that.releaseDate);
    }

    @Override
    public int hashCode() {
        int result = movieName.hashCode();
        result = 31 * result + releaseDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "RelatedMovies{" +
                "movieName='" + movieName + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
