public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        boolean swapped;                           // สถานะสำหรับตรวจสอบว่ามีการสลับค่าในลูปหรือไม่
        do {
            swapped = false;                       // เริ่มต้นโดยกำหนดว่าไม่มีการสลับ
            for (int i = 0; i < arr.length - 1; i++) {  // ลูปผ่านอาร์เรย์ตั้งแต่ตำแหน่งแรกถึงรองสุดท้าย
                if (arr[i] > arr[i + 1]) {         // ถ้าค่าตำแหน่ง i มากกว่าค่าถัดไป
                    int temp = arr[i];             // สลับค่าระหว่างตำแหน่ง i และ i + 1
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;                // กำหนดว่าเกิดการสลับ
                }
            }
        } while (swapped);                         // ถ้ามีการสลับค่า จะทำซ้ำจนกว่าจะไม่มีการสลับอีก
    }
}
