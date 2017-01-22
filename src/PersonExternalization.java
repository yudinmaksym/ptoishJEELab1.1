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
public class PersonExternalization implements Externalizable {
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
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(firsname);
	out.writeObject(lastname);
        out.writeInt(age);
        out.writeObject(birthday);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        firsname = (String) in.readObject();
        lastname = (String) in.readObject();
	age = in.readInt();
        birthday = (String) in.readObject();
    }
    
}


class ExternExample {
   
    public static void main(String args[]) {

	
	PersonExternalization person = new PersonExternalization();
	PersonExternalization newPerson = null;
	
	
	try {
	    FileOutputStream fo = new FileOutputStream("personExternalization.ser");
	    ObjectOutputStream so = new ObjectOutputStream(fo);
	    so.writeObject(person);
	    so.flush();
	} catch (Exception e) {
	    System.out.println(e);
	    System.exit(1);
	}

	
	try {
	    FileInputStream fi = new FileInputStream("personExternalization.ser");
	    ObjectInputStream si = new ObjectInputStream(fi);  	    
	    newPerson = (PersonExternalization) si.readObject();
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