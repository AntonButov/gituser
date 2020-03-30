package pro.butovanton.gituser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.squareup.picasso.Picasso;

import pro.butovanton.gituser1.R;

public class SecondFragment extends Fragment {

    private  User user;
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

        Bundle bundle = getArguments();
        int i = bundle.getInt("userId");

        user = Repo.getInstance().getUser(i);

        imageView = view.findViewById(R.id.imageViewSecond);
        Picasso
                .get()
                .load(user.avatar_url)
                .into(imageView);


    }
}
