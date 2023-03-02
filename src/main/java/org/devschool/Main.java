package org.devschool;

import jdk.javadoc.internal.doclets.toolkit.Messages;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.devschool.modules.messages.manager.MessagesManager;
import org.devschool.modules.messages.taker.MessagesTaker;

import java.util.logging.Level;

/**
 * Because of the education of people only,
 * this way is much cut and easier
 */
public class Main extends JavaPlugin {

    // Instance for main class
    private static Main instance;

    private MessagesManager messagesManager;
    private MessagesTaker messagesTaker;
    @Override
    public void onEnable() {
        instance = this;

        messagesManager = new MessagesManager();
        messagesTaker = new MessagesTaker();

        Bukkit.getLogger().log(Level.INFO, " -<|>-<|>-<|>-<|>-<|>-<|>-<|>-<|>-<|>-");
        Bukkit.getLogger().log(Level.INFO, " ");
        Bukkit.getLogger().log(Level.INFO, " DevSchoolB (" + getDescription().getVersion() + ")");
        Bukkit.getLogger().log(Level.INFO, "   Authors: " + getDescription().getAuthors());
        Bukkit.getLogger().log(Level.INFO, "   Description: " + getDescription().getDescription());
        Bukkit.getLogger().log(Level.INFO, " ");
        Bukkit.getLogger().log(Level.INFO, " -<|>-<|>-<|>-<|>-<|>-<|>-<|>-<|>-<|>-");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().log(Level.WARNING, " -<|>-<|>-<|>-<|>-<|>-<|>-<|>-<|>-<|>-");
        Bukkit.getLogger().log(Level.WARNING, " ");
        Bukkit.getLogger().log(Level.WARNING, " DevSchoolB (" + getDescription().getVersion() + ")");
        Bukkit.getLogger().log(Level.WARNING, "   Authors: " + getDescription().getAuthors());
        Bukkit.getLogger().log(Level.WARNING, "   Description: " + getDescription().getDescription());
        Bukkit.getLogger().log(Level.WARNING, " ");
        Bukkit.getLogger().log(Level.WARNING, " -<|>-<|>-<|>-<|>-<|>-<|>-<|>-<|>-<|>-");
    }

    public static Main getInstance() {
        return instance;
    }


    public MessagesManager getMessagesManager() {
        return messagesManager;
    }

    public MessagesTaker getMessagesTaker() {
        return messagesTaker;
    }
}