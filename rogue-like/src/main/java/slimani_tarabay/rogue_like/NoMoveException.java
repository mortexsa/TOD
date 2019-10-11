package slimani_tarabay.rogue_like;
/**
 * Cette exception est pour au cas ou le joueur decider de bouger vers un DecorMap ou un Dragon
 * @author marianetarabay
 *
 */
public class NoMoveException extends Exception {
	NoMoveException()
	{
		super("Le joueur ne peut bouger dans cette direction");
	}
}
