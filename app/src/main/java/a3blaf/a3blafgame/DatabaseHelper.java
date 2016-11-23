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
        Question q81 = new Question("Ktorá pamäť nie je perzistentná?", "cache", "CD/DVD", "flash disk", "cache","Informatika");
        this.addQuestion(q81);
        Question q82 = new Question("TLB (Translation Lookaside buffer) sa nachádza v?", "hlavnej pamäti", "registroch", "MMU", "MMU","Informatika");
        this.addQuestion(q82);
        Question q83 = new Question("FIFO algoritmus vyberie stránku ktorá sa?", "vložila posledná", "vložila prvá", "najdlhšie používala", "vložila prvá","Informatika");
        this.addQuestion(q83);
        Question q84 = new Question("Vektorový grafický editor?", "Adobe Photoshop", "MS PhotoPaint", "Corel Drive", "Corel Drive","Informatika");
        this.addQuestion(q84);
        Question q85 = new Question("Príkaz na porovnanie obsahov súborov?", "cpr", "cmp", "comp", "cmp","Informatika");
        this.addQuestion(q85);
        Question q86 = new Question("Ktoré zariadenie pracuje na fyzickej vrstve OSI modelu?", "switch", "repeater", "router", "repeater","Informatika");
        this.addQuestion(q86);
        Question q87 = new Question("Čím sa zaoberá kybernetika?", "prenosom informácií v strojoch", "ovládaním robotov", "ovládaním počítačov", "prenosom informácií v strojoch","Informatika");
        this.addQuestion(q87);
        Question q88 = new Question("Čo znamená označenie CD-RW?", "zapisovateľné CD", "prepisovateľné CD", "ani jedna možnosť", "zapisovateľné CD","Informatika");
        this.addQuestion(q88);
        Question q89 = new Question("Akú veľkosť má dátový typ char?", "1bit", "8bytov", "1byte", "1byte","Informatika");
        this.addQuestion(q89);
        Question q90 = new Question("Herder je?", "počítač v nebezpečnej sieti", "osoba spravujúca botnet", "počítač v sieti", "osoba spravujúca botnet","Informatika");
        this.addQuestion(q90);
        Question q91 = new Question("Čo je to SPAM?", "zdrojový kód", "šifrovaná správa", "nevyžiadaná pošta", "nevyžiadaná pošta","Informatika");
        this.addQuestion(q91);
        Question q92 = new Question("Program na preklad zdrojového kódu programovacieho jazyka?", "debugger", "kompilátor", "linker", "kompilátor","Informatika");
        this.addQuestion(q92);
        Question q93 = new Question("HW alebo SW prostredie, kde sa spúšťajú programy?", "plug-in", "platforma", "framework", "platforma","Informatika");
        this.addQuestion(q93);
        Question q94 = new Question("Vysokorýchlostná mobilná sieť?", "LTE", "NFC", "LAN", "LTE","Informatika");
        this.addQuestion(q94);
        Question q95 = new Question("Čo je Host?", "PC v sieti", "adresa PC v sieti", "nebezpečný kód", "PC v sieti","Informatika");
        this.addQuestion(q95);
        Question q96 = new Question("Čo je XML?", "skriptovací jazyk", "značkovací jazyk", "programovací jazyk", "značkovací jazyk","Informatika");
        this.addQuestion(q96);
        Question q97 = new Question("Čo je to ABAP?", "skriptovací jazyk", "značkovací jazyk", "programovací jazyk", "programovací jazyk","Informatika");
        this.addQuestion(q97);
        Question q98 = new Question("Čo je to Flaming ?", "závislosť od internetu", "zverejňovanie urážlivých správ", "vytváranie identity", "zverejňovanie urážlivých správ","Informatika");
        this.addQuestion(q98);
        Question q99 = new Question("Ktoré zariadenie pracuje na dátovej vrstve OSI modelu?", "modem", "router", "bridge","bridge","Informatika");
        this.addQuestion(q99);
        Question q100 = new Question("Zamknutie klávesnice systéme Windows?", "windows + U", "windows + L", "windows + Z", "windows + L","Informatika");
        this.addQuestion(q100);

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
        Question q101 = new Question("Akú pravdivostnú hodnotu má výrok:Pôjdeš von?", "nie je to výrok", "je pravdivý", "je nepravdivý", "nie je to výrok","Matematika");
        this.addQuestion(q101);
        Question q102 = new Question("Disjunkcia sa dá nahradiť funkciou?", "minimum", "maximum", "priemer", "maximum","Matematika");
        this.addQuestion(q102);
        Question q103 = new Question("Tvrdenie, ktoré ešte nie je overené nazývame?", "kontradikcia", "axióma", "hypotéza", "hypotéza","Matematika");
        this.addQuestion(q103);
        Question q104 = new Question("Ktorý výrok je pravdivý?", "0 => 1", "0 ∨ (1 => 0)", "1 ∧ (1 => 0)", "0 => 1","Matematika");
        this.addQuestion(q104);
        Question q105 = new Question("Čo vypočítame vzorcom: π*r2+π*r*s?", "povrch ihlana", "povrch kužeľa", "objem kužeľa", "povrch kužeľa","Matematika");
        this.addQuestion(q105);
        Question q106 = new Question("Vzorec na výpočet objemu kužeľa?", "π * r2 + π * r * s", "1/3 * π * r2 * v", "1/3 * π * r * v", "1/3 * π * r2 * v","Matematika");
        this.addQuestion(q106);
        Question q107 = new Question("Ktoré teleso má vzorec na objem: V = a*b*c?", "ihlan", "valec", "kváder", "kváder","Matematika");
        this.addQuestion(q107);
        Question q108 = new Question("Písmenom Q sa označuje množina?", "reálnych čísel", "racionálnych čísel", "iných čísel", "racionálnych čísel","Matematika");
        this.addQuestion(q108);
        Question q109 = new Question("Ktoré číslo je zložené číslo?", "13", "7", "9", "9","Matematika");
        this.addQuestion(q109);
        Question q110 = new Question("Násobením dvoch celých čísiel dostaneme vždy?", "prirodzené číslo", "celé číslo", "párne číslo", "celé číslo","Matematika");
        this.addQuestion(q110);
        Question q111 = new Question("Násobením dvoch prvočísiel dostaneme vždy?", "prvočíslo", "prirodzené číslo", "racionálne číslo", "prirodzené číslo","Matematika");
        this.addQuestion(q111);
        Question q112 = new Question("Číslo 3/2 je číslo?", "racionálne", "iracionálne", "reálne", "racionálne","Matematika");
        this.addQuestion(q112);
        Question q113 = new Question("Ktoré číslo nie je prvočíslo?", "3", "5", "6", "6","Matematika");
        this.addQuestion(q113);
        Question q114 = new Question("Koľko deliteľov má prvočíslo?", "0", "1", "2", "2","Matematika");
        this.addQuestion(q114);
        Question q115 = new Question("Derivácia výrazu cotgx podľa premennej x:", "- 1 / cos2x", "- 1 / sin2x", "1 / sin2x", "- 1 / sin2x","Matematika");
        this.addQuestion(q115);
        Question q116 = new Question("Derivácia výrazu cos x podľa premennej x:", "- cosx", "- sinx", "sinx", "- sinx","Matematika");
        this.addQuestion(q116);
        Question q117 = new Question("Deriváciou čísla (konštatny) 11 dostaneme:", "0", "1", "11x", "0","Matematika");
        this.addQuestion(q117);
        Question q118 = new Question("Zderivujte výraz 5*lnx podľa premennej x:", "1/lnx", "5/x", "5x", "5/x","Matematika");
        this.addQuestion(q118);
        Question q119 = new Question("Ktoré hodnoty za nedajú zoradiť?", "kardinálne", "nominálne", "ordinálne", "nominálne","Matematika");
        this.addQuestion(q119);
        Question q120 = new Question("Variačné rozpätie postupnosti celých čísiel z intervalu od 1 do 5?", "2,5", "5", "4", "4","Matematika");
        this.addQuestion(q120);

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
        this.addQuestion(q30);
        Question q31 = new Question("Archimedes sa spája s vynálezom:", "Okuliarov", "Skrutky", "Zámky", "Skrutky","Dejepis");
        this.addQuestion(q31);
        Question q32 = new Question("V ktorom roku vydal cisár Fridrich II. listinu Zlatá bula sicílska?", "1258", "1212", "1278", "1212","Dejepis");
        this.addQuestion(q32);
        Question q33 = new Question("Aký je príbuzenský vzťah medzi Máriou Teréziou a Leopoldom II.?", "babička-vnuk", "žiadny", "matka-syn", "matka-syn","Dejepis");
        this.addQuestion(q33);
        Question q34 = new Question("Mária Antoinetta sa stala manželkou..", "Ľudovíta XVI.", "Ľudovíta XVIII.", "Napoleona Bonaparte", "Ľudovíta XVI.","Dejepis");
        this.addQuestion(q34);
        Question q35 = new Question("Kto bol americkým prezidentom v čase, kedy vstúpilo USA do druhej svetovej vojny?", "Harry S. Truman", "Dwight D. Esenhower", "Franklin D. Roosevelt", "Franklin D. Roosevelt","Dejepis");
        this.addQuestion(q35);
        Question q36 = new Question("Kedy kapitulovalo Japonsko v druhej svetovej vojke?", "2. septembra 1945", "1. septembra 1945", "3. septembra 1945", "2. septembra 1945","Dejepis");
        this.addQuestion(q36);
        Question q37 = new Question("Kedy vznikla Byzantská ríša?", "v roku 893", "v roku 1453", "v roku 1218", "1453","Dejepis");
        this.addQuestion(q37);
        Question q38 = new Question("Sissi bola bavorská princezná a rakúska cisárovná. Aké bolo jej skutočné meno?", "Alžbeta Bavorská", "Sissi von Habsburg", "Žofia Korutánska", "Alžbeta Bavorská","Dejepis");
        this.addQuestion(q38);
        Question q39 = new Question("Čo zakazoval Le Chaplierov zákon?", "štrajky a vytváranie profesionálnych zväzov", "osobné vlastníctvo", "absolútnu vládu jedného kráľa", "štrajky a vytváranie profesionálnych zväzov","Dejepis");
        this.addQuestion(q39);
        Question q40 = new Question("Za vlády ktorého panovníka prišli na naše územie Konštantín a Metod?", "za vlády Svätopluka I.", "za vlády Mojmíra I.", "za vlády Rastislava", "za vlády Svätopluka I.","Dejepis");
        this.addQuestion(q40);
        Question q41 = new Question("Storočná válka, konflikt medzi Anglickom a Francúzskom, sa odohrávala v rokoch...", "1312-1412", "1337-1435", "1337-1453", "1337-1453","Dejepis");
        this.addQuestion(q41);
        Question q42 = new Question("Posledným Luxemburgom na českom tróne bol syn  Karola IV. a bol to..", "Václav IV.", "Matúš Korvín", "Žigmund Luxemburský", "Žigmund Luxemburský","Dejepis");
        this.addQuestion(q42);
        Question q43 = new Question("V ktorom roku vznikla veľká Británia?", "1707", "1724", "1822", "1707","Dejepis");
        this.addQuestion(q43);
        Question q44 = new Question("Veľká francúzska revolúcia začala v roku", "1785", "1789", "1801", "1789","Dejepis");
        this.addQuestion(q44);
        Question q45 = new Question("Bitka u Slavkova bola významným počinom francúzskeho panovníka, ktorý sa volal...", "Charles de Gaulea", "Karol I.", "Napoleon Bonaparte", "Napoleon Bonaparte","Dejepis");
        this.addQuestion(q45);
        Question q46 = new Question("Americký prezident Abraham Lincoln sa zaslúžil o zrušenie otroctva v USA. Stalo sa to v roku:", "1863", "1864", "1865", "1865","Dejepis");
        this.addQuestion(q46);
        Question q47 = new Question("Behom občianskej války v USA bol prezidentom:", "George Washington", "Abraham Lincoln", "Groover Cleveland", "Abraham Lincoln","Dejepis");
        this.addQuestion(q47);
        Question q48 = new Question("V roku 1867 došlo mimo iného aj...", "ku koncu občianskej války v USA", "zrušeniu nevoľníctva v českých zemiach", "rakúsko-uhorskému vyrovnaniu", "rakúsko-uhorskému vyrovnaniu","Dejepis");
        this.addQuestion(q48);
        Question q49 = new Question("Kedy došlo k požiaru Národného divadla v Prahe?", "1881", "1882", "1883", "1881","Dejepis");
        this.addQuestion(q49);
        Question q50 = new Question("V roku 1896 sa odohrali:", "prezidentské voľby v USA", "Prvé novodobé Olympijské hry", "války o španielske dedičstvo", "Prvé novodobé Olympijské hry","Dejepis");
        this.addQuestion(q50);

        //Vedeli ste ze
        Question q51 = new Question("Ktoré tvrdenie o zvieratách je pravdivé?", "Erdžanie pomáha koňom regulovať vlastnú telesnú teplotu", "Pradenie mačiek má liečivé účinky", "Kňučanie pomáha psom zahnať vlastný hlad", "Pradenie mačiek má liečivé účinky","Vedelisteze");
        this.addQuestion(q51);
        Question q52 = new Question("Ktorá činnosť nás najlepšie upokojí ked' sme nervózni?", "Opakované zvieranie ľavej ruky v päsť", "Žuvanie žuvačky", "Pohybovanie prstami na nohách", "Žuvanie žuvačky","Vedelisteze");
        this.addQuestion(q52);
        Question q53 = new Question("U koho sa vyskytuje hallux valgus", "U mužov ktorí nosia úzke nohavice", "U žien ktoré nosia topnánky na vysokých opätkoch", "U šoférov z povolania", "U žien ktoré nosia topnánky na vysokých opätkoch","Vedelisteze");
        this.addQuestion(q53);
        Question q54 = new Question("Pohľad na človeka trasúceho sa od zimy...", "Spôsobuje zníženie telesnej teploty", "Spôsobuje v nás prudké návaly hladu", "Ovplyvňuje našu rovnováhu", "Spôsobuje zníženie telesnej teploty","Vedelisteze");
        this.addQuestion(q54);
        Question q55 = new Question("Ako zabránime nepríjemnému stekaniu sviečok?", "Potrieme ich cmarom", "Vyložíme ich na priame slnko", "Ponoríme ich do slanej vody", "Ponoríme ich do slanej vody","Vedelisteze");
        this.addQuestion(q55);
        Question q56 = new Question("Jedna z najväčších záhad Slovenska je Val obrov. Je to...", "Vysoké opevnenie čachtického hradu", "Zemný val od Sitna po Ipeľ", "Pozostatok sopky z Vyhorlatských vrchov", "Zemný val od Sitna po Ipeľ","Vedelisteze");
        this.addQuestion(q56);
        Question q57 = new Question("Kto trpí triskaidekafóbiou, radšej by nemal...", "Vkročiť na prechod pre chodcov", "Bývať v hoteli na 13 poschodí", "Sadať si na zadné miesto v aute", "Bývať v hoteli na 13 poschodí","Vedelisteze");
        this.addQuestion(q57);
        Question q58 = new Question("Britská kráľovná vo svojej mladosti...", "Získala majstrovský titul v krikete", "Účinkovala v prvom britskom sitkome", "Vyučila sa za mechaničku nákladných vozidiel", "Vyučila sa za mechaničku nákladných vozidiel","Vedelisteze");
        this.addQuestion(q58);
        Question q59 = new Question("Čo vyrábala stará bratislavská továreň Stollwerck?", "Cverny", "Nábytok", "Cukrovinky", "Cukrovinky","Vedelisteze");
        this.addQuestion(q59);
        Question q60 = new Question("Aby bol účinok rannej kávy najsilnejší, treba ju piť najlpšie...", "Vlažnú", "Postojačky", "Hodinu po zobudení", "Hodinu po zobudení","Vedelisteze");
        this.addQuestion(q60);
        Question q61 = new Question("Sejačka bola vynájdená v", "Mezopotámii", "Egypte", "Amerike", "Mezopotámii","Vedelisteze");
        this.addQuestion(q61);
        Question q62 = new Question("Prvý eskalátor zostrojil:", "Jesse W. Reno a George H. Wheeler", "Willbur Wright a Arthur Korn", "Paul Cornu a Richard Drew", "Jesse W. Reno a George H. Wheeler","Vedelisteze");
        this.addQuestion(q62);
        Question q63 = new Question("Jozef Murgaš vynašiel:", "dynamit", "mlátičku obilia", "bezdrôtovú telegrafiu", "bezdrôtovú telegrafiu","Vedelisteze");
        this.addQuestion(q63);
        Question q64 = new Question("Prvý kombajn zostrojili:", "v USA", "v Rusku", "v Nemecku", "v USA","Vedelisteze");
        this.addQuestion(q64);
        Question q65 = new Question("Kompaktný disk (CD) vznikol:", "v 70. Rokoch 20. storočia", "v 90. Rokoch 20. storočia", "v 60. Rokoch 20. storočia", "v 70. Rokoch 20. storočia","Vedelisteze");
        this.addQuestion(q65);
        Question q66 = new Question("Archimedes sa spája s vynálezom", "skrutky", "okuliarov", "zámky", "skrutky","Vedelisteze");
        this.addQuestion(q66);
        Question q67 = new Question("Štefan Banič vynašiel:", "konzervu", "splachovací záchod", "padák", "padák","Vedelisteze");
        this.addQuestion(q67);
        Question q68 = new Question("Bratia Wrightovci vynašli:", "elektrickú žehličku", "lietadlo", "parnú železnicu", "lietadlo","Vedelisteze");
        this.addQuestion(q68);
        Question q69 = new Question("Prvá civilizácia, ktorá začala používať písmo, žila:", "v Číne", "v Grécku", "v Mezopotámii", "v Mezopotámii","Vedelisteze");
        this.addQuestion(q69);
        Question q70 = new Question("Prvú znáu fotografiu vytvoril:", "Hyram Moore", "Joseph Nicéphore Niepce", "Arthur Korn", "Joseph Nicéphore Niepce","Vedelisteze");
        this.addQuestion(q60);
        Question q71 = new Question("Prvý načúvací prístroj zostrojil:", "Alexander Graham Bell", "Miller Reese Hutchinson", "Arthur Korn", "Miller Reese Hutchinson","Vedelisteze");
        this.addQuestion(q71);
        Question q72 = new Question("Čepel na holenie vynašiel", "William Henson", "Thomas Plucknett", "W.S. Burroughs", "William Henson","Vedelisteze");
        this.addQuestion(q72);
        Question q73 = new Question("Prvú zošívačku zostrojili:", "v USA", "v Taliansku", "vo Francúzsku", "v USA","Vedelisteze");
        this.addQuestion(q73);
        Question q74 = new Question("Alfred Nobel je vynálezcom:", "dynamitu", "automobilu", "elektrickej žehličky", "dynamitu","Vedelisteze");
        this.addQuestion(q74);
        Question q75 = new Question("Alexander Flemming vynašiel:", "penicilín", "mikroprocesor", "očkovanie", "penicilín","Vedelisteze");
        this.addQuestion(q75);
        Question q76 = new Question("Koleso bolo vynájdené okolo roku:", "2000 p.n.l.", "3500 p.n.l.", "1500 p.n.l", "3500 p.n.l.","Vedelisteze");
        this.addQuestion(q76);
        Question q77 = new Question("Prvé televízne vysielanie sa uskutočnilo v roku:", "1921", "1934", "1929", "1929","Vedelisteze");
        this.addQuestion(q77);
        Question q78 = new Question("Prvé mechanické hodiny boli zostrojené:", "v Izraeli", "V mezopotámii", "v Číne", "v Číne","Vedelisteze");
        this.addQuestion(q78);
        Question q79 = new Question("Mlátičku na obilie vynašli v:", "Škótsku", "Rusku", "Nemecku", "Škótsku","Vedelisteze");
        this.addQuestion(q79);
        Question q80 = new Question("Prvé bankomatové karty vznikli:", "v 20. Rokoch 20. storočia", "v 50. Rokoch 20. storočia", "v 40. Rokoch 20. storočia", "v 20. Rokoch 20. storočia","Vedelisteze");
        this.addQuestion(q80);


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

    public void removeQuestion(int questionId) {
        dbase = this.getWritableDatabase();
        dbase.delete(TABLE_QUEST,KEY_ID+" = "+String.valueOf(questionId),null);
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
