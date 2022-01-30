package fr.simple.multifonction.basicCommands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.simple.multifonction.Multifonction;

public class Freeze implements CommandExecutor {

	private Multifonction multifonction;

	public Freeze(Multifonction multifonction) {
		this.multifonction = multifonction;
	}

	List<Player> freezed = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			Player target = Bukkit.getPlayer(args[0]);
			for (int i = 0; i < freezed.size(); i++) {
				if (freezed.get(i).getName().equals(target.getName())) {
					sender.sendMessage(multifonction.prefix + "§b" + target.getName() + " §9n'est plus immobilisé.");
					if (freezed.get(i).isOnline()) {
						target.sendMessage(multifonction.prefix + "§9Vous n'êtes plus immobilisé.");
					}
					freezed.remove(i);
					return true;
				}
				
			}
			
			if (target.isOnline()) {
				freezed.add(target);
				target.sendMessage(multifonction.prefix + "§9Vous venez d'être immobilisé par un membre du staff.");
				sender.sendMessage(multifonction.prefix + "§9Vous venez d'immobiliser §b" + target.getName() + "§9.");
			} else {
				sender.sendMessage(multifonction.prefix + "§Ce joueur n'est pas connecté.");
			}
			return true;
			
		} catch (IndexOutOfBoundsException e) {
			sender.sendMessage(
					multifonction.prefix + "§cVous devez spécifier un joueur comme ceci : §c§l/freeze <joueur>§c.");
			return true;
		}
		
	}

}
