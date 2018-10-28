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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Setting extends AppCompatActivity {
    ImageView man;
    ImageView woman;
    EditText fname;
    EditText lname;
    EditText natcode;
    EditText Specialty;
    EditText Nezam_code;
    EditText Number;
    String sex;
    boolean sexselected;
    View fragment;
    ImageView close;
    ImageView  helpf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        natcode= (EditText) findViewById(R.id.natcode);
        fname=(EditText) findViewById(R.id.fname);
        lname=(EditText) findViewById(R.id.lname);
        Specialty=(EditText) findViewById(R.id.specialty);
        Number=(EditText) findViewById(R.id.number);
        Nezam_code=(EditText) findViewById(R.id.nezam);
        man= (ImageView) findViewById(R.id.picman);
        woman= (ImageView) findViewById(R.id.picwoman);
        SharedPreferences prefs = getSharedPreferences("register", 0);
        fname.setText(prefs.getString("fname", ""));
        lname.setText(prefs.getString("lname", ""));
        sex=prefs.getString("sex", "");
        natcode.setText(prefs.getString("natcode", ""));
        Specialty.setText(prefs.getString("Specialty", ""));
        Nezam_code.setText(prefs.getString("Nezam_code", ""));
        Number.setText(prefs.getString("Number", ""));
        sexselected=true;
        if(sex.equals("man"))
        {
            man.setImageResource(R.drawable.doctormen1);
        }
        else {
            woman.setImageResource(R.drawable.doctorwoman1);
        }
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
    public void selected(View v)
    {
        String s=v.getTag().toString();
        if (s.equals("man0"))
        {
            man.setImageResource(R.drawable.doctormen1);
            woman.setImageResource(R.drawable.doctorwoman);
            sexselected=true;
            woman.setTag("woman0");
            v.setTag("man1");
            sex="man";
        }
        else if (s.equals("woman0"))
        {
            man.setImageResource(R.drawable.doctorman);
            woman.setImageResource(R.drawable.doctorwoman1);
            sexselected=true;
            man.setTag("man0");
            v.setTag("woman1");
            sex="woman";
        }
        else  if (s.equals("man1"))
        {
            man.setImageResource(R.drawable.doctorman);
            sexselected=false;
            v.setTag("man0");
        }
        else
        {
            woman.setImageResource(R.drawable.doctorwoman);
            sexselected=false;
            v.setTag("woman0");
        }
    }
    public void register(View v)
    {
        if (!sexselected)
        {
            Toast.makeText(this,"please enter your gender",Toast.LENGTH_LONG).show();
            return;
        }

        try {
            Long.parseLong(natcode.getText().toString());
        }
        catch (NumberFormatException e)
        {
            Toast.makeText(this,"nat ID must be numbers",Toast.LENGTH_LONG).show();
            return;
        }
        if(natcode.getText().toString().length()!=10)
        {
            Toast.makeText(this,"nat ID must be include 10 numbers",Toast.LENGTH_LONG).show();
            return;
        }
        if(Specialty.getText().toString().equals(""))
        {
            Toast.makeText(this,"Specialty must be entered",Toast.LENGTH_LONG).show();
            return;
        }
        if(Nezam_code.getText().toString().equals(""))
        {
            Toast.makeText(this,"Medical council ID must be entered",Toast.LENGTH_LONG).show();
            return;
        }
        if(Number.getText().toString().equals(""))
        {
            Toast.makeText(this,"Nezam_code must be entered",Toast.LENGTH_LONG).show();
            return;
        }
        if(fname.getText().toString().equals(""))
        {
            Toast.makeText(this,"first name must be entered",Toast.LENGTH_LONG).show();
            return;
        }
        if(lname.getText().toString().equals(""))
        {
            Toast.makeText(this,"last name must be entered",Toast.LENGTH_LONG).show();
            return;
        }
        SharedPreferences prefs = getSharedPreferences("register", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("ok", true);
        editor.putString("fname", fname.getText().toString());
        editor.putString("lname", lname.getText().toString());
        editor.putString("sex", sex); editor.putString("sex", sex);
        editor.putString("natcode", natcode.getText().toString());
        editor.putString("Specialty", Specialty.getText().toString());
        editor.putString("Nezam_code", Nezam_code.getText().toString());
        editor.putString("Number", Number.getText().toString());
        editor.apply();
        Intent intent=new Intent(this,questions.class);
        startActivity(intent);
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
    public void setFonts() {
        SharedPreferences font = getSharedPreferences("font", 0);
        int texty;
        texty = font.getInt("font_size", 14);
        TextView fname_text;
        TextView lname_text;
        TextView natcode_text;
        TextView Specialty_text;
        TextView Nezam_code_text;
        TextView Number_text;
        natcode_text= (TextView) findViewById(R.id.natcode_text);
        fname_text=(TextView) findViewById(R.id.fname_text);
        lname_text=(TextView) findViewById(R.id.lname_text);
        Specialty_text=(TextView) findViewById(R.id.specialty_text);
        Number_text=(TextView) findViewById(R.id.number_text);
        Nezam_code_text=(TextView) findViewById(R.id.nezam_text);
         fname_text.setTextSize(texty);
         lname_text.setTextSize(texty);
         natcode_text.setTextSize(texty);
         Specialty_text.setTextSize(texty);
         Nezam_code_text.setTextSize(texty);
         Number_text.setTextSize(texty);
         fname.setTextSize(texty);
         lname.setTextSize(texty);
         natcode.setTextSize(texty);
         Specialty.setTextSize(texty);
         Nezam_code.setTextSize(texty);
         Number.setTextSize(texty);
    }

}