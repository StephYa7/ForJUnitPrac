package Prac_4.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    BookRepository bookRepository;
    BookService bookService;
    List<Book> allBooks;
    Book book;

    @BeforeEach
    void options() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
        book = new Book("1", "title1", "author1");
        allBooks = List.of(book
                , new Book("2", "title2", "author2")
                , new Book("3", "title3", "author3"));
    }

    @Test
    void returnBookByGivenId() {
        when(bookRepository.findById("1")).thenReturn(book);
        var result = bookService.findBookById("1");
        assertEquals(result, book);
    }

    @Test
    void returnListOfAllBooks() {
        when(bookRepository.findAll()).thenReturn(allBooks);
        var result = bookService.findAllBooks();
        assertEquals(result, allBooks);
    }
}