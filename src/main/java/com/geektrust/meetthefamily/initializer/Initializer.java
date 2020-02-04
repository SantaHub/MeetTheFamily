package com.geektrust.meetthefamily.initializer;

import com.geektrust.meetthefamily.constant.Gender;
import com.geektrust.meetthefamily.model.Person;

public class Initializer {
	private static Person queen;
	
	public static Person getQueen() {
		if(queen == null) {
			Initialize();
		}
		return queen;
	}

	public static void Initialize() {
		queen = new Person("Queen Agna",Gender.FEMALE);
		Person king = new Person("King Shan",Gender.MALE);
		queen.setSpouse(king);
		setQueenChildren(queen);
	}
	
	public static void setQueenChildren(Person queen){
		Person Chit = new Person(queen,"Chit", Gender.MALE);
		setChitFamily(Chit);
		new Person(queen,"Ish", Gender.MALE);
		Person Vich = new Person(queen,"Vich", Gender.MALE);
		setVichFamily(Vich);
		Person Aras = new Person(queen,"Aras", Gender.MALE);
		setArasFamily(Aras);
		Person Satya = new Person(queen,"Satya", Gender.FEMALE);
		setSatyaFamily(Satya);
	}
	public static void setSatyaFamily(Person Satya) {
		Satya.setSpouse(new Person("Vyan", Gender.MALE));
		Person Vyas = new Person(Satya,"Vyas",Gender.MALE);
		setVyasFamily(Vyas);
		Person Asva = new Person(Satya,"Asva",Gender.MALE);
		setAsvaFamily(Asva);
		new Person(Satya, "Atya", Gender.FEMALE);
	}
	public static void setAsvaFamily(Person Asva) {
		Person Satvy = new Person("Satvy",Gender.FEMALE);
		Satvy.setSpouse(Asva);
		new Person(Satvy,"Vasa",Gender.MALE);
	}
	
	public static void setVyasFamily(Person Vyas) {
		Person Krpi = new Person("Krpi",Gender.FEMALE);
		Krpi.setSpouse(Vyas);
		new Person(Krpi,"Krithi",Gender.FEMALE);
		new Person(Krpi,"Kriya",Gender.MALE);
	}
	public static void setArasFamily(Person Aras) {
		Person Chitra = new Person("Chitra", Gender.FEMALE);
		Chitra.setSpouse(Aras);
		Person Jnki = new Person(Chitra, "Jnki", Gender.FEMALE);
		setJnkiFamily(Jnki);
		new Person(Chitra,"Ahit", Gender.MALE);
	}
	
	public static void setJnkiFamily(Person Jnki) {
		Person Arit =  new Person("Arit",Gender.MALE);
		Jnki.setSpouse(Arit);
		new Person(Jnki,"Laki", Gender.MALE);
		new Person(Jnki,"Lavnya", Gender.FEMALE);
	}
	public static void setVichFamily(Person Vich) {
		Person Lika = new Person("Lika", Gender.FEMALE);
		Lika.setSpouse(Vich);
		new Person(Lika,"Vila",Gender.FEMALE);
		new Person(Lika,"Chika",Gender.FEMALE);
	}
	public static void setChitFamily(Person Chit) {
		Person Amba = new Person("Amba", Gender.FEMALE);
		Amba.setSpouse(Chit);
		Person Dritha = new Person(Amba,"Dritha", Gender.FEMALE);
		setDrithaFamily(Dritha);
		new Person(Amba,"Tritha", Gender.FEMALE);
		new Person(Amba,"Vritha", Gender.MALE);
	}
	
	public static void setDrithaFamily(Person Dritha) {
		Dritha.setSpouse(new Person("Jaya", Gender.MALE));
		Dritha.addChild(new Person("Yodhan", Gender.MALE));
	}
	
	
}
