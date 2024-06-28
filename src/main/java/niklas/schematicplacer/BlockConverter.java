package niklas.schematicplacer;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlockConverter {

    public static Block parseBlockString(String blockString) {
        Pattern pattern = Pattern.compile("^(\\w+)(\\[.*\\])?: (\\d+)$");
        Pattern pattern1 = Pattern.compile("^(\\w+)(\\[.*\\])?");
        Matcher matcher = pattern1.matcher(blockString);

        if (matcher.find()) {
            String name = matcher.group(1);
            String attributesString = matcher.group(2);

            Map<String, Object> attributes = new HashMap<>();
            if (attributesString != null) {
                attributesString = attributesString.substring(1, attributesString.length() - 1);
                String[] attributesArray = attributesString.split(",");

                for (String attribute : attributesArray) {
                    String[] keyValue = attribute.split("=");
                    String key = keyValue[0];
                    String value = keyValue[1];

                    if (value.equals("true") || value.equals("false")) {
                        attributes.put(key, Boolean.parseBoolean(value));
                    } else {
                        try {
                            attributes.put(key, Integer.parseInt(value));
                        } catch (NumberFormatException e) {
                            attributes.put(key, value);
                        }
                    }
                }
            }
            return new Block(name, attributes);
        }
        return null;
    }
}

class Block {
    String name;
    Map<String, Object> attributes;


    public Block(String name, Map<String, Object> attributes) {
        this.name = name;
        this.attributes = attributes;

    }
}
