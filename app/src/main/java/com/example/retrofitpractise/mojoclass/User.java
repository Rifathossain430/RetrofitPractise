package com.example.retrofitpractise.mojoclass;

public class User {
    private int postId,id;
    private String name,body,email;

    public User() {
    }

    public User(int postId, int id, String name, String body, String email) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.body = body;
        this.email = email;
    }

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    public String getEmail() {
        return email;
    }
}
