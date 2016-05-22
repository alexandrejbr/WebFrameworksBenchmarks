package hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import org.rapidoid.setup.On;

public class Application {
    private static final Book[] DATA = new Book[]{
            new Book("Animal Farm", new String[]{"George Orwell"}, "Penguin", 9780141036137L, "April 27, 2014"),
            new Book("1984", new String[]{"George Orwell"}, "Penguin", 9780141036144L, "April 27, 2014"),
            new Book("The Razor's Edge", new String[]{"William Sommerset Maugham"}, "Vintage", 9780099284864L, "April 27, 2014")
    };

    private static final ObjectMapper MAPPER = mapper();

    private static final byte[] TEXT = objectAsString(DATA);

    private static byte[] objectAsString(Object data) {
        try {
            return MAPPER.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new AfterburnerModule());
        return mapper;
    }

    public static void main(String[] args) {
        On.get("/json").json(req -> MAPPER.writeValueAsBytes(DATA));
        On.get("/plaintext").plain(TEXT);
    }
}
