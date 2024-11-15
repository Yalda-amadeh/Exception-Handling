package exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;



public class ReadFile {
	public ReadFile(String filename) {
		super();
		this.filename = filename;
		this.data = data;
	}
	private String filename;
	private String data;
	

	public static void readFile(String filename) throws FileExceptions{
        BufferedReader reader = null;

            try{reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line); 
            
            }}catch (FileNotFoundException e) {
            	throw new FileExceptions("فایل پیدا نشد!");
            }catch ( FileAlreadyExistsException  e) {
            	throw new FileExceptions("فایل وجود دارد");
            }catch(Error e) {
            	throw new FileExceptions("kjnkn");
            }catch (IOException e) {
            	throw new FileExceptions("jhbkjnb");
            }finally {
                // Close the reader in the finally block to ensure it gets closed
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred while closing the file: " + e.getMessage());
                }}
                    
   }
	
	public void writefile(String data,String filename) throws FileExceptions{
        try {
		Path path = Paths.get(filename);
        Files.write(path, Arrays.asList(data));
        System.out.println("داده‌ها به فایل نوشته شد: " + filename);
	    }catch(FileSystemException e) {
    	throw new FileExceptions("خطای سیستمی");
    }catch(OutOfMemoryError e) {
    	throw new FileExceptions("خارج از حجم مموری");
    }catch (IOException e) {
    	throw new FileExceptions("jhbkjnb");
    }
}	

	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	

	

}
