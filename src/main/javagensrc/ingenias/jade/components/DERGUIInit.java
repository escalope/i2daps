

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

public  class DERGUIInit {


private static java.lang.String semaphore="DERGUI";
 


 private static Vector<DERGUIAppImp> appsinitialised=new Vector<DERGUIAppImp>();
 


 public static void initialize(DERGUIAppImp app){
  
 }

 public static void shutdown(DERGUIAppImp app){
  
 }

public static void shutdown(){
	synchronized (semaphore) {


  for (int k=0;k<appsinitialised.size();k++){
   shutdown(appsinitialised.elementAt(k));
  }

  }
}



 public static Vector<DERGUIAppImp>  getAppsInitialised(){
		return appsinitialised;
 }
  public static DERGUIApp createInstance(){
  	synchronized (semaphore) {
	DERGUIAppImp app=new DERGUIAppImp();
    initialize(app);
	appsinitialised.add(app);
	
   return app;
   }
  }
  public static DERGUIApp createInstance(JADEAgent owner){
  	synchronized (semaphore) {
	DERGUIAppImp app=new DERGUIAppImp();
	app.registerOwner(owner);
    initialize(app);
	appsinitialised.add(app);
	
   return app;
   }
  }


}

 