import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends JFrame{
    private JLabel IDlabel = new JLabel("ID");
    private JLabel Passlable = new JLabel("Password");
    private JTextField IDtf = new JTextField();
    private JPasswordField Passtf = new JPasswordField();
    private JButton btnLogin = new JButton("Login");
    private JButton btnExit = new JButton("Exit");
    private Container cp ;
    private Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();

    public LoginFrame(){
        init();
    }
    private void init(){
        this.setBounds(100,100,1000,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(3,2,1,1));
        IDlabel.setHorizontalAlignment(JLabel.RIGHT);
        Passlable.setHorizontalAlignment(JLabel.RIGHT);
        cp.add(IDlabel);
        cp.add(IDtf);
        cp.add(Passlable);
        cp.add(Passtf);
        cp.add(btnLogin);
        cp.add(btnExit);
        btnExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnLogin.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (IDtf.getText().equals("K")){
                    if((new String(Passtf.getPassword())).equals("123")){
                        MainFrame lgf = new MainFrame(LoginFrame.this);
                        lgf.setVisible(true);
                        LoginFrame.this.setVisible(false);
                    }else{JOptionPane.showMessageDialog(null,"Password Error" );
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"ID Error");
                }
            }
        });
    }

}
