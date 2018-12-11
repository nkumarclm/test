import com.google.common.base.Splitter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class sample {

    public static void main(String args[]) {

        String pairs = "cat:01,02,03;dog:AA,BB,CC;fish:A1,A2";

        Map<String, Set<String>> pairMap = new HashMap<String, Set<String>>();

        Map<String, String> map = Splitter.on(';')
                .withKeyValueSeparator(':')
                .split(pairs);

        map.forEach((key, value) -> {
            pairMap.put(key, Splitter.on(',').splitToList(value).stream().collect(Collectors.toSet()));
        });

        pairMap.forEach((key, valueSet) ->{
            System.out.println("key: "+key);
            valueSet.forEach(value ->{
                System.out.println(value);
            });
        });

    }
}
