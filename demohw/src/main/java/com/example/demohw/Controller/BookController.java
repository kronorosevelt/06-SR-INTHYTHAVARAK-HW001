package com.example.demo.Contoller;
import com.example.demo.Model.BaseApiResponse;
import com.example.demo.Model.DataTransfer.BookDto;
import com.example.demo.Model.Request.BookRequestModel;
import com.example.demo.Model.Response.BookResposeModel;
import com.example.demo.Service.BookService;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/api")
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<BaseApiResponse<List<BookRequestModel>>> findAll(){
        ModelMapper mapper = new ModelMapper();
        BaseApiResponse<List<BookRequestModel>> response = new BaseApiResponse<>();
        List<BookDto> bookDtoList = bookService.findAll();
        List<BookRequestModel> book = new ArrayList<>();

        for (BookDto articleDto : bookDtoList) {
            book.add(mapper.map(articleDto, BookRequestModel.class));
        }
        response.setMessage("You have found all articles successfully");
        response.setData(book);
        response.setHttpStatus(HttpStatus.OK);
        response.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/books")
    public ResponseEntity<BaseApiResponse<BookResposeModel>> insert(@RequestBody BookRequestModel requestModel){
        System.out.println(requestModel);
        ModelMapper modelMapper = new ModelMapper();
        BaseApiResponse<BookResposeModel> respone=new BaseApiResponse <>();
        BookDto bookDto = modelMapper.map(requestModel,BookDto.class);
        bookService.insert(bookDto);
        BookResposeModel responeModel = modelMapper.map(requestModel,BookResposeModel.class);

        respone.setMessage("YOU HAVE ADD SUCCESSFULLY!");
        respone.setHttpStatus(HttpStatus.CREATED);
        respone.setTimestamp(new Timestamp(System.currentTimeMillis()));
        respone.setData(responeModel);
        return new ResponseEntity <>(respone,HttpStatus.CREATED);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        return new ResponseEntity <>(bookService.delete(id),HttpStatus.OK);
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<BaseApiResponse<BookResposeModel>> update(@PathVariable int id,@RequestBody BookRequestModel requestModel){

        ModelMapper modelMapper=new ModelMapper();
        BaseApiResponse<BookResposeModel> respone=new BaseApiResponse <>();

        BookDto dto=modelMapper.map(requestModel,BookDto.class);

        BookResposeModel responeModel=modelMapper.map(bookService.update(id,dto),BookResposeModel.class);

        respone.setMessage("YOU HAVE UPDATED SUCCESSFULLY!");
        respone.setHttpStatus(HttpStatus.OK);
        respone.setData(responeModel);
        respone.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(respone);
    }

    @GetMapping("/c/{id}")
    public ResponseEntity<BaseApiResponse<List<BookRequestModel>>> findById(@PathVariable int id){

        ModelMapper mapper = new ModelMapper();
        BaseApiResponse<List<BookRequestModel>> response = new BaseApiResponse<>();
        List<BookDto> articleDtoList = bookService.findByID(id);
        List<BookRequestModel> book = new ArrayList<>();

        for (BookDto articleDto : articleDtoList) {
            book.add(mapper.map(articleDto, BookRequestModel.class));
        }
        response.setMessage("You have found all articles successfully");
        response.setData(book);
        response.setHttpStatus(HttpStatus.OK);
        response.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }





}

