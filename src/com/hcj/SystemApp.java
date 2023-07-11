package com.hcj;

import java.util.Random;
import java.util.Scanner;

/**
 * SystemApp
 *
 * @author hcj
 * @date 2023-07-11
 */
public class SystemApp {
    private Scanner sc;
    // 创建账户类对象
    private Account ac;

    /**
     * 初始化对象的功能
    */
    public void init(){
        sc = new Scanner(System.in);
        ac = new Account();
    }

    public SystemApp() {
        init();
    }

    public static void main(String[] args) {
        SystemApp sa = new SystemApp();
        // 启动开始菜单
        sa.startMenu();
    }
    public  void startMenu(){
        System.out.println("----- ---------欢迎来到xxx管理系统-----------");
        System.out.println("1.注册");
        System.out.println("2.登陆");
        System.out.println("3.修改密码");
        System.out.println("4.退出");
        System.out.println("请选择：");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                // 1.注册
                registe();
                break;
            case 2:
                // 2.登陆
                login();
                break;
            case 3:
                // 3.修改密码
                updatePassword();
                break;
            case 4:
                // 4.退出
                System.out.println("欢迎下次使用！");
                System.exit(0);
                break;
            default:
                System.out.println("你输入的数字不对，请输入1-4的数字");
        }
    }

    /**
     * 注册功能
    */
    public  void registe(){
        System.out.println("----------注册页面----------");
        System.out.println("请输入用户名:");
        String username = sc.next();
        // 调用验证用户名的方法
        if(verifyUsername(username)){
            System.out.println(username+"这个用户名已存在，请重新输入");
            registe();
        }else{
            // 说明输入的用户名不存在，就存入账户对象中
            ac.setUsername(username);
            System.out.println("请输入密码:");
            String password = sc.next();
            ac.setPassword(password);
            // 调用生成的验证码
            String code = code();
            System.out.println("生成的验证码："+code);
            boolean flag = false;
            while(!flag){
                System.out.println("请输入验证码:");
                String myCode = sc.next();
                if(code.equals(myCode)){
                    System.out.println("注册成功！");
                    flag = true;
                    // 调用开始菜单
                    startMenu();
                }else{
                    System.out.println("你输入的验证码错误，请重新输入！");
                }
            }
        }
    }
    /**
     * 登录功能
     */
    public void login(){
        System.out.println("----------登录页面----------");
        System.out.println("请输入用户名:");
        String username = sc.next();
        // 验证用户名是否存在，不存在就业先去注册
        if(verifyUsername(username)){
            // 定义一个标记(开关思想)
            boolean flag = false;
            while(!flag){
                // 说明此用户存在，存在后才能继续输入对应的密码
                System.out.println("请输入密码:");
                String password = sc.next();
                if(password.equals(ac.getPassword())){
                    flag = true; // 密码验证正确就做个标记(说明教室有人，就开灯)
                    System.out.println("登录成功！");
                    // 调用主菜单
                    mainMenu();
                }else{
                    System.out.println("你输入的密码错误，请重新输入！");
                }
            }
        }else{
            System.out.println("你输入的"+username+"还不存在，请选去注册！");
            startMenu();
        }
    }
    /**
     * 修改密码功能
     */
    public void updatePassword(){
        System.out.println("----------修改密码页面----------");
        boolean flag = false;
        while(!flag){
            System.out.println("请输入旧密码：");
            String oldPassword = sc.next();
            if(ac.getPassword().equals(oldPassword)){
                System.out.println("旧密码正确！请输入要修改的新密码：");
                String newPassword = sc.next();
                System.out.println("请确认输入要修改的新密码：");
                String reNewPassword = sc.next();
                if(newPassword.equals(reNewPassword)){
                    flag = true;
                    System.out.println("密码修改成功！");
                    ac.setPassword(newPassword);
                    // 调用开始菜单
                    startMenu();
                }else{
                    System.out.println("两次密码输入不一致!");
                }
            }else{
                System.out.println("你输入的"+oldPassword+"不是原来密码，请输入正确的旧密码");
            }
        }

    }
    /**
     * 生成验证码
     */
    public  String code(){
        String[] srr = {"q","w","e","r","t","y","u","i","o","p","a","s","d","f",
                "g","h", "j","k","l","z","x","c","v","b","n","m","Q","W","E","R",
                "T","Y","U","I","O","P","A","S","D","F","G","H", "J","K","L", "Z",
                "X","C","V","B","N","M","0","1","2","3","4","5","6","7","8","9"};
        Random r = new Random();
        String[] code = new String[4];
        // 生成随机下标[0~62)
        for (int i = 0; i < code.length; i++) {
            int index = r.nextInt(srr.length);
            code[i] = srr[index];
        }
        return code[0]+code[1]+code[2]+code[3];
    }
    /**
     * 主菜单
    */
    public void mainMenu(){
        System.out.println("**************欢迎 "+ac.getUsername()+" 登录*********** ******");
        System.out.println("1 幸运抽奖（需要完成功能，加个猜数字功能）\n" +
                "2 购物结算\n" +
                "3 商品陈列\n" +
                "4 真情回馈\n" +
                "5 注销用户");
    }
    /**
     * 验证用户名是否被占用
    */
    public boolean verifyUsername(String name){
        return name.equals(ac.getUsername());
    }

}
