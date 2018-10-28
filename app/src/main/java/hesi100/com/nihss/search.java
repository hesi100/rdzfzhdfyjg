package hesi100.com.nihss;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class search extends AppCompatActivity {
    EditText Patient_code;
    View fragment;
    ImageView close;
    ImageView  helpf;
    TextView Physician;
    TextView Nezam_Pezeshki;
    TextView NIHSS_Score;
    TextView t_t;
    TextView t_c;
    TextView f_c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Patient_code= (EditText) findViewById(R.id.patient_code);
        Physician= (TextView) findViewById(R.id.Physician);
        Nezam_Pezeshki= (TextView) findViewById(R.id.Nezam_Pezeshki);
        NIHSS_Score= (TextView) findViewById(R.id.NIHSS_Score);
        t_t= (TextView) findViewById(R.id.T_T);
        t_c= (TextView) findViewById(R.id.T_c);
        f_c= (TextView) findViewById(R.id.f_d);
        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ImageView im= (ImageView) findViewById(R.id.navigation);
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
        setuserfragment();
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
        setFonts();
        TextView t= (TextView) findViewById(R.id.toolbar_text);
        t.setTypeface(Typeface.DEFAULT);

    }
    public void searchill(View v)
    {
        String code=(Patient_code.getText().toString().trim());
        //search

        DatabaseHelper db=new DatabaseHelper(getApplicationContext());
        db.selectpatient(code,NIHSS_Score,t_t,t_c,f_c);
        if(!t_t.equals(""))
        {
            SharedPreferences prefs1 = getSharedPreferences("register", 0);
            Nezam_Pezeshki.setText(prefs1.getString("Nezam_code", ""));
            SharedPreferences prefs = getSharedPreferences("register", 0);
            String fname=prefs.getString("fname","guest");
            String lname=prefs.getString("lname","");
            TextView username = (TextView) findViewById(R.id.Physician);
            username.setText(fname +" " + lname);

        }
    }
    public void setuserfragment()
    {
        SharedPreferences prefs = getSharedPreferences("register", 0);
        String fname=prefs.getString("fname","guest");
        String lname=prefs.getString("lname","");
        String sex=prefs.getString("sex","");
        String Specialty= prefs.getString("Specialty", "");
        TextView spec= (TextView) findViewById(R.id.spec);
        spec.setText(Specialty);
        TextView username= (TextView) findViewById(R.id.username);
        username.setText(fname+" "+lname);
        ImageView im= (ImageView) findViewById(R.id.doctorpic);
        if(sex.equals("woman"))
        {
            im.setImageResource(R.drawable.doctorwoman);
        }
        else
        {

        }
    }

    public void ok(View v)
    {
        finish();
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
        Button search= (Button) findViewById(R.id.search);
        search.setTextSize(texty);
        Button reset= (Button) findViewById(R.id.reset);
        reset.setTextSize(texty);
        reset.setTextSize(texty);
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

        text6.setTextSize(texty);
        text7.setTextSize(texty);
        text8.setTextSize(texty);
        text9.setTextSize(texty);

    }
}
