package me.sontag.codetest.utils;

import java.nio.file.Paths;

/**
 *  Class containing file related utilities
 */
public class FileUtil {

    // This class shouldn't be instantiated.
    private FileUtil() {}

    /**
     *  A method that returns the jar files directory path
     *  @return path for the jar file directory
     */
    public static String getJarPath() {
        String dirtyPath = FileUtil.class.getResource("").toString();
        String jarPath = dirtyPath.replaceAll("^.*file:/", ""); //removes file:/ and everything before it
        jarPath = jarPath.replaceAll("jar!.*", "jar"); //removes everything after .jar, if .jar exists in dirtyPath
        jarPath = jarPath.replaceAll("%20", " "); //necessary if path has spaces within
        if (!jarPath.endsWith(".jar")) { // this is needed if you plan to run the app using Spring Tools Suit play button.
            jarPath = jarPath.replaceAll("/classes/.*", "/classes/");
        }
        String directoryPath = Paths.get(jarPath).getParent().toString(); //Paths - from java 8
        return directoryPath;
    }
}

