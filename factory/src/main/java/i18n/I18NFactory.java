package i18n;

public class I18NFactory {
    public static Language getI18NObject(String area){
        if (area.equals("China")){
            return new Chinese() ;
        }else if ( area.equals("America") ){
            return new English() ;
        }else {
            return new Spainish() ;
        }
    }
}
