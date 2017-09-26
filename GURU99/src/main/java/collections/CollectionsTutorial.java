package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;


public class CollectionsTutorial {
	@Test
	public void CollectionTest() {
		/*
		 * Collection colIntro =new ArrayList<>(); colIntro.add(1);
		 * colIntro.add("a"); colIntro.add(2); for (Object object : colIntro) {
		 * System.out.println(object);
		 * 
		 * }
		 */
		/*List aList = new ArrayList<>();
		aList.add(1);
		aList.add("a");
		aList.add(2, "b");
		aList.add(1, 2);
		aList.add(1);
		for (Object object : aList) {
			System.out.println(object);

		}
*/
		/*Set aSet = new HashSet<>();
		aSet.add(1);
		aSet.add(1);
		aSet.add(2);
		for (Object object : aSet) {
			System.out.println(aSet);
			
		}*/
		Map aMap= new HashMap<>();
		aMap.put(1, "a");
		aMap.put(2, "b");
		aMap.put(3, "c");
		aMap.put(4, "d");
		//System.out.println(aMap.get(4));
		/*Set aSet= aMap.keySet();
		for (Object object : aSet) {
			System.out.println(aMap.get(object));
			
		}*/
		Iterator i= aMap.entrySet().iterator();
		while(i.hasNext()){
			Map.Entry pair= (Map.Entry)i.next();
			//System.out.println(i.next());
			
		}
		
	}

}
