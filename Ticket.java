// Student Name Fernando Perez
// Date 2/5/2023
// CSCI 3302 Section 001
// 
// Files: Ticket.java
// 
// Description: This java class is used to find the seat ID of a planet ticket using a variety of recursive methods. 
// 


public class Ticket  {

    public static void main(String[] args) {
        System.out.println(Ticket.findSeatID("BFFFBBFRRR"));
    }
   
    /**
     * 
     * @param partition Provides the string of characters that will determine lower/upper, and left/right.
     * @return Returns a integer which is the seat ID number by multiplying row by 8, and then adding the column.
     */
    public static int findSeatID(String partition){
        int column = findSeatColumn(0, 7, partition, 7);
        int row = findSeatRow(127, 0, partition, 0);

        return (row * 8) + column;
        
    } 

    /**
     * 
     * @param upper Upper is an integer type that sets the limit of rows up to 127
     * @param lower Lower is an integer type that sets the lowest amount of rows which is 0
     * @param key Key is a string type that provides the letter that determines which half the seat is located
     * @param index Index is a integer type that tells the recursion method where to start in the string
     * @return Returns an integer that provies the seat row number
     */
     private static int findSeatRow(int upper, int lower, String key, int index){
        if(upper == lower){
            return upper;
        } else {
            int middle = (upper + lower) / 2;


            if(key.charAt(index) == 'B'){
                lower = middle + 1;
            } else if(key.charAt(index) == 'F'){
                upper = middle;
            }
            
            return findSeatRow(upper, lower, key, index + 1);
        } 
    }

    
/**
 * 
 * @param left Left is an integer type that provides the lowest column number that being 0
 * @param right Right in an integer type that provides the highest column number that being 7
 * @param key Key is a string type that provides the letter that determines which half the seat is located
 * @param index is a integer type that tells the recursion method where to start in the string
 * @return Returns a integer type that provides the seat column number
 */
    private static int findSeatColumn(int left, int right, String key, int index){
        
        if(left == right){
            return left;
        } else {
        int middle = (left + right) /2;
        

        if(key.charAt(index) == 'R'){
            left = middle + 1;
        } else if(key.charAt(index) == 'L'){
            right = middle;
        } 

        return findSeatColumn(left, right, key, index + 1);

    }
    }
    
    
}  // end class 