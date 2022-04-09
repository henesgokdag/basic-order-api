package org.example.clients;

import org.example.models.swapi.PeopleResponse;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class SwapiServiceClient {
    private static SwapiService swapiService;

    public static SwapiService createSwapiService() {
        swapiService = new Retrofit.Builder()
                .baseUrl("http://localhost:8083/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(SwapiService.class);
        return swapiService;
    }


    public interface SwapiService {
        @GET("people/{id}")
        Call<PeopleResponse> getPeople(@Path("id") Long peopleId);
    }
}
