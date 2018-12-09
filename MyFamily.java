package myfamily;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Окно с тестированием ситуаций
 * @author Andy Jagello
 */
public class MyFamily extends JFrame{
    
    private Place place;
    
    private JButton bAllHome;
    private JButton bParentsWorkChildrenHome;
    private JButton bParentsWorkChildrenSchool;
    private JButton bAlert;
    private JButton bRecognize;
    private JButton bRandomPeople;
    private JButton bOk;

    private JPanel pControls;
    
    public MyFamily(){
        setTitle("Моя Семья");
        
        // test
        Perceptron perceptron = new Perceptron();
        
        place = new Place();
        
        bAllHome = new JButton("Все дома");
        bAllHome.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                java.util.List<Person> people = TestGenerator.getFamilyHome();
                place.setPeople(people);
                repaint();
            }
        });
        
        bParentsWorkChildrenHome = new JButton("Работа - дом");
        bParentsWorkChildrenHome.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                java.util.List<Person> people = TestGenerator.getParentsAtWorkChildrenHome();
                place.setPeople(people);
                repaint();                
            }
        });
        
        bParentsWorkChildrenSchool = new JButton("Работа - школа");
        bParentsWorkChildrenSchool.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                java.util.List<Person> people = TestGenerator.getParentsAtWorkChildrenAtSchool();
                place.setPeople(people);
                repaint();                
            }
        });
        
        bAlert = new JButton("Нештатная ситуация");
        bAlert.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                java.util.List<Person> people = TestGenerator.getChildLost();
                place.setPeople(people);
                repaint();                
            }
        });
        
        bRandomPeople = new JButton("Случайные люди");
        bRandomPeople.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                java.util.List<Person> people = TestGenerator.getRandomPeopleList(100);
                place.setPeople(people);
                repaint();                
            }
        });
        
        bRecognize = new JButton("Распознать");
        bRecognize.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                // Устанавливаем входы                
                perceptron.setEnters(place.getPerceptronMap());
                perceptron.propagate();
                double[] outers = perceptron.getOuters();
                System.out.println(""+outers[0]+" "+outers[1]+" "+outers[2]);
                int k = -1;
                int l = 0;
                for(int i=0; i<outers.length; i++)
                    if(outers[i]==1) l++;
                
                for(int i=0; i<outers.length; i++){
                    if(outers[i]==1){
                        k=i;
                        break;
                    }
                }
                
                if(l>1) k=-1;
                
                String s = null;
                switch(k){
                    case -1: s="Нештатная ситуация"; break;
                    case 0: s="Все дома"; break;
                    case 1: s="Дети дома, родители на работе"; break;
                    case 2: s="Дети в школе, родители на работе";
                }
                javax.swing.JOptionPane.showMessageDialog(null,s);
            }
        });
        
        bOk = new JButton("Ok");        
        bOk.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
                System.exit(0);
            }
        });
        
        pControls = new JPanel();
        pControls.add(bRecognize);
        pControls.add(bAllHome);
        pControls.add(bParentsWorkChildrenHome);
        pControls.add(bParentsWorkChildrenSchool);
        pControls.add(bAlert);
        pControls.add(bRandomPeople);
        pControls.add(bOk);
        
        
        
        
        setLayout(new java.awt.BorderLayout());
        
        add(place, java.awt.BorderLayout.CENTER);
        add(pControls, java.awt.BorderLayout.SOUTH);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024,768);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                MyFamily myFamily = new MyFamily();
            }
        });
        
    }
    
}
