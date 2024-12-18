package utility;

import java.util.HashMap;
import javax.swing.JFrame;

public class BDUtility {
    private static HashMap<String, JFrame> formsMap = new HashMap<>();
    
    public static void openForm(String formName, JFrame formInstance){
        JFrame existingForm = formsMap.get(formName);
        if(existingForm == null || !existingForm.isVisible()){
            formsMap.put(formName, formInstance);
            formInstance.setVisible(true);
        }else{
            existingForm.toFront();
        }
    }
    
    public static String getPath(String finalPath){
        String projectPath = System.getProperty("user.dir");
        return projectPath+"\\src\\"+finalPath;
    }
    
    public static String getFileExtension(String fileName){
        int lastDotIndex = fileName.lastIndexOf(".");
        if(lastDotIndex != -1) return fileName.substring(lastDotIndex+1);
        return "";
    }
}
