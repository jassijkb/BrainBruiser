package com.example.brainbruiser;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoginDataBaseAdapter {
	static final String DATABASE_NAME = "login.db";
	static final int DATABASE_VERSION = 1;
	public static final int NAME_COLUMN = 1;
	private static final String ID = "id";
	private static final String USERNAME = "userName";
	private static final String PASSWORD = "password"; 
	private static final String SCORE= "score"; 
	// TODO: Create public field for each column in your table.
	// SQL Statement to create a new database.
	static final String DATABASE_CREATE = "create table "+"LOGIN"+
	 "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text,PASSWORD text,SCORE integer); ";
	// Variable to hold the database instance
	public  SQLiteDatabase db;
	// Context of the application using the database.
	private final Context context;
	// Database open/upgrade helper
	private DataBaseHelper dbHelper;
	public  LoginDataBaseAdapter(Context _context) 
	{
		context = _context;
		dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	public  LoginDataBaseAdapter open() throws SQLException 
	{
		db = dbHelper.getWritableDatabase();
		return this;
	}
	public void close() 
	{
		db.close();
	}

	public  SQLiteDatabase getDatabaseInstance()
	{
		return db;
	}

	public void insertEntry(String userName,String password,int score)
	{
       ContentValues newValues = new ContentValues();
		newValues.put("USERNAME", userName);
		newValues.put("PASSWORD",password);
		newValues.put("SCORE",score);
		db.insert("LOGIN", null, newValues);
		
	}
	
	public String getSinlgeEntry(String userName)
	{
		Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Does Not Exist
        {
        	cursor.close();
        	return "NOT EXIST";
        }
	    cursor.moveToFirst();
		String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
		cursor.close();
		return password;				
	}
	/*public int  updateEntry(String userName,int score)
	{
		System.out.println(555);
		Cursor cursor=db.rawQuery("select * from LOGIN where USERNAME=userName ",null);
		//Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
		System.out.println(666);
		int oldscore=cursor.getInt(cursor.getColumnIndex("SCORE"));
		System.out.println(oldscore);
		// Define the updated row content.
		ContentValues updatedValues = new ContentValues();
	
		// Assign values for each row.
		updatedValues.put("SCORE",score);
		//updatedValues.put("PASSWORD",password);

        String where="USERNAME = ?";
	    db.update("LOGIN",updatedValues, where, new String[]{userName});
	    System.out.println(score);
	    return oldscore;
	}*/	
	
}


