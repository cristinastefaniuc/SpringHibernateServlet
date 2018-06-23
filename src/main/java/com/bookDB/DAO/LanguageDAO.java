package com.bookDB.DAO;

import com.bookDB.book.Languages;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class LanguageDAO {
    private final SessionFactory sessionFactory;
    
    @Autowired
    public LanguageDAO(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session session() {
        return sessionFactory.getCurrentSession();
    }
    
    public Languages getLanguageByID(String id) {
        return session().get(Languages.class, id);
    }
    
    public List<Languages> getAllLanguages() {
        return session().createQuery ("from Languages").list();
    }
    
    public void addLanguage(Languages language) {
        session().save(language);
    }
    
    public void updateLanguage(Languages language) {
        session().update(language);
    }
    
    public void deleteLanguage(Languages language) {
        session().delete(language);
    }
}
