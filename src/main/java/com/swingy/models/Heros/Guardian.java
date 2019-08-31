package com.swingy.models.Heros;

import java.sql.SQLException;
import com.swingy.models.Hero;
import com.swingy.controls.MysqlConnect;

/**
 * Guardian
 */

public class Guardian extends Hero {
	MysqlConnect conn = MysqlConnect.getDbCon();

	public Guardian(String name) throws SQLException {
		super(name, "Guardian");
		String stmt = "INSERT INTO Players(ID, Name, Class, Level, Attack, Defense, HitPoints, Experience) VALUES (";

		stmt += "'" + this.getId() + "', ";
		stmt += "'" + name + "', ";
		stmt += "'Guardian', ";
		stmt += "1, ";
		stmt += this.getAttack() + ", ";
		stmt += this.getDefense() + ", ";
		stmt += this.getHitPoints() + ", ";
		stmt += this.getExperience() + ")";
		conn.insert(stmt);
	}

	public Guardian(int id) throws SQLException {
		super(id);
	}
}
