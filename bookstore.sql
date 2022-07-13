DROP database if exists bookstore;
CREATE SCHEMA IF NOT EXISTS `bookstore` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bookstore` ;

-- -----------------------------------------------------
-- Table `bookstore`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`admin` (
  `admin_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`admin_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10001
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`book_author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`book_author` (
  `author_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`author_id`),
  UNIQUE INDEX `idbook_author_UNIQUE` (`author_id` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`categories` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`category_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`library`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`library` (
  `library_id` INT NOT NULL AUTO_INCREMENT,
  `library_name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`library_id`),
  UNIQUE INDEX `library_id_UNIQUE` (`library_id` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`book` (
  `book_id` INT NOT NULL AUTO_INCREMENT,
  `book_name` VARCHAR(45) NOT NULL,
  `book_copies` INT NOT NULL,
  `book_cost` DOUBLE NOT NULL,
  `book_status` VARCHAR(45) NOT NULL,
  `listed_date` VARCHAR(45) NOT NULL,
  `author_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  `library_id` INT NOT NULL,
  `admin_id` INT NOT NULL,
  PRIMARY KEY (`book_id`, `author_id`, `category_id`, `library_id`, `admin_id`),
  UNIQUE INDEX `book_id_UNIQUE` (`book_id` ASC) ,
  INDEX `fk_book_book_author_idx` (`author_id` ASC) ,
  INDEX `fk_book_categories1_idx` (`category_id` ASC) ,
  INDEX `fk_book_library1_idx` (`library_id` ASC) ,
  INDEX `fk_book_admin1_idx` (`admin_id` ASC) ,
  CONSTRAINT `fk_book_admin1`
    FOREIGN KEY (`admin_id`)
    REFERENCES `bookstore`.`admin` (`admin_id`),
  CONSTRAINT `fk_book_book_author`
    FOREIGN KEY (`author_id`)
    REFERENCES `bookstore`.`book_author` (`author_id`),
  CONSTRAINT `fk_book_categories1`
    FOREIGN KEY (`category_id`)
    REFERENCES `bookstore`.`categories` (`category_id`),
  CONSTRAINT `fk_book_library1`
    FOREIGN KEY (`library_id`)
    REFERENCES `bookstore`.`library` (`library_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 1000000124
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `bookstore`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`cart` (
  `cart_id` INT NOT NULL AUTO_INCREMENT,
  `book_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `book_copies` INT NOT NULL,
  PRIMARY KEY (`cart_id`,`book_id`,`user_id`),
  UNIQUE INDEX `cart_id_UNIQUE` (`cart_id` ASC),
  INDEX `fk_book_book_id1_idx` (`book_id` ASC) ,
  INDEX `fk_user_user_id1_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_book_book_id1`
    FOREIGN KEY (`book_id`)
    REFERENCES `bookstore`.`book` (`book_id`),
  CONSTRAINT `fk_user_user_id1`
    FOREIGN KEY (`user_id`)
    REFERENCES `bookstore`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1000000124
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `bookstore`.`checkout`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`checkout` (
  `checkout_id` INT NOT NULL AUTO_INCREMENT,
  `book_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `book_copies` INT NOT NULL,
  PRIMARY KEY (`checkout_id`,`book_id`,`user_id`),
  UNIQUE INDEX `checkout_id_UNIQUE` (`checkout_id` ASC),
  INDEX `fk_book_book_id2_idx` (`book_id` ASC) ,
  INDEX `fk_user_user_id2_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_book_book_id2`
    FOREIGN KEY (`book_id`)
    REFERENCES `bookstore`.`book` (`book_id`),
  CONSTRAINT `fk_user_user_id2`
    FOREIGN KEY (`user_id`)
    REFERENCES `bookstore`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1000000124
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookstore`.`borrower_record`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`borrower_record` (
  `borrower_id` INT NOT NULL AUTO_INCREMENT,
  `issue_date` VARCHAR(45) NOT NULL,
  `due_date` VARCHAR(45) NOT NULL,
  `fees` DOUBLE NULL DEFAULT '0',
  `user_id` INT NOT NULL,
  `book_id` INT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`borrower_id`, `user_id`, `book_id`),
  INDEX `fk_borrower_record_user1_idx` (`user_id` ASC) ,
  INDEX `fk_borrower_record_book1_idx` (`book_id` ASC) ,
  CONSTRAINT `fk_borrower_record_book1`
    FOREIGN KEY (`book_id`)
    REFERENCES `bookstore`.`book` (`book_id`),
  CONSTRAINT `fk_borrower_record_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `bookstore`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;