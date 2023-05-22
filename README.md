# concurrency-control
Concurrency control using threads to solve the producer-consumer problem with a bounded buffer

Producer: Produces data items to buffer and prints what it produced

Consumer: Consumes data items from buffer and prints what it produced

ProducerConsumer: Creates buffer, producer, and consumer, creates producer thread and consumer thread and runs them. 
Throws exception if threads cannot be joined.

BoundedBuffer: Creates a FIFO buffer and declares produce, consume, isEmpty, and isFull methods

Program can be compiled using the Makefile provided
