package wibuland.daynightgamerule;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Random;

public class DeathDropListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {

        Player player = event.getPlayer();
        World world = player.getWorld();
        long nighttick = Config.getInstance().getNightick();
        long daytick = Config.getInstance().getDaytick();
        long chance = Config.getInstance().getDropchance();

        if(world.getTime() >= daytick
                || world.getTime() <= nighttick
                && (world.getEnvironment() != World.Environment.NETHER)
                && (world.getEnvironment() != World.Environment.THE_END))
        {
            event.setKeepInventory(true);
        } else {
            if (player.hasPermission("daynightgamerule.bypass")) {
                event.setKeepInventory(true);
            }

            Random r = new Random();
            boolean keepInventory = r.nextFloat() > chance;
            event.setKeepInventory(keepInventory);
        }
    }

}
