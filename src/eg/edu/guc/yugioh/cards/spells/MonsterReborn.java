package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class MonsterReborn extends SpellCard {

	public MonsterReborn(String name, String desc) {

		super(name, desc);

	}

	public void action(MonsterCard monster) {
		
//		boolean flag=true;
//		
//		for(int i =0;i<getBoard().getActivePlayer().getField().getGraveyard().size();i++){
//			if(getBoard().getActivePlayer().getField().getGraveyard().get(i)instanceof MonsterCard)
//				flag=false;
//		}
//		for(int j =0;j<getBoard().getOpponentPlayer().getField().getGraveyard().size();j++){
//			if(getBoard().getOpponentPlayer().getField().getGraveyard().get(j)instanceof MonsterCard)
//				flag=false;
//		}
//		
//		if(flag)
//			return;

		MonsterCard activeStongest = Card.getBoard().getActivePlayer()
				.getField().strongestMonsterInGraveyard();
		MonsterCard opponentStongest = Card.getBoard().getOpponentPlayer()
				.getField().strongestMonsterInGraveyard();

		if (opponentStongest.getAttackPoints() < activeStongest
				.getAttackPoints()) {

			Card.getBoard().getActivePlayer().getField().getMonstersArea()
					.add(activeStongest);

			Card.getBoard().getActivePlayer().getField().getGraveyard()
					.remove(activeStongest);

			activeStongest.setLocation(Location.FIELD);

		} else {

			Card.getBoard().getActivePlayer().getField().getMonstersArea()
					.add(opponentStongest);

			Card.getBoard().getOpponentPlayer().getField().getGraveyard()
					.remove(opponentStongest);

			opponentStongest.setLocation(Location.FIELD);

		}

	}

}
