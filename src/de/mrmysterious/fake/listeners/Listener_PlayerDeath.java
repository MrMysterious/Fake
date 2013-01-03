package de.mrmysterious.fake.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.mrmysterious.fake.Fake;

public class Listener_PlayerDeath implements Listener
{
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent arg0)
	{
		Player playerEvent = arg0.getEntity();
		
		if(Fake.getHiddenPlayers().contains(playerEvent.getName()))
		{
			arg0.setDeathMessage("");
		}
	}
}