package de.mrmysterious.fake.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.mrmysterious.fake.Fake;

public class Command_Show implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) 
	{
		Player playerSender;
		Player playerTarget;
	
		if(arg0 instanceof Player)
		{
			playerSender = (Player) arg0;
		
			if(playerSender.hasPermission("fake.show") || playerSender.isOp())
			{
				if(arg3.length == 0)
				{
					Fake.showPlayer(playerSender.getName());
					
					playerSender.sendMessage("�7You are now �ashown�7.");
				}
				else
				{
					if(Bukkit.getPlayer(arg3[0]) != null)
					{
						playerTarget = Bukkit.getPlayer(arg3[0]);
						
						Fake.showPlayer(playerTarget.getName());
						
						playerSender.sendMessage(String.format("�7Player '%s' is now �ashown�7.", playerTarget.getName()));
						playerTarget.sendMessage("�7You are now �ashown�7.");
					}
				}
			}
			else
			{
				playerSender.sendMessage("�cError. You don't have access to that command.");
			}
		}
		
		return true;
	}
}