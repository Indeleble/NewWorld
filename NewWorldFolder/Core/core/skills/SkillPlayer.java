package core.skills;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.Table;
import javax.persistence.Transient;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

@Entity
@Table(name = "SkillPlayers")
public class SkillPlayer {

	private static final int MAX_TOTAL_LEVEL = 150;
	private static final int MAX_INDIVIDUAL_SKILL_LEVEL = 100;

	private int id;
	private String accountName;
	private int totalLevel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "SKILL_PLAYER_SKILL", joinColumns = @JoinColumn(name = "SKILL_PLAYER_ID"))
	@MapKey(name = "SKILL_TYPE")
	private Map<SkillType, Skill> skills = new HashMap<SkillType, Skill>();

	public SkillPlayer() {

	}

	@Id
	@Column(name="ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="ACCOUNT_NAME", nullable=false)
	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String name) {
		this.accountName = name;
	}

	@Transient
	private int getExperienceNeeded(int totalLevel) {
		return (int) Math.round(10 + (totalLevel + 1 + Math.log(totalLevel + 1) * Math.log(150) * 700));
	}

	public void addTotalLevel(int totalLevel) {
		this.totalLevel += totalLevel;
	}

	@Column(name="TOTAL_LEVEL", nullable=false)
	public int getTotalLevel() {
		return this.totalLevel;
	}

	public void setTotalLevel(int totalLevel) {
		this.totalLevel = totalLevel;
	}

	public void addExperience(SkillType type, int newExperience) {
		Skill skill = getSkill(type);

		if (moreLevelsAvailable(getTotalLevel(), skill.getLevel())) {

			int experienceNeed = getExperienceNeeded(getTotalLevel());

			int currentExperience = skill.getExperience() + newExperience;

			if (currentExperience >= experienceNeed) {
				int newLevelExperience = currentExperience - experienceNeed;
				skill.setExperience(newLevelExperience);
				skill.addLevel(1);
				addTotalLevel(1);
			} else {
				skill.addExperience(newExperience);
			}
		}
	}

	@Transient
	public int getExperience(SkillType type) {
		return getSkill(type).getLevel();
	}

	@Transient
	public int getLevel(SkillType type) {
		return getSkill(type).getLevel();
	}

	public void setLevel(SkillType type, int level) {
		getSkill(type).setLevel(level);
	}

	@Transient
	private Skill getSkill(SkillType type) {
		if (!skills.containsKey(type)) {
			skills.put(type, new Skill());
			PermissionUser user = PermissionsEx.getUser(accountName);
			user.addGroup(type.toString());
		}
		return skills.get(type);
	}

	private boolean moreLevelsAvailable(int totalLevel, int skillLevel) {
		return (skillLevel < MAX_INDIVIDUAL_SKILL_LEVEL) && (totalLevel < MAX_TOTAL_LEVEL);
	}
}