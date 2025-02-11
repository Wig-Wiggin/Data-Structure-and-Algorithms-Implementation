package implementations.stack;

public class StackUnderFlowException extends Error{
    public StackUnderFlowException(String message){
        throw new Error(message);
    }
}
