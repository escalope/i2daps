

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

public  class SmartMeterInit {


private static java.lang.String semaphore="SmartMeter";
 


 private static Vector<SmartMeterAppImp> appsinitialised=new Vector<SmartMeterAppImp>();
 


 public static void initialize(SmartMeterAppImp app){
  
 }

 public static void shutdown(SmartMeterAppImp app){
  
 }

public static void shutdown(){
	synchronized (semaphore) {


  for (int k=0;k<appsinitialised.size();k++){
   shutdown(appsinitialised.elementAt(k));
  }

  }
}



 public static Vector<SmartMeterAppImp>  getAppsInitialised(){
		return appsinitialised;
 }
  public static SmartMeterApp createInstance(){
  	synchronized (semaphore) {
	SmartMeterAppImp app=new SmartMeterAppImp();
    initialize(app);
	appsinitialised.add(app);
	
   return app;
   }
  }
  public static SmartMeterApp createInstance(JADEAgent owner){
  	synchronized (semaphore) {
	SmartMeterAppImp app=new SmartMeterAppImp();
	app.registerOwner(owner);
    initialize(app);
	appsinitialised.add(app);
	
   return app;
   }
  }


}

 