package a3blaf.a3blafgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "database";
    // tasks table name
    private static final String TABLE_QUEST = "guestions";
    // tasks Table Columns names
    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c
    private static final String KEY_CATEGORY = "category";

    private SQLiteDatabase dbase;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC +" TEXT, " + KEY_CATEGORY + " TEXT)";
        db.execSQL(sql);
        addQuestions();
        // db.close();
    }

    private void addQuestions() {


        Question q1 = new Question("Koľko bitov má jeden bajt?", "8", "7", "9", "8","Informatika");
        this.addQuestion(q1);
        Question q2 = new Question("Ktorý algoritmus na triedenie je najrýchlejší?", "Bubble sort", "Quick sort", "Merge sort", "Quick sort", "Informatika");
        this.addQuestion(q2);
        Question q3 = new Question("Kde vznikol internet?", "CERN", "MIT", "Oxford", "CERN", "Informatika");
        this.addQuestion(q3);
        Question q4 = new Question("V ktorom roku vznikol jazyk C?", "1973", "1980", "1972", "1972", "Informatika");
        this.addQuestion(q4);
        Question q5 = new Question("Vykonaj operáciu or: 0011 or 1111", "0101", "1111", "0000", "1111", "Informatika");
        this.addQuestion(q5);
        Question q6 = new Question("Kto bol prvý programátor?", "Charles Babbage", "Alan Turing", "Ada Lovelace", "Ada Lovelace", "Informatika");
        this.addQuestion(q6);

        // END
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }

    // Adding new question
    public void addQuestion(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_CATEGORY, quest.getCATEGORY());

        dbase.insert(TABLE_QUEST, null, values);
    }

    public void addOwnQuestion(Question quest){
        dbase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_CATEGORY, quest.getCATEGORY());

        dbase.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();

        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setCATEGORY(cursor.getString(6));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }

        Collections.shuffle(quesList);
        return quesList;
    }

    public List<Question> getAllQuestionsByCategory(String category) {
        List<Question> quesList = new ArrayList<Question>();

        String selectQuery = "SELECT  * FROM " + TABLE_QUEST+ " WHERE "+KEY_CATEGORY+" = '"+ category+"'";
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setCATEGORY(cursor.getString(6));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }

        Collections.shuffle(quesList);
        return quesList;
    }


}

