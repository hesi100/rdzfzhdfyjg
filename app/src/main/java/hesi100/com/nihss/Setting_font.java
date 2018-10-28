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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Setting_font extends AppCompatActivity {
    Spinner font_size;
    Spinner font_type;
    TextView font_si;
    TextView font_ty;
    Button ok;
    ImageView close;
    ImageView  helpf;
    View fragment;
    boolean re;
    SharedPreferences font;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        font_si= (TextView) findViewById(R.id.font_si);
        font_ty= (TextView) findViewById(R.id.font_ty);
        re=false;
        font = getSharedPreferences("font", 0);
        final SharedPreferences.Editor editor = font.edit();
        int texty;
        texty=font.getInt("font_size",14);
        font_si.setTextSize(texty+6);
        font_ty.setTextSize(texty+6);
        font_size= (Spinner) findViewById(R.id.font_size);
        font_type= (Spinner) findViewById(R.id.font_type);
        ok= (Button) findViewById(R.id.ok);
        ok.setTextSize(texty);
        ArrayAdapter<String> spinneradapter = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.font_t));
        font_type.setAdapter(spinneradapter);
        ArrayAdapter<String> spinneradaptersize = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.font_si));
        font_size.setAdapter(spinneradaptersize);

        font_type.setPrompt("select your font");
        font_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if(font_type.getSelectedItemPosition()==0) {


                }
                else if(font_type.getSelectedItemPosition()==1) {
                    editor.putString("font_type", "FTLTLT");
                    editor.apply();
             //       Intent i =getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
               //     i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                 //   startActivity(i);
                    app.fontchange();
                    font_type.setSelection(0);
                    onRestart();

                }
                else if (font_type.getSelectedItemPosition()==2) {
                    editor.putString("font_type", "segoepr");
                    editor.apply();
                 //   Intent i =getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
               //     i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                 //   startActivity(i);
                    app.fontchange();
                    font_type.setSelection(0);
                    onRestart();

                }
                else
                {
                    editor.putString("font_type", "times");
                    editor.apply();
                 //   Intent i =getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                 //   i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                 //   startActivity(i);
                    app.fontchange();
                    font_type.setSelection(0);
                    onRestart();
                }
            }
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
        font_size.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                if(font_size.getSelectedItemPosition()!=0) {
                    int size = Integer.parseInt(font_size.getSelectedItem().toString());
                    editor.putInt("font_pos",font_size.getSelectedItemPosition());
                    editor.putInt("font_size",size);
                    editor.apply();
                    recreate();
                }

                font_size.setSelection(0);
            }
            public void onNothingSelected(AdapterView<?> parent)
            {

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
        setuserfragment();
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
    public void okme(View view)
    {
        finish();
    }

}
