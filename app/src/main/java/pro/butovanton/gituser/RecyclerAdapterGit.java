package pro.butovanton.gituser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import pro.butovanton.gituser1.R;

class RecyclerAdapterGit extends RecyclerView.Adapter<RecyclerAdapterGit.ViewHolderGit> {

    private FirstFragment firstFragment;
    private List<User> listUsers;
    private final LayoutInflater mInflater;

    public RecyclerAdapterGit(FirstFragment firstFragment, Context context) {
        this.firstFragment = firstFragment;
        mInflater = LayoutInflater.from(context);
        listUsers = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolderGit onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item, parent, false);
        ViewHolderGit vh = new ViewHolderGit(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerAdapterGit.ViewHolderGit holder, final int position) {
        holder.loginTextView.setText(listUsers.get(position).login);
        holder.loginTextView.setAlpha(0f);
        holder.loginTextView.animate()
                .alpha(1f)
                .setDuration(1000);

        Picasso
                .get()
                .load(listUsers
                .get(position)
                .avatar_url)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }


    public void adnotify(List<User> listUsers) {
        this.listUsers = listUsers;

        notifyDataSetChanged();
    }

    public class ViewHolderGit extends RecyclerView.ViewHolder {
        private final TextView loginTextView;
        private final ImageView imageView;


        public ViewHolderGit(View view) {
            super(view);
            loginTextView = (TextView) view.findViewById(R.id.name);
            imageView =  view.findViewById(R.id.imageView);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    firstFragment.onItemClick(getAdapterPosition());
                }
            });

        }


    }

}
