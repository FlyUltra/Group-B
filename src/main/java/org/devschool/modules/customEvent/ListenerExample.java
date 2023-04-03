package org.devschool.modules.customEvent;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ListenerExample implements Listener {


    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.hasPermission("server.vip")) {
            event.setJoinMessage("§2+ Player");
            return;
        }

        event.setJoinMessage("+ Player");


    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        if (!block.getType().isBlock()) {
            return;
        }

        CustomEvent customEvent = new CustomEvent(block, block.getLocation(), block.getBlockData());
        Bukkit.getPluginManager().callEvent(customEvent);


    }


    // POUŽIJE DEVELOPER MIMO NÁŠ TEAM

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onCustomDataBlockFromBreak(CustomEvent event) {
        Block block = event.getBlock();
        BlockData blockData = event.getBlockData();

        System.out.println(blockData.getMaterial().toString());
    }



}
