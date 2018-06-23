package com.bookDB.DAO;

import com.bookDB.book.Authors;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class AuthorDAO {
    
    private final SessionFactory sessionFactory;
    
    @Autowired
    public AuthorDAO(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session session() {
        return sessionFactory.getCurrentSession();
    }
    
    public Authors getAuthorByID(int id) {
        return session().get(Authors.class, id);
    }
    
    public Authors getAuthorByLastName(String lastName) {
        return (Authors)session().createQuery ("from Authors as a where a.lastName = '"+ lastName +"'").getSingleResult();
    }
    
    public List<Authors> getAllAuthors() {
        return session().createCriteria(Authors.class).list();
    }
    
    public void addAuthor(Authors author) {
        session().save(author);
    }
    
    public void updateAuthor(Authors author) {
        session().update(author);
    }
    
    public void deleteAuthor(Authors author) {
        session().delete(author);
    }
}
