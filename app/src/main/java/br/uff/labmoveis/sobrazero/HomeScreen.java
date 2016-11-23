package br.uff.labmoveis.sobrazero;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.uff.labmoveis.sobrazero.Listeners.IScreen;

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,  IScreen{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sobra Zero");

        ManagerActivity.setCurrentActivity(this);

        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_home_screen);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button bExit = (Button) findViewById(R.id.btnExit);
        bExit.setOnClickListener(getExitListener(this));
    }

    public View.OnClickListener getExitListener(final IScreen hmScreen)
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                hmScreen.finishActivity();
            }
        };
    }

    public void onClickSobras (View v ) {
        Intent intent = new Intent(HomeScreen.this, TelaSobras.class);
        startActivity(intent);
        finishActivity();
    }

    public void onClickVote (View v ) {
        Intent intent = new Intent(HomeScreen.this, VoteScreen.class);
        startActivity(intent);
        finishActivity();
    }

    public void onClickContact (View v ) {
        Intent intent = new Intent(HomeScreen.this, ContactScreen.class);
        startActivity(intent);
        finishActivity();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.ver_resto) {

        } else if (id == R.id.vote_refeicao) {

        } else if (id == R.id.fale_conosco) {

        } else if (id == R.id.home) {
            Toast.makeText(this, "Você já está na Home", Toast.LENGTH_SHORT );
        } else if (id == R.id.login_admin) {
            Intent intent = new Intent(HomeScreen.this, HomeAdmin.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_home_screen);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void finishActivity(){
        finish();
    }
}
