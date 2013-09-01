

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

public  class MicroGridVisualizerInit {


private static java.lang.String semaphore="MicroGridVisualizer";
 


 private static Vector<MicroGridVisualizerAppImp> appsinitialised=new Vector<MicroGridVisualizerAppImp>();
 


 public static void initialize(MicroGridVisualizerAppImp app){
  
 }

 public static void shutdown(MicroGridVisualizerAppImp app){
  
 }

public static void shutdown(){
	synchronized (semaphore) {


  for (int k=0;k<appsinitialised.size();k++){
   shutdown(appsinitialised.elementAt(k));
  }

  }
}



 public static Vector<MicroGridVisualizerAppImp>  getAppsInitialised(){
		return appsinitialised;
 }
  public static MicroGridVisualizerApp createInstance(){
  	synchronized (semaphore) {
	MicroGridVisualizerAppImp app=new MicroGridVisualizerAppImp();
    initialize(app);
	appsinitialised.add(app);
	
   return app;
   }
  }
  public static MicroGridVisualizerApp createInstance(JADEAgent owner){
  	synchronized (semaphore) {
	MicroGridVisualizerAppImp app=new MicroGridVisualizerAppImp();
	app.registerOwner(owner);
    initialize(app);
	appsinitialised.add(app);
	
   return app;
   }
  }


}

 