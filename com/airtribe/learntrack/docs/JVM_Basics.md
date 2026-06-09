# JVM Basics

## What is JDK, JRE & JVM?

**JDK:** It stands for Java Development Kit. It is the platform dependent software development kit for Java language which contains JRE and various develomental tools for making and running programs using Java language.

**JRE:** It stands for Java Runtime Environment. It contains the JVM and class libraries needed to compile and execute Java Programs on a particular machine.

**JVM:** It stands for Java Virtual Machine. It loads, verifies, and runs Java bytecode. It is responsible for converting bytecode to machine-specific code. It has class loader sub-system, runtime data areas and execution engine.

For more information [Click Here](https://www.ibm.com/think/topics/jvm-vs-jre-vs-jdk)
## What is bytecode?
* Java source code is compiled into machine-independent files called as bytecode class files.
* Bytecode is interpreted by machine specific Java Virtual Machines
(JVMs).
* Bytecode consists of simple, step-by-step instructions for the JVM. 

For more information [Click Here](https://ocw.mit.edu/courses/ec-s01-internet-technology-in-local-and-global-communities-spring-2005-summer-2005/7aa811155d4e4d6c9bd9f656d39ff5d7_MITEC_S01S05_bytecode.pdf)
## What does "write once, run anywhere" mean?
Write once, run anywhere means that a Java program once written can be run on any machine that offers a JVM implementation without changing anything, since Java code is first compiled into an intermediate representation known as bytecode which is machine independent.