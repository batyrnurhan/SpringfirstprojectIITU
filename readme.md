The entities of the Book, the Users, the Warning were made.
Books have their own ID, name, genres, author, after which a constructor was made and getters and setters
Users have their own ID, name, login, password and id of the book that the users took, after which 
the constructor and getters and setters were made
The warning has its own identifier, name, description, done/not done (boolean value true, false) 
and the identifier of the users who took the books, the time of receipt and delivery of the book and penalties.

Standard repositories with the JpaRepository extension have been created.
Services have been created with the methods of the project.
Book Service
1. Output of all books
2. Conclusion on the idea
3. Create, Delete, Update Books
User Service
1. Withdrawal of all users (only the admin will have access)
2. Deleting users (only the administrator will have access
3. Creation and modification of user data (all have access)
Warning service (only admins have access)
1. output of all warnings
2.deleting changing creating alerts