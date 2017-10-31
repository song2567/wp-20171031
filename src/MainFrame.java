import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame {
    LoginFrame login = new LoginFrame();
    private int scrW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int scrH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int w = 800;
    private int h = 600;
    private JMenuBar Jmb = new JMenuBar();
    private JMenu Jmu = new JMenu("File");
    private JInternalFrame JIFloto = new JInternalFrame("lotto");
    private JDesktopPane Jdp = new JDesktopPane();
    private JPanel JPnum = new JPanel(new GridLayout(2, 5, 3, 4));
    private JPanel JPre = new JPanel(new GridLayout(2, 4, 3, 5));
    private JButton JBclose = new JButton("close");
    private JButton JBre = new JButton("Re");
    private JLabel Jlab[] = new JLabel[6];
    private int JLableNum[] = new int[6];
    private Random rdm = new Random(System.currentTimeMillis());
    private JInternalFrame Jinkey = new JInternalFrame("Jinkey");
    private JInternalFrame Jinlotto = new JInternalFrame("222");
    private JMenuItem Jexit = new JMenuItem("JExit");
    private JMenuItem Jlotto = new JMenuItem("Jlotto");


    @Override
    public void printAll(Graphics g) {
        super.printAll(g);
    }

    public MainFrame(LoginFrame Login) {
        login = Login;
        init();
    }


    private void init() {
        this.setBounds(scrW / 2, scrH / 2 - h / 2, w, h);
        this.setJMenuBar(Jmb);
        this.setContentPane(Jdp);

JIFloto.setBounds(120,120,500,150);
        Jmb.add(Jmu);
        Jmu.add(Jexit);
        Jmu.add(Jlotto);
        JIFloto.setLayout(new BorderLayout(4, 4));
        JPre.add(JBclose);
        JPre.add(JBre);
        Jdp.add(JIFloto);
        Jdp.add(Jinkey);
        Jinkey.setLayout(new BorderLayout(4, 4));
        JIFloto.add(JPnum, BorderLayout.CENTER);
        JIFloto.add(JPre, BorderLayout.SOUTH);
        regenerate();


        for(int i =0;i<6;i++) {
            Jlab[i] = new JLabel();
            JPnum.add(Jlab[i]);
            Jlab[i].setText(Integer.toString(JLableNum[i]));
        }



        Jexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        Jexit.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));


    Jlotto.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JIFloto.setVisible(true);
        }
    });

}

private void regenerate() {
    boolean check;
    for (int i = 0; i < 6; i++) {
        check = true;
        while (check) {
            check = false;
            int tmp = rdm.nextInt(49) + 1;
            for (int j = 0; j < i; j++) {
                if (JLableNum[j] == tmp) {
                    check = true;
                }
            }
            JLableNum[i] = tmp;
        }
    }
}
}

