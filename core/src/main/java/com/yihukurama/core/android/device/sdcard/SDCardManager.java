package com.yihukurama.core.android.device.sdcard;

import android.os.Environment;
import android.util.Log;

import com.yihukurama.core.utils.AppInfoUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 外置内存卡文件管理类
 * Created by dengshuai on 16/1/29.
 */
public class SDCardManager {
    private static SDCardManager ourInstance;

    private String sdCardRootPath = Environment.getExternalStorageDirectory()
            .getAbsolutePath() + File.separator;
    private String imageFolderName = "image";
    private String audioFolderName = "audio";
    private String videoFolderName = "video";
    File imageFolder;
    File audioFolder;
    File videoFolder;

    private List<File> FileSystemList;
    public static SDCardManager getInstance() {



        if (ourInstance == null){
            ourInstance = new SDCardManager();
        }

        return ourInstance;
    }

    private SDCardManager() {

        FileSystemList = new ArrayList<File>();


        initSDCardManager();


    }

    public boolean initSDCardManager() {
        // 1.判断是否有sdcard
        if (!haveSDCard()) {
            return false;
        }

        //2.判断工程是否获取SDCard读写权限
        if(!isExternalStorageReadable() || !isExternalStorageWritable()){
            Log.d("MVC4A", "程序未获得读写外部存储设备权限");
            return false;
        }
        // 3.建立文件目录架构，有则不建立
        createFileSystemFolders();
        return true;
    }

    //建立文件目录结构
    private void createFileSystemFolders(){
        Log.d("MVC4A", "createFileSystemFolders: ");
        //初始化所有路径
        String appName = AppInfoUtil.getInstance().getAppName();
        String appSdCardRootPath = sdCardRootPath + appName;
        imageFolder = new File(appSdCardRootPath + File.separator + imageFolderName);
        audioFolder = new File(appSdCardRootPath + File.separator + audioFolderName);
        videoFolder = new File(appSdCardRootPath + File.separator + videoFolderName);

        FileSystemList.add(imageFolder);
        FileSystemList.add(audioFolder);
        FileSystemList.add(videoFolder);

        creatSDDir("", FileType.image,true);
        creatSDDir("",FileType.audio,true);
        creatSDDir("", FileType.video, true);

        for (File folder:FileSystemList) {
            if (folder.exists()){
                Log.i("MVC4A","文件目录"+folder.getAbsolutePath()+"已存在");
            }else{
                folder.mkdirs();
            }
        }

    }

    //判断是否有SDCard
    public boolean haveSDCard() {
        return android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
    }

    //判断是否存在该文件
    public boolean isExists(String dir,FileType type){
        File dirFile = null;
        switch (type) {
            case image:
                dirFile = new File(imageFolder.getAbsolutePath()  + File.separator + dir + File.separator);
                break;
            case audio:
                dirFile = new File(audioFolder.getAbsolutePath()  + File.separator + dir + File.separator);
                break;
            case video:
                dirFile = new File(videoFolder.getAbsolutePath() + File.separator + dir + File.separator);
                break;
            case other:
                dirFile = new File(sdCardRootPath  + File.separator + dir + File.separator);
                break;
        }

        return dirFile.exists()?true:false;
    }



    //删除SDCard内的目录
    public boolean deleteSDDir(String dir,FileType type){
        File dirFile = null;
        switch (type){
            case image:
                dirFile = new File(imageFolder.getAbsolutePath()  + File.separator + dir + File.separator);
                break;
            case audio:
                dirFile = new File(audioFolder.getAbsolutePath()  + File.separator + dir + File.separator);
                break;
            case video:
                dirFile = new File(videoFolder.getAbsolutePath() + File.separator + dir + File.separator);
                break;
            case other:
                dirFile = new File(sdCardRootPath  + File.separator + dir + File.separator);
                break;
        }

        dirFile.delete();

        return dirFile.exists()?false:true;

    }


    // 在SD卡上创建目录,只能创建在包名下的文件夹内,canSee参数为false建立隐藏文件夹
    public File creatSDDir(String dir,FileType type,boolean canSee) {
        Log.d("MVC4A", "creatSDDir: ");
        File dirFile = null;
        switch (type){
            case image:
                dirFile = new File(imageFolder.getAbsolutePath()  + File.separator + dir + File.separator);
                break;
            case audio:
                dirFile = new File(audioFolder.getAbsolutePath()  + File.separator + dir + File.separator);
                break;
            case video:
                dirFile = new File(videoFolder.getAbsolutePath() + File.separator + dir + File.separator);
                break;
            case other:
                dirFile = new File(sdCardRootPath  + File.separator + dir + File.separator);
                break;
        }

        Log.d("MVC4A", dirFile.getAbsolutePath());
        dirFile.mkdirs();

        if (!canSee){//隐藏该文件夹
            Log.d("MVC4A", "canSee: ");
            try {
                new File(dirFile.getAbsolutePath() + File.separator+".nomedia").createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return dirFile;
    }


    /* 外部存储设备是否读正常 */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* 外部存储设备是否写正常 */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

}
