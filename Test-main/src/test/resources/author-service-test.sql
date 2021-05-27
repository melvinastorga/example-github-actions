-- insert authors
INSERT INTO `author` (`age`, `name`, `genre`) VALUES (23, "Mark Janel", "Anthology");
SET @autor1_id := LAST_INSERT_ID();
INSERT INTO `author` (`age`, `name`, `genre`) VALUES (43, "Olivia Goy", "Horror");
SET @autor2_id := LAST_INSERT_ID();
INSERT INTO `author` (`age`, `name`, `genre`) VALUES (51, "Quartis Young", "Anthology");
INSERT INTO `author` (`age`, `name`, `genre`) VALUES (34, "Joana Nimar", "History");
SET @autor4_id := LAST_INSERT_ID();

-- insert books
INSERT INTO `book` (`isbn`, `title`, `author_id`) VALUES ("001-MJ", "The Beatles Anthology", @autor1_id);
INSERT INTO `book` (`isbn`, `title`, `author_id`) VALUES ("001-OG", "Carrie", @autor2_id);
INSERT INTO `book` (`isbn`, `title`, `author_id`) VALUES ("001-JN", "A History of Ancient Prague", 4);
INSERT INTO `book` (`isbn`, `title`, `author_id`) VALUES ("002-JN", "A People's History", @autor4_id);