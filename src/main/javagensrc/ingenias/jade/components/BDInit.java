

/**
 *
 *
 *  Description of the task /
 *
 * 
 *@author     Jorge J. Gomez
 *@version    1.0
 */

package ingenias.jade.components;

import java.util.*;
import ingenias.jade.exception.*;
import ingenias.jade.JADEAgent;

public  class BDInit {

 private static BDAppImp instance = null;


private static java.lang.String semaphore="BD";
 

 


 public static void initialize(BDAppImp app){
  
 }

 public static void shutdown(BDAppImp app){
  
 }

public static void shutdown(){
	synchronized (semaphore) {

   if (instance!=null){
	shutdown(instance);
   }


  }
}




  public static BDApp getInstance(){
  	synchronized (semaphore) {
   if (instance==null){
	instance=new BDAppImp();
    initialize(instance);
   }
   
   return instance;
   }
  }
    public static BDApp getInstance(JADEAgent owner){
    	synchronized (semaphore) {
   if (instance==null){
	instance=new BDAppImp();	
    initialize(instance);
   } 
	instance.registerMultipleOwners(owner);
	
   return instance;
   }
  }

}

 