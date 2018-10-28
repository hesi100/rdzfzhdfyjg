package hesi100.com.nihss;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class page15 extends Fragment {
    LinearLayout lin1;
    LinearLayout lin0;
    TextView text0;
    TextView text1;
    public page15() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v=inflater.inflate(R.layout.fragment_page15, container, false);
        final View fragment;
        fragment = v.findViewById(R.id.ques);
        lin1= (LinearLayout) v.findViewById(R.id.lin1);
        lin0= (LinearLayout) v.findViewById(R.id.lin0);
        text0= (TextView) v.findViewById(R.id.text0);
        text1= (TextView) v.findViewById(R.id.text1);
        lin0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //result red 1 key1

                    result_nihss frg1 = new result_nihss();
                    Bundle bundle = new Bundle();
                    bundle.putInt("key", 1);
                    bundle.putInt("pager", 15);
                    myStack.push(15);
                    frg1.setArguments(bundle);
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.ques, frg1);
                    ft.commit();


            }
        });
        lin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                //page17
                page17 frg1 = new page17();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.ques, frg1);
                myStack.push(15);
                ft.commit();

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