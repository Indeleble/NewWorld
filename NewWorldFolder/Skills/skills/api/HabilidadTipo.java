package skills.api;

public enum HabilidadTipo {
    PROSPECTAR(10, "Te preparas para prospectar la piedra", "Dejas de prospectar la piedra", "", ""),
    INSTRUMENTO(0, "Te preparas para tocar el instrumento", "Dejas de tocar el instrumento", "", "");
    
    private int cooldown;
    private String habilidadOn;
    private String habilidadOff;
    private String abilityPlayer;
    private String abilityPlayerOff;
    
    private HabilidadTipo(int cooldown, String abilityOn, String abilityOff, String abilityPlayer, String abilityPlayerOff) {
        this.setCooldown(cooldown);
        this.setHabilidadOn(abilityOn);
        this.setHabilidadOff(abilityOff);
        this.setAbilityPlayer(abilityPlayer);
        this.setAbilityPlayerOff(abilityPlayerOff);

    }

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	public String getHabilidadOn() {
		return habilidadOn;
	}

	public void setHabilidadOn(String habilidadOn) {
		this.habilidadOn = habilidadOn;
	}

	public String getHabilidadOff() {
		return habilidadOff;
	}

	public void setHabilidadOff(String habilidadOff) {
		this.habilidadOff = habilidadOff;
	}

	public String getAbilityPlayer() {
		return abilityPlayer;
	}

	public void setAbilityPlayer(String abilityPlayer) {
		this.abilityPlayer = abilityPlayer;
	}

	public String getAbilityPlayerOff() {
		return abilityPlayerOff;
	}

	public void setAbilityPlayerOff(String abilityPlayerOff) {
		this.abilityPlayerOff = abilityPlayerOff;
	}

}
