package pro.butovanton.gituser;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDetail  {

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

    @SerializedName("followers")
    @Expose
    String followers;

    @SerializedName("following")
    @Expose
    String following;

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getFollowers() {
        return followers;
    }

    public String getFollowing() {
        return following;
    }
}
