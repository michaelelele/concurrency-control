import java.util.Random;
public class Producer implements Runnable{
    private BoundedBuffer Buffer;
    private double total = 0.0;

    public Producer(BoundedBuffer Buffer){
        this.Buffer = Buffer;
    }

    public void run(){ //produces data items to buffer and prints what it produced
        Random random = new Random();
        for(int i = 0; i < 1000000; i++){
            double bufferElement = random.nextDouble() * 100.0;
            total += bufferElement;

            try{
                synchronized(Buffer){
                    while(Buffer.isFull()){
                        Buffer.wait();
                    }
                    Buffer.produce(bufferElement);
                    Buffer.notify();
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            if(((i+1) % 100000) == 0){
                System.out.printf("Producer: Generated %,d items, Cumulative value of consumed items=%.3f %n", (i+1), total);
            }
        }
        System.out.println("Producer: Finished generating 1,000,000 items");
    }
}