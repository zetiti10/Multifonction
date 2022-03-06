package fr.simple.multifonction.basicCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.simple.multifonction.Multifonction;

public class Help implements CommandExecutor {

	@SuppressWarnings("unused")
	private Multifonction multifonction;

	public Help(Multifonction multifonction) {
		this.multifonction = multifonction;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage("§9=§b+§9= §bPage d'aide §9=§b+§9=");
		sender.sendMessage("§9Wiki (commandes, fonctionnalités...) : §bhttps://simple.zapto.org/wiki.html§9.");
		if(sender instanceof Player) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "minecraft:tellraw " + sender.getName() +" [\"\",{\"text\":\"Demander de l'aide au staff : \",\"color\":\"blue\"},{\"text\":\"Clique ici\",\"color\":\"aqua\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/helpop\"}},{\"text\":\".\",\"color\":\"blue\"}]");
		}
		return true;
	}

}
