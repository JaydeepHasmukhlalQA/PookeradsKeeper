# PookeradsKeeper

# Abouts
This project is part of my course with QA Consultants where we have to create a fully function CRUD application that includes backend(JAVA) and frontend(HTML/CSS/JS).

The project is called Pookerards Keeper; reason I called it this name, **Poo**~~l~~ > ~~Snoo~~**ker** > ~~Bill~~**ards** = Pookerards. The project is aimed to help players who play 8-ball/9-ball pool, snooker, billards, to keep track of your statistics and matches. For exmaple, wins, lossess, win streaks, loss streaks, draws and every single match played.

Current the project is in its early access, therefore functionality will be very limited, so bare in mind before trying.

# Images
![alt text](https://imgur.com/NUZqyjm.png)

# How to use the website
The application is currently hosted on a GCP (Google Cloud Platform) server.
There are two ways to access the application. Either via [jaydeep.io](jaydeep.io) or http://35.234.137.70:8080/PookeradsKeeper-1.0
1. You can login via your username, or you can register by pressing the register button. 
2. To register, you need to enter your username, firstname and lastname. Else you won't be able to register. 
3. Once you're logged in, you can see your main profile page. This is where you'll be able to see your stats (matches once implemented in the future).
4. You can add wins and losses which would keep track of your statistics. 
5. If you would like to edit your firstname or surname, you can click "Edit Details" button and make those changes then don't forget to click "Update Details" else your changes won't be saved.
6. To delete an account, you have to click "Edit Details" > "Delete Details" > "Please delete my account".

# How to run this application
This application is currently being hosted on jaydeep.io. However, if you'd like to recreate this project here are the steps to get it up and running.

## 1 Aquire and run a H2 database
### 1.1 What is an h2 database?
H2 is an open-source lightweight Java database. It can be embedded in Java applications or run in the client-server mode.

### 1.2 Download the h2 database
To run a h2 database, download the jar file [here](http://repo2.maven.org/maven2/com/h2database/h2/1.4.199/h2-1.4.199.jar)

### 1.3 Run the h2 database
Open up a terminal in the same directory as the jar file and run the command
`java -jar h2-1.4.199.jar`

### 1.4 Check the h2 database
The server should now be at [localhost:8082](http://localhost:8082)
The username should be "sa" and password should either be "sa" or empty.

## 2 Download wildfly
### 2.1 What is wildfly?
Wildfly is essentially an application server authored by JBoss, it was previously known as JBoss AS. WildFly is written in Java and implements the Java Platform, Enterprise Edition specification.

### 2.2 Download and extract
You can download the wildfly file [here](https://wildfly.org/downloads/)
Next extract the file in a safe place i.e `Documents`.

### 2.3 Adding datasource to wildfly.
You need to add a datasource to your wildfly project. We need to let wildfly know that there is a h2database that we are currently running.
Go to the wildfly project `wildfly-folder -> standalone -> configurations -> standalone.xml`

The reason we do this, is because the datasource that is provided in the standalone.xml uses in memory database. which means when you close the database, you'll lose all your data! And we don't want that. Therefore we're pointing it to use our database.
Now inside the XML file, look for an XML tag `datasource`. Now after that last datasource called "ExampleDS", add the following below it.
```html
<datasource jta="true" jndi-name="java:jboss/datasources/PookerardsDataSource" pool-name="PookerardsDataSource" enabled="true" use-ccm="true">
    <connection-url>jdbc:h2:tcp://localhost/~/test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url> 
    <driver-class>org.h2.Driver</driver-class>
    <driver>h2</driver>
    <security>
        <user-name>sa</user-name>
        <password></password>
    </security>
    <validation>
        <background-validation>false</background-validation>
    </validation> 
</datasource> 
```
Now you can enter your database with the username "sa" and a blank password.

## 3 Compile and install war file.
Using maven, use `mvn install` to build the Pookerards project. This will create a .war file inside `project-folder/target/Pookerards-1.0.war`
Copy this .war file and put it in `wildfly-folder/standalone/deployments`.

## 4 Running wildfly
**BEFORE WE RUN WILDFLY**
Before we run wildfly, make sure you have:
1. H2 is running. 
2. The standalone.xml is correctly modified and saved.
3. The .war file is in deployments folder. 
If something doesn't work, double check this!

Now can run wildfly and run standalone.bat. Go to `wildfly-folder -> bin -> standalone.bat`
This will now run the project. Visit [localhost:8080](localhost:8080) which is where the wildfly is running. However to view the project you need to append the .war project name at the name. Therefore, [localhost:8080/Pookerards-1.0](localhost:8080/Pookerards-1.0).
