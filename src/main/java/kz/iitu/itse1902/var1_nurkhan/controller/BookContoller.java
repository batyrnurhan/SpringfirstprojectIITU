package kz.iitu.itse1902.var1_nurkhan.controller;

import kz.iitu.itse1902.var1_nurkhan.exception.NotFoundException;
import kz.iitu.itse1902.var1_nurkhan.model.Book;
import kz.iitu.itse1902.var1_nurkhan.model.User;
import kz.iitu.itse1902.var1_nurkhan.repository.BookRepository;
import kz.iitu.itse1902.var1_nurkhan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/library")
public class BookContoller {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    //all books
    @GetMapping("/books")
    public List<Book> getAllBook(){
        return (List<Book>) this.bookRepository.findAll();
    }

    //book by id
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId) throws NotFoundException {
        Book book = bookRepository.findById(bookId).orElseThrow(()->
                new NotFoundException("Book not found by this id::" +bookId));
        return ResponseEntity.ok().body(book);
    }

    //create book
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book){
        return this.bookRepository.save(book);
    }

    //update book
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long bookId,
                                           @Valid @RequestBody Book bookDetails) throws NotFoundException {
        Book book = bookRepository.findById(bookId).orElseThrow(()->
                new NotFoundException("Book nnot found by this id::" +bookId));
        book.setName(bookDetails.getName());
        book.setGenre(bookDetails.getGenre());
        book.setAuthor(bookDetails.getAuthor());


        return ResponseEntity.ok(this.bookRepository.save(book));
    }
    //delete book
    @DeleteMapping("/books/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Long bookId) throws NotFoundException {
        Book book = bookRepository.findById(bookId).orElseThrow(()->
                new NotFoundException("Book nnot found by this id::" +bookId));
        this.bookRepository.delete(book);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
