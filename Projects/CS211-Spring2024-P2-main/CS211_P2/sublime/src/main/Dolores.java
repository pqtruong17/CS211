package src.main;
import java.util.ArrayList;
import java.util.List;
public class Dolores extends Robot implements Wipeable {
	
	/*
	 * An Arraylist which holds NarrativeLoop type
	 */
	private List<NarrativeLoop> narrativeLoops = new ArrayList<NarrativeLoop>();
	
	/*
	 * Initializes Dolores with characteristics such as  emergences, serial number, and capabilities (flies, autonomous, teleoperated)
	 */
	public Dolores(){
		super(new String[]{},-1,false, false, false);
	}
	
	/*
	 * Add narrativeLoop only if its not null
	 * @param narrativeLoop is either HostLoop or MazeLoop
	 */
	public final void addNarrativeLoop(NarrativeLoop narrativeLoop) {
		narrativeLoops.add(narrativeLoop);	
	}
	
	/*
	 * Getting capabilities directly through Dolores is un-implemented
	 * @throws UnsupportedOperationException
	 * @return Machine[] 
	 */
	public final Machine[] getAbsoluteCapabilities() {
		throw new UnsupportedOperationException("Fetching absolute capabilities directly is not supported.");
	}
	
	/*
	 * It is ineffective on Dolores, it just returns false.
	 * @return boolean false
	 */
	public boolean freezeAllMotorFunctions() {
		return false;
	}
	
	/*
	 * If narrativeLoops is empty, then return null.
	 * return MemorySnapshot MemorySnapshot Record the list of SystemWhole (emulation, simulacra, simulation) 
	 */
	public MemorySnapshot analyze() {
		if (narrativeLoops.isEmpty()) {
			return null;
		}
		NarrativeLoop lastItem = narrativeLoops.get(narrativeLoops.size()-1);
		return new MemorySnapshot(lastItem.emulation, lastItem.simulacra, lastItem.simulation);
	}
	
	/*
	 * Dolores does nothing with this method, an empty implementation is all there is.
	 */
	@Override
	public void wipe() {

	}
}
