package skills.mineria;

import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import skills.drops.CustomDrop;
import skills.drops.ItemPurityBuilder;

public class MiningListener implements Listener {

	static SkillPlayerManager	spm;
	Logger						log;
	Plugin						pl;

	public MiningListener(SkillPlayerManager spm, Logger log, Plugin pl) {
		this.spm = spm;
		this.log = log;
		this.pl = pl;
	}
	/*
	 * @EventHandler public static void PlayerInteractEvent(PlayerInteractEvent
	 * event) {
	 * 
	 * SkillPlayer sp; Player player = event.getPlayer(); Action action =
	 * event.getAction(); PermissionUser user =
	 * PermissionsEx.getUser(event.getPlayer()); Block block =
	 * event.getClickedBlock(); sp = spm.getSkillPlayer(player.getName());
	 * 
	 * @SuppressWarnings("unused") Material material;
	 * 
	 * int inHand = player.getItemInHand().getTypeId();
	 * 
	 * if (block == null) { material = Material.AIR; } else { material =
	 * block.getType(); }
	 * 
	 * switch (action) { case RIGHT_CLICK_BLOCK: // if
	 * (user.inGroup("mineria")){ // Colocar a nivel en el que empieza a ser
	 * prospectable la piedra if((inHand==257) || (inHand==274) || (inHand==278)
	 * || (inHand==285) ){ player.sendMessage("test block");
	 * if(sp.isProspectando()==false){ sp.setProspectando(true);
	 * player.sendMessage
	 * (ChatColor.GREEN+"Te preparas para prospectar la piedra"); }else{
	 * sp.setProspectando(false);
	 * player.sendMessage(ChatColor.RED+"Dejas de prospectar la piedra"); } } //
	 * } break; case RIGHT_CLICK_AIR: // if (user.inGroup("mineria")){ //
	 * Colocar a nivel en el que empieza a ser prospectable la piedra
	 * if((inHand==257) || (inHand==274) || (inHand==278) || (inHand==285) ){
	 * player.sendMessage("test block"); if(sp.isProspectando()==false){
	 * sp.setProspectando(true);
	 * player.sendMessage(ChatColor.GREEN+"Te preparas para prospectar la piedra"
	 * ); }else{ sp.setProspectando(false);
	 * player.sendMessage(ChatColor.RED+"Dejas de prospectar la piedra"); } } //
	 * } break; default: break; } }
	 * 
	 * @EventHandler public void BlockBreakEvent(BlockBreakEvent ev) {
	 * 
	 * 
	 * SkillPlayer sp; Player player = ev.getPlayer(); Location blockLocation =
	 * ev.getBlock().getLocation(); sp = spm.getSkillPlayer(player.getName());
	 * PermissionUser user = PermissionsEx.getUser(ev.getPlayer()); Block block
	 * = ev.getBlock(); ItemPurityBuilder ipb; Random r = new Random(); int
	 * inHand = player.getItemInHand().getTypeId(); int r2 = 0;
	 * 
	 * 
	 * if (block.getType() == Material.STONE){ // if (user.inGroup("mineria")){
	 * // Colocar a nivel en el que empieza a ser prospectable la piedra
	 * if(player.getGameMode()==GameMode.SURVIVAL){ if((inHand==257) ||
	 * (inHand==274) || (inHand==278) || (inHand==285)){ ipb = new
	 * ItemPurityBuilder(); if(sp.isProspectando()==true){// Si prospecta
	 * player.sendMessage("test romper stone prospectando");
	 * sp.setProspectando(false);
	 * 
	 * // Pendiente de revisar el prospecteo de cada material
	 * if(sp.getMineriaLvl()>=20){
	 * 
	 * // random de volver el bloque prospectado coal
	 * 
	 * if(sp.isProspectando()==false){ player.sendMessage(ChatColor.GREEN+
	 * "Has prospectado la piedra y te ha salido coal"); } }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }else{ //si no prospecta
	 * player.sendMessage("test romper stone sin prospectar");
	 * 
	 * ItemStack cobblestone = new ItemStack(4);
	 * 
	 * if(inHand==274){ //pico cobre ipb.addDrop(new CustomDrop(cobblestone,
	 * sp.getMineriaLvl(), 1, 50)); } if (inHand==257) { //pico hierro
	 * ipb.addDrop(new CustomDrop(cobblestone, sp.getMineriaLvl(), 1, 70)); }
	 * if(inHand==278){ //pico acero ipb.addDrop(new CustomDrop(cobblestone,
	 * sp.getMineriaLvl(), 1, 80)); }
	 * 
	 * if (ipb.getDrops().size() > 0) {
	 * 
	 * for (ItemStack is : ipb.getDrops()) {
	 * pl.getServer().getWorld("world").dropItem(blockLocation, is); } }
	 * 
	 * sp.addMineriaExp(200);
	 * player.sendMessage("Experiencia en mineria subio en 200 puntos");
	 * player.sendMessage("Experiencia en mineria: " + sp.getMineriaExp());
	 * player.sendMessage("Nivel de mineria: " + sp.getMineriaLvl());
	 * player.sendMessage("Nivel total: " + sp.getTotalLevel());
	 * 
	 * ev.setCancelled(true); ev.getBlock().setTypeId(0);
	 * 
	 * // Añadir el resto de bloques a parte de la piedra
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * } } } // } } }
	 */
}
