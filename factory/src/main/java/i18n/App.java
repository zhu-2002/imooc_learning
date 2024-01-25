package i18n;

public class App {
    public static void main(String[] args) {
        Language language = I18NFactory.getI18NObject("China") ;
        System.out.println(language.getTitle());
    }
}
