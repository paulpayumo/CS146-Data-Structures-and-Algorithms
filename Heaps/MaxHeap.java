//package heapProj2;

/*
The following code breaks abstraction and gives students an index in order for more efficient changeKey methods.
*/
import java.util.Collection;
import java.util.ArrayList;


public class MaxHeap
{
   private ArrayList<Student> students;
   
   public MaxHeap(int capacity)
   {
      students = new ArrayList<Student>(capacity);
   }
      
   public MaxHeap(Collection<Student> collection)
   {
      students = new ArrayList<Student>(collection);
      for(int i = 0; i <students.size(); i++)
      	  students.get(i).setIndex(i);
      for(int i = size()/2; i >= 0; i--)
      {
         maxHeapify(i);
      }
   }
   
   public Student getMax()
   {
      if(size() < 1)
      {
         throw new IndexOutOfBoundsException("No maximum value:  the heap is empty.");
      }
      return students.get(0);
   }
   
   public Student extractMax()
   {
      Student value = getMax();
      students.set(0,students.get(size()-1));
      students.get(0).setIndex(0);
      students.remove(size()-1);
      maxHeapify(0);
      return value;
   }
   
   
   private void moveUp(int index)
   {
	    while(students.get(index).compareTo(students.get(parent(index))) > 0){
	     	swap(index, parent(index));
	     	index = parent(index);
	    } 
   }
   
   public void insert(Student elt)
   {
	  int index = students.size();
	  elt.setIndex(index);
      students.add(elt);
      //maxHeapify on its own does not move inserted element all the way to the top. Following code will continuously call maxHeapify on the
      //parent index as long as elt is moved up.
      moveUp(index);
   }
   
   public void changeKey(Student s, double newGPA)
   {
	   //set index equal to the index s
      int index = s.getIndex();
      int origIndex = index;
      s.setGPA(newGPA);
      maxHeapify(origIndex);
      //will move up the student as long as it needs to.
      moveUp(index);  

      
    	  
   }

   private int parent(int index)
   {
      return (index - 1)/2;
   }
   
   private int left(int index)
   {
      return 2 * index + 1;
   }
   
   private int right(int index)
   {
      return 2 * index + 2;
   }
   
   //was original private
   public int size()
   {
      return students.size();
   }
   
   public Student gets(int i)
   {
	   return students.get(i);
   }
   
   public double getGPA(int i)
   {
	   return students.get(i).gpa();
   }
   
   private void swap(int from, int to)
   {
	  int tempIndex = students.get(from).getIndex();
	  students.get(from).setIndex(students.get(to).getIndex());
	  students.get(to).setIndex(tempIndex);
      Student val = students.get(from);
      students.set(from,  students.get(to));
      students.set(to,  val);
   }
   
   private void maxHeapify(int index)
   {
      int left = left(index);
      int right = right(index);
      int largest = index;
      if (left <  size() && students.get(left).compareTo(students.get(largest)) > 0)
      {
         largest = left;
      }
      if (right <  size() && students.get(right).compareTo(students.get(largest)) > 0)
      {
         largest = right;
      }
      if (largest != index)
      {
         swap(index, largest);
         maxHeapify(largest);
      }  
   }   
}
