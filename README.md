# Mavericks-Team7
# Bookstore Library & Stock keeping

Online library management  where users can rent books for a specific time, like them and can also review books. 

This will have 2 interfaces.

    MVPs is marked with a asterisk (*)

# User Interface
Core Features (MVPs)
    Login System (User) 
    User will have unique 10 digit library access card number
    This number will be the userId
    Access to all the book previews
    browse books from the library
    Pay & Rent them for a specific duration
# Optional Features
    Filter them based on category, author, publications etc.
    Request usage of Library Space - do we want to add public events 
    Like/Review Books
    Like/Review Libraries
    Manage Notifications

# Admin Interface 
Core Features (MVPs)
    Login System (Admin) *
    Request book transfers from other Libraries *
    Approve book transfers *
    Track rented books and their availability *
    If unavailable track availability in other libraries *
    List/manage books*
# Optional Features
    Manage Categories
    Approve/Create/Manage public events?
    Send notifications via email to users once lease expires
    Clear fees/extend user duration
    Create Notifications

# Entity

# User:
userId(PK)
firstName
lastName
userName
userPassword
balance

# Admin:
adminId(PK)
firstName
lastName
Username
Password

# Book:
bookId(PK)
categoryId(FK - categoryId)
bookName
currentLibrary(Which library the book is at)(FK - libraryId)
bookAuthor(FK - authorId)
bookCopies
bookCost
bookStatus
listedDate

# BookAuthor
authorId(PK)
authorFName
authorLName

# Categories:
    categoryId(PK)
    categoryName

    Library:
    libraryId(PK)
    libraryName

# BorrowersRecords
    recordId(PK)
    borrowerId(FK - userId) 
    bookId(FK - bookId)
    issueDate
    dueDate
    fees

# ReturnsRecords
    returnId(PK)
    borrowerId(FK - userId)
    bookId(FK - bookId)
    releaseDate
    dueDate

# TransferRecords
    transferId(PK)
    adminId(FK - adminId)
    bookId(FK - bookId)
    requestDate
    arrivalDate
    
    
    Roles:
    Roshan - Admin- login system, add and list books
    Rory - Admin - delete and update boooks. Library Transfer System + Track availability
    Taranvir - User- login, applying for library card, review and like functionality
    Richard - User- Browse/Rent/Pay for books

# Functionality :

Menu


# User Login
Login - Done (Roshan)
Check if username is present it wont register user - Done- (Roshan)
User registration with 10 digit library# done - (Roshan)
Forgot Password -WorkingDone (Roshan)
Create Account - Done(Taranvir)
Search book
Show Books
Add to cart (checkout)


# Admin
 Login - done (Roshan)
Check if username is present it wont register user - Done- (Roshan)
Forgot Password -Done (Roshan)


Add Books - in progress (Taranvir)
Delete Book - done (Rory)
Update Book - In Progress (Rory)


View all users - Done(Taranvir)
Delete user accounts - Done(Taranvir)


