package pro.butovanton.gituser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import pro.butovanton.gituser1.R;

public class ListUsersFragment extends Fragment implements ItemClickListener {

public ViewModelMain viewModelMain;

private RecyclerView recyclerView;
private RecyclerAdapterGit adapter;
private LinearLayoutManager lm;
private ProgressBar progressBar;
private int i = 1;
private FloatingActionButton nextButton, prevButton;
private final int PERPAGE = 10;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar =view.findViewById(R.id.progressBar);

        prevButton = view.findViewById(R.id.fabnprev);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = i - PERPAGE;
                getData(i, PERPAGE);
            }
        });
        nextButton = view.findViewById(R.id.fabnext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = i + PERPAGE;
                getData(i, PERPAGE);
            }
        });

        recyclerView = view.findViewById(R.id.reciclerView);
        adapter = new RecyclerAdapterGit(this,getContext());
        lm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager( lm );

        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if ((lm.findLastVisibleItemPosition() + 1) % PERPAGE == 0) nextButton.show();
                else nextButton.hide();
                if (lm.findFirstVisibleItemPosition() % PERPAGE == 0 && i != 1) prevButton.show();
                else prevButton.hide();
            }
        });
    }

    void getData(int i, int PERPAGE) {
        progressBar.setVisibility(View.VISIBLE);
        Repo.getInstance().getUsers(i,PERPAGE);
    }

    @Override
    public void onItemClick(String login) {
        Bundle bundle = new Bundle();
        bundle.putString("login", login);
        NavHostFragment.findNavController(this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModelMain =  new ViewModelProvider(this).get(ViewModelMain.class);
        viewModelMain.getUsers(i,PERPAGE).observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> listUser) {
                progressBar.setVisibility(View.INVISIBLE);
                adapter.adnotify(listUser);

            }
        });

    }
}
