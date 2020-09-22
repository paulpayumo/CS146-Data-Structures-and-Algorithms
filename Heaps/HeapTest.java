//package heapProj2;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class HeapTest {

	@Test
	public void test() {
		ArrayList<Student> heapAssertion = new ArrayList<Student>();
		Student reed = new Student("Reed", 120, 3.9);
		Student josh = new Student("Josh", 60, 4.0);
		Student jake = new Student("Jake", 30, 3.8);
		Student ben = new Student("Ben", 110, 3.4);
		Student susan = new Student("Susan", 60, 3.5);
		Student johnny = new Student("Johnny", 50, 1.2);
		Student jen = new Student("Jen", 60, 1.9);
		
		heapAssertion.add(josh);
		heapAssertion.add(jake);
		heapAssertion.add(reed);
		heapAssertion.add(johnny);
		heapAssertion.add(susan);
		heapAssertion.add(jen);
		heapAssertion.add(ben);
		
		
		MaxHeap heap = new MaxHeap(10);
		
		heap.insert(reed);
		System.out.println(heap.getMax());
		heap.insert(susan);
		heap.insert(ben);   
		heap.insert(johnny);
		heap.insert(jake);
		heap.insert(jen);
		heap.insert(josh);
		
		for(int i = 0; i<heapAssertion.size(); i++)
		{
			System.out.println(heap.gets(i).getIndex());
			assertEquals(heapAssertion.get(i).getIndex(), heap.gets(i).getIndex(), .000001);
		}
		//System.out.println(reed.getIndex());
		
		
		/*for(int i = 0; i < heap.size(); i++)
		{
			System.out.println(heap.getGPA(i));
		}*/
		
		System.out.println();
		System.out.println(reed.getIndex());
		heap.changeKey(reed, 2.5);
		assertEquals(6, reed.getIndex(), .0001);
		System.out.println();
		/*for(int i = 0; i < heap.size(); i++)
		{
			System.out.println(heap.getGPA(i));
		}*/
		
		heap.changeKey(ben,1.0);
		assertEquals(6, ben.getIndex(), .0001);
		assertEquals(2, reed.getIndex(), .00001);
		System.out.println(josh.gpa());
		System.out.println(josh.getName());
		josh.setUnits(100);
		Student ben1 = new Student("Ben", 110, 1.0);
		assertEquals(0, ben.compareTo(ben1), .00001);
		
		//System.out.println(josh.units());
		assertEquals(4.0, heap.extractMax().gpa(), .000001);
		//Student fuller = new Student("Full", 120, 3.1, 0);
		
		ArrayList<Student> heapTester = new ArrayList<Student>();
		heapTester.add(reed);
		heapTester.add(josh);
		heapTester.add(ben);
		MaxHeap arrayTester = new MaxHeap(heapTester);
	}
	

}

