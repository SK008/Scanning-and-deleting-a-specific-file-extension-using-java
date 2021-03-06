import java.io.*;

public class FileChecker {

   private static final String FILE_DIR = "C:\\Users\\hp\\Desktop";
   private static final String FILE_TEXT_EXT = ".";     \\file extension

   public static void main(String args[]) {
	new FileChecker().deleteFile(FILE_DIR,FILE_TEXT_EXT);
   }

   public void deleteFile(String folder, final String ext) {
File dir = new File(folder);

// list out all the file name with .bat.gz extension
    File[] list = dir.listFiles(new FileFilter() {

@Override
public boolean accept(File file) {
return file.isFile() && file.getName().endsWith(ext);
}
});

if (list.length == 0)
return;

for (File file : list) {
boolean isdeleted = file.delete();
System.out.println("file : " + file.getAbsolutePath() + " is deleted : " + isdeleted);
}
}

   //inner class, generic extension filter
   public class GenericExtFilter implements FilenameFilter {

       private String ext;

       public GenericExtFilter(String ext) {
         this.ext = ext;
       }

       public boolean accept(File dir, String name) {
         return (name.endsWith(ext));
       }
    }
}
