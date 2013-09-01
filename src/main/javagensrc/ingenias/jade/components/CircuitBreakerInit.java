

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

public  class CircuitBreakerInit {


private static java.lang.String semaphore="CircuitBreaker";
 


 private static Vector<CircuitBreakerAppImp> appsinitialised=new Vector<CircuitBreakerAppImp>();
 


 public static void initialize(CircuitBreakerAppImp app){
  
 }

 public static void shutdown(CircuitBreakerAppImp app){
  
 }

public static void shutdown(){
	synchronized (semaphore) {


  for (int k=0;k<appsinitialised.size();k++){
   shutdown(appsinitialised.elementAt(k));
  }

  }
}



 public static Vector<CircuitBreakerAppImp>  getAppsInitialised(){
		return appsinitialised;
 }
  public static CircuitBreakerApp createInstance(){
  	synchronized (semaphore) {
	CircuitBreakerAppImp app=new CircuitBreakerAppImp();
    initialize(app);
	appsinitialised.add(app);
	
   return app;
   }
  }
  public static CircuitBreakerApp createInstance(JADEAgent owner){
  	synchronized (semaphore) {
	CircuitBreakerAppImp app=new CircuitBreakerAppImp();
	app.registerOwner(owner);
    initialize(app);
	appsinitialised.add(app);
	
   return app;
   }
  }


}

 