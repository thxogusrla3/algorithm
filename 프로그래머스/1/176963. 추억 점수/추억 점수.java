import java.util.*;

class Person {
    private String name;
    private int yearPoint;

    public Person(String name, int yearPoint){
        this.name = name;
        this.yearPoint = yearPoint;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getYearPoint() {
        return this.yearPoint;
    }
}

class People {
    private List<Person> people;

    public People(String[] name, int[] yearning) {
        this.people = new ArrayList<>();
        for(int i = 0 ; i < name.length; i++) {
            Person person = new Person(name[i], yearning[i]);
            this.people.add(person);
        }
    }
    
    private Person findPerson(String name) {
        return this.people.stream()
            .filter(person -> person.getName().equals(name))
            .findFirst()
            .orElse(null);
    }
    
    public int getTotalPoint(String[] ph) {
        int total = 0;
        for(int i = 0 ; i < ph.length; i++) {
            Person person = findPerson(ph[i]);
            if(person != null) {
                total += person.getYearPoint();
            }
        }
        return total;
    }
    
}

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        People people = new People(name, yearning);
        
        for(int i = 0 ; i < photo.length; i++) {
            answer[i] = people.getTotalPoint(photo[i]);
        }
        
        return answer;
    }
}