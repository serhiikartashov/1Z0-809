Stream Operations:

1. Closing the Stream (close() method in a finally block or using the try-with-resource syntax)

2. Flushing the Stream (the data will make it to the file immediately. In many operating systems, the data may be cached in memory)

3. Marking the Stream (include mark(int) and reset() methods to move the stream back to an earlier position)

Input - ABCD

InputStream is = ...
System.out.print ((char)is.read());
if(is.markSupported()) {
    is.mark(100);
    System.out.print((char)is.read());
    System.out.print((char)is.read());
    is.reset();
}
System.out.print((char)is.read());
System.out.print((char)is.read());
System.out.print((char)is.read());

Output - ABCBCD

4. Skipping over Data (a skip(long) method, which as you might expect skips over a certain number of bytes)

Input - TIGERS

InputStream is = . . .
System.out.print ((char)is.read());
is.skip(2)
is.read();
System.out.print((char)is.read());
System.out.print((char)is.read());

Output - TRS
