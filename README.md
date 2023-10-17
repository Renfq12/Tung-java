# 麥O勞餐廳模擬點餐系統

資料存取、讀取與檔案的寫入:
1. String filepath = "data/";
2. String filename = "menu.txt";
3. File f = new File(filepath + filename); //建立餐點資料檔物件
4. Scanner sc = new Scanner(f, "UTF-8");
5. Scanner scm = new Scanner(System.in);
6. String[] category = sc.nextLine().split (",");//讀取資料檔的第一列並轉成陣列
7. String[] menuinfo = sc.nextLine().split(","); //讀取資料檔的第二列並轉成陣列
8. List menuList = new ArrayList();//存放餐點資料

點餐程序說明：
使用者介面>使用者現在使用時間>副程式1列出餐點項目(String getmenu)>使用者輸入想點選的餐點類別(輸入阿拉伯數字)(類別代碼NA逐一比對陣列內的餐點資料，if(menus[i][0]... String[]menu比對到後取出陣列內餐點資料。>使用者輸入想選擇的餐點編號>選擇是否點餐>想點幾份>要不要繼續點餐>點餐後印出餐點明細>副程式2getprint餐點明細(品項、價格(total_price)、卡路里(total_cal)等等)>訂單編號 (int) (Math.random() * 100) >選擇用餐地點(內用/外帶)>付款方式(現金/刷卡(String cash))>是否加購紙袋(String bag)>結束本次點餐。
![image](https://github.com/Renfq12/Tung-java/assets/143602495/7f0c7194-5cf6-4afe-9a9d-52d9e1e0fe71)

主程式：
輸出歡迎光臨麥當勞點餐系統
換行
輸出早餐供應時段(6:0-10:30)
Date dnow宣告新的變數
使用者當下使用時間:(yyyy-mm-dd 年月日 幾時幾分)
For迴圈跑出menuinfo菜單陣列資料
Double[]price 取出餐點價格形成陣列

Do{
副程式1-使用者想選擇的餐點類別
Getmenu(上面寫入的category,scm,menus)
換行印出 輸入想點的餐點編號:
讀取使用者輸入的餐點編號。
若使用者輸入B為早餐。
若為非早餐時段。
換行印出詢問是否繼續使用點餐系統
如果使用者輸入SB
從(i0開始 長度到i<menu.length I++)
換行印出:甜心卡要先選取A區再選B區
如果使用者輸入SA
換行印出想送的B區餐點
輸入想要的B區餐點號碼
Stirng order_idb 讀取輸入的B區號碼
If else如果輸入pw 
換行
1+1先選擇紅區
換行
印出想選擇送的白區餐點
for迴圈(i0開始 i長度<menu.length i++)
換行印出:輸入想要的白區號碼
nextLine接續讀出輸入號碼
for迴圈(i0開始 i長度<menu.length i++)
換行印出是否繼續點餐(y/n)
If(y) 布林變數=true /(n)=false
}while迴圈//結束迴圈。
封裝寫入檔案，才能讀取的到

宣告:total:getprint l:getcal
換行印出餐點金額、卡路里
If(當卡路里>=650)
換行印出注意今天攝取的卡路里量
換行印出 選擇用餐的方式(內用0/外帶1)
宣告新字串way if(way.equals(0))
會隨機產生號碼 提供取餐號碼使用
宣告新字串bag amount
換行印出是否加購袋子(是0/否1)
換行印出需要的袋子數量
搭配先前的total 產出總金額
換行印出先前使用者選的用餐地點(內用/外帶)
換行選擇付款方式(刷卡0/現金1)
If(cash.equals(0))
刷卡付款，感應卡片付款

副程式：
1.String getmenu 
 for迴圈(i0開始 i長度< category.length i++)
Index輸入類代號，讀取緩衝字元，以利後續文字輸入，文字螢幕端輸入，若比對到(即取得類別代碼，跳出迴圈)若無比對menu的前置碼, 是選擇的分類則輸出, 否則跳過。
2.double getprint
換行輸出訂單明細:total價位
for迴圈(i0開始 i長度< stress.size I=I+2)
開始計算總價以及總卡路里 
for迴圈(j0開始 j長度<2 j++)
換行印出總價以及總卡路里
結束點餐系統。



宣告好新的一個menu陣列讓上頭存取菜單串列資料集合的List menuList資料存取，收集完檔案資料夾後的數目，讓下面一欄的菜單欄位讀取到的是menuinfo。
檔案存取以及陣列架設完後開始今日的麥當勞餐廳模擬點餐系統。
將麥當勞餐餐點分為以下幾類:
1.甜心卡(對應代號sa、sb):
  甜心卡簡單規則為買A送B，因此只須計算A區的價錢。SA:為甜心卡A區意思，SB:則為甜心卡B區。利用If else判斷當使用者在點餐時先點選B區時，跳出，提醒使用者先點選A區餐點，並重新點餐。
  當使用者輸入SA時，System.out請使用者選擇想送的B區餐點，並將b區餐點加入for迴圈中讀取想要的B區餐點的號碼(order_idb:計算餐點b區的餐點編號)。
2.1+1(pr、pw):
  1+1簡單規則為，紅區選一個白區選一個只要50$。紅區(pr)白區(pw)。預設使用者先選紅區再選白區，並比照甜心卡模式，利用if else以及for迴圈，選擇紅區後選擇白區餐點，最後利用(order_id_b能讀出想要的餐點編號)。
3早餐(B):早餐時段:6:0-10:30
  由於早餐有時間限制，因此利用date dnow = new date、SimpleDateFormat ft = new SimpleDateFormat(yyyy-mm-dd H:mm:ss)判讀使用者使用當下的時間(dnow)，並告知是否在早餐供應時間內。若時間在非早餐時段內:利用if else判斷式 if (time_n > 103000 || time_n < 60000)判斷。 定義時間變數: String time_s = time.format(tNow);
4午晚餐(L):按照正常的點餐程序即可(如下)
  基本陣列列出餐點編號、品項、餐點名稱、餐點價格、餐點熱量
5.單點(D): 按照正常的點餐程序即可(如下)
  基本陣列列出餐點編號、品項、餐點名稱、餐點價格、餐點熱量
