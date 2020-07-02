package com.example.demo.Service;


import com.example.demo.Model.DataTransfer.BookDto;
import com.example.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceIpm implements BookService{


    private BookRepository bookRepository;
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public BookDto insert(BookDto bookDto) {
        boolean isInsert=bookRepository.insert(bookDto);
        if(isInsert){
            return bookDto;
        }else{
            return null;
        }
    }
    @Override
    public String delete(int id) {
        boolean isDelete=bookRepository.delete(id);
        if(isDelete){
            return "YOU HAVE DELETE SUCCESSFULLY";
        }else {
            return "YOU CAN NOT DELETE";
        }
    }

    @Override
    public BookDto update(int id, BookDto dto) {
        boolean isUpdated=bookRepository.update(id,dto);
        if(isUpdated){
            return dto;
        }else {
            return null;
        }
    }

    @Override
    public List<BookDto> findByID(int id) {
        try{
            return bookRepository.findByID(id);
        }catch (Exception e){
            return null;
        }
    }

   }
}



