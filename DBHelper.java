package com.example.brainbruiser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "triviaQuiz";
	private static final String TABLE_TECH = "quest";
	private static final String TABLE_SPORTS = "sports";
	private static final String TABLE_POLI = "politics";
	private static final String TABLE_APTI = "aptitude";
	private static final String TABLE_CINEMA = "cinema";
	private static final String KEY_ID = "id";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; 
	private static final String KEY_OPTA= "opta"; 
	private static final String KEY_OPTB= "optb"; 
	private static final String KEY_OPTC= "optc"; 
	private static final String KEY_OPTD= "optd";
	private SQLiteDatabase dbase;
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		dbase=db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_TECH + " ( "
		+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
		+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
		+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT,"+KEY_OPTD+" TEXT)";
		
		String sql1 = "CREATE TABLE IF NOT EXISTS " + TABLE_SPORTS + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT,"+KEY_OPTD+" TEXT)";
		
		String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_APTI + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT,"+KEY_OPTD+" TEXT)";
		
		String sql3 = "CREATE TABLE IF NOT EXISTS " + TABLE_CINEMA + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT,"+KEY_OPTD+" TEXT)";
		
		String sql4 = "CREATE TABLE IF NOT EXISTS " + TABLE_POLI + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT,"+KEY_OPTD+" TEXT)";
		db.execSQL(sql);
		db.execSQL(sql1);
		db.execSQL(sql2);
		db.execSQL(sql3);
		db.execSQL(sql4);
		addQuestionstech();
		addQuestionsports();
		addQuestionspoli();
		addQuestioncinema();
		addQuestionapti();
		//System.out.println()
		//db.close();
		
	}
	private void addQuestionapti()
	{
		Question q1=new Question("A goat is tied to one corner of a square" + 
	"plot of side 12m by a rope 7m long find the area it can graze.","38.5 sq.m", "155 sq.m", "144 sq.m", "19.25 sq.m", "155 sq.m");
		this.addQuestion4(q1); 
		Question q2=new Question("if 2x-y=4, then 6x-3y=?", "15", "12", "18", "10", "12");
		this.addQuestion4(q2);
		Question q3=new Question("What is the missing number in this series?8 2 14 6 11 ? 14 6 18 12", "2", "9", "3", "11", "9");
		this.addQuestion4(q3);
		Question q4=new Question("The total of the ages of Amar, Akbar and Anthony is 80 years. " +
				"What was the otal of their ages three years ago?", "71 years", "73 years",
				"77 years", "76 years", "71 years");
		this.addQuestion4(q4);
		Question q5=new Question("What is the produt of all the numbers in the dial of a telephone?",
				"1,58,480", "1,58,450", "1,45,580", "None of these", "None of these");
		this.addQuestion4(q5);
		Question q6=new Question("Which word best expresses the meaning of the word 'IRONIC'?",
				"Inflexible", "Bitter", "Good-natured", "Disguisedly sarcastic", "Disguisedly sarcastic");
		this.addQuestion4(q6);
		Question q7=new Question("Pointing to a man in a photograph, a woman said, 'His brother's father " +
				"is the only son of my grandfather.' How is the woman related to the man in the photograph?", "Sister", "Aunt", "Grandmother", "Daughter", "Sister");
		this.addQuestion4(q7);
		Question q8=new Question("Poles : Magnet:: ? : Battery", "Energy", "Power", "Terminals", "Cells", "Terminals");
		this.addQuestion4(q8);
		Question q9=new Question("Which word best expresses the meaning of the word 'INEXPLICABLE'?",
				"Confusing", "Unaccountable", "Chaotic", "Unconnected", "Unaccountable");
		this.addQuestion4(q9);
		Question q10=new Question("Architect : Building:: Sculptor : ? ", "Chisel", "Statue", "Museum", "Stone", "Stone");
		this.addQuestion4(q10);
		Question q11=new Question("Which word best expresses the meaning of the word 'SHALLOW'?",
				"Foolish", "Artificial", "Worthless", "Superficial", "Superficial");
		this.addQuestion4(q11);
		Question q12=new Question("Peace : Chaos:: Creation : ? ",
				"Manufacture", "Destruction", "Build", "Construction", "Destruction");
		this.addQuestion4(q12);
		Question q13=new Question("A told B, 'The girl I met yesterday is the youngest daughter" +
				" of the brother-in-law of my friend's mother.' How is the girl related to A's friend?",
				"Niece", "Cousin", "Friend", "Daughter", "Daughter");
		this.addQuestion4(q13);
		Question q14=new Question("FAG,GAF,HAI,IAH,___", "JAK", "HAL", "HAK", "JAI", "JAK");
		this.addQuestion4(q14);
		Question q15=new Question("SCD, TEF, UGH, ___, WKL", "CMN", "UJI", "VIJ", "IJT", "VIJ");
		this.addQuestion4(q15);
		Question q16=new Question("8th Dec 2007 was Saturday, what day of the week was it on 8th Dec 2006?",
				"Sunday", "Monday", "Friday", "Tuesday", "Friday");
		this.addQuestion4(q16);
		Question q17=new Question("12 year old Manik is thrice as old as his brother Manan." +
				" How old will Manik be when he is twice as old as Manan?", "14 years", "16 years", "18 years", "18 years", "16 years");
		this.addQuestion4(q17);
		Question q18=new Question("If you write down all numbers from 1 to 100, how many times will you write 3?", "11", "18", "20", "21", "20");
		this.addQuestion4(q18);
		Question q19=new Question("If the number 5*2 is divisible by 6, then *=?", "3", "2", "4", "6", "2");
		this.addQuestion4(q19);
		Question q20=new Question("WHich of the following can't be the square of a natural number?",
				"128242", "128881", "130321", "131044", "128242");
		this.addQuestion4(q20);
		
	}
	
	private void addQuestionspoli(){
		Question q1=new Question("Which state has no Panchayati Raj Institution?",
				"Mizoram", "Manipur", "Nagaland","Jharkhand" ,"Nagaland");
				this.addQuestion2(q1);	
				Question q2=new Question("Rajya Sabha has a strength of",
			   "200 members", "225 members", "250 members","300 members" ,"250 members");
				this.addQuestion2(q2);	
				Question q3=new Question("The national words 'Satyameva Jayathe' are taken from-",
				"Jataka","Mundaka Upanishad","Mahabharatha","Puranas","Mundaka Upanishad");
				this.addQuestion2(q3);	
				Question q4=new Question("The power to decide petition is vested in the","Parliament",
				"Supreme Court", "High Courts","Election Commission" ,"High Courts");
				this.addQuestion2(q4);	
				Question q5=new Question("The present Lok Sabha is","13th Lok Sabha", "14th Lok Sabha",
				"15th Lok Sabha","16th Lok Sabha" ,"16th Lok Sabha");
				this.addQuestion2(q5);
				Question q6=new Question("The Directive Principles of the Indian Constitution were incorporated from- ",
				"England", "Ireland","U.S.A","Canada" ,"Ireland");
				this.addQuestion2(q6);
				Question q7=new Question("The members of Lok Sabha hold office for a term of", 
				"4 years", "5 years","6 years" ,"3 years","5 years");
				this.addQuestion2(q7);
				Question q8=new Question("The minimum age to qualify for elections to the Lok Sabha is", 
				"25 years", "21 years","18 years" ,"35 years","25 years");
				this.addQuestion2(q8);
				Question q9=new Question("The president of India addresses his resignation letter to the", 
				"speaker", "Vice president of India","Chief Justice" ,"Prime Minister","Vice president of India ");
				this.addQuestion2(q9);
				Question q10=new Question("Who is the longest serving Chief Minister of India", 
				"M Karunanidhi", "Jyoti Basu","Sheila Dixit" ,"Manik Saarkar","Jyoti Basu");
				this.addQuestion2(q10);
				Question q11=new Question("Which state has the largest number of seats reserved for schedule tribes in Lok Sabha", 
				"Bihar", "Assam","Madhya Pradesh" ,"Chhattisgarh","Madhya Pradesh");
				this.addQuestion2(q11);
				Question q12=new Question("The members of the Rajya Sabha are elected for a term ", 
				"of six years", "determined by the state legislative assembly","of four years" ,
				"None of the above","of six years");
				this.addQuestion2(q12);
				Question q13=new Question("The members of Parliament can express themselves in the House in ", 
			    "English only", "Hindi only","English or Hindi" ,
				"English,Hindi or mother tongue","English,Hindi or mother tongue");
				this.addQuestion2(q13);
				Question q14=new Question("The members of the Rajya Sabha are elected for a term ", 
				"of six years", "determined by the state legislative assembly","of four years" ,
				"None of the above","of six years");
				this.addQuestion2(q14);
				Question q15=new Question("The minimum age required to become a member of Rajya Sabha is ", 
				"21 years", "25 years","30 years" ,
				"35 years","30 years");
				this.addQuestion2(q15);
				Question q16=new Question("The preamble to our constitution includes all the following except ", 
				"Adult franchise", "Equality of status","Fraternity" ,
				"Justice","Adult franchise");
				this.addQuestion2(q16);
				Question q17=new Question("The preamble was proposed before the drafting committee by ", 
				"B.N Rao", "B.R Ambedkar","Jawaharlal Nehru" ,
				"Sardar Patel","Jawaharlal Nehru");
				this.addQuestion2(q17);
				Question q18=new Question("Abdul Kalam was elected president in which year ?", 
				"1986", "1992","1996" ,
				"2002","2002");
				this.addQuestion2(q18);
				Question q19=new Question("Where is the elction commission located ?", 
				"Chennai", "New Delhi","Mumbai" ,
				"Kolkata","New Delhi");
				this.addQuestion2(q19);
				Question q20=new Question("The head of the Indian Parliament System is the ", 
				"Prime Minister", "President","Speaker of Lok Sabha " ,
				"Speaker of Rajya Sabha","President");
				this.addQuestion2(q20);
				
				
							
				
	}
	private void addQuestioncinema(){

		Question q1=new Question("Which was the first 3D film of India?", 
				"Kagaz Ke Phool","Deewana", "Darr", "My Dear Kuttichathan", "My Dear Kuttichathan");
		this.addQuestion3(q1);
		Question q2=new Question("Who is called 'the father of Indian cinema' ?", "AK Hangal", "Dileep Kumar", "Dada Saheb Phalke",
				"Jatn Lalit", "Dada Saheb Phalke");
		this.addQuestion3(q2);
		Question q3=new Question("First Indian to win an Oscar..?", "Bhanu Athaiya", "AR Rahman",
				"Rasul Pookutty", "None Of The above", "Bhanu Athaiya");
		this.addQuestion3(q3);
		Question q4=new Question("First 3D animation film from India is", "Hanuman", "Roadside Romeo",
				"Bal Ganesh", "Ghayab Aaya", "Roadside Romeo");
		this.addQuestion3(q4);
		Question q5=new Question("Who was the actress in Arjun Kapur's first movie?",
				"Alia", "Parineeti", "Kratika", "Sasha Agha", "Parineeti");
		this.addQuestion3(q5);
		Question q6=new Question("Dabbawallahs of Mumbai are the backdrops of a movie made by?",
				"Imtiaz Ali", "Kiran Rao", "Sagar Bellary", "Ritesh Batra and Anurag Kashyap",
				"Ritesh Batra and Anurag Kashyap");
		this.addQuestion3(q6);
		Question q7= new Question("Which film involved a businessman and an income-tax officer stranded on an isolated island?", 
				"Bheja Fry 2", "Dhoom","Barfi", "Delhi Belly", "Bheja Fry 2");
		this.addQuestion3(q7);
		Question q8=new Question("Music director AR Rahman won the Oscar for which movie?",
				"Taal", "Rang De Basanti", "Highway", "Slumdog Millionaire", "Slumdog Millionaire");
		this.addQuestion3(q8);
		Question q9=new Question("Who played the role of  Ranbir Kapoor's father in the movie " +
				"'Yeh Jawani Hai Deewani'?", "Om Puri", "Farooq Sheikh", "Anupam Kher", "Alok Kumar", "Farooq Sheikh");
		this.addQuestion3(q9);
		Question q10=new Question("WWhere was the Bollywood movie 'Blue' shot primarily?", "Hawaii",
				"Miami", "Bahamas", "Jamaica", "Bahamas");
		this.addQuestion3(q10);
		Question q11=new Question("Shivaji Rao Gaikwad is the real name of which actor?","NTR", "Chiranjeevi",
				"Rajinikanth", "Nagarjuna", "Rajinikanth");
		this.addQuestion3(q11);
		Question q12=new Question("Which of these is not related to Hema Malini?", "Politics", "Dance",
				"Sports", "Bollywood", "Sports");
		this.addQuestion3(q12);
		Question q13=new Question("Which was the last movie directed by Yash Chopra?", "Rab Ne Bana Di Jodi	",
				"Jab Tak Hai Jaan", "Veer Zara	", "Ek Tha Tiger", "Jab Tak Hai Jaan");
		this.addQuestion3(q13);
		Question q14=new Question("'Itna sannata kyun hai bhai?', Who said these legendary words in 'Sholay'?",
				"AK Hangal", "Thala’ Ajith", "Arjun Sarja", "Ashutosh Gawariker", "AK Hangal");
		this.addQuestion3(q14);
		Question q15=new Question("Who became the first Indian Director to shoot at NASA?", "Ashutosh Gawariker(Film-Swadesh)",
				"AK Hangal", "‘Thala’ Ajith", "Arjun Sarja", "Ashutosh Gawariker(Film-Swadesh)");
		this.addQuestion3(q15);
		Question q16=new Question("Sonam Kapoor was assistant director in which movie?", "Black", "Devdas", "Sawariyan", "Bhool bhulaiyan", "Black");
		this.addQuestion3(q16);
		Question q17=new Question("In which movie did Deepika Padukone play the role of a blind girl?",
				"Kartik Calling Kartik", "Houseful2", "Lagangay Parinday", "Finding Fanny", "Lagangay Parinday");
		this.addQuestion3(q17);
		Question q18=new Question("Which Indian actor has appeared in over 151 films in nine languages?", 
				"Jackie Shroff", "Ashok Kumar", "Madhavan", "Shahid Kapoor", "Jackie Shroff");
		this.addQuestion3(q18);
		Question q19=new Question("What was Aamir Khan's character's name in Rang De Basanti?",
				"Daljeet", "Jaspreet", "Ranjeet", "Navjot", "Daljeet");
		this.addQuestion3(q19);
		Question q20=new Question("In which of these regional languages has actor Dino Moreo starred?", 
				"Oriya", "Kannada", "Kashmiri", "Bangla", "Kannada");
		this.addQuestion3(q20);
				
				
				
	}
	private void addQuestionsports(){
		Question q1=new Question("The only driver female in Grand Prix 2011 is",
				"Alice Powell", "Sarah Fisher", "Maria Terese","Divina Glacia" ,"Alice Powell");
				this.addQuestion1(q1);	
				Question q2=new Question("In which stadium did Sachin Tendulkar hit his 100th century?",
				"Eden Garden", "Shere Bangla Stadium", "Firoz Shah Kotla Ground","None of the above" ,"Shere Bangla Stadium");
				this.addQuestion1(q2);	
				Question q3=new Question("Total Olympic Medals won by India in 2012","5", "4", "6","8" ,"6");
				this.addQuestion1(q3);	
				Question q4=new Question("Who is the first Indian woman to win in an Asian Game?",
				"M L Valsamma", "Kamaljit Sandhu", "PT Usha","K Malleshwari" ,"Kamaljit Sandhu");
				this.addQuestion1(q4);	
				Question q5=new Question("Who was India's first Football captain?",
				"PK Banerjee", "Shailen Manna", "SC Goswami","Talimeren Ao" ,"Talimeren Ao");
				this.addQuestion1(q5);
				Question q6=new Question("Which one is the oldest football club in India?",
				"Mohun Bagan AC", "East Bengal FC", "Mohmmedan SC","Mahindra United" ,"Mohun Bagan AC");
				this.addQuestion1(q6);
				Question q7=new Question("Who is the first recepient of Rajiv Gandhi Khel Ratna Award?", 
				"Sunil Gavaskar", "Sachin Tendulkar","Milkha Singh" ,"Viswanathan Anand","Viswanathan Anand");
				this.addQuestion1(q7);	
				Question q8=new Question("Who is the youngest Grandmaster in India?", 
				"V Anand", "Parimarjan Negi","P Harikrishnan" ,"Koneru Humpy","Parimarjan Negi");
				this.addQuestion1(q8);
				Question q9=new Question("Who was the man of the series in 1983 Cricket World Cup ?", 
				"Kapil Dev", "Roger Binny","K Srikanth" ,"Mohinder Amarnath","Mohinder Amarnath");
				this.addQuestion1(q9);
				Question q10=new Question("First Sportsperson nominated for Rajya Sabha membership", 
				"Sachin Tendulkar", "Milkha Singh","Sunil Gavaskar" ,"Navajot S Sidhu","Sachin Tendulkar");
				this.addQuestion1(q10);
				Question q11=new Question("Which animal was represented as the mascot in Delhi Asian Games,1982?", 
				"A Tiger", "An Elephant","A Lion" ,"A Panda","An Elephant");
				this.addQuestion1(q11);
				Question q12=new Question("For which game is the ‘Indira Gandhi Gold Cup’ being awarded ?",
				"Women’s Hockey","Women’s Football","Women’s Cricket","Women’s Badminton","Women’s Hockey");
				this.addQuestion1(q12);
				Question q13=new Question("Lord Hanuman is symbolised with which sports ?", 
				"Boxing", "Wrestling","Archery" ,"Rugby","Wrestling");
				this.addQuestion1(q13);
				Question q14=new Question("Of which country is Bull-fighting the National game?", 
				"Spain", "Japan","Portugal" ,"Poland","Spain");
				this.addQuestion1(q14);
				Question q15=new Question("The National Sports Day is observed on which of the following days ?", 
				"August 29", "July 29","September 29" ,"August 20","August 29");
				this.addQuestion1(q15);
				Question q16=new Question("Which of the following Cups/Trophies is associated with the game of Football ?", 
				"Wimbledon Cup	", "Evert Cup","Agha Khan Cup" ,"Mardeka Cup","Mardeka Cup");
				this.addQuestion1(q16);
				Question q17=new Question("The term ‘Beamer’ is associated with", 
				"Football", "Hockey","Cricket" ,"Chess","Cricket");
				this.addQuestion1(q17);
				Question q18=new Question("Which of the following terms is not related with the game of Hockey ?", 
				"Follow on", "Tie breaker","Hat trick" ,"Half volley","Follow on");
				this.addQuestion1(q18);
				Question q19=new Question("The Standard distance of Marathon Race", 
				"26 kms", "42 kms","42.195 kms" ,"42.123 kms","42.195 kms");
				this.addQuestion1(q19);
				Question q20=new Question("The first Commonwealth games were held in ", 
				"1930 Hamilton", "1934 Australia "," 1935 India" ,"1940 Pakistan","1930 Hamilton");
				this.addQuestion1(q20);
				
				
				
				
	}
	private void addQuestionstech()
	{
		Question q1=new Question("Which company is the largest manufacturer" +
				" of network equipment?","HP", "IBM", "CISCO","MICROSOFT" ,"CISCO");
				this.addQuestion(q1);
				System.out.println(8);
				Question q2=new Question("Which of the following is NOT " +
				"an operating system?", "SuSe", "BIOS", "DOS","UNIX" ,"BIOS");
				this.addQuestion(q2);
				System.out.println(12);
				Question q3=new Question("Which of the following is the fastest" +
				" writable memory?","RAM", "Flash","Register","Hard Disk","Register");
				this.addQuestion(q3);
				System.out.println(13);
				Question q4=new Question("Which of the following device" +
				" regulates internet traffic?","Router", "Bridge", "Hub","Ring","Router");
				this.addQuestion(q4);
				System.out.println(15);
				Question q5=new Question("Which of the following is NOT an" +
				" interpreted language?","Ruby","Python","BASIC","C","BASIC");
				this.addQuestion(q5);
				System.out.println(9);
				Question q6=new Question("Which of the following is not a logical data-base structure?",
				"tree","relational","network","chain","chain");
			    this.addQuestion(q6);
			    System.out.println(10);
				Question q7=new Question("The time required for the fetching and execution of one simple machine instruction is",
				"Delay time","CPU cycle","Real time","Seek time","CPU cycle");
			    this.addQuestion(q7);
			    Question q8=new Question("Which access method is used for obtaining a record from a cassette tape?",
				"Direct","Sequential","Random","All of the above","Sequential");
				this.addQuestion(q8);
				Question q9=new Question("A single packet on a data link is known as ",
				"Path","Frame","Block","Group","Frame");
				this.addQuestion(q9);
				Question q10=new Question("The symbols used in an assembly language are",
			    "Codes","Mnemonics","Assembler","All of the above","Mnemonics");
				this.addQuestion(q10);
				Question q11=new Question("A number that is used to control the form of another number is known as",
				"Map","Mask","Mamtossa","Marker","Mask");
				this.addQuestion(q11);
				Question q12=new Question(".MOV extension refers to",
				"Word File","Text File","Image File","Movie File","Movie File");
				this.addQuestion(q12);
				Question q13=new Question("The complete picture of data stored in database is known as",
				"Record","Schema","System flowchart","DBMS","Schema");
				this.addQuestion(q13);
				Question q14=new Question("Compilers and interpreters are themselves",
				"High-level language","Codes","Programs","Mnemonics","Programs");
				this.addQuestion(q14);
				Question q15=new Question("A path by which communication is achieved between a central processor and other devices is called",
				"Audit trail","Network","Bus","Channel","Bus");
				this.addQuestion(q15);
				Question q16=new Question("Which of the following is not currently a topic in computer science?",
				"Speech recognition","Artificial intelligence","Thermodynamics","Multiprocessing","Thermodynamics");
				this.addQuestion(q16);
				Question q17=new Question("Human beings are referred to as Homosapiens. Which device is called Silico sapien?",
				"Monitor","Hardware","Robot","Computer","Computer");
				this.addQuestion(q17);
				Question q18=new Question("Which of the following is the user programmed semiconductor memory?",
				"SRAM","DRAM","EPROM","All of the above","EPROM");
				this.addQuestion(q18);
				Question q19=new Question("One byte can be used to encode any integer between 'O' and -inclusive",
				"16","256","128","255","255");
				this.addQuestion(q19);
				Question q20=new Question("Fifth generation computers are likely to exhibit",
				"Artificial intelligence","Heuristic behaviour","Advanced parallel processing","All of the above","All of the above");
				this.addQuestion(q20);
				
			    System.out.println(11);
						
				
	
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TECH);
		onCreate(db);
		
	}
	public void addQuestion4(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		values.put(KEY_OPTD, quest.getOPTD());
		dbase.insert(TABLE_APTI, null, values);
		}
	public void addQuestion3(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		values.put(KEY_OPTD, quest.getOPTD());
		dbase.insert(TABLE_CINEMA, null, values);
		}
	public void addQuestion1(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		values.put(KEY_OPTD, quest.getOPTD());
		dbase.insert(TABLE_SPORTS, null, values);
		}
	public void addQuestion(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		values.put(KEY_OPTD, quest.getOPTD());
		dbase.insert(TABLE_TECH, null, values);
		}
	public void addQuestion2(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		values.put(KEY_OPTD, quest.getOPTD());
		dbase.insert(TABLE_POLI, null, values);
		}
	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		String selectQuery = "SELECT  * FROM " + TABLE_TECH;
		//System.out.println();
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		System.out.println(cursor.getCount());
		// looping through all rows and adding to list
		List<Integer> randomNumber = new ArrayList<Integer>();
		Random random=new Random();
		for(int i=1;i<=10;i++){
			int r;
			do{
				r=random.nextInt(20);
			}while(randomNumber.contains(r));
				randomNumber.add(r);
		
		if (cursor.moveToPosition(r)) {
		Question quest = new Question();
		quest.setID(cursor.getInt(0));
		quest.setQUESTION(cursor.getString(1));
		quest.setANSWER(cursor.getString(2));
		quest.setOPTA(cursor.getString(3));
		quest.setOPTB(cursor.getString(4));
		quest.setOPTC(cursor.getString(5));
		quest.setOPTD(cursor.getString(6));
		quesList.add(quest);
		System.out.println(r);
		}}
		//System.out.println(1);
		
		return quesList;
		
	}


public List<Question> getAllQuestions1() {
	List<Question> quesList = new ArrayList<Question>();
	String selectQuery = "SELECT  * FROM " + TABLE_SPORTS;
	//System.out.println();
	dbase=this.getReadableDatabase();
	Cursor cursor = dbase.rawQuery(selectQuery, null);
	System.out.println(cursor.getCount());
	// looping through all rows and adding to list
	List<Integer> randomNumber = new ArrayList<Integer>();
	Random random=new Random();
	for(int i=1;i<=10;i++){
		int r;
		do{
			r=random.nextInt(20);
		}while(randomNumber.contains(r));
			randomNumber.add(r);
	
	if (cursor.moveToPosition(r)) {
	Question quest = new Question();
	quest.setID(cursor.getInt(0));
	quest.setQUESTION(cursor.getString(1));
	quest.setANSWER(cursor.getString(2));
	quest.setOPTA(cursor.getString(3));
	quest.setOPTB(cursor.getString(4));
	quest.setOPTC(cursor.getString(5));
	quest.setOPTD(cursor.getString(6));
	quesList.add(quest);
	System.out.println(r);
	}}
	//System.out.println(1);
	
	return quesList;
	
}


public List<Question> getAllQuestions2() {
	List<Question> quesList = new ArrayList<Question>();
	String selectQuery = "SELECT  * FROM " + TABLE_POLI;
	//System.out.println();
	dbase=this.getReadableDatabase();
	Cursor cursor = dbase.rawQuery(selectQuery, null);
	System.out.println(cursor.getCount());
	// looping through all rows and adding to list
	List<Integer> randomNumber = new ArrayList<Integer>();
	Random random=new Random();
	for(int i=1;i<=10;i++){
		int r;
		do{
			r=random.nextInt(20);
		}while(randomNumber.contains(r));
			randomNumber.add(r);
	
	if (cursor.moveToPosition(r)) {
	Question quest = new Question();
	quest.setID(cursor.getInt(0));
	quest.setQUESTION(cursor.getString(1));
	quest.setANSWER(cursor.getString(2));
	quest.setOPTA(cursor.getString(3));
	quest.setOPTB(cursor.getString(4));
	quest.setOPTC(cursor.getString(5));
	quest.setOPTD(cursor.getString(6));
	quesList.add(quest);
	System.out.println(r);
	}}
	//System.out.println(1);
	
	return quesList;
	
}


public List<Question> getAllQuestions3() {
	List<Question> quesList = new ArrayList<Question>();
	String selectQuery = "SELECT  * FROM " + TABLE_CINEMA;
	//System.out.println();
	dbase=this.getReadableDatabase();
	Cursor cursor = dbase.rawQuery(selectQuery, null);
	System.out.println(cursor.getCount());
	// looping through all rows and adding to list
	List<Integer> randomNumber = new ArrayList<Integer>();
	Random random=new Random();
	for(int i=1;i<=10;i++){
		int r;
		do{
			r=random.nextInt(20);
		}while(randomNumber.contains(r));
			randomNumber.add(r);
	
	if (cursor.moveToPosition(r)) {
	Question quest = new Question();
	quest.setID(cursor.getInt(0));
	quest.setQUESTION(cursor.getString(1));
	quest.setANSWER(cursor.getString(2));
	quest.setOPTA(cursor.getString(3));
	quest.setOPTB(cursor.getString(4));
	quest.setOPTC(cursor.getString(5));
	quest.setOPTD(cursor.getString(6));
	quesList.add(quest);
	System.out.println(r);
	}}
	//System.out.println(1);
	
	return quesList;
	
}


public List<Question> getAllQuestions4() {
	List<Question> quesList = new ArrayList<Question>();
	String selectQuery = "SELECT  * FROM " + TABLE_APTI;
	//System.out.println();
	dbase=this.getReadableDatabase();
	Cursor cursor = dbase.rawQuery(selectQuery, null);
	System.out.println(cursor.getCount());
	// looping through all rows and adding to list
	List<Integer> randomNumber = new ArrayList<Integer>();
	Random random=new Random();
	for(int i=1;i<=10;i++){
		int r;
		do{
			r=random.nextInt(20);
		}while(randomNumber.contains(r));
			randomNumber.add(r);
	
	if (cursor.moveToPosition(r)) {
	Question quest = new Question();
	quest.setID(cursor.getInt(0));
	quest.setQUESTION(cursor.getString(1));
	quest.setANSWER(cursor.getString(2));
	quest.setOPTA(cursor.getString(3));
	quest.setOPTB(cursor.getString(4));
	quest.setOPTC(cursor.getString(5));
	quest.setOPTD(cursor.getString(6));
	quesList.add(quest);
	System.out.println(r);
	}}
	//System.out.println(1);
	
	return quesList;
	
}

}

