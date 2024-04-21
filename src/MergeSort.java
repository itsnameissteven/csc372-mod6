import java.util.ArrayList;
public class MergeSort {
  ArrayList<Integer> numbers;
  public void splitArray(ArrayList<Integer> numbers, int startingPoint, int endingPoint) {
    int midPoint;

    // Only run if pointers do not cross paths
    if(startingPoint < endingPoint) {
      midPoint = (startingPoint + endingPoint) / 2;

      // Split the left side
      splitArray(numbers, startingPoint, midPoint);
      // Split the right side
      splitArray(numbers, midPoint + 1, endingPoint);
    }
  }

  public static void mergeData(ArrayList<Integer> numbers, int startingPoint, int midPoint, int endingPoint) {
    int tempSize = endingPoint - startingPoint + 1; // 
    int[] tempArray = new int[tempSize];
    int mergePos, leftPointer, rightPointer;

    mergePos = 0;
    leftPointer = startingPoint;
    rightPointer = endingPoint + 1;

    // get the smallest element from each list, compare and insert into temp array.
    while (leftPointer <= midPoint && rightPointer <= endingPoint) {
      if (numbers.indexOf(leftPointer) < numbers.indexOf(rightPointer)) {
        tempArray[mergePos] = numbers.indexOf(leftPointer);
        leftPointer++;
      } else {
        tempArray[mergePos] = numbers.indexOf(rightPointer);
        rightPointer++;
      }
      mergePos++;
    }

    // Add remainder of first array to temp array
    while(leftPointer <= midPoint) {
      tempArray[mergePos] = numbers.indexOf(leftPointer);
      leftPointer++;
      mergePos++;
    }

    // Add remainder of second array to temp array
    while(rightPointer <= endingPoint) {
      tempArray[mergePos] = numbers.indexOf(rightPointer);
      rightPointer++;
      mergePos++;
    }

    // Use temp array to copy back into original arrayList
    for(mergePos = 0; mergePos < tempSize; mergePos++) {
      numbers.set(startingPoint + mergePos, tempArray[mergePos]);
    }
  }
}
