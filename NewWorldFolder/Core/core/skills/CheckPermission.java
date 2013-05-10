package core.skills;

import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CheckPermission {
	
	SkillType skill;
	String playerName;
	int skillLevel;
	
	public CheckPermission(String playerName, SkillType skill, int skillLevel){
		this.skill = skill;
		this.playerName = playerName;
		this.skillLevel = skillLevel;
	}
	
	public boolean check(){
		
		PermissionUser user = PermissionsEx.getUser(playerName);
		PermissionManager pex = PermissionsEx.getPermissionManager();
		PermissionGroup[] groups = pex.getGroups();
		
		for (int i = 0;i < groups.length;i++){
			
			String playerGroup = skill.toString() + String.valueOf(skillLevel);
			
			if (groups[i].toString().equalsIgnoreCase(playerGroup)){
				
				user.addGroup(playerGroup);
				return true;
			}
		}		
		return false;
	}
}
