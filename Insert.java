public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {     // เริ่มลูปจากตำแหน่งที่สองไปจนถึงตัวสุดท้าย
            int key = arr[i];                      // เก็บค่าปัจจุบันที่ต้องการจัดตำแหน่ง
            int j = i - 1;                         // เริ่มจากตัวที่อยู่ก่อนหน้า key
            while (j >= 0 && arr[j] > key) {       // เปรียบเทียบ key กับค่าที่อยู่ก่อนหน้า
                arr[j + 1] = arr[j];               // ถ้า key น้อยกว่าย้ายค่าที่อยู่ก่อนหน้าไปข้างหน้า
                j--;
            }
            arr[j + 1] = key;                      // วาง key ในตำแหน่งที่เหมาะสม
        }
    }
}
