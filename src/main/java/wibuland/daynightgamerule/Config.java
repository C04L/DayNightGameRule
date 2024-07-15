package wibuland.daynightgamerule;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {

    public static final Config instance = new Config();

    private Config() {}

    private File file;
    private YamlConfiguration config;
    private long daytick;
    private long nighttick;
    private long dropchance;
    private String daytitle;
    private String daysubtitle;
    private String nighttitle;
    private String nightsubtile;
    private String netherTitle;
    private String netherSubtitle;
    private String theEndTitle;
    private String theEndSubtitle;

    public void save() {
        try {
            config.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Load() {
        file = new File(DayNightGameRule.getInstance().getDataFolder(), "config.yml");

        if(!(file.exists())) {
            DayNightGameRule.getInstance().saveResource("config.yml", false);
        }

        config = new YamlConfiguration();

//        try {
//            config.options().parseComments(true);
//        } catch (Throwable t) {
//            Bukkit.getConsoleSender().sendMessage("[DayNightGameRule] Comment in Config is not supported");
//        }

       try {
           config.load(file);
       } catch (Exception e) {
           e.printStackTrace();
       }

       daytick = config.getLong("DayTick");
       nighttick = config.getLong("NightTick");
       dropchance = config.getLong("DropChance");
       daytitle = config.getString("DayTitle");
       daysubtitle = config.getString("DaySubtitle");
       nighttitle = config.getString("NightTitle");
       nightsubtile = config.getString("NightSubtitle");
       netherTitle = config.getString("NetherTitle");
       netherSubtitle = config.getString("NetherSubtitle");
       theEndTitle = config.getString("TheEndTitle");
       theEndSubtitle = config.getString("TheEndSubtitle");
    }


    public long getDaytick() {
        return daytick;
    }

    public long getNightick() {
        return nighttick;
    }
    public long getDropchance() {
        return dropchance;
    }

    public String getDaytitle() {
        return daytitle.replace("&", "§");
    }

    public String getDaysubtitle() {
        return daysubtitle.replace("&", "§");
    }

    public String getNighttitle() {
        return nighttitle.replace("&", "§");
    }

    public String getNightsubtile() {
        return nightsubtile.replace("&", "§");
    }

    public String getNetherTitle() {
        return netherTitle.replace("&", "§");
    }

    public String getNetherSubtitle() {
        return netherSubtitle.replace("&", "§");
    }

    public String getTheEndTitle() {
        return theEndTitle.replace("&", "§");
    }

    public String getTheEndSubtitle() {
        return theEndSubtitle.replace("&", "§");
    }

    public static Config getInstance() {
        return instance;
    }


}
