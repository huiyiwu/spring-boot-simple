package com.huchx.mvc.config;

import org.springframework.boot.jackson.JsonComponent;

/**
 * 不可与Config/MyConfiguration中HttpMessageConverters配置同时存在
 */
@JsonComponent
public class ClothColorJsonSerializer {
//    public static class ClothColorSerializer extends JsonSerializer<ClothColorPojo> {
//
//        @Override
//        public void serialize(ClothColorPojo clothColorPojo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//            // 对象转为字节流
//            jsonGenerator.writeStartObject();
//            jsonGenerator.writeStringField("color",getColor(clothColorPojo.getColor()));
//            jsonGenerator.writeEndObject();
//        }
//
//        public String getColor(Color color) {
//            int r = (int) Math.round(color.getRed()*255.0);
//            int g = (int) Math.round(color.getRed()*255.0);
//            int b = (int) Math.round(color.getBlue()*255.0);
//            return String.format("#%02x%02x%02x",r,g,b);
//        }
//
//    }
//    public static class ClothColorDeserializer extends JsonDeserializer<ClothColorPojo>{
//
//        @Override
//        public ClothColorPojo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
//            // 字节流转为对象
//            TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
//            TextNode colorNode = (TextNode) treeNode.get("color");
//            return new ClothColorPojo(Color.web(colorNode.asText()));
//        }
//    }
}
