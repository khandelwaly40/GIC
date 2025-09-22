The minimum requirement to run this project:
  - JDK - 17
  - Maven - 3.8
  -  OS - Any OS which has JDK installed
  - Junit package already installed in your repo (if connected to VPN) or go to pom.xml and right click and update maven project to download relevant dependencies.

Running the Application: After cloning this project from master branch, open the project in IDE (ex: Intellij) - Select JDK and .m2 repo followed by maven (if not using bundled)
 - Go to MinesweeperMainApp class (entry point), right click and select 'Run Minesweeper main()'
 - If using maven to run the application, open bash and use command 'mvn exec:java -Dexec.mainClass="com.minesweeper.MinesweeperApp" (need to update pom.xml -> exec-maven-plugin).
 - If using Run Configuration of Intellij then add 'mvn clean exec:java' in Run command and select the parent working directory.

Design pattern:
  - Used SOLID principles and OOP concepts as and where required.
  - Can go for more abstraction, but as the scope of the application is small so keeping it simple.
  - Design patterns can be followed if need to extend this project.

Assumptions:
  - Stopping the game when user input some invalid inputs
  - Game continues as long as user wants.
