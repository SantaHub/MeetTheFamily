package com.geektrust.meetthefamily.initializer;

import com.geektrust.meetthefamily.FamilyTreeHandler.Person;
import com.geektrust.meetthefamily.queryhandler.GenderType;

public class Initializer {
	private static Person queen;
	
	public static Person getQueen() {
		if(queen == null) {
			Initialize();
		}
		return queen;
	}

	public static void Initialize() {
		queen = new Person("Queen Agna",GenderType.FEMALE);
		Person king = new Person("King Shan",GenderType.MALE);
		queen.setSpouse(king);
		setQueenChildren(queen);
	}
	
	public static void setQueenChildren(Person queen){
		Person Chit = new Person(queen,"Chit", GenderType.MALE);
		setChitFamily(Chit);
		new Person(queen,"Ish", GenderType.MALE);
		Person Vich = new Person(queen,"Vich", GenderType.MALE);
		setVichFamily(Vich);
		Person Aras = new Person(queen,"Aras", GenderType.MALE);
		setArasFamily(Aras);
		Person Satya = new Person(queen,"Satya", GenderType.FEMALE);
		setSatyaFamily(Satya);
	}
	public static void setSatyaFamily(Person Satya) {
		Satya.setSpouse(new Person("Vyan", GenderType.MALE));
		Person Vyas = new Person(Satya,"Vyas",GenderType.MALE);
		setVyasFamily(Vyas);
		Person Asva = new Person(Satya,"Asva",GenderType.MALE);
		setAsvaFamily(Asva);
		new Person(Satya, "Atya", GenderType.FEMALE);
	}
	public static void setAsvaFamily(Person Asva) {
		Person Satvy = new Person("Satvy",GenderType.FEMALE);
		Satvy.setSpouse(Asva);
		new Person(Satvy,"Vasa",GenderType.MALE);
	}
	
	public static void setVyasFamily(Person Vyas) {
		Person Krpi = new Person("Krpi",GenderType.FEMALE);
		Krpi.setSpouse(Vyas);
		new Person(Krpi,"Krithi",GenderType.FEMALE);
		new Person(Krpi,"Kriya",GenderType.MALE);
	}
	public static void setArasFamily(Person Aras) {
		Person Chitra = new Person("Chitra", GenderType.FEMALE);
		Chitra.setSpouse(Aras);
		Person Jnki = new Person(Chitra, "Jnki", GenderType.FEMALE);
		setJnkiFamily(Jnki);
		new Person(Chitra,"Ahit", GenderType.MALE);
	}
	
	public static void setJnkiFamily(Person Jnki) {
		Person Arit =  new Person("Arit",GenderType.MALE);
		Jnki.setSpouse(Arit);
		new Person(Jnki,"Laki", GenderType.MALE);
		new Person(Jnki,"Lavnya", GenderType.FEMALE);
	}
	public static void setVichFamily(Person Vich) {
		Person Lika = new Person("Lika", GenderType.FEMALE);
		Lika.setSpouse(Vich);
		new Person(Lika,"Vila",GenderType.FEMALE);
		new Person(Lika,"Chika",GenderType.FEMALE);
	}
	public static void setChitFamily(Person Chit) {
		Person Amba = new Person("Amba", GenderType.FEMALE);
		Amba.setSpouse(Chit);
		Person Dritha = new Person(Amba,"Dritha", GenderType.FEMALE);
		setDrithaFamily(Dritha);
		new Person(Amba,"Tritha", GenderType.FEMALE);
		new Person(Amba,"Vritha", GenderType.MALE);
	}
	
	public static void setDrithaFamily(Person Dritha) {
		Dritha.setSpouse(new Person("Jaya", GenderType.MALE));
		Dritha.addChild(new Person("Yodhan", GenderType.MALE));
	}
	
	
}
