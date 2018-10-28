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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class questions extends AppCompatActivity {
    ProgressBar p;
    TextView title;
    LinearLayout[] q;
    TextView[] ans;
    int x;
    TextView percent;
    int puan;
    ImageView close;
    ImageView  helpf;
    View fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        title = (TextView) findViewById(R.id.title_q);
        ans = new TextView[6];
        ans[0] = (TextView) findViewById(R.id.text0);
        ans[1] = (TextView) findViewById(R.id.text1);
        ans[2] = (TextView) findViewById(R.id.text2);
        ans[3] = (TextView) findViewById(R.id.text3);
        ans[4] = (TextView) findViewById(R.id.text4);
        ans[5] = (TextView) findViewById(R.id.text5);
        q = new LinearLayout[6];
        q[0] = (LinearLayout) findViewById(R.id.li0);
        q[1] = (LinearLayout) findViewById(R.id.li1);
        q[2] = (LinearLayout) findViewById(R.id.li2);
        q[3] = (LinearLayout) findViewById(R.id.li3);
        q[4] = (LinearLayout) findViewById(R.id.li4);
        q[5] = (LinearLayout) findViewById(R.id.li5);
        x = 0;
        puan = 0;
        fragment = findViewById(R.id.help_me);
        fragment.setVisibility(View.GONE);
        close = (ImageView) findViewById(R.id.close_t);
        helpf = (ImageView) findViewById(R.id.helpf);
        p = (ProgressBar) findViewById(R.id.progress);
        p.setMax(15);
        p.setProgress(0);
        getTitle(x);
        getOptions(x);
        setuserfragment();

        ImageView im = (ImageView) findViewById(R.id.navigation);
        percent = (TextView) findViewById(R.id.percent);
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

    public void getTitle(int s) {
        try {
            title.setText(Answer.title(s));
        } catch (IndexOutOfBoundsException e) {

        }

    }

    public void getOptions(int s) {
        int i = 0;
        List<String> options;
        options = Answer.getAnswer(s);
        try {
            while (!options.get(i).equals("null")) {
                try {
                    ans[i].setText(options.get(i));
                    i++;
                } catch (IndexOutOfBoundsException e) {

                }

            }
        } catch (IndexOutOfBoundsException e) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {

                    finish();
                }
            }, 1000);
            Intent intent = new Intent(this, points.class);
            intent.putExtra("point", puan);
            startActivity(intent);

        }

        for (int j = i; j < 5; j++) {
            q[j].setVisibility(View.GONE);
        }
        try {
            ans[5].setText(options.get(7));
        } catch (IndexOutOfBoundsException e) {
            q[5].setVisibility(View.GONE);
        }
    }

    public void select(View v) {

        int im = Integer.parseInt(v.getTag().toString());
        puan = puan + im;
        Answer.setsum(x,im);
        x = x + 1;
        visi();
        getTitle(x);
        getOptions(x);
        p.setProgress(x);
        int p;
        p = (x * 100) / 15;
        percent.setText(p + " %");

    }

    public void visi() {
        for (int i = 0; i < 6; i++) {
            q[i].setVisibility(View.VISIBLE);
        }
    }

    public void setuserfragment() {
        SharedPreferences prefs = getSharedPreferences("register", 0);
        String fname = prefs.getString("fname", "guest");
        String lname = prefs.getString("lname", "");
        String sex = prefs.getString("sex", "");
        TextView username = (TextView) findViewById(R.id.username);
        String Specialty= prefs.getString("Specialty", "");
        TextView spec= (TextView) findViewById(R.id.spec);
        spec.setText(Specialty);
        username.setText(fname +" " + lname);
        ImageView im = (ImageView) findViewById(R.id.doctorpic);
        if (sex.equals("woman")) {
            im.setImageResource(R.drawable.doctorwoman);
        }
        else
        {

        }
    }

    public void helpme(View v) {
        Bundle bundle = new Bundle();
        help_title frg1 = new help_title();
        bundle.putInt("key", x);
        frg1.setArguments(bundle);
        FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.help_me, frg1);
        ft.commit();
        fragment.setVisibility(View.VISIBLE);

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
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getSharedPreferences("stop", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("x",x);
        editor.putInt("puan",puan);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("stop", 0);
        x = prefs.getInt("x", 0);
        puan = prefs.getInt("puan", 0);
        getTitle(x);
        getOptions(x);
        p.setProgress(x);
        int p;
        p = (x * 100) / 15;
        percent.setText(p + " %");
    }
    //  @Override
   // public void onBackPressed() {
    //    super.onBackPressed();

    //}

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences prefs = getSharedPreferences("stop", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("x",0);
        editor.putInt("puan",0);
        editor.apply();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences prefs = getSharedPreferences("stop", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("x",0);
        editor.putInt("puan",0);
        editor.apply();
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
        for(int i=0;i<6;i++)
        {
            ans[i].setTextSize(texty);
        }

    }
    public void prev(View v)
    {
        if(x==0)
        {

        }
        else {
            puan = puan - Answer.getsum(x-1);
            x--;
            getTitle(x);
            getOptions(x);
            p.setProgress(x);
            int p;
            p = (x * 100) / 15;
            percent.setText(p + " %");
        }
    }
}