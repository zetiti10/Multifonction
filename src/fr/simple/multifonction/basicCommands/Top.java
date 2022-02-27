package fr.simple.multifonction.basicCommands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.simple.multifonction.Multifonction;

public class Top implements CommandExecutor {

	private Multifonction multifonction;

	public Top(Multifonction multifonction) {
		this.multifonction = multifonction;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			Location loc = player.getWorld().getHighestBlockAt(player.getLocation()).getLocation();
			loc.setX(player.getLocation().getX());
			loc.setZ(player.getLocation().getZ());
			Double Y = loc.getY();
			Y= Y + 1D;
			loc.setY(Y);
			player.teleport(loc);
			player.sendMessage(multifonction.prefix + "§9Vous avez été téléporté au bloc le plus haut.");
		}
		return true;
	}

}
