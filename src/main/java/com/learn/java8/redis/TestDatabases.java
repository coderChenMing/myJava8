package com.learn.java8.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.util.SafeEncoder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestDatabases {
    public static void main(String[] args) throws Exception {
        Jedis jedis = new Jedis("10.4.123.133", 6379);
        jedis.auth("123456");
        //getDBNum(jedis);
        //getDBNames(jedis);
        //getDBNames2(jedis);
        //getKeys(jedis);
        //getKeys2(jedis);
        /*jedis.hset("myHash", "field1", "value1");
        jedis.hset("myHash", "field2", "value2");
        String fieldValue = jedis.hget("myHash", "field1");
        System.out.println(fieldValue);*/
       /* jedis.lpush("myList", "element1");
        jedis.lpush("myList", "element2");
        List<String> elements = jedis.lrange("myList", 0, -1);
        System.out.println(elements);*/
        //jedis.publish("myChannel", "Hello, Redis!");
        //jedis.set("name", "zhangsan");
        // 添加数据到Set
        /*String setName = "exampleSet";
        jedis.sadd(setName, "value1");
        jedis.sadd(setName, "value2");
        jedis.sadd(setName, "value3");
        // 获取Set中的所有元素
        System.out.println("Set elements: " + jedis.smembers(setName));*/
        /*// 添加数据到ZSet
        String zsetName = "exampleZSet";
        jedis.zadd(zsetName, 1.0, "value1");
        jedis.zadd(zsetName, 2.0, "value2");
        jedis.zadd(zsetName, 3.0, "value3");

        // 获取ZSet中的所有元素
        Set<String> zsetElements = jedis.zrange(zsetName, 0, -1);
        System.out.println("ZSet elements: " + zsetElements);

        // 获取ZSet中的元素及其分数
        Set<Tuple> zsetElementsWithScores = jedis.zrangeWithScores(zsetName, 0, -1);
        System.out.println("ZSet elements with scores: " + zsetElementsWithScores);*/

        String response = jedis.bgsave();
        System.out.println("Background save in progress: " + response);
        //getKeysByDb(jedis);
        //getAllKeyValue(jedis);
        //getAllKeyValueByType(jedis);
        //getKeyType(jedis);
        jedis.close();

    }

    private static void getKeyType(Jedis jedis) {
        // 设置一个字符串类型的 key
        jedis.set("myKey", "Hello, Jedis!");
        // 获取 key 的类型
        String keyType = jedis.type("myHash");
        // 打印 key 类型
        System.out.println("Type of 'myHash': " + keyType);
    }

    public static void getAllKeyValueByType(Jedis jedis) {
        jedis.select(0);
        // 定义要查找的数据类型
        //String targetType = "string"; // 可以是 "string", "hash", "list", "set", "zset" 等
        // 使用SCAN命令遍历所有键
        String cursor = "0";
        ScanParams scanParams = new ScanParams().count(100); // 适当设置count以减小每次扫描的数量
        do {
            ScanResult<String> scanResult = jedis.scan(cursor, scanParams);
            List<String> keys = scanResult.getResult();
            // 遍历每个键，获取数据类型并打印值
            for (String key : keys) {
                String keyType = jedis.type(key);
                //if (keyType.equals(targetType)) {
                // 根据键的数据类型获取值
                Object value = getValueByType(jedis, key, keyType);
                System.out.println("Key: " + key + ", Type: " + keyType + ", Value: " + value);
                //}
            }
            // 更新游标
            cursor = scanResult.getCursor();
        } while (!cursor.equals("0"));
    }

    private static Object getValueByType(Jedis jedis, String key, String keyType) {
        switch (keyType) {
            case "string":
                return jedis.get(key);
            case "hash":
                // 实现获取哈希表值的逻辑
                return jedis.hgetAll(key);
            // ...
            //break;
            case "list":
                // 实现获取列表值的逻辑
                // ...
                return jedis.lrange(key, 0, -1);
            //break;
            case "set":
                // 实现获取列表值的逻辑
                // ...
                return jedis.smembers(key);
            case "zset":
                // 实现获取列表值的逻辑
                // ...
                Map<String, Object> map = new HashMap<>();
                Set<Tuple> tuples = jedis.zrangeWithScores(key, 0, -1);
                tuples.forEach(tuple -> {
                    map.put(SafeEncoder.encode(tuple.getBinaryElement()), tuple.getScore());
                });
                System.out.println(tuples);
                System.out.println(map);
                return jedis.zrangeWithScores(key,0,-1);
            // 其他数据类型的处理
            // ...
        }
        return null;
    }

    public static void getDBNum(Jedis jedis) {
        List<String> config = jedis.configGet("databases");
        System.out.println(config);
        String numberOfDatabases = config.get(1); // The value is at index 1 in the list.
        System.out.println("Number of Databases: " + numberOfDatabases);
    }

    public static void getDBNames(Jedis jedis) {
        for (int databaseIndex = 0; databaseIndex < 16; databaseIndex++) {
            jedis.select(databaseIndex);
            // Assuming you've set a name for the database using a key, retrieve it.
            String databaseName = jedis.get("database_name");
            if (databaseName != null) {
                System.out.println("Database " + databaseIndex + " Name: " + databaseName);
            } else {
                System.out.println("Database " + databaseIndex + " Name not set.");
            }
        }
    }

    public static void getDBNames2(Jedis jedis) {
        // Send the CONFIG GET command to get the number of databases
        String configResult = jedis.configGet("databases").get(1);
        // Parse the result to get the number of databases
        int numberOfDatabases = Integer.parseInt(configResult);
        // Print the names of all databases
        for (int i = 0; i < numberOfDatabases; i++) {
            System.out.println("Database " + i + ": " + jedis.select(i));
        }
    }

    public static void getKeys(Jedis jedis) throws Exception {
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println("Key: " + new String(key.getBytes(), StandardCharsets.UTF_8));
        }
    }

    public static void getKeys2(Jedis jedis) throws UnsupportedEncodingException {
        // Specify the correct character encoding explicitly
        String charset = StandardCharsets.UTF_8.toString();
        // Retrieve the keys and handle character encoding
        Set<byte[]> keysBytes = jedis.keys("*".getBytes(StandardCharsets.ISO_8859_1));
        for (byte[] keyBytes : keysBytes) {
            String key = new String(keyBytes, charset);
            System.out.println("Key: " + key);
        }
    }

    public static void getKeysByDb(Jedis jedis) {
        // 选择指定的数据库
        jedis.select(0); // 0是数据库的索引，可以根据实际情况修改
        // 获取所有Key
        List<String> keys = scanAllKeys(jedis);
        // 打印所有Key
        for (String key : keys) {
            System.out.println("Key: " + key);
        }
    }

    private static Set<String> getAllKeys(Jedis jedis) {
        // 使用SCAN命令来迭代获取所有Key
        String cursor = "0";
        ScanParams scanParams = new ScanParams().count(100); // 每次迭代返回100个Key
        Set<String> keys = jedis.keys("*"); // 通过KEYS命令获取所有Key，不推荐在生产环境使用
        return keys;
    }

    private static List<String> scanAllKeys(Jedis jedis) {
        // 初始化游标
        String cursor = "0";
        ScanParams scanParams = new ScanParams().count(100);
        // 每次迭代返回100个Key
        List<String> keys = jedis.scan(cursor, scanParams).getResult();
        // 继续迭代直到游标为0
        while (!cursor.equals("0")) {
            keys.addAll(jedis.scan(cursor, scanParams).getResult());
        }
        return keys;
    }

    public static void getAllKeyValue(Jedis jedis) {
        // 获取所有键
        Set<String> keys = jedis.keys("*");
        // 转换为数组
        String[] keyArray = keys.toArray(new String[keys.size()]);
        // 获取所有键对应的值
        List<String> values = jedis.mget(keyArray);
        // 打印键值对
        for (int i = 0; i < keys.size(); i++) {
            System.out.println("Key: " + keyArray[i] + ", Value: " + values.get(i));
        }
    }
}
