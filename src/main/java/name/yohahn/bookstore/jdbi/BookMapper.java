package name.yohahn.bookstore.jdbi;

import name.yohahn.bookstore.domain.model.Book;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yohahn.kim on 10/23/15.
 */
public class BookMapper implements ResultSetMapper<Book> {

    @Override
    public Book map(
            int i,
            ResultSet rs,
            StatementContext ctx) throws SQLException {
        return new Book(rs.getLong("id"), rs.getString("title"));
    }
}
