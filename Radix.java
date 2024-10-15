import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();  // หาค่าที่มากที่สุดในอาร์เรย์
        for (int exp = 1; max / exp > 0; exp *= 10) {   // เริ่มจากหลักหน่วย ไปจนถึงหลักสูงสุด
            countSort(arr, exp);                        // เรียกใช้ countSort โดยจัดเรียงตามหลักแต่ละหลัก
        }
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];                      // อาร์เรย์ชั่วคราวสำหรับเก็บผลลัพธ์
        int[] count = new int[10];                      // ใช้สำหรับนับจำนวนแต่ละหลัก (0-9)

        Arrays.fill(count, 0);                          // ตั้งค่า count ทั้งหมดเป็น 0

        // เก็บจำนวนของแต่ละ digit ในตำแหน่งที่ exp กำหนด (เช่น หลักหน่วย, หลักสิบ)
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // เปลี่ยน count เป็นตำแหน่งที่แท้จริงใน output array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // เรียงอาร์เรย์ตามหลักที่ exp กำหนด
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // คัดลอกผลลัพธ์จาก output กลับไปที่ arr
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
