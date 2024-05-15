public class TemperatureCalculator {
    public int [] temperatures = {
        15, 22, 18, 25, 30, 
        19, 24, 20, 27, 21, 
        16, 29, 23, 17, 20, 
        28, 31, 26, 24, 19, 
        22, 27, 18, 16, 21, 
        29, 23, 20, 25, 28
    };
    public TemperatureCalculator()
    {}
    
    public int getTempByDay(int day){
        int currTemp = 0;
        try{
          currTemp = temperatures[day-1];
        } catch (ArrayIndexOutOfBoundsException  e){
          System.out.println("Invalid day");
          currTemp = -1;
        }
        return currTemp;
    }
    public int tempAvg(int firstDay, int lastDay) throws AverageException, IllegalRangeException {
      // throw AverageException for invalid range of firstDay and lastDay
      // throw IllegalRangeException if firstDay is greater than lastDay
        if (firstDay > lastDay){
          throw new AverageException("Last must be greater than first day");
        } else if ((firstDay < 0) || (lastDay > 30)) {
          throw new IllegalRangeException("First day and last day must be in range 1-30");
        }
        int tempSum = 0;
        int total = 0;
        int average = 0;
        for(total = firstDay; total < lastDay; total++){
          tempSum += temperatures[total]; 
        }
        average = tempSum/total; 
        // System.out.printf("The average is (%d)/(%d) = %d\n", tempSum, total, average);
        return average;
    }
}