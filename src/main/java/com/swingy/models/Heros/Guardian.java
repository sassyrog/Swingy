package com.swingy.models.Heros;

import java.sql.SQLException;
import com.swingy.models.Hero;

/**
 * Guardian
 */

public class Guardian extends Hero {

	public Guardian(String name) throws SQLException {
		super(name, "Guardian");
	}

	public Guardian(int id) throws SQLException {
		super(id);
	}
}
