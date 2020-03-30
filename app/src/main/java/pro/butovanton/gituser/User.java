package pro.butovanton.gituser;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("login")
    @Expose
    String login;

    @SerializedName("avatar_url")
    @Expose
    String avatar_url;

}
