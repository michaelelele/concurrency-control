public class ProducerConsumer { 
    public static void main(String[] args){
        BoundedBuffer Buffer = new BoundedBuffer(); //creates buffer

        Producer Producer = new Producer(Buffer); //creates producer
        Consumer Consumer = new Consumer(Buffer); //creates consumer

        Thread ProducerThread = new Thread(Producer); //creates thread for producer
        Thread ConsumerThread = new Thread(Consumer); //creates thread for consumer

        ProducerThread.start(); //runs producer thread
        ConsumerThread.start(); //runs consumer thread

        try{
            ProducerThread.join(); //throws exception if threads cannot be joined
            ConsumerThread.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Exiting!");
    }
}