package niklas.schematicplacer;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Door;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import static niklas.schematicplacer.BlockProperties.setBlockProperties;
import static niklas.schematicplacer.JSONReader.*;
import static niklas.schematicplacer.Positions.getPositions;

public class SchematicBuilder implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        ArrayList positions = getPositions();
        Player player = (Player) commandSender;
        Location loc = player.getLocation();
        World world = player.getWorld();
        loc.setX(loc.getX() + 25);

        int schematic = 0;

        try {
            schematic = Integer.valueOf(strings[0]);
        } catch (NumberFormatException e) {
            System.out.println("Argumente sind ungültig");
            player.sendMessage("Argumente sind ungültig");
            e.printStackTrace();
            return false;
        }

        if (schematic == 1) {
            ArrayList datap = getPalette();
            int height = getHeight();
            int length = getLength();
            int width = getWidth();
            Long offset1 = (Long) getOffset().get(0);
            int offset11 = offset1.intValue();

            Long offset2 = (Long) getOffset().get(1);
            int offset22 = offset2.intValue();

            Long offset3 = (Long) getOffset().get(2);
            int offset33 = offset3.intValue();

            ArrayList data = getData();

            int index = 0;
            for (int y = 0; y < height; y++) {

                for (int z = 0; z < length; z++) {

                    for (int x = 0; x < width; x++) {

                        int actualX = (int) (loc.getX() + offset11 + x);
                        int actualY = (int) (loc.getY() + offset22 + y);
                        int actualZ = (int) (loc.getZ() + offset33 + z);

                        Long pos = (Long) data.get(index);
                        Long prüf = 21L;
                        if (pos == prüf) {
                        }

                        Material material = null;
                        Map<String, Object> properties = null;

                        int xxx = pos.intValue();
                        ArrayList hilf = (ArrayList) datap.get(xxx);
                        String mat = (String) hilf.get(0);
                        material = Material.valueOf(mat.toUpperCase());
                        properties = (Map<String, Object>) hilf.get(1);

                        Block block = world.getBlockAt(actualX, actualY, actualZ);
                        block.setType(material);

                        if (block.getBlockData() instanceof Door || block.getBlockData() instanceof Ageable) {
                        } else {
                            BlockData blockData = block.getBlockData();
                            System.out.println(properties);
                            System.out.println(material);
                            setBlockProperties(blockData, properties);
                            block.setBlockData(blockData);
                        }

                        index++;
                    }
                }

            }
/*--------------------------------------------------------------------------------------------------------------------*/
        } else if (schematic == 2) {
            ArrayList datap = getPalette2();
            int height = getHeight2();
            int length = getLength2();
            int width = getWidth2();
            Long offset1 = (Long) getOffset2().get(0);
            int offset11 = offset1.intValue();

            Long offset2 = (Long) getOffset2().get(1);
            int offset22 = offset2.intValue();

            Long offset3 = (Long) getOffset2().get(2);
            int offset33 = offset3.intValue();

            ArrayList data = getData();




            int index = 0;
            for (int y = 0; y < height; y++) {

                for (int z = 0; z < length; z++) {

                    for (int x = 0; x < width; x++) {

                        int actualX = (int) (loc.getX() + offset11 + x);
                        int actualY = (int) (loc.getY() + offset22 + y);
                        int actualZ = (int) (loc.getZ() + offset33 + z);

                        Long pos = (Long) data.get(index);
                        Long prüf = 21L;
                        if (pos == prüf) {
                        }

                        Material material = null;
                        Map<String, Object> properties = null;

                        int xxx = pos.intValue();
                        ArrayList hilf = (ArrayList) datap.get(xxx);
                        String mat = (String) hilf.get(0);
                        material = Material.valueOf(mat.toUpperCase());
                        properties = (Map<String, Object>) hilf.get(1);

                        Block block = world.getBlockAt(actualX, actualY, actualZ);
                        block.setType(material);

                        if (block.getBlockData() instanceof Door || block.getBlockData() instanceof Ageable) {
                        } else {
                            BlockData blockData = block.getBlockData();
                            System.out.println(properties);
                            System.out.println(material);
                            setBlockProperties(blockData, properties);
                            block.setBlockData(blockData);
                        }

                        index++;
                    }
                }
            }
        }
        return true;
    }
}
