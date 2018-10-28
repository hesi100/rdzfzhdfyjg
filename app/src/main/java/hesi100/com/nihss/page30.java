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
public class page30 extends Fragment {
    View v;
    ImageView prev;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    Button b;
    public page30() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_page30, container, false);
         checkBox1= (CheckBox) v.findViewById(R.id.checkBox1);
         checkBox2= (CheckBox) v.findViewById(R.id.checkBox2);
         checkBox3= (CheckBox) v.findViewById(R.id.checkBox3);
         checkBox4= (CheckBox) v.findViewById(R.id.checkBox4);
        checkBox5= (CheckBox) v.findViewById(R.id.checkBox5);
        prev= (ImageView) v.findViewById(R.id.prev);
        b = (Button) v.findViewById(R.id.gonext);
        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     
                                     String tf="";
                                     if(checkBox1.isChecked())
                                     {
                                         tf=tf+checkBox1.getText().toString()+ " - ";
                                     }
                                     if(checkBox2.isChecked())
                                     {
                                         tf=tf+checkBox2.getText().toString()+ " - ";
                                     }
                                     if(checkBox3.isChecked())
                                     {
                                         tf=tf+checkBox3.getText().toString()+ " - ";
                                     }
                                     if(checkBox4.isChecked())
                                     {
                                         tf=tf+checkBox4.getText().toString()+ " - ";
                                     }
                                     if(checkBox5.isChecked())
                                     {
                                         tf=tf+checkBox5.getText().toString()+ " - ";
                                     }
                                     SharedPreferences tf1 = app.context.getSharedPreferences("tf", 0);
                                     SharedPreferences.Editor editor = tf1.edit();
                                     editor.putString("tf4",tf);
                                     editor.apply();
                                     if(checkBox1.isChecked()||checkBox2.isChecked()||checkBox3.isChecked()||checkBox4.isChecked()||checkBox5.isChecked())
                                     {
                                         //page32
                                         page32 frg1 = new page32();
                                         FragmentManager fm = getActivity().getSupportFragmentManager();
                                         android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                                         ft.replace(R.id.ques, frg1);
                                         myStack.push(30);
                                         ft.commit();


                                     }
                                     else
                                     {
                                         //green result
                                         Bundle bundle = new Bundle();
                                         result_nihss frg1 = new result_nihss();
                                         bundle.putInt("key", 5);
                                         bundle.putInt("pager", 30);
                                         frg1.setArguments(bundle);
                                         FragmentManager fm = getActivity().getSupportFragmentManager();
                                         android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                                         ft.replace(R.id.ques, frg1);
                                         myStack.push(30);
                                         ft.commit();
                                     }
                                 }
                             });

        // Inflate the layout for this fragment
        setFonts();

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
        b.setTextSize(texty);
    }


}