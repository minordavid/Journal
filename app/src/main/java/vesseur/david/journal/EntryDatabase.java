package vesseur.david.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gebruiker on 2-5-2018.
 */

public class EntryDatabase extends SQLiteOpenHelper {
    private static EntryDatabase instance;


    public static final String TABLE_NAME = "entries";

    public static final String KEY_ID = "_id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_CONTENT = "marks";
    public static final String KEY_MOOD = "mood";
    public static final String KEY_TIME = "time";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " ( " +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_TITLE + " TEXT, " +
                KEY_CONTENT + " TEXT, " +
                KEY_MOOD + " INTEGER, " +
                KEY_TIME + " DATETIME DEFAULT (datetime('now','localtime')) " + " ) ";
        sqLiteDatabase.execSQL(query);

        // insertion in the table
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE , "abc");
        values.put(KEY_CONTENT , "95");
        values.put(KEY_MOOD , 1);
        sqLiteDatabase.insert(TABLE_NAME, null, values);

    }

    public static EntryDatabase getInstance(Context context){
        if (instance == null){
            instance = new EntryDatabase(context, TABLE_NAME,null,1 );
        }
        return  instance;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // TODO Auto-generated method stub

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(sqLiteDatabase);

    }
    public Cursor selectAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM entries", null);
        c.moveToFirst();
        db.close();
        return c;
//        return getWritableDatabase().rawQuery("SELECT * FROM entries", null);
    }

    private EntryDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void insert(JournalEntry entry) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mood", entry.getMood());
        values.put("title", entry.getTitle());
        values.put("content", entry.getContent());

        db.insert(TABLE_NAME, null, values);
        db.close();


    }

    public void deleteEntry(long id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, "_id" + "=" + id , null);
        db.close();
    }
}
