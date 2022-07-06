package org.acme.domaine;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.quarkus.runtime.annotations.IgnoreProperty;
import io.quarkus.transaction.annotations.Rollback;

@Entity
public class Command {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	LocalDate date;
	
	@Transient
	Client client;
	
	long idclient;
	
	
	//@JsonManagedReference
	@OneToMany(mappedBy = "commande", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	Set<Composant> composants=new HashSet<>();

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public long getIdclient() {
		return idclient;
	}

	public void setIdclient(long idclient) {
		this.idclient = idclient;
	}

	public Set<Composant> getComposants() {
		return composants;
	}

	public void setComposants(Set<Composant> composants) {
		this.composants = composants;
	}
	
	
	
}
