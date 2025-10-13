package com.example.borrowbook.service;

import com.example.borrowbook.entity.Book;
import com.example.borrowbook.exception.BookNotAvailableException;
import com.example.borrowbook.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private IBookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book getBook(int id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public void decreaseQuantity(int id) {
        Book book = getBook(id);
        if (book.getQuantity() <= 0) {
            throw new BookNotAvailableException("Sách đã được mượn hết!");
        }
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
    }

    public void increaseQuantity(int id) {
        Book book = getBook(id);
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
    }
}
