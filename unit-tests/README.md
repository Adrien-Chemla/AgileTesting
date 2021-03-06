## Junit lib & Hamcrest lib Download

```sh
cd /Library/Java/
mkdir JUNIT
cd JUNIT/
sudo wget https://github.com/junit-team/junit4/releases/download/r4.12/junit-4.12.jar
sudo wget http://central.maven.org/maven2/org/hamcrest/hamcrest-all/1.3/hamcrest-all-1.3.jar
sudo chown $USER:$USER /Library/Java/JUNIT/*
sudo chmod 755 /Library/Java/JUNIT/*
```

## Junit & Hamcrest Configuration

```sh
vim ~/.bash_profile
# Put this line at the end of file
export CLASSPATH=/Library/Java/JUNIT/junit-4.12.jar:/Library/Java/JUNIT/hamcrest-all-1.3.jar:.
source ~/.bash_profile
```

## First of all, you need to compile your src classes and test cases (from src folder):

```sh
# Important, to avoid compile errors
cd src/

### Classes
javac -d ../bin/ codingfactory/rpgconsole/enemy/*.java
javac -d ../bin/ codingfactory/rpgconsole/hero/*.java
javac -d ../bin/ codingfactory/rpgconsole/game/*.java

### Tests
javac -d ../bin/ HeroTest.java
```

## Play with the Java App (from bin folder)

```sh
cd bin/
java bin/codingfactory.rpgconsole.game.Starter
```

## Then run your test cases (from bin tests folder)

```sh
cd bin/
java org.junit.runner.JUnitCore test.HeroTest
```

## Enjoy Agile Testing

Thank you.
