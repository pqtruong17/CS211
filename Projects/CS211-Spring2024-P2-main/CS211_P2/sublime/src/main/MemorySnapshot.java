package src.main;
import java.util.List;
public record MemorySnapshot(
		
		/*
		 * List of SystemWhole of emulation place holder 
		 */
		List<SystemWhole> emulationMemory,
		
		/*
		 * List of SystemWhole of simulacra place holder 
		 */
		List<SystemWhole> simulacraMemory,
		
		/*
		 * List of SystemWhole of simulation place holder 
		 */
		List<SystemWhole> simulationMemory) {}
