package name.yohahn.bookstore.jdbi;

import com.google.common.base.Strings;
import name.yohahn.bookstore.domain.model.Book;
import org.joda.time.DateTime;
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

        DateTime published = null;
        if (rs.getDate("published") != null) {
            published = new DateTime(rs.getDate("published"));
        }
        return new Book(
                rs.getLong("id"),
                rs.getString("title"),
                published);
    }
}
