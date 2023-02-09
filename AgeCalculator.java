import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AgeCalculator {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your birthday in the format of yyyy-MM-dd: ");
    String birthday = sc.nextLine();
    sc.close();
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate birthdate = LocalDate.parse(birthday, formatter);
    LocalDate now = LocalDate.now();
    
    Period age = Period.between(birthdate, now);
    
    System.out.println("You are " + age.getYears() + " years, " + age.getMonths() + 
                       " months, and " + age.getDays() + " days old.");
  
  LocalDate nextBirthday = birthdate.withYear(now.getYear());
  if (nextBirthday.isBefore(now) || nextBirthday.isEqual(now)) {
    nextBirthday = nextBirthday.plusYears(1);
  }
  
  long daysUntilNextBirthday = ChronoUnit.DAYS.between(now, nextBirthday);
  System.out.println("There are " + daysUntilNextBirthday + " days until your next birthday.");
}
}


