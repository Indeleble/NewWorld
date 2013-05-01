package core.skills;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SkillPlayers")
public class SkillPlayer {

	@Id
	private int id;

	@Column
	private String accountName;

	@Column
	private int totalExp;
	
	@Column
	private int totalLvl;

	@Column
	private int mineriaLvl;

	@Column
	private int mineriaExp;

	@Column
	private int talaLvl;

	@Column
	private int talaExp;

	@Column
	private int agriculturaLvl;

	@Column
	private int agriculturaExp;

	@Column
	private int pescaLvl;

	@Column
	private int pescaExp;

	private int checkTotalLevel(int skillActualLevel, int skillExpGained) {

		int expNeed = (int) (this.totalExp + Math
				.round(Math.log(this.totalExp) * 21));

		if ((skillActualLevel + skillExpGained) >= expNeed) {

			return (skillActualLevel + skillExpGained) - expNeed;
		} else {

			return skillExpGained;
		}

	}
	
	public int getTotalLevel(){
		return this.totalLvl;
	}

	/*
	 * Mineria
	 */

	public void addMineriaExp(int exp) {

		if (this.mineriaLvl < 100) {

			if (this.checkTotalLevel(this.mineriaExp, exp) == exp) {
				this.mineriaExp += exp;
			} else {
				this.mineriaExp = this.checkTotalLevel(this.mineriaExp, exp);
				this.mineriaLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getMineriaLvl() {
		return this.mineriaLvl;
	}

	/*
	 * Tala
	 */

	public void addTalaExp(int exp) {

		if (this.talaLvl < 100) {

			if (this.checkTotalLevel(this.talaExp, exp) == exp) {
				this.talaExp += exp;
			} else {
				this.talaExp = this.checkTotalLevel(this.talaExp, exp);
				this.talaLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getTalaLvl() {
		return this.mineriaLvl;
	}

}