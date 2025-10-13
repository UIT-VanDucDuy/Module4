package com.example.borrowbook.service;

import com.example.borrowbook.entity.Borrow;
import com.example.borrowbook.exception.BookNotAvailableException;
import com.example.borrowbook.exception.InvalidBorrowCodeException;
import com.example.borrowbook.repository.IBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BorrowService {
    @Autowired
    private BookService bookService;

    @Autowired
    private IBorrowRepository borrowRepository;

    public String borrowBook(int bookId) {
        bookService.decreaseQuantity(bookId);

        String code = String.format("%05d", new Random().nextInt(100000));
        Borrow borrow = new Borrow(code, bookId);
        borrowRepository.save(borrow);

        return code;
    }

    public void returnBook(String code) {
        Borrow borrow = borrowRepository.findByCode(code)
                .orElseThrow(() -> new InvalidBorrowCodeException("Mã mượn sách không hợp lệ!"));


        bookService.increaseQuantity((int) borrow.getBookId());
        borrowRepository.delete(borrow);
    }
}
