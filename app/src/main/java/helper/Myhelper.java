package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Myhelper extends SQLiteOpenHelper {

    private static final String databaseName = "DictionaryDB";
    private static final int dbversion = 1;

    private static final String tablename = "tblWord";
    private static final String Wordid = "Wordid";
    private static final String Word = "Word";
    private static final String Wordmeaning = "Wordmeaning";

    public Myhelper(Context context) {
        super(context, databaseName, null, dbversion);


    }

    public long InsertData(String word, String wordmeaning, SQLiteDatabase db) {
        long id;
        ContentValues contentValues = new ContentValues();
        contentValues.put(Word, word);
        contentValues.put(Wordmeaning, wordmeaning);
        id = db.insert(tablename, null, contentValues);
        return id;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + tablename + "("
                + Wordid + " INTEGER PRIMARY KEY AUTOINCREMENT," + Word
                + " TEXT," + Wordmeaning + " TEXT" + ")";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
