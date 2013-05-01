package core.skills;

import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SkillPlayers")
public class SkillPlayer {
	
	@Id
	private int id;

	@Nonnull
	private String accountName;
	
	@Nonnull
	private int totalLvl;

	@Nonnull
	private int mineriaLvl;

	@Nonnull
	private int mineriaExp;

	@Nonnull
	private int talaLvl;

	@Nonnull
	private int talaExp;

	@Nonnull
	private int agriculturaLvl;

	@Nonnull
	private int agriculturaExp;

	@Nonnull
	private int pescaLvl;

	@Nonnull
	private int pescaExp;
	
	public SkillPlayer(){
		
	}

	private int checkTotalLevel(int skillActualExpLevel, int skillExpGained) {

		int expNeed = (int) (10 + (this.totalLvl+1 + Math.log(this.totalLvl+1) * Math.log(150) *700));

		if ((skillActualExpLevel + skillExpGained) >= expNeed) {

			return (skillActualExpLevel + skillExpGained) - expNeed;
		} else {

			return skillExpGained;
		}

	}
	public void addTotalLevel(int lvl){
		this.totalLvl+=lvl;
	}
	public String getAccountName(){
		return this.accountName;
	}
	
	public void setAccountName(String name){
		this.accountName = name;
	}
	
	public int getTotalLevel(){
		return this.totalLvl;
	}

	/*
	 * Mineria
	 */

	public void addMineriaExp(int exp) {

		if (this.mineriaLvl < 100 && this.totalLvl<150) {

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

		if (this.talaLvl < 100 && this.totalLvl<150) {

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
		return this.talaLvl;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalLvl() {
		return totalLvl;
	}
	public void setTotalLvl(int totalLvl) {
		this.totalLvl = totalLvl;
	}
	public int getMineriaExp() {
		return mineriaExp;
	}
	public void setMineriaExp(int mineriaExp) {
		this.mineriaExp = mineriaExp;
	}
	public int getTalaExp() {
		return talaExp;
	}
	public void setTalaExp(int talaExp) {
		this.talaExp = talaExp;
	}
	public int getAgriculturaLvl() {
		return agriculturaLvl;
	}
	public void setAgriculturaLvl(int agriculturaLvl) {
		this.agriculturaLvl = agriculturaLvl;
	}
	public int getAgriculturaExp() {
		return agriculturaExp;
	}
	public void setAgriculturaExp(int agriculturaExp) {
		this.agriculturaExp = agriculturaExp;
	}
	public int getPescaLvl() {
		return pescaLvl;
	}
	public void setPescaLvl(int pescaLvl) {
		this.pescaLvl = pescaLvl;
	}
	public int getPescaExp() {
		return pescaExp;
	}
	public void setPescaExp(int pescaExp) {
		this.pescaExp = pescaExp;
	}
	public void setMineriaLvl(int mineriaLvl) {
		this.mineriaLvl = mineriaLvl;
	}
	public void setTalaLvl(int talaLvl) {
		this.talaLvl = talaLvl;
	}

}