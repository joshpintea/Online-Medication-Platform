# Installation
Clone or download the project.

Make sure that you have mysql installed on your machine, if you dont have it, you can download from here https://www.mysql.com/downloads/

Download and install Node.js from nodejs.org/en/download/

Download and install java jdk 1.8 and java jre 1.8

Download and install maven.

Download and install python > 3.x.x

Install rabbitmq 

Navigate with a terminal into "frontend/" directory and install the app dependencies by running the following command

                                                            
    npm install
 
 
 # Database config
Change the name of database, user and password from this file:

    "backend\core\src\main\resources\persistence.properties"
 
 For first run of the backend app set also the "hibernate.hbm2ddl.auto" field from "none" to "create" and then change it back. In this way, the database and all the tables are created. 

Change also the db credentials for the django web service from this file:

    "soap_web_services/soap_web_services/settings.py"

Change the db credentials from this file for the soap web service that is written in java.
    
    "java_soap_web_service/src/main/resources/persistence.properties"


# Rmi client 
Change the patient id from the config file:
"backend\rmi-client\src\main\resources\persistence.properties"
 
 
 # Producer dependencies
 Navigate to
 
    "producer/" 
    
 and run the following command:
 
    python -m pip install -r requirements.txt
 
 # Django web service dependecies
Install virtual env

Navigate to 
   
    "soap_web_service/"
 
Run the following commands:

    virtualenv env
    source env/Scripts/activate or on windows cd/env/Scripts/; .\activate
    pip install -r requirements.txt
 
 # Running configuration
 
  - start the mysql server
  - start the producer: go to "/producer" directory:
 
        python -m pilotproducer [run_on_infinite] 
        example: python -m pilotproducer True
        
  - start the django web service
 
    Navigate to "soap_web_service/" and after that activate the enviroment that you had created on "Django web service dependencies" step and run the following command:
  
        python manage.py runserver 
    
  The server will start on 8000 port.
  
 - start the java soap web service app: default port: 8087 (can be changed from this file "java_soap_web_service/src/main/resources/application.properties")

 - start the backend server: by default it will start on the 8088 port. (can be changed from this file "/app/src/main/resources/application.properties")

 - start the client: default port is 3000: navigate into "frontend/" directory and run the following command:
   
        npm start
        
 - start the rmi-client app (optional) 
      The patient can be configured from the persistence.properties file that can be find into the rmi-client module resources. 
 

  
 
   
