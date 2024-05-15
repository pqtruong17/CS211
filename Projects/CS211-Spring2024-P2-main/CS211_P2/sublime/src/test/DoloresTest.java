package src.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import src.main.Bernard;
import src.main.Dolores;
import src.main.HostLoop;
import src.main.Machine;
import src.main.MazeLoop;
import src.main.MemorySnapshot;
import src.main.NarrativeLoop;
import src.main.SystemWhole;

//For this project, it is OK to place all tests in this class. Prefer creating a test class per project class.
public class DoloresTest {
	private SystemWhole[] emulationContext;
	private SystemWhole[] simulacraContext;
	private MemorySnapshot memorySnapshot;
	private Dolores host = new Dolores();;
	private final SystemWhole sys1 = Bernard.analysis(new String[] { "kind:Square" });
	private final SystemWhole sys2 = Bernard.analysis(new String[] { "kind:Box" });

	@Nested
	@Order(1)
	class FreezableTests {
		public boolean testFreezeAllMotorFunctions(Dolores host) {
			try {
				assertFalse(host.freezeAllMotorFunctions());
				return true;
			} catch (AssertionError e) {
				return false;

			}
		}


		@Test
		@DisplayName("Dolores freezeAllMotorFunctions")
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		public void test1() {
			assertTrue(testFreezeAllMotorFunctions(new Dolores()));
		}
		@Test
		@DisplayName("Dolores ClassCastException")
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		public void test2() {
			try {
				testFreezeAllMotorFunctions((Dolores) new Object());
			}catch(ClassCastException ex) {
				assertEquals(ex,ex);
			}
		}
	}
 
	@Nested
	@Order(2)
	class AnalyzeTests{
		@Test
		@DisplayName("Analyze a null NarrativeLoop")
		public void test1() {
			host.addNarrativeLoop(null);
			assertNull(host.analyze());
		}
		@Test
		@DisplayName("Analyze a new HostLoop")
		public void test2() {
			host.addNarrativeLoop(new HostLoop());
			assertNotNull(host.analyze());
		}
		@Test
		@DisplayName("Analyze a new MazeLoop")
		public void test3() {
			host.addNarrativeLoop(new HostLoop());
			assertNotNull(host.analyze());
		}
	}
	@Nested
	@Order(3)
	class WipeTests {
		@AfterEach
		void display() {
			System.out.println(host.analyze());
		}
		public boolean testWipe(NarrativeLoop narrativeLoop) {
			if (narrativeLoop != null) {
				narrativeLoop.updateNarrativeLoops(emulationContext, simulacraContext);
			}
			host.addNarrativeLoop(narrativeLoop);
			memorySnapshot = host.analyze();
			try {
				if (memorySnapshot != null) {
					List<SystemWhole> emulation = memorySnapshot.emulationMemory();
					List<SystemWhole> simulacra = memorySnapshot.simulacraMemory();
					List<SystemWhole> simulation = memorySnapshot.emulationMemory();
					host.wipe();
					assertTrue(emulation.isEmpty());
					assertTrue(simulacra.isEmpty());
					assertTrue(simulation.isEmpty());
				} else {
					assertNull(memorySnapshot);
				}
				return true;
			} catch (AssertionError e) {
				return false;
			}
		}
	
		@Test
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		@DisplayName("Wipe a null NarrativeLoop")
		public void test1() {
			assertTrue(testWipe(null));
		}
		@Test
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		@DisplayName("EmulationContext and SimulacraContext is null")
		public void test3() {
			try {
				assertTrue(testWipe(new MazeLoop()));
				assertTrue(testWipe(new HostLoop()));
			} catch (NullPointerException ex) {
				assertEquals(ex,ex);
			}
		}
		@Test
		@DisplayName("Wipe an analyzed HostLoop")
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		public void test4() {
			emulationContext = new SystemWhole[] { sys1, sys2 };
			simulacraContext = new SystemWhole[] { sys1 };
			assertFalse(testWipe(new HostLoop()));
		}

		@Test
		@DisplayName("Wipe an analyzed MazeLoop")
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		public void test5() {
			emulationContext = new SystemWhole[] { sys2 };
			simulacraContext = new SystemWhole[] { sys1 };
			assertFalse(testWipe(new MazeLoop()));
		}
		@Test
		@Order(5)
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		@DisplayName("Wipe empty new HostLoop and MazeLoop")
		public void test6() {
			emulationContext = new SystemWhole[] {};
			simulacraContext = new SystemWhole[] {};
			assertTrue(testWipe(new HostLoop()));
			assertTrue(testWipe(new MazeLoop()));
		}
		
	}

	@Nested
	@Order(4)
	class AbsoluteCapabilitiesTest {
		@Test
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		@DisplayName("UnsupportedOperationException Example")
		public void testAbsoluteCapabilitiesException() {
			try {
				Machine[] capabilities = host.getAbsoluteCapabilities();
			} catch (UnsupportedOperationException ex) {
				assertEquals("Fetching absolute capabilities directly is not supported.", ex.getMessage());
			}
		}
	}
}
