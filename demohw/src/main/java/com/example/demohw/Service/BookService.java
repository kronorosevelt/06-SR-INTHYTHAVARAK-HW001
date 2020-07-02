package com.example.demo.Service;

import com.example.demo.Model.DataTransfer.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> findAll();
    BookDto insert(BookDto bookDto);
    String delete(int id);
    BookDto update (int id,BookDto dto);
    List <BookDto> findByID(int id);

}
