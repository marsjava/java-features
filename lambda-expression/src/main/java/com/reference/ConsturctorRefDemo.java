package com.reference;

public class ConsturctorRefDemo {
    public static void main(String[] args) {
        System.out.println(primesum(0));
        int num = 50;
        int sum = 0;
        int j = 0;
        String[] arg = new String[num/2];
        for(int i=2;i<=num;i++){
            if(i%2==0) {
                sum = sum+i;
                arg[j++] = Integer.toString(i);
            }
        }
        //System.out.println(String.join(",",arg));
        //System.out.println(sum);
    }
    static long primesum(int maxNum) {
        int sum = 0, num = 0;
        //insert your code here
        if (maxNum<=0) {
            sum = 0;
        } else {
            for(int number = 1; number <= maxNum; number++) {
                for (int i = 2; i <= number/2; i++)   {
                    num = 0;
                    if(number % i == 0) {
                        num++;
                        break;
                    }
                }
                if(num == 0 && number != 1 ) {
                    sum = sum + number;
                }
            }
        }
        return sum;
    }
}
/*
<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>javaApp</groupId>
    <artifactId>EvenSum</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <!--insert your plugins here-->
    <packaging>jar</packaging>
    <name>challenge</name>
    <url>http://maven.apache.org</url>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
     <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.1</version>
                <inherited>true</inherited>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <classpathPrefix>lib</classpathPrefix>
                            <mainClass>javaApp.EvenSum</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>1.3</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>java</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <mainClass>javaApp.EvenSum</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
 */