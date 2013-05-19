package core.husbrandy;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SkillPlayers")
public class AnimalDb {

	@Id
	@Column(name = "ID")
	private int					id;
	
	@Column(name = "UUID")
	private UUID					uuid;

	@Column(name = "OWNER", nullable = false)
	private String				owner;
	
	@Column(name = "AGE")
	private int					age;

	public AnimalDb() {

	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}