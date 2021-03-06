package sample;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {

    public Word insertWord() {
        Word array = new Word();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập từ tiếng anh");
        String a;
        a = sc.nextLine();
        array.setWord_target(a);
        System.out.println("giải nghĩa");
        String b;
        b = sc.nextLine();
        array.setWord_plain(b);
        return array;
    }

    public int nhapso() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập số lượng từ vựng");
        n = sc.nextInt();
        return n;
    }

    public ArrayList<Word> insertFromcomandline() {
        DictionaryManagement b = new DictionaryManagement();
        ArrayList<Word> a = new ArrayList<>();
        Dictionary s = new Dictionary();
        int k;
        k = b.nhapso();
        for (int i = 0; i < k; i++) {
            a.add(i, b.insertWord());
        }
        return a;
    }

        public void insertFromFile(Dictionary as) {
        String path="C:/gibhub/filedictionary/E_V.txt";
            String[] wordonline;
            String textInALine;
            BufferedReader br = null;
            int i=0;
            try {
                br = new BufferedReader(new FileReader(path));
                while ((textInALine = br.readLine()) != null) {
                    int posSplit = textInALine.indexOf("<html>");
                    if (posSplit > 0 && posSplit < textInALine.length()) {
                        String target = textInALine.substring(0, posSplit);
                        String explain = textInALine.substring(posSplit);
                        Word word = new Word();
                        word.word(target,explain);
                        as.push(word);

                    }
                }


            }
            catch (Exception e) {}

    }

    public String dictionarylookup(ArrayList<Word> a,String text1) {

        ArrayList<String> test=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < a.size(); i++) {
            Word swap = new Word();
            swap = a.get(i);
            if (swap.word_target.equals(text1)) {
                text1=swap.word_plain;
            }
        }
        return text1;
    }

    public void dictionaryExportToFile(String text1,ArrayList<Word> a) {
        File file = new File("C:/gibhub/filedictionary/E_V.txt");
        try{ PrintWriter writer = new PrintWriter(file);
            writer.write(" ");
            writer.close();}
        catch (Exception e){}

        BufferedWriter bw = null;
        FileWriter fw = null;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).word_target.equals(text1)) {
                a.remove(i);
            }
            else
            {
                try {
                    fw = new FileWriter(file.getAbsoluteFile(), true);
                    bw = new BufferedWriter(fw);
                    bw.write(a.get(i).word_target+a.get(i).word_plain+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (bw != null)
                            bw.close();
                        if (fw != null)
                            fw.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }


    public  void addfile(ArrayList<Word> add,String texttess,String texttess2) {
        File file = new File("C:/gibhub/filedictionary/E_V.txt");
        int n = 0;
        BufferedWriter bw = null;
        FileWriter fw = null;
        for (int i = 0; i < add.size(); i++) {
            Word s=new Word();
            s=add.get(i);
            if (s.word_target.equals(texttess)) {
                n++;
            }
        }
        if (n == 0) {
            try {
                fw = new FileWriter(file.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);
                bw.write(texttess+"<html><i>...</i><br/><ul><li><b><i> </i></b><ul><li><font color='#cc0000'><b>"+texttess2+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bw != null)
                        bw.close();
                    if (fw != null)
                        fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public void dictionaryFixToFile(String text1,String text2,ArrayList<Word> a) {
        File file = new File("C:/gibhub/filedictionary/E_V.txt");
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.write("");
            writer.close();
        } catch (Exception e) {
        }
        for (int i = 0; i < a.size(); i++) {
            Word swap = new Word();
            swap = a.get(i);
            if (swap.word_target.equals(text1)) {

                a.get(i).word_target = text1;
                a.get(i).word_plain = text2;
            }
            try {
                fw = new FileWriter(file.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);
                bw.write(a.get(i).word_target + a.get(i).word_plain + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bw != null)
                        bw.close();
                    if (fw != null)
                        fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}