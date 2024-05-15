package src.main;
/*
 * The Host class equipped with mechanisms for narrative analysis, memory management, and operational control.
 */
public class Host extends Dolores implements Freezable{
	
	/*
	 * This field holds a reference to the NarrativeLoop instance associated with this Host
	 */
	private final NarrativeLoop narrativeLoop;
	
	/*
	 * Automatically calls the in-heriented Dolores default constructor
	 * Add narrativeLoop a separate new private feild narrativeLoops inherited from Dolores
	 * @param narrativeLoop a NarrativeLoop instances
	 */
	public Host(NarrativeLoop narrativeLoop){
		this.narrativeLoop = narrativeLoop;
		super.addNarrativeLoop(narrativeLoop);
	}
	
	/*
	 * Freeze command will always be successful every time it's called.
	 * @return boolean true
	 */
	@Override
	public boolean freezeAllMotorFunctions() {
		return true;
	}
	
	/* 
	 * If narrativeLoop is null, then return null
	 * @return MemorySnapshot Record the list of SystemWhole (emulation, simulacra, simulation) 
	 */
	@Override
	public MemorySnapshot analyze() {
		if(narrativeLoop == null) {
			return null;
		}
		return new MemorySnapshot(narrativeLoop.emulation, narrativeLoop.simulacra, narrativeLoop.simulation);
	}
	
	/*
	 * Calls the wipeNarrativeLoops() method of the narrativeLoop field
	 */
	@Override
	public void wipe() {
		this.narrativeLoop.wipeNarrativeLoops();
	}
	
	/* Calling freezeAllMotorFunctions() to implement freeze
	 * return boolean true
	 */
	@Override
	public boolean freeze() {
		return this.freezeAllMotorFunctions();
	}
}
