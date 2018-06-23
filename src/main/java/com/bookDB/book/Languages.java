package com.bookDB.book;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
public class Languages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Code")
    private String code;
    
    @Column(name = "Name")
    private String name;
    
    @ManyToMany( mappedBy = "languages", fetch = FetchType.EAGER)
    private Set<Books> books = new HashSet<>();

    public Languages() {
    }

    public Languages(String code) {
        this.code = code;
    }

    public Languages(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> bookLangList) {
        this.books = bookLangList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Languages)) {
            return false;
        }
        Languages other = (Languages) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "book.entity.Languages[ code=" + code + " ]";
    }
    
}
