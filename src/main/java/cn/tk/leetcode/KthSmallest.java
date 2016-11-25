package cn.tk.leetcode;


import java.util.Random;

/**
 * Created by xiedan on 16/9/21.
 */
public class KthSmallest {
    /* This function returns k'th smallest element in arr[l..r]
     using QuickSort based method.  ASSUMPTION: ALL ELEMENTS
     IN ARR[] ARE DISTINCT*/
    int kthSmallest(int arr[], int l, int r, int k)
    {
        // If k is smaller than number of elements in array
        if (k > 0 && k <= r - l + 1)
        {
            // Partition the array around a random element and
            // get position of pivot element in sorted array
            int pos = randomPartition(arr, l, r);

            // If position is same as k
            if (pos-l == k-1)
                return arr[pos];

            // If position is more, recur for left subarray
            if (pos-l > k-1)
                return kthSmallest(arr, l, pos-1, k);

            // Else recur for right subarray
            return kthSmallest(arr, pos+1, r, k-pos+l-1);
        }

        // If k is more than number of elements in array
        return Integer.MAX_VALUE;
    }

    // Utility method to swap arr[i] and arr[j]
    void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* Standard partition process of QuickSort().  It considers
     the last element as pivot and moves all smaller element
     to left of it and greater elements to right. This function
     is used by randomPartition()*/
    int partition(int arr[], int l, int r)
    {
        int x = arr[r], i = l;
        //保证i之前的元素均小于数组最右边的元素
        for (int j = l; j < r; j++)
        {
            if (arr[j] <= x)
            {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    /* Picks a random pivot element between l and r and
     partitions arr[l..r] arount the randomly picked
     element using partition()*/
    int randomPartition(int arr[], int l, int r)
    {
        Random rand = new Random();
        int n = r-l+1;
        int pivot = rand.nextInt(n);        //return a Integer between [0, n);
        swap(arr, l + pivot, r);
        return partition(arr, l, r);
    }

    // Driver method to test above
    public static void main(String args[])
    {
        KthSmallest kthSmallest = new KthSmallest();
        int arr[] = {1, 5, 1, 1, 6, 4, 3};
        int n = arr.length,k = n / 2;
        System.out.println("K'th smallest element is "+
                kthSmallest.kthSmallest(arr, 0, n-1, k + 1));
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

