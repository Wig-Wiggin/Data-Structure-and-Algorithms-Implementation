package implementations.array;


import java.util.Arrays;

public class DynamicArray {

    private int length;
    private int[] arr;
    private int pointer;

    public DynamicArray(int capacity) {
        this.length = capacity;
        this.arr = new int[length];

        pointer = 0;
    }

    public int get(int i) {
        return i < length ? arr[i] : -1;
    }

    public void set(int i, int n) {
//        if (i < length) {
//            if (arr[i] == 0) {
//                arr[i] = n;
//            } else {
//                int[] rest = new int[pointer - i];
//                for (int j = i,z = 0; j < rest.length; j++,z++) {
//                    rest[z] = arr[j];
//                }
//                arr[i] = n;
//
//                for (int j = i+1,z = 0;j<rest.length;j++,z++){
//                    arr[j] = rest[z];
//                }
//                pointer++;
//
//            }
//        }
        if (i == pointer) {
            arr[pointer] = n;
            pointer++;
        } else {
            arr[i] = n;
        }
    }

    public void pushback(int n) {

        if (pointer == length) {
            length *= 2;
            int[] newArr = new int[length];
            for (int i = 0; i < newArr.length; i++) {
                if (i >= arr.length) {
                    newArr[i] = -1;
                } else {
                    newArr[i] = arr[i];
                }
            }

            arr = newArr;
        }

        arr[pointer] = n;
        pointer++;

    }

    public int popBack() {
        int result = arr[pointer - 1];
        arr[pointer - 1] = -1;
        pointer--;
        return result;
    }

    private void resize() {
        length *= 2;
        int[] newArr = new int[length];
        for (int i = 0; i < newArr.length; i++) {
            if (i >= arr.length) {
                newArr[i] = -1;
            } else {
                newArr[i] = arr[i];
            }
        }

        arr = newArr;
    }

    public int getSize() {
        return pointer + 1;
    }

    public int getCapacity() {
        return length;
    }

 //   ["Array",1,"getSize","getCapacity","pushback",1,"getSize","getCapacity","pushback",2,
    //   "getSize","getCapacity","get",1,"set",1,3,"get",1,"popback","getSize","getCapacity"]

    public static void main(String[] args) {
        DynamicArray array = new DynamicArray(1);
        System.out.println(array.getSize());
        System.out.println(array.getCapacity());
        array.pushback(1);
        System.out.println(array.getSize());
        System.out.println(array.getCapacity());
        array.pushback(2);
        System.out.println(array.getSize());
        System.out.println(array.getCapacity());
        System.out.println(array.get(1));
        array.set(1,3);
        array.get(1);
        System.out.println(array.popBack());
        System.out.println(array.getSize());
        System.out.println(array.getCapacity());

    }
}
