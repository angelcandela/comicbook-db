package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.ComicDao;
import com.techelevator.model.AuthorComicCount;
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
    public List<Comic> findComicsByCollectionId(@PathVariable int id) {
        return comicDao.findComicsByCollectionId(id);
    }


//statistics methods
    @RequestMapping(path = "/count", method = RequestMethod.GET)
    public int getComicCount() {
        return comicDao.getComicCount();
    }

    @RequestMapping(path = "/author/count", method = RequestMethod.GET)
    public int getAuthorCount() {
        return comicDao.getAuthorCount();
    }

    @RequestMapping(path = "/authorComicCount", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<AuthorComicCount> getAuthorComicCount() {
        return comicDao.getAuthorComicCount();
    }

    @RequestMapping(path = "/collection/{id}/count", method = RequestMethod.GET)
    public int getComicCountByCollectionId(@PathVariable int id) {
        return comicDao.getComicCountByCollectionId(id);
    }
}





//@RequestMapping(path = "/comicname", method = RequestMethod.GET)
//public Comic comic{return comicDao.findByComicName();}

