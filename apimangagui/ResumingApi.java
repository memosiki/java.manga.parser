/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apimangagui;

import java.io.*;
import java.util.*;

/**
 *
 * @author mint
 */
public class ResumingApi {

    
    void checkChapters(String path) {
        File file = new File(path);
        String[] dirСontent;
        if (file.exists()) {
        //нет такого
        } 
        if (!file.isDirectory()) {
        //это не папка
        } 
        dirСontent=file.list();
        System.err.println(Arrays.toString(dirСontent));
        
        
    }
    void checkPages(String path) {
    }
    void checkCovers(String path) {
    }
    
}
