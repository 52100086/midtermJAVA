# midtermJAVA-52100086
**I. Brief explanation**
In this Spring Boot app, several software development principles, patterns, and practices are being applied, including:

1/ Model-View-Controller (MVC) architecture: The app follows the MVC design pattern, separating the application into three components - Model, View, and Controller. This separation of concerns helps in maintaining the codebase and makes it easier to modify or scale the application in the future.

2/ Object-Relational Mapping (ORM): The app uses Hibernate, which is an ORM framework, to map Java objects to relational database tables. This abstraction layer helps in dealing with the complexities of object-oriented programming and relational databases.

3/ Dependency Injection (DI): The app uses Spring Framework's DI functionality to inject dependencies into classes, reducing coupling between components and making the code more modular and maintainable.

4/ Repository pattern: The app uses a repository layer to abstract the data access logic from the service layer, allowing for separation of concerns and easier unit testing.

**II. Code Structure**
The code structure of this Spring Boot application follows the standard MVC (Model-View-Controller) architecture pattern.
- The model package contains the entity classes representing the domain model of the application.
- The repository package contains the interfaces for interacting with the database.
- The service package contains the business logic and interacts with the repository layer.
- The controller package contains the classes responsible for handling user requests and responses, and rendering the appropriate views.
- Additionally, the application uses Hibernate as the ORM (Object-Relational Mapping) framework for database interactions.

<img width="250" alt="image" src="https://user-images.githubusercontent.com/122030902/229352127-94eacf9d-76a3-4e12-9408-34848742d548.png">

**III. Step to run on a local machine**
***Step 1: Set up database (In my case, I use MySQL and XAMPP) ***
<br />
<img width="174" alt="image" src="https://user-images.githubusercontent.com/122030902/229353082-bab813c6-8aa9-4074-8c91-080d5d796cb5.png">
<br />
ERD
<br />
<img width="491" alt="image" src="https://user-images.githubusercontent.com/122030902/229353143-6b78dc30-1e81-493a-aa17-4498908ada57.png">
<br />
Relational Schema:
<br />
<img width="420" alt="image" src="https://user-images.githubusercontent.com/122030902/229353170-62a8fccc-a858-4bb9-9720-54735196d4c8.png">
<br />
***Step 2: Clone the project from my github and run the Spring boot app (the database need to have some of the product included)***
<br />
**Demo App**





