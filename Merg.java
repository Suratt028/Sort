public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {                       // ถ้ามีมากกว่าหนึ่งองค์ประกอบในส่วนย่อย
            int mid = (left + right) / 2;         // แบ่งอาร์เรย์ออกเป็นครึ่งๆ โดยหา midpoint
            mergeSort(arr, left, mid);            // เรียกใช้ mergeSort ซ้ำกับครึ่งซ้าย
            mergeSort(arr, mid + 1, right);       // เรียกใช้ mergeSort ซ้ำกับครึ่งขวา
            merge(arr, left, mid, right);         // รวมสองครึ่งกลับมาด้วยการเรียงลำดับ
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArray = new int[mid - left + 1];  // สร้างอาร์เรย์ย่อยสำหรับเก็บค่าครึ่งซ้าย
        int[] rightArray = new int[right - mid];    // สร้างอาร์เรย์ย่อยสำหรับเก็บค่าครึ่งขวา

        for (int i = 0; i < leftArray.length; i++)  // คัดลอกข้อมูลครึ่งซ้ายเข้า leftArray
            leftArray[i] = arr[left + i];
        for (int i = 0; i < rightArray.length; i++) // คัดลอกข้อมูลครึ่งขวาเข้า rightArray
            rightArray[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;                 // เริ่มการรวมลิสต์ด้วยตัวชี้ในแต่ละอาร์เรย์
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j])      // เปรียบเทียบค่าครึ่งซ้ายกับขวา
                arr[k++] = leftArray[i++];          // ค่าที่เล็กกว่าจะถูกเพิ่มกลับไปยังอาร์เรย์หลัก
            else
                arr[k++] = rightArray[j++];
        }

        while (i < leftArray.length)                // ถ้ามีค่าคงเหลือใน leftArray ให้เพิ่มกลับเข้าไปในอาร์เรย์หลัก
            arr[k++] = leftArray[i++];
        while (j < rightArray.length)               // ถ้ามีค่าคงเหลือใน rightArray ให้เพิ่มกลับเข้าไปในอาร์เรย์หลัก
            arr[k++] = rightArray[j++];
    }
}
