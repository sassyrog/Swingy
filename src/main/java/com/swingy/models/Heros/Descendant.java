package com.swingy.models.Heros;

import java.sql.SQLException;
import com.swingy.models.Hero;
import com.swingy.controls.MysqlConnect;

/**
 * Descendant
 */

public class Descendant extends Hero {
	MysqlConnect conn = MysqlConnect.getDbCon();

	public Descendant(String name) throws SQLException {
		super(name, "Descendant");
		String stmt = "INSERT INTO Players(ID, Name, Class, Level, Attack, Defense, HitPoints, Experience) VALUES (";

		stmt += "'" + this.getId() + "', ";
		stmt += "'" + name + "', ";
		stmt += "'Descendant', ";
		stmt += "1, ";
		stmt += this.getAttack() + ", ";
		stmt += this.getDefense() + ", ";
		stmt += this.getHitPoints() + ", ";
		stmt += this.getExperience() + ")";
		conn.insert(stmt);
	}

	public Descendant(int id) throws SQLException {
		super(id);
	}

}
