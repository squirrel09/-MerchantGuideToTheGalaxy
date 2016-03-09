@echo off
echo Loading....
echo path:%~dp0

set base=%~dp0

set class=%base%\classes

set class_path=%class%;

java -classpath %class_path% com.thoughtworks.homework.currencyExchangeTool.TestAPP
@pause