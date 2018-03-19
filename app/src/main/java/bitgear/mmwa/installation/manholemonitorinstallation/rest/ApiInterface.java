package bitgear.mmwa.installation.manholemonitorinstallation.rest;

import java.util.List;

import bitgear.mmwa.installation.manholemonitorinstallation.domain.Manhole;
import bitgear.mmwa.installation.manholemonitorinstallation.domain.ManholesResponse;
import bitgear.mmwa.installation.manholemonitorinstallation.model.MoviesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("manhole")
    Call<List<Manhole>> getTopRatedMovies(@Header("Authorization") String authHeader);

    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
