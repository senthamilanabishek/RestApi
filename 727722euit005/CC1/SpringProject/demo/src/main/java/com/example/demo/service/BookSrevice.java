package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookSrevice {
    @Autowired
    BookRepository book;

    @SuppressWarnings("null")
    public Book post(Book ob)
    {
        return book.save(ob);
    }

    public List<Book> getAll()
    {
        return book.findAll();
    }

    public Optional<Book> getone(int id)
    {
        return book.findById(id);
    }

    public Book putAll(int id,Book obj)
    {
        Book b=book.findById(id).orElse(null);
        if(b!=null)
        {
            b.setBookName(obj.getBookName());
            b.setAuthorName(obj.getAuthorName());
            b.setDescription(obj.getDescription());
            b.setPrice(obj.getPrice());
            return book.saveAndFlush(b);
        }
        else
        {
            return null;
        }
    }

    public String delete(int id)
    {
        book.deleteById(id);
        return ("Deleted Successfully");
    }

    public List<Book> getByBookName(String bookName)
    {
        return book.getByBookName(bookName);
    }
}
