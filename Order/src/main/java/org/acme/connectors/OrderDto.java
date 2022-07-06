package org.acme.connectors;

import java.time.LocalDate;

public class OrderDto {

	long idcmd;
	long idproduit;
	int qte_dde;
	LocalDate date=LocalDate.now();
	public long getIdcmd() {
		return idcmd;
	}
	public void setIdcmd(long idcmd) {
		this.idcmd = idcmd;
	}
	public long getIdproduit() {
		return idproduit;
	}
	public void setIdproduit(long idproduit) {
		this.idproduit = idproduit;
	}
	public int getQte_dde() {
		return qte_dde;
	}
	public void setQte_dde(int qte_dde) {
		this.qte_dde = qte_dde;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
}
