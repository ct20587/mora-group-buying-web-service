CREATE TABLE track_co_buyer (
    track_id MEDIUMINT UNSIGNED NOT NULL KEY,
    co_buyer VARCHAR(32) NOT NULL,
    creator VARCHAR(32) NOT NULL,
    create_date DATETIME NOT NULL,
    updater VARCHAR(32) DEFAULT NULL,
    update_date DATETIME DEFAULT NULL
) ENGINE = InnoDB;

CREATE TABLE track (
    track_id MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    album_id VARCHAR(512) NOT NULL,
    track_no TINYINT UNSIGNED NOT NULL,
    track_name VARCHAR(128) NOT NULL,
    artist VARCHAR(128) NOT NULL,
    price SMALLINT UNSIGNED NOT NULL COMMENT 'Japanese yen',
    purchase_date DATETIME DEFAULT NULL,
    creator VARCHAR(32) NOT NULL,
    create_date DATETIME NOT NULL,
    updater VARCHAR(32) DEFAULT NULL,
    update_date DATETIME DEFAULT NULL
) ENGINE = InnoDB;

CREATE TABLE album (
    album_id VARCHAR(512) PRIMARY KEY COMMENT 'Album id from url, usually cd no.',
    album_name VARCHAR(128) NOT NULL,
    artist VARCHAR(128) NOT NULL,
    cover_art TEXT DEFAULT NULL,
    url TEXT NOT NULL,
    creator VARCHAR(32) NOT NULL,
    create_date DATETIME NOT NULL,
    updater VARCHAR(32) DEFAULT NULL,
    update_date DATETIME DEFAULT NULL
) ENGINE = InnoDB;

CREATE TABLE user (
    user_id VARCHAR(32) PRIMARY KEY,
    nickname VARCHAR(32) NOT NULL,
    create_date DATETIME NOT NULL,
    updater VARCHAR(32) DEFAULT NULL,
    update_date DATETIME DEFAULT NULL,
    INDEX (nickname)
) ENGINE = InnoDB;