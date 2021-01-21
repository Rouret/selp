package lexer;

public class Buffer {
    private String buffer;

    public Buffer() {
        this.buffer = "";
    }

    public String getBuffer() {
        return buffer;
    }

    public void add(char value){
        this.buffer+=value;
    }

    public void reset(){
        this.buffer="";
    }

    @Override
    public String toString() {
        return this.buffer;
    }
}
