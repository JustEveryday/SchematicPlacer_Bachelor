package niklas.schematicplacer;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SchematicPlacer extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getCommand("Schematic").setExecutor( new SchematicBuilder());
        getServer().getPluginManager().registerEvents(this, this);

    }

    @EventHandler // Event-Handler markieren
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setGameMode(GameMode.CREATIVE);
    }

    @Override
    public void onDisable() {
    }
}
