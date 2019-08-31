package com.swingy.controls;

import java.sql.*;
import java.sql.DriverManager;

/**
 * Hello world!
 *
 */

public final class MysqlConnect {
	public Connection conn;
	private Statement statement;
	public static MysqlConnect db;

	private MysqlConnect() {
		String url = "";

		if (System.getenv("USER").equals("rmdaba")) {
			url = "jdbc:mysql://192.168.99.100:3306/Swingy";
		} else {
			url = "jdbc:mysql://localhost:3306/Swingy";
		}

		// String dbName = "database_name";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "Rootroot3";
		try {
			Class.forName(driver).newInstance();
			this.conn = (Connection) DriverManager.getConnection(url, userName, password);
			System.out.println("Connection created!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 *
	 * @return MysqlConnect Database connection object
	 */
	public static synchronized MysqlConnect getDbCon() {
		if (db == null) {
			db = new MysqlConnect();
		}
		return db;
	}

	/*
	 * @param query String The query to be executed
	 *
	 * @return a ResultSet object containing the results or null if not available
	 *
	 * @throws SQLException
	 */
	public ResultSet query(String query) throws SQLException {
		statement = db.conn.createStatement();
		ResultSet res = statement.executeQuery(query);
		return res;
	}

	/*
	 * @desc Method to insert data to a table
	 *
	 * @param insertQuery String The Insert query
	 *
	 * @return boolean
	 *
	 * @throws SQLException
	 */
	public int insert(String insertQuery) throws SQLException {
		statement = db.conn.createStatement();
		int result = statement.executeUpdate(insertQuery);
		return result;
	}

	public void printHeros(ResultSet rSet) throws SQLException {
		System.out.printf("+-----+---------------+---------------+-----+-----+\n");
		System.out.printf("| ID  |   HERO NAME   |  HERO CLASS   | XP  |LEVEL|\n");
		while (rSet.next() == true) {
			String sp = "               ";
			int id = rSet.getInt("Id");
			String heroName = rSet.getString("Name");
			String heroClass = rSet.getString("Class");
			int level = rSet.getInt("Level");
			int experience = rSet.getInt("Experience");
			System.out.printf("+-----+---------------+---------------+-----+-----+\n");
			int widthn = 14 - heroName.length();
			int widthc = 14 - heroClass.length();
			String tmp, tmp2;
			tmp = (widthn < 0) ? sp.substring(0, 0) : sp.substring(0, widthn);
			tmp2 = (widthc < 0) ? sp.substring(0, 0) : sp.substring(0, widthc);
			System.out.printf("|%-5d|%.14s%s*|", id, heroName, tmp);
			System.out.printf("%.14s%s*|", heroClass, tmp2);
			System.out.printf("%-5d|%-5d|\n", experience, level);
		}
		System.out.printf("+-----+---------------+---------------+-----+-----+\n\n");
	}
}
