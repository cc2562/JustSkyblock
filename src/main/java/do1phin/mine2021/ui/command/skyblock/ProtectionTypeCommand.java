package do1phin.mine2021.ui.command.skyblock;

import cn.nukkit.command.CommandSender;
import do1phin.mine2021.ServerAgent;
import do1phin.mine2021.data.Config;
import do1phin.mine2021.skyblock.SkyBlockAgent;
import do1phin.mine2021.ui.MessageAgent;

public class ProtectionTypeCommand extends SkyblockCommand {

    public ProtectionTypeCommand(ServerAgent serverAgent, MessageAgent messageAgent, Config config, SkyBlockAgent skyBlockAgent) {
        super(config.getPluginConfig().getString("command.skyblock.protection-type-command.command"),
                config.getPluginConfig().getString("command.skyblock.protection-type-command.description"),
                config.getPluginConfig().getString("command.skyblock.protection-type-command.usage"),
                serverAgent, messageAgent, config, skyBlockAgent);
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        return false;
    }

}
