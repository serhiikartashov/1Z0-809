#WHY to USE Console?

In a command that is designed to be run from the command line, it is (IMO) reasonable to use 
System.out and System.err for output and for error messages that the person running the command 
could reasonably expect to understand. If you are running your application from a decent 
shell or script, the System.out and/or System.err streams may be redirected to files or another 
process in a pipeline. AFAIK, using System.out and System.err is the only way to "respect" the 
user's wishes as far as redirection is concerned. Hence, for most use-cases this is still the best 
way for a command line application to write output for the user to see.

In JDK 1.6 and later, there also a class called java.io.Console which will give you access 
to the console. It is not spelled out in the Javadoc, but I suspect that java.io.Console opens 
a fresh stream to the console, and therefore cannot be redirected. (The moral equivalent of opening 
"/dev/tty" on an old-school UNIX box.) IMO, you should use this if your application wants to REALLY 
talk to the user, without the possibility of redirection; e.g. to ask for and then read a password.

However, if your application is GUI command, and particularly if it is intended to run as an unattended 
service, you should avoid "writing to the console" because:

- the console streams (System.{out,err} or java.io.Console) may be connected to nothing, or
- they may end up annoying the user, especially if your application provide no way to suppress the console output.

#Discarding a Scanner

When you have finished using a Scanner, such as when you have exhausted a line of input or reached 
the end of a file, you should close the Scanner using the close method. If you do not close 
the Scanner then Java will not garbage collect the Scanner object and you will have a memory leak in your program:

void close(): closes the Scanner and allows Java to reclaim the Scanner's memory. 
You cannot re-use a Scanner so you should get rid of it as soon as you exhaust its input.