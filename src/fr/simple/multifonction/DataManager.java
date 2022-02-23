package fr.simple.multifonction;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class DataManager {
	
	public static List<Player> freezed = new ArrayList<Player>();
	public static List<Player> PVPPlayers = FileManager.getPVPPlayers();
	public static List<Player> InPVPPlayers = new ArrayList<Player>();
	public static List<Integer> InPVPPlayersTime = new ArrayList<Integer>();
	
}
