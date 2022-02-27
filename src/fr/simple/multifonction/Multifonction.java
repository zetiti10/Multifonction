package fr.simple.multifonction;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import fr.simple.multifonction.basicCommands.Cc;
import fr.simple.multifonction.basicCommands.Freeze;
import fr.simple.multifonction.basicCommands.Help;
import fr.simple.multifonction.basicCommands.HelpOp;
import fr.simple.multifonction.basicCommands.Liens;
import fr.simple.multifonction.basicCommands.MyChunk;
import fr.simple.multifonction.basicCommands.MyPos;
import fr.simple.multifonction.basicCommands.Pvp;
import fr.simple.multifonction.basicCommands.SafeRestart;
import fr.simple.multifonction.basicCommands.Top;
import net.milkbowl.vault.economy.Economy;

public class Multifonction extends JavaPlugin {
	
	public Economy eco;
	public String prefix = "§eSimplebot §8» ";
	public Multifonction multifonction = this;
	
	@Override
	public void onEnable() {
		
		if (!setupEconomy()) {
			Bukkit.getConsoleSender().sendMessage(
					"Erreur : Vous devez avoir Vault ainsi qu'un plugin d'économie installé sur votre serveur !");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		getCommand("afreeze").setExecutor(new Freeze(this));
		getCommand("cc").setExecutor(new Cc(this));
		getCommand("mychunk").setExecutor(new MyChunk(this));
		getCommand("myloc").setExecutor(new MyPos(this));
		getCommand("liens").setExecutor(new Liens());
		getCommand("saferestart").setExecutor(new SafeRestart(this));
		getCommand("pvp").setExecutor(new Pvp(this));
		getCommand("help").setExecutor(new Help(this));
		getCommand("helpop").setExecutor(new HelpOp(this));
		getCommand("top").setExecutor(new Top(this));
		
		getServer().getPluginManager().registerEvents(new Listeners(this), this);
		
		Bukkit.getScheduler().runTaskTimer(this, new PvpManager(), 20, 20);
		
		Bukkit.getConsoleSender().sendMessage("========================================================");
		Bukkit.getConsoleSender().sendMessage("===== Simple, le plugin multifonction est allumé ! =====");
		Bukkit.getConsoleSender().sendMessage("========================================================");
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("========================================================");
		Bukkit.getConsoleSender().sendMessage("===== Simple, le plugin multifonction est éteint ! =====");
		Bukkit.getConsoleSender().sendMessage("========================================================");
	}
	
	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economy = getServer().getServicesManager()
				.getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economy != null) {
			eco = economy.getProvider();
		}
		return (eco != null);
	}
	
}
