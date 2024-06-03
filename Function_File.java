import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
    Notepad notepad;
    String fileName;
    String fileAddress;

    Function_File(Notepad notepad) {
        this.notepad = notepad;
    }

    public void New_File() {
        notepad.textArea.setText("");
        notepad.NotePad.setTitle("New");
        fileName=null;
        fileAddress = null;
    }

    public void open() {
        FileDialog fd = new FileDialog(notepad.NotePad, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            notepad.NotePad.setTitle(fileName);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            notepad.textArea.setText("");
            String line = null;
            while ((line = br.readLine()) != null) {
            notepad.textArea.append(line + "\n");
        }
        br.close();
    } catch( Exception e){
            System.out.println("File Note Open");
        }

    }
    public  void Save(){
        if(fileName==null)
        {
            SaveAs();
        }else {
            try {
                FileWriter fw = new FileWriter(fileAddress+fileName);
                fw.write(notepad.textArea.getText());
                notepad.NotePad.setTitle(fileName);
                fw.close();

            }catch (Exception e){
                System.out.println("Something Wrong ");

            }
        }

    }
     public void SaveAs(){
        FileDialog fd = new FileDialog(notepad.NotePad,"Save",FileDialog.SAVE);
        fd.setVisible(true);
          if(fd.getFile()!=null){
              fileName = fd.getFile();
              fileAddress = fd.getDirectory();
              notepad.NotePad.setTitle(fileName);
          }
          try {
              FileWriter fw = new FileWriter(fileAddress+fileName);
              fw.write(notepad.textArea.getText());
               fw.close();
          }catch (Exception e){
              System.out.println("Something Wrong ");

          }

     }
     public void Exit(){
        System.exit(0);
     }
}
