package org.acme.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Composant {

	@Id
	@GeneratedValue
	long id;
	int qte;
	
	@Transient
	Produit produit;
	
	long idproduit;
	
	double prix;
	
	//@JsonBackReference
	@JsonIgnore
	@ManyToOne()
	Command commande;
	
	
	
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public long getIdproduit() {
		return idproduit;
	}
	public void setIdproduit(long idproduit) {
		this.idproduit = idproduit;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Command getCommande() {
		return commande;
	}
	public void setCommande(Command commande) {
		this.commande = commande;
	}
	
	
	
}
