CREATE TABLE "Favorite_Player" (
    "PlayerID" INT PRIMARY KEY NOT NULL
    "Player_Name" TEXT 
    "Sport" TEXT
    "Number" INT
);

CREATE TABLE "Upcoming" (
    "EventID" INT NOT NULL
    "City" TEXT
    "State" TEXT
    "Event_Date" date /*format YYYY-MM-DD*/

    CONSTRAINT "PK_Upcoming" PRIMARY KEY ("EventID")
    CONSTRAINT "FK_EventPlayerID" FOREIGN KEY ("PlayerID") references "Favorite_Player" ("PlayerID")
);

insert into Favorite_Player values (100, "Lebron James", "Basketball", 6);
insert into Favorite_Player values (101, "Odell Beckham Jr", "Football", 13);
insert into Favorite_Player values (102, "Harold Varner III", "Golf" );

insert into Upcoming values (200, "Los Angeles", "CAL", 2022-04-16);
insert into Upcoming values (201, "Dallas", "TX", 2022-10-23);
insert into Upcoming values (202, "Pheonix", "AZ", 2022-06-30);