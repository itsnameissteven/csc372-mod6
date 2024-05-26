import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort  {
  Comparator<Student> comparer;
  
  MergeSort(Comparator<Student> comparer) {
    this.comparer = comparer;
  }

  // A recursive method to split an array and sort data provided
  public void sortArray(ArrayList<Student> data, int startingPoint, int endingPoint) {
    int midPoint;

    // Only run if pointers do not cross paths
    if(startingPoint < endingPoint) {
      midPoint = (startingPoint + endingPoint) / 2;

      // Recursively split the left side
      sortArray(data, startingPoint, midPoint);
      // Recursively split the right side
      sortArray(data, midPoint + 1, endingPoint);
      // Recursively call 
      mergeData(data, startingPoint, midPoint, endingPoint);
    }
  }

  // Reorganizes data provided after comparing values.
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
      data.set(startingPoint + mergePos, tempArray[mergePos]);
    }
  }
}
