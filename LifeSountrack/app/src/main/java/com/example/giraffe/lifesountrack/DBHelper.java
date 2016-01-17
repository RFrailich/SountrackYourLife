package com.example.giraffe.lifesountrack;

import android.content.Context;
import android.database.sqlite.*;

/**
 * Created by Giraffe on 2016-01-16.
 */
public class DBHelper extends SQLiteOpenHelper {


    static final String dbName="songDB";
    static final String songTable="Songs";
    static final String colID="SongID";
    static final String colBPM="BPM";
    static final String colPath="Path";
    static final String colList="List";

    static final String viewEmps="ViewEmps";

  public DBHelper(Context context) {

      super(context, dbName, null, 33);
  }

      public void onCreate(SQLiteDatabase db){

          db.execSQL("CREATE TABLE "+songTable+" ("+colID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                  ""+colBPM+" INTEGER "+colPath+" STRING "+colList+" LIST);");

      }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

        db.execSQL("DROP TABLE IF EXISTS "+songTable);
        onCreate(db);
    }


  }

