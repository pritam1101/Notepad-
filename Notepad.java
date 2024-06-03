import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import javax.swing.JTextArea;
        import javax.swing.JMenuBar;
//import javax.swing.JMenu;
public class Notepad implements ActionListener {
    JFrame NotePad;
    JTextArea textArea;
    JMenuBar menuBar;
    JMenu menuFile,menuEdit,menuView;
    JMenuItem iNew,iNewWindow,iOpen,iSave,iSaveAs,iPageSetup,iPrint,iExit;
    Function_File file = new Function_File(this);
    public Notepad() {

        create_Window();
        create_TextArea();
        create_Menubar();
        create_FileMenu();
        NotePad.setVisible(true);

    }

    public void create_Window() {
        NotePad = new JFrame("PSNotepad+");
        NotePad.setSize(800,  700);
        NotePad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void create_TextArea(){
        textArea = new JTextArea();
        NotePad.add(textArea);
    }
    public void create_Menubar(){

        menuBar = new JMenuBar();
        NotePad.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuView = new JMenu("View");
        menuBar.add(menuView);

    }
    public void create_FileMenu(){
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

      //  iNewWindow = new JMenuItem("New Window");
       // menuFile.add(iNewWindow);


        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");
        menuFile.add(iSaveAs);

       // iPageSetup = new JMenuItem("Page Setup");
       // menuFile.add(iPageSetup);

      //  iPrint = new JMenuItem("Print");
      //  menuFile.add(iPrint);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        switch (command){
            case "New": file.New_File(); break;
            case "Open":file.open(); break;
            case "SaveAs":file.SaveAs();break;
            case "Save":file.Save();break;
            case "Exit":file.Exit();break;
            
        }
    }
    public static void main(String[] args) {
        new Notepad();

    }
}