/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author pupil
 */
@Entity
public class Reader extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Book> books;

    public Reader() {
    }

    public Reader(String firstname, String lastname, String code, List<Book> books) {
        super(firstname,lastname,code);
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).getName().equals(book.getName()))
            this.books.remove(i);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.books);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reader other = (Reader) obj;
        if (!Objects.equals(this.books, other.books)) {
            return false;
        }
        return true;
    }
    
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        String strBooks = "";
        for (int i = 0; i < this.books.size(); i++) {
            strBooks += this.books.get(i);
        }
        return "Reader{" + "Firstname: " + super.getFistname()
                + "Lastname: " + super.getLastname() + "Code: " + super.getCode() + ""
                + "Books: " + "" + strBooks + '}';
    }
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
