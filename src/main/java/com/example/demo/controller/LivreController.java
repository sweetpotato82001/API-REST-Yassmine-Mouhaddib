package com.example.demo.controller;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Livre;
import com.example.demo.service.LivreService;

@RestController
public class LivreController {
	@Autowired
    private LivreService livreService;
	@GetMapping("/academia/livres/all")
    
	public List<Livre> findAllLivres()
	{
		return livreService.findAll();
	}
	@GetMapping("/academia/livres/{id}")
	public Livre findByid(@PathVariable int id)
	{  Livre l=livreService.findByid(id);
	   Date now = new Date(System.currentTimeMillis());
       l.setDate_derniere_consultation(now);
       return livreService.findByid(id);  	
	}
	@Transactional
	@DeleteMapping("/academia/livres/DeleteAllLivres")
	public void deleteAllLivres()
	{
		livreService.deleteAllLivres();
		System.out.println("All the books had been deleted successfully!!!");
	}
	@Transactional
	@DeleteMapping("/academia/livres/delete/{id}")
	public void deleteByid(@PathVariable Integer id)
	{
		livreService.deleteByidBook(id);
		System.out.println("The book has been deleted successfully!!!");
	}
	
	@PutMapping("/academia/livres/update/{id}")
    public Livre updateLivre(@PathVariable int id) {
       Livre l=livreService.findByid(id);
       l.setAuteur("batata");
        return livreService.updateLivre(l);
    }
	
	@PutMapping("/academia/livres/update2/{id}")
    public Livre updateLivre(@PathVariable int id, @RequestBody Livre livre) {
        livre.setId(id);
        return livreService.updateLivre(livre);
    }
	
	@PutMapping("/academia/livres/update3/{id}")
    public Livre updateLivre1(@PathVariable int id, @RequestBody Livre livre) {
        return livreService.updateLivre(livre, id);
    }
	
}
