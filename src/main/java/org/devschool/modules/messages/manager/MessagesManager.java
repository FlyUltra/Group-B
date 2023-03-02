package org.devschool.modules.messages.manager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.devschool.Main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MessagesManager {

    private Main plugin;

    private HashMap<String, String> messageHashMap;
    private List<String> legacyColors = Arrays.asList("&0", "&1", "&2", "&3", "&4", "&5", "&6", "&7", "&8", "&9", "&a", "&b", "&c", "&d", "&e", "§0", "§1", "§2", "§3", "§4", "§5", "§6", "§7", "§8", "§9", "§a", "§b", "§c", "§d", "§e");
    private List<String> specialChars = Arrays.asList("&l", "&n", "&o", "&k", "&m", "§l", "§n", "§o", "§k", "§m");

    /**
     * Simple example of manager for messages without database!
     *
     * The easiest way to store messages,
     * because of the education of people only,
     * this way is much cut and easier
     *
     */
    public MessagesManager() {
        this.plugin = Main.getInstance();
        loadData();
    }

    public void loadData() {
        messageHashMap = new HashMap<>();

        addMessage("super", "&cSuper zpráva");
        addMessage("bad", "Super zpráva");
        addMessage("no_perm", "&cMáš nedostatečná oprávnění na to provést tento příkaz!");
        addMessage("success_remove", "&aÚspěšně si odstranil zprávů!");
    }

    public void removeMessage(String name) {
        getMessages().remove(name.toLowerCase());
    }

    public String removeColorsAndChars(String input) {
        for (String chars : specialChars) {
            if (!input.contains(chars)) {
                continue;
            }
            input = input.replaceAll(chars, "");
        }

        for (String colors : legacyColors) {
            if (!input.contains(colors)) {
                continue;
            }
            input = input.replaceAll(colors, "");
        }

        return input;
    }

    public void sendMessage(Player player, String msg, boolean colorize) {
        if (!colorize) {
            msg = removeColorsAndChars(msg);
            player.sendMessage(msg);
            return;
        }
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
        return;
    }

    public void addMessage(String name, String content) {
        getMessages().put(name.toLowerCase(), content);
    }

    public String getMsg(String name) {
        return messageHashMap.get(name.toLowerCase());
    }

    public HashMap<String, String> getMessages() {
        return messageHashMap;
    }
}
