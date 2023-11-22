package core;

import java.io.*;
import java.util.logging.Logger;

public class AppiumServer {

    String appiumPath;

    String nodePath;

    public void setAppiumPath(String appiumPath) {
        this.appiumPath = appiumPath;
    }

    public void setNodePath(String nodePath) {
        this.nodePath =  nodePath;
    }
    public String getAppiumPath(String appiumPath){return appiumPath;}

    public String getNodePath(String nodePath) { return nodePath;}




    AppiumServer(){
        if(System.getProperty("os.name").contains("Windows")){
            setAppiumPath(getAppiumPathDirectory("npm.cmd list -g") + "\\node_modules\\appium");
            setNodePath(getNodePathDirectory("where node"));
        }
    }

    private String getNodePathDirectory(String command) {
        String nodePath = null;
        try {
            Process p = Runtime.getRuntime().exec(command);
            InputStream in = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            nodePath = br.readLine();
        }
        catch (IOException e){
            System.out.println(e);
        }
        return nodePath;
    }

    private String getAppiumPathDirectory(String command){
        String appiumPath = null;
        try {
            Process p = Runtime.getRuntime().exec(command);
            InputStream in = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            appiumPath = br.readLine();
        }
        catch (IOException e){
            System.out.println(e);
        }
        return appiumPath;
    }

    public void startServer(){



    }
}

