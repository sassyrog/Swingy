package com.swingy.controls;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.swingy.models.Hero;
import com.swingy.models.Heros.*;
import com.swingy.controls.MysqlConnect;

/**
 * HeroFactory
 */
public class HeroFactory {
	MysqlConnect conn = MysqlConnect.getDbCon();

	public Hero newHero(String hString, String name) throws SQLException {
		if (hString.equalsIgnoreCase("underdog"))
			return new Underdog(name);
		else if (hString.equalsIgnoreCase("guardian"))
			return new Guardian(name);
		else if (hString.equalsIgnoreCase("descendant"))
			return new Descendant(name);
		return null;
	}

	public Hero newHero(int id) throws SQLException {
		ResultSet rSet = conn.query("SELECT Class FROM Players WHERE ID =" + id);
		rSet.next();
		String hString = rSet.getString("Class");
		if (hString.equalsIgnoreCase("underdog"))
			return new Underdog(id);
		else if (hString.equalsIgnoreCase("guardian"))
			return new Guardian(id);
		else if (hString.equalsIgnoreCase("descendant"))
			return new Descendant(id);
		return null;
	}
}
