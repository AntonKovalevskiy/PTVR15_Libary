/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptvr15_libary;

import entity.Book;
import entity.Reader;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author pupil
 */
public class PTVR15_Libary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book book1 = new Book("Название автора книги", "название книги", "Индивидуальный код");
        Book book2 = new Book("Дж. Блох", "Эф. программирование на Java", "412412412");
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        //  Reader reader1 = new Reader("Иван", "Иванов", "38910104323", new ArrayList<Book>());
        Reader reader1 = new Reader("Иван", "Иванов", "38910104323", books);
        //reader1.addBook(book1);
        // System.out.println(reader1.toString());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PTVR15_LibaryPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(reader1);
       // Reader readerFromDB = em.find(Reader.class, 1L);
        //readerFromDB.removeBook(book2);
        // Query query = em.createQuery("SELECT r FROM Reader r WHERE r.firstname=:firstname AND r.lastname=:lastname");
        //  query.setParameter("firstname", "Иван");
        //  query.setParameter("lastname", "Иванов");
        //   Reader updReader = (Reader) query.getSingleResult();
//      System.out.println(readerFromDB.toString());
        // updReader.addBook(book2);
        // em.merge(updReader);
//        em.merge(readerFromDB);
        tx.commit();
        //em.close();
        //emf.close();

        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
}
