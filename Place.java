package myfamily;

import javax.swing.JPanel;

/**
 * Класс отображает карту, на которой действуют члены семьи
 * @author Andy Jagello
 */
public class Place extends JPanel{
    
    private java.util.List<Person> people;
    
    public Place(){
        people = new java.util.ArrayList<Person>();
    }
    
    public Place(java.util.List<Person> people){
        this.people = new java.util.ArrayList<Person>();
        this.people.addAll(people);
        for(Person p:this.people)
            System.out.println(p.getName());
        repaint();
    }
    
    public void setPeople(java.util.List<Person> people){
        this.people=people;
        repaint();
    }
    
    public void addPerson(Person person){
        people.add(person);
    }
    
    public void clearPeople(){
        people.clear();
    }
    
    // Вернуть карту для перцептрона, т.е. с членами семьи в квадратах
    public double[] getPerceptronMap(){
        double[] result = new double[70];
        for(int i=0; i<result.length; i++)
            result[i]=0;
        int n=0;
        for(Person p:people){
            if(p.getName()!=null){
                System.out.println("Член семьи");
                // Есть имя, значит член семьи
                java.awt.Point point = p.getCurrentPoint();
                int x = (int) point.x/100;
                int y = (int) point.y/100;
                n = x + y*10;
                System.out.println(n);
                result[n]++;
            }
        }
        return result;
    }
    
    public void paint(java.awt.Graphics g){
        for(Person person:people){
            // Перебираем всех людей и размещаем на карте кружочками с именами
            java.awt.Point point = person.getCurrentPoint();
            g.drawOval(point.x, point.y, 5, 5);
            if(person.getName()!=null)
                g.drawString(person.getName(), point.x+10, point.y+7); 
        }
    }
}
