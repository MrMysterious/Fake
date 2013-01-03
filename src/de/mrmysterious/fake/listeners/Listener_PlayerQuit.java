package de.mrmysterious.fake.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.mrmysterious.fake.Fake;

public class Listener_PlayerQuit implements Listener
{
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent arg0)
	{
		Player playerEvent = arg0.getPlayer();
		
		if(Fake.getHiddenPlayers().contains(playerEvent.getName()))
		{
			arg0.setQuitMessage("");
		}
	}
}