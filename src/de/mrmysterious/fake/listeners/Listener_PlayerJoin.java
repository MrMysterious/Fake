package de.mrmysterious.fake.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import de.mrmysterious.fake.Fake;

public class Listener_PlayerJoin implements Listener
{
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent arg0)
	{
		Player playerEvent = arg0.getPlayer();
		Player playerTarget;
		
		for(String x:Fake.getHiddenPlayers())
		{
			if(Bukkit.getPlayer(x) != null)
			{
				playerTarget = Bukkit.getPlayer(x);
				
				Fake.hidePlayer(x);
			}
		}
		
		if(Fake.getHiddenPlayers().contains(playerEvent.getName()))
		{
			arg0.setJoinMessage("");
			
			playerEvent.sendMessage(String.format("§7Hidden: %s", Fake.getHiddenPlayers()));
		}
	}
}