package hesi100.com.nihss;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class last_result extends AppCompatActivity {
    TextView NIHSS_Score;
    TextView Nezam_Pezeshki;
    TextView Patient_code;
    TextView Physician;
    TextView t_c;
    TextView t_t;
    TextView f_c;
    int puan;
    String code;
    ImageView close;
    ImageView  helpf;
    View fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_result);
        SharedPreferences pref = getSharedPreferences("ill", 0);
        code=pref.getString("code","0");
        SharedPreferences prefs = getSharedPreferences("points_nihss", 0);
        SharedPreferences tcw = getSharedPreferences("tc", 0);
        String tc= tcw.getString("tc","");
        t_c= (TextView) findViewById(R.id.T_c);
        t_c.setText(tc);
        SharedPreferences tt = getSharedPreferences("tt", 0);
        t_t= (TextView) findViewById(R.id.T_T);
        String tt1= tt.getString("tt","");
        t_t.setText(tt1);
        String tf="";
        SharedPreferences tf1 = getSharedPreferences("tf", 0);
        tf1.getString("tf1",tf);
        tf=tf+tf1.getString("tf2","");
        tf=tf+tf1.getString("tf3","");
        tf=tf+tf1.getString("tf4","");

        f_c= (TextView) findViewById(R.id.f_d);
        f_c.setText(tf);
        puan =prefs.getInt("puan",0);
        NIHSS_Score= (TextView) findViewById(R.id.NIHSS_Score);
        Physician= (TextView) findViewById(R.id.Physician);
        NIHSS_Score.setText(""+puan);
        Patient_code= (TextView) findViewById(R.id.Patient_code);
        Patient_code.setText(""+code);
        Nezam_Pezeshki= (TextView) findViewById(R.id.Nezam_Pezeshki);
        SharedPreferences prefs1 = getSharedPreferences("register", 0);
        Nezam_Pezeshki.setText(prefs1.getString("Nezam_code", ""));
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
        fragment = findViewById(R.id.help_me);
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
        register();
        setuserfragment();
        setFonts();
        TextView t= (TextView) findViewById(R.id.toolbar_text);
        t.setTypeface(Typeface.DEFAULT);

        SharedPreferences prefsy = getSharedPreferences("register", 0);
        String fname=prefsy.getString("fname","guest");
        String lname=prefsy.getString("lname","");
        TextView username = (TextView) findViewById(R.id.Physician);
        username.setText(fname +" " + lname);


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
    public void register()
    {

        DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
        databaseHelper.insertNewpatient(code,puan,t_t.getText().toString(),t_c.getText().toString(),f_c.getText().toString());
    }
    public void reset(View v)
    {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    finish();
                }
            }, 1000);
            Intent intent=new Intent(this,getp_c.class);
            startActivity(intent);
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
    public void setFonts()
    {
        SharedPreferences font = getSharedPreferences("font", 0);
        int texty;
        texty=font.getInt("font_size",14);
        TextView text1= (TextView) findViewById(R.id.text1);
        TextView text2= (TextView) findViewById(R.id.text2);
        TextView text3= (TextView) findViewById(R.id.text3);
        TextView text4= (TextView) findViewById(R.id.text4);
        TextView text5= (TextView) findViewById(R.id.text5);
        TextView text6= (TextView) findViewById(R.id.text6);
        TextView text7= (TextView) findViewById(R.id.text7);
        TextView text8= (TextView) findViewById(R.id.text8);
        TextView text9= (TextView) findViewById(R.id.text9);
         NIHSS_Score.setTextSize(texty);
         Nezam_Pezeshki.setTextSize(texty);
         Patient_code.setTextSize(texty);
         Physician.setTextSize(texty);
         t_c.setTextSize(texty);
         t_t.setTextSize(texty);
         f_c.setTextSize(texty);
        text1.setTextSize(texty);
        text2.setTextSize(texty);
        text3.setTextSize(texty);
        text4.setTextSize(texty);
        text5.setTextSize(texty);
        text6.setTextSize(texty);
        text7.setTextSize(texty);
        text8.setTextSize(texty);
        text9.setTextSize(texty);
        Button reset= (Button) findViewById(R.id.reset);
        reset.setTextSize(texty);

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

}
