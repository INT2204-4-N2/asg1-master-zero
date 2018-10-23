package sample;

import com.darkprograms.speech.translator.GoogleTranslate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class Controller {
    @FXML
    private TextField text1= new TextField();
    @FXML
    private Button s1= new Button();
    @FXML
    private ListView list1= new ListView<>();// hiển thị gợi ý
    @FXML
     private  Button s2=new Button();
    @FXML
    private  TextField text2 = new TextField();
    @FXML
    private TextField text3 = new TextField();
    @FXML
    private Button s3 = new Button();
    @FXML
    private  String e = "";
    @FXML Button s4 = new Button();
    @FXML Button s5=new Button();
    private String V = "vi";
    private String E = "en";
    @FXML
    private WebView w1 = new WebView();// để hiển thị ra nghĩa
    @FXML
       public void search(ActionEvent event)
   {
       DictionaryComanline c= new DictionaryComanline();
       DictionaryManagement a=new DictionaryManagement();
       Dictionary b =  new Dictionary();
    a.insertFromFile(b);// nhập  dữ liệu
       WebEngine webEngine= w1.getEngine();//hiện ra web view
       webEngine.loadContent(a.dictionarylookup(b.getDictionarys(),text1.getText()));
   }
   public void API(ActionEvent event)
   {
       try{
    String a = GoogleTranslate.translate(E,V,text1.getText());
       WebEngine webEngine= w1.getEngine();//hiện ra web view
       webEngine.loadContent(a);
   }
   catch (Exception e){}}

   public void Find (KeyEvent event)
   {
       DictionaryComanline c= new DictionaryComanline();
       DictionaryManagement a=new DictionaryManagement();
       Dictionary b =  new Dictionary();
   a.insertFromFile(b);
       list1.getItems().setAll(c.dictionarySearch(b.getDictionarys(),text1.getText()));

   }

   public void click1 ()
   {
       text1.clear();
       list1.getItems().setAll(" ");
       WebEngine webEngine= w1.getEngine();//hiện ra web view
       webEngine.loadContent(" ");
   }

   public void Mouse(MouseEvent arg0)
   {
       DictionaryComanline c= new DictionaryComanline();
       DictionaryManagement a=new DictionaryManagement();
       Dictionary b =  new Dictionary();
      a.insertFromFile(b);
       e = list1.getSelectionModel().getSelectedItem().toString();
       text1.setText(e);
       WebEngine webEngine= w1.getEngine();
       webEngine.loadContent(a.dictionarylookup(b.getDictionarys(),text1.getText()));
   }
   public void delete(ActionEvent event)
   {
       DictionaryComanline c= new DictionaryComanline();
       DictionaryManagement a=new DictionaryManagement();
       Dictionary b =  new Dictionary();
       a.insertFromFile(b);
       a.dictionaryExportToFile(text2.getText(),b.getDictionarys());
       text2.clear();
   }
   public void add()
   {
       DictionaryComanline c= new DictionaryComanline();
       DictionaryManagement a=new DictionaryManagement();
       Dictionary b =  new Dictionary();
       a.insertFromFile(b);
       a.addfile(b.Dictionarys,text2.getText(),text3.getText());
       text2.clear();
       text3.clear();
   }
  public void Fix()
  {
      DictionaryComanline c= new DictionaryComanline();
      DictionaryManagement a=new DictionaryManagement();
      Dictionary b =  new Dictionary();
      a.insertFromFile(b);
      a.dictionaryFixToFile(text2.getText(),text3.getText(),b.getDictionarys());
     text2.clear();
     text3.clear();
  }
}
