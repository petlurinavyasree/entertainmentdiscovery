package model.movie;

import java.util.List;

public class MovieData {
    private String movieName;
    private String actorName;
    private List<RelatedMovies> relatedMovies;

    @Override
    public String toString() {
        return "MovieData{" +
                "movieName='" + movieName + '\'' +
                ", actorName='" + actorName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieData movieData = (MovieData) o;

        if (!movieName.equals(movieData.movieName)) return false;
        return actorName.equals(movieData.actorName);
    }

    @Override
    public int hashCode() {
        int result = movieName.hashCode();
        result = 31 * result + actorName.hashCode();
        return result;
    }

    public String getMovieName() {

        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public List<RelatedMovies> getRelatedMovies() {
        return relatedMovies;
    }

    public void setRelatedMovies(List<RelatedMovies> relatedMovies) {
        this.relatedMovies = relatedMovies;
    }
}
