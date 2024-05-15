package src.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;
import java.util.concurrent.TimeUnit;

import src.main.*;

public class RepeatSystemWholeTest {
	private SystemWhole[] emulationContext;
	private SystemWhole[] simulacraContext;
	private MemorySnapshot memorySnapshot;
	private NarrativeLoop narrativeLoop = new HostLoop();	
	private Host host;
	private final SystemWhole empty = Bernard.analysis(new String[]{});
	private final SystemWhole sys1 = Bernard.analysis(new String[] {"kind:Square"});
	private final SystemWhole sys2 = Bernard.analysis(new String[] {"kind:Box"});
	
	@Nested
	@Order(1)
	class testHasSystemWholeRepeats{
		
		@AfterEach
		void display() {
			//System.out.println(getMemory(memorySnapshot.emulationMemory()));
			//System.out.println(getMemory(memorySnapshot.simulacraMemory()));
			//System.out.println(getMemory(memorySnapshot.simulationMemory()));
			host.wipe();
		}
		@Test
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		public void test1() {
			emulationContext = new SystemWhole[] { sys1, sys2, sys2, sys2};
			simulacraContext = new SystemWhole[] { sys1, sys1, sys1, sys1};
			narrativeLoop.updateNarrativeLoops(emulationContext, simulacraContext);
			host = new Host(narrativeLoop);
			memorySnapshot = host.analyze();
			assertFalse(hasSystemWholeRepeats(memorySnapshot.emulationMemory()));
			assertFalse(hasSystemWholeRepeats(memorySnapshot.simulacraMemory()));
			assertFalse(hasSystemWholeRepeats(memorySnapshot.simulationMemory()));
		}
		@Test
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		public void test2() {
			emulationContext = new SystemWhole[] {};
			simulacraContext = new SystemWhole[] {};
			host = new Host(narrativeLoop);
			memorySnapshot = host.analyze();
			assertFalse(hasSystemWholeRepeats(memorySnapshot.emulationMemory()));
			assertFalse(hasSystemWholeRepeats(memorySnapshot.simulacraMemory()));
			assertFalse(hasSystemWholeRepeats(memorySnapshot.simulationMemory()));
		}
		@Test
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		public void test3() {
			emulationContext = new SystemWhole[] {sys1,sys1,sys1,sys1,sys1};
			simulacraContext = new SystemWhole[] {empty};
			narrativeLoop.updateNarrativeLoops(emulationContext, simulacraContext);
			host = new Host(narrativeLoop);
			memorySnapshot = host.analyze();
			assertFalse(hasSystemWholeRepeats(memorySnapshot.emulationMemory()));
			assertFalse(hasSystemWholeRepeats(memorySnapshot.simulacraMemory()));
			assertFalse(hasSystemWholeRepeats(memorySnapshot.simulationMemory()));
		}
	}
	
    public static <T> boolean hasSystemWholeRepeats(List<T> arrayList) {
        HashSet<T> set = new HashSet<>();
        for (T element : arrayList) {
            if (!set.add(element)) {
                return true; 
            }
        }
        return false; 
    }
    
	public String getMemory(List<SystemWhole> context) {
		if (context.isEmpty()) {
			return "[]";
		}
		String str = "";
		for(int i = 0; i < context.size()-1; i++) {
			List<Machine> machines = context.get(i).reify();
			for(int j = 0; j < machines.size()-1; j++) {
				str += String.format("%s,",machines.get(j));
			}
			str += String.format("%s,",machines.get(machines.size()-1));
		}
		str += context.get(context.size()-1).reify();
		return str;
	}
}
