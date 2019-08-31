package com.swingy.models.Heros;

import java.sql.SQLException;
import com.swingy.models.Hero;

/**
 * Underdog
 */

public class Underdog extends Hero {

	public Underdog(String name) throws SQLException {
		super(name, "Underdog");
	}

	public Underdog(int id) throws SQLException {
		super(id);
	}
}
