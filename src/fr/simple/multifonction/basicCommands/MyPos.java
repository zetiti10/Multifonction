package fr.simple.multifonction.basicCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.simple.multifonction.Multifonction;

public class MyPos implements CommandExecutor {

	private Multifonction multifonction;

	public MyPos(Multifonction multifonction) {
		this.multifonction = multifonction;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			String loc = "string";
			loc = Math.round(player.getLocation().getX()) + " " + Math.round(player.getLocation().getY()) + " " + Math.round(player.getLocation().getZ());
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "minecraft:tellraw " + player.getName() + " {\"text\":\"" + loc + "\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + loc + "\"}}");
		} else {
			sender.sendMessage(multifonction.prefix + "§cVous devez être un joueur pour faire ceci !");
		}
		return true;

	}

}
