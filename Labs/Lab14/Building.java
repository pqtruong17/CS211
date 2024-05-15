import java.util.*;

public class Building{

	public String address;
	public String name;
	public ArrayList<Room> roomList;

    //inner class
	public class Room{

        // TODO:
        int squareFeet;
        public Room(int squareFeet) {
        	this.squareFeet = squareFeet;
        }
        public String toString() {
        	return String.format("The room is %d square feets.", squareFeet);
        }
	}
    
    //constructor
    public Building(String address, String name, int[] squareFeetList){
    
        this.address = address;
        this.name = name;
        roomList = new ArrayList<Room>();
        
        for (int i=0; i<squareFeetList.length; i++){
            Room r = new Room(squareFeetList[i]);
            roomList.add(r);
        }      
    }
    
	public ArrayList<Room> orderRoomsBySpace(){
	
	    //method local inner class
		// TODO:
		
	    Collections.sort(this.roomList, new Comparator<Room>() {
			@Override
			public int compare(Building.Room o1, Building.Room o2) {
				return Integer.compare(o1.squareFeet, o2.squareFeet);
			}
	    } );
	    return roomList;
	}
  
    public static void main(String args[])
    {
        int[] temp = new int[4];
        temp[0] = 23;
        temp[1] = 2777;
        temp[2] = 15;
        temp[3] = 777;
        Building b = new Building("123 Fake St", "Observatory", temp);
        for (Room r: b.roomList){
            System.out.println(r);
        }
        //23
        //15
        //777
        System.out.println("-------");
        b.orderRoomsBySpace();
        for (Room r: b.roomList){
            System.out.println(r);
        }
        //15
        //23
        //777
    }

}