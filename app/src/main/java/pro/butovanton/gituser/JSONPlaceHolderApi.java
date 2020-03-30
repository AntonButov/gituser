package pro.butovanton.gituser;


import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {
    @Headers({"Authorization: token "+ "69b70329537854658dd0ef326f6efcd72561c3e1"})
    @GET("/users")
    public Call<List<User>> getUsers (@Query("since") Integer i, @Query("per_page") Integer p );

    @GET("users/{user}")
    Call<UserDetail> getUserDetail(@Path("user") String login);
}
