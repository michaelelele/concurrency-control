FILES = ProducerConsumer.java Producer.java Consumer.java BoundedBuffer.java
all:
	javac -g $(FILES)
run:
	java ProducerConsumer
clean:
	rm *.class
package:
	zip -r concurrency.zip $(FILES) Makefile README.txt