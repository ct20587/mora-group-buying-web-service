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
        );

INSERT INTO track
    (
        album_id, track_no, track_name, artist, price,
        purchase_date, creator, create_date
    )
VALUES
    (
        "BRMM-10065", 2, "1000回潤んだ空", "Poppin'Party", 257,
        NOW(), "FZ", NOW()
    );

INSERT INTO track_co_buyer
    (track_id, co_buyer, creator, create_date)
VALUES
    (1, "FZ", "FZ", NOW()),
    (1, "PP", "FZ", NOW());

INSERT INTO user
    (user_id, nickname, create_date)
VALUES
    ("FZ", "Fat Weeb", NOW()),
    ("PP", "Pop Paul", NOW());
