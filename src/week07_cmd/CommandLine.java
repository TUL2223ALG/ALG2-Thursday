package week07_cmd;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class CommandLine {

    private File actualDir;

    public CommandLine() {
        actualDir = new File(System.getProperty("user.dir"));
    }

    public String getActualDir() {
        return actualDir.getAbsolutePath();
    }

    public String dir() {
        return dir(actualDir);
    }
    
    private String dir(File file){
        File[] sub = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().charAt(0) != '.';
            }
        });
        StringBuilder sbDir = new StringBuilder();
        StringBuilder sbFile = new StringBuilder();
        for (File f : sub) {
            if (f.isDirectory()) {
                sbDir.append(f.getName()).append("\n");
            } else {
                sbFile.append(f.getName()).append("\n");
            }
        }
        return sbDir.append(sbFile).toString();
    }
    
    public String dir(String name) {
        File newActualDir = new File(actualDir, name); 
        
        if (!newActualDir.exists()){
            throw new FileException("Adresář neexistuje.");
        }
        if (!newActualDir.isDirectory()) {
            throw new FileException("Toto není adresář.");
        }
        return dir(newActualDir);
    }
    
    public void cd(String dirName) {
        //jen jestli je to existujici adresar
        if (!"..".equals(dirName)) {
            File newActualDir = new File(actualDir, dirName);
            actualDir = newActualDir;
        } else{
            actualDir = actualDir.getParentFile();
        }
    }

    public boolean mkfile(String name) throws IOException {
        File newFile = new File(actualDir, name);
        return newFile.createNewFile();
    }
    
    public boolean rm(String name){
        File fileToDelete = new File(actualDir, name);
        return fileToDelete.delete();
    }
}
