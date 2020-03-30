package pro.butovanton.gituser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


class ViewModelMain extends AndroidViewModel {
 //   public RecyclerAdapterGit recyclerAdapterGit;

    public ViewModelMain(@NonNull Application application) {
        super(application);
   //     recyclerAdapterGit = new RecyclerAdapterGit(application);
    }



//    public LiveData<List<User>> getUser(Integer i) {
//        return Repo.getInstance().getUsers(100);
//    }

}
