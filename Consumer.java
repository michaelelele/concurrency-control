import java.util.Random;
public class Consumer implements Runnable{
    private BoundedBuffer Buffer;
    private double total = 0.0;

    public Consumer(BoundedBuffer Buffer){
        this.Buffer = Buffer;
    }

    public void run(){ //Consumes data items from buffer and prints what it consumed
        double bufferElement;
        for(int i = 0; i < 1000000; i++){
            try{
                synchronized(Buffer){
                    while(Buffer.isEmpty()){
                        Buffer.wait();
                    }
                    bufferElement = Buffer.consume();
                    total += bufferElement;
                    Buffer.notify();
                }
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            if(((i+1) % 100000) == 0){
                System.out.printf("Consumer: Consumed %,d items, Cumulative value of consumed items=%.3f %n", (i+1) , total);
            }

        }
        System.out.println("Consumer: Finished consuming 1,000,000 items");
    }
}