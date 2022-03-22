CREATE TABLE "favorite_player" (
    "PlayerID" INT PRIMARY KEY NOT NULL,
    "Player_Name" VARCHAR,
    "Sport" VARCHAR,
    "Number" INT
);
--
--CREATE TABLE "upcoming" (
--    "EventID" INT NOT NULL,
--    "City" VARCHAR,
--    "State" VARCHAR,
--    "EventDate" date, --format YYYY-MM-DD
--    "PlayerID" INT NOT NULL,
--
--    CONSTRAINT "PK_Upcoming" PRIMARY KEY ("EventID"),
--    CONSTRAINT "FK_EventPlayerID" FOREIGN KEY ("PlayerID") references "favorite_player" ("PlayerID")
--);

insert into favorite_player values (100, 'Lebron James', 'Basketball', 6);
insert into favorite_player values (101, 'Odell Beckham Jr', 'Football', 13);
insert into favorite_player values (102, 'Harold Varner III', 'Golf', 1 );

--insert into upcoming values (200, 'Los Angeles', 'CAL', 2022-04-16);
--insert into upcoming values (201, 'Dallas', 'TX', 2022-10-23);
--insert into upcoming values (202, 'Phoenix', 'AZ', 2022-06-30);