interface MathExpressions
{
    // An abstract function
    void operate(double x, double y);
 
}
 
class LambdaPractice
{
    public static void main(String args[])
    {
    	MathExpressions obj1 = (double x, double y) ->{
        	System.out.printf("(%.2f)+(%.2f)=%.2f\n" ,x,y,x+y); 
        };
        obj1.operate(3, -1);
    	MathExpressions obj2 = (double x, double y) ->{
        	System.out.printf("(2*%.2f)/(7*%.2f)=%.2f\n" ,x,y,(2*x)/(7*y)); 
        };
        obj2.operate(3, -1);
    	MathExpressions obj3 = (double x, double y) ->{
        	System.out.print("(2*"+String.format("%.2f)+",x) + String.format("(%.2f*",x)+String.format("%.2f)",y)+String.format("+(-3*%.2f)+",x)+73 +"=");
        	System.out.println((2*x)+(x*y)-(3*y)+73);
        };
        obj3.operate(3, -1);
    }
}