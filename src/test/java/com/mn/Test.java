package com.mn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mn.model.dto.Group;
import com.mn.model.dto.GroupUser;
import com.mn.model.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author mengna
 * @date 2020/11/28 13:22
 */
@SpringBootTest
@ActiveProfiles("dev")
@Slf4j
public class Test {

    /**
     * 上手
     */
    @org.junit.jupiter.api.Test
    public void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setId(100);
        user.setName("zhangsan");
        user.setDescription("张三喜欢编程");
        user.setMobile("18812344321");
        String jsonStr = objectMapper.writeValueAsString(user);
        System.out.println("Java对象转换为Json字符串:\n" + jsonStr);
        User object = objectMapper.readValue(jsonStr, User.class);
        System.out.println("Json字符串转换为Java对象:\n" + object);
    }


    /**
     * writeValueAsString
     */
    @org.junit.jupiter.api.Test
    public void test1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setId(100);
        user.setName("zhangsan");
        user.setDescription("张三喜欢编程");
        user.setMobile("18812344321");
        String s = objectMapper.writeValueAsString(user);
        System.out.println("String:" + s);
    }


    /**
     * JsonGenerator-将Json写入file
     */
    @org.junit.jupiter.api.Test
    public void test2() {
        log.info("开始写入file");
        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator jsonGenerator = null;
        try {
            jsonGenerator = jsonFactory.createGenerator(new File("d:\\user.json"), JsonEncoding.UTF8);
            jsonGenerator.writeStartObject();
            {
                jsonGenerator.writeNumberField("id", 1002);
                jsonGenerator.writeStringField("name", "zhangsan");
//                jsonGenerator.writeString("我是张三");
//                jsonGenerator.writeString("我超级喜欢编程");

                jsonGenerator.writeStartArray();
                jsonGenerator.writeString("我是李四");
                jsonGenerator.writeString("我也喜欢编程");
                jsonGenerator.writeEndArray();

                jsonGenerator.writeEndObject();
                jsonGenerator.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("开始写入file");
    }

    /**
     * 简单数据绑定
     */
    @org.junit.jupiter.api.Test
    public void test3() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<>();
        User user = new User();
        user.setId(1002);
        user.setName("李四");
        user.setDescription("李四比张三更喜欢编程");
        user.setMobile("18888888888");
        int[] arr = {1, 2, 3};
        // Java对象类型
        map.put("Object类型", user);
        // String类型
        map.put("String类型", "hello");
        // Boolean类型
        map.put("Boolean类型", Boolean.FALSE);
        // 数组类型
        map.put("数组类型", arr);
        objectMapper.writeValue(new File("d:\\map.json"), map);
        map = objectMapper.readValue(new File("d:\\map.json"), map.getClass());
        System.out.println("Object类型:" + map.get("Object类型"));
        System.out.println("String类型:" + map.get("String类型"));
        System.out.println("Boolean类型:" + map.get("Boolean类型"));
        System.out.println("数组类型:" + map.get("数组类型"));
    }

    /**
     * 完整数据绑定
     *
     * @throws IOException
     */
    @org.junit.jupiter.api.Test
    public void test4() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setId(1003);
        user1.setName("王五");
        user1.setDescription("王五有点喜欢编程");
        user1.setMobile("18812344321");
        userList.add(user1);
        User user2 = new User();
        user2.setId(1004);
        user2.setName("赵六");
        user2.setDescription("赵六喜欢打篮球");
        user2.setMobile("12341234123");
        userList.add(user2);
        objectMapper.writeValue(new File("d:\\test.json"), userList);
        List list = objectMapper.readValue(new File("d:\\test.json"), List.class);
        System.out.println(list);
    }

    @org.junit.jupiter.api.Test
    public void test5() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, User> map = new HashMap<>();
        User user = new User();
        user.setId(1002);
        user.setName("李四");
        user.setDescription("李四比张三更喜欢编程");
        user.setMobile("18888888888");
        TypeReference ref = new TypeReference<Map<String, User>>() {
        };
        map.put("泛型", user);
        objectMapper.writeValue(new File("d:\\ref.json"), map);
        map = (HashMap<String, User>) objectMapper.readValue(new File("d:\\ref.json"), ref);

    }


    @org.junit.jupiter.api.Test
    public void testJsonGenerator() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File("d:\\testJsonGenerator.json"), JsonEncoding.UTF8);
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("Int", 1006);
        jsonGenerator.writeStringField("String", "Jeo");
        jsonGenerator.writeBooleanField("Boolean", false);
        jsonGenerator.writeEndObject();
        jsonGenerator.close();
        Map<String, Object> map = objectMapper.readValue(new File("d:\\testJsonGenerator.json"), Map.class);
        System.out.println("Int:" + map.get("Int"));
        System.out.println("String:" + map.get("String"));
        System.out.println("Boolean:" + map.get("Boolean"));
    }

    @org.junit.jupiter.api.Test
    public void testJsonParser() throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator jsonGenerator = null;
        jsonGenerator = jsonFactory.createGenerator(new File("d:\\testJsonParser.json"), JsonEncoding.UTF8);
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("Int", 1006);
        jsonGenerator.writeStringField("String", "Jeo");
        jsonGenerator.writeBooleanField("Boolean", false);
        jsonGenerator.writeEndObject();
        jsonGenerator.close();
        JsonParser jsonParser = jsonFactory.createParser(new File("d:\\testJsonParser.json"));
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jsonParser.getCurrentName();
            while (Objects.nonNull(fieldname)) {
                if (fieldname.equals("Int")) {
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getText());
                }
                if (fieldname.equals("String")) {
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getTextCharacters());
                }
                if (fieldname.equals("Boolean")) {
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getBooleanValue());
                }
            }
        }

    }

    @org.junit.jupiter.api.Test
    public void testJsonInclude() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setId(1000);
        user.setName("小红");
        System.out.println(objectMapper.writeValueAsString(user));
    }


    @org.junit.jupiter.api.Test
    public void testJsonTree() {
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode objectNode = factory.objectNode();
        objectNode.put("id", 111);
        objectNode.put("username", "zhangsan");
        System.out.println("objectNode:" + objectNode);
        NumericNode numberNode = factory.numberNode(99);
        System.out.println("numberNode:" + numberNode);
    }

    /**
     * 测试循环嵌套
     */
    @org.junit.jupiter.api.Test
    public void testJson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Group group = new Group();
        group.setGroupId("2002");
        group.setGroupTitle("群标题");
        GroupUser user = new GroupUser();
        user.setGroup(group);
        user.setId(1111);
        user.setName("Jeo");
        user.setDescription("描述");
        user.setMobile("18888888888");
        group.setGroupUser(user);
        System.out.println(group);
        String s = objectMapper.writeValueAsString(group);
//        String s ="{\"groupId\":\"2020\",\"groupTitle\":\"群标题\",\"user\":{\"group.groupId\":\"2020\",\"id\":11111,\"name\":\"群成员1\",\"description\":\"这是一号群成员\",\"mobile\":\"18888888888\"}}";
        System.out.println(s);
        Group group1 = objectMapper.readValue(s, Group.class);
        System.out.println(group1);
    }


    @org.junit.jupiter.api.Test
    public void testFastjson() throws Exception {
        Group group = new Group();
        group.setGroupId("2002");
        group.setGroupTitle("群标题");
        GroupUser user = new GroupUser();
        user.setGroup(group);
        user.setId(1111);
        user.setName("Jeo");
        user.setDescription("描述");
        user.setMobile("18888888888");
        group.setGroupUser(user);
        System.out.println(group);
        String s = JSON.toJSONString(group, SerializerFeature.DisableCircularReferenceDetect);
//        String s ="{\"groupId\":\"2020\",\"groupTitle\":\"群标题\",\"user\":{\"group.groupId\":\"2020\",\"id\":11111,\"name\":\"群成员1\",\"description\":\"这是一号群成员\",\"mobile\":\"18888888888\"}}";
        System.out.println(s);
        Group group1 = JSON.parseObject(s, Group.class);
        System.out.println(group1);

    }

}