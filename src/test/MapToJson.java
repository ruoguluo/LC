package test;

import java.util.*;

/**
 * Created by programmer on 12/7/15.
 */
public class MapToJson {

    public static void main(String[] args) {
        Map map = new HashMap<String, Object>();
        map.put("A","aaa");
        map.put("B",2.0f);

        Map subMap = new HashMap<String, Object>();
        subMap.put("C1",1);
        map.put("C",subMap);

        List aList = new ArrayList();
        aList.add("this");
        aList.add("is");
        aList.add("a");
        aList.add("list");
        aList.add(new HashMap());
        aList.add(Arrays.asList("i", "j", "k", 1, 2, 3));
        map.put("listA", aList);
        String result = convert(map);
        System.out.println(result);
    }

    private static String convert(Map<String, Object> map) {

        String result = "{";
        for (String key:map.keySet()) {
            Object value = map.get(key);
            result+=key;
            result+=":";
            result += processValue(value);
            result+=",";
        }
        if (result.length()>1) {
            result = result.substring(0, result.length() - 1);
        }
        result+="}";
        return result;
    }

    private static String processValue (Object value) {
        String result="";

         if (value instanceof Map) {
            result+=convert((Map)value);
        }else if (value instanceof List) {
            result+="[";
            List listValue = (List) value;
            for (Object item:listValue) {
                result +=processValue(item);
                result +=",";
            }
             if (result.length()>1) {
                 result = result.substring(0, result.length() - 1);
             }
            result+="]";
        }else{
             result = value.toString();
         }
        return result;
    }
}
