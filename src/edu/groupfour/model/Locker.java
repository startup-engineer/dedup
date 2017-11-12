package edu.groupfour.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Locker {

    private String path; //path to locker
    private ArrayList<String> files; //paths of the files that are to be added to the locker

    public Locker(){
        files = new ArrayList<>();
        path = System.getProperty("user.dir"); //temporarily just using the default path of the process
    }

    public Locker(String path){
        this.path = path; //temporarily just using the default path of the process
        files = new ArrayList<>();
    }

    public void addFile(String filePath) throws IOException{
        files.add(filePath);
    }

    public void save() throws IOException{
        FileInputStream in = null;
        FileOutputStream out = null;
        try{
            out = new FileOutputStream(path, true); //open the locker
            for(String file : files){
                in = new FileInputStream(file); //open each file to add to locker
                int c;

                while ((c = in.read()) != -1) { //add each file to the locker
                    out.write(c);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            //System.exit(1);
        }

    }

    public void load(){

    }
}