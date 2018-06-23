package com.bookDB.DAO;

import com.bookDB.book.Books;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class BookDAO {
    private final SessionFactory sessionFactory;
    
    @Autowired
    public BookDAO(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session session() {
        return sessionFactory.getCurrentSession();
    }
    
    public Books getBookByID(int id) {
        return session().get(Books.class, id);
    }
    
    public List getBooksByYear(String year) {
        return session().createQuery ("from Books as books where books.year = '"+ year +"'").list();
    }
    
    public List<Books> getBooksByAuthor(String Author){
        return session().createCriteria(Books.class, "b")
                .createCriteria("b.author", "booksList", JoinType.INNER_JOIN, Restrictions.eq("lastName", Author))   
                .list();
    }
    
    public List getBooksByGenre(String Genre){
        return session()
                .createQuery ("from Books as books where books.genres in (select genre.id from Genres as genre where genre.name='" + Genre + "')")
                .list();
    }
    
    public Books getBookByTitle(String Title){
        return (Books)session().createQuery ("from Books as books where books.title = '" + Title + "'")
                .getSingleResult();
    }
    
    public void addBook(Books book) {
        session().save(book);
    }
    
    public void updateBook(Books book) {
        session().update(book);
    }
    
    public void deleteBook(Books book) {
        session().delete(book);
    }
}
