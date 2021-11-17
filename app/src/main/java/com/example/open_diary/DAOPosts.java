package com.example.open_diary;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOPosts {
    private DatabaseReference databaseReference;
    //private String key;

    public DAOPosts() {
        FirebaseDatabase db =FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Posts.class.getSimpleName());
    }
    public Task<Void> add(Posts pst)
    {
        return databaseReference.push().setValue(pst);
    }
}
