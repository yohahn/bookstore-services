package name.yohahn.bookstore.domain.repository;

import com.google.inject.Inject;
import io.katharsis.queryParams.RequestParams;
import io.katharsis.repository.ResourceRepository;
import name.yohahn.bookstore.domain.model.Book;
import name.yohahn.bookstore.jdbi.BookDAO;

/**
 * Created by yohahn.kim on 10/23/15.
 */
public class BookRepository implements ResourceRepository<Book, Long> {

    private BookDAO bookDAO;

    @Inject
    public BookRepository(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public Book findOne(Long id, RequestParams requestParams) {
        Book book = bookDAO.findById(id);
        return book;
    }

    @Override
    public Iterable<Book> findAll(RequestParams requestParams) {
        return bookDAO.findAll();
    }

    @Override
    public Iterable<Book> findAll(Iterable<Long> iterable, RequestParams requestParams) {
        // TODO need to look into implementing sub-set logic
        return bookDAO.findAll();
    }

    @Override
    public void delete(Long id) {
        bookDAO.delete(id);
    }

    @Override
    public <S extends Book> S save(S book) {
        if (book.getId() == null) {
            long id = bookDAO.create(book.getTitle());
            book.setId(id);
        } else {
            bookDAO.update(book.getId(), book.getTitle());
        }
        return book;
    }
}
