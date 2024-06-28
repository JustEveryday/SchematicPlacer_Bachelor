package niklas.schematicplacer;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.*;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.block.data.type.Bed;
import org.bukkit.block.data.type.Chest;
import org.bukkit.block.data.type.Door;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.block.BlockFace;

import java.util.Map;

public class BlockProperties {
    public static void setBlockProperties(BlockData blockData, Map<String, Object> properties) {
        properties.forEach((key, value) -> {
            System.out.println("Setting property: " + key + " to " + value);
            switch (key) {
                case "axis":
                    if (blockData instanceof Orientable && value instanceof String) {
                        ((Orientable) blockData).setAxis(Axis.valueOf(((String) value).toUpperCase()));
                    }
                    break;
                case "facing":
                    if (blockData instanceof Directional && value instanceof String) {
                        BlockFace facing = BlockFace.valueOf(((String) value).toUpperCase());
                        ((Directional) blockData).setFacing(facing);
                    }
                    break;
                case "half":
                    if (blockData instanceof Bisected && value instanceof String) {
                        ((Bisected) blockData).setHalf(Bisected.Half.valueOf(((String) value).toUpperCase()));
                    }
                    break;
                case "waterlogged":
                    if (blockData instanceof Waterlogged && value instanceof Boolean) {
                        ((Waterlogged) blockData).setWaterlogged((Boolean) value);
                    }
                    break;
                case "shape":
                    if (blockData instanceof Stairs && value instanceof Stairs.Shape) {
                        ((Stairs) blockData).setShape((Stairs.Shape) value);
                    }
                    break;
                case "part":
                    if (blockData instanceof Bed && value instanceof Bed.Part) {
                        ((Bed) blockData).setPart((Bed.Part) value);
                    }
                    break;
                case "occupied":
                    break;
                case "type":
                    if (blockData instanceof Chest && value instanceof Chest.Type) {
                        ((Chest) blockData).setType((Chest.Type) value);
                    }
                    break;
                case "hinge":
                    if (blockData instanceof Door && value instanceof Door.Hinge) {
                        ((Door) blockData).setHinge((Door.Hinge) value);
                    }
                    break;

                case "open":
                    if (blockData instanceof Door && value instanceof Boolean) {
                        ((Door) blockData).setOpen((Boolean) value);
                    }
                    break;
                default:
                    System.err.println("Unbekannte Eigenschaft: " + key);
            }
        });
        System.out.println("----Block hoffentlich richtig----");
    }

}
