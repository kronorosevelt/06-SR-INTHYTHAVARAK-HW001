package com.example.demo.Model.DataTransfer;

public class BookDto {

    private int id;
    private String title;
    private String author;
    private String description;
    private String thumbnail;
    private int category_id;

    public BookDto() {
    }

    public BookDto(int id, String title, String author, String description, String thumbnail, int category_id) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.thumbnail = thumbnail;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "BookDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", category_id=" + category_id +
                '}';
    }
}
