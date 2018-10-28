package hesi100.com.nihss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class help_q extends AppCompatActivity {
    TextView header;
    TextView matn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_q);
        header= (TextView) findViewById(R.id.title_q);
        matn= (TextView) findViewById(R.id.matn);
       // Intent iin= getIntent();
      //  Bundle b = iin.getExtras();
//        int key= b.getInt("key",0);
  //      header.setText(Answer.title(key));
    //    matn.setText(Answer.gethelp(key));

    }
    public void close(View v)
    {
        finish();
    }
}
