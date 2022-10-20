package com.example.springmongodb.controller;


import com.example.springmongodb.model.Book;
import com.example.springmongodb.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepo br;

    @GetMapping("/")
    public String displayMessage()
    {
        return "Welcome my frand";
    }


    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book)
    {
        br.save(book);
        return "Added" + book.getBookName();
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks()
    {
        return br.findAll();
    }


    @GetMapping("/findBook/{id}")
    public Optional<Book> findBook(@PathVariable int id)
    {
        return br.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        br.deleteById(id);
        return "book deleted with id : " + id;
    }

}
