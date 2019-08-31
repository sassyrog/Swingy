package com.swingy.models;

import com.swingy.controls.MysqlConnect;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Hero
 */
public class Hero {
	private int id;
	private String heroName;
	private String heroClass;
	private int level;
	private int experience;
	private int attack;
	private int defense;
	private int hitPoints;
	protected Position position;

	private static int idCounter = 0;
	static MysqlConnect conn = MysqlConnect.getDbCon();

	public Hero(String name, String heroClass) throws SQLException {
		ResultSet rSet = conn.query("SELECT MAX(ID) AS 'MaxID' FROM Players");
		if (rSet.next() == true)
			idCounter = rSet.getInt("MaxID");
		this.id = nextId();
		this.level = 1;
		this.experience = 1 * 1000 + (0) ^ 2 * 450;
		// this.attack = ;
		// this.defense = ;
		// this.hitPoints = ;
		this.position = new Position(this.level);

	}

	public Hero(int _id) {
		this.id = _id;
		try {
			conn.query("SELECT * FROM Players WHERE ID = " + _id);
			ResultSet rSet = conn.query("SELECT * FROM Players");
			if (rSet.next() != false) {
				this.heroName = rSet.getString("Name");
				this.heroClass = rSet.getString("Class");
				this.level = rSet.getInt("Level");
				this.experience = rSet.getInt("Experience");
				this.attack = rSet.getInt("Attack");
				this.defense = rSet.getInt("Defense");
				this.hitPoints = rSet.getInt("HitPoints");
			} else {
				throw new SQLException("Lol");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getHeroName() {
		return this.heroName;
	}

	public int getId() {
		return this.id;
	}

	public String getHeroClass() {
		return this.heroClass;
	}

	public int getLevel() {
		return this.level;
	}

	public int getExperience() {
		return this.experience;
	}

	public int getAttack() {
		return this.attack;
	}

	public int getDefense() {
		return this.defense;
	}

	public int getHitPoints() {
		return this.hitPoints;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
		try {
			conn.insert("UPDATE Players SET Name = '" + heroName + "' WHERE ID = " + this.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setHeroClass(String heroClass) {
		this.heroClass = heroClass;
		try {
			conn.insert("UPDATE Players SET Class = '" + heroClass + "' WHERE ID = " + this.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setLevel(int level) {
		this.level = level;
		try {
			conn.insert("UPDATE Players SET Level = " + level + " WHERE ID = " + this.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setExperience(int _level) {
		this.experience = _level * 1000 + (_level - 1) ^ 2 * 450;
		try {
			conn.insert("UPDATE Players SET Experience = " + this.experience + " WHERE ID = " + this.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setAttack(int attack) {
		this.attack = attack;
		try {
			conn.insert("UPDATE Players SET Attack = " + attack + " WHERE ID = " + this.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setDefense(int defense) {
		this.defense = defense;
		try {
			conn.insert("UPDATE Players SET Defense = " + defense + " WHERE ID = " + this.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
		try {
			conn.insert("UPDATE Players SET HitPoints = " + hitPoints + " WHERE ID = " + this.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int nextId() {
		return ++idCounter;
	}
}
