package Infrastructure;

import javax.enterprise.context.ApplicationScoped;

import org.acme.domaine.Command;

@ApplicationScoped
public class CommandDao implements IDAO{

	@Override
	public void addcommand(Command c) {
		
		persist(c);
		
	}

	@Override
	public Command findcmd(long id) {
		
		return findById(id);
	}

}
