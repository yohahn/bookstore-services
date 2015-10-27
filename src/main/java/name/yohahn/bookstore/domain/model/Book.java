package name.yohahn.bookstore.domain.model;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

/**
 * Created by yohahn.kim on 10/23/15.
 */
@JsonApiResource(type = "books")
public class Book {

    @JsonApiId
    private Long id;

    private String title;

    public Book() {
        // Jackson deserialization
    }

    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
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
}
