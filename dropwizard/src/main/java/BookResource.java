import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/json")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    private static final Book[] DATA = new Book[]{
            new Book("Animal Farm", new String[]{"George Orwell"}, "Penguin", 9780141036137L, "April 27, 2014"),
            new Book("1984", new String[]{"George Orwell"}, "Penguin", 9780141036144L, "April 27, 2014"),
            new Book("The Razor's Edge", new String[]{"William Sommerset Maugham"}, "Vintage", 9780099284864L, "April 27, 2014")
    };

    @GET
    public Book[] get() { return DATA;}
}
