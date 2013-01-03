package de.mrmysterious.fake;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.mrmysterious.fake.commands.Command_FakeDeop;
import de.mrmysterious.fake.commands.Command_FakeJoin;
import de.mrmysterious.fake.commands.Command_FakeList;
import de.mrmysterious.fake.commands.Command_FakeOp;
import de.mrmysterious.fake.commands.Command_FakeQuit;
import de.mrmysterious.fake.commands.Command_FakeSay;
import de.mrmysterious.fake.commands.Command_Hide;
import de.mrmysterious.fake.commands.Command_Show;
import de.mrmysterious.fake.listeners.Listener_PlayerDeath;
import de.mrmysterious.fake.listeners.Listener_PlayerJoin;
import de.mrmysterious.fake.listeners.Listener_PlayerQuit;

public class Fake extends JavaPlugin
{
	private static ArrayList<String> hiddenPlayers = new ArrayList<String>();
	
	private static String messageJoin;
	private static String messageQuit;
	
	private PluginManager pluginManager;
	
	@Override
	public void onEnable()
	{
		pluginManager = Bukkit.getPluginManager();
		
		getConfig().options().copyDefaults(true);
		
		saveConfig();
		
		messageJoin = getConfig().getString("message-fakejoin");
		messageQuit = getConfig().getString("message-fakequit");
		
		pluginManager.registerEvents(new Listener_PlayerJoin(), this);
		pluginManager.registerEvents(new Listener_PlayerQuit(), this);
		pluginManager.registerEvents(new Listener_PlayerDeath(), this);
		
		getCommand("fakesay").setExecutor(new Command_FakeSay());
		getCommand("fakeop").setExecutor(new Command_FakeOp());
		getCommand("fakedeop").setExecutor(new Command_FakeDeop());
		getCommand("fakejoin").setExecutor(new Command_FakeJoin());
		getCommand("fakequit").setExecutor(new Command_FakeQuit());
		getCommand("fakelist").setExecutor(new Command_FakeList());
		getCommand("show").setExecutor(new Command_Show());
		getCommand("hide").setExecutor(new Command_Hide());
	}
	
	public static void showPlayer(String arg0)
	{
		Player playerTarget = Bukkit.getPlayerExact(arg0);
		
		if(hiddenPlayers.contains(arg0))
		{
			hiddenPlayers.remove(arg0);
		}
		
		for(Player x:Bukkit.getOnlinePlayers())
		{
			x.showPlayer(playerTarget);
		}
	}
	
	public static void hidePlayer(String arg0)
	{
		Player playerTarget = Bukkit.getPlayerExact(arg0);
		
		if(!(hiddenPlayers.contains(arg0)))
		{
			hiddenPlayers.add(arg0);
		}
		
		for(Player x:Bukkit.getOnlinePlayers())
		{
			if(!((x.hasPermission("fake.see")) || (x.isOp())))
			{
				x.hidePlayer(playerTarget);
			}
		}
	}
	
	public static ArrayList<String> getHiddenPlayers()
	{
		return hiddenPlayers;
	}
	
	public static String getJoinMessage()
	{
		return messageJoin;
	}
	
	public static String getQuitMessage()
	{
		return messageQuit;
	}
}