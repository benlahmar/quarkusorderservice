package org.acme.service;

import org.acme.domaine.Command;

public interface IService {

	public void addcommand(Command c);
	public Command findcmd(long id);
}
