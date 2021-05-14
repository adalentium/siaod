public int binarySearch(int[] sortedArray, int key, int low, int high) {
    int index = -1;

    while (low <= high) {
        int mid = (low + high) / 2;
        if (sortedArray[mid] < key) {
            low = mid + 1;
        } else if (sortedArray[mid] > key) {
            high = mid - 1;
        } else if (sortedArray[mid] == key) {
            index = mid;
            break;
        }
    }
    return index;
}
