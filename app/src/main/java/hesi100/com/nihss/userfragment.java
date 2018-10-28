package hesi100.com.nihss;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class userfragment extends Fragment {
    TextView name_text;
    TextView username;
    TextView spec;
    TextView Specialty_text;
    TextView reset_text;
    TextView profile_text;
    TextView search_text;
    TextView about_text;
    TextView setting_text;
    TextView exit_text;
    public userfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_userfragment, container, false);
         name_text= (TextView) v.findViewById(R.id.name_text);
         username= (TextView) v.findViewById(R.id.username);
         spec= (TextView) v.findViewById(R.id.spec);
         Specialty_text= (TextView) v.findViewById(R.id.Specialty_text);
         reset_text= (TextView) v.findViewById(R.id.reset_text);
         profile_text= (TextView) v.findViewById(R.id.profile_text);
         search_text= (TextView) v.findViewById(R.id.search_text);
         about_text= (TextView) v.findViewById(R.id.about_text);
         setting_text= (TextView) v.findViewById(R.id.setting_text);
         exit_text= (TextView) v.findViewById(R.id.exit_text);
        name_text.setTypeface(Typeface.DEFAULT);
        username.setTypeface(Typeface.DEFAULT);
        spec.setTypeface(Typeface.DEFAULT);
        Specialty_text.setTypeface(Typeface.DEFAULT);
        reset_text.setTypeface(Typeface.DEFAULT);
        profile_text.setTypeface(Typeface.DEFAULT);
        search_text.setTypeface(Typeface.DEFAULT);
        about_text.setTypeface(Typeface.DEFAULT);
        setting_text.setTypeface(Typeface.DEFAULT);
        exit_text.setTypeface(Typeface.DEFAULT);
        LinearLayout setting= (LinearLayout) v.findViewById(R.id.setting);
        LinearLayout search= (LinearLayout) v.findViewById(R.id.search);
        LinearLayout   frag=(LinearLayout) v.findViewById(R.id.frag);
        LinearLayout exit= (LinearLayout) v.findViewById(R.id.exit);
        LinearLayout info= (LinearLayout) v.findViewById(R.id.info);
        LinearLayout profile= (LinearLayout) v.findViewById(R.id.profile);
        LinearLayout reset= (LinearLayout) v.findViewById(R.id.reset);
       /* setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),Setting.class);
                startActivity(intent);
            }
        });*/
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),Setting.class);
                startActivity(intent);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),getp_c.class);
                startActivity(intent);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),Setting_font.class);
                startActivity(intent);
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),about.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),search.class);
                startActivity(intent);
            }
        });

        frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),want_exit.class);
                startActivity(intent);

            }
        });
        /*LinearLayout my_reserved= (LinearLayout) v.findViewById(R.id.my_reserved);

        LinearLayout support= (LinearLayout) v.findViewById(R.id.support);
        
        LinearLayout background= (LinearLayout) v.findViewById(R.id.back_g);

        ImageView home= (ImageView) v.findViewById(R.id.home);
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),changeback.class);
                startActivity(intent);
            }
        });
        my_reserved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),reserved.class);
                startActivity(intent);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),mysearchs.class);
                startActivity(intent);
            }
        });

        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),support.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),main.class);
                startActivity(intent);
            }
        });
   */

        // Inflate the layout for this fragment
       // setFonts();
        return v;

    }
 /*   public void setFonts()
    {
        SharedPreferences font = app.context.getSharedPreferences("font", 0);
        int texty;
        texty=font.getInt("font_size",14);
        texty=texty+6;

         name_text.setTextSize(texty-2);
         username.setTextSize(texty-2);
         spec.setTextSize(texty-2);
         Specialty_text.setTextSize(texty-2);
         reset_text.setTextSize(texty);
         profile_text.setTextSize(texty);
         search_text.setTextSize(texty);
         about_text.setTextSize(texty);
         setting_text.setTextSize(texty);
         exit_text.setTextSize(texty);
       
    }*/
    
    
}