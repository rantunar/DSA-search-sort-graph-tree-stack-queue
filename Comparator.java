import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Comparator {

  public static void main(String[] args) {

    String x = "33500";
    String y = "7";
    String a = String.valueOf((new BigDecimal(x).divide(new BigDecimal(y),11, RoundingMode.HALF_UP)));
    System.out.println("parcentage full = "+a);
    String b = String.valueOf((new BigDecimal(x).divide(new BigDecimal(y), 11, RoundingMode.HALF_UP)));
    System.out.println("parcentage round = "+b);

    String z = String.valueOf((new BigDecimal(b)).multiply(new BigDecimal(100)));
    System.out.println("balance = "+z);

    //String k = String.format("%.2f",(new BigDecimal(b)).multiply(new BigDecimal(100)));
    String k = String.valueOf((new BigDecimal(b)).multiply(new BigDecimal(100)).setScale(2,RoundingMode.HALF_UP));
    System.out.println("balance round = "+k);
  }

}
