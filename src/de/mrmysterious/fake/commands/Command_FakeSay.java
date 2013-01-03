package de.mrmysterious.fake.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_FakeSay implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) 
	{
		Player playerSender;
		Player playerTarget;
		
		String message = "";
		
		if(arg0 instanceof Player)
		{
			playerSender = (Player) arg0;
			
			if(playerSender.hasPermission("fake.fakesay") || playerSender.isOp())
			{
				if(arg3.length == 0)
				{
					playerSender.sendMessage("§cError. Usage: /Fakesay <Username> <Message>");
				}
				else
				{
					if(Bukkit.getPlayer(arg3[0]) != null)
					{
						playerTarget = Bukkit.getPlayer(arg3[0]);
						
						message += String.format("%s§r: ", playerTarget.getDisplayName());
					}
					else
					{
						message += String.format("%s§r: ", arg3[0]);
					}
					
					for(int x = 1; x < arg3.length; x++)
					{
						message += String.format("%s ", arg3[x]);
					}
					
					message = message.replace('&', '§');
					
					Bukkit.broadcastMessage(message);
				}
			}
			else
			{
				playerSender.sendMessage("§cError. You don't have access to that command.");
			}
		}
		
		return true;
	}
}
