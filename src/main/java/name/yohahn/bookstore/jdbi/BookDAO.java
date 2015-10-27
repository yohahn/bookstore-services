package name.yohahn.bookstore.jdbi;

import name.yohahn.bookstore.domain.model.Book;
import org.joda.time.DateTime;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by yohahn.kim on 10/23/15.
 */
@RegisterMapper(BookMapper.class)
public interface BookDAO {
    @SqlQuery("SELECT id, title, published FROM book")
    List<Book> findAll();

    @SqlQuery("SELECT id, title, published FROM book WHERE id = :id")
    Book findById(@Bind("id") long id);

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO book (id, title, published) VALUES (NULL, :title, :published)")
    long create(@Bind("title") String title, @Bind("published") DateTime published);

    @SqlUpdate("UPDATE book SET title = :title, published = :published WHERE id = :id")
    void update(@Bind("id") long id, @Bind("title") String title, @Bind("published") DateTime published);

    @SqlUpdate("DELETE FROM book WHERE id = :id")
    void delete(@Bind("id") long id);
}
