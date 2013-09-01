

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

public  class DERSensorInit {


private static java.lang.String semaphore="DERSensor";
 


 private static Vector<DERSensorAppImp> appsinitialised=new Vector<DERSensorAppImp>();
 


 public static void initialize(DERSensorAppImp app){
  
 }

 public static void shutdown(DERSensorAppImp app){
  
 }

public static void shutdown(){
	synchronized (semaphore) {


  for (int k=0;k<appsinitialised.size();k++){
   shutdown(appsinitialised.elementAt(k));
  }

  }
}



 public static Vector<DERSensorAppImp>  getAppsInitialised(){
		return appsinitialised;
 }
  public static DERSensorApp createInstance(){
  	synchronized (semaphore) {
	DERSensorAppImp app=new DERSensorAppImp();
    initialize(app);
	appsinitialised.add(app);
	
   return app;
   }
  }
  public static DERSensorApp createInstance(JADEAgent owner){
  	synchronized (semaphore) {
	DERSensorAppImp app=new DERSensorAppImp();
	app.registerOwner(owner);
    initialize(app);
	appsinitialised.add(app);
	
   return app;
   }
  }


}

 