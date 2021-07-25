import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;


import java.awt.*;
import java.awt.event.*;



/* //////////////////////////////////////////////////////////////////////////////////

                            MAIN (FIRST) FRAME CLASS
-------------------------------------------------------------------------------------
Buttons : 3

// ////////////////////////////////////////////////////////////////////////////////*/
class FirstFrame extends JFrame implements ActionListener
{
    private JButton buttonPack,buttonUnpack, buttonExit;
    private JTextField text1;
    private JLabel label;
    
    
    private void addButtons()
    {
        buttonPack = new JButton("Pack");
        buttonPack.setBounds(50,50,100,50);
        
        buttonUnpack = new JButton("Unpack");
        buttonUnpack.setBounds(250,50,100,50);
        
        
        
        buttonExit = new JButton("Exit");
        buttonExit.setBounds(300, 10, 90, 30);
        
        
        buttonPack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonUnpack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));



        add(buttonPack);
        add(buttonUnpack);
        add(buttonExit);

        buttonPack.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    new PackingFrame();
                    dispose();
                }
            }
        );

        buttonUnpack.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    new UnpackingFrame();
                    dispose();
                }
            }
        );

        buttonExit.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    dispose();
                    System.exit(0);
                }
            }
        );
    }

    private void addText()
    {
        text1 = new JTextField();
        text1.setBounds(30,100,767,65);
        add(text1);    
    }

	public FirstFrame() // Constructor
    {
		super("IP Packer Unpacker");
		
        setSize(400,200);
		setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButtons();
 
        setLayout(null);
		setVisible(true);
	}
    
    public void actionPerformed(ActionEvent e){}
}


/* //////////////////////////////////////////////////////////////////////////////////

                            PACKING FRAME CLASS
-------------------------------------------------------------------------------------
Buttons : 5

// ////////////////////////////////////////////////////////////////////////////////*/

class PackingFrame extends JFrame implements ActionListener
{
    private JButton buttonPack,buttonMain,buttonExit, buttonContToUnpack, buttonBackToPack;
    private JTextField tf1,tf2,tf3,tf4;
    private JLabel colon1,colon2,colon3,colon4,labelEnterIP, labelOutput;
    private ImageIcon homeIcon;
    //Basic Blank Frame with Basic Buttons
    private void BasicFrame()       
    {   
        getContentPane().removeAll();
        getContentPane().repaint();
        BasicButtons();
    }
    // Exit & Main Buttons
    private void BasicButtons()
    {
        homeIcon = new ImageIcon("img/home.png");
        Image img = homeIcon.getImage();
        img = img.getScaledInstance(30,30,  java.awt.Image.SCALE_SMOOTH);
        homeIcon = new ImageIcon(img);


        buttonMain = new JButton(homeIcon);
        buttonExit = new JButton("Exit");
        
        //Making button Transperant
        buttonMain.setOpaque(false);
        buttonMain.setContentAreaFilled(false);
        buttonMain.setBorderPainted(false);

        buttonMain.setBounds(20,10, 35, 35);
        buttonExit.setBounds(300, 10, 90, 30);

        buttonMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));



        add(buttonMain);
        add(buttonExit);

        buttonMain.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    new FirstFrame();
                    dispose();
                }
            }
        );

        buttonExit.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    dispose();
                    System.exit(0);
                }
            }
        );
    }

    // Function to add all buttons and their action Listeners
    private void addButtons()
    {
        buttonPack = new JButton("Pack");
        buttonPack.setBounds(125, 250, 150, 50);
        buttonPack.setFont(new Font(buttonPack.getFont().getName(),Font.BOLD,20));
        buttonPack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(buttonPack);
        BasicButtons();

        buttonPack.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(checkEmptyText())
                    {
                        IPPackUnpack obj = new IPPackUnpack();
                        int no1 = 0, no2 = 0, no3 = 0,no4 = 0;                    
                        no1 = Integer.parseInt(tf1.getText());
                        no2 = Integer.parseInt(tf2.getText());
                        no3 = Integer.parseInt(tf3.getText());
                        no4 = Integer.parseInt(tf4.getText());
                        int iRes = obj.Packing(no1, no2, no3, no4);
    
                        // label to show output IPPackUnpack.Packing() function
                        labelOutput = new JLabel("Packed Number is "+iRes, SwingConstants.CENTER);
                        
                        addPackedFrameContents();
                    }
                }
            }
        );
    }

    private boolean checkEmptyText()
    {
        if(tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty() || tf4.getText().isEmpty())
        {
            addWarning("Text is Empty !");
            return false;
        }
        else
        {
            return true;
        }
    }
    private void addWarning(String warning)
    {
        new Warning(warning);
    }

    // Function to Show contents After packing
    private  void addPackedFrameContents() 
    {
        labelOutput.setBounds(50,120,300,50);
        Border b  = BorderFactory.createLineBorder(Color.gray, 3);
        labelOutput.setBorder(b);

        buttonBackToPack = new JButton("Pack Again");
        buttonContToUnpack = new JButton("Continue to Unpack");

        buttonBackToPack.setBounds(40, 220, 150, 50);
        buttonContToUnpack.setBounds(210, 220,150, 50);

        buttonBackToPack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonContToUnpack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        BasicFrame();
        add(buttonBackToPack);
        add(buttonContToUnpack);
        add(labelOutput);


        buttonBackToPack.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    new PackingFrame();
                    dispose();
                }
            }
        );

        buttonContToUnpack.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    int packedNumber = Integer.parseInt(labelOutput.getText().trim().replace("Packed Number is ",""));
                    new UnpackingFrame(packedNumber);
                    dispose();
                }
            }
        );
    }



    // Function to add all JTextField
    private void addText()
    {
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();

        tf1.setBounds(55,150,65,40);
        tf2.setBounds(130,150,65,40);
        tf3.setBounds(205,150,65,40);
        tf4.setBounds(280,150,65,40);

        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
    }

    //Function to add all labels
    private void addLabel()
    {
        colon1 = new JLabel("<html><b> : <b></html>");
        colon2 = new JLabel("<html><b> : <b></html>");
        colon3 = new JLabel("<html><b> : <b></html>");
        labelEnterIP = new JLabel("Enter IP Address ");

        colon1.setBounds(120,145,50,50);
        colon2.setBounds(195,145,50,50);
        colon3.setBounds(270,145,50,50);
        labelEnterIP.setBounds(150,100,150,50);
        
        add(colon1);
        add(colon2);
        add(colon3);
        add(labelEnterIP);
    }

    // Constructor
    public PackingFrame()
    {
        super("Packer");
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addButtons();
        addLabel();
        addText();

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){}
}


/* //////////////////////////////////////////////////////////////////////////////////

                            UNPACKING FRAME CLASS
-------------------------------------------------------------------------------------
Buttons : 3

// ////////////////////////////////////////////////////////////////////////////////*/
class UnpackingFrame extends JFrame
{
    JButton buttonUnpackk, buttonMain, buttonExit;
    JTextField tField;
    JLabel labelno1, labelno2, labelno3, labelno4,labelPackedno;
    int unpackArr[];
    private ImageIcon homeIcon;

    private void addText(int iPackedNo)
    {
        String str = (" "+iPackedNo).trim();// Converting INT to String
        tField = new JTextField(str);
        tField.setBounds(50, 150, 300, 50);
        tField.setHorizontalAlignment(JTextField.CENTER);

        add(tField);
    }

    // Basic Buttons Main & Exit
    private void BasicButtons()
    {
        homeIcon = new ImageIcon("img/home.png");
        Image img = homeIcon.getImage();
        img = img.getScaledInstance(30,30,  java.awt.Image.SCALE_SMOOTH);
        homeIcon = new ImageIcon(img);

        buttonMain = new JButton(homeIcon);
        buttonExit = new JButton("Exit");

        //Making button Transperant
        buttonMain.setOpaque(false);
        buttonMain.setContentAreaFilled(false);
        buttonMain.setBorderPainted(false);

        buttonMain.setBounds(20,10, 35, 35);
        buttonExit.setBounds(300, 10, 90, 30);

        buttonMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        add(buttonMain);
        add(buttonExit);

        buttonMain.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    new FirstFrame();
                    dispose();
                }
            }
        );
        buttonExit.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    dispose();
                    System.exit(0);
                }
            }
        );
    }
    // Basic Blank Frame with Basic Buttons
    private void BasicFrame()       
        {   
            getContentPane().removeAll();
            getContentPane().repaint();
            BasicButtons();
        }
    private int parse()
    {
        if(tField.getText().trim().isEmpty())
        {
            addWarning("Text is Empty !");
            return -1;
        }
        else
        {
            int PackedNumber = Integer.parseInt(tField.getText().trim()); 
            return PackedNumber;
        }
        
    }

    private void addWarning(String warning)
    {
        new Warning(warning);
    }
    private void addButtons()
    {
        BasicButtons();
        buttonUnpackk = new JButton("UNPACK");
        buttonUnpackk.setBounds(100,220, 200, 70);
        buttonUnpackk.setFont(new Font((buttonUnpackk.getFont().getName()),Font.BOLD,30));
        buttonUnpackk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        add(buttonUnpackk);

        buttonUnpackk.addActionListener
        (
            new ActionListener()
            {
                
                public void actionPerformed(ActionEvent e)
                {
                    IPPackUnpack obj = new IPPackUnpack();
                    if(parse() != -1)
                    {
                        unpackArr = obj.Unpacking(parse());
                        BasicFrame();
                        LabelOutput();
                    }

                }
            }
        );
    }

    private void LabelOutput()
    {
        labelno1 = new JLabel((" "+unpackArr[0]).trim());
        labelno2 = new JLabel((" "+unpackArr[1]).trim());
        labelno3 = new JLabel((" "+unpackArr[2]).trim());
        labelno4 = new JLabel((" "+unpackArr[3]).trim());
        labelPackedno = new JLabel("UNPACKED NUMBERS");
        labelPackedno.setFont(new Font(labelPackedno.getFont().getName(), Font.BOLD,20));

        labelno1.setBounds(0,150,200,40);
        labelno2.setBounds(200,150,200,40);
        labelno3.setBounds(0,200,200,40);
        labelno4.setBounds(200,200,200,40);
        labelPackedno.setBounds(50, 50, 300, 60);

        labelno1.setHorizontalAlignment(SwingConstants.CENTER);
        labelno2.setHorizontalAlignment(SwingConstants.CENTER);
        labelno3.setHorizontalAlignment(SwingConstants.CENTER);
        labelno4.setHorizontalAlignment(SwingConstants.CENTER);
        labelPackedno.setHorizontalAlignment(SwingConstants.CENTER);

        add(labelno1);
        add(labelno2);
        add(labelno3);
        add(labelno4);
        add(labelPackedno);
    }

    
    // Default Constructor
    public UnpackingFrame() 
    {
        super("Unpacker");
        setResizable(false);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addText(0);
        addButtons();

        setLayout(null);
        setVisible(true);
    }
    // PARAMETERIZED CONSTRUCTOR
    public UnpackingFrame(int packedNumberGiven)
    {
        super("Unpacking");
        setResizable(false);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addText(packedNumberGiven);
        addButtons();

        setLayout(null);
        setVisible(true);
    }
}
/* //////////////////////////////////////////////////////////////////////////////////

                            WARNING CLASS

// ////////////////////////////////////////////////////////////////////////////////*/

class Warning extends JFrame
{
    private JLabel warningtext;
    private JButton okButton;

    private void addButtons()
    {
        okButton = new JButton("OK");
        okButton.setBounds(75,100,50,35);
        add(okButton);

        okButton.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    dispose();   
                }
            }
        );

    }

    private void addLabel(String warning)
    {
        warningtext = new JLabel(warning);
        warningtext.setForeground(Color.RED);
        warningtext.setBounds(50,25, 100,50);
        warningtext.setHorizontalAlignment(SwingConstants.CENTER);
        add(warningtext);
    }

    public Warning(String warning)
    {
        super("Warning");
        // setResizable(false);
        setSize(200,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addButtons();
        addLabel(warning);

        setLayout(null);
        setVisible(true);
    }

}

/* //////////////////////////////////////////////////////////////////////////////////

                            SOURCECODE CLASS

// ////////////////////////////////////////////////////////////////////////////////*/
class IPPackUnpack
{
	public int Packing(int no1, int no2, int no3, int no4)
	{
		return (no1<<24) | (no2<<16) | (no3<<8) | no4;
	}

    public int[] Unpacking(int no)
    {

        int arr[] = new int[4];
        arr[0] = no & 0x000000ff;
        arr[1] = no>>8;
        arr[1] = arr[1] & 0x000000ff;
        arr[2] = no>>16;
        arr[2] = arr[2] & 0x000000ff;
        arr[3] = no>>24;
        return arr;
    }
}


/* //////////////////////////////////////////////////////////////////////////////////

                            MAIN CLASS

///////////////////////////////////////////////////////////////////////////////////*/
class IPPackerUnpacker
{
    public static void main(String[] args)
    {
	    new FirstFrame();
	}
}


