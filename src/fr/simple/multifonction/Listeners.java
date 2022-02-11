package fr.simple.multifonction;


import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Listeners implements Listener {
	
	private Multifonction multifonction;

	public Listeners(Multifonction multifonction) {
		this.multifonction = multifonction;
	}
	
	Location ruban_rouge0 = new Location(Bukkit.getWorld("world"), -176, 78, -1155);
	Location void0 = new Location(Bukkit.getWorld("world"), -176, 77, -1155);
	
	Location ruban_rouge1 = new Location(Bukkit.getWorld("world"), -176, 78, -1154);
	Location ruban_rouge2 = new Location(Bukkit.getWorld("world"), -176, 78, -1156);
	Location void1 = new Location(Bukkit.getWorld("world"), -176, 77, -1154);
	Location void2 = new Location(Bukkit.getWorld("world"), -176, 77, -1156);
	
	Location ruban_rouge3 = new Location(Bukkit.getWorld("world"), -176, 78, -1153);
	Location ruban_rouge4 = new Location(Bukkit.getWorld("world"), -176, 78, -1157);
	Location void3 = new Location(Bukkit.getWorld("world"), -176, 77, -1153);
	Location void4 = new Location(Bukkit.getWorld("world"), -176, 77, -1157);
	
	Location ruban_rouge5 = new Location(Bukkit.getWorld("world"), -176, 78, -1152);
	Location ruban_rouge6 = new Location(Bukkit.getWorld("world"), -176, 78, -1158);
	Location void5 = new Location(Bukkit.getWorld("world"), -176, 77, -1152);
	Location void6 = new Location(Bukkit.getWorld("world"), -176, 77, -1158);
	
	Location ruban_rouge7 = new Location(Bukkit.getWorld("world"), -176, 78, -1151);
	Location ruban_rouge8 = new Location(Bukkit.getWorld("world"), -176, 78, -1159);
	Location void7 = new Location(Bukkit.getWorld("world"), -176, 77, -1151);
	Location void8 = new Location(Bukkit.getWorld("world"), -176, 77, -1159);
	
	Location artifices = new Location(Bukkit.getWorld("world"), -170, 71, -1132);
	
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		if(event.getBlock().getLocation().getX() == ruban_rouge0.getX() && event.getBlock().getLocation().getY() == ruban_rouge0.getY() && event.getBlock().getLocation().getZ() == ruban_rouge0.getZ()) {
			if(event.getPlayer() == Bukkit.getPlayer("zetiti10")) {
				void0.getBlock().setType(Material.AIR);
				Bukkit.getScheduler().runTaskTimer(multifonction, new Runnable() {
					int i = 1;
					@SuppressWarnings("unchecked")
					List<Player> players = (List<Player>) Bukkit.getOnlinePlayers();
					@Override
					public void run() {
						switch (i) {
						case 1:
							ruban_rouge1.getBlock().setType(Material.AIR);
							ruban_rouge2.getBlock().setType(Material.AIR);
							void1.getBlock().setType(Material.AIR);
							void2.getBlock().setType(Material.AIR);
							break;
						case 2:
							ruban_rouge3.getBlock().setType(Material.AIR);
							ruban_rouge4.getBlock().setType(Material.AIR);
							void3.getBlock().setType(Material.AIR);
							void4.getBlock().setType(Material.AIR);
							break;
						case 3:
							ruban_rouge3.getBlock().setType(Material.AIR);
							ruban_rouge4.getBlock().setType(Material.AIR);
							void3.getBlock().setType(Material.AIR);
							void4.getBlock().setType(Material.AIR);
							break;
						case 4:
							ruban_rouge5.getBlock().setType(Material.AIR);
							ruban_rouge6.getBlock().setType(Material.AIR);
							void5.getBlock().setType(Material.AIR);
							void6.getBlock().setType(Material.AIR);
							break;
						case 5:
							ruban_rouge7.getBlock().setType(Material.AIR);
							ruban_rouge8.getBlock().setType(Material.AIR);
							void7.getBlock().setType(Material.AIR);
							void8.getBlock().setType(Material.AIR);
							break;
						case 6:
							Bukkit.broadcastMessage("§bSimple est ouvert ! §9Après plus d'un an de développement, le serveur est enfin ouvert. Vous pouvez commencer dès maintenant votre survie !");
							for(int i = 0; i < players.size(); i ++) {
								players.get(i).playSound(players.get(i).getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1, 1);
								players.get(i).sendTitle("§bSimple est ... ouvert !", "§9Vous pouvez commencer votre aventure dès maintenant !", 20, 20 * 5, 20);
								artifices.getBlock().setType(Material.REDSTONE_BLOCK);
							}
							break;
						default:
							break;
						}
						i ++;
						for(int i = 0; i < players.size(); i ++) {
							players.get(i).playSound(players.get(i).getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
						}
					}
				}, 20 * 1L, 15L);
				
				Bukkit.getScheduler().runTaskTimer(multifonction, new Runnable() {
					long i = 0L;
					@Override
					public void run() {
						Bukkit.getWorld("world").setTime(i);
						i = i + 50L;
						if(i == 20000L) {
							Bukkit.getWorld("world").setGameRule(GameRule.DO_DAYLIGHT_CYCLE, true);
							Bukkit.getWorld("world").setGameRule(GameRule.DO_WEATHER_CYCLE, true);
							Bukkit.getScheduler().cancelTasks(multifonction);
						}
					}
				}, 1L, 1L);
				
				/*Bukkit.getScheduler().runTaskLater(multifonction, new Runnable() {
					@Override
					public void run() {
						
					}
				}, 20 * 1L);*/
				
			} else {
				event.setCancelled(true);
			}
		}
	}
}
