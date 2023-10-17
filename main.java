/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PTT
 */
public class try3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String filepath = "data/";
        String filename = "menu.txt";
        File f = new File(filepath + filename);//建立圖書資料檔物件
        Scanner sc = new Scanner(f, "UTF-8");
        Scanner scm = new Scanner(System.in);
        String[] category = sc.nextLine().split(",");//讀取資料檔的第一列並轉成陣列
        String[] menuinfo = sc.nextLine().split(",");//讀取資料檔的第二列並轉成陣列
        List menuList = new ArrayList();//存放圖書資料的串列集合
        while (sc.hasNextLine()) {//循序讀取圖書資料
            String[] menu = sc.nextLine().split(",");//讀取每一列資料後立即拆成字串陣列(每一本書的資訊)
            menuList.add(menu);//置入每一本書的資料
        }
        String[][] menus = new String[menuList.size()][menuinfo.length];//宣告圖書陣列, 書本數為bookList收集完檔案資料後的數目, 圖書欄位則是第二列讀到的bookinfo大小
        for (int i = 0; i < menus.length; i++) {
            String[] menu = (String[]) menuList.get(i);
            menus[i] = menu;//這兩句可以寫在一起, 即取出List內的元素(每個均為一維陣列)便賦予資料給books[i](即第i本書)
        }
        System.out.println("=================歡迎光臨麥當勞點餐系統================");
        System.out.println("\t");
        System.out.println("早餐供應時間為AM 6:00-10:30  其餘品項則於AM10:30後供應");
        System.out.println("甜心卡請先選擇A區" + "\n" + "1+1請先選擇紅區");
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        System.out.println("目前時間為: " + ft.format(dNow));
        System.out.println("\t");
        for (int i = 0; i < menuinfo.length; i++) {
            System.out.print(menuinfo[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < menus.length; i++) {
            for (int j = 0; j < menus[i].length; j++) {
                System.out.print(menus[i][j] + "\t");
            }
            System.out.println();
        }
        double[] price = new double[menus.length];//取出書價存成數字陣列
        for (int i = 0; i < menus.length; i++) {
            price[i] = Double.parseDouble(menus[i][3]);//將書價字串轉成數字存進陣列
        }

        String id = "";
        List stress = new ArrayList();//最後的單子
        boolean check = true;
        do {
            //副程式1-選擇欲索引類別(輸入阿拉伯數字代號)
            String cate = getmenu(category, scm, menus);
            System.out.println("輸入想點的餐點編號");
            String order_id = scm.nextLine();
            SimpleDateFormat time = new SimpleDateFormat("Hmmss");
            Date tNow = new Date();
            String time_s = time.format(tNow);
            long time_n = Long.parseLong(time_s);
            if (order_id.toUpperCase().startsWith("B")) {//早餐
                if (time_n > 103000 || time_n < 60000) {//非早餐
                    System.out.println("現在是非早餐時段喔!");
                    System.out.println("是否繼續使用系統(Y/N)");
                    if (scm.nextLine().toUpperCase().startsWith("N")) {
                        System.exit(0);
                    } else {
                        continue;
                    }
                }
            } else if (order_id.toUpperCase().startsWith("SB")) {//甜心卡B區
                System.out.println("甜心卡需先點A區，再選B區餐點");
                continue;
            } else if (order_id.toUpperCase().startsWith("SA")) {//甜心卡A區
                System.out.println("請選擇想送的B區餐點");
                System.out.print("SB-甜心卡B區  " + "\n");
                for (int i = 0; i < menus.length; i++) {
                    if (menus[i][0].startsWith("SB")) {
                        id = id + menus[i][0] + ",";
                        for (int j = 0; j < menus[i].length; j++) {
                            System.out.print(menus[i][j] + "\t");
                        }
                        System.out.println();
                    }
                }
                System.out.println("輸入想要的B區號碼");
                String order_idb = scm.nextLine();
                for (int i = 0; i < menus.length; i++) {
                    if (menus[i][0].equals(order_idb.toUpperCase())) {
                    }
                }
            } else if (order_id.toUpperCase().startsWith("PW")) {//1+1白區
                System.out.println("1+1請先選擇紅區");
                continue;
            } else if (order_id.toUpperCase().startsWith("PR")) {//1+1紅區
                System.out.println("請選擇想送的白區餐點");
                System.out.print("1+1-白區  " + "\n");
                for (int i = 0; i < menus.length; i++) {
                    if (menus[i][0].startsWith("PW")) {
                        id = id + menus[i][0] + ",";
                        for (int j = 0; j < menus[i].length; j++) {
                            System.out.print(menus[i][j] + "\t");
                        }
                        System.out.println();
                    }
                }
                System.out.println("輸入想要的白區號碼");
                String order_idb = scm.nextLine();
                for (int i = 0; i < menus.length; i++) {
                    if (menus[i][0].equals(order_idb.toUpperCase())) {
                    }
                }
            }
            System.out.println("請問是否確定點餐(Y/N)");//還沒做完
            if (scm.nextLine().toUpperCase().startsWith("Y")) {
                System.out.println("請問要幾份?");
                double x = scm.nextDouble();
                for (int i = 0; i < menus.length; i++) {
                    if (menus[i][0].startsWith(order_id.toUpperCase())) {//比對書號的前置碼, 是選擇的分類(ex: A)則輸出, 否則跳過
                        String[] menu = menus[i];//取出第 i 本書
                        stress.add(menu);
                        stress.add(x);
                        break;
                    }
                }

            }
            System.out.println("請問是否繼續點餐(Y/N)");
            if (scm.next().toUpperCase().startsWith("Y")) {
                check = true;
            } else {
                check = false;
            }

        } while (check);
        FileWriter fw = new FileWriter("Orderlist.txt");
        fw.close();//封存寫入檔案, 才可以被讀取

        double total = getprint(stress);
        double l = getcal(stress);

        System.out.println("餐點總金額為: " + total + "元");
        System.out.println("餐點總卡路里為: " + l + "卡路里");
        if (l >= 650) {
            System.out.println("請注意您今天卡路里的攝取量喔!!");
        }
        System.out.println("請問以上餐點是否正確(正確0/錯誤1)");
        String correct = scm.next();
        if (correct.equals("1")) {
            System.out.println("請重新點餐");
            System.exit(0);
        }
        System.out.println("請選擇用餐方式(內用0/外帶1)");
        String way = scm.next();
        if (way.equals("0")) {
//                int t = (int) (Math.random() * 100);//產生隨機的2位數驗證碼
            System.out.println("請等叫號取餐" + "您的取餐號碼為:" + (int) (Math.random() * 100) + " \n期間請先找位置");

        } else if (way.equals("1")) {
            System.out.println("是否要加購袋子(一個2元)(是0/否1)");
            String bag = scm.next();
            if (bag.equals("0")) {
                System.out.println("請輸入數量");
                String amount = scm.next();
                total = total + Double.parseDouble(amount) * 2.0;
                System.out.println("總金額為: " + total + "元");
            } else if (way.equals("1")) {
                int t = (int) (Math.random() * 1000);//產生隨機的3位數驗證碼
                System.out.println("請等叫號取餐" + "您的取餐號碼為:" + (int) (Math.random() * 100));
            } else {
                System.out.println("想在哪吃飯==");
            }
        } else {

        }
        System.out.println("\n");
        System.out.println("請選擇付款方式(刷卡0/現金1)");
        String cash = scm.next();
        if (cash.equals("0")) {
            System.out.println("請感應卡片");
            System.out.println("謝謝您的光臨");
        } else if (cash.equals("1")) {
            System.out.println("請至櫃台付款 謝謝您的光臨");
        } else {
            System.out.println("還想捲款逃跑啊!");
        }
        System.out.println("按enter結束程式");
        scm.nextLine();
        scm.nextLine();
    }

    //副程式1
    public static String getmenu(String[] category, Scanner scm, String[][] menus) {
        for (int i = 0; i < category.length; i++) {
            System.out.println("[" + (i + 1) + "]" + category[i].split("\\|")[1]);
        }
        System.out.println("選擇欲索引類別(輸入阿拉伯數字代號)");
        int index = scm.nextInt();//輸入代號
        scm.nextLine();//讀取緩衝字元(Enter鍵), 以利後續的文字輸入
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
            for (int i = 0; i < menus.length; i++) {
                if (menus[i][0].startsWith(cate_id)) {//比對書號的前置碼, 是選擇的分類(ex: A)則輸出, 否則跳過
                    String[] menu = menus[i];//取出第 i 本書
                    for (String b : menu) {
                        System.out.print(b);
                    }
                    System.out.print("\n");
                }
            }
        } else {
            System.out.println("無此品項");
        }//點餐流程, 以輸入餐點編號為例
        return cate;
    }

    //副程式2
    public static double getprint(List stress) {
        System.out.println("____________________您的訂單如下___________________");
        double total = 0;//計算餐點總價        
        for (int i = 0; i < stress.size(); i = i + 2) {
            String[] menu = (String[]) stress.get(i);
            double x = (double) stress.get(i + 1);
            double total_price = Double.parseDouble(menu[3]) * x;
            double total_cal = Double.parseDouble(menu[4]) * x;
            for (int j = 0; j < 2; j++) {
                System.out.print(menu[j] + "\t");
                System.out.print(total_price + "\t");
                System.out.print(total_cal);
            }
            System.out.print("\n");
            total = total + total_price;

        }//所有項目資訊
        System.out.println();
        return total;

    }

    public static double getcal(List stress) {
        double cal = 0;
        for (int i = 0; i < stress.size(); i = i + 2) {
            String[] menu = (String[]) stress.get(i);
            double x = (double) stress.get(i + 1);
            double total_calory = Double.parseDouble(menu[4]) * x;
            cal = cal + total_calory;
        }

        return cal;
    }
}
