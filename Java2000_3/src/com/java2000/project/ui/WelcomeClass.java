package com.java2000.project.ui;

import com.java2000.project.utils.UserIO;

public class WelcomeClass extends BaseClass{
    public void start(){
        print(getString("info.welcome"));
        boolean flag = true;
        while (flag){
            print(getString("info.login.reg"));
            print(getString("info.select"));
            String select = input.nextLine();
            switch (select){
                case "1":
                    try {
                        new LoginClass().login();
                        flag = false;
                        print(getString("log.success"));
                    }catch (BusinessException e){
//                        print(getString(e.getMessage()));
                        print(getString("log.error"));
                    }

                    break;
                case "2":
                    try {
                        new RegisterClass().register();
                        print(getString("reg.success"));
                        flag = false;
                    }catch (BusinessException e){
                        print(getString("reg.error"));
                    }
                    break;
                default:
                    print(getString("input.error"));
                    break;
            }
        }
        HomeClass homeClass = new HomeClass();
        homeClass.show();

    }

}
