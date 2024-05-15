// Edit class name
public class CustomInteger extends Number{

    private int value;

    public CustomInteger(int value) {
     setValue(value+1);
    }
    public void setValue(int value) {
     this.value = value;
    }
    @Override
    public String toString(){
        return ""+value;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return Long.valueOf(value);
    }

    @Override
    public float floatValue() {
        return Float.valueOf(value);
    }

    @Override
    public double doubleValue() {
        return Double.valueOf(value);
    }

}
