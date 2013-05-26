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


	public UUID getUuid() {
		return uuid;
	}


	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	
}