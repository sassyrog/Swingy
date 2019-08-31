package com.swingy.models.Heros;

import java.sql.SQLException;
import com.swingy.models.Hero;

/**
 * Descendant
 */

public class Descendant extends Hero {

	public Descendant(String name) throws SQLException {
		super(name, "Descendant");
	}

	public Descendant(int id) throws SQLException {
		super(id);
	}

}
