

package dev.leyla.movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        List<Movie> movies = movieRepository.findAll();
        // Log the retrieved movies
        System.out.println("Retrieved movies: " + movies);
        return movies;
    }

    public Optional<Movie> singleMovie(String imdbId) {
        Optional<Movie> movie = movieRepository.findMovieByImdbId(imdbId);
        // Log the retrieved movie
        System.out.println("Retrieved movie: " + movie);
        return movie;
    }
}

