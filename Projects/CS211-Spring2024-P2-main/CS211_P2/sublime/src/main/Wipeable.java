package src.main;
/*
 * This interface requires the concrete implementation of analyze and wipe
 */
public interface Wipeable extends Analyzable{
	
	/*
	 * This method, when invoked, should clear or reset the SystemWhole state (emulation, simulacra, simulation)
	 */
	void wipe();
}
