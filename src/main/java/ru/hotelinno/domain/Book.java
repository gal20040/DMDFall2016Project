package ru.hotelinno.domain;

import javax.persistence.*;

@Entity //эта аннотация говорит, что эту сущность мы будем хранить в БД //TODO
@Table(name = "books") //имя таблицы //TODO
public class Book {

    @Id
    @Column(name = "id") //имя колонки в таблице в БД //TODO
    @GeneratedValue //это говорит, что это поле - автогенерируемое //TODO
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private String genre;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getGenre() {return genre;}
    public void setGenre(String genre) {this.genre = genre;}
}