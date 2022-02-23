package fr.simple.multifonction.basicCommands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.simple.multifonction.Multifonction;

public class SafeRestart implements CommandExecutor {

	private Multifonction multifonction;
	public SafeRestart(Multifonction multifonction) {
		this.multifonction = multifonction;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!Bukkit.getOnlinePlayers().isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Player> onlines = (List<Player>) Bukkit.getOnlinePlayers();
			Bukkit.broadcastMessage(multifonction.prefix + "§c§lLe serveur va redémarrer dans 1 minute.");
			Bukkit.getScheduler().runTaskLater(multifonction, new Runnable() {
				@Override
				public void run() {
					PotionEffect potion = new PotionEffect(PotionEffectType.BLINDNESS, 220, 1);
					Bukkit.broadcastMessage(multifonction.prefix + "§c§lRedémarrage du serveur.");
					for(int i = 0; i < onlines.size(); i ++) {
						onlines.get(i).addPotionEffect(potion);
						onlines.get(i).sendTitle("§c§lLe serveur redémarre", "§c§lNe bougez pas", 20, 60, 20);
					}
				}
			}, 60 * 20L);
			Bukkit.getScheduler().runTaskLater(multifonction, new Runnable() {
				@Override
				public void run() {
					for(int i = 0; i < onlines.size(); i ++) {
						onlines.get(i).kickPlayer("§c§lRedémarrage...");
					}
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop");
				}
			}, 70L * 20L);
			
		} else {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop");
		}
		return true;
	}

}
