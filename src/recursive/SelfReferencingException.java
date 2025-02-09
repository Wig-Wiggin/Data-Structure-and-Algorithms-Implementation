package recursive;

public class SelfReferencingException extends Exception{

    public SelfReferencingException(String message){
        System.out.println(message);
    }
}
