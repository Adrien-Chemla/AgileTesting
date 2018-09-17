#! /bin/bash
javac -d ../bin/ HeroTest.java
cd ../bin/
java org.junit.runner.JUnitCore test.HeroTest