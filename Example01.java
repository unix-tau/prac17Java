import java.util.List;
public class Example01{
  public static void main(String [] args){
      List<String> items = List.of("1", "a", "2", "a", "3", "a");
      items.stream()
.forEach(y -> System.out.print(y + " "));
      
      }}
