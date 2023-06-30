// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MySql {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new LinkedHashMap<>();
        myMap(map);
        System.out.println(getCondition(map));
    }

    //считывает строку из файла и записывает в карту HashMap
    public static void myMap(HashMap<String, String> map) {
        String dataFile = "Sql_query.txt";
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(dataFile));
            String line;
            {
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(":", 2);
                    if (parts.length >= 2) {
                        String key = parts[0];
                        String value = parts[1];
                        map.put(key, value);
                    } else {
                        System.out.println("ignoring line: " + line);
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // формируем строку StringBuilder.
    // (( не удается избавиться от нулевого значения ((
    public static StringBuilder getCondition(HashMap<String, String> params) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null) {
                result.append(pair.getKey()).append(" :'").append(pair.getValue());
            }
        }
        return result;
    }
}



