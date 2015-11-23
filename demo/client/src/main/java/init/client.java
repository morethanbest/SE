package init;

import javax.swing.JOptionPane;

import presentation.mainui.MainFrame;

/**
 * Created by Administrator on 2015/11/23.
 */
public class client {

    public static void main(String[] args) {
        try {
            RMIHelper.init();
           MainFrame frame= new MainFrame();
           frame.start();
        } catch (ClientInitException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Client boots fail!\nCause: " + e.getMessage(),
                    "Fatal Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }
}
