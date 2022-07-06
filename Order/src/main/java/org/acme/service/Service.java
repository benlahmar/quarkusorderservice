package org.acme.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.domaine.Command;

import Infrastructure.IDAO;

@ApplicationScoped
public class Service implements IService{

	@Inject
	IDAO dao;
	
	@Override
	@Transactional
	public void addcommand(Command c) {
//		c.getComposants().stream()
//		.forEach(x-> x.setCommande(c));
		
		dao.addcommand(c);
		
		
	}

	@Override
	public Command findcmd(long id) {
		return dao.findcmd(id);
		
	}

}
