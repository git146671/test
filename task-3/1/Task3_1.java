import java.util.Random;

public class Task3_1 {
    // Написать программу, выводящую на экран 3 случайно сгенерированных трёхзначных числа и сумму их первых
    //цифр
    public static void main(String[] args) {
        int random1, random2, random3;
        random1 = new Random().nextInt(999);
        random2 = new Random().nextInt(999);
        random3 = new Random().nextInt(999);
        if (random1 < 100) random1 += 100;
        if (random2 < 100) random2 += 100;
        if (random3 < 100) random3 += 100;
        System.out.println(random1 + " " + random2 + " " + random3);
        System.out.println(random1/100 + random2/100 + random3/100);
    }
}
