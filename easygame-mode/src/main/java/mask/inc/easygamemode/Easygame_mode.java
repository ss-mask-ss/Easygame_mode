package mask.lab.easygamemode;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Easygame_mode extends JavaPlugin {

    @Override
    public void onEnable() {
        // プラグインの有効化時の処理
        getLogger().info("Easygame_modeプラグインが有効になりました。");
    }

    @Override
    public void onDisable() {
        // プラグインの無効化時の処理
        getLogger().info("Easygame_modeプラグインが無効になりました。");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mode")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("プレイヤーからのみ実行できます。");
                return true;
            }

            Player player = (Player) sender;

            if (!player.isOp()) {
                player.sendMessage("このコマンドを実行する権限がありません。");
                return true;
            }

            if (args.length < 1) {
                return false;
            }

            GameMode gameMode;
            switch (args[0].toLowerCase()) {
                case "s":
                    gameMode = GameMode.SURVIVAL;
                    break;
                case "a":
                    gameMode = GameMode.ADVENTURE;
                    break;
                case "c":
                    gameMode = GameMode.CREATIVE;
                    break;
                case "spec":
                    gameMode = GameMode.SPECTATOR;
                    break;
                default:
                    return false;
            }

            player.setGameMode(gameMode);
            player.sendMessage("ゲームモードを " + gameMode.name() + " に変更しました。");
            return true;
        }

        return false;
    }
}
