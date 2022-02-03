package gxun.edu.ShopCarDemo;

import java.util.Scanner;

public class ShopCar {
    public static void main(String[] args) {

       /*
         //1.定义商品类
        //2.创建菜单
        */
        Goods[] shopCar = new Goods[2];  //创建购物车，用数组来存放商品。

        while (true) {
            System.out.println("====================================================");
            System.out.println("请输入您的操作");
            System.out.println("添加商品：add");
            System.out.println("查询购物车里的商品：query");
            System.out.println("修改购买的商品数量：update");
            System.out.println("结算购物车：pay");
            System.out.println("====================================================");
            Scanner sc = new Scanner(System.in);
            String command = sc.next();

            switch (command) {
                case "add":
                    addGoods(shopCar,sc);
                    break;
                case "query":
                    queryGoods(shopCar);
                    break;
                case "update":
                    updateGoods(shopCar,sc);
                    break;
                case "pay":
                    pay(shopCar);
                    break;
                default:
                    System.out.println("您输入的指令不正确！");

            }
        }
    }
//查询商品id
    public static boolean getGoodsId(Goods[] shopCar, int id){
        boolean x = false;
        for (int i = 0; i < shopCar.length; i++) {
            if (shopCar[i]!=null) {
                if (id == shopCar[i].id) {
                    x = true;
                    break;
                } else {
                    System.out.println("抱歉，您输入的id有误");
                    x = false;
                    break;
                }
            }else {
                System.out.println("抱歉，您的购物车没有东西");
                x = false;
                break;
            }
        }
       return x;
    }
//添加商品
    public static void addGoods(Goods[] shopCar, Scanner sc){
        System.out.println("请输入商品id");
        int id = sc.nextInt();

        System.out.println("请输入商品名称");
        String name = sc.next();

        System.out.println("请输入商品价格");
        double price = sc.nextInt();

        System.out.println("请输入商品数量");
        int num = sc.nextInt();

        //新建一个商品类来存商品详情
        Goods g = new Goods();
        g.id=id;
        g.name= name;
        g.price = price;
        g.num = num;
        for (int i = 0; i < shopCar.length ; i++) {
            if(shopCar[i]==null){
                shopCar[i]=g;
                System.out.println("您已添加购物车！");
                break;
            }
        }
    }
    public static void queryGoods(Goods[] shopCar){
        System.out.println("===============查询的商品信息如下======================");
        //int id = sc.nextInt();
        System.out.println("id"+"\t\t"+"name"+"\t\t\t\t"+"price"+"\t\t\t\t"+"num");
        for (int i = 0; i < shopCar.length; i++) {
            Goods g;
            g=shopCar[i];

            if(g!=null){
                System.out.println(g.id+"\t\t"+g.name+"\t\t\t\t"+g.price+"\t\t\t\t"+g.num);
               continue;
            }else {
                System.out.println("抱歉，您还没有添加商品到购物车");
                break;
            }
        }
    }
    public static void updateGoods(Goods[] shopCar, Scanner sc){
        System.out.println("请输入您要查询的商品id:");
        int id = sc.nextInt();
        boolean isTrue =getGoodsId(shopCar,id);
    while(isTrue){
        for (int i = 0; i < shopCar.length; i++) {
            System.out.println("请输入您要修改的数量:");
            int num = sc.nextInt();
            shopCar[i].num = num;
            System.out.println("修改成功");
            System.out.println("==================修改后的数据为===============");
            System.out.println("id"+"\t\t"+"name"+"\t\t\t\t"+"price"+"\t\t\t\t"+"num");
            System.out.println(shopCar[i].id+"\t\t"+shopCar[i].name+"\t\t\t\t"+shopCar[i].price+"\t\t\t\t"+shopCar[i].num);
            break;
        }
    break;
    }

/*
//question1：为什么不可以跨数组元素取成员的属性
        for (int i = 0; i < shopCar.length; i++) {
            if(id == shopCar[i].id) {  //------------错点-----------
                System.out.println("请输入您要修改的数量:");
                int num = sc.nextInt();
                shopCar[i].num = num;
                System.out.println("修改成功");
                System.out.println("==================修改后的数据为===============");
                System.out.println("id" + "\t\t" + "name" + "\t\t\t\t" + "price" + "\t\t\t\t" + "num");
                System.out.println(shopCar[i].id + "\t\t" + shopCar[i].name + "\t\t\t\t" + shopCar[i].price + "\t\t\t\t" + shopCar[i].num);
            }
        }
*/

    }
    public static void pay(Goods[] shopCar){
        double sum = 0;
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if(g!=null)
                sum += (g.num*g.price);
        }

       /* for (int i = 0; i < shopCar.length; i++) {
            sum += shopCar[i].num*shopCar[i].price; //question2:相同错误？
        }*/
        System.out.println("您的商品总额为："+sum);

    }

}
