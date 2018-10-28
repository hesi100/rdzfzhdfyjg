package hesi100.com.nihss;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uncopt.android.widget.text.justify.JustifiedTextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class help_title extends Fragment {
    TextView header;
    JustifiedTextView matn;
    public help_title() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_help_title, container, false);
        header= (TextView) v.findViewById(R.id.title_q);
        matn= (JustifiedTextView) v.findViewById(R.id.matn);
        try {
            int key = getArguments().getInt("key", 0);
            header.setText(Answer.title(key));
            matn.setText(Answer.gethelp(key));
        }
        catch (NullPointerException e)
        {

        }


        // Inflate the layout for this fragment
        setFonts();
        return v;

    }
    public void setFonts()
    {
        SharedPreferences font = app.context.getSharedPreferences("font", 0);
        int texty;
        texty=font.getInt("font_size",14);
        header.setTextSize(texty);
        matn.setTextSize(texty);

    }

}