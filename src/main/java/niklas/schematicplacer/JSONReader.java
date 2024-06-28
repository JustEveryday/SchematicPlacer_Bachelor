package niklas.schematicplacer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static niklas.schematicplacer.BlockConverter.parseBlockString;


public class JSONReader {
    public static JSONObject getSchem() {
        JSONParser parser = new JSONParser();
        JSONObject schem = null;
        try {
            Object objMain = parser.parse(new FileReader("C:/Users/nmpeh/Desktop/Bachelor/Fertiger Code/SchematicPlacer/src/main/java/niklas/schematicplacer/Schematic.json"));
            JSONObject jsonObject = (JSONObject) objMain;
            schem = (JSONObject) jsonObject.get("Schematic");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schem;
    }
    public static ArrayList getPalette() {
        ArrayList paletteArray = new ArrayList<>();
        JSONObject schem = getSchem();
        JSONObject blocks = (JSONObject) schem.get("Blocks");
        JSONObject palette = (JSONObject) blocks.get("Palette");

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Integer> paletteMap = new LinkedHashMap<>();
        try {
            paletteMap = mapper.readValue(palette.toString(), new TypeReference<LinkedHashMap<String, Integer>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map.Entry<String, Integer>> sortedEntries = paletteMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            String blockName = entry.getKey();
            String ss = blockName.substring(10);
            Block block2 = parseBlockString(ss);

            ArrayList<Object> sup = new ArrayList<>();
            sup.add(block2.name);
            sup.add(block2.attributes);

            paletteArray.add(sup);
        }
        return paletteArray;
    }
    public static ArrayList getData() {
        JSONObject schem = getSchem();
        JSONObject blocks = (JSONObject) schem.get("Blocks");
        JSONArray data = (JSONArray) blocks.get("Data");

        return data;
    }

    public static int getWidth() {
        JSONObject schem = getSchem();
        Long width1 = (Long) schem.get("Width");
        int width = width1.intValue();
        return width;
    }

    public static int getHeight() {
        JSONObject schem = getSchem();
        Long height1 = (Long) schem.get("Height");
        int height = height1.intValue();
        return height;
    }

    public static int getLength() {
        JSONObject schem = getSchem();
        Long length1 = (Long) schem.get("Length");
        int length = length1.intValue();
        return length;
    }

    public static ArrayList getOffset() {
        JSONObject schem = getSchem();
        JSONArray offset = (JSONArray) schem.get("Offset");
        System.out.println(offset.get(0).getClass().getName());
        return offset;
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    public static JSONObject getSchem2() {
        JSONParser parser = new JSONParser();
        JSONObject schem = null;
        try {
            Object objMain = parser.parse(new FileReader("C:/Users/nmpeh/Desktop/Bachelor/Fertiger Code/SchematicPlacer/src/main/java/niklas/schematicplacer/Schematic3.json"));
            JSONObject jsonObject = (JSONObject) objMain;
            schem = (JSONObject) jsonObject.get("Schematic");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schem;
    }
    public static ArrayList getPalette2() {
        ArrayList paletteArray = new ArrayList<>();
        JSONObject schem = getSchem2();
        JSONObject blocks = (JSONObject) schem.get("Blocks");
        JSONObject palette = (JSONObject) blocks.get("Palette");

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Integer> paletteMap = new LinkedHashMap<>();
        try {
            paletteMap = mapper.readValue(palette.toString(), new TypeReference<LinkedHashMap<String, Integer>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map.Entry<String, Integer>> sortedEntries = paletteMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            String blockName = entry.getKey();
            String ss = blockName.substring(10);
            Block block2 = parseBlockString(ss);

            ArrayList<Object> sup = new ArrayList<>();
            sup.add(block2.name);
            sup.add(block2.attributes);

            paletteArray.add(sup);
        }
        return paletteArray;
    }
    public static ArrayList getData2() {
        JSONObject schem = getSchem2();
        JSONObject blocks = (JSONObject) schem.get("Blocks");
        JSONArray data = (JSONArray) blocks.get("Data");

        return data;
    }

    public static int getWidth2() {
        JSONObject schem = getSchem2();
        Long width1 = (Long) schem.get("Width");
        int width = width1.intValue();
        return width;
    }

    public static int getHeight2() {
        JSONObject schem = getSchem2();
        Long height1 = (Long) schem.get("Height");
        int height = height1.intValue();
        return height;
    }

    public static int getLength2() {
        JSONObject schem = getSchem2();
        Long length1 = (Long) schem.get("Length");
        int length = length1.intValue();
        return length;
    }

    public static ArrayList getOffset2() {
        JSONObject schem = getSchem2();
        JSONArray offset = (JSONArray) schem.get("Offset");
        System.out.println(offset.get(0).getClass().getName());
        return offset;
    }
}
