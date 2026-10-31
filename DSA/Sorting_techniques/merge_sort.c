#include <stdio.h>

void merge(int a[], int temp[], int left, int mid, int right){
    
    int i = left;
    int j = mid + 1;
    int k = left;

    // Compare and merge both halves
    while (i <= mid && j <= right)
    {
        if (a[i] <= a[j])
            temp[k++] = a[i++];
        else
            temp[k++] = a[j++];
    }

    // Copy remaining elements from left half
    while (i <= mid)
        temp[k++] = a[i++];

    // Copy remaining elements from right half
    while (j <= right)
        temp[k++] = a[j++];

    // Copy sorted elements back to original array
    for (i = left; i <= right; i++)
        a[i] = temp[i];
}

void mergeSort(int a[], int temp[], int left, int right){

    if (left < right)
    {
        int mid = left + (right - left) / 2;

        mergeSort(a, temp, left, mid);
        mergeSort(a, temp, mid + 1, right);

        merge(a, temp, left, mid, right);
    }
}

int main(){
    
    int n, i;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int a[n], temp[n];

    printf("Enter elements: ");
    for (i = 0; i < n; i++)
        scanf("%d", &a[i]);

    mergeSort(a, temp, 0, n - 1);

    printf("Sorted array: ");
    for (i = 0; i < n; i++)
        printf("%d ", a[i]);

    return 0;
}