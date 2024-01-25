package computershop;

public class Customer {
    public static void main(String[] args) {
        shopAssitant assitant = new shopAssitant() ;
        Computer computer = assitant.suggest("办公") ;
        System.out.println(computer.describe());
    }
}
