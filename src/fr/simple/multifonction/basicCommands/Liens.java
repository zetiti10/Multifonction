package fr.simple.multifonction.basicCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Liens implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage("§9Voilà les liens de Simple :");
		sender.sendMessage("§b- §9Site : §bhttps://simple.zapto.org");
		sender.sendMessage("§b- §9Discord : §bhttps://discord.gg/a66TRsC");
		sender.sendMessage("§b- §9YouTube : §bhttps://www.youtube.com/channel/UCvUIRrazNAuIXojRUUSX8KA");
		sender.sendMessage("§b- §9Twitter : §bhttps://twitter.com/ServeurSimple");
		return true;
	}

}
