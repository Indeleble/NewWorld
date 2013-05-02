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
	private int ganaderiaLvl;

	@Nonnull
	private int ganaderiaExp;

	@Nonnull
	private int botanicaLvl;
	
	@Nonnull
	private int botanicaExp;
	
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

	public int getMineriaExp() {
		return mineriaExp;
	}
	
	public void setMineriaLvl(int mineriaLvl) {
		this.mineriaLvl = mineriaLvl;
	}
	
	public void setMineriaExp(int mineriaExp) {
		this.mineriaExp = mineriaExp;
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
	
	public int getTalaExp() {
		return talaExp;
	}
	
	public void setTalaLvl(int talaLvl) {
		this.talaLvl = talaLvl;
	}
	
	public void setTalaExp(int talaExp) {
		this.talaExp = talaExp;
	}
	

	/*
	 * Agricultura
	 */

	public void addAgriculturaExp(int exp) {

		if (this.agriculturaLvl < 100 && this.totalLvl<150) {

			if (this.checkTotalLevel(this.agriculturaExp, exp) == exp) {
				this.agriculturaExp += exp;
			} else {
				this.agriculturaExp = this.checkTotalLevel(this.agriculturaExp, exp);
				this.agriculturaLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getAgriculturaLvl() {
		return this.agriculturaLvl;
	}
	
	public int getAgriculturaExp() {
		return agriculturaExp;
	}
	
	public void setAgriculturaLvl(int agriculturaLvl) {
		this.agriculturaLvl = agriculturaLvl;
	}
	
	public void setAgriculturaExp(int agriculturaExp) {
		this.agriculturaExp = agriculturaExp;
	}


	/*
	 * Ganaderia
	 */

	public void addGanaderiaExp(int exp) {

		if (this.ganaderiaLvl < 100 && this.totalLvl<150) {

			if (this.checkTotalLevel(this.ganaderiaExp, exp) == exp) {
				this.ganaderiaExp += exp;
			} else {
				this.ganaderiaExp = this.checkTotalLevel(this.ganaderiaExp, exp);
				this.ganaderiaLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getGanaderiaLvl() {
		return this.ganaderiaLvl;
	}
	
	public int getGanaderiaExp() {
		return ganaderiaExp;
	}
	
	public void setGanaderiaLvl(int ganaderiaLvl) {
		this.ganaderiaLvl = ganaderiaLvl;
	}
	
	public void setGanaderiaExp(int ganaderiaExp) {
		this.ganaderiaExp = ganaderiaExp;
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


}