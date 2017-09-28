
**jps** - Lists the instrumented Java Virtual Machines (JVMs) on the target system.

https://docs.oracle.com/javase/8/docs/technotes/tools/unix/jps.html

Example,

jps
18027 Java2Demo.JAR
18032 jps
18005 jstat

jps -l remote.domain
3002 /opt/jdk1.7.0/demo/jfc/Java2D/Java2Demo.JAR
2857 sun.tools.jstatd.jstatd

jps -m remote.domain:2002
3002 /opt/jdk1.7.0/demo/jfc/Java2D/Java2Demo.JAR
3102 sun.tools.jstatd.jstatd -p 2002

jps -q suppress class name, jar and arguments

jps -v display arguments passed in JVM
11000 Launcher -Dvisualvm.id=115675940194914 -javaagent:C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2017.1\lib\idea_rt.jar=57342:C:\Program Files (x86)\JetBrains\IntelliJ IDEA 2017.1\bin -Dfile.encoding=UTF-8



**jstat** - Monitors Java Virtual Machine (JVM) statistics. 

jstat -gcutil 13536

**serialver**

serialver -classpath target/classes certification.jvm.Launcher
e.i.

jar file
serialver -classpath EmailSender.jar net.codejava.swing.JFilePicker

two classes
serialver CustomPanel TestSwingZoom

user interface
serialver -classpath EmailSender.jar -show

by default, it does not set a security manager, do it manually
serialver -classpath target/classes -J-Djava.security.manager Launcher

When necessary, a security policy can be specified with the following option:
-J-Djava.security.policy=<policy file>