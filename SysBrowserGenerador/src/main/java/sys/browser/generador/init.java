package sys.browser.generador;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;

public class init {
 static String parametro = "";
//    static String parametro = "";
//    private final Preferences prefs = Preferences.userNodeForPackage(this.getClass());

    public static void main(String[] args) {
        
          for (int i = 0; i < args.length; i++) {
            parametro = parametro + " " + args[i];
        }

        Preferences prefs = Preferences.systemRoot();
        try {
            prefs.put("3fone", "3fone1");
            prefs.flush();
            prefs.sync();
            String phoneNumber = prefs.get("3fone", "3fone2");

             JOptionPane.showMessageDialog(null, phoneNumber, "preferences", JOptionPane.ERROR_MESSAGE);
             JOptionPane.showMessageDialog(null, parametro, "args", JOptionPane.ERROR_MESSAGE);
        } catch (BackingStoreException ex) {
            JOptionPane.showMessageDialog(null, ex, "00 - Error", JOptionPane.ERROR_MESSAGE);
        }

        for (String arg : args) {
            parametro = parametro + " " + arg;
        }

        if ("".equals(parametro)) {

        } else if (parametro.contains("syscmd:")) {
        }
    }

}
