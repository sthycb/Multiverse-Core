/******************************************************************************
 * Multiverse 2 Copyright (c) the Multiverse Team 2011.                       *
 * Multiverse 2 is licensed under the BSD License.                            *
 * For more information please check the README.md file included              *
 * with this project.                                                         *
 ******************************************************************************/

package com.onarandombox.MultiverseCore.commands;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.enums.Action;
import com.onarandombox.MultiverseCore.enums.AddProperties;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModifyCommand extends MultiverseCommand {

    public ModifyCommand(MultiverseCore plugin) {
        super(plugin);
        this.setName("Modify a World");
        this.setCommandUsage("/mv modify" + ChatColor.GREEN + " {set|add|remove|clear} ...");
        this.setArgRange(2, 3);
        this.addKey("mvm");
        this.addKey("mvmodify");
        this.addKey("mv modify");
        Map<String, Boolean> children = new HashMap<String, Boolean>();
        children.put("multiverse.core.modify.add", true);
        children.put("multiverse.core.modify.modify", true);
        children.put("multiverse.core.modify.clear", true);
        children.put("multiverse.core.modify.remove", true);
        Permission modify = new Permission("multiverse.core.modify", "Modify various aspects of worlds. See the help wiki for how to use this command properly. If you do not include a world, the current world will be used.", PermissionDefault.OP, children);
        this.setPermission(modify);
    }

    protected static boolean validateAction(Action action, String property) {
        if (action != Action.Set) {
            try {
                AddProperties.valueOf(property);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public void runCommand(CommandSender sender, List<String> args) {
        // This is just a place holder. The real commands are in:
        // ModifyAddCommand
        // ModifyRemoveCommand
        // ModifySetCommand
        // ModifyClearCommand
    }
}
