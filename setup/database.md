# Database setups

```sql
CREATE DATABASE mgb
    DEFAULT character set utf8mb4
    DEFAULT COLLATE utf8mb4_general_ci;

USE mgb;

CREATE TABLE test
    (
        id INT UNIQUE,
        msg VARCHAR(512),
        createDate DATETIME
    )
    ENGINE = InnoDB;

INSERT INTO test (id, msg, createDate) VALUES (1, 'first record', NOW());

CREATE USER 'the_user_name'@'localhost' IDENTIFIED BY 'the_password';

GRANT SELECT, INSERT, UPDATE, DELETE ON mgb.* TO 'the_user_name'@'localhost';
```

which can achieve by copy the template and remove the suffix `template`,