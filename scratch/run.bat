@echo off

setlocal enabledelayedexpansion

set app_jar="%1"
set main_class="%2"
set libs_path="%3"

set classpath=.;%1

FOR %%j IN (%libs_path%\*.jar) DO (	
	set classpath=!classpath!;%%j
)
java -cp %classpath% %main_class%

pause
