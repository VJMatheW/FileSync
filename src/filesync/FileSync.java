/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesync;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Vijay
 */
public class FileSync {
    
   public static String folderKey="folvj",fileKey="filevj";

   public static void main(String[] args) throws IOException {
       
        String dest = "G:\\Images\\Pride",src="\\\\192.168.1.1\\usb1_5\\VJ\\Pride";
        
        Collection<File> all = new ArrayList<File>();
        Collection<File> destCollection = new ArrayList<File>();
        
        addTree(new File(src), all);
        addTree(new File(dest), destCollection);
        
        List<String> srcFiles = getAsList(src,all);
        List<String> destFiles = getAsList(dest,destCollection);
        
        printList(srcFiles);
        printList(destFiles);
        int missingCount =0,copyCount=0,folderCount=0;
        
        for(int i =0;i<srcFiles.size();i++){
            if(destFiles.contains(srcFiles.get(i))){
                System.out.println( "Already exists : "+srcFiles.get(i));
            }else{
                System.out.println("File not present");
                ++missingCount;
                String tempSrc,tempDest;
                if(srcFiles.get(i).startsWith(folderKey)){
                    ++folderCount;
                    tempSrc = dest+srcFiles.get(i).replace(folderKey, "");
                    System.out.println("Folder : "+tempSrc);
                    File folder = new File(tempSrc);
                    if(!folder.exists()){
                        System.out.println("Creating a folder");
                        folder.mkdirs();
                    }
                }else{
                    ++copyCount;
                    System.out.println("Copying to destination : "+srcFiles.get(i).replace(fileKey, ""));
                    tempSrc = src+srcFiles.get(i).replace(fileKey, "");
                    tempDest = dest+srcFiles.get(i).replace(fileKey, "");
                    System.out.println("File src  :"+tempSrc+ "\n File Dest : "+tempDest);
                    Files.copy(new File(tempSrc).toPath(), new File(tempDest).toPath(),StandardCopyOption.REPLACE_EXISTING);
                }                                              
            }
        }
        System.out.println("Total No of Files Missing : "+(missingCount-folderCount));                        
        System.out.println("Total No of Files Copied : "+copyCount);
    }

    static void addTree(File file, Collection<File> all) {    
        File[] children = file.listFiles();
        if (children != null) {
            for (File child : children) {
                all.add(child);
                addTree(child, all);
            }
        }
    }

    static List<String> getAsList(String path,Collection<File> files){                        
        List<String> srcFileName = new ArrayList<String>();        
        for(File f : files){
            if(f.isDirectory()){
                srcFileName.add(folderKey+f.toString().replace(path, ""));
            }else{
                srcFileName.add(fileKey+f.toString().replace(path, ""));
            }
            
        }                         
        return srcFileName;
    }
    
    static void printList(List<String> s){
        System.out.println(s.size());
        for(String s1 : s){
            System.out.println(s1);
        }
    }
        
}
