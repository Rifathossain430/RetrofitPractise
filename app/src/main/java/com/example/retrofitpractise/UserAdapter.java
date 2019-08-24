package com.example.retrofitpractise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitpractise.mojoclass.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHoldwer> {
    private List<User> users;
    private Context context;

    public UserAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHoldwer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item,parent,false);
        return new ViewHoldwer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoldwer holder, int position) {
        User user= users.get(position);
        holder.id.setText(String.valueOf(user.getId()));
        holder.postId.setText(String.valueOf(user.getPostId()));
        holder.email.setText(user.getEmail());
        holder.body.setText(user.getBody());
        holder.name.setText(user.getName());



    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHoldwer extends RecyclerView.ViewHolder {
        private TextView postId,id,email,body,name;
        public ViewHoldwer(@NonNull View itemView) {
            super(itemView);
            postId= itemView.findViewById(R.id.postIdTV);
            id= itemView.findViewById(R.id.idTV);
            name= itemView.findViewById(R.id.nameTV);
            body= itemView.findViewById(R.id.bodyTV);
            email= itemView.findViewById(R.id.emailTV);

        }
    }
}
