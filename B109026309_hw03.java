
import java.util.ArrayList;
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
public class B109026309_hw03_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List borrowList = new ArrayList();//宣告串列函數
        String[] category = {"L|literature", "P|psychology", "T|thriller", "M|medicine"};//宣告字串陣列
        String[] bookinfo
                = {"類別        ", "書名            ", "作者           ", "頁數", "書號", "出版社        ", "ISBN        ", "發行日    ", "定價 ", "有無電子書", "有無館藏"};//宣告字串陣列
        String[][] books = {
            {"literature", "恐懼先生          ", "潘柏霖               ", "144", "L001", "潘柏霖    ", "9789574392506", "2021-11-19", "666 ", " Y", "        N"},
            {"literature", "這裡沒有光        ", "追奇                 ", "160", "L002", "時報出版  ", "9789571368351", "2016-11-29", "300 ", " Y", "        Y"},
            {"literature", "風箏落不下來      ", "陳繁齊               ", "208", "L003", "大田      ", "9789861795478", "2019-02-01", "350 ", " N", "        Y"},
            {"literature", "本宮不玩了(一)    ", "安豫                 ", "304", "L004", "說頻文化  ", "9789865289645", "2021-11-10", "250 ", " N", "        N"},
            {"literature", "本宮不玩了(二)    ", "安豫                 ", "304", "L005", "說頻文化  ", "9789865289652", "2021-11-10", "250 ", " N", "        N"},
            {"psychology", "回家              ", "章成                 ", "168", "P001", "商周      ", "9786263180062", "2021-10-09", "380 ", " Y", "        Y"},
            {"psychology", "心要好好放        ", "黃子容               ", "192", "P002", "光采      ", "9789869912679", "2021-11-15", "300 ", " N", "        N"},
            {"psychology", "我要的新人生      ", "川原卓巳             ", "288", "P003", "天下雜誌  ", "9789863987253", "2021-11-30", "350 ", " N", "        Y"},
            {"psychology", "今天也要用心生活  ", "松浦彌太郎(張富玲譯) ", "168", "P004", "麥田      ", "9789863446804", "2019-08-31", "260 ", " N", "        N"},
            {"psychology", "自己的人生自己定義", "趙丰                 ", "184", "P005", "全品圖書  ", "9789866989599", "2008-02-25", "180 ", " Y", "        Y"},
            {"thriller  ", "半自白            ", "橫山秀夫(王蘊潔譯)   ", "336", "T001", "春天出版社", "9789577414700", "2021-10-27", "380 ", " Y", "        N"},
            {"thriller  ", "狼煙未盡          ", "蔡榮恩               ", "253", "T002", "墨言文化  ", "9789860665123", "2021-11-01", "280 ", " Y", "        N"},
            {"thriller  ", "請把門鎖好        ", "萊利·塞傑 (林零譯)   ", "384", "T003", "臉譜      ", "9786263150287", "2021-10-30", "400 ", " N", "        Y"},
            {"thriller  ", "有人在說謊        ", "瑪麗庫·碧卡(周倩如譯)", "368", "T004", "春天出版社", "9789577414663", "2021-10-27", "410 ", " Y", "        N"},
            {"thriller  ", "死人不會說話      ", "珍·哈珀(牛世峻譯)    ", "368", "T005", "春天出版社", "9789577414694", "2021-10-27", "420 ", " Y", "        Y"},
            {"medicine  ", "醫學統計          ", "林建甫               ", "1380","M001", "雙葉書廊  ", "9789865492186", "2021-09-17", "806 ", " N", "        N"},
            {"medicine  ", "雙眼視覺理論      ", "卓達雄               ", "325", "M002", "新文亰    ", "9789864307807", "2021-10-20", "440 ", " N", "        N"},
            {"medicine  ", "公共衛生新思維    ", "張耕維               ", "288", "M003", "商鼎      ", "9789861441986", "2021-06-15", "380 ", " Y", "        N"},
            {"medicine  ", "輸血醫學(5版)     ", "林媽利               ", "552", "M004", "五南      ", "9789865223762", "2021-03-10", "850 ", " N", "        N"},
            {"medicine  ", "基本護理學(下冊)  ", "蘇麗智               ", "533", "M005", "華杏      ", "9789861945880", "2021-04-12", "750 ", " Y", "        N"}
        };//宣告二維字串陣列----圖書資料，設計概念，書號第一碼用圖書分類開始

        System.out.println("歡迎進入圖書館借閱系統，本館一次最多可以借三本書(電子書不限)" + "\n歡迎借閱");
        for (int i = 0; i < 4; i++) {
            System.out.print(bookinfo[i] + "\t");
        }//輸出前4項資訊
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(books[i][j] + "\t");
            }
            System.out.println();
        }//輸出前4項資訊
        Scanner sc = new Scanner(System.in);//宣告掃描器函數(Scanner)，讀取使用者輸入的值
        int borrow2 = 0; 
        do {//使用do...while迴圈，一定要做第一次
            System.out.println("選擇想要查詢的圖書分類(輸入英文)" + "\n" + "literature(文學) psychology(心理) thriller(驚悚) medicine(醫學)");
            String bookcate = sc.nextLine();//選擇想要查詢的圖書分類
            String cate_id = "NA";//宣告分類代號變數，預設是一個不存在的代號

            for (int i = 0; i < category.length; i++) {//搜尋分類陣列
                if (bookcate.toLowerCase().equals(category[i].split("\\|")[1])) {//將圖書分類的元素拆開來，第0個元素是分類碼，第1個元素是分類中文
                    cate_id = category[i].split("\\|")[0];//比對到時，取出分類代碼，並跳出迴圈
                    System.out.println(bookcate + "類代號: " + cate_id);
                    break;
                }
            }
            for (int i = 1; i < 5; i++) {
                System.out.print(bookinfo[i] + "\t");
            }
            System.out.println();
            if (!cate_id.equals("NA")) {//如果有比對到圖書分類，列出該分類的圖書清單
                for (int i = 0; i < books.length; i++) {
                    //比對書號，保險起見把書號跟圖書代碼轉成大寫來比對
                    if (books[i][0].toUpperCase().startsWith(cate_id.toUpperCase())) {
                        for (int j = 1; j < 5; j++) {
                            System.out.print(books[i][j] + "\t");
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("輸入錯誤");
                System.exit(0);
            }

            System.out.println("輸入想借的書的書號");
            String borrow_id = sc.nextLine();//假設要借書，輸入書號
            String kate_id = "NA";//宣告分類代號變數，預設是一個不存在的代號
             if (!kate_id.equals("NA")) {
            System.out.println("輸入錯誤");
            System.exit(0);
             }
            for (int i = 0; i < books.length; i++) {
                if (borrow_id.toUpperCase().equals(books[i][4].toUpperCase())) {//比對書號
                    System.out.println("找到要借的書: ");
                    for (int k = 1; k < 8; k++) {
                        System.out.print(bookinfo[k] + "\t");
                    }
                    System.out.println("");
                    for (int j = 1; j < 8; j++) {
                        System.out.print(books[i][j] + "\t");
                    }
                    System.out.println();
                    System.out.println("是否要借這本書？(Y/N)");
                    String borrow = sc.nextLine();
                    if (borrow.equals("Y") || borrow.equals("y")) {
                        if (!books[i][10].equals("        N")) {
                            System.out.println("已放入借閱清單");
                            borrowList.add(books[i]);//將第i本書的資料存到清單
                            break;
                        } else {
                            System.out.println("抱歉，館內目前無此書,可以參考本館網頁借閱電子書");
                            System.out.println("是否要預約下次借閱(0-是/1-否)");
                            int borrow3 = 0;
                            borrow3 = sc.nextInt();
                            sc.nextLine();
                            if(borrow3 ==0){
                                System.out.println("已預約成功,請耐心等待待相關人員聯絡,即可借閱");
                                break; 
                                }
                            }           
                    } else if (borrow.equals("N") || borrow.equals("n")) {

                    } else {
                        System.out.println("無效輸入");
                    }
                }
            }
            if (borrowList.size() < 3) {//當串列數超過3時，停止迴圈
                System.out.println("是否還要借書？(0-是)/1(否))");
                borrow2 = sc.nextInt();
                sc.nextLine();               
            } else {
                System.out.println("你已經借三本書囉！");
                break;
            }
        } while (borrow2 == 0);//當borrow2 == 0時，執行do裡面的程式
        //列出借閱清單
        System.out.println("您的借閱清單，別忘了還書~~");
        for (int i = 0; i < bookinfo.length; i++) {
            System.out.print(bookinfo[i] + "\t");
        }//所有項目資訊
        System.out.println();
        for (int i = 0; i < borrowList.size(); i++) {//傳回 ArrayList 元素個數
            String[] book = (String[]) borrowList.get(i);//所有加入串列的陣列
            for (String item : book) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
    }
}
