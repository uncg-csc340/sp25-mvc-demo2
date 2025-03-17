# sp25-mvc-demo2
## CRUD MVC App using JPA/Hibernate, MySQL, and FreeMarker.
## Installation
- Get the project
    - clone  
        ```
      git clone https://github.com/uncg-csc340/sp25-mvc-demo2.git
        ``` 
    - OR download zip.
- Open the project in IntelliJ.
- This project is built to run with jdk 21.
## Notes:
- [`/src/main/resources/application.properties`](https://github.com/uncg-csc340/sp25-mvc-demo2/blob/dabf1bbd01670ff453730273827bfe3a01782abd/src/main/resources/application.properties) file  is the configuration for the MySQL database.
- the database name is on the `datasource.url` property between the last `/` and the `?`. In this case the database name is `mvc2-database`.
  - You MUST have the database up and running before running the project! 
    - Start your AMPPS Server.
    - Click on the Home icon to open the localhost server on your browser.
    - Go to Database Tools and open phpMyAdmin to start up the MySQL Dashboard.
    - Ensure the database that you need is available. Either
      - Create a database called `student-database`
      - OR edit `datasource.url` to point to a database that you do have.
  - Verify your username and password is spelled correctly in the properties file.
  - Import sample database (optional)
    - To make the process easier, we included an arcive file for a database, `mvc2-database.sql`.
    - You may import this database into your local MySQL server so you can have a copy of the database with some entries.
    - Click on the newly created `mvc2-database` database and look for the Import option at the top. Click Browse, select the archive file, and click Import.
    - If everything works correctly, you should see 4 new tables created under the taskmanager database:
      - projects
      - students
      - teams
