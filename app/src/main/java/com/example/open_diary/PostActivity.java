package com.example.open_diary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class PostActivity extends AppCompatActivity {

    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpost);

        final EditText edit_title=findViewById(R.id.edit_title);
        final EditText edit_genre=findViewById(R.id.edit_genre);
        final EditText edit_write=findViewById(R.id.edit_write);

        mToolbar = (Toolbar) findViewById(R.id.update_post_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Update");
        Button btn = findViewById(R.id.btn_post);
        DAOPosts dao =new DAOPosts();
        btn.setOnClickListener(v->
        {
            Posts pst= new Posts(edit_title.getText().toString(),edit_genre.getText().toString(),
                    edit_write.getText().toString());
            dao.add(pst).addOnSuccessListener(suc ->
            {

                Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er ->
                    {
                        Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
                    }
            );
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
       int id = item.getItemId();

       if(id ==  android.R.id.home)
       {
           SendUserToMainActivity();
       }

        return super.onOptionsItemSelected(item);
    }

    private void SendUserToMainActivity() {
        Intent mainIntent = new Intent(PostActivity.this,MainActivity_home.class);
        startActivity(mainIntent);
    }
}