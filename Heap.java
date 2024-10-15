public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // สร้าง heap (ปรับโครงสร้างอาร์เรย์ให้เป็น max-heap)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // สลับค่าที่ตำแหน่ง root กับตำแหน่งสุดท้าย แล้วเรียก heapify เพื่อลด heap size
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);                     // ทำ heapify ใหม่สำหรับขนาดที่เล็กลง
        }
    }

    // ปรับอาร์เรย์ให้เป็น heap structure (max-heap)
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;                            // ตั้งค่าตัวชี้ largest เป็น root
        int left = 2 * i + 1;                       // ตำแหน่งลูกด้านซ้าย
        int right = 2 * i + 2;                      // ตำแหน่งลูกด้านขวา

        // ถ้าค่าของลูกด้านซ้ายใหญ่กว่า root ให้เปลี่ยน largest
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // ถ้าค่าของลูกด้านขวาใหญ่กว่า largest ให้เปลี่ยน largest
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // ถ้า largest ไม่เท่ากับ root ให้สลับค่า
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);               // ทำ heapify ซ้ำที่ตำแหน่งลูก
        }
    }
}
