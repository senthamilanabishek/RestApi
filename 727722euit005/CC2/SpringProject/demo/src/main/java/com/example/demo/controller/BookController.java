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

    @PostMapping("/book/post")
    public ResponseEntity<Book> post(@RequestBody Book b) {
        Book savedBook = bookService.post(b);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/book/getall")
    public ResponseEntity<List<Book>> getAll() {
        List<Book> books = bookService.getAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/book/getid/{bookid}")
    public Optional<Book> ge(@PathVariable int bookid)
    {
        return bookService.getone(bookid);
    }

    @GetMapping("/book/getuser/{bookName}")
    public ResponseEntity<List<Book>> getByBookName(@PathVariable String bookName) {
        List<Book> books = bookService.getByBookName(bookName);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("/book/put/{bookid}")
    public ResponseEntity<Book> put(@PathVariable int bookid, @RequestBody Book updatedBook) {
        Book updated = bookService.putAll(bookid, updatedBook);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/book/delete")
    public ResponseEntity<String> delete(@RequestParam int bookid) {
        String result = bookService.delete(bookid);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/book/pagination/{offset}/{pagesize}")
    public List<Book> page(@PathVariable int offset,@PathVariable int pagesize)
    {
        return bookService.pagination(offset, pagesize);
    }

    @GetMapping("/book/sorting/{field}")
    public List<Book> sort(@PathVariable String field)
    {
        return bookService.sorting(field);
    }

    @GetMapping("/book/sorting/{offset}/{pagesize}/{field}")
    public List<Book> pagesort(@PathVariable int pageNumber,@PathVariable int pageSize,@PathVariable String field)
    {
        return bookService.pagesorting(pageNumber, pageSize, field);
    }
}