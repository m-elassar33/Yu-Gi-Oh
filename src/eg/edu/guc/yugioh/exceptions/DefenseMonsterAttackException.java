package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class DefenseMonsterAttackException extends RuntimeException {

	public DefenseMonsterAttackException() {
		super("Monster in Defense Mode Cannot Attack!");
	}
	
}
