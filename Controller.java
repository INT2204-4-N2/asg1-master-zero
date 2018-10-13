package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
public class Controller {
    @FXML
    private TextField text1= new TextField();
    @FXML
    private Button s1= new Button();
    @FXML
    private ListView list1= new ListView<>();
    @FXML
     private  Button s2=new Button();
    @FXML
    private ListView list2 = new ListView();
    @FXML
    private Button s3 = new Button();
    @FXML
    private  String a = "";
       public void search(ActionEvent event)
   {
       DictionaryComanline c= new DictionaryComanline();
       DictionaryManagement a=new DictionaryManagement();
       Dictionary b =  new Dictionary();
       b.setDictionarys(a.insertFromfile());

      // list1.getItems().setAll(a.dictionarylookup(b.getDictionarys(),text1.getText()));
      // list1.getItems().setAll(c.dictionarySearch(b.getDictionarys(),text1.getText()));
      // text1.clear();
      // text1.appendText("house");
      // list1.getItems().setAll( c.dictionarySearch(text1.getText(),b.getDictionarys()));
       list2.getItems().setAll(a.dictionarylookup(b.getDictionarys(),text1.getText()));

   }
   public void Find (ActionEvent event)
   {
       DictionaryComanline c= new DictionaryComanline();
       DictionaryManagement a=new DictionaryManagement();
       Dictionary b =  new Dictionary();
       b.setDictionarys(a.insertFromfile());
       list1.getItems().setAll(c.dictionarySearch(b.getDictionarys(),text1.getText()));

   }

   public void click1 ()
   {
       text1.clear();
   }
   public void Mouse(MouseEvent arg0)
   {
      // a = output.getSelectionModel().getSelectedItem().toString();
       //input.setText(a);
   }

}
