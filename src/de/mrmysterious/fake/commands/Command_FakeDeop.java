package de.mrmysterious.fake.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_FakeDeop implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) 
	{
		Player playerSender;
		Player playerTarget;
		
		if(arg0 instanceof Player)
		{
			playerSender = (Player) arg0;
			
			if(playerSender.hasPermission("fake.fakedeop") || playerSender.isOp())
			{
				if(arg3.length == 0)
				{
					playerSender.sendMessage("§cError. Usage: /Fakedeop <Username>");
				}
				else
				{
					if(Bukkit.getPlayer(arg3[0]) == null)
					{
						playerSender.sendMessage(String.format("§cError. Could not find user '%s'.", arg3[0]));
					}
					else
					{
						playerTarget = Bukkit.getPlayer(arg3[0]);
						
						playerSender.sendMessage(String.format("§7Player '%s' has been fake-deopped.", arg3[0]));
						playerTarget.sendMessage("§eYou are no longer OP!");
					}
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
