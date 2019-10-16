# Installation
Clone or download the project.

Make sure if you have mysql installed on your machine, if you dont have it, you can download from here https://www.mysql.com/downloads/

Download and install Node.js from nodejs.org/en/download/

Download and install java jdk 1.8 and java jre 1.8

Download and install maven.

Navigate with a terminal into "frontend/" directory and install the app dependencies by running the following command

                                                            
    npm install
 
 
 # Database config
Change the name of database, user and password from this file:

    "backend\core\src\main\resources\persistence.properties"
 
 For first run of the backend app set also the "hibernate.hbm2ddl.auto" field from "none" to "create" and then change it back. In this way, the database and all the tables are created. 
 
 # Running configuration
 
 - start the mysql server
 - start the backend server: by default it will start on the 8088 port.
 - start the client: default port is 3000: navigate into "frontend/" directory and run the following command:
   
        npm start
        
                                         
 
 
 
   
