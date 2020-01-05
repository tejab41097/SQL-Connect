package com.example.sqdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQL {
	String d_name = "d_name";
	String t_name = "t_name";
	int version = 1;
	
	String s_no = "s_no";
	String name = "name";
	String age = "age";
	
	SQLiteDatabase s;
	Context c;
	rec r;

	public class rec extends SQLiteOpenHelper {
		public rec(Context context) {
			super(context, d_name, null, version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String abc = " CREATE TABLE " + t_name + "(" + s_no
					+ "INTEGER PRIMARY KEY AUTOINCREMENT," + name
					+ "TEXT NOT NULL," + age + "TEXT NOT NULL);";
			db.execSQL(abc);
		}

		@Override
		public void onUpgrade(SQLiteDatabase sb, int arg1, int arg2) {
			// TODO Auto-generated method stub

		}
	}

	public SQL(MainActivity mainActivity) {
		// TODO Auto-generated constructor stub
	}

	public void open() throws SQLException{
		// TODO Auto-generated method stub
		r = new rec(c);
		s = r.getWritableDatabase();
	}

	public void savemyd(String str1, String str2) {
		// TODO Auto-generated method stub
		ContentValues val = new ContentValues();
		val.put(name, str1);
		val.put(age, str2);
		s.insert(t_name, null, val);
	}

	public void close() throws SQLException {
		// TODO Auto-generated method stub
		s.close();
	}

	public void delmyd(String string) {
		s.delete(t_name, s_no + "=" + string, null);

	}

	public String view() {
		// TODO Auto-generated method stub
		String st = " ";
		String[] az = { s_no, name, age };
		Cursor cu = s.query(t_name, az, null, null, null, null, null);
		cu.moveToFirst();
		int snum = cu.getColumnIndex(s_no);
		int na = cu.getColumnIndex(name);
		int ag = cu.getColumnIndex(age);
		for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {
			st = st + cu.getString(snum) + " " + cu.getString(na) + " "
					+ cu.getString(ag) + "\n";
		}
		return st;
	}

	public void updatemyd(String x, String y, String z) {
		// TODO Auto-generated method stub
		ContentValues val1 = new ContentValues();
		val1.put(name,y);
		val1.put(age,z);
		s.update(t_name, val1, s_no + "=" + x, null);
	}

}
