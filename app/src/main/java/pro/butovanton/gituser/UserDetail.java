package pro.butovanton.gituser;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDetail extends BaseObservable {

    @SerializedName("login")
    @Expose
    String login;

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("avatar_url")
    @Expose
    String avatar_url;

    @SerializedName("email")
    @Expose
    String email;

    @SerializedName("bio")
    @Expose
    String bio;

    @SerializedName("public_repos")
    @Expose
    String public_repos;

    @SerializedName("created_at")
    @Expose
    String created_at;

    @SerializedName("updated_at")
    @Expose
    String updated_at;

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public void setName(String name) {
        this.name = name;
    }
}
