package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class NoMonsterSpaceException extends NoSpaceException {
	
	public NoMonsterSpaceException() {
		super("Your Monster Area Is Full!");
	}

}
