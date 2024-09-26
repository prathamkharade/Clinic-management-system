# Clinic-management-system

-----------------------------------------------------------------------------------------
If you want to directly run the application
-----------------------------------------------------------------------------------------

1) Download and install postgresql on port 5432 (important).
2) Open pgadmin4 and click on Servers on left side
3) Let the name be PostgreSQL 16, username 'postgres' and password 'password'.
4) Create a new database named 'FirstDatabase'
5) CLick on Databases -> FirstDatabase -> Schemas -> Tables
6) Righ click on Tables and open Query Tool.
7) Open sqlcode.txt file and paste only the create table statements (if for testing paste 
the query directly).
8) Download and install JDK 17.
9) Open Environment Variables and check in System Variables if path for JAVA_HOME is set. 
Also look inside PATH if path to jre is given. If not add new and set it.
10) Put Clinic.exe on Desktop and open it. It should work now.


-----------------------------------------------------------------------------------------
If you want to see code
-----------------------------------------------------------------------------------------

1) Assuming you already have installed postgresql and JDK, install Eclipse IDE for JAVA EE.
2) Use Help -> Eclipse Marketplace to download e(fx)clipse
3) Go to File -> Import -> Maven -> Existing Maven Projects -> Browse to starttrial folder
-> Finish. Make changes to java files if needed.
4) Install scenebuilder to open and edit fxml files.
5) To build project, on right side of ide, right click on starttrial -> Run As -> Maven 
build. In dialog, in Goals field type 'clean package' (from next time you can just click on 
'9 starttrial()'. 
6) Open terminal inside 'target' folder.
7) Type command 'java -jar starttrial-0.0.1-SNAPSHOT-spring-boot.jar' and run it. It should
open you application.
8) If you want to create .exe, install launch4j. (you can open my launchcode.xml file)
9) In output file field browse the path to desktop and type file name [name].exe
10) In jar, browse to where you starttrial->target folder is and select 
starttrial-0.0.1-SNAPSHOT-spring-boot.jar
11) In icon browse the .ico file you want to give
12) Type on the gear button on top left to build. Do not press on play button.
13) Go to desktop and refresh. Click on app to run it.
