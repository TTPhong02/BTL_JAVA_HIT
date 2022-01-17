package Controller;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileController {
    public FileWriter fileWriter ;
    public BufferedWriter bufferedWriter;
    public PrintWriter printWriter;
    public Scanner scanner;

    public Scanner getScanner(){
        return this.scanner;
    }
    public void OpenFileToWrite(String namefile){
        try{
            fileWriter = new FileWriter(namefile,false);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void CloseFileAfterWrite(){
        try{
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void OpenFileToRead(String namefile){
        try{
            scanner = new Scanner(Paths.get(namefile));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CloseFileAfterRead(){
        scanner.close();
    }
    public PrintWriter getPrintWriter(){
        return printWriter;
    }
}
