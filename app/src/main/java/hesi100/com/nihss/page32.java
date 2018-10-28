package hesi100.com.nihss;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class page32 extends Fragment {
    TextView text0;
    TextView text1;
    ImageView prev;
    public page32() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_page32, container, false);
        LinearLayout lin0= (LinearLayout) v.findViewById(R.id.lin0);
        LinearLayout lin1= (LinearLayout) v.findViewById(R.id.lin1);
        text0= (TextView) v.findViewById(R.id.text0);
        text1= (TextView) v.findViewById(R.id.text1);
        prev= (ImageView) v.findViewById(R.id.prev);
        lin0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //page red
                Bundle bundle = new Bundle();
                result_nihss frg1 = new result_nihss();
                bundle.putInt("key", 4);
                bundle.putInt("pager", 32);
                myStack.push(32);
                frg1.setArguments(bundle);
                FragmentManager fm = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.ques, frg1);
                ft.commit();
            }
        });
        lin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //result green
                Bundle bundle = new Bundle();
                result_nihss frg1 = new result_nihss();
                bundle.putInt("key", 5);
                bundle.putInt("pager", 32);
                myStack.push(32);
                frg1.setArguments(bundle);
                FragmentManager fm = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.ques, frg1);
                ft.commit();
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
        text0.setTextSize(texty);
        text1.setTextSize(texty);
    }

}