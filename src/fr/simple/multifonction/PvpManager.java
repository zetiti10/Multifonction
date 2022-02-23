package fr.simple.multifonction;

public class PvpManager implements Runnable {
	@Override
	public void run() {
		if(!DataManager.InPVPPlayers.isEmpty()) {
			for(int i = 0; i < DataManager.InPVPPlayers.size(); i ++) {
				DataManager.InPVPPlayersTime.set(i, DataManager.InPVPPlayersTime.get(i) - 1);
				if(DataManager.InPVPPlayersTime.get(i) <= 0) {
					DataManager.InPVPPlayers.remove(i);
					DataManager.InPVPPlayersTime.remove(i);
				}
			}
		}
	}
}
