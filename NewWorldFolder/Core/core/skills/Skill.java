package core.skills;

public class Skill {
	
	int level;
	
	String skillName;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Skill() {
		
		this.level = 0;
		this.skillName = "Habilidad de prueba";
	}

}
