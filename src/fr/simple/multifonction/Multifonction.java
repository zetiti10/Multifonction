package fr.simple.multifonction;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import fr.simple.multifonction.basicCommands.Freeze;
import net.milkbowl.vault.economy.Economy;

public class Multifonction extends JavaPlugin {
	
	public Economy eco;
	public String prefix = "§eSimplebot §8» ";//
	public Multifonction multifonction = this;
	
	@Override
	public void onEnable() {
		
		if (!setupEconomy()) {
			Bukkit.getConsoleSender().sendMessage(
					"Erreur : Vous devez avoir Vault ainsi qu'un plugin d'économie installé sur votre serveur !");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		getCommand("freeze").setExecutor(new Freeze(this));
		
		getServer().getPluginManager().registerEvents(new Listeners(), this);
		
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
