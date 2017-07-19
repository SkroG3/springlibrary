package ru.skroznikov.library.dao;


import ru.skroznikov.library.domain.Book;

import java.util.List;

public interface BookDao extends GeneralDao<Book> {

    List<Book> findTopBooks(int limit);

}
