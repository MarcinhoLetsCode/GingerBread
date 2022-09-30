package br.com.etecia.gingerbread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    MaterialToolbar materialToolbar;
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.drawer_layout);
        new ProdutoFragment();

        drawerLayout = findViewById(R.id.drawerLayout);
        materialToolbar = findViewById(R.id.toolBar);
        bottomNavigationView = findViewById(R.id.bnMenu);
        navigationView = findViewById(R.id.navDrawer);

        materialToolbar.setTitle("Café");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new ProdutoFragment(0)).
                commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bnCoffe:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new ProdutoFragment(0)).
                                commit();
                        materialToolbar.setTitle("Café");
                        return true;

                    case R.id.bnMuffin:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new ProdutoFragment(1)).
                                commit();
                        materialToolbar.setTitle("Muffin");
                        return true;

                    case R.id.bnTea:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new ProdutoFragment(2)).
                                commit();
                        materialToolbar.setTitle("Chá");
                        return true;

                    case R.id.bnDonuts:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new ProdutoFragment(3)).
                                commit();
                        materialToolbar.setTitle("Donuts");
                        return true;
                }
                return true;
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, materialToolbar, R.string.navopen, R.string.navclose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}