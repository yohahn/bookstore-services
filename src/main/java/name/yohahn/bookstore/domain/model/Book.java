package name.yohahn.bookstore.domain.model;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;
import org.joda.time.DateTime;

/**
 * Created by yohahn.kim on 10/23/15.
 */
@JsonApiResource(type = "books")
public class Book {

    @JsonApiId
    private Long id;

    private String title;

    private DateTime published;

    public Book() {
        // Jackson deserialization
    }

    public Book(Long id, String title, DateTime published) {
        this.id = id;
        this.title = title;
        this.published = published;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DateTime getPublished() {
        return published;
    }

    public void setPublished(DateTime published) {
        this.published = published;
    }
}
