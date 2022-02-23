package fr.simple.multifonction;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Pvp implements CommandExecutor {
	
	private Multifonction multifonction;

	public Pvp(Multifonction multifonction) {
		this.multifonction = multifonction;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(multifonction.prefix + "§cSeul un joueur peut exécuter cette commande.");
			return true;
		}
		
		Player player = (Player) sender;
		
		if(!DataManager.InPVPPlayers.isEmpty()) {
			List<Player> InPVPPlayers = DataManager.InPVPPlayers;
			for(int i = 0; i < InPVPPlayers.size(); i ++) {
				if(InPVPPlayers.get(i) == player) {
					player.sendMessage(multifonction.prefix + "§cVous ne pouvez pas désactiver le PVP lorque vous êtes en PVP.");
					return true;
				}
			}
		}
		
		if(FileManager.isPVPEnabled(player)) {
			FileManager.setPVPEnabled(player, false);
			player.sendMessage(multifonction.prefix + "§9PVP : §cdésactivé§9.");
		} else {
			FileManager.setPVPEnabled(player, true);
			player.sendMessage(multifonction.prefix + "§9PVP : §aactivé§9.");
		}
		
		return true;
		
	}

}
