package Pets;
public class PetSitter
{
	public static void main(String[] args) 
	{
		
	
		Dog fido = new Dog("Fido");
		System.out.println(fido + " says, \"" + fido.speak() + "\"");
		
		LoudDog rocko = new LoudDog("Rocko");
		System.out.println(rocko + " says, \"" + rocko.speak() + "\"");
		
		AngryDog spike = new AngryDog("Spike");
		System.out.println(spike + " says, \"" + spike.speak() + "\"");
	}

}