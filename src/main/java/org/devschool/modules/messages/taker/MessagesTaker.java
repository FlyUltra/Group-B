package org.devschool.modules.messages.taker;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.devschool.Main;

import java.util.logging.Level;

public class MessagesTaker {

    private Main plugin;

    /**
     * The easiest way to store messages,
     * because of the education of people only,
     * this way is much cut and easier
     */
    public MessagesTaker() {
        this.plugin = Main.getInstance();
    }

    public void sendMessage(Player player, String nameOfMessage, boolean colorize) {
        if (nameOfMessage.isEmpty()) {
            Bukkit.getLogger().log(Level.INFO, "Message "+ nameOfMessage +" is null!");
            return;
        }

        String message = plugin.getMessagesManager().getMsg(nameOfMessage);

        if (message == null || message.isEmpty()) {
            return;
        }

        if (player == null) {
            return;
        }

        plugin.getMessagesManager().sendMessage(player, message, colorize);
    }

    public void removeMessage(Player player, String nameOfMessage) {
        if (!player.hasPermission("messages.remove") && !player.hasPermission("messages.admin")) {
            plugin.getMessagesManager().sendMessage(player, "no_perm", true);
            return;
        }

        if (nameOfMessage.isEmpty()) {
            return;
        }

        String message = plugin.getMessagesManager().getMsg(nameOfMessage);
        if (message == null || message.isEmpty()) {
            return;
        }

        plugin.getMessagesManager().removeMessage(nameOfMessage);
        plugin.getMessagesManager().sendMessage(player, "success_remove", true);
    }

}
