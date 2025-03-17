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
    - If everything works correctly, you should see 4 new tables created under the mvc2-database database:
      - projects
      - students
      - teams
- Views are in [subfolders](https://github.com/uncg-csc340/sp25-mvc-demo2/tree/1c9b2eac1d3b0431d465cade4ff32d7a5334962d/src/main/resources/templates), so when we reference them in the MVC Controller, we [include the subfolder name](https://github.com/uncg-csc340/sp25-mvc-demo2/blob/26b3456145a69da7c01c696e573b0ca46456af37/src/main/java/com/csc340/mvc_demo2/team/TeamController.java#L33).
- Foreign Keys
    - The Student entity has a foreign key pointing to the Team entity. This is a [`@ManyToOne`](https://github.com/uncg-csc340/sp25-mvc-demo2/blob/26b3456145a69da7c01c696e573b0ca46456af37/src/main/java/com/csc340/mvc_demo2/student/Student.java#L23) mapping. Many Students may belong to one Team. A Student may only be in one Team. Each Student in the database will have a column called team_id to identify which Team they belong to. This column may be null if the Student has not Team affiliation.
    - The Project entity has a foreign key pointing to the Team entity. This is also a [`@ManyToOne`](https://github.com/uncg-csc340/sp25-mvc-demo2/blob/26b3456145a69da7c01c696e573b0ca46456af37/src/main/java/com/csc340/mvc_demo2/project/Project.java#L15) mapping. Many Projects may belong to one Team. A Project may only belong to one Team. Each Project in the database will have a column called team_id to identify which Team it belongs to.
    - When we create a new Student, we want to optionally add them to a team, so we [get all available Teams with space](https://github.com/uncg-csc340/sp25-mvc-demo2/blob/26b3456145a69da7c01c696e573b0ca46456af37/src/main/java/com/csc340/mvc_demo2/student/StudentController.java#L115) to use them with the student form. For unaffilated Students, we start with Team Id -1, then convert that to a null on the server side. We do the same thing with the update form.
    - When we create a new Project, it MUST belong to a Team so we [start this is at the Team page](https://github.com/uncg-csc340/sp25-mvc-demo2/blob/26b3456145a69da7c01c696e573b0ca46456af37/src/main/resources/templates/team/team-details.ftlh#L69), then we include the team Id in the form.
    - When we delete a Team, we must decide what happens to the affilated Students and Projects.
        - Projects cannot exist outside of a Team, so when the Team gets deleted, the [Projects must also get deleted.](https://github.com/uncg-csc340/sp25-mvc-demo2/blob/26b3456145a69da7c01c696e573b0ca46456af37/src/main/java/com/csc340/mvc_demo2/team/TeamController.java#L66)
        - Students may be unaffilated, so when we delete a Team, we remove the affiliation by [setting the Team ID to null](https://github.com/uncg-csc340/sp25-mvc-demo2/blob/26b3456145a69da7c01c696e573b0ca46456af37/src/main/java/com/csc340/mvc_demo2/team/TeamController.java#L68) for each Student.
- We also have a [Home Controller](https://github.com/uncg-csc340/sp25-mvc-demo2/blob/26b3456145a69da7c01c696e573b0ca46456af37/src/main/java/com/csc340/mvc_demo2/HomeController.java#L7) that handles our redirects. You would typically use this to load a home page or a dashboard.
- 
