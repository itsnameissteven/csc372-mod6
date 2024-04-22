import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort  {
  Comparator<Student> comparer;
  
  MergeSort(Comparator<Student> comparer) {
    this.comparer = comparer;
  }
  public void splitArray(ArrayList<Student> data, int startingPoint, int endingPoint) {
    int midPoint;

    // Only run if pointers do not cross paths
    if(startingPoint < endingPoint) {
      midPoint = (startingPoint + endingPoint) / 2;

      // Split the left side
      splitArray(data, startingPoint, midPoint);
      // Split the right side
      splitArray(data, midPoint + 1, endingPoint);

      mergeData(data, startingPoint, midPoint, endingPoint);
    }
  }

  public void mergeData(ArrayList<Student> data, int startingPoint, int midPoint, int endingPoint) {
    int tempSize = endingPoint - startingPoint + 1; // 
    Student[] tempArray = new Student[tempSize];
    int mergePos, leftPointer, rightPointer;

    mergePos = 0;
    leftPointer = startingPoint;
    rightPointer = midPoint + 1;
    
    // get the smallest element from each list, compare and insert into temp array.
    while (leftPointer <= midPoint && rightPointer <= endingPoint) {
      if (this.comparer.compare(data.get(leftPointer), data.get(rightPointer)) <0 ) {
        tempArray[mergePos] = data.get(leftPointer);
        leftPointer++;
      } else {
        tempArray[mergePos] = data.get(rightPointer);
        rightPointer++;
      }
      mergePos++;
    }

    // Add remainder of first array to temp array
    while(leftPointer <= midPoint) {
      tempArray[mergePos] =  data.get(leftPointer);
      leftPointer++;
      mergePos++;
    }

    // Add remainder of second array to temp array
    while(rightPointer <= endingPoint) {
      tempArray[mergePos] = data.get(rightPointer);
      rightPointer++;
      mergePos++;
    }

    // Use temp array to copy back into original arrayList
    for(mergePos = 0; mergePos < tempSize; mergePos++) {
      try {
        data.set(startingPoint + mergePos, tempArray[mergePos]);
      } catch (Exception e) {
        System.out.println("Error " + mergePos);
        System.out.println("Error " + tempSize);
        System.out.println(data);
      }
    }
  }
}
