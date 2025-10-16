CREATE TABLE `space` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name_space` VARCHAR(100) NOT NULL,
    `max_people` INT NOT NULL,
    `price` INT NOT NULL,
    `enabled` BOOLEAN NOT NULL,
    PRIMARY KEY (`id`)
);