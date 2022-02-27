package fr.simple.multifonction.basicCommands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.simple.multifonction.Multifonction;

public class HelpOp implements CommandExecutor {

	private Multifonction multifonction;

	public HelpOp(Multifonction multifonction) {
		this.multifonction = multifonction;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {

			@SuppressWarnings("unchecked")
			List<Player> onlines = (List<Player>) Bukkit.getOnlinePlayers();
			boolean staffConnected = false;
			for (int i = 0; i < onlines.size(); i++) {
				if (onlines.get(i).hasPermission("multifonction.moderateur")) {
					staffConnected = true;
					onlines.get(i).playSound(onlines.get(i).getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 1);
					onlines.get(i).sendMessage(multifonction.prefix + "§b" + sender.getName() + " §9a besoin d'aide !");

				}
			}
			if (!staffConnected) {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
						"discord broadcast #「💭」discutions **ALERTE** @everyone " + sender.getName() + " a besoin d'aide !");
				sender.sendMessage(multifonction.prefix
						+ "§9Aucun membre du staff n'est connecté, nous envoyons une notification sur Discord.");
			} else {
				sender.sendMessage(
						multifonction.prefix + "§9Le staff a été informé de votre demande et va bientôt arriver.");
			}
			return true;
		}
		
		sender.sendMessage("Vous devez être un joueur pour exécuter cette commande !");
		return true;
	}

}
