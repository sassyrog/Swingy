package com.swingy.models;

/**
 * Player
 */
public class Player {
	private String	heroName;
	private String	heroClass;
	private int		level;
	private int		experience;
	private int		attack;
	private int		defense;
	private int		hitPoints;


	Player () {

	}

	public String getHeroName() {
		return this.heroName;
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
	}
	public void setHeroClass(String heroClass) {
		this.heroClass = heroClass;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
}
