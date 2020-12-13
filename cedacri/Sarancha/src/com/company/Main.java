package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class Main {
    static private Scanner in = new Scanner(System.in);
    static int[][] x;
    static int n,m;
    
    public static void main(String[] args) throws IOException {
    	MyApp a = new MyApp();
        System.out.println("Сейчас мы определим случайным образом какой будет размер сельхоз участка:");
        RandMatrix();
        int input = 1;
        while (input != 0) {
            System.out.println("__________________________________________________________________________________________________ ");
            System.out.println("| " +"1 - Записать данные в файл                                                                       |");
            System.out.println("-------------------------------------------------------------------------------------------------- ");
            System.out.println("| " +"2 - Прочитать файл                                                                               |");
            System.out.println("-------------------------------------------------------------------------------------------------- ");
            System.out.println("| " +"3 - Вывести содержимое файла на экран                                                            |");
            System.out.println("-------------------------------------------------------------------------------------------------- ");
            System.out.println("| " +"4 - Среднее арифметическое каждой строки                                                         |");
            System.out.println("-------------------------------------------------------------------------------------------------- ");
            System.out.println("| " +"5 - Найти максимальный элемент в строке                                                          |");
            System.out.println("-------------------------------------------------------------------------------------------------- ");
            System.out.println("| " +"6 - Добавить строку                                                                              |");
            System.out.println("-------------------------------------------------------------------------------------------------- ");
            System.out.println("| " +"7 - Файл записать и открыть файл с простыми числами                                              |");
            System.out.println("-------------------------------------------------------------------------------------------------- ");
            System.out.println("| " +"8 - Отсортировать быстрой сортировкой по столбцам                                                |");
            System.out.println("-------------------------------------------------------------------------------------------------- ");
            System.out.println("| " +"9 - Удалить столбец и строку у которой в пересечении находится самый малленький элемент в матрице|");
            System.out.println("-------------------------------------------------------------------------------------------------- ");
            System.out.println("| " +"10 - Найти магический квадрат в матрице                                                          |");
            System.out.println("-------------------------------------------------------------------------------------------------- ");
            System.out.println("| " +"11 - Путь саранчи                                                                                |");
            System.out.println("-------------------------------------------------------------------------------------------------- ");
            System.out.println("| " +"0 - exit the program                                                                             |");
            System.out.println("___________________________________________________________________________________________________|");
            input = in.nextInt();
            switch (input) {
                case 1:
                    addInfoToFile();
                    System.out.println("Информация успешно добавлена в файл");
                    break;
                case 2:
                    readFromFile();
                    System.out.println("Информация успешно считана из файла!");
                    break;
                case 3:
                    outputFromFile();
                    break;
                case 4:
                    SredneeArifmeticeskoe();
                    System.out.println("Успешно выведено среднее арифметическое каждой строки");
                    break;
                case 5:
                    printStroka();
                    System.out.println("Успешно выведен максимальный элемент каждой строки");
                    break;
                case 6:
                    insertColumn();
                    break;
                case 7:
                    addInfoToFilePrime();
                   outputFromPrimeFile();
                    break;
                case 8:
                    sortColumnWise();
                    break;
                case 9:
                    DeleteColumn();
                    break;
                case 10:
                    MagicSquare();
                    break;
                case 11:
                    Sarancha();
                    break;
                case 12:
                    SendMail();
            }
        }
        in.close();
    }

    static void RandMatrix() {
    	 Random rand = new Random();
         x = new int[101][101];
         n = 10;
         m = 10;
         for (int i = 0; i <n; i++) {
             for (int j = 0; j < m; j++) {
                 x[i][j] = rand.nextInt(256) + 1;
             }
         }
         System.out.println(n + " " + m);
         for (int i = 0; i < n; i++) {
             for (int j = 0; j < m; j++) {
                 System.out.print(x[i][j] + " ");
             }
             System.out.println();
         }
    }
    
    static String printStroka(){
        int i = 0;
        int k = 0;
        int max = maxElement();
        while (i < n) {
            for (int j = 0; j < m; j++) {
                if (x[i][j] == max) {
                    k++;
                    break;
                }
            }
            i++;
        }
        System.out.println("Количество строк содержащие максимальный элемент = " + k);
        return Integer.toString(k);
    }

    static int maxElement(){ //нахожу максимальный элемент в каждой строке
        int i = 0;
        int max = 0;
        while (i < n) {
            for (int j = 0; j < m; j++) {
                if (x[i][j] > max) {
                    max = x[i][j];
                }
            }
            i++;
        }
        return max;
    }

    static void SredneeArifmeticeskoe() { //Нахожу среднее арифметическое каждого столбца
        double sum = 0;
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                sum = sum + x[i][j];
            }
            sum = sum / n;
                System.out.println("Среднее арифметическое " + (j + 1) + " столбца: " + sum);
            
            sum = 0;
        }
    }

    static void outputFromFile() {
        System.out.println(n + " " + m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(x[i][j] != 0) {
                    System.out.print(x[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    static void readFromFile() throws IOException {
        BufferedReader br = null;
        br = new BufferedReader(new FileReader("Lacusta.in.txt")); //чтение из файла
        String[] line;
        line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                x[i][j] = Integer.parseInt(line[j]);
            }
        }
        br.close();
    }

    static void addInfoToFile() throws IOException {
        File f = new File("Lacusta.in.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        PrintWriter pw = new PrintWriter(f);
        pw.println(n + " " + m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pw.print(x[i][j] + " ");
            }
            pw.println();
        }
        pw.close();
    }

    static boolean isPrime(int n) { //метод для проверки является ли число простым
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static String[] printPrimeNumbers() { //метод для вывода простых чисел
    	String[] s = new String[n*m];
    	int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isPrime(x[i][j])) {
                    System.out.println(x[i][j] + " Простое число");
                    k++;
                    s[0] = Integer.toString(k);
                    s[k] = x[i][j] + " Простое число";
                }
            }
        }
        return s;
    }

    static void outputFromPrimeFile() throws IOException { //метод для вывода из файла с простыми числами который читает главный файл лакуста.ин и выбирает оттуда все простые числа и выводит их
        readFromFile();
        printPrimeNumbers();
            System.out.println();
    }

    static void addInfoToFilePrime() throws IOException {
        File f = new File("Prime.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        PrintWriter pw = new PrintWriter(f);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isPrime(x[i][j])) {
                    pw.println(x[i][j] + " Простое число");
                }
            }
            pw.println();
        }
        pw.close();
    }

    static void insertColumn() throws IOException { //метод для добавления строк и столбцов со всех сторон матрицы,сначала читаем матрицу из файла потом совершаем над ней действия и потом уже запсиываем их в файл и выводим это
         readFromFile();
       int menu;
       do {
           System.out.println("1 - Добавить новый столбец справа");
           System.out.println("2 - Добавить новую строку снизу");
           System.out.println("3 - Добавить новый столбец слева");
           System.out.println("4 - Добавить новую строку сверху");
           System.out.println("0 - Для того чтобы выйти из меню");
           menu = in.nextInt();
           if(menu == 1) {
               m++;
               Arrays.copyOf(x[0], m);
               for (int i = 0; i < n; i++) {
                   System.out.print("x[" + i + "]" + "[" + (m - 1) + "]=");
                   x[i][m - 1] = in.nextInt();
               }
           }
               else if(menu == 2) {
               n++;
               Arrays.copyOf(x, n);
               for (int i = 0; i < m; i++) {
                   System.out.print("x[" + (n - 1) + "]" + "[" + i + "]=");
                   x[n - 1][i] = in.nextInt();
               }
           }
               else if(menu == 3) {
               m++;
               Arrays.copyOf(x[0], m);
               for (int i = 0; i < n; i++) {
                   for (int j = m - 1; j > 0; j--) {
                       x[i][j] = x[i][j - 1];
                   }
               }
               for (int i = 0; i < n; i++) {
                   System.out.print("x[" + i + "]" + "[" + 0 + "]=");
                   x[i][0] = in.nextInt();
               }
           }
               else if(menu == 4) {
               n++;
               Arrays.copyOf(x, n);
               for (int j = 0; j < m; j++) {
                   for (int i = n - 1; i > 0; i--) {
                       x[i][j] = x[i - 1][j];
                   }
               }
               for (int i = 0; i < m; i++) {
                   System.out.print("x[" + 0 + "]" + "[" + i + "]=");
                   x[0][i] = in.nextInt();
               }
            }
           }
        while (menu != 0);
        menu = 1;
        addInfoToFile();
        outputFromFile();
       }

    static void DeleteColumn() throws IOException { //уделяет строку и столбец у которого в пересечении самый маленький элемент в матрице
        readFromFile();
            int max = x[0][0];
            int pi=1,pj=1;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if(x[i][j]<max )
                    {
                        max=x[i][j];
                        pi=i+1;
                        pj=j+1;
                    }
                }
            }

            int [][]matrix1 = new int[n-1][m-1];
            for (int i=0, ln=0; ln<n-1;) {
                if (i!=pi-1) {
                    for (int j=0, cn=0; cn<m-1; j++, cn++) {
                        if (j==pj-1) j++;
                        matrix1[ln][cn]=x[i][j];
                    }
                    i++;
                    ln++;
                } else i++;
            }
            x=matrix1;
            n--;
            m--;
            outputFromFile();
            addInfoToFile();
        }

    static int sortColumnWise() throws IOException { //сортирую встроенным методом в джаве,Который сортирует быстрой сортировкой,все столбцы
        readFromFile();
        int B [] = new int [n];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                B[i] = x[i][j];
            }
            Arrays.sort(B);
            for(int z = 0;z < n; z++){
                x[z][j] = B[z];
            }
        }

        outputFromFile();
        addInfoToFile();
        return 0;
    }

    static void MagicSquare() throws IOException { //нахожу магический квадрат в своей матрице и вывожу магическая матрица или нет
        readFromFile();
        int MaxSize;
        int Size = 0;
        int LeftI = 0;
        int LeftJ = 0;
        if(n < m)
        {
            MaxSize = n;
        }
        else {
            MaxSize = m;
        }
        for(int k = 2;k <= MaxSize; k++) {
            for (int li = 0; li <= n - k; li++) {
                for (int lj = 0; lj <= m - k; lj++) {
                   if(IsMagicSquare(k,li,lj)){
                       Size = k;
                       LeftI = li;
                       LeftJ = lj;
                   }
                }
            }
        }
        if(Size == 0){
            System.out.println("Нет");
        }
        else {
            System.out.println("Да,координаты левого верхнего угла:" +  LeftI + " " + LeftJ);
            System.out.println("Размер квадрата:" + Size);
        }
    }

    static boolean IsMagicSquare(int Size, int li, int lj) throws IOException{ //метод для нахождения магического квадрата типа булян который проверяет равна ли сумма всех диагоналей и столбцов,строк
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0;i < Size; i++){
            sum1 += x[i + li][i + lj];
        }
        for(int i = Size;i > 0; i--){
            sum2 += x[Size - i + li][i + lj - 1];
        }
        if(sum1 != sum2){
            return false;
        }
        for(int i = 0;i < Size;i++){
            int SumI = 0;
            for(int j = 0; j < Size; j++){
                SumI += x[i + li][j + lj];
            }
            if(SumI != sum1){
                return  false;
            }
        }
        for(int j = 0;j < Size; j++){
            int SumJ = 0;
            for(int i = 0; i< Size; i++){
               SumJ += x[i + li][j + lj];
            }
            if(SumJ != sum1){
                return false;
            }
        }
        return  true;
    }

    static int Min(int a, int b) {
        return (a<b)? a : b;
    }

    static void Sarancha() throws IOException { //принцип задачи с роботом и задачи с золотоносном участком,вместо swap код писал вручную ,в методе все записывается в файл лакуста.аут
        readFromFile();
        int[][] C = new int[100][100];
        System.out.println("n = " + n);
        System.out.println("m = " + m);
        C[0][0]=x[0][0];
        for(int i=1; i<n; i++)
            C[i][0]=x[i][0]+C[i-1][0];
        for(int j=1; j<m; j++)
            C[0][j]=x[0][j]+C[0][j-1];
        for (int k=1; k<n+m-1; k++)
            for(int i=1; i<n; i++)
                for(int j=1; j<m; j++)
                    if (i+j-1==k) {
                        C[i][j]=x[i][j]+Min(C[i][j-1], C[i-1][j]);
                    }
        System.out.println();
        System.out.println("Cmin = " + C[n-1][m-1]);
        File f = new File("Lacusta.out.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        PrintWriter pw = new PrintWriter(f);
        pw.println(C[n-1][m-1]);
        for(int i=0; i<n/2; i++){
            for(int j=0; j<m; j++){
                int t = C[i][j];
                C[i][j] = C[n-i-1][j];
                C[n-i-1][j] = t;
            }
        }
        int Ri=0,Rj=0;
        while(Ri<n-1 && Rj<m){
            pw.print("(" + Ri + ", " + Rj + ")");
            if(C[Ri][Rj+1]>C[Ri+1][Rj]){
                Rj++;
            }
            else{
                Ri++;
            }
            if(!(Ri == n - 1 || Rj == m))
                pw.print("->");
        }
        pw.close();
    }
    static void SendMail() {
        final  String username = "stefanboblic@gmail.com";
        final  String password = "Tedy2002";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("stefanboblic.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("stefanboblic@gmail.com,stefanboblic@yahoo.com")
            );
            message.setSubject("Testing Gmail TLS");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}