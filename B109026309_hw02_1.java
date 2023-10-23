/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PTT
 */
public class B109026309_hw02_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //作業1
        System.out.print("110學年行事曆" + "\n\n");//輸出引號內文字
        System.out.print("110年8月" + "\n");//輸出引號內文字

        String weekdays = "Sun\tMon\tTue\tWed\tThu\tFri\tSat";//設定字串，星期欄
        String monthday = "313031303131283130313031";//依序是 110年 8,9,10,11,12 111年1,2,3,4,5,6,7 月的日數(字串中的偶數位置起 2 個字元)
        System.out.print(weekdays);//輸出星期
        System.out.print("\n");//換行

        for (int md = 0; md <= 22; md = md + 2) {//md=0跑到md=22(因為共12個月)，且每次加2，亦即每個月分
            int d = Integer.parseInt(monthday.substring(md, md + 2));//擷取monthday的第md個字到第md + 2個字前(取月份)

            for (int i = 1; i <= d; i++) {//i=1~d

                //8月
                if (md == 0 & i == 1) {//8月1號
                    System.out.print("休" + "\t");//輸出"休"(8月1號為星期日)
                } else if (md == 0 & i <= 6) {
                    System.out.print(i + "\t");
                } else if (md == 0 & i % 7 == 0 || md == 0 & i % 7 == 1) {
                    System.out.print("休\t");//日期除7餘0或餘1輸出"休"(六和日)
                } else if (md == 0) {
                    System.out.print(i + "\t");//輸出剩下的日期
                }
                if (md == 0 & i % 7 == 0) {
                    System.out.print("\n");//日期除7餘0換行(一星期)
                }

                //9月
                if (md == 2 & i == 1) {//9月1號
                    System.out.print("\t\t\t" + i + "\t");//空3格後輸出"1"(9月1號為星期三)
                } else if (md == 2 & i <= 3) {//9月2號跟3號
                    System.out.print(i + "\t");//輸出"2"&"3"
                } else if (md == 2 & i <= 5) {//9月4號跟5號
                    System.out.print("休" + "\t");//輸出"休"
                } else if (md == 2 & i == 11) {
                    System.out.print("補班" + "\t");//9月11號輸出"補班"
                } else if (md == 2 & i == 13) {//9月13號
                    System.out.print("開學(A)" + "\t");//輸出"開學" 
                } else if (md == 2 & i == 20) {//9月20號
                    System.out.print("補假" + "\t");//輸出"補假"(9月20號為星期一)
                } else if (md == 2 & i == 21) {//9月21號
                    System.out.print("中秋節" + "\t");//輸出"中秋"(9月21號為星期二)
                } else if (md == 2 & i == 27) {//9月27號
                    System.out.print("27(B)" + "\t");//輸出"27(B)"
                } else if (md == 2 & i % 7 == 4 || md == 2 & i % 7 == 5) {
                    System.out.print("休\t");//日期除7餘4或餘5輸出"休"(六和日)
                } else if (md == 2) {
                    System.out.print(i + "\t");//輸出剩下的日期
                }
                if (md == 2 & i % 7 == 4) {
                    System.out.print("\n");//日期除7餘4換行(一星期)
                }

                //10月
                if (md == 4 & i == 1) {//10月1號
                    System.out.print("\t\t\t\t\t" + i + "\t");//空5格後輸出"1"(10月1號為星期五)
                } else if (md == 4 & i <= 3) {
                    System.out.print("休" + "\t");//輸出"休"                
                } else if (md == 4 & i == 10) {//10月10號
                    System.out.print("國慶" + "\t");//輸出"國慶"
                } else if (md == 4 & i == 11) {//10月11號
                    System.out.print("補假" + "\t");//輸出"補假"
                } else if (md == 4 & i % 7 == 2 || md == 4 & i % 7 == 3) {
                    System.out.print("休" + "\t");//日期除7餘2或餘3輸出"休"(六和日)
                } else if (md == 4) {
                    System.out.print(i + "\t");//輸出剩下的日期
                }
                if (md == 4 & i % 7 == 2) {
                    System.out.print("\n");//日期除7餘2換行(一星期)
                }

                //11月
                if (md == 6 & i == 1) {//11月1號
                    System.out.print("\t" + i + "\t");//空1格後輸出11/1
                } else if (md == 6 && i <= 5) {//(11/1為星期一)
                    System.out.print(i + "\t");//空1格後輸出11/2~5
                } else if (md == 6 & i <= 7) {//11月6號跟7號輸出"休"
                    System.out.print("休" + "\t");
                } else if (md == 6 & i <= 12) {//11月8號~12號
                    System.out.print("期中考" + "\t");//輸出"期中考"
                } else if (md == 6 & i == 22) {//11月22號
                    System.out.print("22(C)" + "\t");//輸出"22(C)"
                } else if (md == 6 & i == 29) {//11月29號
                    System.out.print("29(E)" + "\t");//輸出"29(E)"
                } else if (md == 6 & i % 7 == 6 || md == 6 & i % 7 == 0) {
                    System.out.print("休\t");//日期除7餘6或餘0輸出"休"(六和日)               
                } else if (md == 6) {
                    System.out.print(i + "\t");//輸出剩下的日期
                }
                if (md == 6 & i % 7 == 6) {
                    System.out.print("\n");//日期除7餘6換行(一星期)
                }

                //12月
                if (md == 8 & i == 1) {//12月1號為星期三
                    System.out.print("\t\t\t" + i + "\t");//空3格後輸出12/1
                } else if (md == 8 && i <= 3) {//輸出12/2~3
                    System.out.print(i + "\t");
                } else if (md == 8 && i <= 5) {//12月4號跟5號輸出"休"
                    System.out.print("休\t");
                } else if (md == 8 & i % 7 == 4 || md == 8 & i % 7 == 5) {
                    System.out.print("休\t");//日期除7餘4或餘5輸出"休"(六和日)    
                } else if (md == 8 && i == 10) {
                    System.out.print("10(D/F)" + "\t");//輸出10(D/F)
                } else if (md == 8 && i == 20) {
                    System.out.print("20(G)" + "\t");//輸出20(G)
                } else if (md == 8 && i == 30) {
                    System.out.print("30(H)");//輸出30(H)
                } else if (md == 8 & i == 31) {//12月31號
                    System.out.print("\t" + "補假" + "\t");//輸出"補假"(12月31號為星期一)
                } else if (md == 8) {
                    System.out.print(i + "\t");//輸出剩下的日期
                }
                if (md == 8 & i % 7 == 4) {
                    System.out.print("\n");//日期除7餘4換行(一星期)
                }

                //1月
                if (md == 10 & i == 1) {//1月1號
                    System.out.print("\t\t\t\t\t\t" + "元旦" + "\t");//空5格後輸出"元旦"(1月1號為星期六)
                } else if (md == 10 & i % 7 == 1 || md == 10 & i % 7 == 2) {
                    System.out.print("休\t");//日期除7餘1或餘2輸出"休"(六和日)                                      
                } else if (md == 10 & i <= 14 & i >= 10) {//1月10號~14號
                    System.out.print("期末考" + "\t");//輸出"期末考"                            
                } else if (md == 10 & i == 31) {//1月31號
                    System.out.print("結業" + "\n" + "\t" + "春假");//輸出"結業"                
                } else if (md == 10) {
                    System.out.print(i + "\t");//輸出剩下的日期
                }
                if (md == 10 & i % 7 == 1) {
                    System.out.print("\n");//日期除7餘1換行(一星期)
                }

                //2月
                if (md == 12 & i == 1) {// 2/1為星期二
                    System.out.print("\t\t" + "春假");//空2格後輸出"春假"
                } else if (md == 12 & i <= 3) {// 2/2~2/3
                    System.out.print("\t" + "春假");//輸出"春假"    
                } else if (md == 12 & i == 4) {//2月4號
                    System.out.print("\t" + i + "\t");//輸出"2/4"
                } else if (md == 12 & i <= 6) {//2月5~6號
                    System.out.print("休" + "\t");//輸出"休"
                } else if (md == 12 & i == 21) {
                    System.out.print("開學(A)" + "\t");//輸出開學(A)
                } else if (md == 12 & i == 28) {
                    System.out.print("228(休)");//輸出228(休)
                } else if (md == 12 & i % 7 == 5 || md == 12 & i % 7 == 6) {
                    System.out.print("休" + "\t");//日期除7餘5或餘6輸出"休"(六和日)
                } else if (md == 12) {
                    System.out.print(i + "\t");//輸出剩下的日期
                }
                if (md == 12 & i % 7 == 5) {
                    System.out.print("\n");//日期除7餘5換行(一星期)
                }

                //3月
                if (md == 14 & i == 1) {//3月1號為星期二
                    System.out.print("\t\t" + i + "\t");//空2格後輸出"3/1"
                } else if (md == 14 & i <= 4) {// 3/2~3/4
                    System.out.print(i + "\t");
                } else if (md == 14 & i <= 6) {
                    System.out.print("休" + "\t"); //輸出"休"
                } else if (md == 14 & i == 7) {
                    System.out.print("7(B)" + "\t");
                } else if (md == 14 & i % 7 == 5 || md == 14 & i % 7 == 6) {
                    System.out.print("休" + "\t");//日期除7餘5或餘6輸出"休"(六和日)
                } else if (md == 14) {
                    System.out.print(i + "\t");//輸出剩下的日期
                }
                if (md == 14 & i % 7 == 5) {
                    System.out.print("\n");//日期除7餘5換行(一星期)
                }

                //4月
                if (md == 16 & i == 1) {//4月1號
                    System.out.print("\t\t\t\t\t" + i + "\t");//空5格後輸出"1"(4月1號為星期五)
                } else if (md == 16 & i <= 3) {//4月2號跟3號
                    System.out.print("休" + "\t");//輸出"休"
                } else if (md == 16 & i == 4) {//4月4號
                    System.out.print("兒童節" + "\t");//輸出"兒童節"
                } else if (md == 16 & i == 5) {//4月5號
                    System.out.print("清明節" + "\t");//輸出"清明節"
                } else if (md == 16 & i >= 18 & i <= 22) {//4月18號~22號
                    System.out.print("期中考" + "\t");//輸出"期中考"
                } else if (md == 16 & i % 7 == 2 || md == 16 & i % 7 == 3) {
                    System.out.print("休\t");//日期除7餘2或餘3輸出"休"(六和日)
                } else if (md == 16) {
                    System.out.print(i + "\t");//輸出剩下的日期
                }
                if (md == 16 & i % 7 == 2) {
                    System.out.print("\n");//日期除7餘2換行(一星期)
                }

                //5月
                if (md == 18 & i == 1) {//5月1號為星期日
                    System.out.print("休" + "\t");//輸出休
                } else if (md == 18 & i == 5) {
                    System.out.print("破蛋日" + "\t");//輸出破蛋日
                } else if (md == 18 & i <= 6) {
                    System.out.print(i + "\t");
                } else if (md == 18 & i == 9) {
                    System.out.print("9(E)" + "\t");//輸出9(E)
                } else if (md == 18 & i == 20) {
                    System.out.print("20(F)" + "\t"); //輸出20(F) 
                } else if (md == 18 & i == 23) {
                    System.out.print("23(D)" + "\t");//輸出23(D)
                } else if (md == 18 & i == 30) {
                    System.out.print("30(G)" + "\t");//輸出30(G)
                } else if (md == 18 & i % 7 == 0 || md == 18 & i % 7 == 1) {
                    System.out.print("休\t");//日期除7餘0或餘1輸出"休"(六和日)
                } else if (md == 18) {
                    System.out.print(i + "\t");//輸出剩下的日期
                }
                if (md == 18 & i % 7 == 0) {
                    System.out.print("\n");//日期除7餘0換行(一星期)
                }
                //6月
                if (md == 20 & i == 1) {//6月1號
                    System.out.print("\t\t\t" + i + "\t");//空3格後輸出"1"(6月1號為星期三)
                } else if (md == 20 & i == 2) {//6月2號
                    System.out.print(i + "\t");
                } else if (md == 20 & i == 3) {//6月3號
                    System.out.print("端午節\t");//輸出"端午節"    
                } else if (md == 20 & i <= 5) {//6月4~5號
                    System.out.print("休" + "\t");//輸出"休"
                } else if (md == 20 & i == 10) {//6月10號
                    System.out.print("10(D/H)" + "\t");//輸出"休"
                } else if (md == 20 & i == 12) {//6月12號
                    System.out.print("畢典\t");//輸出"畢典"
                } else if (md == 20 & i >= 20 & i <= 24) {//6月20號~24號
                    System.out.print("期末考" + "\t");//輸出"期末考"                
                } else if (md == 20 & i % 7 == 4 || md == 20 & i % 7 == 5) {
                    System.out.print("休\t");//日期除7餘4或餘5輸出"休"(六和日) 
                } else if (md == 20) {
                    System.out.print(i + "\t");//輸出剩下的日期
                }
                if (md == 20 & i % 7 == 4) {
                    System.out.print("\n");//日期除7餘4換行(一星期)
                }

                //7月
                if (md == 22 & i == 1) {//7月1號
                    System.out.print("\t\t\t\t\t" + i + "\t");//空5格後輸出"1"(7月1號為星期五)
                } else if (md == 22 & i <= 3) {// 7/2~3
                    System.out.print("休" + "\t");//輸出"休" 
                } else if (md == 22 & i == 31) {
                    System.out.print("31" + "\n大二結束了!");//輸出31 換行 輸出大二結束了!
                } else if (md == 22 & i % 7 == 2 || md == 22 & i % 7 == 3) {
                    System.out.print("休\t");//日期除7餘2或餘3輸出"休"(六和日)
                } else if (md == 22) {
                    System.out.print(i + "\t");//輸出剩下的日期
                }
                if (md == 22 & i % 7 == 2) {
                    System.out.print("\n");//日期除7餘2換行(一星期)
                }
            }

            switch (md) {//以md為變數
                case 0://md=0(8月日期輸出完)
                    System.out.print("\n\n");//空兩行
                    System.out.print("110年09月");//輸出"110年9月"
                    System.out.print("\n");//空一行
                    break;
                case 2://md=2(9月日期輸出完)
                    System.out.print("\n\n");//空兩行
                    System.out.print("110年10月");//輸出"110年10月"
                    System.out.print("\n");//空一行
                    break;
                case 4://md=4(10月日期輸出完)
                    System.out.print("\n\n");//空兩行
                    System.out.print("110年11月");//輸出"110年11月"
                    System.out.print("\n");//空一行
                    break;
                case 6://md=6(11月日期輸出完)
                    System.out.print("\n\n");//空兩行
                    System.out.print("110年12月");//輸出"110年12月"
                    System.out.print("\n");//空一行
                    break;
                case 8://md=8(12月日期輸出完)
                    System.out.print("\n\n");//空兩行
                    System.out.print("111年01月");//輸出"111年01月"
                    System.out.print("\n");//空一行
                    break;
                case 10://md=10(1月日期輸出完)
                    System.out.print("\n\n");//空兩行
                    System.out.print("111年02月");//輸出"111年02月"
                    System.out.print("\n");//空一行
                    break;
                case 12://md=12(2月日期輸出完)
                    System.out.print("\n\n");//空兩行
                    System.out.print("111年03月");//輸出"111年03月"
                    System.out.print("\n");//空一行
                    break;
                case 14://md=14(3月日期輸出完)
                    System.out.print("\n\n");//空兩行
                    System.out.print("111年04月");//輸出"111年04月"
                    System.out.print("\n");//空一行
                    break;
                case 16://md=16(4月日期輸出完)
                    System.out.print("\n\n");//空兩行
                    System.out.print("111年05月");//輸出"111年05月"
                    System.out.print("\n");//空一行
                    break;
                case 18://md=18(5月日期輸出完)
                    System.out.print("\n\n");//空兩行
                    System.out.print("111年06月");//輸出"111年06月"
                    System.out.print("\n");//空一行
                    break;
                case 20://md=20(6月日期輸出完)
                    System.out.print("\n\n");//空兩行
                    System.out.print("111年07月");//輸出"111年07月"
                    System.out.print("\n");//空一行
                    break;
                default:
                    break;
            }
            if (md < 22) {//md<小於22(12月前)
                System.out.print(weekdays);//輸出weekdays(日一二三四五六)
                System.out.print("\n");
            }//空一行 
        }
        System.out.println("\n");
        System.out.println("註解\n" + "A=加退選開始\n" + "B=加退選結束\n" + "C=停車位申請開始\n" + "D=停車位申請結束\n" + "E=停修申請開始\n" + "F=停修申請結束\n" + "G=雙主修申請開始\n" + "H=雙主修申請結束\n");
    }
}
