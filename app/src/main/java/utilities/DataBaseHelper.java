package utilities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="conafe";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_GROUPS = "CREATE TABLE groups (group_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "name_group TEXT NOT NULL,"+"synchronize TEXT NOT NULL)";

    public static final String TABLE_STUDENTS = "CREATE TABLE students (student_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"group_id INTEGER,"+"curp TEXT NOT NULL,"+"born_date TEXT NOT NULL,"+"student_name TEXT NOT NULL,"
            +"gender TEXT NOT NULL,"+"school_grade TEXT NOT NULL,"+"avatar_uri TEXT,"+"synchronize TEXT,"
            +"FOREIGN KEY (group_id) REFERENCES groups(group_id))";

    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS groups");
        db.execSQL("DROP TABLE IF EXISTS students");
        db.execSQL(TABLE_GROUPS);
        db.execSQL(TABLE_STUDENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS groups");
        db.execSQL("DROP TABLE IF EXISTS students");
        onCreate(db);
    }
}
