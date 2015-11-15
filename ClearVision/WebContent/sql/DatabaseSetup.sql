Drop database if exists BookmarkManager;
Create database BookmarkManager;

use BookmarkManager;

Drop table if exists Users;
Create table Users (
UserID INT NOT NULL AUTO_INCREMENT,
Email VARCHAR(50),
Pass VARCHAR(50),
FirstName VARCHAR(50),
LastName VARCHAR(50),
Primary Key (UserID)
);

Drop table if exists Bookmarks;
Create table Bookmarks (
BookmarkID INT NOT NULL AUTO_INCREMENT,
BookmarkName VARCHAR(50),
URL VARCHAR(500),
Topic VARCHAR(50),
UserIDKey INT,
Primary Key (BookmarkID),
Foreign Key (UserIDKey) references Users(UserID)
);

Drop table if exists Tags;
Create table Tags (
TagID INT NOT NULL AUTO_INCREMENT,
Tag VARCHAR(50),
Primary Key (TagID)
);

Drop table if exists BookmarkTag;
Create table BookmarkTag (
relationshipID INT NOT NULL AUTO_INCREMENT,
BookmarkID int,
TagID int,
Primary Key (relationshipID),
Foreign Key (BookmarkID) references Bookmarks(BookmarkID),
Foreign Key (TagID) references Tags(TagID)
);

Insert into Users (FirstName, LastName, Email, Pass) Values ('Charlie','Winnard','ctwinnard@gmail.com','Pass')

