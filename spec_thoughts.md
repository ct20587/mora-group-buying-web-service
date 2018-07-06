# mora 歌曲共購登錄系統

## UI

### Register
- 貼上網址後，自動括回封面、曲目列表，提供清單以勾選方式加入，可增加共買者（需有自動完成之類的）
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

mysql maybe

#### track
|      track id      |    track name    | album id (mora url path) | track number (ordinal) | price |   co-buyer   | purchase date | creator  | create date | update date |
| ------------------ | ---------------- | ------------------------ | ---------------------- | ----- | ------------ | ------------- | -------- | ----------- | ----------- |
| int auto increment | varchar utf8-mb4 | varchar utf8-mb4         | small int              | float | array maybe? | datetime      | datetime | datetime    | datetime    |

#### album
|     album id      |    album name    |        cover art        |       link       | creator  | create date | update date |
| ----------------- | ---------------- | ----------------------- | ---------------- | -------- | ----------- | ----------- |
| varchavr utf8-mb4 | varchar utf8-mb4 | binary? imgur link? s3? | varchar utf8-mb4 | datetime | datetime    | datetime    |

#### co-buyer
|     user id      |     nickname     | create date | update date |
| ---------------- | ---------------- | ----------- | ----------- |
| varchar utf8-mb4 | varchar utf8-mb4 | datetime    | datetime    |

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