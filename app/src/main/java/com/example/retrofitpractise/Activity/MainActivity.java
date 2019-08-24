package com.example.retrofitpractise.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitpractise.retrofit.ApiClients;
import com.example.retrofitpractise.R;
import com.example.retrofitpractise.UserAdapter;
import com.example.retrofitpractise.mojoclass.User;
import com.example.retrofitpractise.retrofit.RetrofitInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<User> users;
    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private RetrofitInterface retrofitInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        getData();
    }

    private void getData() {
        retrofitInterface = new ApiClients().getInstance().getApi();

        Call<List<User>> call = retrofitInterface.getData("posts?userId=2");
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                users= response.body();
                adapter= new UserAdapter(users,MainActivity.this);
                Toast.makeText(MainActivity.this, ""+users.size(), Toast.LENGTH_SHORT).show();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void init() {
        users = new ArrayList<>();
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
