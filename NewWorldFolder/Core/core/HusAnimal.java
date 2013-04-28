package core;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "husanimals")
public class HusAnimal {

	@Column
	UUID uid;
	@Column
	int calidad;
	@Column
	String owner;
	
	public UUID getUid() {
		return uid;
	}
	public void setUid(UUID uid) {
		this.uid = uid;
	}
	public int getCalidad() {
		return calidad;
	}
	public void setCalidad(int calidad) {
		this.calidad = calidad;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}

}
