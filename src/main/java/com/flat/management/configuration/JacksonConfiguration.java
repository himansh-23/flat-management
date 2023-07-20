package com.flat.management.configuration;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.TextNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Configuration
public class JacksonConfiguration {
    public static class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

        @Override
        public ZonedDateTime deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JacksonException {
            ObjectCodec codec = jp.getCodec();
            TextNode node = codec.readTree(jp);
            String dateString = node.textValue();
            java.time.LocalDate instant = LocalDate.parse(dateString);
            return ZonedDateTime.ofInstant(instant.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        }
    }

    public static class ZonedDateTimeSerializer extends JsonSerializer<ZonedDateTime> {

        @Override
        public void serialize(ZonedDateTime dateTime, JsonGenerator jg,
                              SerializerProvider sp) throws IOException {
            DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
            jg.writeString(dateTime.format(formatter));
        }
    }


}
