package com.sinhvien.myrex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper
{
    public static String database_name = "your_note";
    private static final int database_version = 1;

    private static final String table_Tu = "Tu";
    private static final String tu_id = "id";
    private static final String tu_name = "name";
    private static final String tu_dn = "dinhNghia";
    private static final String tu_img = "image";



    private static final String Create_table_tu = "CREATE TABLE " + table_Tu + "("
            + tu_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + tu_name + " TEXT, "
            + tu_dn + " TEXT, "
            + tu_img + " BLOB);";



    public Database(Context context)
    {
        super(context, database_name, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(Create_table_tu);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS '" + table_Tu + "'");
        onCreate(db);
    }

    public void addTu(String name, String dinhNghia, byte[] image)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(tu_name, name);
        cv.put(tu_dn, dinhNghia);
        cv.put(tu_img, image);

        db.insert(table_Tu, null, cv);
    }

    public ArrayList<note_tu> getAllTu()
    {
        ArrayList<note_tu> tuList = new ArrayList<note_tu>();
        String query = "SELECT * FROM " + table_Tu;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst())
        {
            do
            {
                note_tu nt = new note_tu();

                nt.setId(c.getInt(c.getColumnIndex(tu_id)));
                nt.setTenTu(c.getString(c.getColumnIndex(tu_name)));
                nt.setDinhNghia(c.getString(c.getColumnIndex(tu_dn)));
                nt.setHinhanh(c.getBlob(c.getColumnIndex(tu_img)));

                tuList.add(nt);
            }
            while (c.moveToNext());
        }
        return tuList;
    }
}
