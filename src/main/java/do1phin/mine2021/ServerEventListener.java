package do1phin.mine2021;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.level.LevelLoadEvent;
import cn.nukkit.event.player.*;

public class ServerEventListener implements Listener {

    private final ServerAgent serverAgent;
    private final String skyblockLevel;

    ServerEventListener(ServerAgent serverAgent, String skyblockLevel) {
        this.serverAgent = serverAgent;
        this.skyblockLevel = skyblockLevel;
    }

    @EventHandler
    public void onLevelLoad(LevelLoadEvent event) {
        if (event.getLevel().getName().equals(skyblockLevel)) this.serverAgent.setMainLevel(event.getLevel());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        this.serverAgent.registerPlayer(event.getPlayer());
        event.setJoinMessage("");
    }

    @EventHandler
    public void onPlayerLocallyInitialized(PlayerLocallyInitializedEvent event) {
        if (this.serverAgent.isPendingRegisterNewPlayer(event.getPlayer().getUniqueId()))
            this.serverAgent.continueRegisterNewPlayer(event.getPlayer());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        this.serverAgent.purgePlayer(event.getPlayer());
        event.setQuitMessage("");
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.setKeepInventory(this.serverAgent.isEnableInventorySave());
        event.getEntity().setExperience(event.getEntity().getExperience(), Math.max(event.getEntity().getExperienceLevel() - 1, 0));
        event.setKeepExperience(this.serverAgent.isEnableInventorySave());
        event.setDeathMessage("");
    }

    @EventHandler
    public void onPlayerAchievementAwarded(PlayerAchievementAwardedEvent event) {
        event.setCancelled();
    }

}
