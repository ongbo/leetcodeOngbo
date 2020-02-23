package TOP100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class LRU_Cache {
	ArrayList<Integer> arrayListkey = null;
	ArrayList<Integer> arrayListvalue = null;
	ArrayList<Integer> arrayListnum = null;
	int capacity = 0;
	  public LRU_Cache(int capacity) {
	        arrayListkey = new ArrayList<Integer>();
	        arrayListvalue = new ArrayList<Integer>();
	        arrayListnum = new ArrayList<Integer>();
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	        for(int i=0;i<arrayListkey.size();i++)
	        	if(arrayListkey.get(i)==key) {
	        		arrayListnum.set(i, arrayListnum.get(i)+1);
	        		return arrayListvalue.get(i);
	        	}
	        return -1;
	    }
	    
	    public void put(int key, int value) {
	    	if(arrayListkey.size()==capacity) {
	    		int nu = 1000,j=-1;
	    		for(int i=0;i<arrayListnum.size();i++) {
	    			if(arrayListnum.get(i)<nu) {nu = arrayListnum.get(i);j=i;}
	    		}
	    		arrayListkey.set(j, key);
	    		arrayListvalue.set(j, value);
	    		arrayListnum.set(j,0);
	    	}
	    	arrayListkey.add(key);
	    	arrayListvalue.add(value);
	    	arrayListnum.add(0);
	    	
	    }
	    
}
