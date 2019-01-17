@echo off 
echo path:%~dp0
set base=%~dp0


set libs=%base%\lib
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_121
set file_name=test.xlsx

"%JAVA_HOME%/bin/java"  -Dbase=%base% -Dfile=%file_name%  -jar jtracConflict_main.jar
@pause