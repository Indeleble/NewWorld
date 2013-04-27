package basehabilidades.skills;

public enum SkillType {
    ALL, //This one is just for convenience
    MINERIA(AbilityType.PROSPECTAR, Config.getInstance().getLevelCapMineria(), ToolType.PICKAXE, Config.getInstance().getFormulaMultiplierMineria()),
    TALA(Config.getInstance().getLevelCapTala(), Config.getInstance().getFormulaMultiplierTala()),
    AGRICULTURA(Config.getInstance().getLevelCapAgricultura(), Config.getInstance().getFormulaMultiplierAgricultura()),
    GANADERIA(Config.getInstance().getLevelCapGanaderia(), Config.getInstance().getFormulaMultiplierGanaderia()),
    BOTANICA(Config.getInstance().getLevelCapBotanica(), Config.getInstance().getFormulaMultiplierBotanica()),
    PESCA(Config.getInstance().getLevelCapPesca(), Config.getInstance().getFormulaMultiplierPesca()),
    CONSTRUCCION(Config.getInstance().getLevelCapConstruccion(), Config.getInstance().getFormulaMultiplierConstruccion()),
    HERRERIA(Config.getInstance().getLevelCapHerreria(), Config.getInstance().getFormulaMultiplierHerreria()),
    ARTESANIA(Config.getInstance().getLevelCapArtesania(), Config.getInstance().getFormulaMultiplierArtesania()),
    CARPINTERIA(Config.getInstance().getLevelCapCarpinteria(), Config.getInstance().getFormulaMultiplierCarpinteria()),
    COCINA(Config.getInstance().getLevelCapCocina(), Config.getInstance().getFormulaMultiplierCocina()),
    APOTECARIO(Config.getInstance().getLevelCapApotecario(), Config.getInstance().getFormulaMultiplierApotecario()),
    JOYERIA(Config.getInstance().getLevelCapJoyeria(), Config.getInstance().getFormulaMultiplierJoyeria()),
    MAMPOSTERIA(Config.getInstance().getLevelCapMamposteria(), Config.getInstance().getFormulaMultiplierMamposteria()),
    DOMA(Config.getInstance().getLevelCapMamposteria(), Config.getInstance().getFormulaMultiplierMamposteria()),
    PINTURA(Config.getInstance().getLevelCapPintura(), Config.getInstance().getFormulaMultiplierPintura()),
    ARCO(Config.getInstance().getLevelCapArco(), Config.getInstance().getFormulaMultiplierArco()),
    ESCUDOS(Config.getInstance().getLevelCapEscudos(), Config.getInstance().getFormulaMultiplierEscudos()),
    ARMADURAS(Config.getInstance().getLevelCapArmaduras(), Config.getInstance().getFormulaMultiplierArmaduras()),
    LANZAS(Config.getInstance().getLevelCapLanzas(), Config.getInstance().getFormulaMultiplierLanzas()),
    ESPADAS(Config.getInstance().getLevelCapEspadas(), Config.getInstance().getFormulaMultiplierEspadas()),
    HACHAS(Config.getInstance().getLevelCapHachas(), Config.getInstance().getFormulaMultiplierHachas()),
    MAZAS(Config.getInstance().getLevelCapMazas(), Config.getInstance().getFormulaMultiplierMazas());

    private AbilityType ability;
    private int maxLevel;
    private ToolType tool;
    private double xpModifier;

    private SkillType() {
        this.ability = null;
        this.maxLevel = 0;
        this.tool = null;
        this.xpModifier = 0;
    }

    private SkillType(AbilityType ability, int maxLevel, ToolType tool, double xpModifier) {
        this.ability = ability;
        this.maxLevel = maxLevel;
        this.tool = tool;
        this.xpModifier = xpModifier;
    }

    private SkillType(int maxLevel, double xpModifier) {
        this(null, maxLevel, null, xpModifier);
    }

    public AbilityType getAbility() {
        return ability;
    }

    /**
     * Get the max level of this skill.
     *
     * @return the max level of this skill
     */
    public int getMaxLevel() {
        if (maxLevel > 0) {
            return maxLevel;
        }

        return Integer.MAX_VALUE;
    }

    public ToolType getTool() {
        return tool;
    }

    /**
     * Get the base permissions associated with this skill.
     *
     * @param player The player to check the permissions for
     * @return true if the player has permissions, false otherwise
     */
    public boolean getPermissions(Player player) {
        switch (this) {
        case MINERIA:
            return Permissions.mineria(player);

        case TALA:
            return Permissions.tala(player);

        case AGRICULTURA:
            return Permissions.agricultura(player);

        case GANADERIA:
            return Permissions.ganaderia(player);

        case BOTANICA:
            return Permissions.botanica(player);

        case PESCA:
            return Permissions.pesca(player);

        case CONSTRUCCION:
            return Permissions.construccion(player);

        case HERRERIA:
            return Permissions.herreria(player);

        case ARTESANIA:
            return Permissions.artesania(player);

        case CARPINTERIA:
            return Permissions.carpinteria(player);

        case COCINA:
            return Permissions.cocina(player);
            
        case APOTECARIO:
            return Permissions.apotecario(player);

        case JOYERIA:
            return Permissions.joyeria(player);

        case MAMPOSTERIA:
            return Permissions.mamposteria(player);

        case DOMA:
            return Permissions.doma(player);

        case PINTURA:
            return Permissions.pintura(player);

        case ARCO:
            return Permissions.arco(player);

        case ESCUDOS:
            return Permissions.escudos(player);
            
        case ARMADURAS:
            return Permissions.armaduras(player);

        case LANZAS:
            return Permissions.lanzas(player);
            
        case ESPADAS:
            return Permissions.espadas(player);

        case HACHAS:
            return Permissions.hachas(player);
            
        case MAZAS:
            return Permissions.mazas(player);

        default:
            return false;
        }
    }

    public double getXpModifier() {
        return xpModifier;
    }

    public static SkillType getSkill(String skillName) {
        if (skillName.equalsIgnoreCase("powerlevel") || skillName.equalsIgnoreCase("all")) {
            return SkillType.ALL;
        }

        for (SkillType type : SkillType.values()) {
            if (type.name().equalsIgnoreCase(skillName)) {
                return type;
            }
        }

        System.out.println("[DEBUG] Invalid Sacra skill (" + skillName + ")");
        return null;
    }

    /**
     * Get the skill level for this skill.
     *
     * @param player The player to check
     * @return
     */
    public int getSkillLevel(Player player) {
        return Users.getProfile(player).getSkillLevel(this);
    }
}