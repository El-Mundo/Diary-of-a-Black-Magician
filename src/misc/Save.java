package misc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Save {
	private static Path path = Paths.get("res/Save.txt");
	public static int[] readSav() {
		int[] output = new int[6];
        int lines = 0;
        try{
            try {
	        	path = Paths.get("res/Save.txt");
	            BufferedReader Reader = Files.newBufferedReader(path);
	            LineNumberReader reader = new LineNumberReader(Reader);
	            String line = "";
	            while((line = reader.readLine())!=null){
	            	if(lines<6) {
	            		output[reader.getLineNumber()-1] = Integer.parseInt(line);
	                    lines++;
	                }else {break;}
	            }
	            if(reader.getLineNumber()!=6) {throw new Exception("Save File Format is Incorrect.");}
	            reader.close();
	            Reader.close();
            }catch(IOException e2) {
            	throw new IOException("Save File doesn't Exsist.");
            }
        }catch(Exception e){
        	e.printStackTrace();
        	int[] newSav = {2,0,0,0,0,0};
        	writeSav(newSav);
        	return newSav;
        }
        return output;
	}
	
	public static void writeSav(int[] sav) {
		try {
			BufferedWriter writer = Files.newBufferedWriter(path,StandardOpenOption.CREATE);
			writer.write(sav[0]+"\n"+sav[1]+"\n"+sav[2]+"\n"+sav[3]+"\n"+sav[4]+"\n"+sav[5]);
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
