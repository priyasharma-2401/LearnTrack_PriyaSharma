# LearnTrack_PriyaSharma

#### **JVM:** 

The JVM is a platform-specific virtual machine that executes Java bytecode.
It manages memory (heap, stack) ,Garbage collection ,Security , Just-In-Time (JIT) compilation.
It runs the program.


#### **JRE:**

JRE includes JVM and Core Java libraries (like java.lang, java.util)
It cannot compile code, only execute already-compiled programs.


#### **JDK:**

JDK includes JRE , JVM and developer tools like: javac (compiler), javadoc, jar, debugger tools etc.


#### **Bytecode:**

Bytecode is an intermediate language that Java programs are converted into. Java source code is converted into bytecode when compiled and gets stored in a .class file.
Different operating systems have different JVMs, but all understand the same bytecode.


#### **WORA(Write once run anywhere)**

Java follows the principle of “Write Once, Run Anywhere” (WORA) because Java source code is compiled into platform-independent bytecode instead of machine-specific instructions. This bytecode can be executed by any JVM, regardless of the underlying operating system.
Each platform provides its own JVM implementation, which understands the same bytecode format. As a result, developers can write and compile Java applications once and run them consistently across multiple platforms without recompilation, improving portability and reducing deployment complexity.You write a Java program once, and it can run on any system that has a JVM — Windows, macOS, or Linux — without changing the code.