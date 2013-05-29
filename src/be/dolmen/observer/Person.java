package be.dolmen.observer;


public class Person {
    
    private String forename ;
    private String surname ;
    private int age ;
    
    public Person() {
        forename = "NONE" ;
        surname = "NONE" ;
        age = 0 ;
    } 
      
    public Person(String f, String s, int a) {
	forename = f;
	surname = s;
	age = a;
    }  

    public String getForename() {
        return forename ;
    } 
    
    public String getSurname() {
        return surname ;
    } 
    
    public int getAge() {
        return age ;
    } 
    
    public void setForename(String f) {
        forename = f ;
    } 
    
    public void setSurname(String s) {
        surname = s ;
    } 
    
    public void setAge(int a) {
        age = a ;
    } 
    
    public void increaseAge(int n) {
        age += n ;
    }     
}


