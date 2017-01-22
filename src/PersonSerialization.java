/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author админ
 */
public class PersonSerialization implements Serializable {
        String firsname = "Maksym";
        String lastname = "Yudin" ;
        int age = 23;
        String birthday = "15.06.1993";
    
        public String getFirstname() {
		return this.firsname;
	}

	public String getLastname() {
		return this.lastname;
	}
        public int getAge() {
		return this.age;
	}

	public String getBirthday() {
		return this.birthday;
	}
}
class SerializeExemaple {

   public static void main(String [] args) {
      PersonSerialization person = new PersonSerialization();
      PersonSerialization newPerson = null;
      
      try {
         FileOutputStream fileOut =
         new FileOutputStream("person.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(person);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in person.ser");
      }catch(Exception e) {
        System.out.println(e);
	System.exit(1);
      }
      try {
	    FileInputStream fi = new FileInputStream("person.ser");
	    ObjectInputStream si = new ObjectInputStream(fi);  	    
	    newPerson = (PersonSerialization) si.readObject();
            fi.close();
            si.close();
	}
	catch (Exception e) {
	    System.out.println(e);
	    System.exit(1);
	}
        System.out.println("Read person: ");
        System.out.println(newPerson);
        System.out.println(newPerson.firsname);
        System.out.println(newPerson.lastname);
        System.out.println(newPerson.age);
        System.out.println(newPerson.birthday);
   }
}
