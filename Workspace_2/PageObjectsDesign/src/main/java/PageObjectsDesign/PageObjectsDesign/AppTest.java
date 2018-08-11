package PageObjectsDesign.PageObjectsDesign;

import java.util.Arrays;
import java.util.List;

public class AppTest {
public static void main(String[] args) {
List<Integer> list = Arrays.asList(1, 3, 6, 9, 11, 14, 16, 15, 21, 23);

int sum = list.stream()
                .filter(i -> i > 5)
                .filter(i -> i < 20)
                .filter(i -> i % 3 == 0)
                .mapToInt(i -> i )
                .limit(1)
                .sum();
System.out.println(sum);
}


}
