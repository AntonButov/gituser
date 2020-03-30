package pro.butovanton.gituser;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;

import com.squareup.picasso.Picasso;

import pro.butovanton.gituser1.R;
import pro.butovanton.gituser1.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private ImageView imageView;
    private FragmentSecondBinding binding;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false);

        return binding.getRoot();
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

                binding.setUserDetail(userDetail);

            }
        });

    }
}
