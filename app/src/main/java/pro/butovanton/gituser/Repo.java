package pro.butovanton.gituser;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Repo {

    private static Repo Instance;
    private NetworkService networkService;
    private JSONPlaceHolderApi jsonPlaceHolderApi;
    MutableLiveData<List<User>> userMutableLiveData = new MutableLiveData<>();
    List<User> listUsers = new ArrayList<>();

    MutableLiveData<UserDetail> userDetailMutableLiveData = new MutableLiveData<>();

    private Repo() {
        networkService = NetworkService.getInstance();
        jsonPlaceHolderApi = networkService.getJSONApi();
    }

    public LiveData<List<User>> getUsers(Integer i, Integer p) {

            jsonPlaceHolderApi.getUsers(i,p).enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    listUsers = response.body();
                    userMutableLiveData.setValue(listUsers);
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    Log.d("DEBUG", t.toString());
                }
            });

        return userMutableLiveData;
    }

    public LiveData<UserDetail> getUserDetail(String login)    {

        jsonPlaceHolderApi.getUserDetail(login).enqueue(new Callback<UserDetail>() {
            @Override
            public void onResponse(Call<UserDetail> call, Response<UserDetail> response) {
                userDetailMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<UserDetail> call, Throwable t) {
                Log.d("DEBUG", t.toString());
            }
        });
        return userDetailMutableLiveData;
    }

    public static synchronized Repo getInstance() {
        if (Instance == null) {
            Instance = new Repo();
        }
        return Instance;
    }
}
