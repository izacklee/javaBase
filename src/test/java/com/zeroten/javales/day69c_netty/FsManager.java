package com.zeroten.javales.day69c_netty;

import com.zeroten.javales.day57c_concurrentfuture.PrompLogger;
import com.zeroten.javales.day69c_netty.po.FsEntity;
import com.zeroten.javales.day69c_netty.po.FsResponse;
import lombok.Data;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class FsManager {

    private static volatile FsManager singleton;

    private String inFilePath;

    private String outFilePath;

    private FsManager() {}

    private static final PrompLogger logger = PrompLogger.getLogger(FsManager.class);

    public static FsManager getSingleton() {

        if (null == singleton) {

            synchronized (FsManager.class) {

                if (null == singleton) {
                    singleton = new FsManager();
                }

            }
        }

        return singleton;
    }

    private Map<String, FsResponse> fsResponseMap = new ConcurrentHashMap<>();

    /**
     * 记录文件发送响应
     * @param response
     */
    public void recordFsResponse(FsResponse response) {

        fsResponseMap.put(response.getHost(), response);

        logger.info(response.toString());

//        System.out.println(response);
    }

    public void init(String inPath, String outPath) {

        this.inFilePath = inPath;
        this.outFilePath = outPath;
    }

    /**
     * Mapped File way MappedByteBuffer 可以在处理大文件时，提升性能
     *
     * @return
     * @throws IOException
     */
    public FsEntity readFromDisk(FsEntity fsEntity) throws IOException {

        String path = inFilePath + File.separator + fsEntity.getId() + ".zip";

        FileChannel fc = null;

        try {
            fc = new RandomAccessFile(path, "r").getChannel();
            MappedByteBuffer byteBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).load();

            byte[] result = new byte[(int) fc.size()];
            if (byteBuffer.remaining() > 0) {
                byteBuffer.get(result, 0, byteBuffer.remaining());
            }

            // 生成32位UUID
            String fsId = getUUID();

            logger.info("文件读取成功，路径=[{}]", path);

            return new FsEntity(fsId, result.length, result);
        } catch (IOException e) {

            e.printStackTrace();
            throw e;
        } finally {
            try {
                fc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getUUID() {

        String uuid = UUID.randomUUID().toString();

        return uuid.replaceAll("-", "");
    }

    /**
     * 创建文件，创建成功返回true, 存在返回true
     * @param filePath
     * @return
     * @throws IOException
     */
    public boolean createFile(String filePath) throws IOException {

        File file = new File(filePath);

        if (file.exists()) return true;

        String dir = file.getParent();

        File dirFile = new File(dir);

        if (!dirFile.exists()) {

            if (dirFile.mkdirs()) {

                return file.createNewFile();
            }

            return false;
        }


        return file.createNewFile();
    }

    /**
     * 写文件到磁盘
     * @param fsEntity
     */
    public void writeToDisk(FsEntity fsEntity) throws IOException {

        FileOutputStream foStream = null;

        String zipFileName = fsEntity.getId() + ".zip";

        String fPath = outFilePath + File.separator + zipFileName;

        try {

            if (!createFile(fPath)) {

                return;
            }

            foStream = new FileOutputStream(fPath);

            int len = fsEntity.getFsData().length;

            int readOneTime = 1024;

            int start = 0;

            while(start < len) {

                if (len - start > readOneTime) {

                    foStream.write(fsEntity.getFsData(), start, readOneTime);
                    start += readOneTime;

                } else {

                    foStream.write(fsEntity.getFsData(), start, len - start);
                    start += (len - start);
                }
            }

            foStream.flush();

            logger.info("文件保存成功，路径=[{}]", zipFileName);

        } catch (FileNotFoundException e) {

            e.printStackTrace();
            throw e;

        } catch (IOException e) {

            e.printStackTrace();
            throw e;

        } finally {

            if (null != foStream) {

                try {
                    foStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void setSingleton(FsManager singleton) {
        FsManager.singleton = singleton;
    }

    public String getInFilePath() {
        return inFilePath;
    }

    public void setInFilePath(String inFilePath) {
        this.inFilePath = inFilePath;
    }

    public String getOutFilePath() {
        return outFilePath;
    }

    public void setOutFilePath(String outFilePath) {
        this.outFilePath = outFilePath;
    }

    public static PrompLogger getLogger() {
        return logger;
    }

    public Map<String, FsResponse> getFsResponseMap() {
        return fsResponseMap;
    }

    public void setFsResponseMap(Map<String, FsResponse> fsResponseMap) {
        this.fsResponseMap = fsResponseMap;
    }

    public static void main(String args[]) {

        FsManager.getSingleton().init("/Users/app/Downloads/javaproject/" +
                "javatest/basic-code/slsweb/src/com/jinxun/githubmaven/java_demo/" +
                "src/test/java/com/zeroten/javales/day69c_netty/txt", "/Users/app/Downloads/javaproject/" +
                "javatest/basic-code/slsweb/src/com/jinxun/githubmaven/java_demo/" +
                "src/test/java/com/zeroten/javales/day69c_netty/txt/111.txt");

        try {
            FsManager.getSingleton().createFile("/Users/app/Downloads/javaproject/" +
                    "javatest/basic-code/slsweb/src/com/jinxun/githubmaven/java_demo/" +
                    "src/test/java/com/zeroten/javales/day69c_netty/txt/111.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
