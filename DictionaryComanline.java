package sample;
import java.util.ArrayList;

public class DictionaryComanline {

    ArrayList<Word>arrays=new ArrayList<>();
    public void showAllWords(Dictionary vd) {

        arrays = vd.getDictionarys();
        System.out.println("stt  " +"|English  "+"|Tiếng việt");
        for (int i = 1; i < arrays.size(); i++) {
            System.out.println(i + "     |" + arrays.get(i).getWord_target() + "    |"+ arrays.get(i).getWord_plain());
        }
    }
    public void dictionaryBasic()
    {  DictionaryManagement a =new DictionaryManagement();
        Dictionary b = new Dictionary();
        DictionaryComanline c = new DictionaryComanline();
        b.setDictionarys(a.insertFromcomandline());
        c.showAllWords(b);
    }
    public void dictionaryAdvanced()
    {
        DictionaryComanline c= new DictionaryComanline();
        DictionaryManagement a=new DictionaryManagement();
        Dictionary b =  new Dictionary();
       a.insertFromFile(b);
        c.showAllWords(b);
       // a.dictionarylookup(b.getDictionarys());
    }
     public  ArrayList<String> dictionarySearch(ArrayList<Word> c, String text)
        {
            ArrayList<String> same = new ArrayList<>();
            int n=0;
            for (int i=0;i<c.size();i++)
            {
                Word saw=new Word();
                saw=c.get(i);
                if(saw.word_target.startsWith(text))
                {
                    same.add(n,saw.getWord_target());
                    n++;
                }
            }

            return same;
        }
}

