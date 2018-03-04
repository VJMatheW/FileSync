/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesync;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Vijay
 */
public class ScanFolder2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String homeDir = "G:\\aurora\\AuroraWebsite";
        File folder = new File(homeDir);
        
        System.out.println(System.getProperty("file.separator"));
        Path src = new File("G:\\Images\\Pride\\IMG_4149.JPG").toPath();
        Path dest = new File("G:\\Images\\Pride\\test.JPG").toPath();
        
        String s = "G:\\Images\\Pride\\IMG_4149.JPG";
        Files.copy(src, dest,StandardCopyOption.REPLACE_EXISTING);
        
//        File[] listOfFiles = folder.listFiles();
////        String[] filesAndFoldersNames = folder.list();
////        for(String s : filesAndFoldersNames ){
////            System.out.println(s);
////        }
//
//    for (int i = 0; i < listOfFiles.length; i++) {
//      if (listOfFiles[i].isFile()) {
//        System.out.println("File " + listOfFiles[i].getName());
//      } else if (listOfFiles[i].isDirectory()) {
//        System.out.println("Directory " + listOfFiles[i].getName());
//      }
//    }
   }
    
}
