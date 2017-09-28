###In a hypothetical theater ,

- it is called **Mutex** if only one person allow to watch the play 
- it is called **Semaphore** if N number of people allow to watch the play.If anybody leave the Theater during the play then other person can be allowed to watch play. 
- it is called **CountDownLatch** if no one allowed to enter until every person vacate the theater.Here each person has freewill to leave the theater. 
- it is called **Cyclicbarrier** if theater will not start until every person enter in theater. Here showman can not start the show until all the person enter and grab the seat . Once the play finish same barrier will apply for next show

Here , **person** is Thread , **Play** is resource.



Real life example:--

- **CountDownLatch**: Consider a IT world scenario where manager divided modules between development teams (A and B) and he wants to assign it to QA team for testing only when both the teams completes their task.
Here manager thread works as main thread and development team works as worker thread. Manager thread waits for development teams thread to complete their task.

- **CyclicBarrier**: Consider the same IT world scenario where manager divided modules between development teams (A and B). He goes on leave and asked both team to wait for each other to complete their respective task once both are done assign it to QA team for testing.
Here manager thread works as main thread and development team works as worker thread. Development team threads wait for other development team threads after completing their task.


http://www.oracle.com/technetwork/articles/javase/index-140767.html
http://netjs.blogspot.com/2016/01/phaser-in-java-concurrency.html

http://netjs.blogspot.com/2016/01/countdownlatch-in-java-concurrency.html
http://netjs.blogspot.com/2016/01/cyclicbarrier-in-java-concurrency.html
http://netjs.blogspot.com/2016/01/difference-between-countdownlatch-and-cyclicbarrier-in-java.html


!!!
http://netjs.blogspot.com/2016/05/java-concurrency-interview-questions.html
