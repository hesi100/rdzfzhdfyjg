package hesi100.com.nihss;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by EHSAN PC on 3/13/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    Context context;
    public DatabaseHelper(Context context) {
        super(context, IOHelper.DATA_DIRECTORY + IOHelper.DATABASE_FILE_NAME, null, 1);
        this.context=context;
    }


    public void insertNewpatient(String patient_code,int puan,String t_t,String t_c,String f_c) {

        SQLiteDatabase dbBazarche = getWritableDatabase();
        String sql = "";
        String g="'";
        String k="%";
        String replace = t_t.replace(g, k);
        try {

            sql = "INSERT INTO illness (patient_code,puan,t_t,t_c,f_c) VALUES('"
                    + patient_code + "','" + puan + "','" + replace + "','" + t_c + "','" + f_c + "')";

            dbBazarche.execSQL(sql);
            dbBazarche.close();
            Toast.makeText(context, "added", Toast.LENGTH_LONG).show();
        }
        catch (android.database.sqlite.SQLiteConstraintException e)
        {
            Toast.makeText(context,"imposible",Toast.LENGTH_LONG).show();
        }
    }

    public void  selectpatient(String code,TextView puan,TextView t_t,TextView t_c,TextView f_c) {
        SQLiteDatabase dbBazarche = getReadableDatabase();
        String sql = "SELECT * FROM illness WHERE patient_code=" + "'"+ code + "'" + "";
        Cursor cursor = dbBazarche.rawQuery(sql, null);
        if(cursor.getCount()==0)
        {
            Toast.makeText(context,"no patient",Toast.LENGTH_LONG).show();
            puan.setText("");
            t_t.setText("");
            t_c.setText("");
            f_c.setText("");
        }
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            do {
                puan.setText(cursor.getString(cursor.getColumnIndex("puan")));
                String h= cursor.getString(cursor.getColumnIndex("t_t"));
                String g="'";
                String k="%";
                String replace = h.replace(k, g);
                t_t.setText(replace);
                t_c.setText(cursor.getString(cursor.getColumnIndex("t_c")));
                f_c.setText(cursor.getString(cursor.getColumnIndex("f_c")));
            } while (cursor.moveToNext());

        }
        cursor.close();
        dbBazarche.close();
    }
    public boolean isselectpatient(String code) {
        boolean yes = false;
        SQLiteDatabase dbBazarche = getReadableDatabase();
        String sql = "SELECT * FROM illness WHERE patient_code=" + "'"+ code + "'" + "";
        Cursor cursor = dbBazarche.rawQuery(sql, null);
        if (cursor.getCount() == 0) {
            yes = false;
        }
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            do {
                yes = true;
            } while (cursor.moveToNext());

        }

        cursor.close();
        dbBazarche.close();
        return yes;
    }

    public void deleteStores(String id) {

        Log.i("LOG", "ehsan:" + id);
        SQLiteDatabase dbBazarche = getWritableDatabase();
        String sql = "DELETE FROM stores WHERE id=" + id + "";
        dbBazarche.execSQL(sql);
        dbBazarche.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
