# springboot2exe - How to package a SpringBoot App with JDKs standard javapackager

If you ever happen to ask yourself how to package your [Spring Boot](https://projects.spring.io/spring-boot/) App as an .exe File for running in Windows (could that possibly happen :P ?!), then maybe the standard Oracle JDK [javapackager](http://docs.oracle.com/javase/8/docs/technotes/tools/windows/javapackager.html) could be something for you.

This is a simple example project to show how this is done

##### 1. Be sure to run all that on a Windows Box!

It seems to be simple - but all those steps only run on a Windows Machine or VM and will fail on your Mac or Ubuntu :) So fire up one!

##### 2. You just need a Standard Java-JDK-Installation

javapackager will be included in your jdk_xxx\bin Folder

##### 3. Install current Inno Setup release

All the packaging is done through the freeware [Inno Setup](http://www.jrsoftware.org/isinfo.php) installer for Windows programs - javapackager builds upon it, when creating an exe-File. Get the latest version [here](http://www.jrsoftware.org/isdl.php) and __be sure to have administrative rights!__ Refrain from just installing it on some machine, packaging the resulting Folder under C:\Program Files into a .zip and copy it to another Windows Box -> __This will not work!__ You would get error messages, that are quite confusing like:

```
Bundler EXE Installer skipped because of a configuration problem: Main application jar is missing. javapackager deploy exe
Advice to fix: Make sure to use fx:jar task to create main application jar javapackager
```

...which will point you in a complete false direction! This is one of the worst error messages I have ever seen :P

##### 4. do a normal Maven build

```
mvn clean package
```

##### 5. execute javapackager inside your target-Folder, where your Spring boot fat.jar was build

With our project, the command is something like this: 

```
javapackager -deploy -native exe -outdir ./executable -srcfiles springboot2exe-0.0.1-SNAPSHOT.jar -outfile springboot2exe-0.0.1-SNAPSHOT -appclass org.springframework.boot.loader.JarLauncher -v
```

The -appclass __is not your Application.class__ with the main in it! You need to pick Spring Boot´s __org.springframework.boot.loader.JarLauncher__


##### 6. Install target/executable/JarLauncher-1.0.exe

You´ll find a JarLauncher-1.0.exe inside your target/executable folder - install it and it will create a folder inside of __C:\Users\YourUserHere\AppData\Local\JarLauncher__, where the __runtime folder__ holds a JRE and the __app folder__ contains your fat.jar.

##### 7. Start JarLauncher-1.0.exe

Start __C:\Users\YourUserHere\AppData\Local\JarLauncher\JarLauncher-1.0.exe__ - it´s named the same like the installer, but it´s the actual runnable .exe File you wanted. Just take a look inside your Windows Taskmanager:

![taskmanager_process_jarlauncher](https://github.com/jonashackt/springboot2exe/blob/master/taskmanager_process_jarlauncher.png)