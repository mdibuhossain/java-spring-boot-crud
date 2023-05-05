package app.web.mdibuhossain.crud.service;

import app.web.mdibuhossain.crud.model.Book;
import app.web.mdibuhossain.crud.repository.BookRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> singleBook(String id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public void delete(String id) {
        bookRepository.deleteById(id);
    }
}
