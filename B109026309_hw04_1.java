
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PTT
 */
public class B109026309_hw04_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String filepath = "data/";
        String filename = "booklist.txt";
        String stockname = "bookstock.txt";
        File f = new File(filepath + filename);//建立圖書資料檔物件
        Scanner sc = new Scanner(f, "UTF-8");
        String[] category = sc.nextLine().split(",");//讀取資料檔的第一列並轉成陣列
        String[] bookinfo = sc.nextLine().split(",");//讀取資料檔的第二列並轉成陣列
        List bookList = new ArrayList();//存放圖書資料的串列集合
        while (sc.hasNextLine()) {//循序讀取圖書資料
            String[] book = sc.nextLine().split(",");//讀取每一列資料後立即拆成字串陣列(每一本書的資訊)
            bookList.add(book);//置入每一本書的資料
        }
        String[][] books = new String[bookList.size()][bookinfo.length];//宣告圖書陣列, 書本數為bookList收集完檔案資料後的數目, 圖書欄位則是第二列讀到的bookinfo大小
        for (int i = 0; i < books.length; i++) {
            String[] book = (String[]) bookList.get(i);
            books[i] = book;//這兩句可以寫在一起, 即取出List內的元素(每個均為一維陣列)便賦予資料給books[i](即第i本書)
        }
        //至此已取得圖書資料
        f = new File(filepath + stockname);//建立庫存資料檔物件
        //循序讀取庫存資料, 資料筆數與圖書資料一樣多
        int[] bookstock = new int[books.length];
        sc = new Scanner(f);
        for (int i = 0; i < bookstock.length; i++) {
            String[] data = sc.nextLine().split(",");//ex: A001,5
            bookstock[i] = Integer.parseInt(data[1]);//取得拆開字串後的第1個元素, 第0個元素則是書號(可以在此與books[i][0]再做一次比對)
        }
        double[] price = new double[books.length];//取出書價存成數字陣列
        for (int i = 0; i < books.length; i++) {
            price[i] = Double.parseDouble(books[i][7]);//將書價字串轉成數字存進陣列
        }
//列出所有的圖書資訊
        System.out.println("歡迎來到圖書館借閱系統，本館一次最多只能借三本書");
        for (int i = 0; i < bookinfo.length; i++) {
            System.out.print(bookinfo[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < books[i].length; j++) {
                System.out.print(books[i][j] + "\t");
            }
            System.out.println();
        }

        //假設要印出文學類的書籍
        System.out.println("=================================");
        boolean isContinue = false;//檢查是否繼續借閱的變數, 預設是不繼續借
        List borrow_list = new ArrayList();// 使用串列集合逐次紀錄借閱書籍
        List time_list = new ArrayList();
        sc = new Scanner(System.in);
        double total = 0;//計算借出書籍的總價錢
        System.out.println("請輸入學號");
        String stunum = sc.nextLine();//輸入代號
        if (stunum.length() == 9) {
            System.out.println("輸入正確");
        } else {
            System.out.println("輸入錯誤");
            System.exit(0);
        }
        do {
            for (int i = 0; i < category.length; i++) {
                System.out.println("[" + (i + 1) + "]" + category[i].split("\\|")[1]);
            }

            System.out.println("選擇想要查詢的圖書分類(輸入阿拉伯數字代號)");
            int index = sc.nextInt();//輸入代號
            sc.nextLine();//讀取緩衝字元(Enter鍵), 以利後續的文字輸入
            String cate = category[index - 1].split("\\|")[1]; ////從螢幕端輸入
            
            String cate_id = "NA";//設定類別代碼, 預設是不存在的代碼
            for (int i = 0; i < category.length; i++) {//尋訪類別陣列逐一比對分類的資訊
                String[] cate_info = category[i].split("\\|");//要使用跳脫字元 \ 將保留字如|,\符號還原                
                if (cate.equals(cate_info[1])) {//比對到了
                    cate_id = cate_info[0];//取得類別代碼, 跳出迴圈
                    break;
                }
            }
            if (!cate_id.equals("NA")) {//如果cate_id不再等於NA, 表示有找到對應的分類, 則輸出書單
                for (int i = 0; i < books.length; i++) {
                    if (books[i][0].startsWith(cate_id)) {//比對書號的前置碼, 是選擇的分類(ex: A)則輸出, 否則跳過
                        String[] book = books[i];//取出第 i 本書
                        for (String b : book) {
                            System.out.print(b + "\t");
                        }
                        System.out.println("庫存量: " + bookstock[i] + "本");
                    }
                }
            } else {
                System.out.println("無此分類");
            }
            //借書流程, 以輸入圖書編號為例

            System.out.println("輸入想借的書的書號");
            String borrow_id = sc.nextLine();
            for (int i = 0; i < books.length; i++) {
                //比對書號, 避免使用者輸入失誤(例如大小寫英文), 設計強迫都轉成大寫再比較
                if (borrow_id.toUpperCase().equals(books[i][0].toUpperCase())) {//找到對應的書籍
                    System.out.println("是否要借這本書(Y/N)");
                    String borrowCheck = sc.nextLine();
                    if (borrowCheck.toUpperCase().startsWith("Y")) {//將輸入的字串轉成大寫字元, 如果首碼是Y就表示要借閱, 則儲存借閱資訊
                        if (bookstock[i] > 0) {//如果還有庫存, 就可以借走
                            bookstock[i] = bookstock[i] - 1;//確定要借走則從庫存中扣掉一本
                            total = total + price[i];//累加書價
                            for (int j = 0; j < 2; j++) {
                                borrow_list.add(books[i][j]);//加到購物車, 注意此時加入的是一個一維陣列(第i本書的所有內容)
                                Date date = new Date();//取得今天的時間
                                int yyyy = date.getYear() + 1900;//取得西元年
                                int mm = date.getMonth() + 1;//取得月份
                                int dd = date.getDate();//取得日期
                                int ww = date.getDay();//取得星期幾
                                int hr = date.getHours();//取得小時
                                int mi = date.getMinutes();//取得分鐘
                                int se = date.getSeconds();//取得秒數
                                String[] weekday = {"日", "一", "二", "三", "四", "五", "六"};//對應ww的星期內容(第0個元素是星期日)
                                String ymd_hms = yyyy + "-" + mm + "-" + dd + " " + hr + ":" + mi + ":" + se + "(" + weekday[ww] + ")";//將日期連成字串
                                time_list.add(ymd_hms);
                            }
                            System.out.println("已放入借閱清單");

                        }
                    } else {
                        System.out.println("本書沒有庫存");
                    }
                    if (borrow_list.size() < 6) {//當串列數超過3時，停止迴圈
                        System.out.println("請問是否還要繼續借書？(Y/N)");
                        String continueBorrow = sc.nextLine();
                        if (continueBorrow.toUpperCase().startsWith("Y")) {
                            isContinue = true;//如果要繼續借, 變數設為true, 啟動下一次迴圈
                        } else {
                            isContinue = false;//如果不想借, 變數設成false, 中止do while迴圈
                        }
                    } else {
                        System.out.println("一次最多借三本書,您已經無法繼續借書了");
                        isContinue = false;
                    }

                }
            }

        } while (isContinue);//可以重複借書的迴圈
        //記錄檔
        FileWriter fw = new FileWriter("Borrowlist.txt");
        fw.write("借閱者代碼" + "\t" + bookinfo[0] + "\t" + bookinfo[1] + "\t" + "圖書分類" + "\t" + "借閱時間" + "\t");
        fw.write("\r\n");
        for (int j = 0; j < borrow_list.size(); j = j + 2) { //輸出借書清單
            String book = (String) borrow_list.get(j) + "\t" + (String) borrow_list.get(j + 1);
            fw.write("s" + stunum + "\t" + book + "\t" + ((String) borrow_list.get(j)).charAt(0) + "       " + "\t" + (String) time_list.get(j));
            fw.write("\r\n");
        }
        fw.close();//封存寫入檔案, 才可以被讀取

        File ffw = new File("borrowlist.txt");
        Scanner rfw = new Scanner(ffw);
        //
        File f2 = new File("borrowlist.txt");//建立借閱清單檔物件
        Scanner sc2 = new Scanner(f2);
        System.out.println("請選擇你是使用者[0]還是管理者[1](請輸入0或1)");
        int role = sc.nextInt();
        if (role == 0) {
            if (borrow_list.size() > 0) {
                System.out.println("專屬於你的借閱清單，記得還書");
                while (sc2.hasNextLine()) {//循序讀取借閱清單
                    String str = sc2.nextLine();
                    System.out.println(str);
                }
                System.out.println("借閱清單總書價為 " + total + "元, 如有遺失需照價賠償");
            } else {
                System.out.println("你沒有借書");
                System.exit(0);
            }
        } else if (role == 1) {
            FileWriter fw2 = new FileWriter("Managerlist.txt");
            System.out.println("歡迎來到管理者介面");
            List bbookList = new ArrayList();//存放借閱紀錄的串列集合

            String[] info = sc2.nextLine().split("\t");//讀取資料檔的第一列並轉成陣列
            while (sc2.hasNextLine()) {//循序讀取圖書資料
                String[] bbook = sc2.nextLine().split("\t");//讀取每一列資料後立即拆成字串陣列(每一本書的資訊)
                bbookList.add(bbook);//置入每一本書的資料
            }

            String[][] bbooks = new String[bbookList.size()][info.length];//宣告圖書陣列, 書本數為bbookList收集完檔案資料後的數目, 圖書欄位則是第二列讀到的info大小
            for (int i = 0; i < bbooks.length; i++) {
                String[] bbook = (String[]) bbookList.get(i);
                bbooks[i] = bbook;//這兩句可以寫在一起, 即取出List內的元素(每個均為一維陣列)便賦予資料給books[i](即第i本書)
            }

            // for (int i = 0; i < info.length; i++) {
            System.out.print(info[1] + "\t" + info[2] + "\t");
            fw2.write(info[1] + "\t" + info[2] + "\t");

            for (int i = 0; i < category.length; i++) {
                System.out.print(category[i].split("\\|")[0] + "\t");
                fw2.write(category[i].split("\\|")[0] + "\t");

            }
            System.out.print(info[0] + "\t" + info[4] + "\t");
            fw2.write(info[0] + "\t" + info[4] + "\t");
            fw2.write("\r\n");
            //}
            System.out.println();

            for (int i = 0; i < bbooks.length; i++) { //輸出借閱紀錄   
                String letter = bbooks[i][1].substring(0, 1);
                String nike;
                if (letter.equals("L")) {
                    nike = "v" + "\t\t\t\t";
                } else if (letter.equals("P")) {
                    nike = "\t" + "v" + "\t\t\t";                
                } else if (letter.equals("T")) {
                    nike = "\t\t" + "v" + "\t";
                } else if (letter.equals("M")) {
                    nike = "\t\t\t" + "v";
                } else {
                    nike = " ";
                }
                System.out.print(bbooks[i][1] + "\t" + bbooks[i][2] + "\t" + nike + "\t" + bbooks[i][0] + "\t" + bbooks[i][4] + "\t");
                fw2.write(bbooks[i][1] + "\t" + bbooks[i][2] + "\t" + nike + "\t" + bbooks[i][0] + "\t" + bbooks[i][4] + "\t");
                fw2.write("\r\n");
                System.out.println();
            }
            fw2.close();
        } else {
            System.out.println("輸入錯誤");
            System.exit(0);
        }
    }

}
