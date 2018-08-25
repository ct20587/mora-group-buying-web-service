INSERT INTO album 
    (
        album_id, album_name,
        artist, url,
        creator, create_date
    ) 
VALUES
    (
        "BRMM-10065", "TVアニメ「BanG Dream！」OP主題歌「ときめきエクスペリエンス！」",
        "Poppin'Party", "http://mora.jp/package/43000033/BRMM-10065/",
        "FZ", NOW()
    ),
    (
        "BRMM-10084", "前へススメ!/夢みるSunflower",
        "Poppin'Party", "http://mora.jp/package/43000033/BRMM-10084/",
        "FZ", NOW()
    ),
    (
        "A63162", "Opera of the wasteland",
        "Roselia", "http://mora.jp/package/43000033/A63162/",
        "FZ", NOW()
    ),
    (
        "PCCG-70432_F", "星のダイアローグ",
        "スタァライト九九組", "http://mora.jp/package/43000004/PCCG-70432_F/",
        "FZ", NOW()
    );

INSERT INTO track
    (
        album_id, track_no, track_name, artist, price,
        memo, purchase_date, creator, create_date
    )
VALUES
    (   -- id 1
        "BRMM-10065", 1, "ときめきエクスペリエンス！", "Poppin'Party", 257,
        NULL, NOW(), "FZ", NOW()
    ), 
    (   -- id 2
        "BRMM-10065", 2, "1000回潤んだ空", "Poppin'Party", 257,
        NULL, NOW(), "FZ", NOW()
    ),
    (   -- id 3
        "BRMM-10084", 1, "前へススメ!", "Poppin'Party", 257,
        NULL, NOW(), "FZ", NOW()
    ),
    (   -- id 4
        "BRMM-10084", 2, "夢みるSunflower", "Poppin'Party", 257,
        NULL, NOW(), "FZ", NOW()
    ),
    (   -- id 5
        "A63162", 2, "軌跡", "Roselia", 257,
        NULL, NOW(), "FZ", NOW()
    ),
    (   -- id 6
        "PCCG-70432_F", 1, "星のダイアローグ", "スタァライト九九組", 297,
        "Whole album purchase, single track was 432 JPY.", NOW(), "FZ", NOW()
    ),
    (   -- id 7
        "PCCG-70432_F", 2, "ディスカバリー!", "スタァライト九九組", 297,
        "Whole album purchase, single track was 432 JPY.", NOW(), "FZ", NOW()
    ),
    (   -- id 8
        "PCCG-70432_F", 3, "星のダイアローグ(instrumental)", "スタァライト九九組", 297,
        "Whole album purchase, single track was 432 JPY.", NOW(), "FZ", NOW()
    ),
    (   -- id 9
        "PCCG-70432_F", 4, "ディスカバリー!(instrumental)", "スタァライト九九組", 297,
        "Whole album purchase, single track was 432 JPY.", NOW(), "FZ", NOW()
    );

INSERT INTO track_co_buyer
    (track_id, co_buyer, creator, create_date)
VALUES
    (1, "FZ", "FZ", NOW()), (1, "PP", "FZ", NOW()),
    (2, "FZ", "FZ", NOW()), (2, "PP", "FZ", NOW()),
    (3, "FZ", "FZ", NOW()), (3, "PP", "FZ", NOW()),
    (4, "FZ", "FZ", NOW()), (4, "PP", "FZ", NOW()),
    (5, "FZ", "FZ", NOW()), (5, "PP", "FZ", NOW()),
    (6, "FZ", "FZ", NOW()), (6, "PP", "FZ", NOW()), (6, "TW", "FZ", NOW()),
    (7, "FZ", "FZ", NOW()), (7, "PP", "FZ", NOW()), (7, "TW", "FZ", NOW()),
    (8, "FZ", "FZ", NOW()), (8, "PP", "FZ", NOW()), (8, "TW", "FZ", NOW()),
    (9, "FZ", "FZ", NOW()), (9, "PP", "FZ", NOW()), (9, "TW", "FZ", NOW());

INSERT INTO user
    (user_id, nickname, create_date)
VALUES
    ("FZ", "Fat Weeb", NOW()),
    ("PP", "Pop Paul", NOW()),
    ("TW", "Ten Wind", NOW());
