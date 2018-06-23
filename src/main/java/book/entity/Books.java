package book.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Books implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "Title")
    private String title;
    
    @Column(name = "Year")
    private String year;
    
    @Column(name = "Genre")
    @Enumerated(EnumType.STRING)
    private Genres genre;
    
    @ManyToOne
    @JoinColumn(name = "AuthorID")
    private Authors author;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_lang", 
        joinColumns = { @JoinColumn(name = "book_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "lang_code") }
    )
    private Set<Languages> languages = new HashSet<>();

    public Books() {
    }

    public Books(Integer id) {
        this.id = id;
    }

    public Books(Authors author, String title, String year, Genres genre) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }
 
    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors authorID) {
        this.author = authorID;
    }

    public Set<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Languages> languages) {
        this.languages = languages;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "book.entity.Books[ id=" + id + " ]";
    }
    
}
