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

        //INFORMATIKA
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
        Question q7 = new Question("Ktorý tag slúži ako link?","<a></a>","<h1></h1>","<p></p>","<a></a>","Informatika");
        this.addQuestion(q7);
        Question q8 = new Question("Akú hodnotu bude mať premenná i po vykonaní príkazu int i = 3/6", "0,5", "0", "1", "0","Informatika");
        this.addQuestion(q8);
        Question q9 = new Question("Aká je adresa broadcastu pre sieť, v ktorej je počítač s IP adresou 192.168.1.1/27?", "192.168.1.31", "192.168.1.63", "192.168.1.32", "192.168.1.31","Informatika");
        this.addQuestion(q9);
        Question q10 = new Question ("Aké typy súborov majú príponu .avi?", "dokumenty", "videá", "pesničky", "videá","Informatika");
        this.addQuestion(q10);
        //MATEMATIKA
        Question q11 = new Question("Pravdepodobnosť, že odpoviem správne na túto otázku tipovaním:", "1/4", "1/2", "1/3", "1/3","Matematika");
        this.addQuestion(q11);
        Question q12 = new Question("Derivácia výrazu 5x + 5 podľa premennej x:", "5", "5x", "x", "5","Matematika");
        this.addQuestion(q12);
        Question q13 = new Question("Mobil stál 1000€ a zdražel o 10%. Jeho nová cena je:", "1010", "1100", "10000", "1100","Matematika");
        this.addQuestion(q13);
        Question q14 = new Question("Písmenom N sa označuje množina:", "celých čísiel", "prirodzených čísiel", "kladných čísiel", "prirodzených čísiel","Matematika");
        this.addQuestion(q14);
        Question q15 = new Question("Derivácia výrazu sinx podľa premennej x:", "- sinx", "- cosx", " cosx", " cosx","Matematika");
        this.addQuestion(q15);
        Question q16 = new Question("Rímske číslo LXVIII je:", "118", "58", "68", "68","Matematika");
        this.addQuestion(q16);
        Question q17 = new Question("Čo vyplýva z týchto výrokov: Ak sneží, kino je zavreté. Kino je otvorené?", "nesneží", "nič nevyplýva", "sneží", "nesneží","Matematika");
        this.addQuestion(q17);
        Question q18 = new Question("Aký je modus z množiny čísiel {1, 1, 6, 7, 8}?", "5", "1", "4", "1","Matematika");
        this.addQuestion(q18);
        Question q19 = new Question("Ak platia výroky p=>r, q=>r tak platí aj:", " p => q", " r => q", "ani jedna možnosť", "ani jedna možnosť","Matematika");
        this.addQuestion(q19);
        Question q20 = new Question("Negácia výroku: Aspoň jeden z nás vyhral:", "všetci sme vyhrali", "nikto z nás nevyhral", "niekto z nás nevyhral", "nikto z nás nevyhral","Matematika");
        this.addQuestion(q20);
        //DEJEPIS
        Question q21 = new Question("Kedy bola dobitá Bastila?", "1689", "1789", "1714", "1789", "Dejepis");
        this.addQuestion(q21);
        Question q22 = new Question("Kedy sa začala druhá svetová vojna?", "1939", "1938", "1937", "1939", "Dejepis");
        this.addQuestion(q22);
        Question q23 = new Question("Prvý prezident USA bol: ", "George Washington", "John Adams", "Thomas Jefferson", "George Washington","Dejepis");
        this.addQuestion(q23);
        Question q24 = new Question("Prvý slovenský prezident ", "Michal Kováč", "Jozef Tiso", "Róber Fico", "Jozef Tiso","Dejepis");
        this.addQuestion(q24);
        Question q25 = new Question("Ako sa volala prvá atómová bomba, ktorá bola zhodená na japonské mesto Hirošima", "Big Teddy", "Little Boy", "Fat Man", "Little Boy","Dejepis");
        this.addQuestion(q25);
        Question q26 = new Question("V ktorom roku nastal výbuch v ukrajinskej elektrárni ?", "26.04.1986", "04.04.1976", "24.09.1990", "26.04.1986","Dejepis");
        this.addQuestion(q26);
        Question q27 = new Question("Kto sa nezúčasnil pri podpisovaní Mníchovskej dohody?", "Adolf Hilter", "Winston Churchill", "Jozef Tiso", "Jozef TIso", "Dejepis");
        this.addQuestion(q27);
        Question q28 = new Question("Ako sa volal prvý počítač ", "Apple 2", "MsDOS", "ENIAC", "ENIAC","Dejepis");
        this.addQuestion(q28);
        Question q29 = new Question("Kto sa považuje za historicky prvého programátora ? ", "Steve Wozniak ", "Bill Gates", "Augusta Ada Byronová Kingová, grófka Lovelace", "Augusta Ada Byronová Kingová, grófka Lovelace","Dejepis");
        this.addQuestion(q29);
        Question q30 = new Question("Kto sa považuje za vynálezca telefónu?", "Nikola Tesla", " Alexander Graham Bell", "Philo Taylor Farnsworth", "Alexander Graham Bell","Dejepis");
        this.addQuestion(q30);// END
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

