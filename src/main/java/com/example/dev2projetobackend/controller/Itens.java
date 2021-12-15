package com.example.dev2projetobackend.controller;

import com.example.dev2projetobackend.exception.exceptions.RequestInvalidaException;
import com.example.dev2projetobackend.model.Item;
import com.example.dev2projetobackend.modelo.dao.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
public class Itens {

    @Autowired
    ItemDAO itemDAO;

    public void validaObjeto(Item item) {

        if(item.getCor()==null||item.getCor().isEmpty()) {
            throw new RequestInvalidaException();
        }

        if(item.getDescricao()==null||item.getDescricao().isEmpty()) {
            throw new RequestInvalidaException();
        }
    }


    @RequestMapping(path = "/cadastrarItem/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Item cadastrar(@RequestBody Item item) {
        item.setId(0);
        validaObjeto(item);
        return itemDAO.save(item);
    }

    @RequestMapping(path = "/itens/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Item> listar() {
        return itemDAO.findAll();
    }

    @RequestMapping(path = "/itens/pesquisa/nome", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Item> pesquisaNome(
            @RequestParam(required = false) String contem){
        if(contem != null)
            return itemDAO.findByNomeContainingIgnoreCase(contem);
        else
            throw new RequestInvalidaException();

    }

    @RequestMapping(path = "/itens/pesquisa/data", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Item> pesquisaData(
            @RequestParam Date inicio,
            @RequestParam Date fim
    ) {
        return itemDAO.findByDataBetween(inicio, fim);
    }

    }



