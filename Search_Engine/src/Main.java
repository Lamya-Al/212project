import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.;
    //ReadFile rf= new ReadFile();
   // rf.printstopWords();

       DocumentIndex De=new DocumentIndex();
      De.IndexID(new File("C:\\Users\\LALKA\\IdeaProjects\\Search_Engine\\src\\dataset.csv"));
       //De.printUniqueWords();
     De.Invertedindex(new File("C:\\Users\\LALKA\\IdeaProjects\\Search_Engine\\src\\dataset.csv"));
      //De.printInverted();
        De.InvertedBST();



    }
}