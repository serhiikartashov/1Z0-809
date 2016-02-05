The three possible outcomes of an assert statement are as follows:

1. If assertions are disabled, Java skips the assertion and goes on
in the code.
2. If assertions are enabled and the boolean expression is true, 
then our assertion has been validated and nothing happens. 
The program continues to execute in its normal manner.
3. If assertions are enabled and the boolean expression is false, 
then our assertion is invalid and a java.lang.AssertionError is thrown.

The following command enables assertions only for classes in the
certification.chapter6.assertions package and any subpackages:

java -ea:certification.chapter6.assertions... certification.chapter6.assertions.Main

You can also enable assertions for a specific class:

java -ea:certification.chapter6.assertions.Assertions certification.chapter6.assertions.Main

You can disable assertions

java -ea:certification.chapter6.assertions... -da:certification.chapter6.assertions.TestClass certification.chapter6.assertions.Main

more info here:
https://docs.oracle.com/cd/E19683-01/806-7930/6jgp65ikq/index.html

Because assertions can, should, and probably will be turned off in 
a production environment, your assertions should not contain any 
business logic that affects the outcome of your code.

Assertions are used for debugging purposes
