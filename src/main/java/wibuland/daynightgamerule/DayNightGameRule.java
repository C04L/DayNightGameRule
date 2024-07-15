package wibuland.daynightgamerule;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class DayNightGameRule extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new DeathDropListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerWorldListener(), this);
        Bukkit.getConsoleSender().sendMessage("[DayNightGameRule] Free Plugin by C04L");
        Config.getInstance().Load();


        getCommand("daynightgamerule").setExecutor(new CommandHandle());

        final Component daytitle = Component.text(Config.getInstance().getDaytitle());
        final Component daysubtitle = Component.text(Config.getInstance().getDaysubtitle());
        final Component nighttitle = Component.text(Config.getInstance().getNighttitle());
        final Component nightsubtitle = Component.text(Config.getInstance().getNightsubtile());
        final Title day = Title.title(daytitle, daysubtitle);
        final Title night = Title.title(nighttitle, nightsubtitle);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.getWorld().getTime() == Config.getInstance().getDaytick()
                            && player.getWorld().getEnvironment() != World.Environment.NETHER
                            && player.getWorld().getEnvironment() != World.Environment.THE_END) {
                        player.showTitle(day);
                    } else if (player.getWorld().getTime() == Config.getInstance().getNightick()
                            && player.getWorld().getEnvironment() != World.Environment.NETHER
                            && player.getWorld().getEnvironment() != World.Environment.THE_END) {
                        player.showTitle(night);
                    }
                }
            }
        }.runTaskTimer(this, 1L, 1L);
    }


    public static DayNightGameRule getInstance() {
        return getPlugin(DayNightGameRule.class);
    }
}
