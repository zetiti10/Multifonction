package fr.simple.multifonction.basicCommands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.simple.multifonction.Multifonction;

public class Cc implements CommandExecutor {

	private Multifonction multifonction;

	public Cc(Multifonction multifonction) {
		this.multifonction = multifonction;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player cam = Bukkit.getPlayer("MissCake10");//MissCake10
		try {
			switch (args[0]) {
			case "1":
				cam.setGameMode(GameMode.SPECTATOR);
				cam.setFlying(true);
				cam.setInvisible(true);
				Location loc1 = new Location(Bukkit.getWorld("world"), -230.5, 27.0, -1141.5, 136.3f, 15.2f);
				cam.teleport(loc1);
				break;
			case "2":
				cam.setGameMode(GameMode.SPECTATOR);
				cam.setFlying(true);
				cam.setInvisible(true);
				Location loc2 = new Location(Bukkit.getWorld("world"), -190.0, 84.0, -1145.5, 115.8f, 14.7f);
				cam.teleport(loc2);
				break;
			case "3":
				cam.setGameMode(GameMode.SPECTATOR);
				cam.setFlying(true);
				cam.setInvisible(true);
				Location loc3 = new Location(Bukkit.getWorld("world"), -150.5, 77.0, -1154.5, 90f, 0f);
				cam.teleport(loc3);
				break;
			case "4":
				cam.setGameMode(GameMode.SPECTATOR);
				cam.setFlying(true);
				cam.setInvisible(true);
				Location loc4 = new Location(Bukkit.getWorld("world"), -184.8, 100.0, -1177.8, 47.9f, 33.8f);
				cam.teleport(loc4);
				break;
			case "5":
				cam.setGameMode(GameMode.SPECTATOR);
				cam.setFlying(true);
				cam.setInvisible(true);
				Location loc5 = new Location(Bukkit.getWorld("world"), -169.15, 83.7, -1135.1, -138.4f, 24.8f);
				cam.teleport(loc5);
				break;
			case "6":
				cam.setGameMode(GameMode.SPECTATOR);
				cam.setFlying(true);
				cam.setInvisible(true);
				Location loc6 = new Location(Bukkit.getWorld("world"), -181.0, 77.0, -1150.6, -124.5f, 0.0f);
				cam.teleport(loc6);
				break;
			case "7":
				cam.setGameMode(GameMode.SURVIVAL);
				cam.setFlying(false);
				cam.setInvisible(false);
				cam.getInventory().clear();
				cam.updateInventory();
				Bukkit.dispatchCommand(cam, "spawn");
				break;
			default:
				sender.sendMessage(multifonction.prefix + "§cUsage : §c§l§/cc [1|2|3|4|5|6|7]§c.");
				break;
			}
			return true;
		} catch (IndexOutOfBoundsException e) {
			sender.sendMessage(multifonction.prefix + "§cUsage : §c§l§/cc [1|2|3|4|5|6|7]§c.");
		}
		return true;
	}

	
	
}
