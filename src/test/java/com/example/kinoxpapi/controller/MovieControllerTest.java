import com.example.kinoxpapi.KinoXpApiApplication;
import com.example.kinoxpapi.controller.MovieController;
import com.example.kinoxpapi.model.Movie;
import com.example.kinoxpapi.repository.MovieRepository;
import com.example.kinoxpapi.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

      
@ActiveProfiles("test")
@WebMvcTest(MovieController.class) // Replace with your actual controller name if different
@SpringBootTest
@ContextConfiguration(classes = KinoXpApiApplication.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService; // Replace with your actual service interface

    @MockBean
    private MovieRepository movieRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieController movieController;


    @Autowired
    private ObjectMapper objectMapper;
  
  @Transactional
    @Test
    void deactivateMovie() {
        Movie lionKing = movieRepository.save(new Movie("Lionking", 125, "En meget god film med løver", 12, "URL", true));

        movieController.deactivateMovie(lionKing.getMovieId());
        Optional<Movie> updatedLionKing = movieRepository.findById(lionKing.getMovieId());


        assertFalse(updatedLionKing.get().isInRotation());
    }

    @Test
    void testPostMovie_Success() throws Exception {
        // Arrange
        Movie movie = new Movie();
        movie.setMovieId(1);
        movie.setMovieTitle("Interstellar");
        movie.setMovieLength(169);
        movie.setMovieDescription("A team of explorers travel through a wormhole in space...");
        movie.setAgeRequirement(12);
        movie.setMoviePosterUrl("http://example.com/poster.jpg");
        movie.setInRotation(true);

        Optional<Movie> optionalMovie = Optional.of(movie);

        Mockito.when(movieService.saveMovie(any(Movie.class))).thenReturn(optionalMovie);

        // Act & Assert
        mockMvc.perform(post("/movie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movie)))
                .andExpect(status().isOk()) // 200 OK if movie is returned
                .andExpect(jsonPath("$.movieId").value(1))
                .andExpect(jsonPath("$.movieTitle").value("Interstellar"))
                .andExpect(jsonPath("$.movieLength").value(169))
                .andExpect(jsonPath("$.movieDescription").value("A team of explorers travel through a wormhole in space..."))
                .andExpect(jsonPath("$.ageRequirement").value(12))
                .andExpect(jsonPath("$.moviePosterUrl").value("http://example.com/poster.jpg"))
                .andExpect(jsonPath("$.inRotation").value(true));
    }
}