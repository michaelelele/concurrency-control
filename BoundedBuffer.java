public class BoundedBuffer{
    private Double[] Buffer;
    private int size;
    private int out;
    private int in;
    private int counter;


public BoundedBuffer(){
    this.size = 1000;
    this.Buffer = new Double[size];
    this.in = 0;
    this.out = 0;
    this.counter = 0;
}

public void produce(Double nextProduced) throws InterruptedException{ //produces data items to the buffer
        Buffer[in] = nextProduced;
        in = (in +1)%size;
        counter++;
}

public double consume() throws InterruptedException{ //consumes data items from the buffer
        Double nextConsumed = Buffer[out];
        out = (out +1)% size;
        counter--;
        return nextConsumed;
}

public boolean isEmpty(){ //checks if counter is empty
    if(counter == 0){
        return true;
    }
        return false;
}

public boolean isFull(){ //checks if counter is full
    if(counter == 1000){
        return true;
    }
    return false;
}



}
