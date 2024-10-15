public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // เริ่มต้นด้วยการกำหนด gap โดยเริ่มจากครึ่งหนึ่งของขนาดอาร์เรย์
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // ใช้ insertion sort กับแต่ละส่วนที่เว้นช่วง gap
            for (int i = gap; i < n; i++) {
                int temp = arr[i];                  // เก็บค่าที่ต้องการจัดเรียง
                int j;

                // เลื่อนค่าที่ใหญ่กว่า temp ออกไปใน gap
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = temp;                      // วาง temp ไว้ที่ตำแหน่งที่เหมาะสม
            }
        }
    }
}
