package core.skills;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class SkillPlayer {

	@Id
	private int id;

	@Column
	private String accountName;
	
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

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getMineriaLvl() {
		return mineriaLvl;
	}

	public void setMineriaLvl(int mineriaLvl) {
		this.mineriaLvl = mineriaLvl;
	}

	public int getMineriaExp() {
		return mineriaExp;
	}

	public void setMineriaExp(int mineriaExp) {
		this.mineriaExp = mineriaExp;
	}

	public int getTalaLvl() {
		return talaLvl;
	}

	public void setTalaLvl(int talaLvl) {
		this.talaLvl = talaLvl;
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


}