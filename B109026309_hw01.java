
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
public class B109026309_hw01_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          //判斷生日是否有誤,無誤則輸出平/閏年、生肖、星座
        Scanner sc = new Scanner(System.in);//宣告一個scanner物件,次此變數可以掃描從螢幕輸入的資料,存成變數
        System.out.println("請輸入你的西元生日(yyyymmdd)");//輸出括號內的文字
        String date = sc.nextLine();//宣告字串,掃描輸入生日
        String year = date.substring(0, 4);//西元年
        String month = date.substring(4, 6);//月
        String day = date.substring(6, 8);//日
        int yyyy = Integer.parseInt(year);//年(字串轉成整數)
        int mm = Integer.parseInt(month);//月(字串轉成整數)
        int dd = Integer.parseInt(day);//日(字串轉成整數)
        int mmdd = Integer.parseInt(date.substring(4));//取得後四碼並轉成整數
        if (date.length() == 8 && mm <= 12 && dd >= 1 && dd <= 31) {//基本條件
            System.out.println();//輸出結果
        } else {
            System.out.println("輸入錯誤");
        int Y = Integer.parseInt(date.substring(0,1));
            if(Y==0){//若是輸入民國則+1911
        yyyy = yyyy + 1911;//
    }
            System.exit(0);//不符合條件終止程式
        }
        switch (mm) {
            case 01:case 03:case 05:case 07:case 8:case 10:case 12://大月31天
                if(dd>=1&&dd<=31){
            System.out.println("生日正確");//輸出括號內文字
        }else{
                System.out.println("輸入錯誤");
                System.exit(0);}//不符合條件終止程式
                break;

   
             case 04:case 06:case09:case11://小月30天
             if (dd>=1&&dd<=30){
                 System.out.println("生日正確");//輸出括號內文字
             }else{
                 System.out.println("輸入錯誤");
                 System.exit(0);}//不符合條件終止程式
                 break;
                 
             case 02:
                 if(yyyy%4==0&&yyyy%100!=0 ||(yyyy%400==0)&&dd>=1&&dd<=29){//閏年2月是29天
                     System.out.println("生日正確(閏年)");//輸出括號內的文字
                 }else if(dd>=1&&dd<=28){////平年2月是28天
                      System.out.println("生日正確(平年)");//輸出括號內的文字
                 }else{
                     System.out.println("輸入錯誤");
                     System.exit(0);}//不符合條件終止程式
                 break;
        }          
        //驗證碼
        int code = (int)(Math.random()*100000);//隨機取一個五位數以內的數字
         System.out.println("您的驗證碼為: " + code); //輸出括號內文字
         int code_check = sc.nextInt();//讀取驗證碼
    if(code == code_check)//確認讀取的驗證碼與程式給的驗證碼相同
    {System.out.println("輸入正確");//輸出括號內文字
    }else {
        System.out.println("輸入錯誤");
        System.exit(0);}//錯誤則終止程式
    //判斷平年閏年
    if(yyyy % 4 == 0 && yyyy % 100 != 0 || yyyy % 400 == 0){//判斷該年為閏年還平年
        System.out.println("您的出生年份為閏年");//輸出括號內文字
           }else
        System.out.println("您的出生年份為平年");//輸出括號內文字 
    
    //數學函數
    double a = 0; 
    String xingzuo;
    switch(mm){//以月份做敘述
        case 1://1月
            if(dd >=1 && dd <=20){//摩羯座日期
            a = (double)(Math.round(Math.sqrt(dd+mm)*100));//開根號
            xingzuo="摩羯座";
            System.out.println("您的星座為:"+xingzuo);
            }           
            else if(dd>=21 && dd<=31){//水瓶座日期
            a = (double)(Math.abs(Math.round(Math.tan(mm+dd)*1000)));
            xingzuo="水瓶座";
            System.out.println("您的星座為:"+xingzuo);

            }
            break;
        case 2://二月
            if(dd >=1 && dd <=19){//水瓶座日期
                 a = (double)(Math.abs(Math.round(Math.tan(mm+dd)*1000)));
            xingzuo="水瓶座";
    System.out.println("您的星座為:"+xingzuo);
}
            else if(dd>=20 && dd<=29){//雙魚座日期
            a = (double)(Math.round(Math.sin(dd)*100));//三角函數
            xingzuo="雙魚座";
    System.out.println("您的星座為:"+xingzuo);
}
            break;
        case 3://三月
            if(dd >=1 && dd <=20){//雙魚座日期
            a = (double)(Math.round(Math.sin(dd)*100));//三角函數
            xingzuo="雙魚座";
    System.out.println("您的星座為:"+xingzuo);
}
            else if(dd>=21 && dd<=31){//牡羊座日期
            a = (double)(Math.pow(2.0,mm+50)+dd);//乘方
            xingzuo="牡羊座";
    System.out.println("您的星座為:"+xingzuo);
}
            break;
        case 4://四月
            if(dd >=1 && dd <=20){//牡羊座日期
              a = (double)(Math.pow(2.0,mm+50)+dd);//乘方
             xingzuo="牡羊座";
    System.out.println("您的星座為:"+xingzuo);}
            else if(dd>=21 && dd<=30){//金牛座日期
            a = (double)(Math.round(Math.sin(dd)*500));//三角函數
            xingzuo="金牛座";
    System.out.println( "您的星座為:"+xingzuo);
}
            break;
        case 5://五月
            if(dd >=1 && dd <=21){//金牛座日期
                a = (double)(Math.round(Math.sin(dd)*500));//三角函數
            xingzuo="金牛座";
    System.out.println( "您的星座為:"+xingzuo);
}

            else if(dd>=22 && dd<=31){//雙子座日期
               a = (double)(Math.round(Math.log10(dd)*1000)+Math.round(Math.log10(mm)*10));
            xingzuo="雙子座";
    System.out.println("您的星座為:"+xingzuo);
}
            break;
        case 6://六月
            if(dd>=1 && dd<=21){//雙子座日期
               a = (double)(Math.round(Math.log10(dd)*1000)+Math.round(Math.log10(mm)*10));
            xingzuo="雙子座";
    System.out.println("您的星座為:"+xingzuo);
}
            else if(dd>=22 && dd<=30){//巨蟹座日期
                a = (double)(Math.pow(3, mm)+(dd*8));
            xingzuo="巨蟹座";
    System.out.println("您的星座為:"+xingzuo);
}
            break;
        case 7://七月
            if(dd >=1 && dd <=23){//巨蟹座日期
                a = (double)(Math.pow(3, mm)+(dd*8));
            xingzuo="巨蟹座";
    System.out.println("您的星座為:"+xingzuo);
}
            else if(dd >= 24 && dd<=31){//獅子座日期
                a = (double)(Math.abs(Math.round(Math.cos(mm+dd)-1000)));
            xingzuo="獅子座";
    System.out.println("您的星座為:"+xingzuo);
}
                break;
        case 8://八月
            if(dd >=1 && dd <=23){//獅子座日期
                a = (double)(Math.cos(mm+dd)*1000);
            xingzuo="獅子座";
    System.out.println("您的星座為:"+xingzuo);
}
            else if(dd>=24 && dd<=31){//處女座日期
                 a = (double)(Math.cos(mm+dd)-1000);
            xingzuo="處女座";
    System.out.println("您的星座為:"+xingzuo);
}
            break;
        case 9://九月
            if(dd >=1 && dd <=23){//處女座日期
                a = (double)(Math.cos(mm+dd)-1000);
            xingzuo="處女座";
    System.out.println("您的星座為:"+xingzuo);
}
            else if(dd >=24 && dd <=30){//天秤座日期
                a = (double)(Math.round((yyyy+mmdd)/100));
            xingzuo="天秤座";
    System.out.println("您的星座為:"+xingzuo);
}
            break;
        case 10://十月
            if(dd >=1 && dd <=23){//天秤座日期
                a = (double)(Math.round((yyyy+mmdd)/100));
            xingzuo="天秤座";
    System.out.println("您的星座為:"+xingzuo);
}
            else if(dd >=24 && dd <=31){//天蠍座日期
                 a = (double)(Math.round(Math.log10(dd)*1000));//以10為底的對數
            xingzuo="天蠍座";
    System.out.println("您的星座為:"+xingzuo);
}
            break;       
        case 11://十一月
            if(dd >=1 && dd <=22){//天蠍座日期
                a = (double)(Math.round(Math.log10(dd)*1000));//以10為底的對數
            xingzuo="天蠍座";
    System.out.println("您的星座為:"+xingzuo);
}
             else if(dd>=23 && dd<=30){//射手座日期
                a = (double)(Math.round(Math.sin(mm)*50))+Math.round(Math.log10(mm)*10);
             xingzuo="射手座";
    System.out.println("您的星座為:"+xingzuo);
} 
            break;
        case 12://十二月
            if(dd >=1 && dd <=22){//射手座日期
                a = (double)(Math.round(Math.sin(mm)*50))+Math.round(Math.log10(mm)*10);
            xingzuo="射手座";
    System.out.println("您的星座為:"+xingzuo);
}
            else if(dd>=23 && dd<=31){//魔羯座日期
               a = (double)(Math.round(Math.sqrt(dd+mm)*100));//開根號
            xingzuo="魔羯座";
    System.out.println("您的星座為:"+xingzuo);
}
            break;
        default:
                a = 0;//讓迴圈完整，此處不可能達到 
    }      
    int base_year = 2002;//馬年
    int zodiac_id = (yyyy-base_year)%12;//以2002年(馬)為基礎年去推敲生肖
    String zodiac;//宣告字串
    if(zodiac_id<0){
        zodiac_id = zodiac_id + 12;//若為負數的話要加上12矯正
    }
        switch (zodiac_id) {
            case 0:
                zodiac = "馬";//餘數為0，屬馬
                break;
            case 1:
                zodiac = "羊";//餘數為1，屬羊
                break;
            case 2:
                zodiac = "猴";//餘數為2，屬猴
                break;
            case 3:
                zodiac = "雞";//餘數為3，屬雞
                break;
            case 4:
                zodiac = "狗";//餘數為4，屬狗
                break;
            case 5:
                zodiac = "豬";//餘數為5，屬豬
                break;
            case 6:
                zodiac = "鼠";//餘數為6，屬鼠
                break;
            case 7:
                zodiac = "牛";//餘數為7，屬牛
                break;
            case 8:
                zodiac = "虎";//餘數為8，屬虎
                break;
            case 9:
                zodiac = "兔";//餘數為9，屬兔
                break;
            case 10:
                zodiac = "龍";//餘數為10，屬龍
                break;
            case 11:
                zodiac = "蛇";//餘數為11，屬蛇
                break;
            default:
                zodiac = "四不像";//讓迴圈完整，此處不可能達到            
        }
    System.out.println("您的生肖為: " + zodiac );//輸出括號內文字
    
     //ID
    int e = Integer.parseInt(date.substring(1, 4));//宣告一個整數，此整數為取西元8碼中的1~4碼
    int f = e + 87;//宣告一個整數
    int g = mm+13;
    int h = yyyy+mm+dd;
    String ID = "" + ((char)(int)f) + String.valueOf(h) +String.valueOf(g)+ String.valueOf(a).substring(0,3);//設計ID碼,((char)(int)f)為數字轉英文， String.valueOf(a)為把a轉為字串
    System.out.println("您的ID為: " + ID);//輸出括號內文字
    System.out.println("請輸入ID");//輸出括號內文字
    sc.nextLine();//緩衝字元
    String ID_check = sc.nextLine();//讀取ID
    if(!ID_check.equals("")){//如果不是輸入空字串可進行以下比較
        if(ID_check.toLowerCase().equals(ID.toLowerCase())||
                ID_check.toUpperCase().equals(ID.toUpperCase())){
    System.out.println("輸入正確");//輸出括號內文字
        }else{
        System.out.println("輸入錯誤");
        System.exit(0);}//錯誤則終止程式
        //
        System.out.println("請輸入身分證字號(大小寫不拘)");
        String id = sc.nextLine();//螢幕端使用者輸入自己的身分證字號
        System.out.println("你輸入的身分證字號為:" + id);
        String id_num = id.substring(1);//挑出身分證字號數字的部分
        int num = Integer.parseInt(id_num);//Integer.parseInt:整數數字字串換成整數 //資料轉換(適用數字)
        int sex_num = num / 100000000;
        String sex_id = id.substring(1, 2);
        char sex_no = id.charAt(1);
        char city_id = id.charAt(0);
        if (id.length() == 10) {//判斷長度是否正確
            System.out.println("您輸入的身分證字號長度正確");
        }
        if (id.length() != 10) {
            System.out.println("身分證字號輸入錯誤:");

        }
        if (sex_id.equals("1")) {
            System.out.println("您的性別為男性");
        }
        if (sex_id.equals("2")) {
            System.out.println("您的性別是女性");
        }
        
        if (id.length() == 10 && sex_no == '1') {
            System.out.println("身分證字號共10碼，且性別為生理男性");

        }
       
        if (id.length() == 10 && sex_no == '2') {
            System.out.println("身分證字號共10碼，且性別為生理女性");

        }
        String city ;
        String town;
        if(city_id == 'A' || city_id == 'a') {
            city = "台北市";
            
        } else if (city_id == 'F' || city_id == 'f') {                        
            city = "新北市";
            
        } else if (city_id == 'H' || city_id == 'h') {
            city = "桃園縣";
            
        } else if (city_id == 'B' || city_id == 'b') {
            city = "台中市";
            
        } else if (city_id == 'D' || city_id == 'd') {
            city = "台南市";
            
        } else if (city_id == 'E' || city_id == 'e') {
            city = "高雄市";
            
        } else {
            city = "您的出生地不是六都,詳情請請教google大神";
        }
        System.out.println("您的出生地:"+city);
         String s = id.substring(1);
        int i = Integer.parseInt(s); 
        int x = i*2;//整數相乘取餘數
        int y = (i+x+6)+(int)i;//整數相加
        int z = i*8^2;//整數相乘
        System.out.println("Java大神告訴我,您身分證代碼為:" +(i + x + y + z + Math.round(z)) ); 
}
    //健康資訊評估流程(心肌梗塞)
    System.out.println("輸入近期內是否胸悶,以診斷是否患有心肌梗塞,有,請輸入yes,沒有請輸入no");//輸出括號內文字
    String answer=sc.next();
    if(answer.equals("yes")){
        System.out.println("請輸入CKMB值(ng/mL)");
        double CKMB=sc.nextDouble();
    if(CKMB>0.6&&CKMB<6.3){
            System.out.println("數值正常,不排除是其他相關疾病,請洽詢門診");
    }else{
            System.out.println("數值不正常,很可能是心肌梗塞,為了您的健康,請盡速洽詢門診");
            System.exit(0);}

            System.out.println("請輸入LDH(U/L)值");
            double LDH=sc.nextDouble();
        if(LDH<229&&LDH>119){  
            System.out.println("數值正常,不排除是其他相關疾病,請洽詢門診");            
        } else{
            System.out.println("數值不正常,很可能是心肌梗塞,為了您的健康,請盡速洽詢門診");
            System.exit(0);
        }
            System.out.println("請輸入MB值(ng/mL)");
        double MB=sc.nextDouble();
        if(MB>0&&MB<=0.0175){
            System.out.println("數值正常,不排除是其他相關疾病,請洽詢門診");
        }else{
            System.out.println("數值不正常,不排除是其他疾病,請洽詢門診");
            System.exit(0);}       
            System.out.println("請輸入性別,男為0,女為1");
            int answer1=sc.nextInt();
       if (answer1==0){ 
           System.out.println("請輸入Myoglobin值(ng/mL)");
           double Myoglobin=sc.nextDouble();
           if(Myoglobin>16.3&&Myoglobin<96.5){
            System.out.println("您的心肌梗塞相關數值一切正常,胸悶現象可能是其他原因所致,請洽詢門診以利進一步檢查");
            System.exit(0);
           }else {
            System.out.println("數值不正常,很可能是心肌梗塞,為了您的健康,請盡速洽詢門診");
            System.exit(0);
       }
    }else if(answer1==1){
           System.out.println("請輸入Myoglobin值(ng/mL)");
           double Myoglobin=sc.nextDouble();
           if(Myoglobin>9&&Myoglobin<82.5){
            System.out.println("您的心肌梗塞相關數值一切正常,胸悶現象可能是其他原因所致,請洽詢門診以利進一步檢查");
            System.exit(0);
           }else{ System.out.println("數值不正常,很可能是心肌梗塞,為了您的健康,請盡速洽詢門診");
            System.exit(0);}
       }else {
             System.out.println("輸入錯誤");
             System.exit(0);}
  }
    }
}   