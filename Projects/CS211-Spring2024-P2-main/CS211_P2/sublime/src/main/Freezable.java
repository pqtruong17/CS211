package src.main;
/*
 * This interface requires the concrete implementation of freeze
 */
public interface Freezable {
	
	/*
	 * @return boolean whether or not functionality to temporarily suspend their operation.
	 */
	boolean freeze();
	
}
