find . -name "*.java" > src.txt

javac -sourcepath . @src.txt

java mkgosise.Main scenario.txt