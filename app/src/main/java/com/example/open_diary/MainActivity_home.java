package com.example.open_diary;

import static com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity_home extends AppCompatActivity {
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private RecyclerView postList;
    public Toolbar mToolbar;

    private ImageButton AddNewPostButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);

        AddNewPostButton = (ImageButton) findViewById(R.id.add_new_post_button);

        //actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity_home.this,);
        //postList = (RecyclerView) findViewById(all_users_post);



        drawerLayout = (DrawerLayout) findViewById(R.id.drawable_layout);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener()
         {
                @Override
                public void onClick(View view)
                {
                     drawerLayout.openDrawer(GravityCompat.START);
                }
          });

                navigationView = (NavigationView) findViewById(R.id.navigation_view);
        View navView = navigationView.inflateHeaderView(R.layout.navigation_header);
        navigationView.setNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                UserMenuSelector(item);
                return false;
            }
        });

        AddNewPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendToPostActivity();


            }
        });




    }


    private void SendToPostActivity() {
        Intent addNewPostIntent = new Intent(MainActivity_home.this, PostActivity.class);
        startActivity(addNewPostIntent);


    }
    private void UserMenuSelector(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.nav_profile:
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_write:
                SendToPostActivity();
                break;

            case R.id.nav_setting:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_logout:
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;

        }
    }






}