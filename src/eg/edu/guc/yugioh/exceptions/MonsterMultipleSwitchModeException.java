package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class MonsterMultipleSwitchModeException extends RuntimeException {

	public MonsterMultipleSwitchModeException() {
		super("This Monster's Mode Was Switched Before!");
	}

}
