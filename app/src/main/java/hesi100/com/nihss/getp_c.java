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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class getp_c extends AppCompatActivity {
    EditText e;
    View fragment;
    ImageView close;
    ImageView  helpf;
    boolean xx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getp_c);
        e= (EditText) findViewById(R.id.puan);
        ImageView im= (ImageView) findViewById(R.id.navigation);
        xx=false;
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
        setuserfragment();
        setFonts();
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
    public void next(View v)
    {
        DatabaseHelper databaseHelper=new DatabaseHelper(this);

        if(e.getText().toString().equals(""))
        {
            Toast.makeText(this,"please enter code",Toast.LENGTH_LONG).show();
        }
        else {
            if(!databaseHelper.isselectpatient((e.getText().toString().trim()))) {
                SharedPreferences prefs = getSharedPreferences("ill", 0);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("code", (e.getText().toString()));
                editor.apply();
                Intent intent = new Intent(this, questions.class);
                startActivity(intent);
            }
            else
            {
                if(!xx) {
                    xx=true;
                    String temp = e.getText().toString() + "x";
                    e.setText(temp);
                }
                Intent intent=new Intent(this,is_patient.class);
                startActivity(intent);
            }
        }

    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,want_exit.class);
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
        TextView t= (TextView) findViewById(R.id.toolbar_text);
        t.setTypeface(Typeface.DEFAULT);
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
        Button b= (Button) findViewById(R.id.next);
        text1.setTextSize(texty);
        b.setTextSize(texty);
        e.setTextSize(texty);
    }
}