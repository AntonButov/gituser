package pro.butovanton.gituser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import pro.butovanton.gituser.databinding.FragmentSecondBinding;

public class UserDetailFragment extends Fragment {

    private FragmentSecondBinding binding;
    private ViewModelMain viewModelMain;

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

        Bundle bundle = getArguments();
        String login = bundle.getString("login");
        binding.progressBarDetail.setVisibility(View.VISIBLE);
        viewModelMain = new ViewModelProvider(requireActivity()).get(ViewModelMain.class);
        viewModelMain.getUserDetail(login).observe(getViewLifecycleOwner(), new Observer<UserDetail>() {
            @Override
            public void onChanged(UserDetail userDetail) {
                Picasso
                        .get()
                        .load(userDetail.avatar_url)
                        .into(binding.imageViewSecond, new Callback() {
                            @Override
                            public void onSuccess() {
                                binding.progressBarDetail.setVisibility(View.INVISIBLE);
                            }

                            @Override
                            public void onError(Exception e) {

                            }
                        });

                if (userDetail.email == null) binding.emailtextView.setVisibility(View.INVISIBLE);
                if (userDetail.bio == null) binding.biotextView.setVisibility(View.INVISIBLE);

                animatiorTextView(binding.logintextView);
                animatiorTextView(binding.nametextView);
                animatiorTextView(binding.followerstextView);
                animatiorTextView(binding.followingtextView);
                animatiorTextView(binding.createdtextView);
                animatiorTextView(binding.updatedAttextView);
                animatiorTextView(binding.emailtextView);
                animatiorTextView(binding.biotextView);

                binding.setUserDetail(userDetail);
            }
        });

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    void animatiorTextView(TextView textView) {
        textView.setAlpha(0f);
        textView.animate()
                .alpha(1f)
                .setDuration(1000);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
