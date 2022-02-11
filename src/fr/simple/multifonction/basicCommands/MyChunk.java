package fr.simple.multifonction.basicCommands;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.simple.multifonction.Multifonction;

public class MyChunk implements CommandExecutor {

	private Multifonction multifonction;

	public MyChunk(Multifonction multifonction) {
		this.multifonction = multifonction;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Chunk chunk = player.getWorld().getChunkAt(player.getLocation());
			player.sendMessage(multifonction.prefix + "§9Le chunk dans lequel vous vous tenez est aux positions : x §b"
					+ (chunk.getX() * 16) + "§9, z §b" + (chunk.getZ() * 16) + "§9 et x §b" + ((chunk.getX() * 16) + 16)
					+ "§9, z §b" + ((chunk.getZ() * 16) + 16) + "§9.");
			Location l = new Location(player.getWorld(), (chunk.getX() * 16), (player.getLocation().getY() + 1d), (chunk.getZ() * 16));
			for(double i = 0; i < 17; i++) {
				player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, l, 5);
				l.setX(l.getX() + 1);
			}
			l = new Location(player.getWorld(), (chunk.getX() * 16), (player.getLocation().getY() + 1d), (chunk.getZ() * 16));
			for(double i = 0; i < 17; i++) {
				player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, l, 5);
				l.setZ(l.getZ() + 1);
			}
			l = new Location(player.getWorld(), (chunk.getX() * 16), (player.getLocation().getY() + 1d), (chunk.getZ() * 16));
			l.setZ(l.getZ() + 16);
			for(double i = 0; i < 17; i++) {
				player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, l, 5);
				l.setX(l.getX() + 1);
			}
			l = new Location(player.getWorld(), (chunk.getX() * 16), (player.getLocation().getY() + 1d), (chunk.getZ() * 16));
			l.setX(l.getX() + 16);
			for(double i = 0; i < 17; i++) {
				player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, l, 5);
				l.setZ(l.getZ() + 1);
			}
		} else {
			sender.sendMessage(multifonction.prefix + "§cVous devez être un joueur pour faire ceci !");
		}
		return true;
	}

}
