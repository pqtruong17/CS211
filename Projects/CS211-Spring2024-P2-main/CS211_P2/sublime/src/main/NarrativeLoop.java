package src.main;
import java.util.ArrayList;
import java.util.List;
/*
 * Categorize narrative processes under (EMULATION,SIMULACRA,SIMULATION)
 */
enum Realm {
	/*
	 * The emulationContext kind is in emulationContext but not in simulacraContext
	 */
	EMULATION,
	/*
	 * The simulacraContext kind is not in emulationContexts but is in simulacraContext
	 */
	SIMULACRA,
	/*
	 * The simulacraContext kind is in both emulationContexts and simulacraContext
	 */
	SIMULATION
}

/*
 * Populate the List of all three individual ArrayLists (emulation, simulacra, simulation) under 
 * the logic for filtering SystemWhole parts by kind using determineReam.
 * 
 */
public abstract class NarrativeLoop {
	/*
	 * Place holder to be populate under presumption of Realm.EMULATION
	 */
	protected final List<SystemWhole> emulation = new ArrayList<>();
	
	/*
	 * Place holder to be populate under presumption of Realm.SIMULACRA
	 */
	protected final List<SystemWhole> simulacra = new ArrayList<>();
	
	/*
	 * Place holder to be populate under presumption of Realm.SIMULATION
	 */
	protected final List<SystemWhole> simulation = new ArrayList<>();
	
	/*
	 * A logic gate switch which determine whether or not  (emulation, simulacra, simulation) to be added.
	 */
	private boolean addSwitch;
	
	/*
	 * This clear emulation, simulacra, and simulation lists of SystemWhole
	 * @see List.clear() API docs
	 */
	public void wipeNarrativeLoops() {
		emulation.clear();
		simulacra.clear();
		simulation.clear();
	}
	
	/* 
	 * A setter method which utilize enum Realm logic to populate the prospective ArrayList of emulation, emulation, and simulation.
	 * Use get kind per Machine to determineRealm between emulationContext and simulacraContext. 
	 * If kind is originally from emulationContext, add SystemWhole to emulation.
	 * Use get kind per Machine to determineRealm between emulationContext and simulacraContext.
	 * If kind is originally from simulacraContext, add SystemWhole to simulacra.
	 * If kind is originally from simulacraContext, add SystemWhole to simulation.
	 * @param emulationContext SystemWhole array of context to be emulate.
	 * @param simulacraContext SystemWhole array of context to be simulacra.
	 * @see reify() at SystemWhole
	 */
	public void updateNarrativeLoops(SystemWhole[] emulationContext, SystemWhole[] simulacraContext) {
		
		for(int i = 0; i < emulationContext.length; i++) {
			List<Machine> machines = emulationContext[i].reify();
			for (int j = 0; j < machines.size(); j++) {
				String kind = machines.get(j).getKind();
				SystemWhole system = emulationContext[i];
				switch(determineRealm(kind, emulationContext, simulacraContext)) {
					case EMULATION:
						addSwitch = (!containsKind(emulation,kind)) ? emulation.add(system):false;
						break;
					default:
						break; 
				}
			}
		}
		
		for(int i = 0; i < simulacraContext.length; i++) {
			List<Machine> machines = simulacraContext[i].reify();
			for (int j = 0; j < machines.size(); j++) {
				String kind = machines.get(j).getKind();
				SystemWhole system = simulacraContext[i];
				switch(determineRealm(kind, emulationContext, simulacraContext)) {
					case SIMULACRA:
						addSwitch = (!containsKind(simulacra,kind)) ? simulacra.add(system):false;
						break;
					case SIMULATION:
						addSwitch = (!containsKind(simulation,kind)) ? simulation.add(system):false;
						break;
					default:
						break; 
				}
			
			}
		}
		
	}
	
	/*
	 * Check for the presence of the Machine kind in both emulationContext and simulacraContext using isInContext.
	 * If the kind is found in both contexts, then assign Realm.SIMULATION.
	 * If the kind is found only in simulacraContext, Realm.SIMULACRA.
	 * Default to Realm.EMULATION if neither of the above conditions is met.
	 * @param kind machines kind per Machine 
	 * @param emulationContext SystemWhole array of context to be emulate.
	 * @param simulacraContext SystemWhole array of context to be simulacra.
	 * @return Realm in context of MULATION, SIMULACRA, and SIMULATION. 
	 */
	private final Realm determineRealm(String kind, SystemWhole[] emulationContext, SystemWhole[] simulacraContext) {
		boolean kindInEmulation = isInContext(kind, emulationContext);
		boolean kindInSimulacra = isInContext(kind, simulacraContext);
		if (kindInEmulation && kindInSimulacra) {
			return Realm.SIMULATION;
		}
		if (!kindInEmulation && kindInSimulacra) {
			return Realm.SIMULACRA;
		}
		return Realm.EMULATION;
	}
	
	/*
	 * Check if kind exists in SystemWhole array context
	 * @param kind is machine self identification
	 * @param context contains SystemWhole array of individual Machines
	 * @return boolean true if match, otherwise false.
	 */
	private final boolean isInContext(String kind, SystemWhole[] context) {
		 for(int i = 0; i < context.length; i++) {
			 List<Machine> machines = context[i].reify();
			 for (int j = 0; j < machines.size(); j++) {
				 if (machines.get(j).getKind().equals(kind)) {
					 return true;
				 }
			 }
		 }
		 return false;
	 }
	
	/*
	 * Check if kind exists in SystemWhole list(emulation, simulacra, or simulation) 
	 * @param kind is machine self identification
	 * @param list contains SystemWhole list of individual Machines
	 * @return boolean true if match, otherwise false.
	 */
	private final boolean containsKind(List<SystemWhole> list, String kind){
		for(int i = 0; i < list.size(); i++) {
			List<Machine> machines = list.get(i).reify();
			 for (int j = 0; j < machines.size(); j++) {
				 if (machines.get(i).getKind().equals(kind)) {
					 return true;
				 }
			 }
		}
		return false;
	 }
}
