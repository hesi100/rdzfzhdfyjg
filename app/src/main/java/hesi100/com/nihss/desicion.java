package hesi100.com.nihss;

import android.content.Context;
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

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class desicion extends AppCompatActivity {
    int puan;
    TextView nihss_puan;
    View fragment;
    ImageView  helpf;
    View fragment1;
    ImageView close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desicion);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        puan=b.getInt("point",0);
        nihss_puan= (TextView) findViewById(R.id.nihss_puan);
        nihss_puan.setText(""+puan);
        fragment = findViewById(R.id.ques);
        que();
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

        SharedPreferences tcw = app.context.getSharedPreferences("tc", 0);
        SharedPreferences.Editor editor = tcw.edit();
        editor.putString("tc","");
        editor.apply();
        SharedPreferences tf1 = app.context.getSharedPreferences("tf", 0);
        SharedPreferences.Editor editor1 = tf1.edit();
        editor1.putString("tf1","");
        editor1.putString("tf2","");
        editor1.putString("tf3","");
        editor1.putString("tf4","");
        editor1.apply();
        TextView t= (TextView) findViewById(R.id.toolbar_text);
        t.setTypeface(Typeface.DEFAULT);
        nihss_puan.setTypeface(Typeface.DEFAULT);
        fragment1 = findViewById(R.id.help_me);
        fragment1.setVisibility(View.GONE);
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
                fragment1.setVisibility(View.GONE);
            }
        });

    }
    public void que() {
        page15 frg1 = new page15();
        FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.ques, frg1);
        ft.commit();
        fragment.setVisibility(View.VISIBLE);
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
        TextView t= (TextView) findViewById(R.id.toolbar_text);
        t.setTypeface(Typeface.DEFAULT);

    }
    @Override
    public void onBackPressed() {

        Intent intent=new Intent(this,want_exit.class);
        startActivity(intent);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
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
        fragment1.setVisibility(View.VISIBLE);
    }

}
