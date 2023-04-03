package org.devschool.modules.customEvent;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CustomEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean isCancelled;

    private Block block;
    private Location location;
    private BlockData blockData;

    public CustomEvent(Block block, Location location, BlockData blockData) {
        this.isCancelled = false;
        this.block = block;
        this.location = location;
        this.blockData = blockData;
    }

    public Block getBlock() {
        return block;
    }

    public Location getLocation() {
        return location;
    }

    public BlockData getBlockData() {
        return blockData;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.isCancelled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
