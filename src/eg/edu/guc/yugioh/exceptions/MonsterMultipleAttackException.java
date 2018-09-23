package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class MonsterMultipleAttackException extends RuntimeException {

	public MonsterMultipleAttackException() {
		super("Your Monster Has Attacked Before!");
	}

}
