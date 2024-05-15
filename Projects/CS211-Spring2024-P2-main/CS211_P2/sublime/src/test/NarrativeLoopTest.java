package src.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import src.main.*;


public class NarrativeLoopTest {
	private SystemWhole[] emulationContext;
	private SystemWhole[] simulacraContext;
	private MemorySnapshot memorySnapshot;
	private NarrativeLoop narrativeLoop = new HostLoop();	
	private Host host = new Host(narrativeLoop);
	private final SystemWhole empty = Bernard.analysis(new String[]{});
	private final SystemWhole sys1 = Bernard.analysis(new String[] {"kind:Square"});
	private final SystemWhole sys2 = Bernard.analysis(new String[] {"kind:Box"});
    
	@AfterEach
	void setUp() {
		host.wipe();
	}
	

	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test1() {
        emulationContext = new SystemWhole[]{empty};
        simulacraContext = new SystemWhole[]{empty};
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	memorySnapshot = host.analyze();
		assertTrue(memorySnapshot.emulationMemory().isEmpty());
		assertTrue(memorySnapshot.simulacraMemory().isEmpty());
		assertTrue(memorySnapshot.simulationMemory().isEmpty());
	}
	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test2() {
        emulationContext = new SystemWhole[]{empty};
        simulacraContext = new SystemWhole[]{sys1};
    	host = new Host(narrativeLoop);
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	host = new Host(narrativeLoop);
    	memorySnapshot = host.analyze();
	    assertTrue(memorySnapshot.emulationMemory().isEmpty());
		assertTrue(memorySnapshot.simulacraMemory().contains((Object) simulacraContext[0]));
		assertTrue(memorySnapshot.simulationMemory().isEmpty());
	}
	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test3() {
        emulationContext = new SystemWhole[]{empty};
        simulacraContext = new SystemWhole[]{sys2};
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	memorySnapshot = host.analyze();
		assertTrue(memorySnapshot.emulationMemory().isEmpty());
		assertTrue(memorySnapshot.simulacraMemory().contains((Object) simulacraContext[0]));
		assertTrue(memorySnapshot.simulationMemory().isEmpty());
	}
	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test4() {
        emulationContext = new SystemWhole[]{empty};
        simulacraContext = new SystemWhole[]{sys1,sys2};
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	memorySnapshot = host.analyze();
		assertTrue(memorySnapshot.emulationMemory().isEmpty());
		assertTrue(memorySnapshot.simulacraMemory().contains((Object) simulacraContext[0]));
		assertTrue(memorySnapshot.simulacraMemory().contains((Object) simulacraContext[1]));
		assertTrue(memorySnapshot.simulationMemory().isEmpty());
	}
	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test5() {
        emulationContext = new SystemWhole[]{sys1};
        simulacraContext = new SystemWhole[]{sys1};
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	memorySnapshot = host.analyze();
		assertTrue(memorySnapshot.emulationMemory().isEmpty());
		assertTrue(memorySnapshot.simulacraMemory().isEmpty());
		assertTrue(memorySnapshot.simulationMemory().contains((Object) simulacraContext[0]));
	}
	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test6() {
        emulationContext = new SystemWhole[]{sys1};
        simulacraContext = new SystemWhole[]{sys2};
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	memorySnapshot = host.analyze();
    	assertTrue(memorySnapshot.emulationMemory().contains((Object) emulationContext [0]));
    	assertTrue(memorySnapshot.simulacraMemory().contains((Object) simulacraContext [0]));
    	assertTrue(memorySnapshot.simulationMemory().isEmpty());
	}
	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test7() {
        emulationContext = new SystemWhole[]{sys1};
        simulacraContext = new SystemWhole[]{sys1,sys2};
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	memorySnapshot = host.analyze();
    	assertTrue(memorySnapshot.emulationMemory().isEmpty());
    	assertTrue(memorySnapshot.simulacraMemory().contains((Object) simulacraContext [1]));
    	assertTrue(memorySnapshot.simulationMemory().contains((Object) simulacraContext[0]));
	}
	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test8() {
        emulationContext = new SystemWhole[]{sys1};
        simulacraContext = new SystemWhole[]{empty};
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	memorySnapshot = host.analyze();
    	assertTrue(memorySnapshot.emulationMemory().contains((Object) emulationContext [0]));
    	assertTrue(memorySnapshot.simulacraMemory().isEmpty());
    	assertTrue(memorySnapshot.simulationMemory().isEmpty());
	}
	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test9() {
        emulationContext = new SystemWhole[]{sys2};
        simulacraContext = new SystemWhole[]{sys2};
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	memorySnapshot = host.analyze();
    	assertTrue(memorySnapshot.emulationMemory().isEmpty());
    	assertTrue(memorySnapshot.simulacraMemory().isEmpty());
    	assertTrue(memorySnapshot.simulationMemory().contains((Object) simulacraContext[0]));
	}
	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test10() {
        emulationContext = new SystemWhole[]{sys2};
        simulacraContext = new SystemWhole[]{sys1,sys2};
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	memorySnapshot = host.analyze();
    	assertTrue(memorySnapshot.emulationMemory().isEmpty());
    	assertTrue(memorySnapshot.simulacraMemory().contains((Object) simulacraContext [0]));
    	assertTrue(memorySnapshot.simulationMemory().contains((Object) simulacraContext[1]));
	}
	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test11() {
        emulationContext = new SystemWhole[]{sys2};
        simulacraContext = new SystemWhole[]{sys1};
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	memorySnapshot = host.analyze();
    	assertTrue(memorySnapshot.emulationMemory().contains((Object) emulationContext [0]));
    	assertTrue(memorySnapshot.simulacraMemory().contains((Object) simulacraContext [0]));
    	assertTrue(memorySnapshot.simulationMemory().isEmpty());
	}
	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test12() {
        emulationContext = new SystemWhole[]{sys2};
        simulacraContext = new SystemWhole[]{empty};
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	memorySnapshot = host.analyze();
    	assertTrue(memorySnapshot.emulationMemory().contains((Object) emulationContext [0]));
    	assertTrue(memorySnapshot.simulacraMemory().isEmpty());
    	assertTrue(memorySnapshot.simulationMemory().isEmpty());
	}
	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test13() {
        emulationContext = new SystemWhole[]{sys1,sys2};
        simulacraContext = new SystemWhole[]{sys1,sys2};
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	memorySnapshot = host.analyze();
    	assertTrue(memorySnapshot.emulationMemory().isEmpty());
    	assertTrue(memorySnapshot.simulacraMemory().isEmpty());
    	assertTrue(memorySnapshot.simulationMemory().contains((Object) simulacraContext [0]));
    	assertTrue(memorySnapshot.simulationMemory().contains((Object) simulacraContext [1]));
	}
	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test14() {
        emulationContext = new SystemWhole[]{sys1,sys2};
        simulacraContext = new SystemWhole[]{sys2};
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	memorySnapshot = host.analyze();
    	assertTrue(memorySnapshot.emulationMemory().contains((Object) emulationContext [0]));
    	assertTrue(memorySnapshot.simulacraMemory().isEmpty());
    	assertTrue(memorySnapshot.simulationMemory().contains((Object) simulacraContext [0]));
	}
	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test15() {
        emulationContext = new SystemWhole[]{sys1,sys2};
        simulacraContext = new SystemWhole[]{sys1};
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	memorySnapshot = host.analyze();
    	assertTrue(memorySnapshot.emulationMemory().contains((Object) emulationContext [1]));
    	assertTrue(memorySnapshot.simulacraMemory().isEmpty());
    	assertTrue(memorySnapshot.simulationMemory().contains((Object) simulacraContext [0]));
	}
	@Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
	public void test16() {
        emulationContext = new SystemWhole[]{sys1,sys2};
        simulacraContext = new SystemWhole[]{empty};
    	narrativeLoop.updateNarrativeLoops(emulationContext,simulacraContext);
    	memorySnapshot = host.analyze();
    	assertTrue(memorySnapshot.emulationMemory().contains((Object) emulationContext [0]));
    	assertTrue(memorySnapshot.emulationMemory().contains((Object) emulationContext [1]));
    	assertTrue(memorySnapshot.simulacraMemory().isEmpty());
    	assertTrue(memorySnapshot.simulationMemory().isEmpty());
	}
}
