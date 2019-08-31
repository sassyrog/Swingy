package com.swingy.models.Heros;

import java.sql.SQLException;
import com.swingy.models.Hero;
import com.swingy.controls.MysqlConnect;

/**
 * Underdog
 */

public class Underdog extends Hero {
	MysqlConnect conn = MysqlConnect.getDbCon();

	public Underdog(String name) throws SQLException {
		super(name, "Underdog");
		String stmt = "INSERT INTO Players(ID, Name, Class, Level, Attack, Defense, HitPoints, Experience) VALUES (";

		stmt += "'" + this.getId() + "', ";
		stmt += "'" + name + "', ";
		stmt += "'Underdog', ";
		stmt += "1, ";
		stmt += this.getAttack() + ", ";
		stmt += this.getDefense() + ", ";
		stmt += this.getHitPoints() + ", ";
		stmt += this.getExperience() + ")";
		conn.insert(stmt);
	}

	public Underdog(int id) throws SQLException {
		super(id);
	}
}
