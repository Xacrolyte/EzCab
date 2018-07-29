package homebrew.ezcab;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener{

    private boolean loadFragment(Fragment fragment){

        if (fragment != null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frag_container,fragment)
                    .commit();

            return true;
        }

        return false;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new OneFragment();
                break;
            case R.id.navigation_dashboard:
                fragment = new TwoFragment();
                break;
            case R.id.navigation_notifications:
                fragment = new ThreeFragment();
                break;
        }
        return loadFragment(fragment);
    }


/*
    private int fetchColor(@ColorRes int color) {
        return ContextCompat.getColor(this, color);
        //  Enables color Reveal effect
        bottomNavigation.setColored(true);
        // Colors for selected (active) and non-selected items (in color reveal mode).
        bottomNavigation.setColoredModeColors(Color.WHITE,
                fetchColor(R.color.colorAccent));
    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Mr. ABC");
        actionBar.setSubtitle("online");

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff0000")));

        actionBar.show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings , menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int optnid=item.getItemId();
        String headtext=item.getTitle().toString();
        if (optnid==R.id.itm1){
            Toast.makeText(MainActivity.this, headtext, Toast.LENGTH_SHORT).show();

        }

        if (optnid==R.id.itm2){
            Toast.makeText(MainActivity.this, headtext, Toast.LENGTH_SHORT).show();
        }

        if (optnid==R.id.itm3){
            Toast.makeText(MainActivity.this, headtext, Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);

    }

}
