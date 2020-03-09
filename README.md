I have used page factory. For each page different interfaces and their implementation java files have been created.
Created enum to handle different browser types
Managers package have been created for managing Reading files, WebDriver and Page objects
For Data provider created DataProviders package. CustomerDataBean have been created to pass data for customer details. ConfigFileReader for reading configuration properties. JsonDataReader to read Json files for test data.
All Steps have been kept for each page in Steps package
Kept all support methods in Utils package.

for Cross browser updated 'browser' to 'Chrome' or FireFox' in Configuration.properties file

Git Repository - https://github.com/alishachhabra/CucumberProject
How to Run - 
1. Take clone from repo
2. Import project
3. And run from pom.xml
4. You can run from cmd - mvn test then pom.xml path
5. View report target-> cucumber-reports-> report.html
6. For cross browser update the browser as Firefox or Chrome in configuration.properties