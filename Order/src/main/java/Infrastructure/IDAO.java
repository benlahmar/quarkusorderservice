package Infrastructure;

import org.acme.domaine.Command;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface IDAO extends PanacheRepository<Command>{

	public void addcommand(Command c);
	public Command findcmd(long id);
}
