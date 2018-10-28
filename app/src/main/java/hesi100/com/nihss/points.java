package hesi100.com.nihss;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.uncopt.android.widget.text.justify.JustifiedTextView;

public class points extends AppCompatActivity {
    TextView nipuan;
    TextView nihss;
    TextView is;
    TextView score;
    int puan;
    View fragment;
    ImageView close;
    ImageView  helpf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        puan=b.getInt("point",0);
        SharedPreferences po=getSharedPreferences("ill_puan", 0);
        SharedPreferences.Editor editor=po.edit();
        editor.putInt("puan",puan);
        editor.apply();
        nipuan= (JustifiedTextView) findViewById(R.id.nipuan);
        nihss= (TextView) findViewById(R.id.nihss);
        score= (TextView) findViewById(R.id.score);
        is= (TextView) findViewById(R.id.is);
        nipuan.setText(""+puan);
        setuserfragment();
        ImageView im= (ImageView) findViewById(R.id.navigation);
        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    mDrawerLayout.closeDrawer(Gravity.LEFT);
                } else {
                    mDrawerLayout.openDrawer(Gravity.LEFT);
                }
            }
        });
        fragment= findViewById(R.id.help_me);
        fragment.setVisibility(View.GONE);
        close = (ImageView) findViewById(R.id.close_t);
        helpf = (ImageView) findViewById(R.id.helpf);
        helpf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpform();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.setVisibility(View.GONE);
            }
        });

        TextView t= (TextView) findViewById(R.id.toolbar_text);
        t.setTypeface(Typeface.DEFAULT);

    }
    public void setuserfragment()
    {
        SharedPreferences prefs = getSharedPreferences("register", 0);
        String fname=prefs.getString("fname","guest");
        String lname=prefs.getString("lname","");
        String sex=prefs.getString("sex","");
       TextView username= (TextView) findViewById(R.id.username);
        username.setText(fname+" "+lname);
        String Specialty= prefs.getString("Specialty", "");
        TextView spec= (TextView) findViewById(R.id.spec);
        spec.setText(Specialty);
        ImageView im= (ImageView) findViewById(R.id.doctorpic);
        if(sex.equals("woman"))
        {
           im.setImageResource(R.drawable.doctorwoman);
        }
        else
        {

        }
    }
    public void godesc(View v)
    {
        Intent intent = new Intent(this, desicion.class);
        intent.putExtra("point", puan);
        SharedPreferences prefs = getSharedPreferences("points_nihss", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("puan", puan);
        editor.apply();

        startActivity(intent);
    }
    public void helpform() {
        Bundle bundle = new Bundle();
        help_title frg1 = new help_title();
        bundle.putInt("key", 15);
        frg1.setArguments(bundle);
        FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.help_me, frg1);
        ft.commit();
        fragment.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

}