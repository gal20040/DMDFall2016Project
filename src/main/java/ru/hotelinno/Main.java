package ru.hotelinno;

import ru.hotelinno.Search.Searcher;
import ru.hotelinno.domain.RESULT.Result;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Searcher searcher = new Searcher();
        List<String> options = new ArrayList<String>();
        options.add("Kazan");
        options.add("20161125110000");
        options.add("20161128120000");
        options.add("*");
        options.add("*");
        List<Result> resultList = searcher.searchRooms(options);
    }
}
