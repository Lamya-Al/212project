import java.io.*;

public class ReadFile  {
  ArrayList<String> stpList= new ArrayList<String>(571);
  //LinkedList<String> dataList=new LinkedList<String>();
    File stop = new File("C:\\Users\\LALKA\\IdeaProjects\\Search_Engine\\src\\stop.txt");;

    ReadFile()  {
        try {
            ReadStopWords();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
     public void ReadStopWords() throws IOException {
         String line;
         BufferedReader reader = null;
         try{
             reader = new BufferedReader(new FileReader("C:\\Users\\LALKA\\IdeaProjects\\Search_Engine\\src\\stop.txt"));
            ArrayList<String> alpfa=new ArrayList<String>(26);
            /*for (int i=0;i<26;i++){
              alpfa.insert(Character.toString((char)('a'+i)));
              System.out.println("alfa:"+alpfa.retrieve());
            }*/
            while ((line=reader.readLine())!=null) {
               /* alpfa.findFirst();
                System.out.println("line: "+line);
                if(alpfa.contains(line)){
                    System.out.println("line contain:  "+line);
                    alpfa.remove();*/
                if (line.length() == 1 ) {
                    continue;
                }
                else {
                    stpList.insert(RemovePunctuation(line));
                }
             }
         } catch (FileNotFoundException e) {
             System.out.println("Error: File not found. Please check the file path.");
         } catch (IOException e) {
             System.out.println("Error reading the file: " + e.getMessage());
         }catch (Exception e) {
             System.out.println(e.getMessage());
             System.out.println("File not found");
         }
         finally {
            try{
             if (reader != null)
                 reader.close();
              } catch (IOException ex) {
             System.out.println("Error closing the reader.");
             }
         }
     }
    public static String RemovePunctuation(String line) {
        // Remove all punctuation and convert to lowercase
        return line.replaceAll("[^a-zA-Z0-9 ]", "");
    }
    public void printstopWords(){
        stpList.findFirst();
        while(!stpList.last()){
            System.out.println(stpList.retrieve());
            stpList.findNext();
        }
        System.out.println(stpList.retrieve());
        System.out.println("size of stpList: "+stpList.getSize());
    }

}





