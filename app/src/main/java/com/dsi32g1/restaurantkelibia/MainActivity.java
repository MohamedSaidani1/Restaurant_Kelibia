package com.dsi32g1.restaurantkelibia;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.dsi32g1.restaurantkelibia.ui.jammoulti;
import com.dsi32g1.restaurantkelibia.ui.mansourah;
import com.dsi32g1.restaurantkelibia.ui.monaco;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
private DrawerLayout mDrawerLayout;
private ActionBarDrawerToggle mToggle;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ListView maList;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maList = findViewById(R.id.listviewperso);
        ArrayList<HashMap<String,String>> listItem = new ArrayList<>();
        HashMap<String, String> map;
        map = new HashMap<>();
        map.put("titre","Restaurant El Mansourah");
        map.put("description","Adresse :\n" +"Kélibia 8090\n" +
                "Téléphone : 72 295 169");
        map.put("img", String.valueOf(R.drawable.mansourah1));
        listItem.add(map);


        map = new HashMap<>();
        map.put("titre","Restaurant Monaco Bay");
        map.put("description","Adresse : Rue du petit paris, plage el mansourah، Kelibia 8090\n" +
                "Téléphone : \n" + "29 331 331");
        map.put("img", String.valueOf(R.drawable.monaco));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre","Jammoulti");
        map.put("description","Adresse : Kélibia\n" +
                "Téléphone : 92 262 602");
        map.put("img",String.valueOf(R.drawable.jammoulti));
        listItem.add(map);




        SimpleAdapter adapter = new SimpleAdapter(this,listItem,R.layout.activity_list,
                new String[] {"img", "titre", "description"},
                new int[] {R.id.img, R.id.titre, R.id.description});
        maList.setAdapter(adapter);


        maList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                HashMap<String, String> map = (HashMap<String, String>) maList.getItemAtPosition(1);

                AlertDialog.Builder db = new AlertDialog.Builder(MainActivity.this);
                db.setTitle("select item");
                db.setMessage("votre choix:"+" "+map.get("titre"));
                //Toast.makeText(MainActivity.this,"titre",Toast.LENGTH_LONG).show();
                db.show();

                return true;
            }
        }

        );
        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.Open,R.string.Close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    ArrayList<HashMap<String,String>> listItem = new ArrayList<>();
    HashMap<String, String> map;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if ( (mToggle.onOptionsItemSelected(item))){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void page1 (View view)
    {
        startActivity(new Intent (this, mansourah.class));
    }
    public void page2(View view)
    {
        this.view = view;
        startActivity(new Intent (this, monaco.class));
    }
    public void page3(View view)
    {
        this.view = view;
        startActivity(new Intent (this, jammoulti.class));
    }



}

