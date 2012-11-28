//*******************************************************************
//  MagazineView.java
//  Author:    Lewis/Loftus Modified: C. Conner
//  Course:    CS111B
//  Assignment: K8
//  Date:      Dec 09, 2006
//  Driver to exercise the MagazineList collection.
//*******************************************************************

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class MagazineView extends Applet
{
  private Label addMagazine, deleteMagazine;
  private TextField add, delete;
  private TextArea show;
  private Button list, deleteAll;
  private String text;
  private MagazineList rack = new MagazineList();

  //----------------------------------------------------------------
  //  Creates a MagazineList object, adds several magazines to the
  //  list, then shows it in TextArea.
  //----------------------------------------------------------------
  public void init()
  {
      addMagazine = new Label("Add Magazine:");
      deleteMagazine = new Label("Delete Magazine:");

      add = new TextField(20);
      add.addActionListener(new AddListener());
      delete = new TextField(20);
      delete.addActionListener(new DeleteListener());

      show = new TextArea(20,50);

      list = new Button("List Magazines");
      list.addActionListener(new ListListener());
      deleteAll = new Button("Delete All");
      deleteAll.addActionListener(new DeleteAllListener());

      add(addMagazine);
      add(add);
      add(list);
      add(show);
      add(deleteMagazine);
      add(delete);
      add(deleteAll);

      setBackground(Color.white);
      setSize(400, 400);
  }

  //----------------------------------------------------------------
  //  Adds magazine that you type in the "Add Magazine" text field
  //  to the list.
  //----------------------------------------------------------------
  private class AddListener implements ActionListener
  {
      public void actionPerformed(ActionEvent event)
      {
        text = add.getText();
        add.setText("");

//        rack.insert(new Magazine(text));
      }
  }

  //----------------------------------------------------------------
  //  Deletes individual magazine that you type in the "Delete Magazine"
  //  text field from the list, and shows the error message if cannot
  //  find the magazine.
  //----------------------------------------------------------------
  private class DeleteListener implements ActionListener
  {
      public void actionPerformed(ActionEvent event)
      {
        
            text = delete.getText();
            delete.setText("");

  //          rack.delete(new Magazine(text));
        
      }
  }

  //----------------------------------------------------------------
  //  Refresh the list when click the "List Magazines" button.
  //----------------------------------------------------------------
  private class ListListener implements ActionListener
  {
      public void actionPerformed(ActionEvent event)
      {
        show.setText(rack.toString());
      }
  }

  //----------------------------------------------------------------
  //  Calls method to delete all the list when clicks the "Delete All"
  //  button and catch the error if list is already null.
  //----------------------------------------------------------------
  private class DeleteAllListener implements ActionListener
  {
      public void actionPerformed(ActionEvent event)
      {
        
          rack.deleteAll();
          show.setText(rack.toString());
        
      }
  }
}
 