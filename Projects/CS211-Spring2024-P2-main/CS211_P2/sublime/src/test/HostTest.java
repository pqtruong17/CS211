package src.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import src.main.Bernard;
import src.main.Freezable;
import src.main.Host;
import src.main.HostLoop;
import src.main.MazeLoop;
import src.main.MemorySnapshot;
import src.main.NarrativeLoop;
import src.main.SystemWhole;

public class HostTest {
	private SystemWhole[] emulationContext;
	private SystemWhole[] simulacraContext;
	private MemorySnapshot memorySnapshot;
	private Host host;
	private final SystemWhole empty = Bernard.analysis(new String[] {});
	private final SystemWhole sys1 = Bernard.analysis(new String[] { "kind:Square" });
	private final SystemWhole sys2 = Bernard.analysis(new String[] { "kind:Box" });

	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public boolean testWipeNarrativeLoops(NarrativeLoop narrativeLoop) {
		if (narrativeLoop != null) {
			narrativeLoop.updateNarrativeLoops(emulationContext, simulacraContext);
		}
		host = new Host(narrativeLoop);
		memorySnapshot = host.analyze();
		try {
			if (memorySnapshot != null) {
				List<SystemWhole> emulationMemory = memorySnapshot.emulationMemory();
				List<SystemWhole> simulacraMemory = memorySnapshot.simulacraMemory();
				List<SystemWhole> simulationMemory = memorySnapshot.simulationMemory();
				host.wipe();
				assertTrue(emulationMemory.isEmpty());
				assertTrue(simulacraMemory.isEmpty());
				assertTrue(simulationMemory.isEmpty());
			} else {
				assertNull(memorySnapshot);
			}
			return true;
		} catch (AssertionError e) {
			return false;
		}
	}
	
	@Nested
	@Order(1)
	class FreezableTests {
		public boolean testFreeze(Freezable host) {
			try {
				assertTrue(host.freeze());
				return true;
			} catch (AssertionError e) {
				return false;
			}
		}

		@Test
		@DisplayName("Cast Freezeable on Host")
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		public void test1() {
			assertTrue(testFreeze((Freezable) new Host(null)));
		}

		@Test
		@DisplayName("Freezeable null Host")
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		public void test2() {
			assertTrue(testFreeze(new Host(null)));
		}
	}

	@Nested
	@Order(2)
	class AnalyzeTests {
		@Test
		@DisplayName("Analyze Host with a null NarrativeLoop")
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		public void testAnalyzeNarrativeLoopNull() {
			assertNull(new Host(null).analyze());
		}
		@Test
		@DisplayName("Analyze Host with a new MazeLoop")
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		public void testAnalyzeMazeLoop() {
			assertNotNull(new Host(new MazeLoop()).analyze());
		}
		@Test
		@DisplayName("Analyze Host with a new HostLoop")
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		public void testAnalyzeHostLoop() {
			assertNotNull(new Host(new HostLoop()).analyze());
		}
	}
	@Nested
	@Order(3)
	class WipeTests{
		@Test
		@DisplayName("Wipe Host with a new MazeLoop")
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		public void test1() {
			emulationContext = new SystemWhole[] { sys1, sys2, sys2, sys2};
			simulacraContext = new SystemWhole[] { sys1, sys1, sys1, sys1};
			assertFalse(testWipeNarrativeLoops(new MazeLoop()));
			memorySnapshot = host.analyze();
		}
		@Test
		@DisplayName("Wipe Host with a new HostLoop")
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		public void testAnalyzeWipeHostLoop() {
			emulationContext = new SystemWhole[] { sys1, sys2, empty};
			simulacraContext = new SystemWhole[] { sys1, empty, sys2};
			assertTrue(testWipeNarrativeLoops(new HostLoop()));
		}
	}

}
