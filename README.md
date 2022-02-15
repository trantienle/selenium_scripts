/***************************************************************************************
*================== Copyright by ASPIRE SOFTWARE COPORATION ============================
****************************************************************************************
* Title        : README.md
* Description  : How to setup and run scripts
* Environment  : selenium-java-4.1.2, openjdk version "1.8.0_222", Eclipse 
* 				 Version: 2021-12 (4.22.0), TestNG for Eclipse Plugin, window10 
* Author  	   : Tran, Tien Le
* Version	   : 1.0 draft version
* Update	   : Updated by Tran, Tien Le on draft version	
* Guidelines   : readme.md
* Template name: Selenium Java and testNG
****************************************************************************************
****************************************************************************************/



# ASPIRE Selenium TestNG Script
#=======================================================================================#
# THIS SCRIPT USING ECLIPSE FOR JAVA, SELENIUM AND TESTNG PLUGIN ON WINDOW10 ENVIRONMENT#
#=======================================================================================#

HOW TO CONFIGURATION AND RUN SCRIPT


1. On Window 10, install Eclipse IDE for Java Developers and install TestNG, Selenium plugin already.
   (refer to the reference section below for more detail on how to install)
   
2. Download code from github, unzip and open project via Eclipse IDE

3. Structure of script:
    aspire_selenium_script
	|__lib
	|__src
	|	 |___testscript
	|
	|
	|__test-ouput
	|______________Referenced Librarties
	|______________TestNG
	
	
	-lib: contain all browser drivers that using for selenium (chrome, firefox, edge, safari, opera), selenium for java, testing for eclipse plugin
	-src: contain all scripts and data for running
		  _src\testscript\commonlib.java: including all common functions that use for test script.
		  _src\testscript\testcases.java: including all steps for test case
		  _src\runningtest.xml: including all data that use for scripts (kind of browser, url, user, pass, ...). We run test script from this file
	-test-output: contain report after running script with HTML template
	-Referenced Libraries: External libraries for Selenium (we can re-add to eclipse project in case it shows errors)
	-TestNG: Including libraries for TestNG (we can re-add to eclipse project in case it shows errors)
	
4. Open file \src\runningtest.xml via Eclipse IDE -> right click -> Run As -> 1 TestNG Suite

5. After running, open file: test-output\index.html to see the html report





#=======================================================================================#
#============= HOW TO INSTALL ECLIPSE, SELENIUM, TESTNG ON WINDOW10=====================#
#=======================================================================================#

I. How to Download and Install Eclipse to Run Java:
	Step 1) Installing Eclipse
			Open your browser and type https://www.eclipse.org/
	Step 2) Click on “Download” button.
	Step 3) Click on “Download 64 bit” button
	Step 4) Click on “Download” button and after that install Eclipse.
	Step 5) Click on Run button
	Step 6) Click on “Eclipse IDE for Java Developers”
	Step 7) Click on “INSTALL” button
	Step 8) Click on “LAUNCH” button.
	Step 9) Click on “Launch” button.
	
	Note: reference https://www.guru99.com/install-eclipse-java.html

II. How to Download, Install & Add TestNG in Eclipse for Selenium	
	Step 1) Open Eclipse software & install new software
			Launch Eclipse.
			On the menu bar, click Help.
			Choose the “Install New Software…” option.	
	Step 2) Search the TestNG using the Find option and Click on the installation button.
	Step 3) Confirm the installation process. Click on confirm button
	Step 4) Accept the license agreement
			Select the radio button “I accept the terms of the license agreement”
			Click on Finish.
	Step 5) After accept the licence agreement,
			wait for installation.
	Step 6) Ignore security warning if occurs
			If you encounter a Security warning, just click “Install Anyway”.
	Step 7) Finish the installation and restart your system
			Wait for the TestNG install in Eclipse to finish. When Eclipse prompts you for a restart, click “Restart now.”
	Step 8) Verify if the installation is done properly
			After the restart, verify if TestNG for Eclipse was indeed successfully installed. Click Window > Show View > Other.
			Then open the Java directory and see if TestNG is included.
			That’s it on how to add TestNG in Eclipse.
	

	Note:	
		in case cannot install testNG from Eclipse market. Please do manualy to add libraries via java selenium project under: \aspire_selenium_script\lib\testng-eclipse-master.zip
		reference https://www.guru99.com/install-testng-in-eclipse.html