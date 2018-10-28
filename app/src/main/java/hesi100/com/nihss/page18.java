package hesi100.com.nihss;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class page18 extends Fragment {
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    CheckBox checkBox6;
    CheckBox checkBox7;
    CheckBox checkBox8;
    CheckBox checkBox9;
    CheckBox checkBox10;
    CheckBox checkBox11;
    CheckBox checkBox12;
    String tc;
    Button b;
    View v;
    ImageView prev;
    int key;
    public page18() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_page18, container, false);
        tc=" ";
        b= (Button) v.findViewById(R.id.gonext);
        checkBox1= (CheckBox) v.findViewById(R.id.checkBox1);
        checkBox2= (CheckBox) v.findViewById(R.id.checkBox2);
        checkBox3= (CheckBox) v.findViewById(R.id.checkBox3);
        checkBox4= (CheckBox) v.findViewById(R.id.checkBox4);
        checkBox5= (CheckBox) v.findViewById(R.id.checkBox5);
        checkBox6= (CheckBox) v.findViewById(R.id.checkBox6);
        checkBox7= (CheckBox) v.findViewById(R.id.checkBox7);
        checkBox8= (CheckBox) v.findViewById(R.id.checkBox8);
        checkBox9= (CheckBox) v.findViewById(R.id.checkBox9);
        checkBox10= (CheckBox) v.findViewById(R.id.checkBox10);
        checkBox11= (CheckBox) v.findViewById(R.id.checkBox11);
        checkBox12= (CheckBox) v.findViewById(R.id.checkBox12);
        prev= (ImageView) v.findViewById(R.id.prev);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {

                String tc="";
                if(checkBox1.isChecked())
                {

                    tc=tc+checkBox1.getText().toString()+ " - ";
                }
                if(checkBox2.isChecked())
                {

                    tc=tc+checkBox2.getText().toString()+ " - ";
                }
                if(checkBox3.isChecked())
                {
                    tc=tc+checkBox3.getText().toString()+ " - ";
                }
                if(checkBox4.isChecked())
                {
                    tc=tc+checkBox4.getText().toString()+ " - ";
                }
                if(checkBox5.isChecked())
                {
                    tc=tc+checkBox5.getText().toString()+ " - ";
                }
                if(checkBox6.isChecked())
                {
                    tc=tc+checkBox6.getText().toString()+ " - ";
                }
                if(checkBox7.isChecked())
                {
                    tc=tc+checkBox7.getText().toString()+ " - ";
                }
                if(checkBox8.isChecked())
                {
                    tc=tc+checkBox8.getText().toString()+ " - ";
                }
                if(checkBox9.isChecked())
                {
                    tc=tc+checkBox9.getText().toString()+ " - ";
                }
                if(checkBox10.isChecked())
                {

                    tc=tc+checkBox10.getText().toString()+ " - ";
                }
                if(checkBox11.isChecked())
                {
                    tc=tc+checkBox11.getText().toString()+ " - ";
                }
                if(checkBox12.isChecked())
                {
                    tc=tc+checkBox12.getText().toString()+ " - ";
                }
                SharedPreferences tcw = app.context.getSharedPreferences("tc", 0);
                SharedPreferences.Editor editor = tcw.edit();
                editor.putString("tc",tc);
                editor.apply();
                SharedPreferences page18=app.context.getSharedPreferences("page18", 0);
                int y=page18.getInt("page18",0);
                if(checkBox1.isChecked()&&checkBox2.isChecked()&&checkBox6.isChecked()&&(checkBox3.isChecked()||checkBox4.isChecked()||checkBox5.isChecked())&&checkBox6.isChecked()&&(checkBox7.isChecked()||checkBox8.isChecked()||checkBox9.isChecked()))
                {
                    //page 19 result red
                    Bundle bundle = new Bundle();
                    result_nihss frg1 = new result_nihss();
                    bundle.putInt("key", 2);
                    bundle.putInt("pager", 18);
                    frg1.setArguments(bundle);
                    myStack.push(18);
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.ques, frg1);
                    ft.commit();
                }
                else

                {
                    if(y==17) {
                        //page20
                        page20 frg1 = new page20();
                        FragmentManager fm = getActivity().getSupportFragmentManager();
                        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.ques, frg1);
                        myStack.push(18);
                        ft.commit();
                    }
                    else
                    {
                        //page25
                        page25 frg1 = new page25();
                        SharedPreferences page25=app.context.getSharedPreferences("page25", 0);
                        SharedPreferences.Editor editor1=page25.edit();
                        editor1.putInt("page25",18);
                        editor1.apply();
                        FragmentManager fm = getActivity().getSupportFragmentManager();
                        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.ques, frg1);
                        myStack.push(18);
                        ft.commit();
                    }


                }

            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                //page15
                int pa=myStack.pop();
                if(pa==15) {
                    page15 frg1 = new page15();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.ques, frg1);
                    ft.commit();
                }
                else if(pa==17) {
                    page17 frg1 = new page17();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.ques, frg1);
                    ft.commit();
                }
                else if(pa==18) {
                    page18 frg1 = new page18();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.ques, frg1);
                    ft.commit();
                }
                else if(pa==20) {
                    page20 frg1 = new page20();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.ques, frg1);
                    ft.commit();
                }
                else if(pa==23) {
                    page23 frg1 = new page23();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.ques, frg1);
                    ft.commit();
                }
                else if(pa==25) {
                    page25 frg1 = new page25();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.ques, frg1);
                    ft.commit();
                }
                else if(pa==27) {
                    page27 frg1 = new page27();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.ques, frg1);
                    ft.commit();
                }
                else if(pa==29) {
                    page29 frg1 = new page29();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.ques, frg1);
                    ft.commit();
                }
                else if(pa==30) {
                    page30 frg1 = new page30();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.ques, frg1);
                    ft.commit();
                }
                else if(pa==32) {
                    page32 frg1 = new page32();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.ques, frg1);
                    ft.commit();
                }
                else if(pa==35) {
                    page35 frg1 = new page35();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.ques, frg1);
                    ft.commit();
                }
                else if(pa==175) {
                    page175 frg1 = new page175();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.ques, frg1);
                    ft.commit();
                }


            }
        });


        setFonts();
        // Inflate the layout for this fragment
        return v;

    }
    public void setFonts() {
        SharedPreferences font = app.context.getSharedPreferences("font", 0);
        int texty;
        texty = font.getInt("font_size", 14);
        checkBox1.setTextSize(texty);
        checkBox2.setTextSize(texty);
        checkBox3.setTextSize(texty);
        checkBox4.setTextSize(texty);
        checkBox5.setTextSize(texty);
        checkBox6.setTextSize(texty);
        checkBox7.setTextSize(texty);
        checkBox8.setTextSize(texty);
        checkBox9.setTextSize(texty);
        checkBox10.setTextSize(texty);
        checkBox11.setTextSize(texty);
        checkBox12.setTextSize(texty);
        b.setTextSize(texty);
    }
}