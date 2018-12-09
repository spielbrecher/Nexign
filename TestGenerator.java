/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfamily;

/**
 * Класс генерирует экземпляры Person, т.е. людей для тестирования и обучения сети
 * @author Andy Jagello
 */
public class TestGenerator {
    
    // Случайный набор безымянных людей со случайными координатами в количестве number
    public static java.util.List<Person> getRandomPeopleList(int number){
        java.util.List<Person> people = new java.util.ArrayList<Person>();        
        java.util.Random r = new java.util.Random();
        for(int i=0; i<number; i++){
            Person person = new Person();
            person.setId(i);
            person.addPointToTrack(new java.awt.Point(r.nextInt(1000),r.nextInt(700)));
            people.add(person);
        }
        return people;
    }
    
    // Митинг
    public static java.util.List<Person> getMeeting(int number){
        java.util.List<Person> people = new java.util.ArrayList<Person>();        
        java.util.Random r = new java.util.Random();
        for(int i=0; i<number; i++){
            Person person = new Person();
            person.setId(i);
            person.addPointToTrack(new java.awt.Point(r.nextInt(1000),r.nextInt(700)));
            people.add(person);
        }
        return people;
    }
    
    
    // Семья дома
    public static java.util.List<Person> getFamilyHome(){
        java.util.List<Person> people = new java.util.ArrayList<Person>(); 
        
        // Случайные координаты в пределах дома (100,100 - 200,200)
        java.util.Random r = new java.util.Random();

        // parent Mary
        Person mary = new Person();
        mary.setName("Mary");
        mary.setId(1111);
        mary.addPointToTrack(new java.awt.Point(r.nextInt(100)+100, r.nextInt(100)+100));
        
        // parent Ivan
        Person ivan = new Person();
        ivan.setName("Ivan");
        ivan.setId(2222);
        ivan.addPointToTrack(new java.awt.Point(r.nextInt(100)+100, r.nextInt(100)+100));
        
        // child Vera
        Person vera = new Person();
        vera.setName("Vera");
        vera.setId(3333);
        vera.addPointToTrack(new java.awt.Point(r.nextInt(100)+100, r.nextInt(100)+100));
        
        // child Dima
        Person dima = new Person();
        dima.setName("Dima");
        dima.setId(4444);
        dima.addPointToTrack(new java.awt.Point(r.nextInt(100)+100, r.nextInt(100)+100));
        
        people.add(mary);
        people.add(ivan);
        people.add(vera);
        people.add(dima);
        return people;
    }
    
    // Родители на работе, дети дома
    public static java.util.List<Person> getParentsAtWorkChildrenHome(){
        java.util.List<Person> people = new java.util.ArrayList<Person>(); 
        // Случайные координаты в пределах дома (100,100 - 200,200)
        // В пределах работы Mary (400,300 - 500,400)
        // В пределах работы Ivan (300,300 - 400,400)
        java.util.Random r = new java.util.Random();

        // parent Mary
        Person mary = new Person();
        mary.setName("Mary");
        mary.setId(1111);
        mary.addPointToTrack(new java.awt.Point(r.nextInt(100)+400, r.nextInt(100)+300));
        
        // parent Ivan
        Person ivan = new Person();
        ivan.setName("Ivan");
        ivan.setId(2222);
        ivan.addPointToTrack(new java.awt.Point(r.nextInt(100)+200, r.nextInt(100)+300));
        
        // child Vera
        Person vera = new Person();
        vera.setName("Vera");
        vera.setId(3333);
        vera.addPointToTrack(new java.awt.Point(r.nextInt(100)+100, r.nextInt(100)+100));
        
        // child Dima
        Person dima = new Person();
        dima.setName("Dima");
        dima.setId(4444);
        dima.addPointToTrack(new java.awt.Point(r.nextInt(100)+100, r.nextInt(100)+100));
        
        people.add(mary);
        people.add(ivan);
        people.add(vera);
        people.add(dima);
        
        return people;
    }
    
    // Родители на работе, дети в школе
    public static java.util.List<Person> getParentsAtWorkChildrenAtSchool(){
        java.util.List<Person> people = new java.util.ArrayList<Person>(); 
        // Случайные координаты в пределах школы (700,200 - 800,300)
        // В пределах работы Mary (400,300 - 500,400)
        // В пределах работы Ivan (200,300 - 300,400)
        java.util.Random r = new java.util.Random();

        // parent Mary
        Person mary = new Person();
        mary.setName("Mary");
        mary.setId(1111);
        mary.addPointToTrack(new java.awt.Point(r.nextInt(100)+400, r.nextInt(100)+300));
        
        // parent Ivan
        Person ivan = new Person();
        ivan.setName("Ivan");
        ivan.setId(2222);
        ivan.addPointToTrack(new java.awt.Point(r.nextInt(100)+200, r.nextInt(100)+300));
        
        // child Vera
        Person vera = new Person();
        vera.setName("Vera");
        vera.setId(3333);
        vera.addPointToTrack(new java.awt.Point(r.nextInt(100)+700, r.nextInt(100)+200));
        
        // child Dima
        Person dima = new Person();
        dima.setName("Dima");
        dima.setId(4444);
        dima.addPointToTrack(new java.awt.Point(r.nextInt(100)+700, r.nextInt(100)+200));
        
        people.add(mary);
        people.add(ivan);
        people.add(vera);
        people.add(dima);
        
        return people;
    }
    
    // Ребенок потерялся
    public static java.util.List<Person> getChildLost(){
        java.util.List<Person> people = new java.util.ArrayList<Person>(); 
         // Случайные координаты в пределах дома (700,200 - 800,300)
        // В пределах работы Mary (400,300 - 500,400)
        // В пределах работы Ivan (200,300 - 300,400)
        java.util.Random r = new java.util.Random();

        // parent Mary
        Person mary = new Person();
        mary.setName("Mary");
        mary.setId(1111);
        mary.addPointToTrack(new java.awt.Point(r.nextInt(100)+400, r.nextInt(100)+300));
        
        // parent Ivan
        Person ivan = new Person();
        ivan.setName("Ivan");
        ivan.setId(2222);
        ivan.addPointToTrack(new java.awt.Point(r.nextInt(100)+200, r.nextInt(100)+300));
        
        // child Vera lost
        Person vera = new Person();
        vera.setName("Vera");
        vera.setId(3333);
        vera.addPointToTrack(new java.awt.Point(r.nextInt(995)+5, r.nextInt(695)+5));
        
        // child Dima
        Person dima = new Person();
        dima.setName("Dima");
        dima.setId(4444);
        dima.addPointToTrack(new java.awt.Point(r.nextInt(100)+700, r.nextInt(100)+200));
        
        people.add(mary);
        people.add(ivan);
        people.add(vera);
        people.add(dima);
        
        return people;
    }
    
    
    
    
}
