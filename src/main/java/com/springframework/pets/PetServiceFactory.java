package com.springframework.pets;

// this uses the Factory Method patttern
public class PetServiceFactory {

     /* I could have just cat and default
        but for completion I left in dog
      */
   public PetService getPetService(String petType){

        switch(petType){
            case "dog" :
                return new DogPetService();
            case "cat" :
                return new CatPetService();
            default :
                return new DogPetService();
        }
    }

}
