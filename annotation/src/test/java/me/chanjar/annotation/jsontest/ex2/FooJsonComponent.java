package me.chanjar.annotation.jsontest.ex2;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import me.chanjar.annotation.jsontest.ex1.Foo;
import org.springframework.boot.jackson.JsonComponent;

/**
 * Created by qianjia on 2017/7/19.
 */
@JsonComponent
public class FooJsonComponent {

    public static class Serializer extends JsonSerializer<Foo> {

        @Override
        public void serialize(Foo value, JsonGenerator gen, SerializerProvider serializers)
                throws IOException, JsonProcessingException {
            System.out.println("serialize(value=" + value + ")");
            gen.writeString("name=" + value.getName() + ",age=" + value.getAge());
        }

    }

    public static class Deserializer extends JsonDeserializer<Foo> {

        @Override
        public Foo deserialize(JsonParser jsonParser, DeserializationContext context)
                throws IOException, JsonProcessingException {
            JsonToken jsonToken = jsonParser.getCurrentToken();
            System.out.println("deserialize: jsonToken=" + jsonToken);

            if (jsonToken == JsonToken.VALUE_STRING) {
                String trim = jsonParser.getText().trim();
                String[] split = trim.split(",");

                System.out.println("deserialize: trim=" + trim);

                Foo foo = new Foo();
                foo.setName(split[0].split("=")[1]);
                foo.setAge(Integer.parseInt(split[1].split("=")[1]));
                return foo;
            }

            return (Foo) context.handleUnexpectedToken(handledType(), jsonParser);

        }

    }

}
