package recursion.kunal;

public class BinarySearchUsingRec {

    public static void main(String[] args) {

        int [] arr = new int[]{1,3,5,7,9,11,13,15,17};
        int key = 1;
        System.out.println(binarySearchUsingRec(arr,0,arr.length-1,key));
    }

    private static int binarySearchUsingRec(int[] arr, int l, int h,int key) {

        int mid = (l+h)/2;

        if(arr[mid] == key){
            return mid;
        }
        if(arr[mid] < key){
            return binarySearchUsingRec(arr,mid+1,h,key);
        }
        return binarySearchUsingRec(arr,l,mid-1,key);
    }
}
