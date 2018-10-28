package hesi100.com.nihss;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by hesi100 on 11/26/2017.
 */

public class app extends Application{

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences font = getApplicationContext().getSharedPreferences("font", 0);
        context = getApplicationContext();
        IOHelper.transferDatabaseFile(context);
        fontchange();
    }
    public static void fontchange()
    {
        String s;
        SharedPreferences font = context.getSharedPreferences("font", 0);
        s=font.getString("font_type","FTLTLT");

        if(s.equals("FTLTLT")) {
            CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                    .setDefaultFontPath("font/FTLTLT.TTF")
                    .setFontAttrId(R.attr.fontPath)
                    .build()
            );

        }
        else if(s.equals("segoepr")) {
            CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                    .setDefaultFontPath("font/segoepr.ttf")
                    .setFontAttrId(R.attr.fontPath)
                    .build()
            );

        }
        else   {
            CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                    .setDefaultFontPath("font/times.ttf")
                    .setFontAttrId(R.attr.fontPath)
                    .build()
            );

        }

    }
}
