import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort <T> {
  Comparator<T> comparer;
  
  MergeSort(Comparator<T> comparer) {
    this.comparer = comparer;
  }
  public void splitArray(ArrayList<T> data, int startingPoint, int endingPoint) {
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

  public void mergeData(ArrayList<T> data, int startingPoint, int midPoint, int endingPoint) {
    int tempSize = endingPoint - startingPoint + 1; // 
    ArrayList<T> tempArray = new ArrayList<T>(tempSize);
    int mergePos, leftPointer, rightPointer;

    mergePos = 0;
    leftPointer = startingPoint;
    rightPointer = endingPoint + 1;
    
    // get the smallest element from each list, compare and insert into temp array.
    while (leftPointer <= midPoint && rightPointer <= endingPoint) {
      if (this.comparer.compare(data.get(leftPointer), data.get(rightPointer)) == -1) {
        tempArray.set(mergePos, data.get(leftPointer)) ;
        leftPointer++;
      } else {
        tempArray.set(mergePos, data.get(rightPointer));
        rightPointer++;
      }
      mergePos++;
    }

    // Add remainder of first array to temp array
    while(leftPointer <= midPoint) {
      tempArray.set(mergePos, data.get(leftPointer));
      leftPointer++;
      mergePos++;
    }

    // Add remainder of second array to temp array
    while(rightPointer <= endingPoint) {
      tempArray.set(mergePos, data.get(rightPointer));
      rightPointer++;
      mergePos++;
    }

    // Use temp array to copy back into original arrayList
    for(mergePos = 0; mergePos < tempSize; mergePos++) {
      System.out.println(mergePos);
      data.set(startingPoint + mergePos, tempArray.get(mergePos));
    }
  }
}
