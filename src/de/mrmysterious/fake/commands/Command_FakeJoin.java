package de.mrmysterious.fake.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.mrmysterious.fake.Fake;

public class Command_FakeJoin implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) 
	{
		Player playerSender;
	
		if(arg0 instanceof Player)
		{
			playerSender = (Player) arg0;
		
			if(playerSender.hasPermission("fake.fakejoin") || playerSender.isOp())
			{
				Fake.showPlayer(playerSender.getName());
				
				Bukkit.broadcastMessage(Fake.getJoinMessage().replace("%player%", playerSender.getName()));
			}
			else
			{
				playerSender.sendMessage("§cError. You don't have access to that command.");
			}
		}
		
		return true;
	}
}
