package app.web.mdibuhossain.crud.controller;

import app.web.mdibuhossain.crud.model.Book;
import app.web.mdibuhossain.crud.service.BookService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.allBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getSingleBook(@PathVariable String id) {
        return ResponseEntity.ok(bookService.singleBook(id));
    }

    @PostMapping("/save")
    public ResponseEntity<?> insertBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.createBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id) {
        try {
            bookService.delete(id);
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        } catch (Exception er) {
            return new ResponseEntity<>("Failed to delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
