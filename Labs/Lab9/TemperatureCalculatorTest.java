import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
public class TemperatureCalculatorTest {
  public static void main(String args[]){
   //org.junit.runner.JUnitCore.main("TemperatureCalculatorTest");
  getTempByDayTest();
    
  }
  @Test public static void getTempByDayTest() {
    TemperatureCalculator temperatureCalculator = new TemperatureCalculator();
    int inputValue = 2;
    int expectedValue = 33;
    String errorMessageString = String.format("Temperature(%d) incorrect", expectedValue);
    getTemperatureAverageExceptionTest(0,2);
    getTemperatureAverageExceptionTest(22,1);
    getTemperatureAverageExceptionTest(1,33);
    
  }
  static void getTemperatureAverageExceptionTest(int firstDay, int lastDay) {
    try{
      TemperatureCalculator tempCalc = new TemperatureCalculator();
      int output = tempCalc.tempAvg(firstDay, lastDay);
    }
    catch(AverageException ex) {
      assertEquals("Last must be greater than first day", ex.getMessage());
      System.out.println(-1);
    } catch (IllegalRangeException e) {
      assertEquals("First day and last day must be in range 1-30", e.getMessage());
      System.out.println(-2);
    } 
  }
}

