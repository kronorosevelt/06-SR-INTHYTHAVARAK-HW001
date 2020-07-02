package com.example.demo.Repository;

import com.example.demo.Model.DataTransfer.BookDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {
    @Select("SELECT * FROM tb_books")
    List<BookDto> findAll();

    @Insert("INSERT INTO tb_books (title,author,description,thumbnail,category_id) VALUES(#{title},#{author},#{description},#{thumbnail},#{category_id})")
    boolean insert(BookDto bookDto);

    @Delete("DELETE FROM tb_books WHERE id=#{id}")
    boolean delete (int id);

    @Update("UPDATE "+ "\"tb_books\" SET title=#{arg1.title}, description=#{arg1.description} WHERE id=#{arg0}")
    boolean update(int id, BookDto bookDto);

    @Select("SELECT * FROM tb_books WHERE id = #{arg0}")
    List<BookDto> findByID(int id);




}
