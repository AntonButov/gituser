package pro.butovanton.gituser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;

import com.squareup.picasso.Picasso;

import pro.butovanton.gituser1.R;

public class SecondFragment extends Fragment {

    private ImageView imageView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = view.findViewById(R.id.imageViewSecond);

        Bundle bundle = getArguments();
        String login = bundle.getString("login");

        Repo.getInstance().getUserDetail(login).observe(getViewLifecycleOwner(), new Observer<UserDetail>() {
            @Override
            public void onChanged(UserDetail userDetail) {
                Picasso
                        .get()
                        .load(userDetail.avatar_url)
                        .into(imageView);
            }
        });


    }
}
