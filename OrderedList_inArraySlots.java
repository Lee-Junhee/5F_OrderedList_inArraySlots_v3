/**
  OrderedList_inArraySlots, holding Integers

  A list with the invariant the elements are in order by
  increasing value, implemented using a
  ArrayList<Integer>
 */

public class OrderedList_inArraySlots
    implements OrderedList {

    private java.util.ArrayList<Integer> list_iAS;


    /**
      @return the index any occurrence of 
              \findMe in this list, or -1 if
              \findMe is absent from this list.
     */
    public int indexOf( Integer findMe) {
        return recursive_indexOf(findMe);
    }
	
    private int whileStyle_indexOf(Integer findMe) {	
	int highLimit = size() - 1;
	int lowLimit = 0;
	int pageToCheck, compareResult;
	while (lowLimit <= highLimit) {
	    pageToCheck = (highLimit + lowLimit) / 2;
	    compareResult = get(pageToCheck).compareTo(findMe);
            if (compareResult == 0)
	        return pageToCheck;
	    else if (compareResult > 0)
		highLimit = pageToCheck - 1;
	    else
		lowLimit = pageToCheck + 1;
	}
	return -1; // element not found
    }

    private int recursive_indexOf(Integer findMe) {
        return recursive_indexOf(findMe, 0, size() - 1);
    }

    private int recursive_indexOf(Integer findMe, int low, int high) {
	if (low > high)
	    return -1;
	else {
	    int pageToCheck = (low + high) / 2;
	    int compareResult = get(pageToCheck).compareTo(findMe);
	    if (compareResult == 0)
		return pageToCheck;
	    else if (compareResult > 0)
		return recursive_indexOf(findMe, low, pageToCheck - 1);
	    else
		return recursive_indexOf(findMe, pageToCheck + 1, high);
	}
    }
    

    // ------ code from previous assignments below here ----

    public OrderedList_inArraySlots() {
        list_iAS = new java.util.ArrayList<Integer>();
    }

    /**
      @return the number of elements in this list
     */
    public int size(){
        return list_iAS.size();
    }

    /**
      @return a string representation of this Orderedlist_iAS
     */
    public String toString() {
        return list_iAS.toString();
    }


    /**
      Put @value where it belongs in the list.
      @pre: the list is in increasing order
     */
     public boolean add( Integer value) {
         int dest = 0;
         for( ; dest < list_iAS.size() && list_iAS.get( dest) < value
              ; dest++) ;
         // System.out.println( "OL adding " + value
         //                   + " at index " + dest);
         list_iAS.add( dest, value);
         return true;
     }


     /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether the condition was violated.)
     */
    public Integer get( int index ) {
        return list_iAS.get( index);
    }


    /**
      Remove the element at position @index in this list.

      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
    public Integer remove( int index) {
        return list_iAS.remove( index);
    }
}
