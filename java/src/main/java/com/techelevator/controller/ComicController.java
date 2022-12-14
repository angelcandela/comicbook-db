package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.ComicDao;
import com.techelevator.model.Collection;
import com.techelevator.model.Comic;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/comic")
public class ComicController {

    private ComicDao comicDao;
    private JdbcTemplate jdbcTemplate;

    public ComicController(ComicDao comicDao){
        this.comicDao = comicDao;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Comic createComic(@RequestBody Comic comic){
        return comicDao.createComic(comic);}

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Comic> findAll(){
        return comicDao.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Comic getComicById(@PathVariable int id){return comicDao.getComicById(id);}

    @RequestMapping(path = "/comicName/{comicName}", method = RequestMethod.GET)
    public Comic getComicByName(@PathVariable String comicName){return  comicDao.getByComicName(comicName);}

    @RequestMapping(path = "/collection/{id}", method = RequestMethod.GET)
    public List<Comic> findAllComicsByCollectionId(@PathVariable int id) {
        return comicDao.findAllComicsByCollectionId(id);
    }
//statistics methods
    @RequestMapping(path = "/count", method = RequestMethod.GET)
    public int getComicCount() {
        return comicDao.getComicCount();
    }

//    @RequestMapping(path = "/authorComicCount", method = RequestMethod.GET)
//    public List<Map<String, Object>> getAuthorComicCount() {
//        List<Map<String, Object>> results = new ArrayList<>();
//        String sql = "SELECT author, COUNT(*) FROM comic GROUP BY author";
//        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
//        while (rowSet.next()) {
//            Map<String, Object> row = new HashMap<>();
//            row.put("author", rowSet.getString("author"));
//            row.put("COUNT(*)", rowSet.getInt("COUNT(*)"));
//            results.add(row);
//        }
//        return results;
//    }



}

//@RequestMapping(path = "/comicname", method = RequestMethod.GET)
//public Comic comic{return comicDao.findByComicName();}

