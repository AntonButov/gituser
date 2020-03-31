package pro.butovanton.gituser;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.squareup.picasso.Picasso;

import pro.butovanton.gituser1.R;
import pro.butovanton.gituser1.databinding.FragmentSecondBinding;
//import pro.butovanton.gituser1.databinding.FragmentSecondBinding;

public class UserDetailFragment extends Fragment {

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

        //imageView = view.findViewById(R.id.imageViewSecond);

        Bundle bundle = getArguments();
        String login = bundle.getString("login");

        Repo.getInstance().getUserDetail(login).observe(getViewLifecycleOwner(), new Observer<UserDetail>() {
            @Override
            public void onChanged(UserDetail userDetail) {
                Picasso
                        .get()
                        .load(userDetail.avatar_url)
                        .into(binding.imageViewSecond);

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

}