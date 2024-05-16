package com.learn.java8.yaml2java;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.*;

public class YamlUtil {
    private YamlUtil() {}

    /**
     * 将 Java 对象写到 yaml 文件
     *
     * @param object   对象
     * @param yamlPath 文件路径
     */
    public static void writeYaml(Object object, String yamlPath) {
        try {
            YamlWriter writer = new YamlWriter(new FileWriter(yamlPath));
            writer.write(object);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从 yaml 文件读取转到 Java 对象
     * @param yamlPath 文件路径
     * @param clazz    目标类.class
     * @param <T>      目标类
     * @return 目标类对象
     */
    public static <T> T readYaml(String yamlPath, Class<T> clazz) {
        try {
            YamlReader reader = new YamlReader(new FileReader(yamlPath));
            try {
                return reader.read(clazz);
            } catch (YamlException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 将yaml字符串转成类对象
     * @param yamlStr 字符串
     * @param clazz 目标类
     * @param <T> 泛型
     * @return 目标类
     */
    public static <T> T toObject(String yamlStr, Class<T> clazz){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        try {
            return mapper.readValue(yamlStr, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将类对象转yaml字符串
     * @param object 对象
     * @return yaml字符串
     */
    public static String toYaml(Object object){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        StringWriter stringWriter = new StringWriter();
        try {
            mapper.writeValue(stringWriter, object);
            return stringWriter.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * （此方法非必要）
     * json 2 yaml
     * @param jsonStr json
     * @return yaml
     * @throws JsonProcessingException Exception
     */
    public static String json2Yaml(String jsonStr) throws JsonProcessingException {
        JsonNode jsonNode = new ObjectMapper().readTree(jsonStr);
        return new YAMLMapper().writeValueAsString(jsonNode);
    }
}
