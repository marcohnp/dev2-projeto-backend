package com.example.dev2projetobackend.controller;

import com.example.dev2projetobackend.exception.exceptions.ItemNotFoundException;
import com.example.dev2projetobackend.exception.exceptions.RequestInvalidaException;
import com.example.dev2projetobackend.model.Item;
import com.example.dev2projetobackend.modelo.dao.ItemDAO;
import com.example.dev2projetobackend.util.FileUploadUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
public class Itens {

    @Autowired
    ItemDAO itemDAO;


    @RequestMapping(path = "/cadastrarItem/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Item cadastrar(String itemString, @RequestParam("file") MultipartFile file) throws IOException {
        Item item = null;
        try {
            item = new ObjectMapper().readValue(itemString, Item.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        item.setId(0);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        item.setFoto(fileName);
        Item savedItem = itemDAO.save(item);
        String uploadDir = "item-photos/" + (savedItem.getId()+1);
        FileUploadUtil.saveFile(uploadDir, fileName, file);
        validaObjeto(item);
        return itemDAO.save(item);
    }

    @RequestMapping(path = "/itens/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Item> listar() {
        return itemDAO.findAll();
    }

    @RequestMapping(path = "/itens/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Item recuperarPorId(@PathVariable Integer id) {
        return itemDAO.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @RequestMapping(path = "/itens/pesquisa/nome", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Item> pesquisaNome(
            @RequestParam(required = false) String contem) {
        if (contem != null)
            return itemDAO.findByNomeContainingIgnoreCase(contem);
        else
            throw new RequestInvalidaException();

    }

    @RequestMapping(path = "/itens/pesquisa/data", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Item> pesquisaData(
            @RequestParam @DateTimeFormat(pattern = "yyy-MM-dd") Date inicio,
            @RequestParam @DateTimeFormat(pattern = "yyy-MM-dd") Date fim
    ) {
        return itemDAO.findByDataBetween(inicio, fim);
    }

    @RequestMapping(path = "/itens/pesquisa/categoriaNome", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Item> pesquisaCategoriaNome(
            @RequestParam(required = false) String contem) {
        if (contem != null)
            return itemDAO.findByCategoriaNomeContaining(contem);
        else
            throw new RequestInvalidaException();
    }


    @RequestMapping(path = "/itens/pesquisa/usuarioNome", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Item> pesquisaUsuarioNome(
            @RequestParam(required = false) String contem) {
        if (contem != null)
            return itemDAO.findByUsuarioNomeContaining(contem);
        else
            throw new RequestInvalidaException();

    }

    @PutMapping("/itens/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Item atualizarItem(@PathVariable Integer id, @RequestBody Item request) {
        Item item = itemDAO.findById(id).orElseThrow(ItemNotFoundException::new);
        item.setNome(request.getNome());
        item.setCor(request.getCor());
        item.setDescricao((request.getDescricao()));
        item.setFoto(request.getFoto());
        item.setPerdido(request.getPerdido());
        item.setDevolvido(request.getDevolvido());
        item.setLocal(request.getLocal());
        item.setMarca(request.getMarca());
        item.setModelo(request.getModelo());
        item.getCategoria().setNome(request.getCategoria().getNome());
        return itemDAO.save(item);
    }

    @DeleteMapping("/itens/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarItem(@PathVariable Integer id) {
        Item item = itemDAO.findById(id).orElseThrow(ItemNotFoundException::new);
        itemDAO.delete(item);
    }

    public void validaObjeto(Item item) {

        if (item.getCor() == null || item.getCor().isEmpty()) {
            throw new RequestInvalidaException();
        }

        if (item.getDescricao() == null || item.getDescricao().isEmpty()) {
            throw new RequestInvalidaException();
        }
    }
}



