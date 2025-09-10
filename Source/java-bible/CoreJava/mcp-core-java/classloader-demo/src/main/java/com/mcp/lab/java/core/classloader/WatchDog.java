package com.mcp.lab.java.core.classloader;

import com.mcp.lab.java.core.classloader.watchfile.ITest;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年04月14日 10:20 PM
 * @modified by:
 */
public class WatchDog implements Runnable{

    private Map<String,FileDefine> fileDefineMap;

    public WatchDog(Map<String,FileDefine> fileDefineMap){
        this.fileDefineMap = fileDefineMap;
    }

    @Override
    public void run() {
        File file = new File(FileDefine.WATCH_PACKAGE);
        File[] files = file.listFiles();
        for (File watchFile : files){
            long newTime = watchFile.lastModified();
            FileDefine fileDefine = fileDefineMap.get(watchFile.getName());
            long oldTime = fileDefine.getLastDefine();
            //如果文件被修改了,那么重新生成累加载器加载新文件
            if (newTime!=oldTime){
                fileDefine.setLastDefine(newTime);
                loadMyClass();
            }
        }
    }

    public void loadMyClass(){
        try {
            CustomClassLoader customClassLoader = new CustomClassLoader();
            Class<?> cls = customClassLoader.loadClass("com.mcp.lab.java.core.classloader.watchfile.Test",false);
            ITest test = (ITest) cls.newInstance();
            test.test();
//            Method method = cls.getMethod("test");
//            method.invoke(test);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
