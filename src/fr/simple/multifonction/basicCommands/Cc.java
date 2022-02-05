package fr.simple.multifonction.basicCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.simple.multifonction.Multifonction;

public class Cc implements CommandExecutor {

	@SuppressWarnings("unused")
	private Multifonction multifonction;

	public Cc(Multifonction multifonction) {
		this.multifonction = multifonction;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player cam = Bukkit.getPlayer("MissCake10");
		return false;
	}

	
	
}
