public class SelectionSort {
    public static void selectionSort(int[] arr) {   // ฟังก์ชันที่ใช้ในการเรียงลำดับข้อมูล
        for (int i = 0; i < arr.length - 1; i++) {   // ลูปผ่านอาร์เรย์แต่ละตำแหน่ง ยกเว้นตัวสุดท้าย
            int minIndex = i;                        // กำหนดให้ตำแหน่งปัจจุบันเป็นตัวที่เล็กที่สุด (minIndex)
            for (int j = i + 1; j < arr.length; j++) { // ลูปค้นหาค่าที่เล็กที่สุดในลำดับที่เหลือ
                if (arr[j] < arr[minIndex]) {        // ถ้าค่าตำแหน่ง j เล็กกว่าตัวปัจจุบันที่ minIndex
                    minIndex = j;                    // อัปเดต minIndex เป็นตำแหน่ง j
                }
            }
            int temp = arr[minIndex];                // สลับค่าระหว่างตำแหน่ง i และ minIndex
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
