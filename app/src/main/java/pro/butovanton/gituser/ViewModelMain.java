package pro.butovanton.gituser;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;


class ViewModelMain extends ViewModel {
 //   public RecyclerAdapterGit recyclerAdapterGit;

public LiveData<List<User>> getUsers(int i, int p ) {
    return Repo.getInstance().getUsers(i,p);
}

public LiveData<UserDetail> getUserDetail(String login) {
   return Repo.getInstance().getUserDetail(login);
}

}
