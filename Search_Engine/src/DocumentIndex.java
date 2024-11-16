import java.io.*;

public class DocumentIndex {
    ReadFile readFile = new ReadFile();
    ArrayList<String> stpWord=readFile.stpList;
    LinkedList<LinkedList<String>> IDList=new LinkedList<>();
    LinkedList<String> UniqueWords=new LinkedList<>();
    LinkedList<Integer> IDs = new LinkedList<>();
    LinkedList<LinkedList<Integer>> InvertedList = new LinkedList<>();
    BST<LinkedList<Integer>> InvertedBST=new BST<>();
    public void IndexID(File dataset) throws IOException {
        String line;
        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader(dataset));
            br.readLine(); //skip first line
           // while ((line=br.readLine())!=null) {
            for(int id=0;id<50;id++){
                line=br.readLine();
              char firstChar =line.charAt(0);
                int ch=line.indexOf(',');
                line=line.substring(ch);
                line = line.toLowerCase();
                String[] words = null;
              //  for(int id=0;id<50;id++) {
                if (line != null && !line.trim().isEmpty()) {
                    words = line.split("\\s+");
                }
                //System.out.println("Document ID: " + id);
                LinkedList<String> wordsList = new LinkedList<>();
                for (String word : words) {
//                    System.out.println("In first loop "+word);
                    word = RemovePunctuation(word);
                    if (!stpWord.contains(word)) {
                        wordsList.insert(RemovePunctuation(word));
                        if (!UniqueWords.contains(RemovePunctuation(word))) {
                            UniqueWords.insert(RemovePunctuation(word));
//                            System.out.println(" UniqueWords inserted "+UniqueWords.retrieve());
                        }
                        else {
//                            System.out.println("rempved: "+RemovePunctuation(word));
                        }
                    }//if
//                    else System.out.println("rempved: "+RemovePunctuation(word));
                }//for
                if (!wordsList.empty()) {
                    IDList.insert(wordsList);
                }//if
            }//while
            br.close();
           /* int i=0;
            IDList.findFirst();
            while (!IDList.empty()) {
                LinkedList<String> temp = IDList.retrieve();
                IDList.remove();
                temp.findFirst();
              // System.out.println("i=:"+i);
                while (!temp.last()) {
                    System.out.print("i:"+temp.retrieve());
                    temp.findNext();
                }
                System.out.println(temp.retrieve());
                i++;
            }*/
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());

        }

    }
    //-----------------------------------------------------

    public void printUniqueWords() {
        System.out.println("Start of printUniqueWords");
        int num=0;
        UniqueWords.findFirst();
        while(!UniqueWords.last()){
            System.out.println("num: "+num+" "+UniqueWords.retrieve());
            UniqueWords.findNext();
            num++;
        }
        System.out.println(UniqueWords.retrieve());
        System.out.println("number of unique words: " + (++num));
        System.out.println("end of printUniqueWords");
    }

     public void  Invertedindex (File dataset) throws IOException {
         String line;
         BufferedReader br = null;
       //  br = new BufferedReader(new FileReader(dataset));
         UniqueWords.findFirst();
       //  System.out.println("UniqueWords is; " + !UniqueWords.empty());
         while(!UniqueWords.hasNext()){
            String word = UniqueWords.retrieve();
             br = new BufferedReader(new FileReader(dataset));
             line= br.readLine();
             LinkedList<Integer> IDsOfWord =new LinkedList<>();
             for(int id=0;id<50;id++){
                 line=br.readLine();
                 int ch=line.indexOf(',');
                 line=line.substring(ch);
                 line = line.toLowerCase();
                 line=RemovePunctuation(line);
                 String[] words = line.split("\s");
                 for (int i=0;i< words.length;i++){
                     if(words[i].equals(word)){
                         if(!IDsOfWord.contains(id)) {
                             IDsOfWord.insert(id);
                         }
                     }//if
                 }//for
             }//for
             InvertedList.insert(IDsOfWord);
             UniqueWords.findNext();
             //System.out.println(IDs.empty());
            // UniqueWords.remove();
         }//while

     }

   /*public void printInverted(){
        System.out.println("strat of print");
        int i=0;
        InvertedList.findFirst();
        System.out.println("InvertedList empty?"+InvertedList.empty());
        while (!InvertedList.hasNext()) {
            LinkedList<Integer> temp = InvertedList.retrieve();
            temp.findFirst();
          //  System.out.println("empty?"+temp.empty());
             System.out.println("word "+i+"(testing):");
            while (!temp.last()) {
                System.out.print(temp.retrieve()+" ");
                temp.findNext();
            }
            System.out.println(temp.retrieve());
            InvertedList.findNext();
            i++;
        }
    }*/

    public static String RemovePunctuation (String line){
                // Remove all punctuation
                return line.replaceAll("[^a-zA-Z0-9 ]", "");
            }

    public void InvertedBST() {
       String word;
       LinkedList<Integer> listOfID = new LinkedList<>();
        UniqueWords.findFirst();
        InvertedList.findFirst();
        while (!UniqueWords.last()) {
            word = UniqueWords.retrieve();
            listOfID=InvertedList.retrieve();
            listOfID.findFirst();
            InvertedBST.insert(word,listOfID);
            UniqueWords.findNext();
            InvertedList.findNext();
        }
        word = UniqueWords.retrieve();
        listOfID=InvertedList.retrieve();
        InvertedBST.insert(word,listOfID);

    }

        }//end of class

