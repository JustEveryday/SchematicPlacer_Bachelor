package niklas.schematicplacer;

import com.fasterxml.jackson.databind.util.ISO8601Utils;

import java.util.ArrayList;

import static niklas.schematicplacer.JSONReader.*;



public class Positions {
    /*public static void main(String[] args) {


        Long width = getWidth();
        Long height = getHeight();
        Long length = getLength();
        ArrayList data = getData();
        ArrayList offset = getOffset();


        int index = 0;

        for (int y = 0; y < height; y++) {
            for (int z = 0; z < length; z++) {
                for (int x = 0; x < width; x++) {
                    Long blockId = (Long) data.get(index++);
                    if (blockId != 0) { // Nur nicht-leere Blöcke (Luft ist 0)

                        // Blockname aus Palette holen
                        //String blockName = palette.getString(blockId);

                        // Koordinaten unter Berücksichtigung von Origin und Offset berechnen
                        Long worldX = (Long) offset.get(0) + x;
                        Long worldY = (Long) offset.get(1) + y;
                        Long worldZ = (Long) offset.get(2) + z;

                        System.out.println(String.format(
                                "Block:  an Position (%d, %d, %d)", worldX, worldY, worldZ
                        ));
                    }
                }
            }
        }
        System.out.println(index);
        System.out.println(data.size());
    }*/
    public static ArrayList getPositions() {
        ArrayList<ArrayList> positions = new ArrayList<>();

        int width = getWidth();
        int height = getHeight();
        int length = getLength();
        ArrayList data = getData();
        ArrayList offset = getOffset();


        int index = 0;

        for (int y = 0; y < height; y++) {
            for (int z = 0; z < length; z++) {
                for (int x = 0; x < width; x++) {
                    Long blockId = (Long) data.get(index++);
                    if (blockId != 0) { // Nur nicht-leere Blöcke (Luft ist 0)

                        // Blockname aus Palette holen
                        //String blockName = palette.getString(blockId);

                        // Koordinaten unter Berücksichtigung von Origin und Offset berechnen
                        Long worldX = (Long) offset.get(0) + x;
                        Long worldY = (Long) offset.get(1) + y;
                        Long worldZ = (Long) offset.get(2) + z;
                        ArrayList<Long> position = new ArrayList<>();
                        position.add(worldX);
                        position.add(worldY);
                        position.add(worldZ);
                        positions.add(position);
                    }
                }
            }
        }
        return positions;
    }
}
