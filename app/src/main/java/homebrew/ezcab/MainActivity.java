package homebrew.ezcab;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    /*
    private int fetchColor(@ColorRes int color) {
        return ContextCompat.getColor(this, color);
        //  Enables color Reveal effect
        bottomNavigation.setColored(true);
        // Colors for selected (active) and non-selected items (in color reveal mode).
        bottomNavigation.setColoredModeColors(Color.WHITE,
                fetchColor(R.color.bottomtab_item_resting));
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

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
