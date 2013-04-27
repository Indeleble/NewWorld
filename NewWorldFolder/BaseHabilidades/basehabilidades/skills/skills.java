package basehabilidades.skills;


import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Skills {

    /**
     * Process activating abilities & readying the tool.
     *
     * @param player The player using the ability
     * @param skill The skill the ability is tied to
     */
    public static void activationCheck(Player player, SkillType skill) {
    	
        PlayerProfile profile = Users.getProfile(player);
        AbilityType ability = skill.getAbility();
        ToolType tool = skill.getTool();
        ItemStack inHand = player.getItemInHand();

        if (profile == null) {
            return;
        }

        if (!profile.getAbilityUse()) {
            return;
        }

        for (AbilityType x : AbilityType.values()) {
            if (profile.getAbilityMode(x)) {
                return;
            }
        }

        if (ability.getPermissions(player) && tool.inHand(inHand) && !profile.getToolPreparationMode(tool)) {
        	
            if (Config.getInstance().getAbilityMessagesEnabled()) {
                player.sendMessage(tool.getRaiseTool());
            }

            profile.setToolPreparationATS(tool, System.currentTimeMillis());
            profile.setToolPreparationMode(tool, true);
        }
    }
    
    /**
     * Monitors various things relating to skill abilities.
     *
     * @param player The player using the skill
     * @param profile The profile of the player
     * @param curTime The current system time
     * @param skill The skill being monitored
     */
    public static void monitorSkill(Player player, PlayerProfile profile, long curTime, SkillType skill) {
        final int FOUR_SECONDS = 4000;

        ToolType tool = skill.getTool();
        AbilityType ability = skill.getAbility();

        if (profile == null) {
            return;
        }

        if (profile.getToolPreparationMode(tool) && curTime - (profile.getToolPreparationATS(tool) * Misc.TIME_CONVERSION_FACTOR) >= FOUR_SECONDS) {
            profile.setToolPreparationMode(tool, false);

            if (Config.getInstance().getAbilityMessagesEnabled()) {
                player.sendMessage(tool.getLowerTool());
            }
        }

        if (ability.getPermissions(player)) {
            if (profile.getAbilityMode(ability) && (profile.getSkillDATS(ability) * Misc.TIME_CONVERSION_FACTOR) <= curTime) {
                profile.setAbilityMode(ability, false);
                profile.setAbilityInformed(ability, false);
                player.sendMessage(ability.getAbilityOff());

                Misc.sendSkillMessage(player, ability.getAbilityPlayerOff(player));
            }
        }
    }

    /**
     * Check the XP of a skill.
     *
     * @param skillType The skill to check
     * @param player The player whose skill to check
     * @param profile The profile of the player whose skill to check
     */
    public static void xpCheckSkill(SkillType skillType, Player player, PlayerProfile profile) {
        int skillups = 0;

        if (profile.getSkillXpLevel(skillType) >= profile.getXpToLevel(skillType)) {

            while (profile.getSkillXpLevel(skillType) >= profile.getXpToLevel(skillType)) {
                if ((skillType.getMaxLevel() >= profile.getSkillLevel(skillType) + 1) && (Misc.getPowerLevelCap() >= Users.getPlayer(player).getPowerLevel() + 1)) {
                    profile.removeXP(skillType, profile.getXpToLevel(skillType));
                    skillups++;
                    profile.skillUp(skillType, 1);

                    MMOPlayerLevelUpEvent eventToFire = new MMOPlayerLevelUpEvent(player, skillType);
                    sacra.p.getServer().getPluginManager().callEvent(eventToFire);
                }
                else {
                    profile.addLevels(skillType, 0);
                }
            }

            String capitalized = Misc.getCapitalized(skillType.toString());

            /* Spout Stuff */
            if (sacra.spoutEnabled) {
                SpoutPlayer spoutPlayer = SpoutManager.getPlayer(player);

                if (spoutPlayer != null && spoutPlayer.isSpoutCraftEnabled()) {
                    SpoutStuff.levelUpNotification(skillType, spoutPlayer);

                    /* Update custom titles */
                    if (SpoutConfig.getInstance().getShowPowerLevel()) {
                        spoutPlayer.setTitle(LocaleLoader.getString("Spout.Title", new Object[] {spoutPlayer.getName(), Users.getPlayer(player).getPowerLevel()} ));
                    }
                }
                else {
                    player.sendMessage(LocaleLoader.getString(capitalized + ".Skillup", new Object[] {String.valueOf(skillups), profile.getSkillLevel(skillType)}));
                }
            }
            else {
                player.sendMessage(LocaleLoader.getString(capitalized + ".Skillup", new Object[] {String.valueOf(skillups), profile.getSkillLevel(skillType)}));
            }
        }

        if (sacra.spoutEnabled) {
            SpoutPlayer spoutPlayer = (SpoutPlayer) player;

            if (spoutPlayer != null && spoutPlayer.isSpoutCraftEnabled()) {
                if (SpoutConfig.getInstance().getXPBarEnabled()) {
//                    profile.getSpoutHud().updateXpBar(); ANULADO DE MOMENTO HASTA QUE SE HAGA LO DE SPOUT
                }
            }
        }
    }

    /**
     * Check XP of all skills.
     *
     * @param player The player to check XP for.
     * @param profile The profile of the player whose skill to check
     */
    public static void xpCheckAll(Player player, PlayerProfile profile) {
        for (SkillType skillType : SkillType.values()) {
            //Don't want to do anything with this one
            if (skillType == SkillType.ALL) {
                continue;
            }

            xpCheckSkill(skillType, player, profile);
        }
    }

    /**
     * Get the skill represented by the given string
     *
     * @param skillName The name of the skill
     * @return the SkillType if it exists, null otherwise
     */
    public static SkillType getSkillType(String skillName) {
        for (SkillType x : SkillType.values()) {
            if (x.toString().equals(skillName.toUpperCase())) {
                return x;
            }
        }

        return null;
    }

    /**
     * Checks if the given string represents a valid skill
     *
     * @param skillname The name of the skill to check
     * @return true if this is a valid skill, false otherwise
     */
    public static boolean isSkill(String skillName) {
        if (getSkillType(skillName) != null) {
            return true;
        }

        return false;
    }

    public static boolean isLocalizedSkill(String skillName) {
        for (SkillType skill : SkillType.values()) {
            if (skillName.equalsIgnoreCase(LocaleLoader.getString(Misc.getCapitalized(skill.toString() + ".SkillName")))) {
                return true;
            }
        }

        return false;
    }

    public static String translateLocalizedSkill(String skillName) {
        for (SkillType skill : SkillType.values()) {
            if (skillName.equalsIgnoreCase(LocaleLoader.getString(Misc.getCapitalized(skill.toString() + ".SkillName")))) {
                return skill.toString();
            }
        }

        return null;
    }

    public static String localizeSkillName(SkillType skill) {
        return Misc.getCapitalized(LocaleLoader.getString(Misc.getCapitalized(skill.toString()) + ".SkillName"));
    }

    /**
     * Check if the player has any combat skill permissions.
     *
     * @param player The player to check permissions for
     * @return true if the player has combat skills, false otherwise
     */
    public static boolean hasCombatSkills(Player player) {
        if (Permissions.axes(player)
                || Permissions.archery(player)
                || Permissions.swords(player)
                || Permissions.taming(player)
                || Permissions.unarmed(player)) {
            return true;
        }

        return false;
    }

    /**
     * Check if the player has any gathering skill permissions.
     *
     * @param player The player to check permissions for
     * @return true if the player has gathering skills, false otherwise
     */
    public static boolean hasGatheringSkills(Player player) {
        if (Permissions.fishing(player)
                || Permissions.agriculturaganaderia(player)
                || Permissions.mineria(player)
                || Permissions.talabotanica(player)) {
            return true;
        }

        return false;
    }

    /**
     * Check if the player has any misc skill permissions.
     *
     * @param player The player to check permissions for
     * @return true if the player has misc skills, false otherwise
     */
    public static boolean hasMiscSkills(Player player) {
        if (Permissions.acrobatics(player) || Permissions.repair(player)) {
            return true;
        }

        return false;
    }

    /**
     * Handle tool durability loss from abilities.
     *
     * @param inHand The item to damage
     * @param durabilityLoss The durability to remove from the item
     */
    public static void abilityDurabilityLoss(ItemStack inHand, int durabilityLoss) {
        if (Config.getInstance().getAbilitiesDamageTools()) {
            if (inHand.containsEnchantment(Enchantment.DURABILITY)) {
                int level = inHand.getEnchantmentLevel(Enchantment.DURABILITY);
                if (Misc.getRandom().nextInt(level + 1) > 0) {
                    return;
                }
            }
            inHand.setDurability((short) (inHand.getDurability() + durabilityLoss));
        }
    }

    /**
     * Check to see if an ability can be activated.
     *
     * @param player The player activating the ability
     * @param type The skill the ability is based on
     */
    public static void abilityCheck(Player player, SkillType type) {
        PlayerProfile profile = Users.getProfile(player);
        if (profile == null) {
            return;
        }
        ToolType tool = type.getTool();

        if (!profile.getToolPreparationMode(tool)) {
            return;
        }

        profile.setToolPreparationMode(tool, false);

        AbilityType ability = type.getAbility();

        /* Axes and TalaBotanica are odd because they share the same tool.
         * We show them the too tired message when they take action.
         */
        if (type == SkillType.TALABOTANICA || type == SkillType.AXES) {
            if (!profile.getAbilityMode(ability) && !cooldownOver(profile.getSkillDATS(ability) * Misc.TIME_CONVERSION_FACTOR, ability.getCooldown(), player)) {
                player.sendMessage(LocaleLoader.getString("Skills.TooTired", new Object[] { calculateTimeLeft(profile.getSkillDATS(ability) * Misc.TIME_CONVERSION_FACTOR, ability.getCooldown(), player) }));
                return;
            }
        }

        int ticks = 2 + (profile.getSkillLevel(type) / abilityLengthIncreaseLevel);

        if (Permissions.activationTwelve(player)) {
            ticks = ticks + 12;
        }
        else if (Permissions.activationEight(player)) {
            ticks = ticks + 8;
        }
        else if (Permissions.activationFour(player)) {
            ticks = ticks + 4;
        }

        int maxTicks = ability.getMaxTicks();

        if (maxTicks != 0 && ticks > maxTicks) {
            ticks = maxTicks;
        }

        if (!profile.getAbilityMode(ability) && cooldownOver(profile.getSkillDATS(ability), ability.getCooldown(), player)) {
            player.sendMessage(ability.getAbilityOn());

            Misc.sendSkillMessage(player, ability.getAbilityPlayer(player));

            profile.setSkillDATS(ability, System.currentTimeMillis() + (ticks * Misc.TIME_CONVERSION_FACTOR));
            profile.setAbilityMode(ability, true);
        }
    }

    /**
     * Check to see if ability should be triggered.
     *
     * @param player The player using the ability
     * @param block The block modified by the ability
     * @param ability The ability to check
     * @return true if the ability should activate, false otherwise
     */
    public static boolean triggerCheck(Player player, Block block, AbilityType ability) {
        boolean activate = true;

        if (!ability.getPermissions(player)) {
            activate = false;
            return activate;
        }

        switch (ability) {
        case PROSPECTAR:

        default:
            activate = false;
            break;
        }

        return activate;
    }

    /**
     * Handle the processing of XP gain from individual skills.
     *
     * @param player The player that gained XP
     * @param profile The profile of the player gaining XP
     * @param type The type of skill to gain XP from
     * @param xp the amount of XP to gain
     */
    public static void xpProcessing(Player player, PlayerProfile profile, SkillType type, int xp) {
        if (player == null)
            return;

        if (type.getPermissions(player)) {
            if (Users.getPlayer(player) == null)
                return;

            if ((type.getMaxLevel() < profile.getSkillLevel(type) + 1) || (Misc.getPowerLevelCap() < Users.getPlayer(player).getPowerLevel() + 1))
                return;

            Users.getPlayer(player).addXP(type, xp);
            xpCheckSkill(type, player, profile);
        }
    }
}
