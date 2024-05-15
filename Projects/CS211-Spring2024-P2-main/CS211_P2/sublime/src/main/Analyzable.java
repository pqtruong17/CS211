package src.main;
/*
 * This interface requires the concrete implementation of analyze
 */
public interface Analyzable {
	
	/*
	 * This method analyzes the current memory states of List of SystemWhole ( emulation, simulacra, simulation)
	 * @returns MemorySnapshot 
	 */
	MemorySnapshot analyze();
	
}
