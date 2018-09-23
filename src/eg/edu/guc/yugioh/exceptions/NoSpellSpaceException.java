package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class NoSpellSpaceException extends NoSpaceException {

	public NoSpellSpaceException() {
		super("Your Spell Area Is Full!");
	}

}
