# BasicSpringApplication
 
To run this Basic Spring Application, navigate to the "BasicSpringAppApplication" file in the "com.example.basicSpringApp" directory(src/main/java/com.example.basicSpringApp) and run it. Then in your browser navigate to http://localhost:8080/authors which will render the Author List page and run the Author Controller file.
From here you can have the option to choose to create a book or create, which will take you to their respective pages to create an author/book. Similarly, navigating to http://localhost:8080/books will render the Book List page and run the Book Controller file. From here you also have the option to choose to create a book or author.

When the user clicks on the "Create new book" button, they are navigated to a page where they can enter a book's title, and it's author's name. They can also navigate back to the Books List page. When the user enters an input for the author they are redirected to the "Author List" page.

The "Create Book" page is rendered by it's respective thyme template and function are run by the respective controller i.e. the Author Controller and Book Controller file.
When the user enters a new book or author, these entries are populated in their respective repositories and can be seen when the user navigates back to the "Author List" and "Book List" page. 
These two repositories are seen under the "repository" directory as "AuthorRepository" a d "BookRepository". These two interface files handle the data access related to "author" and "book"
entities that are entered by the user. These interfaces extend the "JpaRepository" that is a component of Spring and allows us to keep the application decoupled from other details/components of our project. It also allows us to use many of built-in methods for CRUD operations such as "findbyID()", "save()", and "findAll". 
We also can use these repositories in other classes of our project by using the annotation "@Autowired" which Spring recognizes and implements it into our classes to be used. This allows our "AuthorRepository" and "BookRepository" interfaces along with the "AuthorController" and "BookController" to provide a clean simple way to perform CRUD operations and query the respective database for the respective entities.

Navigating back to the "Book List" page, the user can see the list of books they have entered and update or delete them. If the user chooses to click on "update" they are redirected to the "Update Book" page where they can change the title and author of the book. Upon submitting their changes they are redirected to the "Book List" page where their changes are reflected.
If the user chooses to delete a book they can simply do so by clicking on "Delete" next to the book they desire to delete. 

Similarly to creating a book, the user can also create authors. By navigating to "Create new author" from either the Book List page or Author List page, the user can enter a name of an author. Upon submitting the author name they are redirect to the "Author List" page that reflect their changes. They can then choose if they want to update or delete any of the authors they have entered. Clicking on "Update" next to any of the authors listed will redirect the user the "Update Author" page where they can update the author's name. 
The "Delete" option next to the author names will allow the user to delete that author if they desire. 

