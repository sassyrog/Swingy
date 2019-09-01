package com.swingy.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.swingy.controls.HeroFactory;
import com.swingy.controls.MysqlConnect;
import com.swingy.models.Hero;
import com.swingy.views.Colors;
import com.swingy.views.TypeWriter;

/**
 * Swingy
 */
public class SwingyConsole {
	static MysqlConnect conn = MysqlConnect.getDbCon();

	SwingyConsole() {
		Scanner scn = new Scanner(System.in);
		HeroFactory hf = new HeroFactory();
		// Hero hero = null;

		try {
			ResultSet rSet = conn.query("SELECT 1 FROM Players LIMIT 1;");
			if (rSet.next() != false) {
				new TypeWriter(Colors._CYAN + "\nWelcome back!!!\n\n" + Colors._RESET);
			} else {
				new TypeWriter(Colors._CYAN
						+ "\nWelcome to the hero war game.\nStarting mode can be chosen\nbetween Console (Default) and GUI. You can choose to\ncreate a new hero or choose from previously created heros.\nIf there are no previously created\nheros, you'll be required to create a new hero.\n\n"
						+ Colors._RESET);
				conn.insert(
						"INSERT INTO Players(ID, Name, Level, Attack, Defense, HitPoints, Experience) VALUES (1, 'Default', 1, 1, 1, 1, 1000)");
			}

			System.out.print(Colors._WHITE + "Would you like to create a new hero? (Y|N) : " + Colors._RESET);
			String inputString = scn.nextLine().trim();

			if (inputString.equals("n") || inputString.equals("N")) {
				rSet = conn.query("SELECT * FROM Players ORDER BY Experience ASC LIMIT 10");
				new TypeWriter(Colors._CYAN
						+ "\nHere are the Top 10 heros, based on experience points,\nthat have been previously created. Please select a hero\nusing their Hero ID e.g 123.\n\n"
						+ Colors._RESET, 20);
				conn.printHeros(rSet);
				System.out.print(Colors._WHITE + "\nPlease enter hero by ID : " + Colors._RESET);
				// hero = hf.newHero(scn.nextInt());
			} else if (inputString.equals("y") || inputString.equals("Y")) {
				System.out.println("----yes----");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scn.close();
	}
}
