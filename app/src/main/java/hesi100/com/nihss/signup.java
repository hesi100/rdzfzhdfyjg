package hesi100.com.nihss;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class signup extends AppCompatActivity {

    ImageView man;
    ImageView woman;
    TextView fname;
    TextView lname;
    TextView natcode;
    TextView Specialty;
    TextView Nezam_code;
    TextView Number;
    LinearLayout sexplus;
    LinearLayout sexpic;
    ImageView plus;
    String sex;
    boolean sexselected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        SharedPreferences prefs = getSharedPreferences("register", 0);
        if(prefs.getBoolean("ok",false))
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
        natcode= (TextView) findViewById(R.id.natcode);
        fname=(TextView) findViewById(R.id.fname);
        lname=(TextView) findViewById(R.id.lname);
        Specialty=(TextView) findViewById(R.id.specialty);
        Number=(TextView) findViewById(R.id.number);
        Nezam_code=(TextView) findViewById(R.id.nezam);
        man= (ImageView) findViewById(R.id.picman);
        woman= (ImageView) findViewById(R.id.picwoman);
        plus= (ImageView) findViewById(R.id.plus);
        sexpic= (LinearLayout) findViewById(R.id.sexpic);
        sexplus= (LinearLayout) findViewById(R.id.sexplus);
        sexselected=false;
    }
    public void selectplus(View view)
    {
        sexplus.setVisibility(View.GONE);
        sexpic.setVisibility(View.VISIBLE);
    }
    public void selectsex(View view)
    {
        sexpic.setVisibility(View.GONE);
        sexplus.setVisibility(View.VISIBLE);
        String tag=view.getTag().toString();
        if(tag.equals("man"))
        {
            plus.setImageResource(R.drawable.doctorman);
            sex="man";
            sexselected=true;
        }
        else
        {
            plus.setImageResource(R.drawable.doctorwoman);
            sex="woman";
            sexselected=true;
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
            Toast.makeText(this,"Number must be entered",Toast.LENGTH_LONG).show();
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
        editor.putString("sex", sex);
        editor.putString("natcode", natcode.getText().toString());
        editor.putString("Specialty", Specialty.getText().toString());
        editor.putString("Nezam_code", Nezam_code.getText().toString());
        editor.putString("Number", Number.getText().toString());
        editor.apply();
        Intent intent=new Intent(this,getp_c.class);
        startActivity(intent);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
