public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {                            // ถ้าตำแหน่งแรกน้อยกว่าตำแหน่งสุดท้าย (ยังไม่เรียงเสร็จ)
            int pi = partition(arr, low, high);      // หา index ของ pivot หลังจากจัดเรียง
            quickSort(arr, low, pi - 1);             // เรียก quickSort สำหรับด้านซ้ายของ pivot
            quickSort(arr, pi + 1, high);            // เรียก quickSort สำหรับด้านขวาของ pivot
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];                       // เลือกค่า pivot ที่ตำแหน่งสุดท้าย
        int i = (low - 1);                           // ตัวชี้สำหรับค่าเล็กกว่า pivot
        for (int j = low; j < high; j++) {           // ลูปผ่านอาร์เรย์ตั้งแต่ low ถึง high-1
            if (arr[j] < pivot) {                    // ถ้าค่าตำแหน่ง j น้อยกว่า pivot
                i++;                                 // เพิ่มตัวชี้ i
                int temp = arr[i];                   // สลับค่าระหว่าง arr[i] และ arr[j]
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];                       // สุดท้าย สลับ pivot ไปที่ตำแหน่งที่ถูกต้อง (i+1)
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;                                // คืนตำแหน่งของ pivot
    }
}
