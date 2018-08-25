# mora 歌曲共購登錄系統

## UI

### Register
- 貼上網址後，自動刮回封面、曲目列表，提供清單以勾選方式加入，可增加共買者（需有自動完成之類的）
- 提供表格全手動輸入

### Checkout
- 能以日期匯入曲目或搜尋曲目、專輯名稱匯入，排序跟分群都要有，可能還要能生成 permalink
- 去爬即期匯率提供換算參考？

### Maintenance
- 更改已登錄的歌曲資訊，僅限歌曲資訊，如曲名、封面、順序等，可能至少要保留上一版甚至所有歷史

### Browser Extension
在瀏覽 mora 網頁的時候可以去按按鈕，跳出註冊歌曲的小視窗，應該會幾乎和註冊頁一樣，另有按鈕是開分頁連到主站

### 看起來也會需要一套簡單的會員系統

---
## Data

### Storage
MySQL
```sql
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;
```

在一首歌只有一個人買的情況下，可以有兩種表示方式：
1. 直接看 track.creator
2. co-buyer 該 track id 只會有一筆紀錄
先用 2 的方式來做，比較不會變成一條潛規則



#### track co_buyer
|           track id           |  co_buyer   |   creator   | create date  | updater | update date |
| :--------------------------: | :---------: | :---------: | :----------: | :-----: | :---------: |
| medium int unsigned, NN, idx | varchar, NN | varchar, NN | datetime, NN | varchar |  datetime   |

#### track
|                track id                 | album id (mora url path) |        track no (ordinal)         | track name  |   artist    |      price (yen)       | purchase date |  memo   |   creator   | create date  | updater | update date |
| :-------------------------------------: | :----------------------: | :-------------------------------: | :---------: | :---------: | :--------------------: | :-----------: | :-----: | :---------: | :----------: | :-----: | :---------: |
| medium int unsigned, auto increment, PK | varchar, NN, UNIQUE KEY  | tiny int unsigned, NN, UNIQUE KEY | varchar, NN | varchar, NN | small int unsigned, NN |   datetime    | varchar | varchar, NN | datetime, NN | varchar |  datetime   |

#### album
| album id  (mora url path) | album name  |   artist    |       cover art        |   url    |   creator   | create date  | updater | update date |
| :-----------------------: | :---------: | :---------: | :--------------------: | :------: | :---------: | :----------: | :-----: | :---------: |
|        varchar, PK        | varchar, NN | varchar, NN | text (imgur link? s3?) | text, NN | varchar, NN | datetime, NN | varchar |  datetime   |

#### user
|   user id   |     nickname     | create date  | updater | update date |
| :---------: | :--------------: | :----------: | :-----: | :---------: |
| varchar, PK | varchar, NN, idx | datetime, NN | varchar |  datetime   |

---
## API

### Register POST

### Tracks GET

### Tracks PATCH

---
## Goal

先不要太貪心，先做出新增和查詢的 api 就很不錯了

spring boot 弄出 web framework, 串 database, swagger 文件和簡單 api demo

---
## 更廣泛的應用？

### 基本上把 track 換成 item, album 換成 package 幾乎就可以適用於其他團購的樣子？頂多再加上數量的考量？