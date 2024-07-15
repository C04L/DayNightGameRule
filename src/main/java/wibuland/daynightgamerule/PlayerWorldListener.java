package wibuland.daynightgamerule;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class PlayerWorldListener implements Listener {

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();
        final Component nethertitle = Component.text(Config.getInstance().getNetherTitle());
        final Component nethersubtitle = Component.text(Config.getInstance().getNetherSubtitle());
        final Component theendtitle = Component.text(Config.getInstance().getTheEndTitle());
        final Component theendsubtitle = Component.text(Config.getInstance().getTheEndSubtitle());
        final Title nether = Title.title(nethertitle, nethersubtitle);
        final Title theend = Title.title(theendtitle, theendsubtitle);


        if (world.getEnvironment() == World.Environment.NETHER) {

            player.showTitle(nether);

        } else if (world.getEnvironment() == World.Environment.THE_END) {
            player.showTitle(theend);
        }
    }

}
