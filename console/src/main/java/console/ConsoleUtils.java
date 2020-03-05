package console;

import org.apache.commons.text.TextStringBuilder;

import java.util.List;
import java.util.Map;

// util class
public abstract class ConsoleUtils {

    public static void outputMap(TextStringBuilder sb, Map<String, List<String>> map) {
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            sb.appendln(entry.getKey() + ": " + entry.getValue());
        }
    }
}
