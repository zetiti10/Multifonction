package fr.simple.multifonction;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import fr.simple.teams.TeamData;
import fr.simple.teams.assaut.Assaut;

public class Listeners implements Listener {

	private Multifonction multifonction;

	public Listeners(Multifonction multifonction) {
		this.multifonction = multifonction;
	}

	Location ruban_rouge0 = new Location(Bukkit.getWorld("world"), -176, 78, -1155);
	Location void0 = new Location(Bukkit.getWorld("world"), -176, 77, -1155);

	Location ruban_rouge1 = new Location(Bukkit.getWorld("world"), -176, 78, -1154);
	Location ruban_rouge2 = new Location(Bukkit.getWorld("world"), -176, 78, -1156);
	Location void1 = new Location(Bukkit.getWorld("world"), -176, 77, -1154);
	Location void2 = new Location(Bukkit.getWorld("world"), -176, 77, -1156);

	Location ruban_rouge3 = new Location(Bukkit.getWorld("world"), -176, 78, -1153);
	Location ruban_rouge4 = new Location(Bukkit.getWorld("world"), -176, 78, -1157);
	Location void3 = new Location(Bukkit.getWorld("world"), -176, 77, -1153);
	Location void4 = new Location(Bukkit.getWorld("world"), -176, 77, -1157);

	Location ruban_rouge5 = new Location(Bukkit.getWorld("world"), -176, 78, -1152);
	Location ruban_rouge6 = new Location(Bukkit.getWorld("world"), -176, 78, -1158);
	Location void5 = new Location(Bukkit.getWorld("world"), -176, 77, -1152);
	Location void6 = new Location(Bukkit.getWorld("world"), -176, 77, -1158);

	Location ruban_rouge7 = new Location(Bukkit.getWorld("world"), -176, 78, -1151);
	Location ruban_rouge8 = new Location(Bukkit.getWorld("world"), -176, 78, -1159);
	Location void7 = new Location(Bukkit.getWorld("world"), -176, 77, -1151);
	Location void8 = new Location(Bukkit.getWorld("world"), -176, 77, -1159);

	Location artifices = new Location(Bukkit.getWorld("world"), -170, 71, -1132);

	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		if (event.getBlock().getLocation().getX() == ruban_rouge0.getX()
				&& event.getBlock().getLocation().getY() == ruban_rouge0.getY()
				&& event.getBlock().getLocation().getZ() == ruban_rouge0.getZ()) {
			if (event.getPlayer() == Bukkit.getPlayer("zetiti10")) {
				void0.getBlock().setType(Material.AIR);
				Bukkit.getScheduler().runTaskTimer(multifonction, new Runnable() {
					int i = 1;
					@SuppressWarnings("unchecked")
					List<Player> players = (List<Player>) Bukkit.getOnlinePlayers();

					@Override
					public void run() {
						switch (i) {
						case 1:
							ruban_rouge1.getBlock().setType(Material.AIR);
							ruban_rouge2.getBlock().setType(Material.AIR);
							void1.getBlock().setType(Material.AIR);
							void2.getBlock().setType(Material.AIR);
							break;
						case 2:
							ruban_rouge3.getBlock().setType(Material.AIR);
							ruban_rouge4.getBlock().setType(Material.AIR);
							void3.getBlock().setType(Material.AIR);
							void4.getBlock().setType(Material.AIR);
							break;
						case 3:
							ruban_rouge3.getBlock().setType(Material.AIR);
							ruban_rouge4.getBlock().setType(Material.AIR);
							void3.getBlock().setType(Material.AIR);
							void4.getBlock().setType(Material.AIR);
							break;
						case 4:
							ruban_rouge5.getBlock().setType(Material.AIR);
							ruban_rouge6.getBlock().setType(Material.AIR);
							void5.getBlock().setType(Material.AIR);
							void6.getBlock().setType(Material.AIR);
							break;
						case 5:
							ruban_rouge7.getBlock().setType(Material.AIR);
							ruban_rouge8.getBlock().setType(Material.AIR);
							void7.getBlock().setType(Material.AIR);
							void8.getBlock().setType(Material.AIR);
							break;
						case 6:
							Bukkit.broadcastMessage(
									"§bSimple est ouvert ! §9Après plus d'un an de développement, le serveur est enfin ouvert. Vous pouvez commencer dès maintenant votre survie !");
							for (int i = 0; i < players.size(); i++) {
								players.get(i).playSound(players.get(i).getLocation(),
										Sound.UI_TOAST_CHALLENGE_COMPLETE, 1, 1);
								players.get(i).sendTitle("§bSimple est ... ouvert !",
										"§9Vous pouvez commencer votre aventure dès maintenant !", 20, 20 * 5, 20);
								artifices.getBlock().setType(Material.REDSTONE_BLOCK);
							}
							break;
						default:
							break;
						}
						i++;
						for (int i = 0; i < players.size(); i++) {
							players.get(i).playSound(players.get(i).getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
						}
					}
				}, 20 * 1L, 15L);

				Bukkit.getScheduler().runTaskTimer(multifonction, new Runnable() {
					long i = 0L;

					@Override
					public void run() {
						Bukkit.getWorld("world").setTime(i);
						i = i + 50L;
						if (i == 20000L) {
							Bukkit.getWorld("world").setGameRule(GameRule.DO_DAYLIGHT_CYCLE, true);
							Bukkit.getWorld("world").setGameRule(GameRule.DO_WEATHER_CYCLE, true);
							Bukkit.getScheduler().cancelTasks(multifonction);
						}
					}
				}, 1L, 1L);

				/*
				 * Bukkit.getScheduler().runTaskLater(multifonction, new Runnable() {
				 * 
				 * @Override public void run() {
				 * 
				 * } }, 20 * 1L);
				 */

			} else {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		if (!event.getPlayer().hasPlayedBefore()) {
			FileManager.createPVPAccount(event.getPlayer());
			Bukkit.broadcastMessage("§eSimplebot §8» §9Bienvenue à §b" + event.getPlayer().getName() + " §9sur Simple ! Il se connecte pour la première fois !");
		}
	}

	@EventHandler
	public void onTP(PlayerTeleportEvent event) {
		if (!DataManager.InPVPPlayers.isEmpty()) {
			for (int i = 0; i < DataManager.InPVPPlayers.size(); i++) {
				if (DataManager.InPVPPlayers.get(i) == event.getPlayer()) {
					if (!(event.getCause() == TeleportCause.CHORUS_FRUIT)
							|| !(event.getCause() == TeleportCause.END_GATEWAY)
							|| !(event.getCause() == TeleportCause.END_PORTAL)
							|| !(event.getCause() == TeleportCause.ENDER_PEARL)
							|| !(event.getCause() == TeleportCause.NETHER_PORTAL)) {
						event.getPlayer()
								.sendMessage(multifonction.prefix + "§cVous ne pouvez pas vous téléporter en PVP.");
						event.setCancelled(true);
					}
				}
			}
			return;
		}
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		if (!DataManager.InPVPPlayers.isEmpty()) {
			for (int i = 0; i < DataManager.InPVPPlayers.size(); i++) {
				if (DataManager.InPVPPlayers.get(i) == event.getEntity()) {
					DataManager.InPVPPlayers.remove(i);
					DataManager.InPVPPlayersTime.remove(i);
				}
			}
			return;
		}
	}

	@EventHandler
	public void onDisconnect(PlayerQuitEvent event) {
		if (!DataManager.InPVPPlayers.isEmpty()) {
			for (int i = 0; i < DataManager.InPVPPlayers.size(); i++) {
				if (DataManager.InPVPPlayers.get(i) == event.getPlayer()) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "discord broadcast #「💭」discutions **ALERTE** "
							+ event.getPlayer().getName() + " s'est déconnecté alors qu'il était en PVP.");
				}
			}
			return;
		}
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPVP(EntityDamageByEntityEvent event) {
		if (!event.isCancelled()) {
			if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
				String playerTeam = TeamData.getPlayerTeam(event.getEntity().getUniqueId());
				if (!playerTeam.equals("null")) {
					List<String> teamsInFight = Assaut.teamsInFight2;
					for (int i = 0; i < teamsInFight.size(); i++) {
						String current = teamsInFight.get(i);
						String[] words = current.split("\\s+");
						String attaquants = words[1];
						String défenceurs = words[2];
						if (playerTeam.equals(attaquants) || playerTeam.equals(défenceurs)) {
							String damagerTeam = TeamData.getPlayerTeam(event.getDamager().getUniqueId());
							if (!damagerTeam.equals("null")) {
								for (int j = 0; j < teamsInFight.size(); j++) {
									String current1 = teamsInFight.get(j);
									String[] words1 = current1.split("\\s+");
									String attaquants1 = words1[1];
									String défenceurs1 = words1[2];
									if (playerTeam.equals(attaquants1) || playerTeam.equals(défenceurs1)) {
										return;
									}
								}
							}
						}
						event.setCancelled(true);
						event.getDamager().sendMessage(multifonction.prefix + "§cCe joueur est en assaut.");
					}
				}

				String damagerTeam = TeamData.getPlayerTeam(event.getDamager().getUniqueId());
				if (!damagerTeam.equals("null")) {
					List<String> teamsInFight = Assaut.teamsInFight2;
					for (int j = 0; j < teamsInFight.size(); j++) {
						String current1 = teamsInFight.get(j);
						String[] words1 = current1.split("\\s+");
						String attaquants1 = words1[1];
						String défenceurs1 = words1[2];
						if (playerTeam.equals(attaquants1) || playerTeam.equals(défenceurs1)) {
							event.getDamager()
									.sendMessage(multifonction.prefix + "§cCe joueur n'est pas dans la team adverse.");
						}
					}
				}

				if (!FileManager.isPVPEnabled((Player) event.getDamager())) {
					event.getDamager().sendMessage(multifonction.prefix + "§cVous n'avez pas le PVP d'activé.");
					event.setCancelled(true);
					return;
				}
				if (!FileManager.isPVPEnabled((Player) event.getEntity())) {
					event.getDamager().sendMessage(multifonction.prefix + "§cCe joueur n'a pas le PVP d'activé.");
					event.setCancelled(true);
					return;
				}
				if (!DataManager.InPVPPlayers.isEmpty()) {
					for (int i = 0; i < DataManager.InPVPPlayers.size(); i++) {
						if (DataManager.InPVPPlayers.get(i) == event.getDamager()) {
							DataManager.InPVPPlayersTime.set(i, 30);
						}
						if (DataManager.InPVPPlayers.get(i) == event.getEntity()) {
							DataManager.InPVPPlayersTime.set(i, 30);
						}
					}
					return;
				}
				DataManager.InPVPPlayers.add((Player) event.getEntity());
				DataManager.InPVPPlayersTime.add(30);
				DataManager.InPVPPlayers.add((Player) event.getDamager());
				DataManager.InPVPPlayersTime.add(30);
			} else if (event.getEntity() instanceof Player && event.getCause() == DamageCause.PROJECTILE) {
				Projectile proj = (Projectile) event.getDamager();
				if (proj.getShooter() instanceof Player) {
					Player damager = (Player) proj.getShooter();
					String playerTeam = TeamData.getPlayerTeam(event.getEntity().getUniqueId());
					if (!playerTeam.equals("null")) {
						List<String> teamsInFight = Assaut.teamsInFight2;
						for (int i = 0; i < teamsInFight.size(); i++) {
							String current = teamsInFight.get(i);
							String[] words = current.split("\\s+");
							String attaquants = words[1];
							String défenceurs = words[2];
							if (playerTeam.equals(attaquants) || playerTeam.equals(défenceurs)) {
								///////////////////////////////////////////////////////////////////
								String damagerTeam = TeamData.getPlayerTeam(damager.getUniqueId());
								if (!damagerTeam.equals("null")) {
									for (int j = 0; j < teamsInFight.size(); j++) {
										String current1 = teamsInFight.get(j);
										String[] words1 = current1.split("\\s+");
										String attaquants1 = words1[1];
										String défenceurs1 = words1[2];
										if (playerTeam.equals(attaquants1) || playerTeam.equals(défenceurs1)) {
											return;
										}
									}
								}
							}
							event.setCancelled(true);
							damager.sendMessage(multifonction.prefix + "§cCe joueur est en assaut.");
						}
					}

					String damagerTeam = TeamData.getPlayerTeam(damager.getUniqueId());
					if (!damagerTeam.equals("null")) {
						List<String> teamsInFight = Assaut.teamsInFight2;
						for (int j = 0; j < teamsInFight.size(); j++) {
							String current1 = teamsInFight.get(j);
							String[] words1 = current1.split("\\s+");
							String attaquants1 = words1[1];
							String défenceurs1 = words1[2];
							if (playerTeam.equals(attaquants1) || playerTeam.equals(défenceurs1)) {
								damager.sendMessage(
										multifonction.prefix + "§cCe joueur n'est pas dans la team adverse.");
							}
						}
					}

					if (!FileManager.isPVPEnabled((Player) damager)) {
						damager.sendMessage(multifonction.prefix + "§cVous n'avez pas le PVP d'activé.");
						event.setCancelled(true);
						return;
					}
					if (!FileManager.isPVPEnabled((Player) event.getEntity())) {
						damager.sendMessage(multifonction.prefix + "§cCe joueur n'a pas le PVP d'activé.");
						event.setCancelled(true);
						return;
					}
					if (!DataManager.InPVPPlayers.isEmpty()) {
						for (int i = 0; i < DataManager.InPVPPlayers.size(); i++) {
							if (DataManager.InPVPPlayers.get(i) == damager) {
								DataManager.InPVPPlayersTime.set(i, 30);
							}
							if (DataManager.InPVPPlayers.get(i) == damager) {
								DataManager.InPVPPlayersTime.set(i, 30);
							}
						}
						return;
					}
					DataManager.InPVPPlayers.add((Player) damager);
					DataManager.InPVPPlayersTime.add(30);
					DataManager.InPVPPlayers.add((Player) damager);
					DataManager.InPVPPlayersTime.add(30);
				}
			}
		}
	}

	@EventHandler
	public void Move(PlayerMoveEvent event) {
		List<Player> freezed = DataManager.freezed;
		if (!freezed.isEmpty()) {
			for (int i = 0; i < freezed.size(); i++) {
				if (freezed.get(i).getName().equals(event.getPlayer().getName())) {
					event.setCancelled(true);
				}
			}
		}
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		if (event.getItemInHand() != null) {
			if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				List<String> list = event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).endsWith("Simple, la monaie")) {
						event.setCancelled(true);
						break;
					}
				}
			}
		}
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		if (event.getMessage().matches("(.*)@(.*)")) {
			String player = "null";
			for (int i = 0; i < event.getMessage().length(); i++) {
				if (event.getMessage().charAt(i) == '@') {
					i++;
					player = String.valueOf(event.getMessage().charAt(i));
					for (int j = i; j < 256; j++) {
						try {
							if (event.getMessage().charAt(j) == ' ') {
								break;
							} else {
								if (i != j) {
									player = player.concat(String.valueOf(event.getMessage().charAt(j)));
								}
							}
						} catch (IndexOutOfBoundsException error) {
						}

					}
					@SuppressWarnings("unchecked")
					List<Player> players = (List<Player>) Bukkit.getOnlinePlayers();
					if (player.equals("everyone") || player.equals("here") || player.equals("all")) {
						for (int j = 0; j < players.size(); j++) {
							players.get(j).playSound(players.get(j).getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
						}
						return;
					}
					for (int j = 0; j < players.size(); j++) {
						if (players.get(j).getDisplayName().startsWith(player)) {
							players.get(j).playSound(players.get(j).getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
						}
					}
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPreprocess(PlayerCommandPreprocessEvent event) {
		String command = event.getMessage();
		if (command.startsWith("/minecraft:kill")) {
			if (command.charAt(16) == '@' && (command.charAt(17) == 'e' || command.charAt(17) == 'a')) {
				event.setCancelled(true);
				event.getPlayer().sendMessage(multifonction.prefix + "§cCETTE COMMANDE EST BLOQUEE !");
			}
		} else if (command.startsWith("/kill")) {
			if (command.charAt(6) == '@' && (command.charAt(7) == 'e' || command.charAt(7) == 'a')) {
				event.setCancelled(true);
				event.getPlayer().sendMessage(multifonction.prefix + "§cCETTE COMMANDE EST BLOQUEE !");
			}
		} else if (command.startsWith("/seed") || command.startsWith("/minecraft:seed") || command.startsWith("/deop")
				|| command.startsWith("/minecraft:deop") || command.startsWith("/op")
				|| command.startsWith("/minecraft:op") || command.startsWith("/reload")
				|| command.startsWith("/minecraft:reload")) {
			if (!event.getPlayer().getName().equals("zetiti10")) {
				event.setCancelled(true);
				event.getPlayer().kickPlayer("§cCETTE COMMANDE EST STRICTEMENT INTERDITE D'UTILISATION !");
			}
		}
	}
}
