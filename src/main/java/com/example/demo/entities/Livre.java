package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
@Entity @Data
@DynamicUpdate
public class Livre {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
   Integer id;
	
	@Column(length=50,nullable=false)
   String titre;
	
	@Column(nullable=false,updatable=false)
   String edition;
	
	@Column(nullable=false)
	@Temporal(value=TemporalType.DATE)
   Date date_sortie;
	
	@Column(nullable=false)
   String auteur;
	
	@Column(nullable=false)
   Integer nbr_page;
	
   @Column(unique=true,nullable=false,updatable=false)
   String ISBN;
   
   @Column(nullable=false)
   @Temporal(value=TemporalType.TIMESTAMP)
   Date date_derniere_consultation;
   
   @Column(nullable=false)
   Boolean disponible;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public String getEdition() {
	return edition;
}

public void setEdition(String edition) {
	this.edition = edition;
}


public Date getDate_sortie() {
	return date_sortie;
}

public void setDate_sortie(Date date_sortie) {
	this.date_sortie = date_sortie;
}

public String getAuteur() {
	return auteur;
}

public void setAuteur(String auteur) {
	this.auteur = auteur;
}

public Integer getNbr_page() {
	return nbr_page;
}

public void setNbr_page(Integer nbr_page) {
	this.nbr_page = nbr_page;
}

public String getISBN() {
	return ISBN;
}

/*public void setISBN(String iSBN) {
	ISBN = iSBN;
}
*/

public Date getDate_derniere_consultation() {
	return date_derniere_consultation;
}

public void setDate_derniere_consultation(Date date_derniere_consultation) {
	this.date_derniere_consultation = date_derniere_consultation;
}

public Boolean getDisponible() {
	return disponible;
}

public void setDisponible(Boolean disponible) {
	this.disponible = disponible;
}
   
}
