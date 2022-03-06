package fr.simple.multifonction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class FileManager {

	public static void createPVPAccount(Player player) {
		
		final File file = new File("plugins/Multifonction", "/pvp.yml");
		final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		
		configuration.set("players." + player.getUniqueId().toString() + ".ispvp", false);
		configuration.set("players." + player.getUniqueId().toString() + ".kills", 0);
		configuration.set("players." + player.getUniqueId().toString() + ".deaths", 0);
		
		try {
			configuration.save(file);
		} catch (IOException e) {
			System.out.println("Une erreur fatale est survenue lors de la création du fichier \"Multifonction.yml\".");
			player.sendMessage("Une erreur fatale est survenue lors de la création du compte PVP. Contactez le staff.");
			e.printStackTrace();
		}
		
	}
	
	private static void fin(File file, YamlConfiguration configuration) {
		try {
			configuration.save(file);
		} catch (IOException e) {
			Bukkit.getConsoleSender().sendMessage("Une erreur fatale est survenue lors de la création du fichier \"teams.yml\".");
			e.printStackTrace();
		}
	}
	
	public static boolean isPVPEnabled(Player player) {
		try {
		final File file = new File("plugins/Multifonction", "/pvp.yml");
		final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		final ConfigurationSection configurationSection = configuration.getConfigurationSection("players." + player.getUniqueId().toString());
		return configurationSection.getBoolean("ispvp");
		} catch(NullPointerException e) {
			Bukkit.getConsoleSender().sendMessage("Une erreur est survenue lors de la récupération du boolean ispvp pour " + player.getName() + " (UUID " + player.getUniqueId() + ") !");
			return false;
		}
	}
	
	public static void setPVPEnabled(Player player, boolean isEnabled) {
		final File file = new File("plugins/Multifonction", "/pvp.yml");
		final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		configuration.set("players." + player.getUniqueId().toString() + ".ispvp", isEnabled);
		fin(file, configuration);
	}
	public static boolean getKills(Player player) {
		final File file = new File("plugins/Multifonction", "/pvp.yml");
		final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		final ConfigurationSection configurationSection = configuration.getConfigurationSection("players." + player.getUniqueId().toString());
		return configurationSection.getBoolean("kills");
	}
	public static void setKills(Player player, int number) {
		final File file = new File("plugins/Multifonction", "/pvp.yml");
		final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		configuration.set("players." + player.getUniqueId().toString() + ".kills", number);
		fin(file, configuration);
	}
	public static boolean getDeaths(Player player) {
		final File file = new File("plugins/Multifonction", "/pvp.yml");
		final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		final ConfigurationSection configurationSection = configuration.getConfigurationSection("players." + player.getUniqueId().toString());
		return configurationSection.getBoolean("deaths");
	}
	public static void setDeaths(Player player, int number) {
		final File file = new File("plugins/Multifonction", "/pvp.yml");
		final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		configuration.set("players." + player.getUniqueId().toString() + ".deaths", number);
		fin(file, configuration);
	}
	
	public static List<Player> getPVPPlayers() {
		final File file = new File("plugins/Multifonction", "/pvp.yml");
		final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		@SuppressWarnings("unused")
		final ConfigurationSection configurationSection = configuration.getConfigurationSection("players");
		List<String> PVPPlayers = new ArrayList<String>();
		
		int in = 0;
		for (String key : configuration.getKeys(true)) { // cette boucle récupère toutes les clés
			if (in == 0) {
				in++;
				continue;
			}
			
			String[] mots = key.split("\\."); // on crée un tableau qui contiendra toutes les parties de la clé
			String fin = mots[1]; // on récupère l'UUID du joueur
			if(!mots[0].equals("players")) {
				break;
			}

			int verif = 0;
			if (PVPPlayers.contains("init")) {
				PVPPlayers.set(0, fin);

			} else {
				for (int i = 0; i < PVPPlayers.size(); i++) {
					if (PVPPlayers.get(i).contains(fin)) {
						verif++;
					}

				}

				if (verif < 1) {
					PVPPlayers.add(fin);
				}

			}

		}
		List<Player> listToReturn = new ArrayList<Player>();
		for(int i = 0; i < PVPPlayers.size(); i ++) {
			listToReturn.add(Bukkit.getPlayer(PVPPlayers.get(i)));
		}
		return listToReturn;
	}
	
}
