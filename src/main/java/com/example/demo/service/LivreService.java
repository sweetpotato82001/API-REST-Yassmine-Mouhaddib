package com.example.demo.service;

import java.util.Date;
import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Livre;
import com.example.demo.repos.LivreRepo;

@Service
public class LivreService {
@Autowired
private LivreRepo livreRepo;


public List<Livre> findAll()
{
	//return livreRepo.findAll();
	return livreRepo.findAllByOrderByIdAsc();
}
public Livre findByid( Integer id)
{
	return livreRepo.findByid(id);
}

public void deleteAllLivres()
{
	livreRepo.deleteAll();
}
public void deleteByidBook(Integer id)
{
	if(livreRepo.findByid(id)!=null)
	{
		livreRepo.deleteByid(id);
	}
	else {
		System.out.println("the book doesn't exist");
	}
}

public Livre updateLivre(Livre livre) {
    return livreRepo.save(livre);

}

public Livre updateLivre(Livre livre , Integer id) {
    Livre l = livreRepo.findByid(id);
    if(l != null) {
    	 Date now = new Date(System.currentTimeMillis());
        l.setDate_derniere_consultation(now);
        l.setAuteur(livre.getAuteur());
        l.setDisponible(livre.getDisponible());
        l.setDate_sortie(livre.getDate_sortie());
        l.setNbr_page(livre.getNbr_page());
        l.setTitre(livre.getTitre());
    }
    return livreRepo.save(l);
}

}
