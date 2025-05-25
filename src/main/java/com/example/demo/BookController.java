package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public void add(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping("/list")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}