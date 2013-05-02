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
	
	@Nonnull
	private int construccionLvl;

	@Nonnull
	private int construccionExp;
	
	@Nonnull
	private int herreriaLvl;

	@Nonnull
	private int herreriaExp;
	
	@Nonnull
	private int artesaniaLvl;

	@Nonnull
	private int artesaniaExp;
	
	@Nonnull
	private int carpinteriaLvl;

	@Nonnull
	private int carpinteriaExp;
	
	@Nonnull
	private int cocinaLvl;

	@Nonnull
	private int cocinaExp;
	
	@Nonnull
	private int apotecarioLvl;

	@Nonnull
	private int apotecarioExp;
	
	@Nonnull
	private int joyeriaLvl;

	@Nonnull
	private int joyeriaExp;
	
	@Nonnull
	private int mamposteriaLvl;

	@Nonnull
	private int mamposteriaExp;
	
	@Nonnull
	private int domaLvl;

	@Nonnull
	private int domaExp;
	
	@Nonnull
	private int pinturaLvl;

	@Nonnull
	private int pinturaExp;
	
	@Nonnull
	private int arcoLvl;

	@Nonnull
	private int arcoExp;
	
	@Nonnull
	private int escudosLvl;

	@Nonnull
	private int escudosExp;
	
	@Nonnull
	private int armadurasLvl;

	@Nonnull
	private int armadurasExp;
	
	@Nonnull
	private int lanzasLvl;

	@Nonnull
	private int lanzasExp;
	
	@Nonnull
	private int espadasLvl;

	@Nonnull
	private int espadasExp;
	
	@Nonnull
	private int hachasLvl;

	@Nonnull
	private int hachasExp;
	
	@Nonnull
	private int mazasLvl;

	@Nonnull
	private int mazasExp;
	
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


	/*
	 * Botanica
	 */

	public void addBotanicaExp(int exp) {

		if (this.botanicaLvl < 100 && this.totalLvl<150) {

			if (this.checkTotalLevel(this.botanicaExp, exp) == exp) {
				this.botanicaExp += exp;
			} else {
				this.botanicaExp = this.checkTotalLevel(this.botanicaExp, exp);
				this.botanicaLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getBotanicaLvl() {
		return this.botanicaLvl;
	}
	
	public int getBotanicaExp() {
		return botanicaExp;
	}
	
	public void setBotanicaLvl(int botanicaLvl) {
		this.botanicaLvl = botanicaLvl;
	}
	
	public void setBotanicaExp(int botanicaExp) {
		this.botanicaExp = botanicaExp;
	}


	/*
	 * Pesca
	 */

	public void addPescaExp(int exp) {

		if (this.pescaLvl < 20 && this.pescaLvl<150) {

			if (this.checkTotalLevel(this.pescaExp, exp) == exp) {
				this.pescaExp += exp;
			} else {
				this.pescaExp = this.checkTotalLevel(this.pescaExp, exp);
				this.pescaLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getPescaLvl() {
		return pescaLvl;
	}
	
	public int getPescaExp() {
		return pescaExp;
	}
	
	public void setPescaLvl(int pescaLvl) {
		this.pescaLvl = pescaLvl;
	}

	public void setPescaExp(int pescaExp) {
		this.pescaExp = pescaExp;
	}
	
	
	/*
	 * Construccion
	 */

	public void addConstruccionExp(int exp) {

		if (this.construccionLvl < 50 && this.construccionLvl<150) {

			if (this.checkTotalLevel(this.construccionExp, exp) == exp) {
				this.construccionExp += exp;
			} else {
				this.construccionExp = this.checkTotalLevel(this.construccionExp, exp);
				this.construccionLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getConstruccionLvl() {
		return construccionLvl;
	}
	
	public int getConstruccionExp() {
		return construccionExp;
	}
	
	public void setConstruccionLvl(int construccionLvl) {
		this.construccionLvl = construccionLvl;
	}

	public void setConstruccionExp(int construccionExp) {
		this.construccionExp = construccionExp;
	}


	/*
	 * Herreria
	 */

	public void addHerreriaExp(int exp) {

		if (this.herreriaLvl < 50 && this.herreriaLvl<150) {

			if (this.checkTotalLevel(this.herreriaExp, exp) == exp) {
				this.herreriaExp += exp;
			} else {
				this.herreriaExp = this.checkTotalLevel(this.herreriaExp, exp);
				this.herreriaLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getHerreriaLvl() {
		return herreriaLvl;
	}
	
	public int getHerreriaExp() {
		return herreriaExp;
	}
	
	public void setHerreriaLvl(int herreriaLvl) {
		this.herreriaLvl = herreriaLvl;
	}

	public void setHerreriaExp(int herreriaExp) {
		this.herreriaExp = herreriaExp;
	}


	/*
	 * Artesania
	 */

	public void addArtesaniaExp(int exp) {

		if (this.artesaniaLvl < 50 && this.artesaniaLvl<150) {

			if (this.checkTotalLevel(this.artesaniaExp, exp) == exp) {
				this.artesaniaExp += exp;
			} else {
				this.artesaniaExp = this.checkTotalLevel(this.artesaniaExp, exp);
				this.artesaniaLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getArtesaniaLvl() {
		return artesaniaLvl;
	}
	
	public int getArtesaniaExp() {
		return artesaniaExp;
	}
	
	public void setArtesaniaLvl(int artesaniaLvl) {
		this.artesaniaLvl = artesaniaLvl;
	}

	public void setArtesaniaExp(int artesaniaExp) {
		this.artesaniaExp = artesaniaExp;
	}

	
	/*
	 * Carpinteria
	 */

	public void addCarpinteriaExp(int exp) {

		if (this.carpinteriaLvl < 50 && this.carpinteriaLvl<150) {

			if (this.checkTotalLevel(this.carpinteriaExp, exp) == exp) {
				this.carpinteriaExp += exp;
			} else {
				this.carpinteriaExp = this.checkTotalLevel(this.carpinteriaExp, exp);
				this.carpinteriaLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getCarpinteriaLvl() {
		return carpinteriaLvl;
	}
	
	public int getCarpinteriaExp() {
		return carpinteriaExp;
	}
	
	public void setCarpinteriaLvl(int carpinteriaLvl) {
		this.carpinteriaLvl = carpinteriaLvl;
	}

	public void setCarpinteriaExp(int carpinteriaExp) {
		this.carpinteriaExp = carpinteriaExp;
	}
	
	
	/*
	 * Cocina
	 */

	public void addCocinaExp(int exp) {

		if (this.cocinaLvl < 50 && this.cocinaLvl<150) {

			if (this.checkTotalLevel(this.cocinaExp, exp) == exp) {
				this.cocinaExp += exp;
			} else {
				this.cocinaExp = this.checkTotalLevel(this.cocinaExp, exp);
				this.cocinaLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getCocinaLvl() {
		return cocinaLvl;
	}
	
	public int getCocinaExp() {
		return cocinaExp;
	}
	
	public void setCocinaLvl(int cocinaLvl) {
		this.cocinaLvl = cocinaLvl;
	}

	public void setCocinaExp(int cocinaExp) {
		this.cocinaExp = cocinaExp;
	}


	/*
	 * Apotecario
	 */

	public void addApotecarioExp(int exp) {

		if (this.apotecarioLvl < 50 && this.apotecarioLvl<150) {

			if (this.checkTotalLevel(this.apotecarioExp, exp) == exp) {
				this.apotecarioExp += exp;
			} else {
				this.apotecarioExp = this.checkTotalLevel(this.apotecarioExp, exp);
				this.apotecarioLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getApotecarioLvl() {
		return apotecarioLvl;
	}
	
	public int getApotecarioExp() {
		return apotecarioExp;
	}
	
	public void setApotecarioLvl(int apotecarioLvl) {
		this.apotecarioLvl = apotecarioLvl;
	}

	public void setApotecarioExp(int apotecarioExp) {
		this.apotecarioExp = apotecarioExp;
	}
	
	
	/*
	 * Joyeria
	 */

	public void addJoyeriaExp(int exp) {

		if (this.joyeriaLvl < 20 && this.joyeriaLvl<150) {

			if (this.checkTotalLevel(this.joyeriaExp, exp) == exp) {
				this.joyeriaExp += exp;
			} else {
				this.joyeriaExp = this.checkTotalLevel(this.joyeriaExp, exp);
				this.joyeriaLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getJoyeriaLvl() {
		return joyeriaLvl;
	}
	
	public int getJoyeriaExp() {
		return joyeriaExp;
	}
	
	public void setJoyeriaLvl(int joyeriaLvl) {
		this.joyeriaLvl = joyeriaLvl;
	}

	public void setJoyeriaExp(int joyeriaExp) {
		this.joyeriaExp = joyeriaExp;
	}
	
	
	/*
	 * Mamposteria
	 */

	public void addMamposteriaExp(int exp) {

		if (this.mamposteriaLvl < 20 && this.mamposteriaLvl<150) {

			if (this.checkTotalLevel(this.mamposteriaExp, exp) == exp) {
				this.mamposteriaExp += exp;
			} else {
				this.mamposteriaExp = this.checkTotalLevel(this.mamposteriaExp, exp);
				this.mamposteriaLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getMamposteriaLvl() {
		return mamposteriaLvl;
	}
	
	public int getMamposteriaExp() {
		return mamposteriaExp;
	}
	
	public void setMamposteriaLvl(int mamposteriaLvl) {
		this.mamposteriaLvl = mamposteriaLvl;
	}

	public void setMamposteriaExp(int mamposteriaExp) {
		this.mamposteriaExp = mamposteriaExp;
	}
	
	
	/*
	 * Doma
	 */

	public void addDomaExp(int exp) {

		if (this.domaLvl < 10 && this.domaLvl<150) {

			if (this.checkTotalLevel(this.domaExp, exp) == exp) {
				this.domaExp += exp;
			} else {
				this.domaExp = this.checkTotalLevel(this.domaExp, exp);
				this.domaLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getDomaLvl() {
		return domaLvl;
	}
	
	public int getDomaExp() {
		return domaExp;
	}
	
	public void setDomaLvl(int domaLvl) {
		this.domaLvl = domaLvl;
	}

	public void setDomaExp(int domaExp) {
		this.domaExp = domaExp;
	}


	/*
	 * Pintura
	 */

	public void addPinturaExp(int exp) {

		if (this.pinturaLvl < 10 && this.pinturaLvl<150) {

			if (this.checkTotalLevel(this.pinturaExp, exp) == exp) {
				this.pinturaExp += exp;
			} else {
				this.pinturaExp = this.checkTotalLevel(this.pinturaExp, exp);
				this.pinturaLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getPinturaLvl() {
		return pinturaLvl;
	}
	
	public int getPinturaExp() {
		return pinturaExp;
	}
	
	public void setPinturaLvl(int pinturaLvl) {
		this.pinturaLvl = pinturaLvl;
	}

	public void setPinturaExp(int pinturaExp) {
		this.pinturaExp = pinturaExp;
	}
	
	
	/*
	 * Arco
	 */

	public void addArcoExp(int exp) {

		if (this.arcoLvl < 10 && this.arcoLvl<150) {

			if (this.checkTotalLevel(this.arcoExp, exp) == exp) {
				this.arcoExp += exp;
			} else {
				this.arcoExp = this.checkTotalLevel(this.arcoExp, exp);
				this.arcoLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getArcoLvl() {
		return arcoLvl;
	}
	
	public int getArcoExp() {
		return arcoExp;
	}
	
	public void setArcoLvl(int arcoLvl) {
		this.arcoLvl = arcoLvl;
	}

	public void setArcoExp(int arcoExp) {
		this.arcoExp = arcoExp;
	}
	
	
	/*
	 * Escudos
	 */

	public void addEscudosExp(int exp) {

		if (this.escudosLvl < 10 && this.escudosLvl<150) {

			if (this.checkTotalLevel(this.escudosExp, exp) == exp) {
				this.escudosExp += exp;
			} else {
				this.escudosExp = this.checkTotalLevel(this.escudosExp, exp);
				this.escudosLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getEscudosLvl() {
		return escudosLvl;
	}
	
	public int getEscudosExp() {
		return escudosExp;
	}
	
	public void setEscudosLvl(int escudosLvl) {
		this.escudosLvl = escudosLvl;
	}

	public void setEscudosExp(int escudosExp) {
		this.escudosExp = escudosExp;
	}
	
	
	/*
	 * Armaduras
	 */

	public void addArmadurasExp(int exp) {

		if (this.armadurasLvl < 10 && this.armadurasLvl<150) {

			if (this.checkTotalLevel(this.armadurasExp, exp) == exp) {
				this.armadurasExp += exp;
			} else {
				this.armadurasExp = this.checkTotalLevel(this.armadurasExp, exp);
				this.armadurasLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getArmadurasLvl() {
		return armadurasLvl;
	}
	
	public int getArmadurasExp() {
		return armadurasExp;
	}
	
	public void setArmadurasLvl(int armadurasLvl) {
		this.armadurasLvl = armadurasLvl;
	}

	public void setArmadurasExp(int armadurasExp) {
		this.armadurasExp = armadurasExp;
	}


	/*
	 * Lanzas
	 */

	public void addLanzasExp(int exp) {

		if (this.lanzasLvl < 10 && this.lanzasLvl<150) {

			if (this.checkTotalLevel(this.lanzasExp, exp) == exp) {
				this.lanzasExp += exp;
			} else {
				this.lanzasExp = this.checkTotalLevel(this.lanzasExp, exp);
				this.lanzasLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getLanzasLvl() {
		return lanzasLvl;
	}
	
	public int getLanzasExp() {
		return lanzasExp;
	}
	
	public void setLanzasLvl(int lanzasLvl) {
		this.lanzasLvl = lanzasLvl;
	}

	public void setLanzasExp(int lanzasExp) {
		this.lanzasExp = lanzasExp;
	}


	/*
	 * Espadas
	 */

	public void addEspadasExp(int exp) {

		if (this.espadasLvl < 10 && this.espadasLvl<150) {

			if (this.checkTotalLevel(this.espadasExp, exp) == exp) {
				this.espadasExp += exp;
			} else {
				this.espadasExp = this.checkTotalLevel(this.espadasExp, exp);
				this.espadasLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getEspadasLvl() {
		return espadasLvl;
	}
	
	public int getEspadasExp() {
		return espadasExp;
	}
	
	public void setEspadasLvl(int espadasLvl) {
		this.espadasLvl = espadasLvl;
	}

	public void setEspadasExp(int espadasExp) {
		this.espadasExp = espadasExp;
	}


	/*
	 * Hachas
	 */

	public void addHachasExp(int exp) {

		if (this.hachasLvl < 10 && this.hachasLvl<150) {

			if (this.checkTotalLevel(this.hachasExp, exp) == exp) {
				this.hachasExp += exp;
			} else {
				this.hachasExp = this.checkTotalLevel(this.hachasExp, exp);
				this.hachasLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getHachasLvl() {
		return hachasLvl;
	}
	
	public int getHachasExp() {
		return hachasExp;
	}
	
	public void setHachasLvl(int hachasLvl) {
		this.hachasLvl = hachasLvl;
	}

	public void setHachasExp(int hachasExp) {
		this.hachasExp = hachasExp;
	}
	
	
	/*
	 * Mazas
	 */

	public void addMazasExp(int exp) {

		if (this.mazasLvl < 10 && this.mazasLvl<150) {

			if (this.checkTotalLevel(this.mazasExp, exp) == exp) {
				this.mazasExp += exp;
			} else {
				this.mazasExp = this.checkTotalLevel(this.mazasExp, exp);
				this.mazasLvl++;
				this.totalLvl++;
			}
		}
	}

	public int getMazasLvl() {
		return mazasLvl;
	}
	
	public int getMazasExp() {
		return mazasExp;
	}
	
	public void setMazasLvl(int mazasLvl) {
		this.mazasLvl = mazasLvl;
	}

	public void setMazasExp(int mazasExp) {
		this.mazasExp = mazasExp;
	}

}