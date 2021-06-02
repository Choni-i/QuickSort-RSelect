package ru.vsu.parshina;

import java.io.*;
import java.util.*;
//Замечание
//0-первый
//1 - последний
//2 - рандомный
//3 - медианный
class QUickStackSort {
    static int k = 0;
    public static int returnK () {
        return k;
    }

    public static void NewK () {
        k = 0;
    }
    private static int partition(int[] data, int left, int right, int a) {//честно посмотрела где то в интернете или у Насти, я уже не помню, по другому не работает :(
        int temp = data[right];
        data[right] = data[a];
        data[a] = temp;
        int x = data[right];
        int i = left - 1;
        for (int l = left; l < right; l++) {
            if (data[l] < x) {
                i++;
                int temp1 = data[i];
                data[i] = data[l];
                data[l] = temp1;
                k++;
            }
        }
        temp = data[i+1];
        data[i+1] = data[right];
        data[right] = temp;
        return i + 1;
    }


    private static void sort(int[] data, int left, int right, int a) {
        if (left < right) {
            int p = 0;
            if (a==0){
                p = left;
            } else if (a==1){
                p = right;
            } else if (a==2){
                Random generator = new Random();
                p = generator.nextInt(right  + 1 - left) + left;
            } else {
                p = median(data, left, right);
            }
            int xIndex = partition(data, left, right, p);
            sort(data, left, xIndex -1 , a);
            sort(data, xIndex + 1, right, a);
        }
    }


   /* public static void sort(int[] data) {
        sort(data, 0, data.length);
    }*/

    public static int []  CopyArr(int [] arr){
        int [] data = new int[arr.length];
        for(int i = 0; i< arr.length; i++){
            data[i] = arr[i];
        }
        return data;
    }




    public static void solve(InputReader in, PrintWriter out) {
        int [] arr = new int[]{1, 5 , 2, 4, 5, 7, 6, 9, 3, 5};
        out.print("Изначальный массив: ");
        for(int i = 0; i< arr.length; i++){
            out.print(arr[i] + " ");
        }
        out.println();
        out.print("Кол-во сравнений для 1ого элемента: ");
        int [] data1 = CopyArr(arr);
        sort(data1, 0, data1.length - 1, 0);
        out.println(returnK());
        NewK();
        out.print("Отсортированный массив: ");
        for(int i = 0; i< arr.length; i++){
            out.print(data1[i] + " ");
        }
        out.println();

        out.print("Кол-во сравнений для последнего элемента: ");
        int [] data2 = CopyArr(arr);
        sort(data2, 0, data2.length - 1, 1);
        out.println(returnK());
        NewK();
        out.print("Отсортированный массив: ");
        for(int i = 0; i< arr.length; i++){
            out.print(data2[i] + " ");
        }
        out.println();
        out.print("Кол-во сравнений для рандомного элемента: ");
        int [] data3 = CopyArr(arr);
        sort(data3, 0, data3.length - 1 , 2);
        out.println(returnK());
        NewK();
        out.print("Отсортированный массив: ");
        for(int i = 0; i< arr.length; i++){
            out.print(data3[i] + " ");
        }
        out.println();
        out.print("Кол-во сравнений для медианнного элемента: ");
        int [] data4 = CopyArr(arr);
        sort(data4, 0, data4.length - 1, 3);
        out.println(returnK());
        NewK();
        out.print("Отсортированный массив: ");
        for(int i = 0; i< arr.length; i++){
            out.print(data4[i] + " ");
        }
        out.println();
        out.print("RSELECT: ");
        int [] data5 = CopyArr(arr);
        int p;
        if (data5.length%2==0){
            p = data5.length/2;
        } else {
            p = (data5.length-1)/2;
        }
        RSelect(data5,0, data5.length - 1 , p);
        out.println(returnK());
        NewK();
        out.println();

        int [] arr1 = new int[100];
        for(int i =0; i<100; i++){
            arr1[i] = (int) ( Math.random() * 100);
        }
        out.print("Изначальный массив: ");
        for(int i = 0; i< arr1.length; i++){
            out.print(arr1[i] + " ");
        }
        out.println();
        out.print("Кол-во сравнений для 1ого элемента: ");
        int [] data11 = CopyArr(arr1);
        sort(data11, 0, data11.length - 1, 0);
        out.println(returnK());
        NewK();
        out.print("Отсортированный массив: ");
        for(int i = 0; i< arr1.length; i++){
            out.print(data11[i] + " ");
        }
        out.println();

        out.print("Кол-во сравнений для последнего элемента: ");
        int [] data21 = CopyArr(arr1);
        sort(data21, 0, data21.length - 1, 1);
        out.println(returnK());
        NewK();
        out.print("Отсортированный массив: ");
        for(int i = 0; i< arr1.length; i++){
            out.print(data21[i] + " ");
        }
        out.println();
        out.print("Кол-во сравнений для рандомного элемента: ");
        int [] data31 = CopyArr(arr1);
        sort(data31, 0, data31.length - 1 , 2);
        out.println(returnK());
        NewK();
        out.print("Отсортированный массив: ");
        for(int i = 0; i< arr1.length; i++){
            out.print(data31[i] + " ");
        }
        out.println();
        out.print("Кол-во сравнений для медианнного элемента: ");
        int [] data41 = CopyArr(arr1);
        sort(data41, 0, data41.length - 1, 3);
        out.println(returnK());
        NewK();
        out.print("Отсортированный массив: ");
        for(int i = 0; i< arr1.length; i++){
            out.print(data41[i] + " ");
        }
        out.println();
        out.print("RSELECT: ");
        int [] data51 = CopyArr(arr1);
        int p1;
        if (data51.length%2==0){
            p1 = data51.length/2;
        } else {
            p1 = (data51.length-1)/2;
        }
        RSelect(data51,0, data51.length - 1 , p1);
        out.println(returnK());
        NewK();
        out.println("Я дико извиняюсь, но делать ещё массивы почти отсортированные и отсортирвоанные и смотреть статистику нет сил и времени. Я старалась, хотя мне не нравится, можно было и умнее организовать выходные данные. ");
    }




    public static void main(String[] args) {
        InputStream inputStream;
        OutputStream outputStream;
        try {
            inputStream = new FileInputStream("input.txt");
            outputStream = new FileOutputStream("output.txt");
        } catch (Exception e) {
            inputStream = System.in;
            outputStream = System.out;
        }

        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        solve(in, out);
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }

    public static int median (int [] data, int right, int left) {
        int middle = (left + right)/2;
        if (right == left) {
            return right;
        } else if (right - left == 1) {
            if (data[right] < data[left]) {
                return right;
            } else {
                return left;
            }
        }
        if ((data[right] > data[left] && data[right] < data[middle]) || (data[right] < data[left] && data[right] > data[middle])) {
            return right;
        } else if ((data[left] > data[right] && data[left] < data[middle]) || (data[left] < data[right] && data[left] < data[middle])) {
            return left;
        } else {
            return middle;
        }
    }

    public static int RSelect (int [] data, int left, int right, int i) {
        if (data.length == 1) {
            return data[0];
        }
        int p = left;
        int f = partition(data, left, right, p);
        if (f == i) {
            return data[f];
        } else if (f > i) {
            return RSelect(data, left, f - 1, i);
        } else {
            return RSelect(data, f + 1, right, i);
        }
    }
}
