package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Book;
import com.example.demo.service.BookSrevice;

@RestController
public class BookController {

    @Autowired
    BookSrevice bookService;

    @PostMapping("/post")
    public ResponseEntity<Book> post(@RequestBody Book book) {
        Book savedBook = bookService.post(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Book>> getAll() {
        List<Book> books = bookService.getAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/getid/{id}")
    public Optional<Book> ge(@PathVariable int id)
    {
        return bookService.getone(id);
    }

    @GetMapping("/getuser/{bookName}")
    public ResponseEntity<List<Book>> getByBookName(@PathVariable String bookName) {
        List<Book> books = bookService.getByBookName(bookName);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Book> put(@PathVariable int id, @RequestBody Book updatedBook) {
        Book updated = bookService.putAll(id, updatedBook);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int id) {
        String result = bookService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}